package com.crm.campaignObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtilities.WebDriverUtility;

public class CampaignPage {

	@FindBy(id = "Campaigns_listView_basicAction_LBL_ADD_RECORD") private WebElement addCampaignbtn;
	
	@FindBy(id = "Campaigns_listView_massAction_LBL_DELETE") private WebElement deleteBtnClick;
	
	@FindBy(xpath = "//button[.='Yes']") private WebElement yesBtnClick;
	
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addCampaign()
	{
		addCampaignbtn.click();
	}
	
	public void selectCampaign(WebDriver driver,Object campName)
	{
	//	driver.findElement(By.xpath("//form[@id='listedit']//tbody/tr/td[2]/span//a[.='camp803']"))
		driver.findElement(By.xpath("//a[.='"+campName+"']")).click();
	}
	
	public void selectTheCampainToDelete(WebDriver driver,String campaignName)
	{
		driver.findElement(By.xpath("//a[.='"+campaignName+"']/ancestor::tr[@class='listViewEntries']/descendant::input[@class='listViewEntriesCheckBox']")).click();
		deleteBtnClick.click();
		yesBtnClick.click();
	}
}