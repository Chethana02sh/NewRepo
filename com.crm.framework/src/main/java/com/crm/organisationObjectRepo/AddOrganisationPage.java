package com.crm.organisationObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrganisationPage {

@FindBy(id = "Accounts_editView_fieldName_accountname") private WebElement orgNameEdtTxt;

@FindBy(xpath = "//button[.='Save']") private WebElement saveBtnClick;


public AddOrganisationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}




public WebElement getOrgNameEdtTxt() {
	return orgNameEdtTxt;
}
public WebElement getSaveBtnClick() {
	return saveBtnClick;
}



public void addOrganisationName(String orgName)
{
	orgNameEdtTxt.clear();
	orgNameEdtTxt.sendKeys(orgName);
}
}
