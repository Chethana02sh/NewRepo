package com.crm.SalesProductObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	@FindBy(id = "Products_listView_basicAction_LBL_ADD_RECORD")private WebElement addProductBtn;
	
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addProduct()
	{
		addProductBtn.click();
	}
}
