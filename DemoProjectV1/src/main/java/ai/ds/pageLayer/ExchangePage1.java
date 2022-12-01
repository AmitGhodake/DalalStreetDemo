package ai.ds.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import ai.ds.testBase.Testbase;

public class ExchangePage1 extends Testbase {
	
	public ExchangePage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	//-------------- Obj repo -------------
	@FindBy(xpath="//a[contains(text(),'Buy')]")
	private WebElement buy_btn1;
	
	@FindBy(xpath="//input[@name='input-Qunatity']")
	private WebElement quantity_txt;
	
	@FindBy(xpath="//button[contains(text(),'Buy')]")
	private WebElement buy_btn2;
	
	@FindBy(xpath="//div[text()='Order Created successfully']")
	private WebElement status_msg;
	
	// ------------- action methods---------
	public void clickOnBuyButton1()
	{
		buy_btn1.click();
	}
	
	public void enterQuantityOfShare(String count)
	{
		quantity_txt.click();
		quantity_txt.sendKeys(count);
	}
	
	public void clickOnBuyButton2()
	{
		buy_btn2.click();
	}
	
	public String getStatus()
	{
		String text = status_msg.getText();
		return text;
	}

}
