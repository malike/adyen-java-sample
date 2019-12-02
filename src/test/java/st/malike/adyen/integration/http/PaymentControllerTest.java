/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.malike.adyen.integration.http;

import com.google.gson.Gson;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import st.malike.adyen.integration.util.Enums;
import st.malike.adyen.integration.PaymentIntegrationMain;

/**
 * @author malike_st
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = PaymentIntegrationMain.class)
@SpringBootTest
@Ignore
public class PaymentControllerTest {

  Map data;
  @Autowired
  private PaymentController paymentController;

  @Before
  public void setUp() throws Exception {

    data = new HashMap<>();

    RestAssuredMockMvc.standaloneSetup(paymentController);

  }

  @Test
  public void testListPaymentOptions() {

    RestAssuredMockMvc.given()
        .log().all().contentType("application/json")
        .body(new Gson().toJson(data))
        .when()
        .post("/payment/options")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("status", Matchers.is(true))
        .body("message", Matchers.is(Enums.JSONResponseMessage.SUCCESS.toString()));
  }

  @Test
  public void testListPaymentCreate() {

    RestAssuredMockMvc.given()
        .log().all().contentType("application/json")
        .body(new Gson().toJson(data))
        .when()
        .post("/payment/create/invoice")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("status", Matchers.is(true))
        .body("message", Matchers.is(Enums.JSONResponseMessage.SUCCESS.toString()));
  }

  @Test
  public void testCheckStatusOfPayment() {

    RestAssuredMockMvc.given()
        .log().all().contentType("application/json")
        .body(new Gson().toJson(data))
        .when()
        .post("/payment/checkstatus")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("status", Matchers.is(true))
        .body("message", Matchers.is(Enums.JSONResponseMessage.SUCCESS.toString()));
  }

  @Test
  public void testConfirmPayment() {

    RestAssuredMockMvc.given()
        .log().all().contentType("application/json")
        .body(new Gson().toJson(data))
        .when()
        .post("/payment/checkstatus")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("status", Matchers.is(true))
        .body("message", Matchers.is(Enums.JSONResponseMessage.SUCCESS.toString()));
  }

  @Test
  public void testCancelPayment() {

    RestAssuredMockMvc.given()
        .log().all().contentType("application/json")
        .body(new Gson().toJson(data))
        .when()
        .post("/payment/checkstatus")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("status", Matchers.is(true))
        .body("message", Matchers.is(Enums.JSONResponseMessage.SUCCESS.toString()));
  }

}