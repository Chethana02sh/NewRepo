package com.crm.createCampaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.campaignObjectRepository.AddCampaignPage;
import com.crm.campaignObjectRepository.CampaignDetailsPage;
import com.crm.campaignObjectRepository.CampaignPage;
import com.crm.campaignObjectRepository.CampaignVerificationPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class EditCampaignTest extends BaseClass {

	@Test
	public void editCampaign() throws Throwable {
		String campaignName = eLib.readDataFromExcel("Campaign", 0, 1);
		if(campaignName.equals("#####")) throw new RuntimeException(campaignName+" Campaign Not created. Please create Campaign before edit Campaign");
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		MenuPage menuPage = new MenuPage(driver);
		menuPage.getCampaignLink().click();

		CampaignPage campaignPage = new CampaignPage(driver);
		campaignPage.selectCampaign(driver, campaignName);

		CampaignVerificationPage campaignVerificationPage = new CampaignVerificationPage(driver);
		campaignVerificationPage.editCampaign();

		CampaignDetailsPage campaignDetailsPage = new CampaignDetailsPage(driver);
		campaignDetailsPage.CampaignStatusDropdown();
		campaignDetailsPage.enterCampaignStatusName(driver, "Completed");

		AddCampaignPage addCampaignPage = new AddCampaignPage(driver);
		addCampaignPage.getSaveBtn().click();

		String campaignStatusName = campaignDetailsPage.enterTheCampaignStatusToVerify(driver, "Completed");

		Assert.assertEquals(campaignStatusName, "Completed");
		System.out.println("testcase is pass");
	}
}