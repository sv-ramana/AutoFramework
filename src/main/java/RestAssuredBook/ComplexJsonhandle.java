package RestAssuredBook;

import io.restassured.path.json.JsonPath;

public class ComplexJsonhandle {
    public static void main(String [] args) {
        JsonPath js2 = new JsonPath(values.CoursePrice());
    //        1. Print No of courses returned by API
        int val1 = js2.get("courses.size()");
        System.out.println(val1);
    //        2.Print Purchase Amount
        int val2 = js2.get("dashboard.purchaseAmount");
        System.out.println(val2);
    //        3. Print Title of the first course
        String val3;
        for (int i = 0; i < val1; i++) {
            val3 = js2.getString("courses["+i+"].title");
            System.out.println(val3);
        }
    //        4. Print All course titles and their respective Prices
        String val4;
        int val5;
        int val6;
        int val7 = 0;
        for (int j = 0; j < val1; j++) {
            val4 = js2.getString("courses["+j+"].title");
            val5 = js2.getInt("courses["+j+"].price");
            System.out.println("course : " + val4 + " its price is " + val5 );
    //        5. Print no of copies sold by RPA Course
            val6 = js2.getInt("courses[" + j + "].copies");
            if (val4.equals("RPA")) {
                System.out.println("No of copies for RPA : " + val6);
            }
    //        6. Verify if Sum of all Course prices matches with Purchase Amount
            val7 = val7 + val6 * val5;
        }

        System.out.println(val7);
        if (val2 == val7) {
           System.out.println("Matched");
        } else {
            System.out.println("Not Matched");
        }

    }


}
