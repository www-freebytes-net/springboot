package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/22.
 * 　注意：二分查找的数组一定是有序的！！！
 　　在有序数组array[]中，不断将数组的中间值（mid）和被查找的值比较，
 如果被查找的值等于array[mid],就返回下标mid; 否则，就将查找范围缩小一半。
 如果被查找的值小于array[mid], 就继续在左半边查找;如果被查找的值大于array[mid],
 就继续在右半边查找。 直到查找到该值或者查找范围为空时， 查找结束。
 */
public class BinaryChop {
    public static void main(String[] args) {
        BinaryChop binaryChop = new BinaryChop();
        int[] array={1,4,6,8,9,12,434,1234};
        int key=1234;
        binaryChop.search(array,key);
    }

    /**
     * 当我们求解某些问题时，由于这些问题要处理的数据相当多，或求解过程相当复杂，
     * 使得直接求解法在时间上相当长，或者根本无法直接求出。对于这类问题，我们往
     * 往先把它分解成几个子问题，找到求出这几个子问题的解法后，再找到合适的方法，
     * 把它们组合成求整个问题的解法。如果这些子问题还较大，难以解决，可以再把它
     * 们分成几个更小的子问题，以此类推，直至可以直接求出解为止。这就是分治策略
     * 的基本思想。上面讲的递归的二分查找法就是一个分治算法的典型例子，分治算法
     * 常常是一个方法，在这个方法中含有两个对自身的递归调用，分别对应于问题的两
     * 个部分。二分查找中，将查找范围分成比查找值大的一部分和比查找值小的一部分，
     * 每次递归调用只会有一个部分执行。
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int search(int[] array,int key,int low,int high){
        int mid = (high-low)/2+low;
        if(key == array[mid]){//查找值等于当前值，返回数组下标
            return mid;
        }else if(low > high){//找不到查找值，返回-1
            return -1;
        }else{
            if(key < array[mid]){//查找值比当前值小
                return search(array,key,low,mid-1);
            }
            if(key > array[mid]){//查找值比当前值大
                return search(array,key,mid+1,high);
            }
        }
        return -1;
    }

    public void search(int[] array, int key){
        int start=0;
        int end=array.length-1;
        int ser = ser(array, key, start, end);
        System.out.println(ser);
    }

    private int ser(int[] array, int key, int start , int end){
        if (start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if (key==array[mid]){
            return mid;
        }
        if (key<array[mid]){
            end=mid-1;
        }else {
            start=mid+1;
        }
        return ser(array,key,start,end);
    }


}
