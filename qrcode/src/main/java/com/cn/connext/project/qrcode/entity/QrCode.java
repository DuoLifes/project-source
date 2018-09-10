package com.cn.connext.project.qrcode.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 二维码基础信息 - 实体定义
 * 开发人员: 张帅
 * 修订日期: 2018-05-31 17:31:23
 */
@Entity
@Table(name = "qrCode")
public class QrCode {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 自增字段
     */
    @Column
    private Long createIndex;

    /**
     * 名称
     */
    @Column
    private String name;

    /**
     * 类型
     */
    @Column
    private String code;

    /**
     * 二维码类型
     */
    @Column
    private String type;

    /**
     * 用途描述
     */
    @Column
    private String explanation;

    /**
     * 生效日期
     */
    @Column
    private Date effectiveDate;

    /**
     * 失效日期
     */
    @Column
    private Date expiryDate;

    @Column
    private String activityId;

    @Transient
    private String activityName;

    @Column
    private String positionId;

    @Transient
    private String positionName;

    @Transient
    private String EmployeeName;

    @Transient
    private String logoPath;

    @Column
    private String depId;


    /**
     * 状态
     */
    @Column
    private String state;

    /**
     * 扫码错误处理类型
     */
    @Column
    private String errorType;

    /**
     * 扫码错误处理
     */
    @Column
    private String handling;

    /**
     * 适用范围
     */
    @Column
    private String applyScope;

    /**
     * 状态
     */
    @Column
    public Boolean isValid;

    /**
     * 更新时间
     */
    @Column
    private Date updateTime;

    /**
     * 二维码图片地址
     */
    @Column
    private String imgUrl;

    /**
     * 说明字段（如果类型为微信和小程序，则存储小程序或微信的ID，如果为名片类，则存用户的ID）
     */
    @Column
    private String notes;

    @Transient
    private String weChatName;

    /**
     * 区域名称（仅用于前台展示）
     */
    @Transient
    private String applyScopeName;

    /**
     * 二维码图片中心logo图片地址
     */
    @Column
    private String logoUrl;

    /**
     * 二维码前景色
     */
    @Column
    private String onColor;

    /**
     * 二维码背景色
     */
    @Column
    private String offColor;

    /**
     * 二维码尺寸
     */
    @Column
    private String width;

    /**
     * 二维码图片类型（0为jpg，1为png）
     */
    @Column
    private String imgType;

    /**
     * 发布时间
     */
    @Column
    private Date releaseTime;

    /**
     * 线索总数
     */
    @Column
    private String leadsCounts;

    @Column
    private String page;

    @Transient
    private String[] content;

    @Transient
    private String PV;

    @Transient
    private String UV;

    @Transient
    private String appId;

    @Transient
    private String appSecret;

    /**
     * 默认实例化方法
     */
    public QrCode() {
        updateTime = new Date();
        isValid = false;
        state = "0";
        leadsCounts = "0";
    }

    //region getter & setter

    /**
     * 获取ID。
     */
    public String getId() {
        return id;
    }

    /**
     *设置ID。
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取自增字段。
     */
    public Long getCreateIndex() {
        return createIndex;
    }

    /**
     *设置自增字段。
     */
    public void setCreateIndex(Long createIndex) {
        this.createIndex = createIndex;
    }

    /**
     * 获取类型。
     */
    public String getCode() {
        return code;
    }

    /**
     *设置类型。
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取名称。
     */
    public String getName() {
        return name;
    }

    /**
     *设置名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        isValid = isValid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getHandling() {
        return handling;
    }

    public void setHandling(String handling) {
        this.handling = handling;
    }

    public String getApplyScope() {
        return applyScope;
    }

    public void setApplyScope(String applyScope) {
        this.applyScope = applyScope;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getApplyScopeName() {
        return applyScopeName;
    }

    public void setApplyScopeName(String applyScopeName) {
        this.applyScopeName = applyScopeName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getOnColor() {
        return onColor;
    }

    public void setOnColor(String onColor) {
        this.onColor = onColor;
    }

    public String getOffColor() {
        return offColor;
    }

    public void setOffColor(String offColor) {
        this.offColor = offColor;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getWeChatName() {
        return weChatName;
    }

    public void setWeChatName(String weChatName) {
        this.weChatName = weChatName;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getLeadsCounts() {
        return leadsCounts;
    }

    public void setLeadsCounts(String leadsCounts) {
        this.leadsCounts = leadsCounts;
    }

    public String getPV() {
        return PV;
    }

    public void setPV(String PV) {
        this.PV = PV;
    }

    public String getUV() {
        return UV;
    }

    public void setUV(String UV) {
        this.UV = UV;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    //endregion
}

