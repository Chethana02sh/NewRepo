package com.crm.SalesOrganisationObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrgPage {

	@FindBy(id = "Accounts_editView_fieldName_accountname")private WebElement orgNameEdtTxt;
	
	@FindBy(xpath = "//button[.='Save']") private WebElement saveBtnClick;
	
	public AddOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void EnterOrgName(String orgName)
	{
		orgNameEdtTxt.clear();
		orgNameEdtTxt.sendKeys(orgName);
		saveBtnClick.click();
	}
}
