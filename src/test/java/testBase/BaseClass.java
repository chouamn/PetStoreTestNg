package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public  static WebDriver driver;
	public Logger logger;
	public ResourceBundle resourcebundle;
	@BeforeClass(groups= {"Sanity","Regrasstion", "Master"})
	@Parameters("browser")
	public void setup(String browser) 
	{
		resourcebundle=ResourceBundle.getBundle("config"); // read config file
		logger=LogManager.getLogger(this.getClass()); // logging



		if(browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup(); 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			this.driver= new ChromeDriver(options);
		}else if(browser.equals("Edge")) 
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			this.driver= new EdgeDriver(options);
		}else 
		{
			this.driver= new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://petstore.com/");
		driver.get(resourcebundle.getString("appURL"));
		driver.manage().window().maximize();
	}

	public String randomeString() 
	{
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeNumber() 
	{
		String generatedString2= RandomStringUtils.randomNumeric(8);
		return generatedString2;
	}	

	public String randomeAlphaNumber() 
	{
		String str= RandomStringUtils.randomNumeric(4);
		String num= RandomStringUtils.randomNumeric(4);
		return (str+"@"+num);
	}	

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}


	@AfterClass(groups= {"Sanity","Regrasstion", "Master"})
	public void teardown() 
	{ 
		driver.quit();
	}



}
