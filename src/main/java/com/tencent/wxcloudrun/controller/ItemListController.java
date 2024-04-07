package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.ItemModel;
import com.tencent.wxcloudrun.service.ItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 潘语笛
 * @Date: 31/3/2024 下午 9:47
 * @Description: TODO
 */
@RestController
public class ItemListController {
    final ItemListService itemListService;
    public ItemListController(@Autowired ItemListService itemListService) {

        this.itemListService = itemListService;
    }

    @GetMapping(value = "/v1/detail/{id}")
    public ApiResponse getItemDetail(@PathVariable Long id) {
        ItemModel itemModel = itemListService.getItemModel(id);
        return ApiResponse.ok(itemModel);
    }
}
