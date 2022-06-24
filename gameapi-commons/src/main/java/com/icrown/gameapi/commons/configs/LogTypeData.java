package com.icrown.gameapi.commons.configs;

import com.icrown.gameapi.commons.responses.ResponseCode;
import com.icrown.gameapi.commons.utils.APIException;

/**
 * Log 種類
 * @author Frank
 */
public enum LogTypeData {
    ERROR(1),
    WARN(2),
    DEBUG(3),
    INFO(4);
    private int logType;
    private LogTypeData(int logType) {
        this.logType = logType;
    }
    public static LogTypeData getByLogType(int logType) {
        for(LogTypeData e : values()) {
            if(e.logType == logType)
            {
                return e;
            }
        }
        throw new APIException(ResponseCode.SYSTEM_ERROR);
    }
}
