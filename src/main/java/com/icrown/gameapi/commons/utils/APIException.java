package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.responses.Response;
import com.icrown.gameapi.commons.responses.ResponseCode;

/**
 * @author David
 */
public class APIException extends RuntimeException {

    private static final long serialVersionUID = 20191009001L;

    private Response response;

    public APIException(ResponseCode code) {
        super();
        response = Results.error(code);
    }

    public APIException(ResponseCode code, String message) {
        super(message);
        response = Results.error(code, message);
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public String getMessage() {
        return response.getErrorMessage();
    }

}
