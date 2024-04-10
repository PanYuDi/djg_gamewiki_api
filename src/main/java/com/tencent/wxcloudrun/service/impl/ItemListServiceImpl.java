package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ItemModelMapper;
import com.tencent.wxcloudrun.model.ItemModel;
import com.tencent.wxcloudrun.service.ItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ItemModel> getItemList(String searchStr, List<String> categories, Integer lastIndex) {
        List<ItemModel> itemList = itemModelMapper.getItemList(searchStr, categories, lastIndex);
        return itemList;
    }
}
