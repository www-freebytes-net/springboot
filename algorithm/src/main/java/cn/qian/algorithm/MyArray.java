package cn.qian.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 千里明月 on 2019/1/14.
 */

public class MyArray {
    //定义一个数组
    private int[] intArray;
    //定义数组的实际有效长度
    private AtomicInteger validateLength = new AtomicInteger(0);
    //定义数组的最大长度
    private int length;

    //默认构造一个长度为50的数组
    public MyArray() {
        this.intArray = new int[50];
        this.length = 50;
    }

    //构造函数，初始化一个长度为length 的数组
    public MyArray(int length) {
        this.intArray = new int[length];
        this.length = length;
    }

    //获取数组的有效长度
    public int getValidateLength() {
        return validateLength.get();
    }

    //遍历显示元素
    public void displayArray() {
        for (int i = 0; i < validateLength.get(); i++) {
            System.out.println(intArray[i]);
        }
    }

    /**
     * 添加元素
     *
     * @param value,假设操作人是不会添加重复元素的，如果有重复元素对于后面的操作都会有影响。
     * @return添加成功返回true,添加的元素超过范围了返回false
     */
    public boolean add(int value) {
        if (validateLength.get() == length) {
            return false;
        }
        intArray[validateLength.get()] = value;
        validateLength.incrementAndGet();
        return true;
    }


    /**
     * 根据下标获取元素
     *
     * @param i
     * @return查找下标值在数组下标有效范围内，返回下标所表示的元素 查找下标超出数组下标有效值，提示访问下标越界
     */
    public int getForValue(int i) {
        if (i - 1 > length) {
            throw new IndexOutOfBoundsException();
        }
        return intArray[i];
    }

    /**
     * 查找元素
     *
     * @param searchValue
     * @return查找的元素如果存在则返回下标值，如果不存在，返回 -1
     */
    public int getForIndex(int searchValue) {
        for (int i = 0; i < validateLength.get(); i++) {
            if (searchValue == intArray[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除元素
     *
     * @param value
     * @return如果要删除的值不存在，直接返回 false;否则返回true，删除成功
     */
    public boolean delete(int value) {
        int index = getForIndex(value);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < validateLength.get(); i++) {
            intArray[index] = intArray[++index];
        }
        validateLength.decrementAndGet();
        return true;
    }

    /**
     * 修改数据
     *
     * @param oldValue
     * @param newValue
     * @return修改成功返回true，修改失败返回false
     */
    public boolean update(int oldValue, int newValue) {
        int index = getForIndex(oldValue);
        if (index == -1) {
            return false;
        }
        intArray[index] = newValue;
        return true;
    }


    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.add(6);
        myArray.displayArray();
        int forIndex = myArray.getForIndex(3);
        System.out.println(forIndex);
        int forValue = myArray.getForValue(5);
        System.out.println(forValue);
         myArray.delete(2);
         myArray.delete(4);
         myArray.displayArray();

    }
}
