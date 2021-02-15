package tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class ApiClient {

    String baseURL = "http://conduit.productionready.io";
    List<String> getFilters(){
        return  given()
                .when().get(baseURL + "/api/tags")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().getList("tags");
    }
     Response checkFilters(String filterName){
        return  given()//.log().all()
                .queryParam("limit", 10)
                .queryParam("offset", 0)
                .queryParam("tag", filterName)
                .when().get(baseURL + "/api/articles")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
