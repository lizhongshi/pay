package com.dly.pay.dao;

import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.entity.TUserBankcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserBankcardMapper {
    long countByExample(TUserBankcardExample example);

    int deleteByExample(TUserBankcardExample example);

    int deleteByPrimaryKey(Integer cardId);

    int insert(TUserBankcard record);

    int insertSelective(TUserBankcard record);

    List<TUserBankcard> selectByExample(TUserBankcardExample example);

    TUserBankcard selectByPrimaryKey(Integer cardId);

    int updateByExampleSelective(@Param("record") TUserBankcard record, @Param("example") TUserBankcardExample example);

    int updateByExample(@Param("record") TUserBankcard record, @Param("example") TUserBankcardExample example);

    int updateByPrimaryKeySelective(TUserBankcard record);

    int updateByPrimaryKey(TUserBankcard record);
}