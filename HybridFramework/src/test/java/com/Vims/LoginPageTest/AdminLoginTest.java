package com.Vims.LoginPageTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.ExcelUtility;
import com.Dalvkot.Vims_GenericUtility.FileUtility;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class AdminLoginTest {


	
	/*Test
	public void VerifyThatUserShouldnotloginByGivingValidUsernameAndInInValidPassword_Test() throws Throwable {
		FileUtility util = new FileUtility();
		String url = util.getProperyKeyValue("url");
		String errormsg = "Please enter your password!";
		String username = "sudarshan@dalvkot.com";
		String password = "";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplicationToApp(url, username, password, driver);
		String errormsg1 = loginpage.pleaseEnterYourPasswordMessage();
		loginpage.clickOnOkButton(driver);
		System.out.println(errormsg1);
		Assert.assertEquals(errormsg, errormsg1);
		System.out.println("User got the :" + errormsg1 + "  Successfully");
		driver.close();

	}

	@Test
	public void VerifyThatUserShouldnotloginByGivivngInValidUsernameAndValidPassword_Test() throws Throwable {

		FileUtility util = new FileUtility();
		String url = util.getProperyKeyValue("url");
		String errormsg = "Please provide valid email or phone number.";
		String username = "sudarshan@dalvkot.c";
		String password = "123456";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplicationToApp(url, username, password, driver);
		String errormsg1 = loginpage.pleaseProvideValidEmailOrPhoneNumber();
		loginpage.clickOnOkButton(driver);
		Assert.assertEquals(errormsg, errormsg1);
		System.out.println("User got the :" + errormsg1 + "  Successfully");
		driver.quit();

	}

	@Test
	public void VerifyThatUserShouldnotloginByGivivngInvalidUsernameAndInvalidPassword_Test() throws Throwable {

		FileUtility util = new FileUtility();
		String url = util.getProperyKeyValue("url");
		String errormsg = "Please provide valid email or phone number.";
		String username = "sudarshan@dalvkot.c";
		String password = "1234";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplicationToApp(url, username, password, driver);
		String errormsg1 = loginpage.pleaseProvideValidEmailOrPhoneNumber();
		loginpage.clickOnOkButton(driver);
		Assert.assertEquals(errormsg1, errormsg);
		System.out.println("login page not opend");
		driver.quit();

	}

	@Test
	public void VerifyThatUserShouldNotLoginWithoutEnteringUsernameAndPassword_Test() throws Throwable {

		FileUtility util = new FileUtility();
		String url = util.getProperyKeyValue("url");
		String errormsg = "Please enter your password!";
		String username = "";
		String password = "";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplicationToApp(url, username, password, driver);
		String errormsg1 = loginpage.pleaseEnterYourPasswordMessage();
		loginpage.clickOnOkButton(driver);
		Assert.assertEquals(errormsg1, errormsg);
		System.out.println("login page not opend");
		driver.quit();
	}

//	  
	/*@Test
	public void VerifyThatUserShouldAbleTologinByGivingCaseSensitiveOfUsername_Test() throws Throwable {
		FileUtility util = new FileUtility();
		String url = util.getProperyKeyValue("url");
		String errormsg = "Your userName or Password do not match.";
		String username = "SUDARSHAN@DALVKOT.COM";
		String password = "123456";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplicationToApp(url, username, password, driver);
		driver.quit();
	}*/

//	  

	/*@Test
	public void checkThatUserShouldAcceptTheTermsAndConditions_Test() throws Throwable {

		FileUtility util = new FileUtility();
		String url = util.getProperyKeyValue("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnTheTermsAndConditions(driver);
		Thread.sleep(3000);
		loginpage.clickOnIAcceptButton(driver);
		driver.quit();
	}

	@Test
	public void checkThatUseeShouldDoTheForgetPassword_Test() throws Throwable {

		FileUtility util = new FileUtility();
		String username = "SUDARSHAN@DALVKOT.COM";
		String msg1 = "reset password request has been sent for verification.";

		String url = util.getProperyKeyValue("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(driver, username);
		loginpage.clickOnFogetPasswordButton(driver);
		loginpage.clickOnSendResetLink(driver);
		String msg = loginpage.resetpasswordRequestHasBeenSentForVerification();
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the succesfully message as : " + msg);
		driver.quit();

	}*/

}
