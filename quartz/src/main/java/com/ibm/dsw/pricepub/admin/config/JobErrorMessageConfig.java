package com.ibm.dsw.pricepub.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="job.error")
public class JobErrorMessageConfig {


    /**
     * job.error.missingInput=SP Missing Input Parameter
     * job.error.generalSql=General SQL Exception
     * job.error.recordExists=Record already exists
     * job.error.recordNotExists=Record not exists
     * job.error.rowNotfound=Row not found
     * */
    private String missingInput;
    private String generalSql;
    private String recordExists;
    private String recordNotExists;
    private String rowNotFound;
    private String success;
    private String missLLSP;
    private String trapError;

    public String getMissLLSP() {
        return missLLSP;
    }

    public void setMissLLSP(String missLLSP) {
        this.missLLSP = missLLSP;
    }

    public String getTrapError() {
        return trapError;
    }

    public void setTrapError(String trapError) {
        this.trapError = trapError;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMissingInput() {
        return missingInput;
    }

    public void setMissingInput(String missingInput) {
        this.missingInput = missingInput;
    }

    public String getGeneralSql() {
        return generalSql;
    }

    public void setGeneralSql(String generalSql) {
        this.generalSql = generalSql;
    }

    public String getRecordExists() {
        return recordExists;
    }

    public void setRecordExists(String recordExists) {
        this.recordExists = recordExists;
    }

    public String getRecordNotExists() {
        return recordNotExists;
    }

    public void setRecordNotExists(String recordNotExists) {
        this.recordNotExists = recordNotExists;
    }

    public String getRowNotFound() {
        return rowNotFound;
    }

    public void setRowNotFound(String rowNotFound) {
        this.rowNotFound = rowNotFound;
    }
}
