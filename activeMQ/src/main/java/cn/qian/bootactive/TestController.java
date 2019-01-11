package cn.qian.bootactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 千里明月 on 2019/1/10.
 */
@RestController
public class TestController {

    @Autowired
    private Producer producer;
    @Autowired
    private Publisher publisher;
    /**
     * 点对点模式的信息生产与消费
     */
    @GetMapping("/produce")
    public void produce() {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent("生产消息");
        messageEntity.setDestination("srp");
        producer.setMessage(messageEntity);
        producer.sendMessage();
    }

    /**
     * 发布/订阅模式的信息生产与消费
     */
    @GetMapping("/publish")
    public void publish(){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent("发布消息");
        messageEntity.setDestination("srp.topic");
        publisher.setMessage(messageEntity);
        publisher.sendMessage();
    }
}
