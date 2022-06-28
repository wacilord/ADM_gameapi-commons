package com.icrown.gameapi.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ip2location.IPResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

//@SpringBootTest(classes = IP2locationUtilTest.class)
//@ComponentScan(basePackages = "com.icrown.gameapi")
//@EnableAutoConfiguration
public class IP2locationUtilTest {

    @Autowired
    private IP2LocationUtil ip2LocationUtil;

    //@Test
    public void test() throws JsonProcessingException {
        String ip = "2001:b400:e40e:82e3:689a:26d5:4f4d:fd06";
        Optional<IPResult> ipResult = ip2LocationUtil.getIPLocationResult(ip);

        System.out.println(ipResult.get());
    }





}
