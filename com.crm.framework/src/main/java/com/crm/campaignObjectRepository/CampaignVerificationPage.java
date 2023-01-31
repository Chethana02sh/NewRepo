package com.crm.campaignObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignVerificationPage {

	@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
	@FindBy(xpath = "//button[contains(.,'More')]//i")private WebElement moreBtnClick;
	
	@FindBy(xpath = "//a[.='Delete Campaign']")private WebElement deleteCampBtn;
	
	@FindBy(xpath = "//button[.='Yes']")private WebElement yesBtn;
	
	
	public CampaignVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void editCampaign()
	{
		EditBtn.click();
	}
	
	public void delete()
	{
		moreBtnClick.click();
		deleteCampBtn.click();
		yesBtn.click();
	}
}