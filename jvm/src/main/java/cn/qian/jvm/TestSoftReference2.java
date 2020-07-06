package cn.qian.jvm;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2020/6/23 14:18
 */
public class TestSoftReference2 {

    public static void main(String[] args) {
        List<SoftReference> list = new ArrayList<>();
        TestSoftReference2 test = new TestSoftReference2();
        for (int i = 0; i < 6; i++) {
            System.out.println("执行第"+(i+1)+"次");
            test.testSoft(list);
        }
        for (SoftReference reference : list) {
            System.out.println(reference.get());
        }
    }

    void testSoft(List list) {
        //分配1M大小的内存给数组对象
        byte[] buffer = new byte[1024 * 1024 * 1];
        SoftReference sr = new SoftReference<byte[]>(buffer);
        list.add(sr);
    }
}
