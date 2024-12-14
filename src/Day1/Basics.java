package Day1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;  //for equal to method it is static so no auto suggestions showing

import org.testng.Assert;

import files.payload;


public class Basics {

	public static void main(String[] args) {
		//validate Add place working
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.Addplace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		//System.out.println(js.getString("place_id"));
		String placeId=js.getString("place_id");
		System.out.println(placeId);
		System.out.println(js.getString("scope"));
		
		
		
//Add place==>Update place(retreive id from above req and use it here in this)
		String Address="hamsterdam";
		
  
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+Address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		
		//Get place
		
		String getplaceinfo=given().log().all().queryParam("key", "qaclick123").queryParam("place_Id",placeId)
		.when().get("maps/api/place/get/json").then().assertThat().statusCode(200).extract()
		.response().asString();
		
		JsonPath js1=new JsonPath(getplaceinfo);
		String updatedAddress=js1.getString("address");
		System.out.println(updatedAddress);
		
		//Assert.assertEquals(Address,updatedAddress );
		
		

	}
	

}

