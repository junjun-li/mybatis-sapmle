package com.imooc.dto;

import com.imooc.entity.Category;
import com.imooc.entity.Goods;

public class GoodsDTO {
    private Goods goods = new Goods();
    private Category Category = new Category();
    private String test;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public com.imooc.entity.Category getCategory() {
        return Category;
    }

    public void setCategory(com.imooc.entity.Category category) {
        Category = category;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
