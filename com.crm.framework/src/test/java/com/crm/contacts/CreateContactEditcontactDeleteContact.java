package com.crm.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.campaignObjectRepository.MenuPage;
import com.crm.contactsObjectRepository.AddContactPage;
import com.crm.contactsObjectRepository.ContactPage;
import com.crm.contactsObjectRepository.ContactVerificationPage;
import com.crm.genericUtilities.BaseClass;

public class CreateContactEditcontactDeleteContact extends BaseClass 
{
	@Test
	public void createContact() throws Throwable
	{
		int randNum = jLib.getRandomNumber();
		
		String firstName = eLib.readDataFromExcel("Contacts", 1, 0)+randNum;
		String lastName = eLib.readDataFromExcel("Contacts", 1, 1)+randNum;
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getMarketingContactLink().click();
		
		ContactPage contactPage = new ContactPage(driver);
		contactPage.addContact();
		
		AddContactPage addContactPage = new AddContactPage(driver);
		addContactPage.addFirstName(firstName);
		addContactPage.addLastName(lastName);
		addContactPage.getSaveBtn().click();
		
		String CreatedfirstName = driver.findElement(By.xpath("//span[.='"+firstName+"']")).getText();
		String CreatedlastName = driver.findElement(By.xpath("//span[.='"+lastName+"']")).getText();
				
		eLib.writeDataIntoExcel("Contacts", 0, 2, CreatedfirstName);
		
		Assert.assertEquals(firstName,CreatedfirstName);
		
		Reporter.log("contact is created",true);
		//Edit
			
		ContactVerificationPage contactVerificationPage = new ContactVerificationPage(driver);
		contactVerificationPage.Edit();
		
		int randNum1 = jLib.getRandomNumber();
		String lastName1 = eLib.readDataFromExcel("Contacts", 1, 1)+randNum1;
		
		addContactPage.addLastName(lastName1);
		addContactPage.getSaveBtn().click();
		
		String EditedlastName = driver.findElement(By.xpath("//span[.='"+lastName1+"']")).getText();
		
		Assert.assertEquals(lastName1, EditedlastName);
		eLib.writeDataIntoExcel("Contacts", 0, 3, EditedlastName);
		
		Reporter.log("last name is edited",true);
		
		//click on contactlink to show the list of contacts created
		//Delete contact
		
		contactVerificationPage.clickOnContactLink();
		
		contactPage.selectcontactToDelete(driver, CreatedfirstName);
		
		Reporter.log("contact is deleted",true);
	}
}
