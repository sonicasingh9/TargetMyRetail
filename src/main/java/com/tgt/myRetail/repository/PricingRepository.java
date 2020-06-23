package com.tgt.myRetail.repository;

import com.tgt.myRetail.entity.Pricing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PricingRepository extends MongoRepository <Pricing, String >{

    Pricing findByProductId(String productId);
}
