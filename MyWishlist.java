package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class MyWishlist {
	
	
	private static final Logger logger= LogManager.getLogger(MyWishlist.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
//============= Locators for WebElements for SignIn activity =========================================//

	private By mywishlist= By.xpath("//img[@alt='wishlist']");

//============= Constructor ========================================================================//
	public MyWishlist (WebDriver driver,Scenario scn)
	{
		this.driver= driver;
		this.scn=scn;
	}

	
	//============ 1. Method to validate Mywishlisticon =================================================//
	   public void MywishlisticonValidation()
	   {
	   	WebElement icon =driver.findElement(mywishlist);
	   	Assert.assertEquals(true,icon.isDisplayed());
	   	logger.info("Validate the Mywishlist icon");
	   	scn.log("Validate the Mywishlist icon");
	   }
	    
	//============ 2. Method to click on Mywishlisticon =================================================//
	   public void clickOnMywishlisticon()
	   {
	   	
	   	WebElement icon =driver.findElement(mywishlist);
	   	wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(icon));
	   	icon.click();
	 	logger.info("Click on the Mywishlist icon");
	    	scn.log("Click on the Mywishlist icon");
	   }
	   
	   
	 //---------=====3. Method to validate MyWishlistpage title =============================================//
	   public void validateMyWishlistpage(String Mywishlisticon)
	   {
	   	wait= new WebDriverWait(driver,20);
	   	boolean xyz = wait.until(ExpectedConditions.titleIs(Mywishlisticon));
	        Assert.assertEquals(true, xyz);
	    	logger.info("Validate title of Mywishlisticon, so title is: "+ Mywishlisticon);
	    	scn.log("Validate title of Mywishlisticon, so title is: "+ Mywishlisticon);   }
	      
	      
}
