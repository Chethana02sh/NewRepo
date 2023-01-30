package com.crm.contactsObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD") private WebElement AddContactBtn;
	
	@FindBy(id = "Contacts_listView_massAction_LBL_DELETE") private WebElement deleteBtnClick;
	
	@FindBy(xpath = "//button[.='Yes']") private WebElement yesBtnClick;
	
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getAddContactBtn() {
		return AddContactBtn;
	}


	public WebElement getDeleteBtnClick() {
		return deleteBtnClick;
	}


	public WebElement getYesBtnClick() {
		return yesBtnClick;
	}

	
	
	public void addContact()
	{
		AddContactBtn.click();
	}
	
	public void selectFirstContactName(WebDriver driver,Object contactFirstName)
	{
	//	driver.findElement(By.xpath("//form[@id='listedit']//tbody/tr/td[2]/span//a[.='camp803']"))
		driver.findElement(By.xpath("//a[.='"+contactFirstName+"']")).click();
	}
	
	public void selectcontactToDelete(WebDriver driver,String CreatedfirstName)
	{
		driver.findElement(By.xpath("//a[.='"+CreatedfirstName+"']/ancestor::tr[@class='listViewEntries']/descendant::input[@class='listViewEntriesCheckBox']")).click();
		deleteBtnClick.click();
		yesBtnClick.click();
	}
}
