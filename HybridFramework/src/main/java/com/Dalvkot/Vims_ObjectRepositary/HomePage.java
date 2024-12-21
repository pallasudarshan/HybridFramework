package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	// intilization f the WebElements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-close='true']//i[1]")
	private WebElement homeButtonForVims;

	@FindBy(xpath = "//a[text()=' Appointment Booking ']")
	private WebElement appointmentButton;

	@FindBy(xpath = "//i[@class='zmdi zmdi-power']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//a[text()=' Patient Admission ']")
	private WebElement patientAdmissionBtn;

	// userList
	@FindBy(xpath = "//b[text()='USER LIST']")
	private WebElement userListBtn;

	// apoointmnetlogout
	@FindBy(xpath = "//img[@style='max-width: 40px;']")
	private WebElement appLogout;

	@FindBy(xpath = "//i[@class='zmdi zmdi-power']")
	private WebElement logOutapp;

	@FindBy(xpath = "//input[@class='form-control newBorder']")
	private WebElement homepageSearchText;

	@FindBy(xpath = "//input[@placeholder='Search For Page']")
	private WebElement searchText;

	@FindBy(xpath = "//span[normalize-space(text())='OPD Registration']")
	private WebElement opdRegistrationPage;

	// Business Logic
	public void appointmentBtn() {
		appointmentButton.click();
	}

	public void homeBtnForvims(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, homeButtonForVims);
	}

	// Business Logic of a patient Admission button
	public void patientAdmissionBtn() {
		patientAdmissionBtn.click();
	}

	// Business Logic of a search the Screens
	public void homePageSearchText(WebDriver driver, String screenName) {
		homepageSearchText.sendKeys(screenName, Keys.ENTER);

	}

	public void clickOnTheScreenButtons(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, searchText);
		searchText.sendKeys("opd registration");
		opdRegistrationPage.click();
	}

}
