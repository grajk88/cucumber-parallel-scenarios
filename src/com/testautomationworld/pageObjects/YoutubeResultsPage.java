package com.testautomationworld.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YoutubeResultsPage
{
	WebDriver driver;
	
	public YoutubeResultsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.LINK_TEXT,using="T4TA Tips 4 Test Automators")
	public WebElement ChannelNameLink;
	
	public void NavigateToChannelName() throws InterruptedException
	{
		Thread.sleep(2000);
		ChannelNameLink.click();
		Thread.sleep(3000);
	}

}
