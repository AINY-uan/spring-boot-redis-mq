package org.ainy.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 阿拉丁省油的灯
 * @date 2019-06-12 22:47
 * @description 消费消息队列
 */
@Slf4j
@Component
public class ConsumerX implements MessageListener {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {

        RedisSerializer<String> valueSerializer = redisTemplate.getStringSerializer();
        String deserialize = valueSerializer.deserialize(message.getBody());
        log.info("Messages received <" + deserialize + " >");
    }
}
