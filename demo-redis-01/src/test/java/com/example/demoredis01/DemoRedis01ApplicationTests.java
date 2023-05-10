package com.example.demoredis01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class DemoRedis01ApplicationTests {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        System.out.println("redisTemplate = " + redisTemplate);
        redisTemplate.opsForValue().set("test001:flag","wangwangwang");

    }

    /*@Test
    public void testMultiThread(){
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                if (redisTemplate.opsForValue().getOperations().hasKey("task_id")){
                    Object task_id = redisTemplate.opsForValue().get("task_id");
                    System.out.println("task_id = " + task_id);
                } else {
                    System.out.println(" ===================================== " );
                    redisTemplate.opsForValue().set("task_id", UUID.randomUUID().toString());
                }

            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
    @Test
    public void testSubPub(){
        redisTemplate.convertAndSend("runoobChat","hello world from springboot");
    }

}
