package com.crm.campaignObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignVerificationPage {

	@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
	
	public CampaignVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void editCampaign()
	{
		EditBtn.click();
	}
}