package com.tgt.myRetail.exception;


import com.tgt.myRetail.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception(ProductNotfoundException exception) {
        return new ResponseEntity<>(Constants.PRODUCT_NAME_NOT_AVAILABLE, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = PriceNotfoundException.class)
    public ResponseEntity<Object> exception(PriceNotfoundException exception) {
        return new ResponseEntity<>(Constants.PRICING_INFORMATION_NOT_AVAILABLE, HttpStatus.NOT_FOUND);
    }

}