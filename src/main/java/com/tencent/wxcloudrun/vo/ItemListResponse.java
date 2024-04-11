package com.tencent.wxcloudrun.vo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tencent.wxcloudrun.model.ItemModel;
import lombok.Data;

import java.util.List;

/**
 * @Author: 潘语笛
 * @Date: 9/4/2024 下午 9:15
 * @Description: TODO
 */
@Data
public class ItemListResponse {
    private List<ItemModel> itemList;
    private Integer firstIndex;
    private Integer lastIndex;
    private Boolean hasMore;
}
