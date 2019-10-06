package edu.zju.cst.bookstore.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author 方康华
 * @description TODO
 * @date 2019/10/5 23:19
 */
public class AccountForm {
    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "是否有效")
    private Boolean available;

    @NotNull
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotNull
    @ApiModelProperty(value = "密码")
    private String password;

    @NotNull
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Gender gender;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @NotNull
    @ApiModelProperty(value = "所属组织编号")
    private String orgId;

    @ApiModelProperty(value = "审核状态")
    private Audit audit;

    @ApiModelProperty(value = "用户类型")
    private UserType userType;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
