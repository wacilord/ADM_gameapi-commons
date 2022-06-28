package com.icrown.gameapi.commons.responses;

/**
 * @author Frank
 */
public class VersionData {
    private String buildProjectName;
    private String buildVersion;
    private String buildTime;

    public String getBuildProjectName() {
        return buildProjectName;
    }

    public void setBuildProjectName(String buildProjectName) {
        this.buildProjectName = buildProjectName;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }
}
