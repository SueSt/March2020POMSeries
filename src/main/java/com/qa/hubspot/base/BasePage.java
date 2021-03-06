package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author souad
 *
 */

public class BasePage {

	WebDriver driver;
	public Properties prop;
	public ElementUtil elementUtil;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is used to in initialize the WebDriver on the basis of browser
	 * 
	 * @param browserName
	 * @return driver
	 */

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());

		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			// driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}

		// driver.manage().deleteAllCookies();
		getDriver().manage().deleteAllCookies();
		// driver.manage().window().maximize();
		getDriver().manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	/**
	 * this method is used to initialize the properties from config.properties file
	 * 
	 * @return prop
	 */

	public Properties init_prop() {
		// create properties object
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
	
	/**
	 * This method will take the screenshot
	 * @return 
	 */

	public String getScreenShot() {
	File src= ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	String path= System.getProperty("user.dir")+"/screenshots/"+ System.currentTimeMillis()+".png";
	File destination = new File(path);
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return path;
	}

	
	
}
