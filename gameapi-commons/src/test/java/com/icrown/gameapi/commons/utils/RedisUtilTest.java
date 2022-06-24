package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.configs.LogTypeData;
import com.icrown.gameapi.commons.configs.ProjectTypeData;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RedisUtilTest.class)
@ComponentScan(basePackages = "com.icrown.gameapi")
@EnableAutoConfiguration
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private LoggerUtil loggerUtil;

    private String key = "testroger";
    private String value = "test";
    private long expireTime = 60000;

    @Test
    public void putKey() {
        loggerUtil.logWeb(LogTypeData.DEBUG, ProjectTypeData.GAMEAPI_COMMONS,"putKey test");
        redisUtil.setEx(key, value, expireTime, TimeUnit.MILLISECONDS);
        Object ret = redisUtil.get(key);

        assertEquals(value, ret);
    }

    @Test
    public void removeKey() {
        loggerUtil.logWeb(LogTypeData.DEBUG, ProjectTypeData.GAMEAPI_COMMONS,"removeKey test");
        redisUtil.setEx(key, value, expireTime, TimeUnit.MILLISECONDS);
        redisUtil.delete(key);
        Object ret = redisUtil.get(key);

        assertNull(ret);
    }

    @Test
    public void expireTime() {
        loggerUtil.logWeb(LogTypeData.DEBUG, ProjectTypeData.GAMEAPI_COMMONS,"..........................  expireTime test ...................");
        redisUtil.setEx(key, value, expireTime, TimeUnit.MILLISECONDS);
        long retExpireTime = redisUtil.getExpire(key);

        assertTrue(retExpireTime < expireTime);
    }

    @Test
    public void hasKey() {
        System.out.println(redisUtil.hasKey("testrogermap"));
    }

    @Test
    public void hMap() {
        String key = "testrogermap";
        Map<String, String> data = Map.of("guid1", "test1", "guid2", "test2");
        redisUtil.hPutAll(key, data);
    }

    @Test
    public void hSetKey() {
        String key = "testrogermap";
        Set<String> keys = redisUtil.hKeys(key);
        keys.stream().forEach(k -> System.out.println(k));
    }



}
