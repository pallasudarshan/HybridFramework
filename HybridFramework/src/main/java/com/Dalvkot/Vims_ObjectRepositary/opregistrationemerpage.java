package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class opregistrationemerpage extends WebDriverUtility {

	private static final String[] FIRST_NAMES = { "jhon", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel",
			"Olivia", "Matthew", "Sophia", "siva", "sam", "salim", "gupta", "chandrakanta", "murali", "babu", "dilli",
			"Leo", "Beast", "vishesh", "dhanush", "simbu", "virat", "dhoni", "siraj", "hardik", "jadeja", "kl rahul",
			"ajith", "lily", "cena", "batista", "kane", "abbas", "boss", "raj", "kumar", "chethan", "venky",
			"raghav", "rishab", "jaggadeesh", "ajay", "vijay", "ramesh", "suresh", "gajesh", "ravi", "rishi", "shashi",
			"unni", "krishna", "sivam", "raju bhai", "doss", };

	public void OPDRegistrationemerpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' OPD Registration ']")
	private WebElement opdRegisatrionBtn;

	@FindBy(xpath = "//a[@title='Events']/ancestor::ul[@class='nav navbar-nav navbar-left']/descendant::a[@class='ls-toggle-btn']")
	private WebElement homeBtn;

	@FindBy(css = "div[aria-label='Please Enter First Name ']")
	private WebElement pleaseEnterFirstName;

	@FindBy(xpath = "//label[text()='Registration Type ']/ancestor::div[@class='form-group col-lg-3 col-md-3 col-xl-3 col-sm-12 col-xs-12']/descendant::span[@class='select2-selection__arrow']")
	private WebElement registartionTypeDrop;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement regTypeTextField;

	@FindBy(xpath = "/html/body/app-root/app-home/app-op-reg-fm/section/div[2]/form/div[1]/div[4]/div/div/div[4]/input")
	private WebElement firstName;
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	private WebElement middleName;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@placeholder='Display Name']")
	private WebElement displaynameText;

	@FindBy(xpath = "//input[@placeholder='Year']")
	private WebElement AgeText;

	@FindBy(xpath = "//label[text()='Gender ']/ancestor::div[@class='form-group col-lg-2 col-xl-2 col-sm-12 col-md-2 col-xs-12']/descendant::span[@class='select2-selection__arrow']")
	private WebElement genderDropdown;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement genderDropdownText;
	@FindBy(xpath = "//label[text()='Marital Status ']/ancestor::div[@class='form-group col-lg-2 col-xl-2 col-sm-12 col-md-2 col-xs-12']/descendant::span[@class='select2-selection__arrow']")
	private WebElement maritalStatus;

	@FindBy(xpath = "//input[@placeholder='Spouse Name']")
	private WebElement spouseNameText;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement maritalStatusText;
	@FindBy(xpath = "//input[@placeholder='Father Name']")
	private WebElement fatherNameText;

	@FindBy(xpath = "//input[@formcontrolname='dateOfBirth']")
	private WebElement dateOfBirthcalender;

	
	
	
	
	public void opdRegistrationButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, opdRegisatrionBtn);
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	public void registrationTypeDropDown(WebDriver driver, String regType) throws Throwable {

		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(registartionTypeDrop)));
		registartionTypeDrop.click();
		Actions reg = new Actions(driver);
		reg.moveToElement(regTypeTextField).sendKeys(regType, Keys.ENTER).perform();
	}

	public void firstNameText(String name) {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		firstName.sendKeys(FIRST_NAMES);
	}

	public void firstName(String name) {
		firstName.sendKeys(name);
	}

	public void dateOfBirthCalenderText(WebDriver driver, String year) {
		dateOfBirthcalender.sendKeys(year);
	}

	public void AgeText(String year) {
		AgeText.sendKeys(year);
	}

}
