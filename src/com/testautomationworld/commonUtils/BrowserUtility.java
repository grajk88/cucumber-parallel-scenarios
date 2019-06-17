package com.testautomationworld.commonUtils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtility {
	
	public static WebDriver OpenBrowser(WebDriver driver, String browserName, String url) throws InterruptedException {
		
		if (browserName.equals("grid")) {
			
			try {
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
				
				Thread.sleep(5000);
				
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
			return driver;
		}

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(5000);
			return driver;
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("requireWindowFocus", true);// to move mouse manually
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.ie.driver",
					"");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
		return null;
	}

}
