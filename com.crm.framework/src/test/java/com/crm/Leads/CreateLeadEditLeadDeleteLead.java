package com.crm.Leads;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.LeadsObjectRepository.AddLeadPage;
import com.crm.LeadsObjectRepository.LeadsPage;
import com.crm.LeadsObjectRepository.LeadsVerificationPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateLeadEditLeadDeleteLead extends BaseClass{
@Test
public void createLeadEditLeadDeleteLead() throws Throwable
{

	WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", ele);

	MenuPage menuPage = new MenuPage(driver);
	menuPage.getLeadsLink().click();
	
	LeadsPage leadsPage = new LeadsPage(driver);
	leadsPage.addLeadBtnClick();
	
	int randNum = jLib.getRandomNumber();
	String firstName = eLib.readDataFromExcel("Leads", 1, 0)+randNum;
	String lastName = eLib.readDataFromExcel("Leads", 1, 1)+randNum;
	
	AddLeadPage addLeadPage = new AddLeadPage(driver);
	addLeadPage.addLeadFirstName(firstName);
	addLeadPage.addLeadLastName(lastName);
	
	String CreatedfirstName = driver.findElement(By.xpath("//span[.='"+firstName+"']")).getText();
	String CreatedlastName = driver.findElement(By.xpath("//span[.='"+lastName+"']")).getText();
			
	Assert.assertEquals(firstName,CreatedfirstName);
	Assert.assertEquals(lastName, CreatedlastName);
	
	Reporter.log("Lead is created",true);
	
	//edit lead
	LeadsVerificationPage leadsVerificationPage = new LeadsVerificationPage(driver);
	leadsVerificationPage.editBtnClick();
	
	int randNum1 = jLib.getRandomNumber();
	
	String lastName1 = eLib.readDataFromExcel("Contacts", 1, 1)+randNum1;
	
	addLeadPage.addLeadLastName(lastName1);
	
	String EditedlastName = driver.findElement(By.xpath("//span[.='"+lastName1+"']")).getText();
	
	Assert.assertEquals(lastName1, EditedlastName);
	
	Reporter.log("Lead last name is edited",true);
	
	Thread.sleep(6000);
	//delete lead
	leadsVerificationPage.clickOnLeadsLink();
	
	leadsPage.selectLeadToDelete(driver, CreatedfirstName);
	
	Reporter.log("Lead is deleted",true);
	Thread.sleep(6000);
}
}
