package com.dly.pay.dao;

import com.dly.pay.entity.OpenQuickpay;
import com.dly.pay.entity.TUserChannel;
import com.dly.pay.entity.TUserChannelExample;
import com.dly.pay.vo.OpenQuickPayInput;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserChannelMapper {
    long countByExample(TUserChannelExample example);

    int deleteByExample(TUserChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserChannel record);

    int insertSelective(TUserChannel record);

    List<TUserChannel> selectByExample(TUserChannelExample example);

    TUserChannel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserChannel record, @Param("example") TUserChannelExample example);

    int updateByExample(@Param("record") TUserChannel record, @Param("example") TUserChannelExample example);

    int updateByPrimaryKeySelective(TUserChannel record);

    int updateByPrimaryKey(TUserChannel record);
    
    OpenQuickpay getUserInfo(OpenQuickPayInput input);
}