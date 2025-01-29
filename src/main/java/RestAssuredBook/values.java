package RestAssuredBook;

public class values {

    public static String enterBody() {
        return "{\r\n" +
				"  \"location\": {\r\n" +
				"    \"lat\": -38.383494,\r\n" +
				"    \"lng\": 33.427362\r\n" +
				"  },\r\n" +
				"  \"accuracy\": 50,\r\n" +
				"  \"name\": \"Rahul Shetty Academy\",\r\n" +
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
				"  \"address\": \"29, side layout, cohen 09\",\r\n" +
				"  \"types\": [\r\n" +
				"    \"shoe park\",\r\n" +
				"    \"shop\"\r\n" +
				"  ],\r\n" +
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
				"  \"language\": \"French-IN\"\r\n" +
				"}\r\n" +
				"";
    }

	public static String changeaddress(String placeId, String newAddress) {
		return "{\r\n" +
				"\"place_id\":\""+placeId+"\",\r\n" +
				"\"address\":\""+newAddress+"\",\r\n" +
				"\"key\":\"qaclick123\"\r\n" +
				"}";
	}

	public static String CoursePrice() {
		return "{\n" +
				"\n" +
				"\"dashboard\": {\n" +
				"\n" +
				"\"purchaseAmount\": 910,\n" +
				"\n" +
				"\"website\": \"rahulshettyacademy.com\"\n" +
				"\n" +
				"},\n" +
				"\n" +
				"\"courses\": [\n" +
				"\n" +
				"{\n" +
				"\n" +
				"\"title\": \"Selenium Python\",\n" +
				"\n" +
				"\"price\": 50,\n" +
				"\n" +
				"\"copies\": 6\n" +
				"\n" +
				"},\n" +
				"\n" +
				"{\n" +
				"\n" +
				"\"title\": \"Cypress\",\n" +
				"\n" +
				"\"price\": 40,\n" +
				"\n" +
				"\"copies\": 4\n" +
				"\n" +
				"},\n" +
				"\n" +
				"{\n" +
				"\n" +
				"\"title\": \"RPA\",\n" +
				"\n" +
				"\"price\": 45,\n" +
				"\n" +
				"\"copies\": 10\n" +
				"\n" +
				"}\n" +
				"\n" +
				"]\n" +
				"\n" +
				"}";
	}

	public static String EnterYourAddress(String address) {
		return "{\r\n" +
				"  \"location\": {\r\n" +
				"    \"lat\": -38.383494,\r\n" +
				"    \"lng\": 33.427362\r\n" +
				"  },\r\n" +
				"  \"accuracy\": 50,\r\n" +
				"  \"name\": \"Rahul Shetty Academy\",\r\n" +
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
				"  \"address\": \""+address+"\",\r\n" +
				"  \"types\": [\r\n" +
				"    \"shoe park\",\r\n" +
				"    \"shop\"\r\n" +
				"  ],\r\n" +
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
				"  \"language\": \"French-IN\"\r\n" +
				"}\r\n" +
				"";
	}
}
