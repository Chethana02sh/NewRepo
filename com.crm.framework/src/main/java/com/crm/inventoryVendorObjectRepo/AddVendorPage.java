package com.crm.inventoryVendorObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVendorPage {

	@FindBy(id = "Vendors_editView_fieldName_vendorname")private WebElement vendorNameEdtTxt;
	
	@FindBy(xpath = "//button[.='Save']")private WebElement saveBtn;
	
	
	public AddVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void vendorNameSave(String name)
	{
		vendorNameEdtTxt.clear();
		vendorNameEdtTxt.sendKeys(name);
		saveBtn.click();
	}
}