package cn.qian.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2020/6/23 14:18
 */
public class TestSoftReference1 {

    public static void main(String[] args) {
        List<byte[]> bytes= new ArrayList<>();
        TestSoftReference1 test = new TestSoftReference1();
        for (int i = 0; i < 6; i++) {
            System.out.println("执行第"+(i+1)+"次");
            test.testSoft(bytes);
        }
    }

    void testSoft(List list) {
        //分配1M大小的内存给数组对象
        byte[] buffer = new byte[1024 * 1024 * 1];
        list.add(buffer);
    }
}
