package RestAssuredBook;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class differentAddress {
    @Test(dataProvider = "addressdata")
    public static void RunLibraryAPi(String address) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // post
        String responsePost = given().queryParam("key", "qaclick123").header("Contract-Type", "application/json")
                .body(values.EnterYourAddress(address)).when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        JsonPath js3 = new JsonPath(responsePost);
        String placeId = js3.get("place_id");
        //get 
        String GetDetails = given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js1 = new JsonPath(GetDetails);
        String Getdetailsof = js1.getString("address");
        System.out.println(Getdetailsof);

    }

    @DataProvider(name = "addressdata")
        public static Object[][] enterdata() {
        return new Object[][] {{"1 main road"},{"2 main road"}, {"3 main road"}};
        }
}
