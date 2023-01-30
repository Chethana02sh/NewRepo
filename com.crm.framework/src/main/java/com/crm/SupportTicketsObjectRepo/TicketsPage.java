package com.crm.SupportTicketsObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketsPage
{
	@FindBy(id = "HelpDesk_listView_basicAction_LBL_ADD_RECORD")private WebElement addTicketBtn;
	
	
	public TicketsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addTicket()
	{
		addTicketBtn.click();
	}
}
