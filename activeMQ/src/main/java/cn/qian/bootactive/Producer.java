package cn.qian.bootactive;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by 千里明月 on 2019/1/10.
 */
@Service
public class Producer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    private MessageEntity message;

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    public void sendMessage() {
        System.out.println("---------------生产信息-------------");
        //信息会持久存在，一直等到被消费者消费
        Destination destination = new ActiveMQQueue(message.getDestination());
        jmsMessagingTemplate.convertAndSend(destination, message.getContent());
    }
}
