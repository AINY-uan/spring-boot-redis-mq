package org.ainy.config;

import org.ainy.consumer.ConsumerX;
import org.ainy.consumer.ConsumerY;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author 阿拉丁省油的灯
 * @date 2019-06-12 22:39
 * @description 消息订阅者配置类
 */
@Configuration
@AutoConfigureAfter({ConsumerX.class, ConsumerY.class})
public class SubscriberConfig {

    /**
     * 消息监听适配器，注入接收消息方法
     *
     * @param consumerX 消费者
     * @return 消息监听适配器
     */
    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(ConsumerX consumerX) {
        //当没有继承MessageListener时需要写方法名字
        return new MessageListenerAdapter(consumerX);
    }


//    @Bean
//    public MessageListenerAdapter getMessageListenerAdapter(ConsumerY consumerY){
//        return new MessageListenerAdapter(consumerY, "receiveMessage"); //当没有继承MessageListener时需要写方法名字
//    }

    /**
     * 创建消息监听容器
     *
     * @param redisConnectionFactory redis连接工厂
     * @param messageListenerAdapter 消息监听适配器
     * @return 消息监听容器
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
                                                                          MessageListenerAdapter messageListenerAdapter) {

        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("MY_TOPIC"));
        return redisMessageListenerContainer;
    }
}
