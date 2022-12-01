package ai.ds.testBase;

import java.time.Duration;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



import ai.ds.pageLayer.DashboardPage1;
import ai.ds.pageLayer.ExchangePage1;
import ai.ds.pageLayer.LoginPage1;
import ai.ds.pageLayer.TransactionsPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	public LoginPage1 login;
	public DashboardPage1 dash;
	public ExchangePage1 exchange;
	public TransactionsPage1 trans;
	
	
	
	@BeforeClass
	public void start()
	{
		 logger = Logger.getLogger("DalalStreet Auto framework");
		 PropertyConfigurator.configure("log4j.properties");
		 
		 logger.info("framework execution started");
	}
	
	@AfterClass
	public void end()
	{
		logger.info("framework execution completed");
	}
	
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws InterruptedException        // String br = "chrome"
	{
		if(br.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please provide correct browser");
		}
		
		driver.get("https://www.apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("url launches, maximize, and provided waits");
		//--------- Object Creation ------------------
		login = new LoginPage1();
		dash = new DashboardPage1();
		exchange = new ExchangePage1();
		trans = new TransactionsPage1();
		logger.info("Object Creation");
		
		//---------- Login steps -----------
		login.enterEmailID("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLoginButton();
		Thread.sleep(3000);
		logger.info("login successfully");
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}

}
