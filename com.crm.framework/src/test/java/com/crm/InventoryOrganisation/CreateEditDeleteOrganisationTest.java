package com.crm.InventoryOrganisation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.InventoryOrgObjectRepo.AddOrganisationPage;
import com.crm.InventoryOrgObjectRepo.OrganisationPage;
import com.crm.SalesOrganisationObjectRepo.OrganisationVerifyPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateEditDeleteOrganisationTest extends BaseClass
{
@Test
public void createEditDeleteOrganisationTest() throws Throwable
{
	int randNum = jLib.getRandomNumber();
	
	WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", ele);

	MenuPage menuPage = new MenuPage(driver);
	menuPage.getInventoryOrgLink().click();
	
	OrganisationPage organisationPage = new OrganisationPage(driver);
	organisationPage.addOrg();
	
	String orgName = eLib.readDataFromExcel("MOrganisation", 1, 0)+randNum;
	
	AddOrganisationPage addOrganisationPage = new AddOrganisationPage(driver);
	addOrganisationPage.orgAndSave(orgName);
	
	String CreatedOrgName = driver.findElement(By.xpath("//span[.='"+orgName+"']")).getText();
	
	Assert.assertEquals(orgName, CreatedOrgName);
	
	Reporter.log("Organisation is created",true);
	
	//edit
	OrganisationVerifyPage organisationVerifyPage = new OrganisationVerifyPage(driver);
	organisationVerifyPage.edit();
	
	int randNum1 = jLib.getRandomNumber();
	String NeworgName = eLib.readDataFromExcel("MOrganisation", 1, 0)+randNum1;
	
	addOrganisationPage.orgAndSave(NeworgName);
	
	String EditedOrgName = driver.findElement(By.xpath("//span[.='"+NeworgName+"']")).getText();
	Assert.assertEquals(NeworgName, EditedOrgName);
	
	Reporter.log("Organisation is edited successfully",true);
	//delete
	organisationVerifyPage.delete();
	
	Reporter.log("Organisation is deleted successfully",true);
}
}
