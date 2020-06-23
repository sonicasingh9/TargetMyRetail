package com.tgt.myRetail.entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Configuration
@Document(collection = "pricing")
public class Pricing {

    @Id
    private String productId;
    private String current_price;
    private String currency_code;


    public Pricing() {}
    public Pricing(String productId, String current_price, String currency_code) {
        this.productId = productId;
        this.current_price = current_price;
        this.currency_code = currency_code;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    @Override
    public String toString() {
        return "pricingEntity{" +
                "productId='" + productId + '\'' +
                ", current_price=" + current_price +
                ", currency_code='" + currency_code + '\'' +
                '}';
    }
}
