package com.dly.pay.dao;

import com.dly.pay.entity.TsLevel;
import com.dly.pay.entity.TsLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TsLevelMapper {
    long countByExample(TsLevelExample example);

    int deleteByExample(TsLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TsLevel record);

    int insertSelective(TsLevel record);

    List<TsLevel> selectByExample(TsLevelExample example);

    TsLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TsLevel record, @Param("example") TsLevelExample example);

    int updateByExample(@Param("record") TsLevel record, @Param("example") TsLevelExample example);

    int updateByPrimaryKeySelective(TsLevel record);

    int updateByPrimaryKey(TsLevel record);
}