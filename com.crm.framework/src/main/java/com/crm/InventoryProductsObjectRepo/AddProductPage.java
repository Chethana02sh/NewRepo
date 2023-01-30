package com.crm.InventoryProductsObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {

	@FindBy(id = "Products_editView_fieldName_productname")private WebElement productNameEdttxt;
	
	@FindBy(xpath = "//button[.='Save']")private WebElement saveBtnClk;
	
	
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addProductNameAndSave(String productName)
	{
		productNameEdttxt.clear();
		productNameEdttxt.sendKeys(productName);
		saveBtnClk.click();
	}
}
