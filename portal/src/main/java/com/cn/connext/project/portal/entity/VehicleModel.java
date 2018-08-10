package com.cn.connext.project.portal.entity;

import java.util.Date;
import java.util.UUID;

/**
 * 车款 - 实体定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */

public class VehicleModel {
    /**
     * 唯一编号
     */

    private String id;
    /**
     * siteCoreId
     */

    private String siteCoreId;
    /**
     * 车系编码
     */

    private String seriesId;
    /**
     * 车型编号
     */

    private String typeId;
    /**
     * 名称
     */

    private String name;
    /**
     * 英文名
     */

    private String enName;
    /**
     * 代码
     */

    private String code;
    /**
     * 描述
     */

    private String description;
    /**
     * 指导价
     */

    private String guidePrice;
    /**
     * 产地
     */

    private String placeOfOrigin;
    /**
     * 年份
     */

    private Integer year;
    /**
     * 是否在售
     */

    private Boolean isSale;
    /**
     * 创建次序
     */

    private Integer createIndex;
    /**
     * 备注
     */

    private String remark;
    /**
     * 是否可用
     */

    private Boolean isInvalid;
    /**
     * 更新时间
     */

    private Date updateTime;

    /**
     * 进口国产FBU/CKD
     */
    private String extValue;

    /**
     * 默认实例化方法
     */
    public VehicleModel() {
        id = UUID.randomUUID().toString().toUpperCase();
        isSale = true;
        isInvalid = false;
        updateTime = new Date();
    }


    //region getter & setter

    /**
     * 获取唯一编号。
     */
    public String getId() {
        return id == null ? null : id.toUpperCase();
    }

    /**
     * 设置唯一编号。
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取siteCoreId。
     */
    public String getSiteCoreId() {
        return siteCoreId == null ? null : siteCoreId.toUpperCase();
    }

    /**
     * 设置siteCoreId。
     */
    public void setSiteCoreId(String siteCoreId) {
        this.siteCoreId = siteCoreId;
    }

    /**
     * 获取车系编码。
     */
    public String getSeriesId() {
        return seriesId;
    }

    /**
     * 设置车系编码。
     */
    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    /**
     * 获取车型编号。
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置车型编号。
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取名称。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取英文名。
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置英文名。
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * 获取代码。
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码。
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取描述。
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述。
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取指导价。
     */
    public String getGuidePrice() {
        return guidePrice;
    }

    /**
     * 设置指导价。
     */
    public void setGuidePrice(String guidePrice) {
        this.guidePrice = guidePrice;
    }

    /**
     * 获取产地。
     */
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    /**
     * 设置产地。
     */
    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    /**
     * 获取年份。
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年份。
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取是否在售。
     */
    public Boolean getIsSale() {
        return isSale;
    }

    /**
     * 设置是否在售。
     */
    public void setIsSale(Boolean isSale) {
        this.isSale = isSale;
    }

    /**
     * 获取创建次序。
     */
    public Integer getCreateIndex() {
        return createIndex;
    }

    /**
     * 设置创建次序。
     */
    public void setCreateIndex(Integer createIndex) {
        this.createIndex = createIndex;
    }

    /**
     * 获取备注。
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注。
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否可用。
     */
    public Boolean getIsInvalid() {
        return isInvalid;
    }

    /**
     * 设置是否可用。
     */
    public void setIsInvalid(Boolean isInvalid) {
        this.isInvalid = isInvalid;
    }

    /**
     * 获取更新时间。
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间。
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    //endregion


    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }
}

