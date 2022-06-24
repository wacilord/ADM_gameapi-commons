package com.icrown.gameapi.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icrown.gameapi.commons.configs.LogTypeData;
import com.icrown.gameapi.commons.configs.ProjectTypeData;
import com.icrown.gameapi.commons.responses.Response;
import com.ip2location.IPResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

@SpringBootTest(classes = JsonUtilTest.class)
@ComponentScan(basePackages = "com.icrown")
@EnableAutoConfiguration
public class JsonUtilTest {

    @Autowired
    private JsonUtil jsonUtil;

    @Autowired
    private LoggerUtil loggerUtil;

    @Test
    public void putKey() throws JsonProcessingException {
        loggerUtil.logWeb(LogTypeData.INFO, ProjectTypeData.GAMEAPI_COMMONS,"testroger");
        Response r = new Response();

        System.out.println(jsonUtil.generate(r));
    }

    @Autowired
    private IP2LocationUtil ip2LocationUtil;

    //@Test
    public void test() throws JsonProcessingException {
        String ip = "1.1.1.1";
//        Optional<IPResult> ipResult = ip2LocationUtil.getIPLocationResult(ip);
//
//        System.out.println(ipResult.get().getCity());
    }





}
