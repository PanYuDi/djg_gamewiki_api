package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ItemModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 潘语笛
 * @Date: 10/4/2024 上午 9:04
 * @Description: TODO
 */
@SpringBootTest
public class ItemListServiceTest {
    @Autowired
    ItemListService itemListService;

    @Test
    public void testGetItemList() {
        List<ItemModel> itemList = itemListService.getItemList("", new ArrayList<>(), 0);
        System.out.println(itemList);

    }
}
