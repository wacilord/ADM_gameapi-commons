package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.configs.LogTypeData;
import com.icrown.gameapi.commons.configs.ProjectTypeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@Component
public class GzipUtil {

    @Autowired
    LoggerUtil loggerUtil;

    public String gzipUnCompressToString(byte[] byteArray) {
        StringWriter writer = new StringWriter();
        try (GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(byteArray));
             BufferedReader reader = new BufferedReader(new InputStreamReader(gzip));) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        } catch (IOException e) {
            loggerUtil.logCommon(LogTypeData.ERROR, ProjectTypeData.GAMEAPI_COMMONS, "gzip uncompress to String error", e);
            return null;
        }
        return writer.toString();
    }

    public byte[] gzipUnCompress(byte[] byteArray) {
        byte[] result = new byte[]{};
        try (ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();
             GZIPInputStream gzipIS = new GZIPInputStream(bis)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipIS.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            result = bos.toByteArray();
        } catch (IOException e) {
            loggerUtil.logCommon(LogTypeData.ERROR, ProjectTypeData.GAMEAPI_COMMONS, "gzip uncompress error", e);
            return null;
        }
        return result;
    }

    private byte[] gzipCompress(byte[] byteArray) {
        byte[] result = new byte[]{};
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(byteArray.length);
             GZIPOutputStream gzipOS = new GZIPOutputStream(bos)) {
            gzipOS.write(byteArray);
            gzipOS.close();
            result = bos.toByteArray();
        } catch (IOException e) {
            loggerUtil.logCommon(LogTypeData.ERROR, ProjectTypeData.GAMEAPI_COMMONS, "gzip compress error", e);
            return null;
        }
        return result;
    }

}
