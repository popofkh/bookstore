/**
 * Address.java
 * Copyright(C) 2019 popo_fkh
 * @date 2019-10-04
 */
package edu.zju.cst.bookstore.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {
    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "是否有效")
    private Boolean available;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "省")
    private String provience;

    @ApiModelProperty(value = "地级市")
    private String prefectureCity;

    @ApiModelProperty(value = "县级市")
    private String countyCity;

    @ApiModelProperty(value = "详细地址")
    private String detail;

    @ApiModelProperty(value = "用户id")
    private String accountId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience;
    }

    public String getPrefectureCity() {
        return prefectureCity;
    }

    public void setPrefectureCity(String prefectureCity) {
        this.prefectureCity = prefectureCity;
    }

    public String getCountyCity() {
        return countyCity;
    }

    public void setCountyCity(String countyCity) {
        this.countyCity = countyCity;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", available=").append(available);
        sb.append(", country=").append(country);
        sb.append(", provience=").append(provience);
        sb.append(", prefectureCity=").append(prefectureCity);
        sb.append(", countyCity=").append(countyCity);
        sb.append(", detail=").append(detail);
        sb.append(", accountId=").append(accountId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}