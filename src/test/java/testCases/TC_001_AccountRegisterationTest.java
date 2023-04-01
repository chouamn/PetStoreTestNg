package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC_001_AccountRegisterationTest extends BaseClass{

	
	
	@ Test(groups= {"Regrasstion", "Master"})
	void test_account_Registration()
	{
		logger.debug(" Application logs ");
		logger.info("*** Starting TC_01_AccountRegisterationTest *** ");
		try {
			Homepage hp = new Homepage(driver);
			logger.info("*** Navigate  to log in button *** ");
			hp.clickOnSitenavigation();
			logger.info("*** Click on  log in button *** ");
			hp.clickOnoLginBtn();
			logger.info("*** Click on Create Account button *** ");
			hp.clickOnCreateAccountBtn();
			CreateAccountPage CreateAccount= new CreateAccountPage(driver);
			logger.info("*** Providing customer data *** ");
			CreateAccount.SetfirstName(randomeString());
			CreateAccount.SetlastName(randomeString());
			CreateAccount.SetEmail(randomeString()+"@gmail.com");
			String password= randomeAlphaNumber();
			CreateAccount.SetPassword(password);
			logger.info("*** Click on Create Account button *** ");
			CreateAccount.clickOncreateBtn();
			//Petstore.com
			String PageTitle= driver.getTitle();
			logger.info("***Validating page title *** ");
			Assert.assertEquals(PageTitle, "Create Account – Petstore.com", "Test failed");
			
		} catch (Exception e) {
			logger.error("Test failed");
			Assert.fail();
		}
		logger.info("***Finished TC_001_AccountRegisterationTest *** ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
