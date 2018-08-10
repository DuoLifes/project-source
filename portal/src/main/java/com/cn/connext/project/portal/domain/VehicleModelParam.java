package com.cn.connext.project.portal.domain;

import java.util.Date;
import java.util.List;

public class VehicleModelParam {

    private List<String> seriesIdList;

    private List<String> typeIdList;

    private String beginYear;

    private String endYear;

    private String name;

    private String code;

    private String isInvalid;

    private Date beginUpdateTime;

    private Date endUpdateTime;

    private String extValue;

    //get set function()


    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }

    public Date getBeginUpdateTime() {
        return beginUpdateTime;
    }

    public void setBeginUpdateTime(Date beginUpdateTime) {
        this.beginUpdateTime = beginUpdateTime;
    }

    public Date getEndUpdateTime() {
        return endUpdateTime;
    }

    public void setEndUpdateTime(Date endUpdateTime) {
        this.endUpdateTime = endUpdateTime;
    }

    public List<String> getSeriesIdList() {
        return seriesIdList;
    }

    public void setSeriesIdList(List<String> seriesIdList) {
        this.seriesIdList = seriesIdList;
    }

    public List<String> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<String> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public String getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(String beginYear) {
        this.beginYear = beginYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(String isInvalid) {
        this.isInvalid = isInvalid;
    }
}
