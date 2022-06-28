package com.icrown.gameapi.commons.configs;

/**
 * 遊戲設定
 */
public enum GameSettingData {

    SLOT_GAME(0, "slot_bet"),
    FISHING_GAME(1, "fish"),
    CARD_GAME(2, "card"),
    MINI_GAME(3, "mini"),
    ROOM_GAME(4, "room");
    //TODO 新的遊戲類別

    private int gameType;
    private String gameTypeKey;

    private GameSettingData(int gameType, String gameTypeKey) {
        this.gameType = gameType;
        this.gameTypeKey = gameTypeKey;
    }

    public String gameTypeKey() {
        return this.gameTypeKey;
    }

    public static GameSettingData getEnumByValue(int value) {
        switch (value) {
            case 1:
                return GameSettingData.SLOT_GAME;
            case 2:
                return GameSettingData.FISHING_GAME;
            case 3:
                return GameSettingData.CARD_GAME;
            case 4:
                return GameSettingData.MINI_GAME;
            case 5:
                return GameSettingData.ROOM_GAME;
            //TODO 新的遊戲類別
            default:
                return null;
        }
    }

    public int getGameType() {
        return gameType;
    }

    public String getGameTypeKey() {
        return gameTypeKey;
    }
}


