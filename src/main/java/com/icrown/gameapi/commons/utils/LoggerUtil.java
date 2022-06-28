package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.configs.LogTypeData;
import com.icrown.gameapi.commons.configs.ProjectTypeData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Roger
 */
@Component
public class LoggerUtil {

    private static final Logger wegLogger = LogManager.getLogger("WebLog");
    private static final Logger commonLogger = LogManager.getLogger("CommonLog");

    private Logger getWebLogger() {
        return wegLogger;
    }

    private Logger getCommonLogger() {
        return commonLogger;
    }

    public void logWeb(LogTypeData logTypeData, ProjectTypeData projectTypeData, Object message, Throwable stack) {
        var logger = getWebLogger();
        log(logger, logTypeData, projectTypeData, message, stack);
    }

    public void logWeb(LogTypeData logTypeData, ProjectTypeData projectTypeData, Object message) {
        var logger = getWebLogger();
        log(logger, logTypeData, projectTypeData, message, null);
    }

    public void logCommon(LogTypeData logTypeData, ProjectTypeData projectTypeData, Object message, Throwable stack) {
        var logger = getCommonLogger();
        log(logger, logTypeData, projectTypeData, message, stack);
    }

    public void logCommon(LogTypeData logTypeData, ProjectTypeData projectTypeData, Object message) {
        var logger = getCommonLogger();
        log(logger, logTypeData, projectTypeData, message, null);
    }

    public void logFile(String type, String fileName, String content) throws IOException {
        File newDir = new File("/usr/local/logs/" + type);
        if (!newDir.exists()) {
            newDir.mkdir();
        }
        Path path = Paths.get("/usr/local/logs/" + type + "/" + fileName);
        byte[] strToBytes = content.getBytes();
        Files.write(path, strToBytes);
    }

    private void log(Logger logger, LogTypeData logTypeData, ProjectTypeData projectTypeData, Object message, Throwable stack) {
        String projectName = projectTypeData.getProjectName();
        String fullMessage = projectName + "-" + message;
        switch (logTypeData) {
            case ERROR:
                logger.error(fullMessage, stack);
                break;
            case WARN:
                logger.warn(fullMessage, stack);
                break;
            case DEBUG:
                logger.debug(fullMessage, stack);
                break;
            case INFO:
                logger.info(fullMessage, stack);
                break;
        }
    }
}
