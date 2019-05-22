package com.dionysus.stydyinbook.jsonparse.json.bean;

/**
 * @className: ShopInfo
 * @author: Dionysus
 * @date: 2019/5/21 1:09
 * @Description: Json的Bean类
 */
public class ShopInfo {
    private int id;
    private String name;
    private Double price;
    private String imagePath;

    public ShopInfo() {
    }

    public ShopInfo(int id, String name, Double price, String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
