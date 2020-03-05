package com.qa.travel.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.travel.base.TestBase;
import com.qa.travel.pages.LoginPage;

public class TC01_LoginPageTest extends TestBase {
	
	
	LoginPage loginPage;
	
	@BeforeClass
	public void setUpTest() {
		startApplication(configData.getURL(), configData.getBrowser());
		loginPage = new LoginPage();
	}
	
	@Test (priority =1)
	public void validateLoginApplicationTest() 
	{
		assertEquals(loginPage.loginApplication(), "Flight Details");
	}

}

