package Day1;
import org.testng.annotations.*;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class DynamicJson {
	@Test
	public void addbook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json")
		.body(payload.AddBook("asdasd","4152"))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String id=js.getString("ID");
		System.out.println(id); 
		
		
		
	}
	

}
