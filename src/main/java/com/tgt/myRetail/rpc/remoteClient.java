package com.tgt.myRetail.rpc;

import com.tgt.myRetail.constants.Constants;
import com.tgt.myRetail.exception.ProductNotfoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class remoteClient {

    public static String redSkyAPICall(String id) {

        StringBuilder redskyUrl = new StringBuilder();

        redskyUrl.append(Constants.REDSKY_URL);
        redskyUrl.append(id);
        redskyUrl.append(Constants.REDSKY_EXCLUDES);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.getForObject(redskyUrl.toString(), String.class);

        } catch (Exception ex) {
            log.info(Constants.PRODUCT_NAME_NOT_AVAILABLE + " - " + id);
            return null;
        }
    }
}

