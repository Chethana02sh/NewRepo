package com.crm.inventoryContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.INventoryContactObjectRepo.AddContactPage;
import com.crm.INventoryContactObjectRepo.ContactPage;
import com.crm.SalesConatcts.ContactVerifyPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateEditDeleteContactTest extends BaseClass{
@Test
	public void createEditDeleteContactTest() throws Throwable
	{
	int randNum = jLib.getRandomNumber();
	
	WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", ele);

	MenuPage menuPage = new MenuPage(driver);
	menuPage.getInventoryContactLnk().click();
	
	ContactPage contactPage = new ContactPage(driver);
	contactPage.addContact();
	
	String firstName = eLib.readDataFromExcel("Contacts", 1, 0)+randNum;
	String lastName = eLib.readDataFromExcel("Contacts", 1, 1)+randNum;
	
	AddContactPage addContactPage = new AddContactPage(driver);
	addContactPage.firstname(firstName);
	addContactPage.lastname(lastName);
	
	String CreatedfirstName = driver.findElement(By.xpath("//span[.='"+firstName+"']")).getText();
	String CreatedlastName = driver.findElement(By.xpath("//span[.='"+lastName+"']")).getText();
	
	Assert.assertEquals(firstName,CreatedfirstName);
	
	Reporter.log("contact is created",true);
	
	//edit contact
	int newRandNum = jLib.getRandomNumber();
	
	String NewLastName = eLib.readDataFromExcel("Contacts", 1, 1)+newRandNum;
	
	ContactVerifyPage contactVerifyPage = new ContactVerifyPage(driver);
	contactVerifyPage.edit();
	addContactPage.lastname(NewLastName);
	
	String EditedLastName = driver.findElement(By.xpath("//span[.='"+NewLastName+"']")).getText();
	
	Assert.assertEquals(NewLastName,EditedLastName);
	
	Reporter.log("contact is edited successfully",true);
	
	//Delete contact
	contactVerifyPage.delete();
	
	Reporter.log("contact is deleted successfully",true);
	}
}
