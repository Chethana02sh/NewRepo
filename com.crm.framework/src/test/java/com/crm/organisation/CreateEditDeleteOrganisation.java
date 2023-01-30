package com.crm.organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;
import com.crm.organisationObjectRepo.AddOrganisationPage;
import com.crm.organisationObjectRepo.OrganisationPage;
import com.crm.organisationObjectRepo.OrganisationVerfyPage;

public class CreateEditDeleteOrganisation extends BaseClass{
@Test
	public void createEditDeleteOrganisation() throws Throwable
	{
	WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", ele);

	MenuPage menuPage = new MenuPage(driver);
	menuPage.getMarketingOrganisationLik().click();
	
	int randNum = jLib.getRandomNumber();
	String OrgName = eLib.readDataFromExcel("MOrganisation", 1, 0)+randNum;
	
	OrganisationPage organisationPage = new OrganisationPage(driver);
	organisationPage.addOrgbtnClick();
	
	AddOrganisationPage addOrganisationPage = new AddOrganisationPage(driver);
	addOrganisationPage.addOrganisationName(OrgName);
	addOrganisationPage.getSaveBtnClick().click();
	
	String CreatedOrgName = driver.findElement(By.xpath("//span[.='"+OrgName+"']")).getText();
	
	eLib.writeDataIntoExcel("MOrganisation", 0, 1, CreatedOrgName);
	
	Assert.assertEquals(OrgName, CreatedOrgName);
	
	Reporter.log("organisation is created",true);
	
	//Edit organisation
	OrganisationVerfyPage organisationVerfyPage = new OrganisationVerfyPage(driver);
	organisationVerfyPage.editBtnClick();
	
	int randNum1 = jLib.getRandomNumber();
	
	String NewOrgName = eLib.readDataFromExcel("MOrganisation", 1, 0)+randNum1;
	
	addOrganisationPage.addOrganisationName(NewOrgName);
	addOrganisationPage.getSaveBtnClick().click();
	
	String EditedorgName = driver.findElement(By.xpath("//span[.='"+NewOrgName+"']")).getText();
	
	System.out.println(EditedorgName);
	eLib.writeDataIntoExcel("MOrganisation", 0, 1, EditedorgName);
	
	Assert.assertEquals(NewOrgName, EditedorgName);
	
	Reporter.log("organisation name is successfully edited",true);
	
	//Delete Organisation
	organisationVerfyPage.clickOnOrganisationLink();
	
	organisationPage.selectOrgToDelete(driver, EditedorgName);
	
	Reporter.log("Organisation is successfully deleted",true);
	}
}
