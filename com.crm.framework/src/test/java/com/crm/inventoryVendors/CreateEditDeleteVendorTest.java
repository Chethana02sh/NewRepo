package com.crm.inventoryVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;
import com.crm.inventoryVendorObjectRepo.AddVendorPage;
import com.crm.inventoryVendorObjectRepo.VendorPage;
import com.crm.inventoryVendorObjectRepo.VendorVerifyPage;

public class CreateEditDeleteVendorTest extends BaseClass{

	@Test
	public void createEditDeleteVendorTest() throws Throwable
	{
		int randNum = jLib.getRandomNumber();
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getInventoryVendorsLink().click();
		
		VendorPage vendorPage = new VendorPage(driver);
		vendorPage.addVendor();
		
		String vendorName = eLib.readDataFromExcel("Vendors", 1, 0)+randNum;
		
		AddVendorPage addVendorPage = new AddVendorPage(driver);
		addVendorPage.vendorNameSave(vendorName);
		
		String CreatedVendorName = driver.findElement(By.xpath("//span[.='"+vendorName+"']")).getText();
		
		Assert.assertEquals(vendorName, CreatedVendorName);
		
		Reporter.log("Vendor is successfully created",true);
		//edit
		int randNum1 = jLib.getRandomNumber();
		
		String NewVendorName = eLib.readDataFromExcel("Vendors", 1, 0)+randNum1;
		
		VendorVerifyPage vendorVerifyPage = new VendorVerifyPage(driver);
		vendorVerifyPage.edit();
		
		addVendorPage.vendorNameSave(NewVendorName);
		
		String EditedVendorName = driver.findElement(By.xpath("//span[.='"+NewVendorName+"']")).getText();
		
		eLib.writeDataIntoExcel("Vendors",0, 1, EditedVendorName);
		Assert.assertEquals(NewVendorName, EditedVendorName);
		
		Reporter.log("Vendor is successfully edited",true);
		
		//delete
		vendorVerifyPage.delete();
		Reporter.log("Vendor is successfully Deleted",true);
	}
}
