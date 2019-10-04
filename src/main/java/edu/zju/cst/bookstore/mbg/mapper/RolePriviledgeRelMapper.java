/**
 * RolePriviledgeRelMapper.java
 * Copyright(C) 2019 popo_fkh
 * @date 2019-10-04
 */
package edu.zju.cst.bookstore.mbg.mapper;

import edu.zju.cst.bookstore.mbg.model.RolePriviledgeRel;
import edu.zju.cst.bookstore.mbg.model.RolePriviledgeRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePriviledgeRelMapper {
    long countByExample(RolePriviledgeRelExample example);

    int deleteByExample(RolePriviledgeRelExample example);

    int deleteByPrimaryKey(String id);

    int insert(RolePriviledgeRel record);

    int insertSelective(RolePriviledgeRel record);

    List<RolePriviledgeRel> selectByExample(RolePriviledgeRelExample example);

    RolePriviledgeRel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RolePriviledgeRel record, @Param("example") RolePriviledgeRelExample example);

    int updateByExample(@Param("record") RolePriviledgeRel record, @Param("example") RolePriviledgeRelExample example);

    int updateByPrimaryKeySelective(RolePriviledgeRel record);

    int updateByPrimaryKey(RolePriviledgeRel record);
}