package com.example.demoredis01.receiver;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @className: Receiver
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2023/5/6
 */
@Component
public class Receiver  {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    public void receiveMsg(String msg){
        System.out.println("msg = " + msg);
    }

    /*@Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("message.getBody() = " + s);
    }*/
}
