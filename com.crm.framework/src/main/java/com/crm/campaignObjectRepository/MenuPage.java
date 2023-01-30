package com.crm.campaignObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

	@FindBy(xpath = "//div[@class='vtiger-menu-item col-lg-6 textOverflowEllipsis textAlignLeft' and @title='Campaigns']") private WebElement campaignLink;
	
	@FindBy(xpath = "//span[.='MARKETING']/ancestor::div[@class='col-lg-12 MARKETING-container']/descendant::div//a[@title='Contacts']") private WebElement marketingContactLink;
	
	@FindBy(xpath = "//span[.='MARKETING']/ancestor::div[@class='col-lg-12 MARKETING-container']/descendant::div//a[@title='Organizations']") private WebElement marketingOrganisationLik;
	
	@FindBy(xpath = "//span[.='MARKETING']/ancestor::div[@class='col-lg-12 MARKETING-container']/descendant::div//a[@title='Project Opps']") private WebElement marketProjectOOPsLink;
	
	@FindBy(xpath = "//a[@class='menu-item-name vicon-leads']") private WebElement LeadsLink;
	
	@FindBy(xpath = "//span[.='SALES']/ancestor::div[@class='col-lg-12 SALES-container']/descendant::div//a[@title='Project Opps']")
	private WebElement SalesProjectoppsLink;
	
	@FindBy(xpath = "//span[.='SALES']/ancestor::div[@class='col-lg-12 SALES-container']/descendant::div//a[@title='Products']")
	private WebElement SalesProductsLink;
	
	@FindBy(xpath = "//span[.='SALES']/ancestor::div[@class='col-lg-12 SALES-container']/descendant::div//a[@title='Organizations']")
	private WebElement SalesOrganizationsLink;
	
	@FindBy(xpath = "//span[.='SALES']/ancestor::div[@class='col-lg-12 SALES-container']/descendant::div//a[@title='Opportunities']")
	private WebElement SalesOpportunitiesLink;
	
	@FindBy(xpath = "//span[.='SALES']/ancestor::div[@class='col-lg-12 SALES-container']/descendant::div//a[@title='Stakeholders']")
	private WebElement SalesStakeholdersLink;
	
	@FindBy(xpath = "//span[.='SALES']/ancestor::div[@class='col-lg-12 SALES-container']/descendant::div//a[@title='Contacts']")
	private WebElement SalesContactsLink;
	
	@FindBy(xpath = "//span[.='INVENTORY']/ancestor::div[@class='col-lg-12 INVENTORY-container']/descendant::div//a[@title='Products']")
	private WebElement inventoryProductsLink;
	
	@FindBy(xpath = "//span[.='INVENTORY']/ancestor::div[@class='col-lg-12 INVENTORY-container']/descendant::div//a[@title='Purchase Orders']")
	private WebElement inventoryPurchaseOrderLnk;
	
	@FindBy(xpath = "//span[.='INVENTORY']/ancestor::div[@class='col-lg-12 INVENTORY-container']/descendant::div//a[@title='Organizations']")
	private WebElement inventoryOrgLink;
	
	@FindBy(xpath = "//span[.='INVENTORY']/ancestor::div[@class='col-lg-12 INVENTORY-container']/descendant::div//a[@title='Invoices']")
	private WebElement inventoryInvoiceLink;
	
	@FindBy(xpath = "//span[.='INVENTORY']/ancestor::div[@class='col-lg-12 INVENTORY-container']/descendant::div//a[@title='Vendors']")
	private WebElement inventoryVendorsLink;
	
	@FindBy(xpath = "//span[.='INVENTORY']/ancestor::div[@class='col-lg-12 INVENTORY-container']/descendant::div//a[@title='Contacts']")
	private WebElement inventoryContactLnk;
	
	@FindBy(xpath = "//span[.='SUPPORT']/ancestor::div[@class='col-lg-12 SUPPORT-container']/descendant::div//a[@title='Tickets']")
	private WebElement supportTicketsLink;
	
	@FindBy(xpath = "//span[.='SUPPORT']/ancestor::div[@class='col-lg-12 SUPPORT-container']/descendant::div//a[@title='Service Contracts']")
	private WebElement serviceContractLink;
	
	@FindBy(xpath = "//span[.='PROJECT']/ancestor::div[@class='col-lg-12 PROJECT-container']/descendant::div//a[@title='Project Opps']")
	private WebElement projectProjectOopsLink;
	
	@FindBy(xpath = "//span[.='PROJECT']/ancestor::div[@class='col-lg-12 PROJECT-container']/descendant::div//a[@title='Approvals']")
	private WebElement projectApprovalsLink;
	
	@FindBy(xpath = "//span[.='PROJECT']/ancestor::div[@class='col-lg-12 PROJECT-container']/descendant::div//a[@title='Project Tasks']")
	private WebElement projectProjectTasksLink;
	
	@FindBy(xpath = "//span[.='PROJECT']/ancestor::div[@class='col-lg-12 PROJECT-container']/descendant::div//a[@title='Samples']")
	private WebElement projectSamplesLink; 
	
	@FindBy(xpath = "//span[.='PROJECT']/ancestor::div[@class='col-lg-12 PROJECT-container']/descendant::div//a[@title='Proposals']")
	private WebElement projectProposalslink;
	
	@FindBy(xpath = "//span[.='TOOLS']/ancestor::div[@class='col-lg-12 TOOLS-container']/descendant::div//a[@title='GeoTools']")
	private WebElement GeoToolsLink;
	
	@FindBy(xpath = "//span[.='TOOLS']/ancestor::div[@class='col-lg-12 TOOLS-container']/descendant::div//a[@title='Basic Email Templates']")
	private WebElement EmailTemplatesLink;
	
	@FindBy(xpath = "//span[.='TOOLS']/ancestor::div[@class='col-lg-12 TOOLS-container']/descendant::div//a[@title='Events']")
	private WebElement EventsLink;
 	
	@FindBy(xpath = "//span[.='TOOLS']/ancestor::div[@class='col-lg-12 TOOLS-container']/descendant::div//a[@title='Comments']")
	private WebElement ToolsCommentsLink;
	
	@FindBy(xpath = "//span[.='TOOLS']/ancestor::div[@class='col-lg-12 TOOLS-container']/descendant::div//a[@title='Recycle Bin']")
	private WebElement RecycleBinlink;
	
	@FindBy(xpath = "//span[.='TOOLS']/ancestor::div[@class='col-lg-12 TOOLS-container']/descendant::div//a[@title='Tickets']")
	private WebElement toolsTicketsLink;
	
	
	public MenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCampaignLink() {
		return campaignLink;
	}


	public WebElement getLeadsLink() {
		return LeadsLink;
	}


	public WebElement getSalesProjectoppsLink() {
		return SalesProjectoppsLink;
	}


	public WebElement getSalesProductsLink() {
		return SalesProductsLink;
	}


	public WebElement getSalesOrganizationsLink() {
		return SalesOrganizationsLink;
	}


	public WebElement getSalesOpportunitiesLink() {
		return SalesOpportunitiesLink;
	}


	public WebElement getSalesStakeholdersLink() {
		return SalesStakeholdersLink;
	}


	public WebElement getSalesContactsLink() {
		return SalesContactsLink;
	}


	public WebElement getInventoryProductsLink() {
		return inventoryProductsLink;
	}


	public WebElement getSupportTicketsLink() {
		return supportTicketsLink;
	}


	public WebElement getProjectProjectOopsLink() {
		return projectProjectOopsLink;
	}


	public WebElement getProjectApprovalsLink() {
		return projectApprovalsLink;
	}


	public WebElement getProjectProjectTasksLink() {
		return projectProjectTasksLink;
	}


	public WebElement getProjectSamplesLink() {
		return projectSamplesLink;
	}


	public WebElement getProjectProposalslink() {
		return projectProposalslink;
	}


	public WebElement getGeoToolsLink() {
		return GeoToolsLink;
	}


	public WebElement getEmailTemplatesLink() {
		return EmailTemplatesLink;
	}


	public WebElement getEventsLink() {
		return EventsLink;
	}


	public WebElement getToolsCommentsLink() {
		return ToolsCommentsLink;
	}


	public WebElement getRecycleBinlink() {
		return RecycleBinlink;
	}


	public WebElement getToolsTicketsLink() {
		return toolsTicketsLink;
	}


	public WebElement getMarketingContactLink() {
		return marketingContactLink;
	}


	public WebElement getMarketingOrganisationLik() {
		return marketingOrganisationLik;
	}


	public WebElement getMarketProjectOOPsLink() {
		return marketProjectOOPsLink;
	}


	public WebElement getInventoryPurchaseOrderLnk() {
		return inventoryPurchaseOrderLnk;
	}


	public WebElement getInventoryOrgLink() {
		return inventoryOrgLink;
	}


	public WebElement getInventoryContactLnk() {
		return inventoryContactLnk;
	}


	public WebElement getInventoryInvoiceLink() {
		return inventoryInvoiceLink;
	}


	public WebElement getInventoryVendorsLink() {
		return inventoryVendorsLink;
	}


	public WebElement getServiceContractLink() {
		return serviceContractLink;
	}	
	
	
}
