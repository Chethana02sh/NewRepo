package com.crm.OpportunitiesObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOpportunityPage {

	@FindBy(id = "Potentials_editView_fieldName_contact_id_create") private WebElement contactNameLookup;
	
	@FindBy(id = "Contacts_editView_fieldName_firstname") private WebElement CntFirstNameEdtTxt;
	
	@FindBy(id = "Contacts_editView_fieldName_lastname") private WebElement CntLastNameEdtTxt;
	
	@FindBy(xpath = "//button[@name='saveButton']") private WebElement savebtnClick;
	
	@FindBy(id = "Potentials_editView_fieldName_related_to_create") private WebElement orgLookupImg;
	
	@FindBy(id = "Accounts_editView_fieldName_accountname") private WebElement orgNameTxtEdt;
	
	@FindBy(id = "Potentials_editView_fieldName_campaignid_create") private WebElement campaignLookupImg;
	
	@FindBy(id = "Campaigns_editView_fieldName_campaignname") private WebElement campaignNameTxtEdt;
	
	@FindBy(id = "Potentials_editView_fieldName_potentialname") private WebElement opportunityTxtEdt;
	
	@FindBy(id = "Potentials_editView_fieldName_amount") private WebElement priceEdtTxt;
	
//	@FindBy(id = "s2id_autogen7") private WebElement selectStatusDropdn;
	
//	@FindBy(xpath = "//div[.='Won']")private WebElement selectStatusWon;
	
//	@FindBy(xpath = "//td[contains(.,'Sales Stage')]/..//div[@id='s2id_autogen15']//span[.='Select an Option']")private WebElement selesStageDropdown;
	
	@FindBy(xpath = "//div[.='Qualification']")private WebElement selectStageQualification;
	
	@FindBy(id = "s2id_autogen23")private WebElement selectLeadSourceDropDown;
	
	@FindBy(xpath = "//div[.='None']") private WebElement selectNoneFromSelectLeadSource;
	
	
	public AddOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public WebElement getSavebtnClick() {
		return savebtnClick;
	}


	public void selectCnt(String firstName,String lastName,String orgName,String opptyName,String campName) throws InterruptedException
	{
		contactNameLookup.click();
		CntFirstNameEdtTxt.sendKeys(firstName);
		CntLastNameEdtTxt.sendKeys(lastName);
		savebtnClick.click();
		orgLookupImg.click();
		orgNameTxtEdt.sendKeys(orgName);
		savebtnClick.click();
		opportunityTxtEdt.sendKeys(opptyName);
		priceEdtTxt.sendKeys("350");
		campaignLookupImg.click();
		campaignNameTxtEdt.sendKeys(campName);
	}
		
	public void selectStatusStageLead(WebDriver driver)
	{
//		selectStatusDropdn.click();
//		selectStatusWon.click();
//		selesStageDropdown.click();
		driver.findElement(By.xpath("//td[contains(.,'Sales Stage')]/..//div[@id='s2id_autogen7']")).click();
//		Point loc = ele.getLocation();
//		int x = loc.getX();
//		int y = loc.getY();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy("+x+","+y+")");
//		ele.click();
		selectStageQualification.click();
//		WebElement ele1 = driver.findElement(By.xpath("//td[contains(.,'Lead Source')]/following-sibling::td/div"));
//		Point loc1 = ele1.getLocation();
//		int x1 = loc1.getX();
//		int y1 = loc1.getY();
//		JavascriptExecutor js1 = (JavascriptExecutor)driver;
//		js1.executeScript("window.scrollBy("+x1+","+y1+")");
//		ele1.click();
//	//	selectLeadSourceDropDown.click();
//		selectNoneFromSelectLeadSource.click();
		driver.findElement(By.xpath("//button[.='Save']")).click();
	}
	
	public void NewOptyName(WebDriver driver,String newOprtyName)
	{
		opportunityTxtEdt.clear();
		opportunityTxtEdt.sendKeys(newOprtyName);
		driver.findElement(By.xpath("//button[.='Save']")).click();
		
	}
}
