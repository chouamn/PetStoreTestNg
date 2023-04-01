package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		
	}

// Elements	

@FindBy(xpath="//input[@id='FirstName']") @CacheLookup
WebElement firstNameCreateAccountTextFiled;
@FindBy(xpath="//input[@id='LastName']") @CacheLookup 
 WebElement lastNameCreateAccountTextFiled;
@FindBy(xpath="//input[@id='Email']") @CacheLookup 
WebElement emailCreateAccountTextFiled;
@FindBy(xpath="//input[@id='CreatePassword']") @CacheLookup 
WebElement passwordCreateAccountTextFiled;
@FindBy(xpath="//input[@value='Create']") @CacheLookup 
WebElement createBtn;

//Action Methods 
public void SetfirstName(String fristname) 
{
	firstNameCreateAccountTextFiled.click();
	firstNameCreateAccountTextFiled.sendKeys(fristname);

}
public void SetlastName(String lastName) 
{
	lastNameCreateAccountTextFiled.click();
	lastNameCreateAccountTextFiled.sendKeys(lastName);

}
public void SetEmail(String email) 
{
	emailCreateAccountTextFiled.click();
	emailCreateAccountTextFiled.sendKeys(email);

}
public void SetPassword(String pws) 
{
	passwordCreateAccountTextFiled.click();
	passwordCreateAccountTextFiled.sendKeys(pws);

}
	
public void clickOncreateBtn() {
	createBtn.click();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
