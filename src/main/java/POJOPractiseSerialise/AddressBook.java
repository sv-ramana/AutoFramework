package POJOPractiseSerialise;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddressBook {
    @Test
    public static void addressbook() {
        // Serialisation
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        AddPlace Adding = new AddPlace();
        location loc = new location();
        loc.setlat(-38.383494);
        loc.setLng(33.427362);
        Adding.setlocation(loc);
        Adding.setaccuracy(50);
        Adding.setname("Frontline house");
        Adding.setphone_number("(+91) 983 893 3937");
        Adding.setAddress("29, side layout, cohen 09");
        List<String> mylist = new ArrayList<String>();
        mylist.add("one");
        mylist.add("two");
        mylist.add("three");
        Adding.setTypes(mylist);
        Adding.setWebsite("http://google.com");
        Adding.setLauguage("French-IN");

        String Response =  given().queryParam("key", "qaclick123")
                .body(Adding)
                .when().post("maps/api/place/add/json")
                .then().statusCode(200).extract().response().asString();

        System.out.println(Response);

    }
}
