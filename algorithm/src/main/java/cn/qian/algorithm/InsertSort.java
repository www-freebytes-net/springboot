package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/14.
 */

/**
 * 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = {65, 5, 2, 434, 1, 7, 3, 89, 1};
        int[] sort = sort(ints);
        display(sort);
    }

    private static int[] sort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j;
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }

        return array;
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
