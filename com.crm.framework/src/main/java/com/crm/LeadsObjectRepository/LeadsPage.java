package com.crm.LeadsObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(id = "Leads_listView_basicAction_LBL_ADD_RECORD") private WebElement addLeadBtn;
	
	@FindBy(xpath  = "//button[@title='Delete']") private WebElement deleteBtnClick;
	
	@FindBy(xpath = "//button[.='Yes']") private WebElement yesBtnClick;
	
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addLeadBtnClick()
	{
		addLeadBtn.click();
	}
	
	public void selectLeadToDelete(WebDriver driver,String CreatedfirstName)
	{
		driver.findElement(By.xpath("//a[.='"+CreatedfirstName+"']/ancestor::tr[@class='listViewEntries']/descendant::input[@class='listViewEntriesCheckBox']")).click();
		deleteBtnClick.click();
		yesBtnClick.click();
	}
}
