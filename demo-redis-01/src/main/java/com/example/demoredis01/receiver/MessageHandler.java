package com.example.demoredis01.receiver;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @className: MessageHandler
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2023/5/6
 */
@Component("messageHandler")
public class MessageHandler implements MessageListener {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取消息
        byte[] messageBody = message.getBody();
        // 使用值序列化器转换
        Object msg = redisTemplate.getValueSerializer().deserialize(messageBody);
        // 获取监听的频道
        byte[] channelByte = message.getChannel();
        // 使用字符串序列化器转换
        Object channel = redisTemplate.getStringSerializer().deserialize(channelByte);
        // 渠道名称转换
        String patternStr = new String(pattern);
        System.out.println(patternStr);
        System.out.println("---频道---: " + channel);
        System.out.println("---消息内容---: " + msg);

    }
}
