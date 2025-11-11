package com.example.order.steps;

import com.example.order.model.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
public class StepDefinitions {

    @LocalServerPort
    private String port;
    private String jsonBody;
    private Order order;

    @Given("the system knows about the following orders:")
    public void the_system_knows_about_the_following_orders(List<Map<String, String>> orders) {
        // Setup initial data state
        System.out.println("my steps hereerreree" + port);
    }

    @Then("make an GET call")
    public void makeAnGETCall() {
        RequestSpecification request = given();

        request.when()
                .get("http://localhost:"+port+"/orders").then().statusCode(200);
        System.out.println("done GET");
    }

    @Given("create valid order")
    public void createValidOrder() {
        jsonBody= """
                {
                  "customerName": "bb",
                  "orderStatus": "PENDING",
                  "localDateTime": "2023-10-01T12:00:00",
                  "orderItemsList": [
                    {
                      "itemId": 101,
                      "productName": "Widget A",
                      "quantity": 2,
                      "price": 19.99
                    },
                    {
                      "productId": 102,
                      "productName": "Widget B",
                      "quantity": 1,
                      "price": 11
                    }
                  ]
                }
                """;
    }

    @Then("make an POST call")
    public void makeAnPOSTCall() {
        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .body(jsonBody);

        Order myOrder = request.when()
                .post("http://localhost:" + port + "/orders")
                .then()
                .statusCode(201).extract().as(Order.class);
        System.out.println("Order created successfully:"+ myOrder.getId());
        order = myOrder;
    }

    @Then("check order created in database successfully")
    public void checkOrderCreatedInDatabaseSuccessfully() {
        System.out.println("here");
        assertThat(order.getId()).isNotNull();
    }
}
