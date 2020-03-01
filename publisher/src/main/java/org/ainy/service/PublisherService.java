package org.ainy.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 阿拉丁省油的灯
 * @date 2019-06-12 22:39
 * @description 消息队列发布者服务
 */
@Slf4j
@Service
public class PublisherService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void sendMessage(Object o) {

        try {
            redisTemplate.convertAndSend("MY_TOPIC", JSON.toJSONString(o));
            log.info("Message sent successfully");
        } catch (Exception e) {
            log.error("Message Failure");
            log.error(e.getMessage());
        }
    }
}
