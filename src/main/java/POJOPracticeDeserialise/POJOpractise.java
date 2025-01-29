package POJOPracticeDeserialise;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POJOpractise {

    @Test
    public static void PojoPractice() {
       // RestAssured.baseURI = "https://rahulshettyacademy.com/";

//        // serialisation
//        GetCources getCources = new GetCources();
//        getCources.setInstructor("venkat");
//        getCources.setUrl("venkataramana.ezyro.com");
//        getCources.setExpertise("Java");
//        getCources.setServices("Software Testing");

        // deserilaisation
        //post
        String response = given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParams("grant_type", "client_credentials")
                .formParams("scope","trust")
                .when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .then().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(response);
        String accessToken = js.get("access_token");
        //get
        GetCources gc = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
                .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .as(GetCources.class);

        System.out.println(gc.getInstructor());
        System.out.println(gc.getCourses().getWebAutomation().size());
        System.out.println(gc.getCourses().getMobile().get(0).getourseTitle());



    }
}
