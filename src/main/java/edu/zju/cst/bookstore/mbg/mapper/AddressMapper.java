/**
 * AddressMapper.java
 * Copyright(C) 2019 popo_fkh
 * @date 2019-10-04
 */
package edu.zju.cst.bookstore.mbg.mapper;

import edu.zju.cst.bookstore.mbg.model.Address;
import edu.zju.cst.bookstore.mbg.model.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(String id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}