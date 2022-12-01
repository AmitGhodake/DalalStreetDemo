package ai.ds.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;



import ai.ds.testBase.Testbase;

public class BuyFunctionality1 extends Testbase {
	
	
	

	@Test 
	public void verifyBuyFunctionalityWipro() throws InterruptedException
	{
		String Expected_Status_msg = "Order Created successfuy";
		dash.enterCompanyName("Wipro");
		dash.clickOnCompanyOption();
		Thread.sleep(3000);
		//---------------------------------
		exchange.clickOnBuyButton1();
		exchange.enterQuantityOfShare("2");
		exchange.clickOnBuyButton2();
		Thread.sleep(2000);
		System.out.println(exchange.getStatus());
		Assert.assertEquals(exchange.getStatus(), Expected_Status_msg);
		
	}
	
	@Test 
	public void verifyBuyFunctionalityAxis() throws InterruptedException
	{
		String Expected_Status_msg = "Order Created successfully";
		dash.enterCompanyName("Axis");
		dash.clickOnCompanyOption();
		Thread.sleep(3000);
		//---------------------------------
		exchange.clickOnBuyButton1();
		exchange.enterQuantityOfShare("2");
		exchange.clickOnBuyButton2();
		Thread.sleep(2000);
		System.out.println(exchange.getStatus());
		Assert.assertEquals(exchange.getStatus(), Expected_Status_msg);
		
	}

}
