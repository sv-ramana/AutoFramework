package RequirmentSpecBuilder;

import RestAssuredBook.values;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class sampleReq {

    @Test
    public static void checkSpecBuilder() {
        RequestSpecification Request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
        ResponseSpecification Response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        String responsePost = given().spec(Request).queryParam("key", "qaclick123")
                .body(values.EnterYourAddress("address")).when().post("maps/api/place/add/json")
                .then().assertThat().spec(Response).header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        JsonPath js3 = new JsonPath(responsePost);
        String placeId = js3.get("place_id");
    }
}
