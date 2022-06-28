package com.icrown.gameapi.commons.responses;

/**
 * gameapi 從 11-0000開始
 * frontendapi 從 12-0000開始
 * backendapi 從 13-0000開始
 * commonService 從 19-0000開始
 */

public enum ResponseCode {
    //共用
    OK(200, "Succeed"),
    SYSTEM_ERROR(500, "System Error"),
    PARAMETER_ERROR(600, "Parameter Error"),
    JSON_FORMAT_ERROR(700, "Json Format Error"),
    SYSTEM_IS_ON_MAINTAIN(800, "System Is On Maintain"),

    //GameAPI
    GAMEAPI_API_NOT_EXIST(111010, "API Not Exist"),
    //GAMEAPI_PARAMETER_ERROR(111040, "Parameter Error"),
    GAMEAPI_SQL_NO_RECORD(111030, "Execute SQL No Infection"),
    GAMEAPI_AGENT_FROZEN(111040, "Agent Frozen"),
    GAMEAPI_IP_NOT_ALLOW(111050, "IP Not Allow"),
    GAMEAPI_DATETIME_FORMAT_ERROR(111060, "DateTime Format Error"),
    GAMEAPI_PLAYER_ALREADY_LOCK(111090, "Player Is Already Lock"),
    GAMEAPI_PLAYER_NOT_LOCK(111100, "Player Is Not Lock"),
    GAMEAPI_LOCKBY_NOT_MATCH(111110, "Lock By Not Match"),
    GAMEAPI_POINTS_NOT_ENOUGH(111120, "Points Not Enough"),
    GAMEAPI_TRANSACTION_NOT_EXIST(111130, "Transaction ID Not Exist"),
    GAMEAPI_TRANSACTION_ALREADY_EXIST(111140, "Transaction ID Already Exist"),
    GAMEAPI_TRANSACTION_ERROR(111150, "Transaction Error"),
    GAMEAPI_GAME_ON_MAINTENANCE(111160, "Game On Maintenance"),
    GAMEAPI_GAME_NOT_EXIST(111170, "Game Not Exists"),
    GAMEAPI_GAME_NOT_ENABLE(111180, "Game Not Enable"),
    GAMEAPI_DATA_IS_PROCESSING(111200, "Data Is Processing"),
    GAMEAPI_MERCHANT_IS_CLOSE(111210, "Merchant Is Close"),
    GAMEAPI_CHECKSUM_ERROR(111220, "CheckSum Error"),
    GAMEAPI_HEADER_AGENT_EMPTY(111230, "Header Not Contains Agent "),
    GAMEAPI_HEADER_DOMAIN_EMPTY(111240, "Header Not Contains Domain "),
    GAMEAPI_GAMETURN_NOT_FOUND(111250, "GameTurn Not Found "),
    GAMEAPI_GAME_SETTING_NOT_FOUND(111270, "Game Setting Not Found"),
    GAMEAPI_GAME_PLAYING_TRANSFER_NOT_ALLOW(111280, "Game Playing Transfer Is Not Allow"),
    GAMEAPI_TRIALPLAYGAME_NOT_ALLOW(111290, "TrialPlayGame Is Not Allow"),
    GAMEAPI_JACKPOTID_NOT_FOUND(111300, "Jackpot Id Not Found"),
    //FrontendAPI
    FRONTENDAPI_API_NOT_EXIST(121010, "API Not Exist"),
    //FRONTENDAPI_PARAMETER_ERROR(121040, "Parameter Error"),
    FRONTENDAPI_TOKEN_ERROR(121020, "Token Error"),
    FRONTENDAPI_TOKEN_MISS(121030, "Token Miss"),
    FRONTENDAPI_IP_NOT_ALLOW(121040, "IP Not Allow"),
    FRONTENDAPI_PLAYER_NOT_EXISTS(121050, "Player Not Exists"),
    FRONTENDAPI_PLAYER_NOT_LOGGED(121070, "Player Not Logged"),
    FRONTENDAPI_PLAYER_DUPLICATE_LOGIN(121080, "Player Duplicate Login"),
    FRONTENDAPI_PLAYER_IS_KICKED(121090, "Player Is Kicked"),
    FRONTENDAPI_PLAYER_PERMISSION_CLOSED(121100, "Player Permission Closed"),
    FRONTENDAPI_NO_SERVICE_FOR_GUEST(121110, "No Service For Guest"),
    FRONTENDAPI_GAME_NOT_EXIST(121120, "Game Not Exists"),
    FRONTENDAPI_GAME_RECORD_NOT_FOUND(121130, "Game Record Not Found"),
    FRONTENDAPI_REDIS_EXPIRED_FALSE(121140, "Redis Expired False"),
    FRONTENDAPI_MERCHANT_IS_CLOSE(121150, "Merchant Is Close"),
    FRONTENDAPI_GAME_NOT_ENABLE(121160, "Game Not Enable"),
    FRONTENDAPI_AWARD_IS_NOT_EXIST(121170, "Award is not exist"),
    FRONTENDAPI_AWARD_ALREADY_EXIST(121180, "Award ID Already Exist"),
    FRONTENDAPI_AWARD_REPLICATE_ID_ERROR(121190, "Award ID Should Not Replicate"),
    FRONTENDAPI_DATA_IS_PROCESSING(121200, "Data Is Processing"),
    FRONTENDAPI_AWARD_PLAYER_IS_NOT_MATCH(121210, "Award Player Is Not Match"),
    FRONTENDAPI_CAMPAIGN_IS_NOT_MATCH(121220, "Campaign Is Not Match"),
    FRONTENDAPI_AWARD_EXCHANGE_FAIL(121230, "Award Excahnge Fail"),
    FRONTENDAPI_AWARD_EXCHANGE_COUNT_NOT_ENOUGH(121240, "Award Exchange Count Not Enough"),
    FRONTENDAPI_AWARD_TYPE_IS_NOT_EXIST(121250, "Award Type is not Exist"),
    FRONTENDAPI_CAMPAIGN_IS_NOT_EXIST(121260, "Campaign Is Not Exist"),

