package StepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Core.WebDriverFactory;

import PageObject.LandingPageObject;
import PageObject.MyWishlist;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stefdef {

	
		private static final Logger logger=LogManager.getLogger(Stefdef.class);
		
		//private static final Logger logger = LogManager.getLogger(StepDefination.class);
		WebDriver driver;
		Scenario scn;   //variable scn
		String base_url = "https://www.candere.com/majestic-solitaire-diamond-ring.html";

		//============== Declare object reference of pageObjects classes =============================//
		
		LandingPageObject landingPageObject;
		MyWishlist mywishlistObject;
		//LoginPageObjects loginPageObject
		
		//====================== Before Hook =========================================================//	
		@Before
		public void setUp(Scenario scn)//Parameterize Scn
		{
			this.scn=scn;

			//Get the desired browser to be invoked
			String browserName= WebDriverFactory.getBrowserName();
			driver=WebDriverFactory.getWebDriverForBrowser(browserName); 
			scn.log("Browser get invoked");// this is occure in report not on console

			//Initialize object of page objects classes 
			landingPageObject = new LandingPageObject(driver, scn);
			mywishlistObject = new MyWishlist(driver, scn);
		
		}

	//====================== After Hook =========================================================//
		
		@After(order=2)
		//Capture screenshot if test case get failed
		public void captureScreenshot(Scenario scn)
		{
			if(scn.isFailed())
			{
				TakesScreenshot srnshot= ((TakesScreenshot)driver);
				byte [] data =srnshot.getScreenshotAs(OutputType.BYTES);
				scn.attach(data, "image/png", "Name of failed step is: "+ scn.getName());
				scn.log("Attach a screenshot as step get failed");
			}
			else
			{
				scn.log("Test case get passed, no screenshot is captured");
			}
		}
		
		@After(order=1)
		//Quit the browser
		public void tearDown(Scenario scn)
		{
			WebDriverFactory.quitTheBrowser();
			scn.log("Browser is quit");
		}
		
	//====================== Background ================================================//
		@Given("User navigate to URL and open the landing page")
		public void user_navigate_to_url_and_open_the_landing_page() {
			
			
			WebDriverFactory.navigateToURL(base_url);
			
			
		    }

	//===================== Scenarios =================================================//

		@When("User is on landing page")
		public void user_is_on_landing_page() {


		}
		@Then("Validate current URL of landing page with expected URL")
		public void validate_current_url_of_landing_page_with_expected_url() {  
			landingPageObject.validatePageURL();
			 scn.log("Validate current URL is: "+ driver.getCurrentUrl());
		}
		@Given("User click on Wishlist icon  from home page")
		public void user_click_on_wishlist_icon_from_home_page() {
		  
			WebElement  mywishlist= driver.findElement(By.xpath("//img[@alt='wishlist']"));
			mywishlist.click();
			
		}

		@When("User redirected to login page of the application where title us {string}")
		public void user_redirected_to_login_page_of_the_application_where_title_us(String MyWishlistpage) throws Exception {
			String titleOfMyWishlistpage = driver.getTitle();
			Assert.assertEquals(MyWishlistpage, titleOfMyWishlistpage);
			Thread.sleep(5000);
			 
		}

		
@When("User enters {string} and click on Continue button")
	public void user_enters_and_click_on_continue_button(String emailid) throws InterruptedException {
		   
			WebElement emailIdInputFieldElement = driver.findElement(By.xpath("//input[@id='email-login-one']"));
			emailIdInputFieldElement.sendKeys(emailid);
			WebElement continueButtonElement = driver.findElement(By.xpath("//button[@id='send2-login-one']"));
			continueButtonElement.click();
		Thread.sleep(5000);
				}

		@When("User is displayed with the message as {string}")
		public void user_is_displayed_with_the_message_as(String string) throws InterruptedException {
		logger.info("User is on login page after entering OTP");
	    scn.log("User is on landing page after navigating to base URL");
		Thread.sleep(10000);
		}
		
		@When("User enters {string} and click on login button1")
		public void user_enters_and_click_on_login_button1(String string) throws InterruptedException {
			Thread.sleep(10000);
			
			WebElement login = driver.findElement(By.xpath("//form[@id='customer-popup-login-form-three']//span[contains(text(),'Login')]"));
			login.click();
			
			//Thread.sleep(10000);
			logger.info("User is on login page after entering OTP");
		    scn.log("User is on landing page after navigating to base URL");
			
		}

		@Then("User successfully login and landing to My Wish List1")
		public void user_successfully_login_and_landing_to_my_wish_lis1t1() throws InterruptedException {
			Thread.sleep(5000);
			WebElement  mywishlist= driver.findElement(By.xpath("//img[@alt='wishlist']"));
			mywishlist.click();
			Thread.sleep(5000);
			logger.info("User is Successfully on Wishlistpage");
		    scn.log("User is Successfully on Wishlistpage landing on wishlist");
			
		}
		
		@When("User click on sign in button")
		public void user_click_on_sign_in_button() {
			WebElement  signin= driver.findElement(By.xpath("//span[normalize-space()='Sign up']"));
			signin.click();
		}

		@When("User enters {string} and  {string} and {string}")
		public void user_enters_and_and(String Name, String emailid, String Phone) throws InterruptedException {
			
			WebElement nameInputFieldElement = driver.findElement(By.xpath("//input[@id='firstname']"));
			nameInputFieldElement.sendKeys(Name);
			Thread.sleep(3000);
			WebElement emailIdInputFieldElement = driver.findElement(By.xpath("//input[@id='popup-email_address']"));
			emailIdInputFieldElement.sendKeys(emailid);
			Thread.sleep(3000);
			WebElement phoneInputFieldElement = driver.findElement(By.xpath("//input[@id='phone']"));
			phoneInputFieldElement.sendKeys(Phone);
			Thread.sleep(3000);
			
		}
		
		@Then("User successfully login and landing to My WishList1")
		public void user_successfully_login_and_landing_to_my_wish_list1() throws InterruptedException {
			 //Thread.sleep(50000);
//			WebElement  mywishlist= driver.findElement(By.xpath("//img[@alt='wishlist']"));
//			mywishlist.click();
//				Thread.sleep(10000);
		}

		@When("User is click on create account")
		public void user_is_click_on_create_account() throws InterruptedException {
			WebElement CreateButtonElement = driver.findElement(By.xpath("//span[normalize-space()='create account']"));
				CreateButtonElement.click();
			Thread.sleep(5000);
		}

		@When("User enters {string} and click on login button")
		public void user_enters_and_click_on_login_button(String string) throws InterruptedException {
			Thread.sleep(3000);
			WebElement login = driver.findElement(By.xpath("//form[@id='customer-popup-login-form-three']//span[contains(text(),'Login')]"));
			login.click();
			Thread.sleep(10000);
			logger.info("User is on login page after entering OTP");
		    scn.log("User is on landing page after navigating to base URL");
			
		}

		@Then("User successfully login and landing to My Wish List")
		public void user_successfully_login_and_landing_to_my_wish_list() throws InterruptedException {
			Thread.sleep(10000);
			WebElement  mywishlist= driver.findElement(By.xpath("//img[@alt='wishlist']"));
			mywishlist.click();
			Thread.sleep(10000);
			logger.info("User is Successfully on Wishlistpage");
		    scn.log("User is Successfully on Wishlistpage landing on wishlist");
			
		}
		@When("User see the Trending option on screen")
		public void user_see_the_trending_option_on_screen() {
		    WebElement trending=driver.findElement(By.xpath("//a[normalize-space()='Trending']"));
		Actions act=new Actions (driver);
		act.moveToElement(trending).perform();
		logger.info("Done Mouse hover on 'Trending' from Menu");
	    scn.log("Done Mouse hover on 'Trending' from Menu");
		
		}

		@Then("User select DGRP and click on it")
		public void user_select_dgrp_and_click_on_it() {
			WebElement subMenuOption = driver.findElement(By.xpath("//a[@data-menu='Trending/DGRP']")); 
	    	//Mouse hover menuOption 'DGRP
			Actions act=new Actions (driver);
	    	act.moveToElement(subMenuOption).perform();
	    	logger.info("Done Mouse hover on 'DGRP' from Menu");
	    	 scn.log("Done Mouse hover on 'DGRP' from Menu");
		}

		@Then("User close the window")
		public void user_close_the_window() {
		    driver.close();
		}

		

@When("User select the size of the ring")
public void user_select_the_size_of_the_ring() throws InterruptedException {
	
	WebElement dropdown =driver.findElement(By.xpath("//select[@id='mt_size']"));
	Select select=new Select(dropdown);
	select.selectByValue("25");
	Thread.sleep(3000);
	select.selectByIndex(4);
	Thread.sleep(3000);
	select.selectByVisibleText("10");
	Thread.sleep(3000);
}

@When("User enters {string} and click on Check button")
public void user_enters_and_click_on_check_button(String pincode) {
    
	WebElement pin = driver.findElement(By.xpath("//input[@id='eedpincode']"));
	pin.sendKeys(pincode);
	
	WebElement checkbutton = driver.findElement(By.xpath("//input[@id='check-eed']"));
	checkbutton.click();
	
}

@Then("User see the Expected Delivery Date")
public void user_see_the_expected_delivery_date() {
   
	logger.info("User see the expected delivery date");
  scn.log("User see the expected delivery date");
}


		

			
			
			
}

		
		









