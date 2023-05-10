package com.example.demoredis01.config;

import com.example.demoredis01.receiver.MessageHandler;
import com.example.demoredis01.receiver.Receiver;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @className: RedisSubPubConfig
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2023/5/8
 */
@Configuration
public class RedisSubPubConfig {
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory, MessageHandler messageHandler){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        //List<Topic> topics = new ArrayList<>();
        container.setConnectionFactory(redisConnectionFactory);
        //new PatternTopic()
        ChannelTopic runoobChat = new ChannelTopic("runoobChat");
        //订阅了一个channel
        container.addMessageListener(messageHandler,runoobChat);
        //container.addMessageListener(adapter1,runoobChat);
        Jackson2JsonRedisSerializer seria = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        seria.setObjectMapper(objectMapper);
        container.setTopicSerializer(seria);
        return container;
    }

    @Bean(name = "adapter")
    public MessageListenerAdapter adapter(Receiver receiver){
        return new MessageListenerAdapter(receiver,"receiveMsg");
    }
    @Bean(name = "adapter1")
    public MessageListenerAdapter adapter1(MessageHandler messageHandler){
        return new MessageListenerAdapter(messageHandler,"onMessage");
    }
}
