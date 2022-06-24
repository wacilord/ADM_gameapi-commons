package com.icrown.gameapi.commons.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Cliff
 */
@Component
public class RtpUtil {

    public BigDecimal calculateRtp(BigDecimal win, BigDecimal bets) {
        return win.divide(bets, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
    }

    public BigDecimal calculateRtpWithoutJackpot(BigDecimal win, BigDecimal bets, BigDecimal jackpot) {
        return win.subtract(jackpot).divide(bets, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
    }
}
