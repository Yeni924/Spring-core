package com.example.core.order;

public class Order {

    private Long memberId;
    private String itemNme;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itemNme, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemNme = itemNme;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemNme() {
        return itemNme;
    }

    public void setItemNme(String itemNme) {
        this.itemNme = itemNme;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemNme='" + itemNme + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
