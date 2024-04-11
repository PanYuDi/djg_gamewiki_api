package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ItemModel;
import com.tencent.wxcloudrun.vo.ItemListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 潘语笛
 * @Date: 31/3/2024 下午 9:48
 * @Description: TODO
 */
public interface ItemListService {
    public ItemModel getItemModel(Long id);
    public ItemListResponse getItemList(String searchStr, List<String> categories, Integer offset);
}
