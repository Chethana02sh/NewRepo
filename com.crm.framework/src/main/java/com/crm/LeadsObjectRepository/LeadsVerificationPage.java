package com.crm.LeadsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsVerificationPage 
{
@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
@FindBy(xpath = "//h4[normalize-space(text())='Leads'] ") private WebElement mainLeadPage;


public LeadsVerificationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
	
public void editBtnClick()
{
	EditBtn.click();
}
public void clickOnLeadsLink()
{
	mainLeadPage.click();
}
}
