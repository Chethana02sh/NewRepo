package com.crm.OpportunitiesObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityVerifyPage 
{
	
	@FindBy(xpath = "//button[contains(.,'More')]//i")private WebElement moreBtnClick;
	
	@FindBy(xpath = "//a[.='Delete Opportunity']")private WebElement deleteOprtBtn;
	
	@FindBy(xpath = "//button[.='Yes']")private WebElement yesBtn;
	
	@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
		
	public OpportunityVerifyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void editBtnClick()
	{
		EditBtn.click();
	}

	public void deleteOpty()
	{
		moreBtnClick.click();
		deleteOprtBtn.click();
		yesBtn.click();
	}
}