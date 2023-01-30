package com.crm.campaignObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCampaignPage {

	@FindBy(id = "Campaigns_editView_fieldName_campaignname") private WebElement campaignNameEdtTxt;
	
	@FindBy(xpath = "//td[contains(.,'Campaign Status')]/..//div[@id='s2id_autogen3']") private WebElement selectCampaignStatusDropdown;
	
	@FindBy(xpath = "//button[.='Save']") private WebElement saveBtn;
	
	
	public AddCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public WebElement getCampaignNameEdtTxt() {
		return campaignNameEdtTxt;
	}

	public WebElement getSelectCampaignStatusDropdown() {
		return selectCampaignStatusDropdown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public void campaignname(WebDriver driver,String username)
	{
		campaignNameEdtTxt.sendKeys(username);
	}
}
