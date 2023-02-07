package com.imooc.entity;


public class GoodsDetail {

  private long gdId;
  private long goodsId;
  private String gdPicUrl;
  private long gdOrder;


  public long getGdId() {
    return gdId;
  }

  public void setGdId(long gdId) {
    this.gdId = gdId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public String getGdPicUrl() {
    return gdPicUrl;
  }

  public void setGdPicUrl(String gdPicUrl) {
    this.gdPicUrl = gdPicUrl;
  }


  public long getGdOrder() {
    return gdOrder;
  }

  public void setGdOrder(long gdOrder) {
    this.gdOrder = gdOrder;
  }

}
