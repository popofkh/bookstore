package edu.zju.cst.bookstore.service;

import edu.zju.cst.bookstore.dto.OrganizationResult;
import edu.zju.cst.bookstore.mbg.model.Organization;

import java.util.List;

/**
 * @author 方康华
 * @description TODO
 * @date 2019/10/4 20:47
 */
public interface OrganizationService {

    OrganizationResult queryOrg(String orgId);

    int updateOrg(String orgId, Organization org);

    List<OrganizationResult> queryOrgs(Organization org);

    Organization addOrg(Organization org);

    int deleteOrg(String orgId);
}
