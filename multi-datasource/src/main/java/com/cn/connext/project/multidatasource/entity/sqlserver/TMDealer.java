package com.cn.connext.project.multidatasource.entity.sqlserver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TMDealer")
public class TMDealer {

    @Id
    public String ID;

    @Column
    public String SitecoreId;

    @Column
    public String CustomerId;

    @Column
    public String VirtualDepartmentId;

    @Column
    public String RegionalismId;

    @Column
    public String Name;

    @Column
    public String Code;

    @Column
    public Boolean IsInvalid;

    @Column
    public String NameShort;

    @Column
    public String NameEn;

    @Column
    public String NameEnShort;

    @Column
    public String Address;

    @Column
    public String AddressEn;

    @Column
    public String Telephone;

    @Column
    public String TelephoneService;

    @Column
    public String TelephoneRescue;

    @Column
    public String CompanyName;

    @Column
    public String CompanyAddress;

    @Column
    public String CompanyAddressEn;

    @Column
    public String CompanyTelephone;

    @Column
    public String Remark;

    @Column
    public Float LocationLong;

    @Column
    public Float LocationLat;

    @Column
    public String DealerUrl;

    @Column
    public String EMail;

    @Column
    public String QQ;

    @Column
    public String Wechat;



}
