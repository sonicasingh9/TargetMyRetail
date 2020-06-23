package com.tgt.myRetail.entity;

import com.tgt.myRetail.model.PriceDataModel;

import com.tgt.myRetail.exception.PriceNotfoundException;
import com.tgt.myRetail.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class ProductDao {

    @Autowired
    private PricingRepository pricingRepository;
    @Autowired
    private Pricing pricing;


    public PriceDataModel getPricingDataByProductId(String id) throws PriceNotfoundException {

        PriceDataModel priceData = new PriceDataModel();
        pricing = pricingRepository.findByProductId(id);

        if(pricing !=null) {
            priceData.setId(id);
            priceData.setCurrency_code(pricing.getCurrency_code());
            priceData.setValue(pricing.getCurrent_price());
        }
        return priceData;

    }

}
