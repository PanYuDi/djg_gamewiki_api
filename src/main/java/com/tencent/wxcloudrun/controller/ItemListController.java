package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.ItemModel;
import com.tencent.wxcloudrun.service.ItemListService;
import com.tencent.wxcloudrun.vo.ItemListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ApiResponse<ItemModel> getItemDetail(@PathVariable Long id) {
        ItemModel itemModel = itemListService.getItemModel(id);
        return ApiResponse.ok(itemModel);
    }

    @GetMapping(value = "/v1/list")
    public ApiResponse<ItemListResponse> getItemList(@RequestParam(required = false) String searchStr, @RequestParam(required = false) List<String> categories, @RequestParam(defaultValue = "-1", required = false) Integer lastIndex) {
        ItemListResponse itemList = itemListService.getItemList(searchStr, categories, lastIndex + 1);
        return ApiResponse.ok(itemList);
    }

    @GetMapping(value = "/v1/category/list")
    public ApiResponse<List<String>> getCategoryList() {
        return null;
    }
}
