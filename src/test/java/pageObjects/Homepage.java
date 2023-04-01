package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage extends BasePage{

	public Homepage(WebDriver driver) {
		super(driver);
	}

	// Element 
	@FindBy(xpath = "//button[@type='button' and @aria-controls='NavDrawer']")
	WebElement SitenavigationBtn;

	@FindBy(linkText = "Log in")
	WebElement LoginBtn;


	@FindBy(xpath="//input[@id='CustomerEmail']") 
	@CacheLookup 
	WebElement emailTextFiledLogIn;

	@FindBy(xpath="//input[@id='CustomerPassword']") 
	@CacheLookup 
	WebElement passwordTextFiledLogIn;

	@FindBy(xpath="//form[@id='customer_login']//button[@type='submit']")
	@CacheLookup 
	WebElement signInBtn;

	@FindBy(xpath="//a[@id='customer_register_link']")
	@CacheLookup 
	WebElement createAccountBtn;

	// Captcha
	@FindBy(xpath="//iframe[@title='reCAPTCHA']")
	@CacheLookup 
	WebElement CaptchaCheckBox;
	// Captch SubmitBtn
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup 
	WebElement CaptchSubmitBtn;


	@FindBy(xpath="//a[normalize-space()='Log out']")
	@CacheLookup 
	WebElement logOutBtn;

	// Action Methods 
	public void clickOnSitenavigation() {

		//	Actions act=new Actions(driver);
		//	act.moveToElement(SitenavigationBtn).click().perform();
		SitenavigationBtn.click();
	}

	public void clickOnlogOutBtn() {

		//	Actions act=new Actions(driver);
		//	act.moveToElement(SitenavigationBtn).click().perform();
		logOutBtn.click();
	}


	public void clickOnoLginBtn() {
		Actions act=new Actions(driver);
		act.moveToElement(LoginBtn).click().perform();
	}


	public void EnterEmail(String email) 
	{
		emailTextFiledLogIn.click();
		emailTextFiledLogIn.sendKeys(email);

	}

	public void EnterPassword(String password) 
	{
		passwordTextFiledLogIn.click();
		passwordTextFiledLogIn.sendKeys(password);

	}


	public void clickOnSignInBtn() {
		signInBtn.click();
	}

	public void clickOnCaptchaCheckBox() {
		//CaptchaCheckBox.isDisplayed();
	driver.switchTo().frame(CaptchaCheckBox);
		CaptchaCheckBox.click();
		
	}
	public void clickOnCaptchSubmitBtn() {
		CaptchSubmitBtn.isDisplayed();
		CaptchSubmitBtn.click();
		driver.switchTo().defaultContent();
	}

	public void clickOnCreateAccountBtn() {
		createAccountBtn.click();

	}







}