    //BackendAPI
    BACKENDAPI_API_NOT_EXIST(131010, "API Not Exist"),
    //BACKENDAPI_PARAMETER_ERROR(131040, "Parameter Error"),
    BACKENDAPI_NO_PERMISSION(131020, "No Permission To Run API"),
    BACKENDAPI_NO_OPERATE_PERMISSION(131030, "No Operate Permission"),
    BACKENDAPI_TOKEN_ERROR(131040, "Token Error"),
    BACKENDAPI_TOKEN_MISS(131050, "Token Miss"),
    BACKENDAPI_TOKEN_EXPIRED(131060, "Token Expired"),
    BACKENDAPI_SQL_NO_RECORD(131070, "Execute SQL No Infection"),
    BACKENDAPI_AGENT_FROZEN(131080, "Agent Frozen"),
    BACKENDAPI_AGENT_NOT_FOUND(131090, "Agent Not Found"),
    BACKENDAPI_IP_NOT_ALLOW(131100, "IP Not Allow"),
    BACKENDAPI_AGENT_REGAIN_TIME(131110, "Regain Time Error"),
    BACKENDAPI_AGENT_PASSWORD_ERROR(131120, "Agent Password Error"),
    BACKENDAPI_ACCOUNT_NOT_EXISTS(131130, "Account Not Exists"),
    BACKENDAPI_ACCOUNT_ALREADY_EXISTS(131140, "Account Already Exists"),
    BACKENDAPI_ACCOUNT_ALREADY_LOCK(131150, "Account Is Already Lock"),
    BACKENDAPI_ACCOUNT_NOT_LOCK(131160, "Account Is Not Lock"),
    BACKENDAPI_SUB_ACCOUNT_NOT_EXIST(131170, "Login Account Not Exist"),
    BACKENDAPI_IS_FIRST_LOGIN(131180, "First Login Error"),
    BACKENDAPI_PASSWORD_SAME_AS_ACCOUNT(131190, "Password Same As Account"),
    BACKENDAPI_PASSWORD_SAME_AS_OLD_PASSWORD(131200, "Password Same As Old Password"),
    BACKENDAPI_OLD_PASSWORD_ERROR(131210, "Old Password Not Match"),
    BACKENDAPI_FORM_NO_NOT_EXIST(131220, "FormNo Not Exist"),
    BACKENDAPI_REDIS_EXPIRED_FALSE(131230, "Redis Expired False"),
    BACKENDAPI_TRANSFERID_NOT_EXIST(131240, "TransferId Not Exist"),
    BACKENDAPI_MERCHANT_IS_CLOSE(131250, "Merchant Is Close"),
    BACKENDAPI_GAMETURN_NOT_FOUND(131260, " GameTurn Not Found "),

