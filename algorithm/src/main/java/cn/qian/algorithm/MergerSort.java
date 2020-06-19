package cn.qian.algorithm;

import java.util.Arrays;

/**
 * Created by 千里明月 on 2019/1/23.
 * 归并算法的中心是归并两个已经有序的数组。归并两个有序数组A和B，
 * 就生成了第三个有序数组C。数组C包含数组A和B的所有数据项。
 */
public class MergerSort {
    private static int[] a={1,2,3,4,5};
    private static int[] b={4,66,77,88,99,100};
     static int[] target={1,3,5,7,2,4,6,8};
     static int[] temp=new int[target.length];


    public static void main(String[] args) {
//        int[] sort = sort(a, b);
//        for (int i = 0; i < sort.length; i++) {
//            System.out.println(sort[i]);
//        }
        sort(target,0,target.length-1);
        System.out.println(Arrays.toString(temp));

    }

    private static int[] sort(int[] a,int[] b){
        int[] c=new int[a.length+b.length];
        int minLength=a.length<=b.length?a.length:b.length;
        int cnum=0,anum=0,bnum=0;
        while (minLength>=0){
            if (a[anum]<=b[bnum]){
                c[cnum++]=a[anum++];
            }else {
                c[cnum++]=b[bnum++];
            }
            minLength--;
        }
        for (int i = anum; i <a.length ; i++) {
            c[cnum++]=a[i];
        }
        for (int i = bnum; i <   b.length; i++) {
            c[cnum++]=b[i];
        }
        return c;
    }

    private static void sort(int [] array,int left,int right){
        if (left<right){
            int mid=(left+right)/2;
            //排序数组(左边数组排序)
            sort(array,left,mid);
            //重置数组排序(对应的右边数组排序)
            sort(array,mid+1,right);
            //归并左右数组
            merge(array, left, right,mid,temp);
        }
    }

    private static void merge(int[] array, int left, int right,int mid,int[] temp) {
        //此处把数组切两份来看待

        int leftIndex=left;//左边数组的起始索引
        int rightIndex=mid+1;//右边数组的起始索引
        int tempIndex=left;//temp的其实索引

        while (leftIndex<=mid&&rightIndex<=right){
            if (array[leftIndex]<=array[rightIndex]){
                temp[tempIndex++]=array[leftIndex++];
            }else {
                temp[tempIndex++]=array[rightIndex++];
            }
        }
        for (int i = leftIndex; i <  mid+1; i++) {
            temp[tempIndex++]=array[leftIndex];
        }
        for (int i = rightIndex; i < right+1; i++) {
            temp[tempIndex++]=array[rightIndex];
        }
    }


}

