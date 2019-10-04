/**
 * PriviledgeMapper.java
 * Copyright(C) 2019 popo_fkh
 * @date 2019-10-04
 */
package edu.zju.cst.bookstore.mbg.mapper;

import edu.zju.cst.bookstore.mbg.model.Priviledge;
import edu.zju.cst.bookstore.mbg.model.PriviledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriviledgeMapper {
    long countByExample(PriviledgeExample example);

    int deleteByExample(PriviledgeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Priviledge record);

    int insertSelective(Priviledge record);

    List<Priviledge> selectByExample(PriviledgeExample example);

    Priviledge selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Priviledge record, @Param("example") PriviledgeExample example);

    int updateByExample(@Param("record") Priviledge record, @Param("example") PriviledgeExample example);

    int updateByPrimaryKeySelective(Priviledge record);

    int updateByPrimaryKey(Priviledge record);
}