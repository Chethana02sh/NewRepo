package com.crm.OpportunitiesObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiyPage {

	@FindBy(id = "Potentials_listView_basicAction_LBL_ADD_RECORD") private WebElement addOpportunityBtn;;
	
	@FindBy(xpath  = "//button[@title='Delete']") private WebElement deleteBtnClick;
	
	@FindBy(xpath = "//button[.='Yes']") private WebElement yesBtnClick;
	
	
	public OpportunitiyPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addOpportunityBtnClick()
	{
		addOpportunityBtn.click();
	}
	
	public void selectOpportunityToDelete(WebDriver driver,String Opportunity)
	{
		driver.findElement(By.xpath("//a[.='"+Opportunity+"']/ancestor::tr[@class='listViewEntries']/descendant::input[@class='listViewEntriesCheckBox']")).click();
		deleteBtnClick.click();
		yesBtnClick.click();
	}	
}