    //TGAdminapi
    TGADMINAPI_API_NOT_EXIST(141010, "API Not Exist"),
    TGADMINAPI_NO_PERMISSION(141020, "No Permission To Run API"),
    TGADMINAPI_TOKEN_ERROR(141030, "Token Error"),
    TGADMINAPI_TOKEN_MISS(141040, "Token Miss"),
    TGADMINAPI_TOKEN_EXPIRED(141050, "Token Expired"),
    TGADMINAPI_IP_NOT_ALLOW(141060, "IP Not Allow"),
    TGADMINAPI_ACCOUNT_REGAIN_TIME(141070, "Regain Time Error"),
    TGADMINAPI_ACCOUNT_PASSWORD_ERROR(141080, "Password Error"),
    TGADMINAPI_ACCOUNT_NOT_EXISTS(141090, "Account Not Exists"),
    TGADMINAPI_ACCOUNT_ALREADY_EXISTS(141100, "Account Already Exists"),
    TGADMINAPI_ACCOUNT_ALREADY_LOCK(141110, "Account Is Already Lock"),
    TGADMINAPI_ACCOUNT_NOT_LOCK(141120, "Account is Not Lock"),
    TGADMINAPI_REDIS_EXPIRED_FALSE(141130, "Redis Expired False"),
    TGADMINAPI_TIME_RANAGE_NOT_ALLOW(141140, "Time Range Not Allow"),
    TGADMINAPI_REDIS_HELPER_OPERATION_TYPE_NOT_EXIST(141150, "Redis Helper Operation Type Not Exist"),
    TGADMINAPI_LOG_TYPE_NOT_EXIST(141160, "Log Type Not Exist"),
    TGADMINAPI_ROLE_ID_NOT_MATCH(141170, "Role Id Not Match"),
    TGADMINAPI_GAME_TYPE_EMPTY(141180, "Game Type Empty"),
    TGADMINAPI_PASSWORD_SAME_AS_ACCOUNT(141190, "Password Same As Account"),
    TGADMINAPI_AGENT_ACCOUNT_ALREADY_EXISTS(141200, "Agent Account Already Exists"),
    TGADMINAPI_DOMAIN_ALREADY_EXISTS(141210, "Domain Already Exists"),
    TGADMINAPI_GAME_TYPE_NOT_EXISTS(141220, "Game Type Not Exists"),
    TGADMINAPI_OLD_PASSWORD_ERROR(141230, "Old Password Not Match"),
    TGADMINAPI_PASSWORD_SAME_AS_OLD_PASSWORD(141240, "Password Same As Old Password"),
    TGADMINAPI_GAMETURN_NOT_FOUND(141250, "GameTurn Not Found"),
    TGADMINAPI_AGENT_ACCOUNT_IS_NOT_AGENT1(141260, "Agent Account Is Not Agent1"),
    TGADMINAPI_LOG_FILE_ERROR(141270, "Log File Error"),
    TGADMINAPI_ADD_PARTITION_ERROR(141280, "Add Partition Error"),
    TGADMINAPI_USER_CONFIG_NOT_EXISTS(141290, "UserConfig Not Exists"),
    TGADMINAPI_AGENT_NOT_EXIST(141300, "Agent is Not Exist"),
    TGADMINAPI_GAME_CODE_NOT_EXISTS(141310, "Game Code Not Exists"),
    TGADMINAPI_GAMETURN_ALREADY_EXISTS(141320, "GameTurn Already Exists"),

    //CommonService
    //COMMONSERVICE_PARAMETER_ERROR(191040, "Parameter Error"),
    COMMONSERVICE_AGENT_NOT_FOUND(191010, "Agent Not Found"),
    //COMMONSERVICE_CHECKSUM_ERROR(191020,"CheckSum Error"),
    COMMONSERVICE_PLAYER_NOT_EXISTS(191030, "Player Not Exists"),
    COMMONSERVICE_PLAYER_PERMISSION_CLOSED(191040, "Player Permission Closed"),
    COMMONSERVICE_TIME_LIMIT(191050, "Time Limit"),
    COMMONSERVICE_PASSWORD_FORMAT_ERROR(191060, "Password Rule Not Match"),
    COMMONSERVICE_GAME_TYPE_NOT_ENABLE(191070, "Game Type Not Enable"),
    COMMONSERVICE_PLAYER_ALREADY_EXISTS(191080, "Player Already Exists");

    private int statusCode;
    private String errorMessage;

    private ResponseCode(int _statusCode, String _errorMessage) {
        this.statusCode = _statusCode;
        this.errorMessage = _errorMessage;
    }


    public int getStatusCode() {
        return statusCode;
    }

    private void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
