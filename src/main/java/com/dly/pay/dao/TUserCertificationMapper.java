package com.dly.pay.dao;

import com.dly.pay.entity.TUserCertification;
import com.dly.pay.entity.TUserCertificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserCertificationMapper {
    long countByExample(TUserCertificationExample example);

    int deleteByExample(TUserCertificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserCertification record);

    int insertSelective(TUserCertification record);

    List<TUserCertification> selectByExample(TUserCertificationExample example);

    TUserCertification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserCertification record, @Param("example") TUserCertificationExample example);

    int updateByExample(@Param("record") TUserCertification record, @Param("example") TUserCertificationExample example);

    int updateByPrimaryKeySelective(TUserCertification record);

    int updateByPrimaryKey(TUserCertification record);
}