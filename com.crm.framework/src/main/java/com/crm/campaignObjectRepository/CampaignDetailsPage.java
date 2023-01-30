package com.crm.campaignObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignDetailsPage 
{
	@FindBy(xpath = "//td[contains(.,'Campaign Status')]/..//div[@id='s2id_autogen3']") private WebElement CampaignStatus;
	
	public CampaignDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void CampaignStatusDropdown()
	{
		CampaignStatus.click();
	}
	
	public void enterCampaignStatusName(WebDriver driver,String SelectCampStatus)
	{
		driver.findElement(By.xpath("//div[.='"+SelectCampStatus+"']")).click();
	}
	
	public String enterTheCampaignStatusToVerify(WebDriver driver,String CampaignStatus)
	{
		String status = driver.findElement(By.xpath("//span[normalize-space(text())='"+CampaignStatus+"']")).getText();
		return status;
	}
}
