package com.crm.SalesProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.SalesProductObjectRepo.AddProductPage;
import com.crm.SalesProductObjectRepo.ProductPage;
import com.crm.SalesProductObjectRepo.ProductVerifyPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateEditDeleteProduct extends BaseClass
{
	@Test
	public void createEditDeleteProduct() throws Throwable
	{
		int randNum = jLib.getRandomNumber();
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getSalesProductsLink().click();
		
		ProductPage productPage = new ProductPage(driver);
		productPage.addProduct();
		
		String productName = eLib.readDataFromExcel("Product", 1, 0)+randNum;
		
		AddProductPage addProductPage = new AddProductPage(driver);
		addProductPage.ProductName(productName);
		
		String CreatedProductName = driver.findElement(By.xpath("//span[.='"+productName+"']")).getText();
		
		Assert.assertEquals(productName, CreatedProductName);
		
		Reporter.log("Product is created",true);
		
		//edit
		ProductVerifyPage productVerifyPage = new ProductVerifyPage(driver);
		productVerifyPage.edit();
		
		int randNum1 = jLib.getRandomNumber();
		String newProductName = eLib.readDataFromExcel("Product", 1, 0)+randNum1;
		addProductPage.ProductName(newProductName);
		
		String EditedProductName = driver.findElement(By.xpath("//span[.='"+newProductName+"']")).getText();
		Assert.assertEquals(newProductName, EditedProductName);
		
		eLib.writeDataIntoExcel("Product", 0, 1, EditedProductName);
		
		Reporter.log("Product is edited successfully",true);
		//delete
		productVerifyPage.delete();
		
		Reporter.log("Product is deleted successfully",true);
	}
}
