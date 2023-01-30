package com.crm.INventoryContactObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {

	@FindBy(id = "Contacts_editView_fieldName_firstname")private WebElement firstNameEdtTxt;
	
	@FindBy(id = "Contacts_editView_fieldName_lastname")private WebElement lastNameEdt;
	
	@FindBy(xpath = "//button[.='Save']")private WebElement saveBtn;
	
	public AddContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void firstname(String firstName)
	{
		firstNameEdtTxt.sendKeys(firstName);
	}
	
	public void lastname(String lastName)
	{
		lastNameEdt.clear();
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
}
