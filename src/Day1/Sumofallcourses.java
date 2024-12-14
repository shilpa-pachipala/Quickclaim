package Day1;

import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class Sumofallcourses {
public static void main(String[] args) {
	
	int sum=0;
	
	JsonPath js=new JsonPath(payload.courseprice());
	int count =js.getInt("courses.size()");
			
for(int i=0;i<count;i++)
{
	 int copies=js.get("courses["+i+"].copies");
	 int prices=js.getInt("courses["+i+"].price");
	 int amount= copies*prices;
	 System.out.println(amount);
	 sum=sum+amount;
	 
	 
}
System.out.println(sum);
int purchasers=js.getInt("dashboard.purchaseAmount");
Assert.assertEquals(sum, purchasers);
}
}
