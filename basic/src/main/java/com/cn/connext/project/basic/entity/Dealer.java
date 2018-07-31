package com.cn.connext.project.basic.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 经销商信息 - 实体定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */

public class Dealer implements Serializable {
    /**
     * 唯一标识
     */

    private String id;
    /**
     * 官网编号
     */

    private String siteCoreId;
    /**
     * 微信APPID
     */

    private String wechatAppId;
    /**
     * 微信AppSecret
     */

    private String wechatAppSecret;
    /**
     * 传真
     */

    private String fax;
    /**
     * 行政区域编号
     */

    private String regionId;
    /**
     * 部门编号
     */
    @Column
    private String departmentId;
    /**
     * 经销商名称
     */

    private String name;
    /**
     * 经销商代码
     */

    private String code;
    /**
     * 经销商简称
     */

    private String shortName;
    /**
     * 英文名称
     */

    private String nameEn;
    /**
     * 英文简称
     */

    private String shortNameEn;
    /**
     * 地址
     */

    private String address;
    /**
     * 英文地址
     */
    @Column
    private String addressEn;
    /**
     * 电话
     */

    private String phone;
    /**
     * 客服电话
     */

    private String servicePhone;
    /**
     * 救援电话
     */

    private String rescuePhone;
    /**
     * 公司名
     */

    private String companyName;
    /**
     * 公司地址
     */

    private String companyAddress;
    /**
     * 英文公司地址
     */

    private String companyAddressEn;
    /**
     * 公司电话
     */

    private String companyPhone;
    /**
     * 经度
     */

    private Float locationLog;
    /**
     * 纬度
     */

    private Float locationLat;
    /**
     * URL
     */

    private String url;
    /**
     * Email
     */

    private String email;
    /**
     * QQ
     */

    private String qq;
    /**
     * Wechat
     */

    private String wechat;
    /**
     * 备注
     */
    @Column
    private String remark;
    /**
     * 是否可用
     */

    private Boolean invalid;
    /**
     * 更新时间
     */

    private Date updateTime;
    /**
     * 创建次序
     */
    @Column
    private Integer createIndex;

    /**
     * 默认实例化方法
     */
    public Dealer() {
        id = UUID.randomUUID().toString().toUpperCase();
        invalid = false;
        updateTime = new Date();
    }

    public String getWechatAppId() {
        return wechatAppId;
    }

    public void setWechatAppId(String wechatAppId) {
        this.wechatAppId = wechatAppId;
    }

    public String getWechatAppSecret() {
        return wechatAppSecret;
    }

    public void setWechatAppSecret(String wechatAppSecret) {
        this.wechatAppSecret = wechatAppSecret;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    //region getter & setter

    /**
     * 获取唯一标识。
     */
    public String getId() {
        return id == null ? null : id.toUpperCase();
    }

    /**
     * 设置唯一标识。
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取官网编号。
     */
    public String getSiteCoreId() {
        return siteCoreId == null ? null : siteCoreId.toUpperCase();
    }

    /**
     * 设置官网编号。
     */
    public void setSiteCoreId(String siteCoreId) {
        this.siteCoreId = siteCoreId;
    }

    /**
     * 获取行政区域编号。
     */
    public String getRegionId() {
        return regionId == null ? null : regionId.toUpperCase();
    }

    /**
     * 设置行政区域编号。
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取部门编号。
     */
    public String getDepartmentId() {
        return departmentId == null ? null : departmentId.toUpperCase();
    }

    /**
     * 设置部门编号。
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取经销商名称。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置经销商名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取经销商代码。
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置经销商代码。
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取经销商简称。
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置经销商简称。
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 获取英文名称。
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * 设置英文名称。
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     * 获取英文简称。
     */
    public String getShortNameEn() {
        return shortNameEn;
    }

    /**
     * 设置英文简称。
     */
    public void setShortNameEn(String shortNameEn) {
        this.shortNameEn = shortNameEn;
    }

    /**
     * 获取地址。
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址。
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取英文地址。
     */
    public String getAddressEn() {
        return addressEn;
    }

    /**
     * 设置英文地址。
     */
    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    /**
     * 获取电话。
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话。
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取客服电话。
     */
    public String getServicePhone() {
        return servicePhone;
    }

    /**
     * 设置客服电话。
     */
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    /**
     * 获取救援电话。
     */
    public String getRescuePhone() {
        return rescuePhone;
    }

    /**
     * 设置救援电话。
     */
    public void setRescuePhone(String rescuePhone) {
        this.rescuePhone = rescuePhone;
    }

    /**
     * 获取公司名。
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名。
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取公司地址。
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置公司地址。
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * 获取英文公司地址。
     */
    public String getCompanyAddressEn() {
        return companyAddressEn;
    }

    /**
     * 设置英文公司地址。
     */
    public void setCompanyAddressEn(String companyAddressEn) {
        this.companyAddressEn = companyAddressEn;
    }

    /**
     * 获取公司电话。
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * 设置公司电话。
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    /**
     * 获取经度。
     */
    public Float getLocationLog() {
        return locationLog;
    }

    /**
     * 设置经度。
     */
    public void setLocationLog(Float locationLog) {
        this.locationLog = locationLog;
    }

    /**
     * 获取纬度。
     */
    public Float getLocationLat() {
        return locationLat;
    }

    /**
     * 设置纬度。
     */
    public void setLocationLat(Float locationLat) {
        this.locationLat = locationLat;
    }

    /**
     * 获取URL。
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置URL。
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取Email。
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置Email。
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取QQ。
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ。
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取Wechat。
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置Wechat。
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
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
    public Boolean getInvalid() {
        return invalid;
    }

    /**
     * 设置是否可用。
     */
    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
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

    //endregion
}

