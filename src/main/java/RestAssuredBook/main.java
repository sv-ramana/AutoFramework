package RestAssuredBook;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class main {
    public static void main(String [] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //given - all the details as per the contract
        //when - submit with request post get put delete
        //then - return the response and validate

        String response = given().queryParam("key", "qaclick123").header("Contract-Type", "application/json")
                .body(values.enterBody()).when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        System.out.println(response);

        // validate scope id now
        JsonPath js = new JsonPath(response);
        String scopeval = js.getString("scope");
        if (scopeval.equals("APP")) {
            System.out.println("matched success");
        } else {
            System.out.println("Not matched");
        }

        //Update Place
        String newAddress = "Summer Walk, Africa";
        String placeId = js.getString("place_id");

        given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(values.changeaddress(placeId, newAddress))
                .when().put("maps/api/place/update/json")
                .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

        // get the details with place id

        String GetDetails = given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js1 = new JsonPath(GetDetails);
        String Getdetailsof = js1.getString("address");
        System.out.println(Getdetailsof);
        Assert.assertEquals(Getdetailsof, newAddress);
    }
}
