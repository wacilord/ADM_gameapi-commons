package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.responses.ResponseCode;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author Adi
 */
@Component
public class Md5Util {

    public String generate(String srcString) {
        try {
            return DigestUtils.md5DigestAsHex(srcString.getBytes());
        } catch (Exception e) {
            throw new APIException(ResponseCode.SYSTEM_ERROR, "MD5 encryption exception");
        }
    }
}



