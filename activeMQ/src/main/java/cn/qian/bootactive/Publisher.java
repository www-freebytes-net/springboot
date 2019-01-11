package cn.qian.bootactive;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by 千里明月 on 2019/1/10.
 */
@Service
public class Publisher {
    private MessageEntity message;

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage() {
        System.out.println("---------------发布信息-------------");
        //信息发送给正在订阅的订阅者，订阅者只能订阅到实时的信息，无法获取过时的信息
        Destination destination = new ActiveMQTopic(message.getDestination());
        jmsMessagingTemplate.convertAndSend(destination, message.getContent());
    }
}
