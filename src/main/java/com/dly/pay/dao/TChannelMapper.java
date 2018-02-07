package com.dly.pay.dao;

import com.dly.pay.entity.TChannel;
import com.dly.pay.entity.TChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChannelMapper {
    long countByExample(TChannelExample example);

    int deleteByExample(TChannelExample example);

    int deleteByPrimaryKey(Integer channelId);

    int insert(TChannel record);

    int insertSelective(TChannel record);

    List<TChannel> selectByExample(TChannelExample example);

    TChannel selectByPrimaryKey(Integer channelId);

    int updateByExampleSelective(@Param("record") TChannel record, @Param("example") TChannelExample example);

    int updateByExample(@Param("record") TChannel record, @Param("example") TChannelExample example);

    int updateByPrimaryKeySelective(TChannel record);

    int updateByPrimaryKey(TChannel record);

	List<TChannel> getChannelAndUserId(String userId);
}