package com.crm.organisationObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationVerfyPage {

	@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
	@FindBy(xpath = "//h4[normalize-space(text())='Organizations'] ") private WebElement mainOrgPage;


	public OrganisationVerfyPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		
	public void editBtnClick()
	{
		EditBtn.click();
	}
	public void clickOnOrganisationLink()
	{
		mainOrgPage.click();
	}
}
