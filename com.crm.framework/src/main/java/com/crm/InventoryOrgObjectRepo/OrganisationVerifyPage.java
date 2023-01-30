package com.crm.InventoryOrgObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationVerifyPage {
@FindBy(xpath = "//button[.='Edit']") private WebElement EditBtn;
	
	@FindBy(xpath = "//button[contains(.,'More')]//i")private WebElement moreBtnClick;
	
	@FindBy(xpath = "//a[.='Delete Organization']")private WebElement deleteOprtBtn;
	
	@FindBy(xpath = "//button[.='Yes']")private WebElement yesBtn;
	
	
	
	public OrganisationVerifyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void edit()
	{
		EditBtn.click();
	}
	
	public void delete()
	{
		moreBtnClick.click();
		deleteOprtBtn.click();
		yesBtn.click();
	}
}
