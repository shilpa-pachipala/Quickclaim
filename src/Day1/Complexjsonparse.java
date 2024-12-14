package Day1;

import files.payload;
import io.restassured.path.json.JsonPath;

public class Complexjsonparse {

	public static void main(String[] args) {
		
		
	JsonPath js=new JsonPath(payload.courseprice());
	//print no of courses
	int count=js.getInt("courses.size()");
	System.out.println(count);
	
	//title of 1st course
	System.out.println(js.getString("courses[0].title").toString());
	
	//price of 3rd course
	
	System.out.println(js.get("courses[2].price").toString());
	
	//all courses and price
	
	for(int i=0;i<count;i++)
	{
		String titles=js.get("courses["+i+"].title");
		System.out.println(titles);
		if(titles.equalsIgnoreCase("rpa"))
		{
			int copies=js.get("courses["+i+"].copies");
			System.out.println(copies);
		}
		
	}
	}
	
	

}
