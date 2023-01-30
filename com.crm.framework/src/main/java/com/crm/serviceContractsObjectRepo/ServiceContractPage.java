package com.crm.serviceContractsObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceContractPage {

	@FindBy(id = "ServiceContracts_listView_basicAction_LBL_ADD_RECORD")private WebElement addServiceCrctBtn;
	
	public ServiceContractPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addService()
	{
		addServiceCrctBtn.click();
	}
}
