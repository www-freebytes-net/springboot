package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/14.
 * 冒泡排序
 * 冒泡算法的运作规律如下：
 * <p>
 * 　　①、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * <p>
 * 　　②、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数（也就是第一波冒泡完成）。
 * <p>
 * 　　③、针对所有的元素重复以上的步骤，除了最后一个。
 * <p>
 * 　　④、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {
    public static int[] sort(int[] array) {
        int end = array.length - 1;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < end; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            end--;
        }
        return array;
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 4, 87};
        int[] sort = sort(array);
        display(sort);
    }
}
