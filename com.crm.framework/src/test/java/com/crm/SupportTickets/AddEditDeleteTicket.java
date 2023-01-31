package com.crm.SupportTickets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.SupportTicketsObjectRepo.AddTicketPage;
import com.crm.SupportTicketsObjectRepo.TicketVerifyPage;
import com.crm.SupportTicketsObjectRepo.TicketsPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class AddEditDeleteTicket extends BaseClass{

	@Test
	public void addEditDeleteTicket() throws Throwable
	{
		int randNum = jLib.getRandomNumber();
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getSupportTicketsLink().click();
		
		TicketsPage ticketsPage = new TicketsPage(driver);
		ticketsPage.addTicket();
		
		String orgname = eLib.readDataFromExcel("MOrganisation", 0, 1)+randNum;
		String title = eLib.readDataFromExcel("Tickets", 1, 0)+randNum;
		
		AddTicketPage addTicketPage = new AddTicketPage(driver);
		addTicketPage.addTicket(title);
		addTicketPage.selectOtherOption(orgname);
		addTicketPage.getFinalSaveBtn().click();
		
		String CreatedTicketName = driver.findElement(By.xpath("//span[.='"+title+"']")).getText();
		
		Assert.assertEquals(title, CreatedTicketName);
		Reporter.log("Ticket is created",true);
		//edit
		int randNum1 = jLib.getRandomNumber();
		
		String Newtitle = eLib.readDataFromExcel("Tickets", 1, 0)+randNum1;
		TicketVerifyPage ticketVerifyPage = new TicketVerifyPage(driver);
		ticketVerifyPage.edit();
		addTicketPage.addTicket(Newtitle);
		addTicketPage.getFinalSaveBtn().click();
		
		String EditedTicketName = driver.findElement(By.xpath("//span[.='"+Newtitle+"']")).getText();
		
		Assert.assertEquals(Newtitle, EditedTicketName);
		Reporter.log("Ticket is edited",true);
		
		//delete
		ticketVerifyPage.delete();
		Reporter.log("Ticket is deleted",true);
	}
}