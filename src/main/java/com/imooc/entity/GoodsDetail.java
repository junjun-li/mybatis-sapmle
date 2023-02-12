package com.imooc.entity;


public class GoodsDetail {
  private Integer gdId;
  private Integer goodsId;
  private String gdPicUrl;
  private Integer gdOrder;
  private Goods goods;

  public Integer getGdId() {
    return gdId;
  }

  public void setGdId(Integer gdId) {
    this.gdId = gdId;
  }


  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
  }


  public String getGdPicUrl() {
    return gdPicUrl;
  }

  public void setGdPicUrl(String gdPicUrl) {
    this.gdPicUrl = gdPicUrl;
  }


  public Integer getGdOrder() {
    return gdOrder;
  }

  public void setGdOrder(Integer gdOrder) {
    this.gdOrder = gdOrder;
  }

  public Goods getGoods() {
    return goods;
  }

  public void setGoods(Goods goods) {
    this.goods = goods;
  }

  @Override
  public String toString() {
    return "GoodsDetail{" +
        "gdId=" + gdId +
        ", goodsId=" + goodsId +
        ", gdPicUrl='" + gdPicUrl + '\'' +
        ", gdOrder=" + gdOrder +
        '}';
  }
}
