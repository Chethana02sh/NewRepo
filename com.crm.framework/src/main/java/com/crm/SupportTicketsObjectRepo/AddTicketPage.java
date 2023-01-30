package com.crm.SupportTicketsObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTicketPage {

	@FindBy(id = "HelpDesk_editView_fieldName_ticket_title")private WebElement TitleNameEdtTxt;
	
	@FindBy(xpath = "//td[contains(.,'Priority')]/..//div[@id='s2id_autogen3']")private WebElement selectPriorityDropdown;
	
	@FindBy(xpath = "//div[.='Normal']")private WebElement selectNormalPty;
	
	@FindBy(id = "HelpDesk_editView_fieldName_parent_id_create")private WebElement selectOrgLookupImg;
	
	@FindBy(id = "Accounts_editView_fieldName_accountname")private WebElement orgNameEdtTxt;
	
	@FindBy(xpath = "//button[@name='saveButton']")private WebElement saveBtn;
//	@FindBy(xpath = "//td[contains(.,'Product')]/..//div[@id='s2id_autogen3']")private WebElement selectProductOption;
	
//	@FindBy(xpath = "//div[.='Armstrong - Condensate & Steam']")private WebElement selectArmStrongProduct;
	
//	@FindBy(id = "Accounts_editView_fieldName_ship_state")private WebElement enterStreetStateEdtTxt;
//	
//	@FindBy(xpath = "//label[contains(.,'Industry')]/../following-sibling::td//div[@id='s2id_autogen176']")private WebElement selectIndustryDropDown;
//	
//	@FindBy(xpath = "//div[.='Chemical']")private WebElement selectChemicalfRomIndustry;
	
	@FindBy(xpath = "//td[contains(.,'Status')]/..//div[@id='s2id_autogen5']")private WebElement selectStatusDropdown;
	
	@FindBy(xpath = "//div[.='In Progress']")private WebElement selectInProgressStatus;
//	@FindBy(xpath = "//td[contains(.,'Category')]/..//div[@id='s2id_autogen1']")private WebElement selectCatagoryOption;
	
//	@FindBy(xpath = "//div[.='Order']")private WebElement selectOrderFromCatagory;
	@FindBy(xpath = "//button[.='Save']")private WebElement finalSaveBtn;
	
	
	public AddTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public WebElement getFinalSaveBtn() {
		return finalSaveBtn;
	}



	public void addTicket(String titleName)
	{
		TitleNameEdtTxt.clear();
		TitleNameEdtTxt.sendKeys(titleName);
	}	
	public void selectOtherOption(String OrgName)	
	{
		selectPriorityDropdown.click();
		selectNormalPty.click();
		selectOrgLookupImg.click();
		orgNameEdtTxt.sendKeys(OrgName);
		saveBtn.click();
		selectStatusDropdown.click();
		selectInProgressStatus.click();
	}
}