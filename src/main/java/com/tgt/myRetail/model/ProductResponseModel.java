package com.tgt.myRetail.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ProductResponseModel {

    private String id;
    private String name;
    private PriceDataModel current_price;

    public ProductResponseModel()
    {}

    public ProductResponseModel(String id, String name, PriceDataModel current_price) {
        this.id = id;
        this.name = name;
        this.current_price = current_price;
    }
}
