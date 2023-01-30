package com.crm.inventoryVendorObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	@FindBy(id = "Vendors_listView_basicAction_LBL_ADD_RECORD")private WebElement addVendorBtn;
	
	public VendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addVendor()
	{
		addVendorBtn.click();
	}
}
