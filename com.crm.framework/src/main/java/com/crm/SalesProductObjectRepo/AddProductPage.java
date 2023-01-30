package com.crm.SalesProductObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage 
{
	@FindBy(id = "Products_editView_fieldName_productname")private WebElement productNameEdtTxt;
	
	@FindBy(xpath = "//button[.='Save']") private WebElement saveBtnClick;
	
	
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void ProductName(String firstName)
	{
		productNameEdtTxt.clear();
		productNameEdtTxt.sendKeys(firstName);
		saveBtnClick.click();
	}
}
