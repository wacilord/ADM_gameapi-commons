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
    public void ts() {

//        redisUtil.rename("cache_all_game_type_zh-CN","cache_all_game_type_zh-CN__");
//        redisUtil.rename("getallenablegamelist","getallenablegamelist__");
//        redisUtil.rename("getallenablegamelistbylanguage_zh_CN","getallenablegamelistbylanguage_zh_CN__");

        System.out.println("cache_all_game_type:");
        System.out.println(redisUtil.get("cache_all_game_type"));

        System.out.println("cache_all_game_type_zh-CN:");
        System.out.println(redisUtil.get("cache_all_game_type_zh_CN"));
        redisUtil.delete("cache_all_game_type_zh_CN");

        System.out.println("ts");
        System.out.println(redisUtil.get("getallenablegamelist"));

        System.out.println("ts1");
        System.out.println(redisUtil.get("getallenablegamelistbylanguage_zh_CN"));
        redisUtil.delete("getallenablegamelistbylanguage_zh_CN");

        assertEquals(1, 1);
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
