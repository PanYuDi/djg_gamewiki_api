package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ItemModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemModel record);

    int insertSelective(ItemModel record);

    ItemModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemModel record);

    int updateByPrimaryKeyWithBLOBs(ItemModel record);

    int updateByPrimaryKey(ItemModel record);
}