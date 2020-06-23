package com.tgt.myRetail.service;

import com.tgt.myRetail.entity.Pricing;
import com.tgt.myRetail.model.PriceDataModel;
import com.tgt.myRetail.model.ProductResponseModel;
import com.tgt.myRetail.repository.PricingRepository;
import com.tgt.myRetail.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
class ProductServiceTest {

    @Mock
    private ProductService productService;

    @Mock
    private PricingRepository pricingRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProductDetailByProductIdTest() throws Exception {

        ProductResponseModel productResponseModel = new ProductResponseModel();

        productResponseModel.setId("13860428");
        productResponseModel.setName("The Big Lebowski (Blu-ray)");
        PriceDataModel priceDataModel = new PriceDataModel();
        priceDataModel.setCurrency_code("USD");
        priceDataModel.setValue("12.4");

        productResponseModel.setCurrent_price(priceDataModel);


        Mockito.when(productService.getProductDetailByProductId(Mockito.anyString())).thenReturn(productResponseModel);

        //Actual
        ProductResponseModel actualProduct = productService.getProductDetailByProductId("13860428");

        // Expected
        assertEquals("The Big Lebowski (Blu-ray)", actualProduct.getName());
        assertEquals("13860428", actualProduct.getId());
        assertEquals("USD", actualProduct.getCurrent_price().getCurrency_code());
        assertEquals("12.4", actualProduct.getCurrent_price().getValue());

    }


    @org.junit.Test(expected = NullPointerException.class)
    @Test
    public void getProductInfoTest_wrongProductId() throws Exception {

        ProductResponseModel productResponseModel = new ProductResponseModel();

        productResponseModel.setId("13860428");
        productResponseModel.setName("The Big Lebowski (Blu-ray)");
        PriceDataModel priceDataModel = new PriceDataModel();
        priceDataModel.setCurrency_code("USD");
        priceDataModel.setValue("12.4");

        productResponseModel.setCurrent_price(priceDataModel);

        Pricing mockPricing = new Pricing("13860428", "USD", "12.3");

        Mockito.when(pricingRepository.findByProductId(Mockito.anyString())).thenReturn(mockPricing);

        productService.getProductDetailByProductId("138604");
    }

}
