package com.qa.travel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.travel.base.TestBase;

public class LoginPage extends TestBase {


	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	//create object repository for Login page
	@FindBy(xpath="//input[@name='userName']") WebElement usrNameTxtBox;
	@FindBy(xpath="//input[@name='password']") WebElement passwordTxtBox;
	@FindBy(xpath="//input[@name='login']") WebElement signInBtn;
	@FindBy(xpath="//form[@name='findflight']//font[contains(text(),'Flight')]") WebElement flightDetailsTxt;
	
	

	//method to login to application
	public String loginApplication() 
	{
		usrNameTxtBox.sendKeys("Manidipta");
		passwordTxtBox.sendKeys("Test1234#");
		signInBtn.click();
		return flightDetailsTxt.getText();
	}



}
