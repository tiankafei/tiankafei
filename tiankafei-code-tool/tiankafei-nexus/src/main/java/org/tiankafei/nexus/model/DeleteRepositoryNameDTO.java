package org.tiankafei.nexus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteRepositoryNameDTO implements Serializable {

    private String id;

    private String repositoryName = "maven-snapshots";

    private String group;

    private String name;

    private String version;

    private String format = "maven2";

    private Boolean healthCheckLoading = Boolean.FALSE;

    private Boolean healthCheckDisabled = Boolean.TRUE;

    private Boolean healthCheckError;

    private Boolean healthCheckMostPopularVersion;

    private Boolean healthCheckCapped;

    private Boolean healthCheckAge;

    private Boolean healthCheckPopularity;

    private Boolean healthCheckSecurityAlerts;

    private Boolean healthCheckCriticalSecurityAlerts;

    private Boolean healthCheckSevereSecurityAlerts;

    private Boolean healthCheckModerateSecurityAlerts;

    private Boolean healthCheckLicenseThreat;

    private Boolean healthCheckLicenseThreatName;

    private Boolean healthCheckCappedAlerts;

}
