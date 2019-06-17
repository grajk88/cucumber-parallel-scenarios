package com.testautomationworld.stepDef;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomationworld.commonUtils.BrowserUtility;
import com.testautomationworld.commonUtils.PropertiesFileReader;
import com.testautomationworld.listeners.ExtentReportListener;
import com.testautomationworld.pageObjects.YoutubeChannelPage;
import com.testautomationworld.pageObjects.YoutubeResultsPage;
import com.testautomationworld.pageObjects.YoutubeSearchPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class YoutubeFeatureStepDef extends ExtentReportListener {
	PropertiesFileReader obj = new PropertiesFileReader();
	private WebDriver driver;

	@Given("^a with (.*)")
	public void a(String transaction_id, DataTable dt) throws Throwable {
		
		List<Object> list = dt.asList(String.class);
		System.out.println("Username - " + list.get(0));
		System.out.println("Password - " + list.get(1));

		System.out.println("Transaction Id" +transaction_id);
        System.out.println("***************************");
        
	}

	@Given("^b with (.*)")
	public void b(String transaction_id) throws Throwable {

		System.out.println("Inside b " + transaction_id);

	}

	@Given("^c")
	public void c() throws Throwable {

		System.out.println("Inside c");

	}

	@Given("^I am in the YouTube website$")
	public void open_chrome_browser_with_URL() throws Throwable {
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Feature.class, "Youtube channel name validation");
			test = test.createNode(Scenario.class, "Youtube channel name validations");
			logInfo = test.createNode(new GherkinKeyword("Given"), "open_chrome_browser_with_URL");
			Properties properties = obj.getProperty();
			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"),
					properties.getProperty("browser.baseURL"));

			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
			driver.quit();
		}
	}

	@When("^I search for T4TA channel$")
	public void search_selenium_tutorial() throws Throwable {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "search_selenium_tutorial");
			new YoutubeSearchPage(driver).NavigateToResultPage("T4TA ");
			logInfo.pass("Searching selenium tutorial");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}

	}

	@When("^Search selenium tutorial \"([^\"]*)\"$")
	public void search_selenium_tutorial(String searchString) throws Throwable {
		new YoutubeSearchPage(driver).NavigateToResultPage(searchString);
	}

	@When("^click on the channel name$")
	public void click_on_channel_name() throws Throwable {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "click_on_channel_name");
			new YoutubeResultsPage(driver).NavigateToChannelName();
			logInfo.pass("Clicked on the channel name");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}

	}

	@Then("^I should be taken to T4TA Channel page$")
	public void validate_channel_name() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "validate_channel_name");
			String expectedChannelName = "T4TA Tips 4 Test Automators";
			String actualChannelName = new YoutubeChannelPage(driver).getTitle();
			Assert.assertEquals(actualChannelName, expectedChannelName, "Channel names are not matching");
			logInfo.pass("Validated channel title");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			System.out.println("closing browser");
			driver.quit();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}

	}

}
