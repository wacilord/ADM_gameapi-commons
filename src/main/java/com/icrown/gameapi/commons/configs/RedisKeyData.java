package com.icrown.gameapi.commons.configs;

public enum RedisKeyData {
    TOKEN(1,"token_"),
    PLAYER_GUID(2,""),
    TICKET(3,""),
    GAME_RECORD(4, "gameRecord_"),
    GAME_RECORD_PROCESS(5,"gameRecordProcess_"),
    CACHE_ALL_GAME_TYPE(6,"cache_all_game_type_"),
    CACHE_ENABLE_GAME(7,"cache_enable_game_"),
    USER_CONFIG_DATA(8 , "user_config_data"),
    SYS_GAMESETTING(9 , "sys_gamesetting"),
    CHECK_PARTITION_FLAG(10, "check_partition"),
    JACKPOT_SETTING(11, "jackpotSetting_"),
    CAM_RECORD_PROCESS(12, "camRecordProcess_"),
    LANG_CODE(12, "language_code");

    private int type;
    private String prefix;
    private RedisKeyData(int type,String prefix){
        this.type = type;
        this.prefix = prefix;
    }
    public String getPrefix(){
        return this.prefix;
    }

}
