package com.crm.ProjectOOPS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.campaignObjectRepository.MenuPage;
import com.crm.genericUtilities.BaseClass;
import com.crm.organisationObjectRepo.OrganisationVerfyPage;
import com.crm.projectOOPSObjectRepo.CreateNewProjectOOPSPage;
import com.crm.projectOOPSObjectRepo.ProjectOOPSVerifyPage;
import com.crm.projectOOPSObjectRepo.ProjectOopspage;

public class CreateEditDeleteProjectOoops extends BaseClass{

	@Test
	public void createEditDeleteProjectOoops() throws Throwable
	{
		WebElement ele = driver.findElement(By.xpath("//a[@title='Menu']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		MenuPage menuPage = new MenuPage(driver);
		menuPage.getMarketProjectOOPsLink().click();
		
		ProjectOopspage projectOopspage = new ProjectOopspage(driver);
		projectOopspage.addRecordBtnClick();
		
		String ProjectName = eLib.readDataFromExcel("ProjectOOPS", 1, 0);
		CreateNewProjectOOPSPage createNewProjectOOPSPage = new CreateNewProjectOOPSPage(driver);
		createNewProjectOOPSPage.projectNameEnter(ProjectName);
		
		String CreatedProjectName = driver.findElement(By.xpath("//span[.='"+ProjectName+"']")).getText();
		
		Assert.assertEquals(ProjectName, CreatedProjectName);
		
		Reporter.log("project oops is created",true);
		
		//Edit organisation
	    ProjectOOPSVerifyPage projectOOPSVerifyPage = new ProjectOOPSVerifyPage(driver);
	    projectOOPSVerifyPage.editBtnClick();
		
		int randNum1 = jLib.getRandomNumber();
		
		String NewProjectName = eLib.readDataFromExcel("ProjectOOPS", 1, 0)+randNum1;
		
		createNewProjectOOPSPage.projectNameEnter(NewProjectName);
		
		String EditedProjectName = driver.findElement(By.xpath("//span[.='"+NewProjectName+"']")).getText();
		
		Assert.assertEquals(NewProjectName, EditedProjectName);
		
		Reporter.log("ProjectName is successfully edited",true);
		
		//Delete Organisation
		projectOOPSVerifyPage.clickOnProjectOOPSLink();
		
		projectOopspage.selectRecordToDelete(driver, EditedProjectName);
		
		Reporter.log("Project is successfully deleted",true); 
		
	}
}
