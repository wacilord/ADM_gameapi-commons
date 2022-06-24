package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.configs.LogTypeData;
import com.icrown.gameapi.commons.configs.ProjectTypeData;
import com.ip2location.IP2Location;
import com.ip2location.IPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class IP2LocationUtil {

    public static final String NO_COUNTRY_RESULT = "-";
    private static final String IP_V4_PATTERN = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String IP_V6_PATTERN = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$|^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$";
    private IP2Location loc = null;
    private IPResult unknown;
    private Pattern validIPV4Pattern;
    private Pattern validIPV6Pattern;

    @Autowired
    private LoggerUtil loggerUtil;

    @Autowired
    public IP2LocationUtil() {
        try {
            loc = new IP2Location();
            loc.IPDatabasePath = ResourceUtils.getFile("classpath:IP-COUNTRY-REGION-CITY-ISP.BIN").getPath();
            loc.IPLicensePath = ResourceUtils.getFile("classpath:license.key").getPath();
            loc.UseMemoryMappedFile = true;
            unknown = loc.IPQuery("127.0.0.1");
            validIPV4Pattern = Pattern.compile(IP_V4_PATTERN);
            validIPV6Pattern = Pattern.compile(IP_V6_PATTERN);
        } catch (Exception ex) {
            loc = null;
        }
    }

    public IPResult getUnknownIPResult() {
        return unknown;
    }

    /**
     * Get Country Code By New IP2Location
     *
     * @param ip
     * @return
     */
    public String getCountry(String ip) {
        try {
            if (!isIPAddress(ip)) {
                return NO_COUNTRY_RESULT;
            }
            IPResult result = loc.IPQuery(ip);
            if (NO_COUNTRY_RESULT.equals(result.getCountryShort())) {
                return NO_COUNTRY_RESULT;
            }

            return result.getCountryShort();
        } catch (Exception ex) {
            loggerUtil.logCommon(LogTypeData.ERROR, ProjectTypeData.GAMEAPI_COMMONS, "getCountry error ip=" + ip);
        }

        return NO_COUNTRY_RESULT;
    }

    /**
     * Get IPResult
     *
     * @param ip
     * @return
     */
    public Optional<IPResult> getIPLocationResult(String ip) {
        try {
            if (!isIPAddress(ip)) {
                return Optional.of(unknown);
            }
            return Optional.of(loc.IPQuery(ip));
        } catch (Exception ex) {
            loggerUtil.logCommon(LogTypeData.ERROR, ProjectTypeData.GAMEAPI_COMMONS, "getIPLocationResult error ip=" + ip);
        }
        return Optional.of(unknown);
    }

    public boolean isIPAddress(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        }
        if (validIPV4Pattern.matcher(ip).matches()) {
            return true;
        }
        return validIPV6Pattern.matcher(ip).matches();
    }
}
