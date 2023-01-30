package com.crm.InventoryOrgObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrganisationPage {

	@FindBy(id = "Accounts_editView_fieldName_accountname")private WebElement orgNameEdtTxt;
	
	@FindBy(xpath = "//button[.='Save']")private WebElement saveBtn;
	
	
	public AddOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void orgAndSave(String orgName)
	{
		orgNameEdtTxt.clear();
		orgNameEdtTxt.sendKeys(orgName);
		saveBtn.click();
	}
}
