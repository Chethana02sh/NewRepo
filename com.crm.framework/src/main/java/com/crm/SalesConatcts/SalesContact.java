package com.crm.SalesConatcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesContact
{
	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD") private WebElement addConatctLnk;
	
	
	public SalesContact(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addConatct()
	{
		addConatctLnk.click();
	}
}
