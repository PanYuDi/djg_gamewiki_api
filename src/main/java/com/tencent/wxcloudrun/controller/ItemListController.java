package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.ItemModel;
import com.tencent.wxcloudrun.service.ItemListService;
import com.tencent.wxcloudrun.vo.ItemListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "ItemListController", description = "item list controller")
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

    @ApiOperation("get item list")
    @GetMapping(value = "/v1/list")
    public ApiResponse<ItemListResponse> getItemList(@RequestParam(required = false) String searchStr, @RequestParam(required = false) List<String> categories, @RequestParam(defaultValue = "-1", required = false) Integer lastIndex) {
        List<ItemModel> listItems = itemListService.getItemList(searchStr, categories, lastIndex + 1);
        ItemListResponse response = new ItemListResponse();
        response.setItemList(listItems);
        response.setFirstIndex(lastIndex + 1);
        response.setLastIndex(lastIndex + 1 + listItems.size());
        return ApiResponse.ok(response);
    }

    @GetMapping(value = "/v1/category/list")
    public ApiResponse<List<String>> getCategoryList() {
        return null;
    }
}
