package com.icrown.gameapi.commons.configs;

import com.icrown.gameapi.commons.responses.ResponseCode;
import com.icrown.gameapi.commons.utils.APIException;

/**
 * 專案類別
 * @author Frank
 */
public enum ProjectTypeData {
    GAMEAPI_COMMONS(0, "ABC_gameapi_commons_XYZ"),
    GAMEAPI_DAOS(1, "ABC_gameapi_daos_XYZ"),
    COMMON_SERVICES(2, "ABC_common_services_XYZ"),
    BACKGROUND_JOBS(3,"ABC_background_jobs_XYZ"),
    GAMEAPI_SERVICES(4, "ABC_gameapi_services_XYZ"),
    GAMEAPI(5, "ABC_gameapi_XYZ"),
    FRONTENDAPI_SERVICES(6, "ABC_frontend_services_XYZ"),
    FRONTENDAPI(7, "ABC_frontendapi_XYZ"),
    BACKEND_SERVICES(8, "ABC_backend_services_XYZ"),
    BACKENDAPI(9, "ABC_backendapi_XYZ"),
    TGBACKEND_SERVICES(10, "ABC_tgbackend_services_XYZ"),
    TGBACKENDAPI(11, "ABC_tgbackendapi_XYZ"),
    TGADMINAPI(12, "ABC_tgadminapi_XYZ"),
    TGADMINSERVICE  (13, "ABC_tgadminservice_XYZ"),
    FISH_JOB(14, "ABC_fishjob_XYZ"),
    SENDELKAPI (15, "ABC_sendElkApi_XYZ"),
    TGTUNNELAPI(16, "ABC_tgtunnelapi_XYZ");
    private int projectCode;
    private String projectName;

    private ProjectTypeData(int projectCode, String projectName) {
        this.projectCode = projectCode;
        this.projectName = projectName;
    }

    public int getProjectCode() {
        return this.projectCode;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public static ProjectTypeData getByCode(int projectCode){
        for(ProjectTypeData e : values()) {
            if(e.projectCode == projectCode)
            {
                return e;
            }
        }
        throw new APIException(ResponseCode.SYSTEM_ERROR);
    }
}