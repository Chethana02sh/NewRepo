package com.crm.LeadsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddLeadPage {

	@FindBy(id = "Leads_editView_fieldName_firstname") private WebElement firstNameTxtEdt;
	
	@FindBy(id = "Leads_editView_fieldName_lastname") private WebElement lastNameTxtEdt;
	
	@FindBy(xpath = "//button[.='Save']") private WebElement saveBtnClick;
	
	
	public AddLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void addLeadFirstName(String firstName)
	{
		firstNameTxtEdt.sendKeys(firstName);
	}
	
	public void addLeadLastName(String lastName)
	{
		lastNameTxtEdt.clear();
		lastNameTxtEdt.sendKeys(lastName);
		saveBtnClick.click();
	}
}
