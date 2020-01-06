package org.ainy.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author 阿拉丁省油的灯
 * @Date 2019-06-12 23:00
 * @Description 消费者
 */
@Slf4j
@Component
public class ConsumerY {

    public void receiveMessage(String message) {

        log.info("Messages received <" + message + ">");
    }
}
