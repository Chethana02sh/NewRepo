package com.crm.organisationObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	@FindBy(id = "Accounts_listView_basicAction_LBL_ADD_RECORD") private WebElement addOrganisationbtn;
	
	@FindBy(xpath  = "//button[@title='Delete']") private WebElement deleteBtnClick;
	
	@FindBy(xpath = "//button[.='Yes']") private WebElement yesBtnClick;
	
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addOrgbtnClick()
	{
		addOrganisationbtn.click();
	}
	
	public void selectOrgToDelete(WebDriver driver,String OrgName)
	{
		driver.findElement(By.xpath("//a[.='"+OrgName+"']/ancestor::tr[@class='listViewEntries']/descendant::input[@class='listViewEntriesCheckBox']")).click();
		deleteBtnClick.click();
		yesBtnClick.click();
	}
}
