/**
 * @author SS
 */
package com.tgt.myRetail.service;

import com.tgt.myRetail.constants.Constants;
import com.tgt.myRetail.entity.ProductDao;
import com.tgt.myRetail.model.PriceDataModel;
import com.tgt.myRetail.model.ProductResponseModel;
import com.tgt.myRetail.rpc.remoteClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @author SS
 */

@Component
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    public ProductResponseModel getProductDetailByProductId(String id) {

        PriceDataModel priceData = new PriceDataModel();
        ProductResponseModel productResponse = new ProductResponseModel();

        //Fetch product names from redsky
        String productName = getProductNameByID(id);

        log.debug("Product Name for Product Id  : " + productName + " - " + id);

        //Fetch pricing data from DB
        priceData = productDao.getPricingDataByProductId(id);

        productResponse.setId(id);
        productResponse.setName(productName);

        productResponse.setCurrent_price(priceData);
        log.debug("Product Response for Product Id " + productResponse.toString() + " - " + id);
        return productResponse;
    }

    private String getProductNameByID(String id) {

        Object response = remoteClient.redSkyAPICall(id);
        if (null != response) {
            try {
                JSONObject jsonObject = new JSONObject((String) response);
                String productDescription = jsonObject.getJSONObject(Constants.PRODUCT).
                        getJSONObject(Constants.ITEM).
                        getJSONObject(Constants.PRODUCT_DESCRIPTION).
                        getString(Constants.TITLE);

                return productDescription;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
