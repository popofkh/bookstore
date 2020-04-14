package edu.zju.cst.bookstore.service.impl;

import edu.zju.cst.bookstore.common.exception.BizServiceException;
import edu.zju.cst.bookstore.dto.OrganizationResult;
import edu.zju.cst.bookstore.mbg.mapper.OrganizationMapper;
import edu.zju.cst.bookstore.mbg.model.Organization;
import edu.zju.cst.bookstore.mbg.model.OrganizationExample;
import edu.zju.cst.bookstore.service.OrganizationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author 方康华
 * @description 组织管理实现
 * @date 2019/10/4 20:48
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public OrganizationResult queryOrg(String orgId) {

        Organization org = organizationMapper.selectByPrimaryKey(orgId);
        if(Objects.isNull(org)) {
            throw new BizServiceException("Organization.NotFount");
        }
        return buildOrganizationResult(org, false);
    }

    @Override
    public int updateOrg(String orgId, Organization org) {
        org.setId(orgId);
        if(Objects.isNull(organizationMapper.selectByPrimaryKey(orgId))) {
            throw new BizServiceException("Organization.NotFount");
        }
        int update = organizationMapper.updateByPrimaryKeySelective(org);
        if(update != 1) {
            throw new BizServiceException("Organization.Update.Failed");
        }
        return update;
    }

    @Override
    public List<OrganizationResult> queryOrgs(Organization org) {

        List<OrganizationResult> results = new ArrayList<>();

        // 查询节点
        OrganizationExample example = new OrganizationExample();
        OrganizationExample.Criteria criteria = example.createCriteria().andAvailableEqualTo(true);

        if(Objects.nonNull(org)) {
            if(StringUtils.isNotBlank(org.getId())) {
                criteria.andIdEqualTo(org.getId());
            }
            if(StringUtils.isNotBlank(org.getPid())) {
                criteria.andPidEqualTo(org.getPid());
            }
            if(StringUtils.isNotBlank(org.getAdmin())) {
                criteria.andAdminEqualTo(org.getAdmin());
            }
            if(StringUtils.isNotBlank(org.getOrgName())) {
                criteria.andOrgNameLike(org.getOrgName());
            }
            if(StringUtils.isNotBlank(org.getDescription())) {
                criteria.andDescriptionLike(org.getDescription());
            }
        }
        List<Organization> rootOrgs = organizationMapper.selectByExample(example);

        // 查询子节点
        for (Organization rootOrg : rootOrgs) {
            OrganizationResult orgResult = buildOrganizationResult(rootOrg, true);
            results.add(orgResult);
        }
        return results;
    }

    @Override
    public Organization addOrg(Organization org) {
        organizationMapper.insertSelective(org);
        return org;
    }

    @Override
    public int deleteOrg(String orgId) {
        Organization org = organizationMapper.selectByPrimaryKey(orgId);
        if(Objects.isNull(org)) {
            throw new BizServiceException("Organization.NotFount");
        }
        return organizationMapper.deleteByPrimaryKey(orgId);
    }

    /**
     * 构造OrganizationResult
     * @param org
     * @param needChild
     * @return
     */
    private OrganizationResult buildOrganizationResult(Organization org, Boolean needChild) {
        OrganizationResult result = new OrganizationResult();
        result.setId(org.getId());
        result.setOrgName(org.getOrgName());
        result.setDescription(org.getDescription());
        result.setPid(org.getPid());
        result.setAdmin(org.getAdmin());
        if(needChild) {
            result.setChildOrgs(queryChildOrgs(result.getId()));
        }
        return result;
    }

    /**
     * 查询所有下级组织
     * @param parentOrgId
     * @return
     */
    private List<OrganizationResult> queryChildOrgs(String parentOrgId) {
        List<OrganizationResult> results = new ArrayList<>();

        OrganizationExample example = new OrganizationExample();
        example.or().andAvailableEqualTo(true).andPidEqualTo(parentOrgId);
        List<Organization> childOrgs = organizationMapper.selectByExample(example);
        if(Objects.isNull(childOrgs)) {
            return null;
        }
        childOrgs.stream().forEach(org -> {
            OrganizationResult result = buildOrganizationResult(org, true);
            result.setChildOrgs(queryChildOrgs(org.getId()));
            results.add(result);
        });
        return results;
    }
}
