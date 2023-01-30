package com.crm.SalesOrganisationObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	@FindBy(id = "Accounts_listView_basicAction_LBL_ADD_RECORD")private WebElement addOrganisationEtTxt;
	
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addOrg()
	{
		addOrganisationEtTxt.click();
	}
}
