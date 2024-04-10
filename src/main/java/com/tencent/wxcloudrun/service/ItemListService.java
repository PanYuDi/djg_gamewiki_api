package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ItemModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 潘语笛
 * @Date: 31/3/2024 下午 9:48
 * @Description: TODO
 */
public interface ItemListService {
    public ItemModel getItemModel(Long id);
    public List<ItemModel> getItemList(String searchStr, List<String> categories, Integer offset);
}
