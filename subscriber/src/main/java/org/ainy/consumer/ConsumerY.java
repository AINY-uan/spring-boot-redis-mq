package org.ainy.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 阿拉丁省油的灯
 * @date 2019-06-12 23:00
 * @description 消费者
 */
@Slf4j
@Component
public class ConsumerY {

    public void receiveMessage(String message) {

        log.info("Messages received <" + message + ">");
    }
}
