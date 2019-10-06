package edu.zju.cst.bookstore.controller;

import edu.zju.cst.bookstore.common.api.CommonResult;
import edu.zju.cst.bookstore.dto.OrganizationResult;
import edu.zju.cst.bookstore.mbg.model.Organization;
import edu.zju.cst.bookstore.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 方康华
 * @description 组织管理模块
 * @date 2019/10/4 19:14
 */
@Api(tags = "OrganizationController", description = "组织管理模块")
@RestController
@RequestMapping("/org")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @ApiOperation("查询组织")
    @RequestMapping(value = "/{orgId}", method = RequestMethod.GET)
    public CommonResult<OrganizationResult> queryOrg(@PathVariable String orgId) {
        return CommonResult.success(organizationService.queryOrg(orgId));
    }

    @ApiOperation("更新组织")
    @RequestMapping(value = "/{orgId}", method = RequestMethod.PUT)
    public CommonResult<Integer> updateOrg(@PathVariable String orgId, @RequestBody Organization org) {
        return CommonResult.success(organizationService.updateOrg(orgId, org));
    }

    @ApiOperation("查询组织及其子组织")
    @RequestMapping(value = "/orgs", method = RequestMethod.POST)
    public CommonResult<List<OrganizationResult>> queryOrgs(@RequestBody Organization org) {
        return CommonResult.success(organizationService.queryOrgs(org));
    }

    @ApiOperation("新增组织")
    @RequestMapping(method = RequestMethod.POST)
    public CommonResult addOrg(@RequestBody Organization org) {
        return CommonResult.success(organizationService.addOrg(org));
    }

    @ApiOperation("删除组织")
    @RequestMapping(value = "/{orgId}", method = RequestMethod.DELETE)
    public CommonResult<Integer> deleteOrg(@PathVariable String orgId) {
        return CommonResult.success(organizationService.deleteOrg(orgId));
    }

}
