package com.icrown.gameapi.commons.configs;

/**
 * @author Cliff
 * 彩金類別
 */
public enum JackpotTypeData {
    NONE(0, "无"),
    INGAME_JACKPOT(1, "天九福彩"),
    JACKPOT_POOL(2, "天九福彩"),
    JACKPOT_RED_ENVELOPE(3, "天九红包");


    private int jackpotType;
    private String jackpotTypeKey;

    private JackpotTypeData(int jackpotType, String jackpotTypeKey) {
        this.jackpotType = jackpotType;
        this.jackpotTypeKey = jackpotTypeKey;
    }

    public String jackpotTypeKey() {
        return this.jackpotTypeKey;
    }

    public static JackpotTypeData getEnumByValue(int value) {
        switch (value) {
            case 0:
                return JackpotTypeData.NONE;
            case 1:
                return JackpotTypeData.INGAME_JACKPOT;
            case 2:
                return JackpotTypeData.JACKPOT_POOL;
            case 3:
                return JackpotTypeData.JACKPOT_RED_ENVELOPE;
            default:
                return null;
        }
    }

    public int getJackpotType() {
        return jackpotType;
    }

    public String getJackpotTypeKey() {
        return jackpotTypeKey;
    }
}
