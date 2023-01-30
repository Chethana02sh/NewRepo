package com.crm.projectOOPSObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectOopspage {

	@FindBy(id = "Projects_listView_basicAction_LBL_ADD_RECORD") private WebElement addRecordBtn;;
	
	@FindBy(xpath  = "//button[@title='Delete']") private WebElement deleteBtnClick;
	
	@FindBy(xpath = "//button[.='Yes']") private WebElement yesBtnClick;
	
	
	public ProjectOopspage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addRecordBtnClick()
	{
		addRecordBtn.click();
	}
	
	public void selectRecordToDelete(WebDriver driver,String projectName)
	{
		driver.findElement(By.xpath("//a[.='"+projectName+"']/ancestor::tr[@class='listViewEntries']/descendant::input[@class='listViewEntriesCheckBox']")).click();
		deleteBtnClick.click();
		yesBtnClick.click();
	}	
}
