package cn.qian.bootactive;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by 千里明月 on 2019/1/10.
 */
@Service
public class Consumer {

    @JmsListener(destination = "srp")
    public void receiveMsg(String msg) {
        System.out.println("------------消费信息------------");
        System.out.println(msg);
        System.out.println("------------消费信息------------");
    }
}
