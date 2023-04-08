package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class LandingPageObject {
	
	
	private static final Logger logger= LogManager.getLogger(LandingPageObject.class);
	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	
	
	//============= Locators for WebElements on Landing page============================================//

		//private By logoImage= By.xpath("//img[@title='Automation Practice Site']");
		//private By prodCatgory= By.xpath("//div[@id='woocommerce_product_categories-2']/ul/li");
		
	//============= Expected Results ====================================================================//
		
		String expCurrentURL= "https://www.candere.com/majestic-solitaire-diamond-ring.html";
		
	//============= Constructor ========================================================================//
		public LandingPageObject (WebDriver driver,Scenario scn)
		{
			this.driver= driver;
			this.scn=scn;
		}
		
	//============ 1. Method to validate page URL =======================================================//
		public void validatePageURL()
		{
			wait= new WebDriverWait(driver,20);
			boolean a = wait.until(ExpectedConditions.urlToBe(expCurrentURL));
			Assert.assertEquals(true,a);
		    logger.info("Validate current URL of page ,so URL is: "+ driver.getCurrentUrl());
		}
		
	

}
