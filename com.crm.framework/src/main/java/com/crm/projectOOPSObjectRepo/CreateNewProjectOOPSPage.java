package com.crm.projectOOPSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProjectOOPSPage {

	@FindBy(id = "Projects_editView_fieldName_projectname") private WebElement projectNameTxtEdt;
	
	@FindBy(xpath = "//button[.='Save']") private WebElement saveBtnClick;


	public CreateNewProjectOOPSPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	public void projectNameEnter(String projectName)
	{
		projectNameTxtEdt.clear();
		projectNameTxtEdt.sendKeys(projectName);
		saveBtnClick.click();
	}
}
