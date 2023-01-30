package com.crm.Opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.LeadsObjectRepository.LeadsPage;
import com.crm.OpportunitiesObjectRepo.AddOpportunityPage;
import com.crm.OpportunitiesObjectRepo.OpportunitiyPage;
import com.crm.OpportunitiesObjectRepo.OpportunityVerifyPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateEditDeleteOpportunity extends BaseClass{
@Test
	public void createEditDeleteOpportunity() throws Throwable
	{
	WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

	int randNum = jLib.getRandomNumber();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", ele);
	
	MenuPage menuPage = new MenuPage(driver);
	menuPage.getSalesOpportunitiesLink().click();
	
	OpportunitiyPage opportunitiyPage = new OpportunitiyPage(driver);
	opportunitiyPage.addOpportunityBtnClick();
	
	String firstName = eLib.readDataFromExcel("Contacts", 0, 2);
	String lastName = eLib.readDataFromExcel("Contacts", 0, 3);
	
	System.out.println(firstName);
	System.out.println(lastName);
	String orgName = eLib.readDataFromExcel("MOrganisation", 0, 1);
	
	String CampaignName = eLib.readDataFromExcel("Campaign", 0, 1);
	
	String OpptyName = eLib.readDataFromExcel("Opportunity", 1, 0)+randNum;
	
	AddOpportunityPage addOpportunityPage = new AddOpportunityPage(driver);
	addOpportunityPage.selectCnt(firstName, lastName, orgName, OpptyName, CampaignName);
	
	driver.findElement(By.id("Campaigns_editView_fieldName_closingdate")).click();
	String monthYear = driver
			.findElement(By.xpath("//table[@class=' table-condensed']/..//tr//th[@class='datepicker-switch']"))
			.getText();
	String[] yearmonth = monthYear.toString().split(" ");
	String month = yearmonth[0];
	String year = yearmonth[1];

	while (!(month.equals("January") && year.equals("2023"))) {
		driver.findElement(By.xpath("//table[@class=' table-condensed']/..//tr/th[.='«']")).click();
		monthYear = driver
				.findElement(By.xpath("//table[@class=' table-condensed']/..//tr//th[@class='datepicker-switch']"))
				.getText();
		yearmonth = monthYear.toString().split(" ");

		month = yearmonth[0];
		year = yearmonth[1];
	}
	driver.findElement(By.xpath("//td[.='28']")).click();
	
	addOpportunityPage.getSavebtnClick().click();
	
	//expected close date
	driver.findElement(By.id("Potentials_editView_fieldName_closingdate")).click();
	String monthYear1 = driver
			.findElement(By.xpath("//table[@class=' table-condensed']/..//tr//th[@class='datepicker-switch']"))
			.getText();
	String[] yearmonth1 = monthYear1.toString().split(" ");
	String month1 = yearmonth1[0];
	String year1 = yearmonth1[1];

	while (!(month1.equals("January") && year1.equals("2023"))) {
		driver.findElement(By.xpath("//table[@class=' table-condensed']/..//tr/th[.='«']")).click();
		monthYear1 = driver
				.findElement(By.xpath("//table[@class=' table-condensed']/..//tr//th[@class='datepicker-switch']"))
				.getText();
		yearmonth1 = monthYear1.toString().split(" ");

		month1 = yearmonth1[0];
		year1 = yearmonth1[1];
	}
	driver.findElement(By.xpath("//td[.='28']")).click();
	
	addOpportunityPage.selectStatusStageLead(driver);
	
	
	String createdoptyname = driver.findElement(By.xpath("//span[.='"+OpptyName+"']")).getText();
	Assert.assertEquals(createdoptyname, OpptyName);
	
	Reporter.log("Opportunity is created",true);
	
	//edit
	OpportunityVerifyPage opportunityVerifyPage = new OpportunityVerifyPage(driver);
	opportunityVerifyPage.editBtnClick();
	
	int randnum1 = jLib.getRandomNumber();
	
	String newOprtyName = eLib.readDataFromExcel("Opportunity", 1, 0)+randnum1;	
	addOpportunityPage.NewOptyName(driver, newOprtyName);
	
	
	String editedOptyName = driver.findElement(By.xpath("//span[.='"+newOprtyName+"']")).getText();
	
	Assert.assertEquals(newOprtyName, editedOptyName);
	
	Reporter.log("Opportunity is edited",true);
	
	//Delete Opportunity
	
	opportunityVerifyPage.deleteOpty();
	
	Reporter.log("Opportunity is deleted",true);
	}
}
