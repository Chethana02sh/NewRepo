package com.crm.SalesConatcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {

	@FindBy(id = "Contacts_editView_fieldName_firstname")private WebElement firstNameEdtTxt;
	
	@FindBy(id = "Contacts_editView_fieldName_lastname")private WebElement lastNameEdtTxt;
	
	@FindBy(xpath = "//button[.='Save']")private WebElement saveBtnClk;
	
	public AddContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void FirstName(String firstName)
	{
		firstNameEdtTxt.sendKeys(firstName);
	}
	public void LastName(String lastName)
	{
		lastNameEdtTxt.clear();
		lastNameEdtTxt.sendKeys(lastName);
		saveBtnClk.click();
	}
}
