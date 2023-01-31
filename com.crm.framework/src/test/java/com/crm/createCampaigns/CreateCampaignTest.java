package com.crm.createCampaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.campaignObjectRepository.AddCampaignPage;
import com.crm.campaignObjectRepository.CampaignDetailsPage;
import com.crm.campaignObjectRepository.CampaignPage;
import com.crm.campaignObjectRepository.CampaignVerificationPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateCampaignTest extends BaseClass {
	@Test
	public void createCampaignTest() throws Throwable {

		
		int randNum = jLib.getRandomNumber();

		String CampaignName = eLib.readDataFromExcel("Campaign", 1, 0) + randNum;
		
		wLib.waitForPageToLoad(driver);

		// HomePage homePage = new HomePage(driver);
		// homePage.clickOnMenuBtn(driver);

		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getCampaignLink().click();

		CampaignPage campaignPage = new CampaignPage(driver);
		campaignPage.addCampaign();

		AddCampaignPage addCampaignPage = new AddCampaignPage(driver);
		addCampaignPage.campaignname(driver, CampaignName);

		driver.findElement(By.xpath("//i[@class='fa fa-calendar ']")).click();
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
		driver.findElement(By.xpath("//td[.='16']")).click();

		addCampaignPage.getSaveBtn().click();
		
		Thread.sleep(3000);
		String campName = driver.findElement(By.xpath("//span[.='" + CampaignName + "']")).getText();

		Assert.assertEquals(campName, CampaignName);
       eLib.writeDataIntoExcel("Campaign", 0, 1, campName);
		
		Reporter.log("Campaign is created",true);
		
		//edit
		CampaignVerificationPage campaignVerificationPage = new CampaignVerificationPage(driver);
		campaignVerificationPage.editCampaign();

		CampaignDetailsPage campaignDetailsPage = new CampaignDetailsPage(driver);
		campaignDetailsPage.CampaignStatusDropdown();
		campaignDetailsPage.enterCampaignStatusName(driver, "Completed");

		addCampaignPage.getSaveBtn().click();

		String campaignStatusName = campaignDetailsPage.enterTheCampaignStatusToVerify(driver, "Completed");

		Assert.assertEquals(campaignStatusName, "Completed");
		Reporter.log("Campaign is edited",true);
		//delete
		campaignVerificationPage.delete();
		Reporter.log("Campaign is deleted");
	}
}