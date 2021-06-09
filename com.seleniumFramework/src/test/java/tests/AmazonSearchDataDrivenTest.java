package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class AmazonSearchDataDrivenTest {
	
	
  @Test(dataProvider = "myDataBucket")
  public void test(String input) {
	  System.out.println(input);
  }
  
  
  @DataProvider
  public String[] myDataBucket() {
	  String[] mydata = new String[5];
	  mydata[0] = "coffee mug";
	  mydata[1] = "pretty coffee mug";
	  mydata[2] = "cool coffee mug";
	  mydata[3] = "cute coffee mug";
	  mydata[4] = "ugly coffee mug";
	  
	  return mydata;
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
