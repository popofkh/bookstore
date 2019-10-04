/**
 * AccountRoleRelMapper.java
 * Copyright(C) 2019 popo_fkh
 * @date 2019-10-04
 */
package edu.zju.cst.bookstore.mbg.mapper;

import edu.zju.cst.bookstore.mbg.model.AccountRoleRel;
import edu.zju.cst.bookstore.mbg.model.AccountRoleRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountRoleRelMapper {
    long countByExample(AccountRoleRelExample example);

    int deleteByExample(AccountRoleRelExample example);

    int deleteByPrimaryKey(String id);

    int insert(AccountRoleRel record);

    int insertSelective(AccountRoleRel record);

    List<AccountRoleRel> selectByExample(AccountRoleRelExample example);

    AccountRoleRel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AccountRoleRel record, @Param("example") AccountRoleRelExample example);

    int updateByExample(@Param("record") AccountRoleRel record, @Param("example") AccountRoleRelExample example);

    int updateByPrimaryKeySelective(AccountRoleRel record);

    int updateByPrimaryKey(AccountRoleRel record);
}