package com.ibm.dsw.pricepub.admin.entity;


import org.apache.commons.lang3.time.DateFormatUtils;

public class JobTask {
    /**
     *  ,	IN	piJobTitle			VARCHAR(100)
     *     ,	IN 	piStartDate			VARCHAR(50)
     *     ,	IN	piEndDate			VARCHAR(50)
     *     ,	IN	piJobFreq			CHAR(1)
     *     ,	IN	piJobDtl			CHAR(11)
     *     ,	IN	piJobSucc			CHAR(11)
     *     ,	IN	piJobFail			CHAR(11)
     *     ,	IN	piAddByUserName		VARCHAR(80)
     *     ,	IN 	piModByUserName		VARCHAR(80)
     *     , 	IN 	piInactFlag			CHAR(6)
     *     ,	IN 	piFileCfgIDs		VARCHAR(1000)
     * */
    private Integer jobID;
    private String jobTitle;
    private String startDate;
    private String endDate;
    private String jobFreq;
    private Integer jobDtl;
    private Integer jobSucc;
    private Integer jobFail;
    private String addByUserName;
    private String modByUserName;
    private Integer inactFlag;
    private String fileCfgIDs;
    private String addDate;
    private String modDate;
    private Integer deleteFlag;
    private String clazzPath;

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public void setJobDtl(Integer jobDtl) {
        this.jobDtl = jobDtl;
    }

    public void setJobSucc(Integer jobSucc) {
        this.jobSucc = jobSucc;
    }

    public void setJobFail(Integer jobFail) {
        this.jobFail = jobFail;
    }

    public void setInactFlag(Integer inactFlag) {
        this.inactFlag = inactFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getClazzPath() {
        return clazzPath;
    }

    public void setClazzPath(String clazzPath) {
        this.clazzPath = clazzPath;
    }

    public int getJobDtl() {
        return jobDtl;
    }

    public void setJobDtl(int jobDtl) {
        this.jobDtl = jobDtl;
    }

    public int getJobSucc() {
        return jobSucc;
    }

    public void setJobSucc(int jobSucc) {
        this.jobSucc = jobSucc;
    }

    public int getJobFail() {
        return jobFail;
    }

    public void setJobFail(int jobFail) {
        this.jobFail = jobFail;
    }

    public int getInactFlag() {
        return inactFlag;
    }

    public void setInactFlag(int inactFlag) {
        this.inactFlag = inactFlag;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStartDate() {
        
        return startDate;
    }

    public void setStartDate(String startDate) {

        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getJobFreq() {
        return jobFreq;
    }

    public void setJobFreq(String jobFreq) {
        this.jobFreq = jobFreq;
    }


    public String getAddByUserName() {
        return addByUserName;
    }

    public void setAddByUserName(String addByUserName) {
        this.addByUserName = addByUserName;
    }

    public String getModByUserName() {
        return modByUserName;
    }

    public void setModByUserName(String modByUserName) {
        this.modByUserName = modByUserName;
    }


    public String getFileCfgIDs() {
        return fileCfgIDs;
    }

    public void setFileCfgIDs(String fileCfgIDs) {
        this.fileCfgIDs = fileCfgIDs;
    }
}
