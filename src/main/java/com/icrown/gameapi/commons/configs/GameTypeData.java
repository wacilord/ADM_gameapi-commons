package com.icrown.gameapi.commons.configs;

/**
 * 遊戲類別
 */
public enum GameTypeData {
    ALL_GAME(0, "AllGame"),
    SLOT_GAME(1, "SlotGame"),
    FISHING_GAME(2, "FishingGame"),
    CARD_GAME(3, "CardGame"),
    MINI_GAME(4, "MiniGame"),
    ROOM_GAME(5, "RoomGame");
    //TODO 新的遊戲類別
    private int gameType;
    private String gameTypeName;

    private GameTypeData(int gameType, String gameTypeName) {
        this.gameType = gameType;
        this.gameTypeName = gameTypeName;
    }

    public int getGameTypeValue() {
        return this.gameType;
    }

    public String getGameTypeName() {
        return this.gameTypeName;
    }

    public static GameTypeData getEnumByValue(int value) {
        switch (value) {
            case 0:
                return GameTypeData.ALL_GAME;
            case 1:
                return GameTypeData.SLOT_GAME;
            case 2:
                return GameTypeData.FISHING_GAME;
            case 3:
                return GameTypeData.CARD_GAME;
            case 4:
                return GameTypeData.MINI_GAME;
            case 5:
                return GameTypeData.ROOM_GAME;
            //TODO 新的遊戲類別
            default:
                return GameTypeData.ALL_GAME;
        }
    }
}


