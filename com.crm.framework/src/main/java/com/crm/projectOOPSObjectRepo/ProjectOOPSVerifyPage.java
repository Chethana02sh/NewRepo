package com.crm.projectOOPSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectOOPSVerifyPage {

@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
	@FindBy(xpath = "//h4[normalize-space(text())='Project Opps'] ") private WebElement mainOOPsPage;


	public ProjectOOPSVerifyPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		
	public void editBtnClick()
	{
		EditBtn.click();
	}
	public void clickOnProjectOOPSLink()
	{
		mainOOPsPage.click();
	}
}
