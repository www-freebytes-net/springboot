package cn.qian.jvm;

/**
 * @date: 2020/6/23 14:18
 */
public class TestStrongReference3 {
    public static void main(String[] args) {
        TestStrongReference3 reference = new TestStrongReference3();
        reference.test1();
        reference.test2();
        reference.test3();
        reference.test4();
        reference.test5();
        reference.test6();
    }
    void test1(){
        byte[] bytes = new byte[1024 * 1024 * 1];
    }
    void test2(){
        byte[] bytes = new byte[1024 * 1024 * 1];
    }
    void test3(){
        byte[] bytes = new byte[1024 * 1024 * 1];
    }
    void test4(){
        byte[] bytes = new byte[1024 * 1024 * 1];
    }
    void test5(){
        byte[] bytes = new byte[1024 * 1024 * 1];
    }
    void test6(){
        byte[] bytes = new byte[1024 * 1024 * 1];
    }
}

