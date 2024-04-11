package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ItemModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemModelMapper {
    List<ItemModel> getItemList(String searchStr, List<String> categories, Integer offset);

    Integer getTotalCount(String searchStr, List<String> categories);
    int deleteByPrimaryKey(Long id);

    int insert(ItemModel record);

    int insertSelective(ItemModel record);

    ItemModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemModel record);

    int updateByPrimaryKeyWithBLOBs(ItemModel record);

    int updateByPrimaryKey(ItemModel record);
}