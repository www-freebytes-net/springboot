package cn.qian.jvm;

/**
 * @date: 2020/6/23 14:18
 */
public class TestStrongReference2 {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            byte[] buffer = new byte[1024 * 1024 * 1];
        }
    }
}

