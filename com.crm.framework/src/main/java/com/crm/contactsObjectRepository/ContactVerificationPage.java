package com.crm.contactsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactVerificationPage {
	
	@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
	@FindBy(xpath = "//h4[normalize-space(text())='Contacts'] ") private WebElement mainContactPage;
	
	public ContactVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void Edit()
	{
		EditBtn.click();
	}
	
	public void clickOnContactLink()
	{
		mainContactPage.click();
	}
	
	
//	public void firstName(WebDriver driver,String firstName)
//	{
//		driver.findElement(By.xpath("//span[.='"+firstName+"']"));
//	}
//	
//	public void lastName(WebDriver driver,String lastName)
//	{
//		driver.findElement(By.xpath("//span[.='"+lastName+"']"));
//	}
}
