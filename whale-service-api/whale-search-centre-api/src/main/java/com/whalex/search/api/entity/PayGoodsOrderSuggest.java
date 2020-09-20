package com.whalex.search.api.entity;

/**
 * @description: 搜索建议
 * @author: 🐋鲸鱼
 * @date: 2020/9/12
 */
public class PayGoodsOrderSuggest {
    private String input;
    private int weight = 10; // 默认权重

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
