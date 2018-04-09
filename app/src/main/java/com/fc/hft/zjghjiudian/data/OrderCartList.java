package com.fc.hft.zjghjiudian.data;

import java.util.List;

/**
 * Created by 邹柳钦 on 2018/3/18.
 */

public class OrderCartList {

    @Override
    public String toString() {
        return "OrderCartList{" +
                "ProductsName='" + ProductsName + '\'' +
                ", ImgPath='" + ImgPath + '\'' +
                ", ProductsPriceX='" + ProductsPriceX + '\'' +
                ", ProductsWebTotal='" + ProductsWebTotal + '\'' +
                ", ProductsPriceY='" + ProductsPriceY + '\'' +
                ", ProductsWeight='" + ProductsWeight + '\'' +
                ", OwnerID='" + OwnerID + '\'' +
                ", ProductsIsShipping=" + ProductsIsShipping +
                ", Qty='" + Qty + '\'' +
                ", spec_list='" + spec_list + '\'' +
                ", Property=" + Property +
                '}';
    }

    /**
     * ProductsName  : 豪华大床房
     * ImgPath  : /uploadfiles/biz/1/image/5aa0994387.jpg
     * ProductsPriceX  : 680.00
     * ProductsWebTotal  : 34.00
     * ProductsPriceY  : 780.00
     * ProductsWeight  : 0.00
     * OwnerID  : 2
     * ProductsIsShipping  : 0
     * Qty  : 1
     * spec_list  :
     * Property  : []
     */

    private String ProductsName;
    private String ImgPath;
    private String ProductsPriceX;
    private String ProductsWebTotal;
    private String ProductsPriceY;
    private String ProductsWeight;
    private String OwnerID;
    private int ProductsIsShipping;
    private String Qty;
    private String spec_list;
    private List<?> Property;

    public String getProductsName() {
        return ProductsName;
    }

    public void setProductsName(String ProductsName) {
        this.ProductsName = ProductsName;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }

    public String getProductsPriceX() {
        return ProductsPriceX;
    }

    public void setProductsPriceX(String ProductsPriceX) {
        this.ProductsPriceX = ProductsPriceX;
    }

    public String getProductsWebTotal() {
        return ProductsWebTotal;
    }

    public void setProductsWebTotal(String ProductsWebTotal) {
        this.ProductsWebTotal = ProductsWebTotal;
    }

    public String getProductsPriceY() {
        return ProductsPriceY;
    }

    public void setProductsPriceY(String ProductsPriceY) {
        this.ProductsPriceY = ProductsPriceY;
    }

    public String getProductsWeight() {
        return ProductsWeight;
    }

    public void setProductsWeight(String ProductsWeight) {
        this.ProductsWeight = ProductsWeight;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String OwnerID) {
        this.OwnerID = OwnerID;
    }

    public int getProductsIsShipping() {
        return ProductsIsShipping;
    }

    public void setProductsIsShipping(int ProductsIsShipping) {
        this.ProductsIsShipping = ProductsIsShipping;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String Qty) {
        this.Qty = Qty;
    }

    public String getSpec_list() {
        return spec_list;
    }

    public void setSpec_list(String spec_list) {
        this.spec_list = spec_list;
    }

    public List<?> getProperty() {
        return Property;
    }

    public void setProperty(List<?> Property) {
        this.Property = Property;
    }
}
