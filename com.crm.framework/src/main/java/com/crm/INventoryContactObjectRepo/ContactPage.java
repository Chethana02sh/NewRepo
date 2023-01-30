package com.crm.INventoryContactObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD")private WebElement addCtntBtn;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addContact()
	{
		addCtntBtn.click();
	}
}
