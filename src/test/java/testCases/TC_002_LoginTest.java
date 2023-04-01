package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Regrasstion", "Master"})
	public void test_Login() 
	{
		try {
			logger.info("**** Starting TC_002 LoginTest****");
			Homepage hp = new Homepage(driver);
			logger.info("*** Navigate  to log in button *** ");
			hp.clickOnSitenavigation();
			logger.info("*** Click on  log in button *** ");
			hp.clickOnoLginBtn();
			logger.info("*** Enter your Email address  *** ");
			hp.EnterEmail(resourcebundle.getString("email")); // valid email , get it from config.property file 
			logger.info("*** Enter your password address  *** ");
			hp.EnterPassword(resourcebundle.getString("password"));//valid password , get it from config.property file 
			logger.info("*** Click on Sign in button  *** ");
			hp.clickOnSignInBtn();
			/*
			 * Thread.sleep(5); hp.clickOnCaptchaCheckBox(); Thread.sleep(8);
			 * hp.clickOnCaptchSubmitBtn(); String pageTitle= driver.getTitle();
			 * System.out.println(pageTitle);
			 * Assert.assertEquals(pageTitle,"Challenge – Petstore.com" );
			 */


		} catch (Exception e) {
			Assert.fail(" Invalid login data");
		}
		logger.info("**** Finished  TC_002 LoginTest****");

	}


	@Test(groups= {"Sanity", "Master"},dataProvider ="LoginData", dataProviderClass =DataProviders.class )
	void test_loginDDt(String email, String password) throws InterruptedException 
	{
		try {
			logger.info("**** Starting TC_002 LoginTDD****");
			Homepage hp = new Homepage(driver);
			logger.info("*** Navigate  to log in button *** ");
			hp.clickOnSitenavigation();
			logger.info("*** Click on  log in button *** ");
			hp.clickOnoLginBtn();
			logger.info("*** Enter your Email address  *** ");
			hp.EnterEmail(email); // valid email , get it from config.property file 
			logger.info("*** Enter your password address  *** ");
			hp.EnterPassword(password);//valid password , get it from config.property file 
			logger.info("*** Click on Sign in button  *** ");
			hp.clickOnSignInBtn();
			Thread.sleep(5);
			hp.clickOnCaptchaCheckBox();
			Thread.sleep(8);
			hp.clickOnCaptchSubmitBtn();
			hp.clickOnlogOutBtn();

		}catch(Exception e){
			Assert.fail("test failed");
		}
		logger.info("**** Finished  TC_002 LoginTestTDD****");	
	}



}
