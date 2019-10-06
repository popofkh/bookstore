package edu.zju.cst.bookstore.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;

/**
 * @author 方康华
 * @description TODO
 * @date 2019/10/4 20:59
 */
public class OrganizationResult {
    @ApiModelProperty(value = "组织编号")
    private String id;

    @ApiModelProperty(value = "上级组织编号")
    private String pid;

    @ApiModelProperty(value = "组织名称")
    private String orgName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "组织管理员")
    private String admin;

    @ApiModelProperty(value = "下级组织")
    private List<OrganizationResult> childOrgs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public List<OrganizationResult> getChildOrgs() {
        return childOrgs;
    }

    public void setChildOrgs(List<OrganizationResult> childOrgs) {
        this.childOrgs = childOrgs;
    }
}
