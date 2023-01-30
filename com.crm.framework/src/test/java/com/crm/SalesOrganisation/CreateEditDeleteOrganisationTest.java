package com.crm.SalesOrganisation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.SalesOrganisationObjectRepo.AddOrgPage;
import com.crm.SalesOrganisationObjectRepo.OrganisationPage;
import com.crm.SalesOrganisationObjectRepo.OrganisationVerifyPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateEditDeleteOrganisationTest extends BaseClass{
	@Test
	public void createEditDeleteTest() throws Throwable 
	{
		int randNum = jLib.getRandomNumber();
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getSalesOrganizationsLink().click();
		
		OrganisationPage organisationPage = new OrganisationPage(driver);
		organisationPage.addOrg();
		
		String orgName = eLib.readDataFromExcel("MOrganisation", 1, 0)+randNum;
		
		AddOrgPage addOrgPage = new AddOrgPage(driver);
		addOrgPage.EnterOrgName(orgName);
		
		String CreatedOrgName = driver.findElement(By.xpath("//span[.='"+orgName+"']")).getText();
		
		Assert.assertEquals(orgName, CreatedOrgName);
		
		Reporter.log("Organisation is created",true);
		//Edit
		OrganisationVerifyPage organisationVerifyPage = new OrganisationVerifyPage(driver);
		organisationVerifyPage.edit();
		
		int randNum1 = jLib.getRandomNumber();
		String NeworgName = eLib.readDataFromExcel("MOrganisation", 1, 0)+randNum1;
		
		addOrgPage.EnterOrgName(NeworgName);
		
		String EditedOrgName = driver.findElement(By.xpath("//span[.='"+NeworgName+"']")).getText();
		Assert.assertEquals(NeworgName, EditedOrgName);
		
		Reporter.log("Organisation is edited successfully",true);
		//delete
		organisationVerifyPage.delete();
		
		Reporter.log("Organisation is deleted successfully",true);
	}
}
