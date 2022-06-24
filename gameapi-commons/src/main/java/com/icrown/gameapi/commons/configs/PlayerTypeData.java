package com.icrown.gameapi.commons.configs;

/**
 * 玩家類別
 */
public enum PlayerTypeData {
    NORMAL_PLAYER("1" ,"正式玩家"),
    TRIAL_PLAYER("0","試玩玩家") ;
    private String typeCode;
    private String typeName;
    private PlayerTypeData(String typeCode,String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }
    public String getTypeCode(){
        return this.typeCode;
    }
    public String getTypeName(){
        return this.typeName;
    }
}
