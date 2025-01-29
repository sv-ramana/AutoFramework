package EcommersAutomate;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth;

public class Main {

    @Test
    public static void EcommersSite() {
        // login
       RequestSpecification reqLoginorder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
       loginDetails ld = new loginDetails();
       ld.setUserEmail("svramana122@gmail.com");
       ld.setUserPassword("Venkat@123");
       RequestSpecification regLoginenter = given().spec(reqLoginorder).body(ld);
       Loginresponse Loginresponses = regLoginenter.when().post("/api/ecom/auth/login")
               .then().extract().response().as(Loginresponse.class);
       String tokenVal = Loginresponses.getToken();
       String userID = Loginresponses.getUserId();


       // CAdd product
        RequestSpecification reqAddproduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization", tokenVal).build();
        RequestSpecification reqcreate = given().spec(reqAddproduct).param("productName", "bigshirt").param("productAddedBy", userID)
                .param("productCategory", "fashion").param("productSubCategory", "Shirt")
                .param("productPrice", "11500").param("productDescription", "Addias Originals")
                .param("productFor", "Women").multiPart("productImage", new File("C://Users//sanapven//Downloads//images.jpeg"));
        String getCreateOrder = reqcreate.when().post("/api/ecom/product/add-product")
                .then().extract().response().asString();
        JsonPath js1 = new JsonPath(getCreateOrder);
        String productId = js1.get("productId");

        // Create order
        RequestSpecification reqCreateOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization", tokenVal).setContentType(ContentType.JSON).build();

        orderInfo orderinfo =new orderInfo();
        orderinfo.setCountry("British Indian Ocean Territory");
        orderinfo.setProductOrderedId(productId);

        List<orderInfo> mylist = new ArrayList<>();
        mylist.add(orderinfo);

        orders orders = new orders();
        orders.setOrders(mylist);

        RequestSpecification reqcreatecmd = given().spec(reqCreateOrder).body(orders);

        String createdOrder = reqcreatecmd.when().post("/api/ecom/order/create-order").then().extract().response().asString();
        JsonPath js2 = new JsonPath(createdOrder);
        String message = js2.get("message");
        System.out.println(message);

        // Delete Order
        given().spec(reqAddproduct).pathParam("productId", productId)
                .when().delete("/api/ecom/product/delete-product/{productId}")
                .then().extract().response();

    }
}
