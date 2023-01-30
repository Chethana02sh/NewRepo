package com.crm.createCampaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.campaignObjectRepository.CampaignPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class DeleteCampaignTest extends BaseClass {
	@Test
	public void deleteCampaign() throws Throwable {
		String campaignName = eLib.readDataFromExcel("Campaign", 0, 1);
		if(campaignName.equals("#####")) throw new RuntimeException(campaignName+" Campaign Not created. Please create Campaign before edit Campaign");
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		MenuPage menuPage = new MenuPage(driver);
		menuPage.getCampaignLink().click();

		CampaignPage campaignPage = new CampaignPage(driver);
		campaignPage.selectTheCampainToDelete(driver, campaignName);
		eLib.writeDataIntoExcel("Campaign", 0, 1, "#####");
	}
}