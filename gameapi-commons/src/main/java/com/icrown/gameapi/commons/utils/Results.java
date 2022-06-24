package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.responses.Response;
import com.icrown.gameapi.commons.responses.ResponseCode;
import io.netty.util.internal.StringUtil;

public class Results {

    private Results()
    {
    }

    public static Response success() {

        Response result = new Response();
        result.setStatusCode(200);
        result.setData(StringUtil.EMPTY_STRING);
        return result;
    }

    public static Response success(Object data) {
        
        Response result = new Response();
        result.setStatusCode(200);
        result.setData(data);
        return result;
    }

    public static Response error(ResponseCode code) {

        Response result = new Response();
        result.setStatusCode(code.getStatusCode());
        result.setErrorMessage(code.getErrorMessage());
        return result;        
    }

    public static Response error(ResponseCode code, String message) {

        Response result = new Response();
        result.setStatusCode(code.getStatusCode());
        result.setErrorMessage(message);
        return result;         
    }
}
