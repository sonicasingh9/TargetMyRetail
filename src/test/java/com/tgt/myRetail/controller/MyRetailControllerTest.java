package com.tgt.myRetail.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyRetailControllerTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void authenticationPassTest() throws Exception {

        String url = "/products/13860428";
        given().auth().basic("admin", "admin").when().get(url).then().statusCode(200);

    }

    @Test
    public void authenticationFailTest() throws Exception {

        String url = "/products/13860428";
        given().auth().basic("admin", "wrong").when().get(url).then().statusCode(401);

    }


}
