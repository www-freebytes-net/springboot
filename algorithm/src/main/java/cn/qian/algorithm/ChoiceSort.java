package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/14.
 */
public class ChoiceSort {
    public static void main(String[] args) {
        int[] ints = {65, 5, 2, 434, 1, 7, 3, 89, 1};
        int[] sort = sort(ints);
        display(sort);
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static int[] sort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            if (minIndex != i) {
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
