package com.dly.pay.dao;

import com.dly.pay.entity.TFenrunMx;
import com.dly.pay.entity.TFenrunMxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFenrunMxMapper {
    long countByExample(TFenrunMxExample example);

    int deleteByExample(TFenrunMxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFenrunMx record);

    int insertSelective(TFenrunMx record);

    List<TFenrunMx> selectByExample(TFenrunMxExample example);

    TFenrunMx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFenrunMx record, @Param("example") TFenrunMxExample example);

    int updateByExample(@Param("record") TFenrunMx record, @Param("example") TFenrunMxExample example);

    int updateByPrimaryKeySelective(TFenrunMx record);

    int updateByPrimaryKey(TFenrunMx record);
}