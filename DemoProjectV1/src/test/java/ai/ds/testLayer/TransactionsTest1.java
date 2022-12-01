package ai.ds.testLayer;

import org.testng.annotations.Test;


import ai.ds.testBase.Testbase;

public class TransactionsTest1 extends Testbase {
	
	@Test
	public void getTransDetails() throws InterruptedException
	{
		dash.clickOnTransactionsLink();
		Thread.sleep(4000);
		trans.getTransactionsDetails();
	}

}
