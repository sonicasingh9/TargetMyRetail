package com.tgt.myRetail.controller;

import com.tgt.myRetail.exception.ProductNotfoundException;
import com.tgt.myRetail.model.ProductResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/products")
public class MyRetailController {

    @Autowired
    private com.tgt.myRetail.service.ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseModel> getProductsById
            (@PathVariable("id") String id) throws Exception {
        log.debug("Inside getProductsById  : " + id);

        if (id == null)
            throw new ProductNotfoundException();

        return new ResponseEntity<ProductResponseModel>(productService.getProductDetailByProductId(id), HttpStatus.OK);

    }
}
