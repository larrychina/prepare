package org.larry.design.flyweight;

import java.util.Random;

public class SearchTicket {

    private String from ;
    private String to ;
    private int price ;

    public SearchTicket(String from, String to) {
        this.from = from;
        this.to = to;
        this.price = new Random().nextInt(100);
    }

    /**
     * 展示价格
     */
    public void showPrice(){
        System.out.println(String.format("从 %s 站 到 %s 站的票价为：%s",from,to,price));
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
