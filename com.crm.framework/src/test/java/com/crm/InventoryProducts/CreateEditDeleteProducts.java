package com.crm.InventoryProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.InventoryProductsObjectRepo.AddProductPage;
import com.crm.InventoryProductsObjectRepo.ProductPage;
import com.crm.InventoryProductsObjectRepo.ProductVerifyPage;
import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;

public class CreateEditDeleteProducts extends BaseClass {
	@Test
	public void createEditDeleteProducts() throws Throwable 
	{
		int randNum = jLib.getRandomNumber();
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getInventoryProductsLink().click();
		
		ProductPage productPage = new ProductPage(driver);	
		productPage.addProduct();
		
		String productName = eLib.readDataFromExcel("Product", 1, 0)+randNum;
		
		AddProductPage addProductPage = new AddProductPage(driver);
		addProductPage.addProductNameAndSave(productName);
		
		String CreatedProductName = driver.findElement(By.xpath("//span[.='"+productName+"']")).getText();
		
		Assert.assertEquals(productName, CreatedProductName);
		
		Reporter.log("Product is successfully created",true);
		//edit
		int randNum1 = jLib.getRandomNumber();
		
		ProductVerifyPage productVerifyPage = new ProductVerifyPage(driver);
		productVerifyPage.edit();
		
		String NewProductName = eLib.readDataFromExcel("Product", 1, 0)+randNum1;
		
		addProductPage.addProductNameAndSave(NewProductName);
		
		String EditedProductName = driver.findElement(By.xpath("//span[.='"+NewProductName+"']")).getText();
		
		Assert.assertEquals(NewProductName, EditedProductName);
		
		Reporter.log("product is successfully edited",true);
		
		//delete
		productVerifyPage.delete();
		
		Reporter.log("product is successfully deleted",true);
		}
}
