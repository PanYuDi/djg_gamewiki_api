package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ItemModelMapper;
import com.tencent.wxcloudrun.model.ItemModel;
import com.tencent.wxcloudrun.service.ItemListService;
import com.tencent.wxcloudrun.vo.ItemListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 潘语笛
 * @Date: 31/3/2024 下午 9:48
 * @Description: TODO
 */
@Service
public class ItemListServiceImpl implements ItemListService {
    final ItemModelMapper itemModelMapper;
    public ItemListServiceImpl(@Autowired ItemModelMapper itemModelMapper) {
        this.itemModelMapper = itemModelMapper;
    }
    @Override
    public ItemModel getItemModel(Long id) {
        return itemModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public ItemListResponse getItemList(String searchStr, List<String> categories, Integer offset) {
        List<ItemModel> itemList = itemModelMapper.getItemList(searchStr, categories, offset);
        ItemListResponse response = new ItemListResponse();
        response.setItemList(itemList);
        response.setItemList(itemList);
        response.setFirstIndex(offset);
        response.setLastIndex(offset + itemList.size());
        Integer totalCount = itemModelMapper.getTotalCount(searchStr, categories);
        response.setHasMore(itemList.size() + offset < totalCount);
        response.setCategories(this.getCategories());
        return response;
    }

    private List<String> getCategories() {
        return Arrays.asList(
                "武器",
                "护符",
                "防具",
                "物品",
                "法术",
                "战灰"
        );
    }
}
