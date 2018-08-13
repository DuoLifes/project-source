package com.cn.connext.project.portal.domain;

import java.util.Date;
import java.util.List;

public class VehicleModelParam {

    public List<String> seriesIdList;

    public List<String> typeIdList;

    public String beginYear;

    public String endYear;

    public String name;

    public String code;

    public String isInvalid;

    public Date beginUpdateTime;

    public Date endUpdateTime;

    public String extValue;

    public String id;

    public String index;

    public String type;

    //get set function()


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

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
