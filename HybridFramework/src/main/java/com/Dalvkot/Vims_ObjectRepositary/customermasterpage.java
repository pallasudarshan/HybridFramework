package com.Dalvkot.Vims_ObjectRepositary;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class customermasterpage extends WebDriverUtility {

	public customermasterpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private static final String[] FIRST_NAMES = { "John", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel",
			"Olivia", "Matthew", "Sophia" };

	private static final String[] LAST_NAMES = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller",
			"Wilson", "Moore", "Taylor" };

///xpath for customer master

	@FindBy(xpath = "//b[text()='Masters']")
	private WebElement clickonmasterbtnVims;

	@FindBy(xpath = "//span[text()=' Customer Master ']")
	private WebElement clickoncustomermasterbtnVims;

	@FindBy(xpath = "//button[text()=' Add']")
	private WebElement clickonaddbtnVims;

	@FindBy(xpath = "//label[text()='Customer Category']/ancestor::div[@class='row body']/descendant::span[@class='select2-selection__arrow']")
	private WebElement customercategorydropdownVims;

	@FindBy(xpath = "//input[contains(@class,'form-control customerName')]")
	private WebElement enterthecustomernamefeildVims;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchboxindropdown;

	@FindBy(xpath = "//label[text()='Email']/ancestor::div[@class='row body']/descendant::input[@placeholder='Enter Email']")
	private WebElement emailtextField;

	@FindBy(xpath = "//label[text()='Land line Number 1']/following-sibling::input")
	private WebElement Enterthelandlinumber;

	@FindBy(xpath = "//label[text()='Mobile Number 1']/following-sibling::input")
	private WebElement Enterthemobilenumber;

	@FindBy(xpath = "//label[text()='Fax Number']/following-sibling::input")
	private WebElement Enterthefaxnumber;

	@FindBy(xpath = "//label[text()='Pin Code']/following-sibling::input")
	private WebElement Enterthepincode;

	@FindBy(xpath = "(//span[@title='Post Office']/following-sibling::span)[1]")
	private WebElement postOfficeDropdown;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement postOfficeDropdownText;

	@FindBy(xpath = "//textarea[@placeholder='Enter Address']")
	private WebElement Entertheaddress;

	@FindBy(xpath = "//span[@title='Select IP Rate Type']/following-sibling::span[1]")
	private WebElement clickonipdratelink;

	@FindBy(xpath = "//span[@title='Select OP Rate Type']/following-sibling::span[1]")
	private WebElement clickonopdratelink;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement clickonsubmitbtn;

	@FindBy(xpath = "//input[@placeholder='Enter Web Site']")
	private WebElement enterthewebsitefield;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement clickonokbtn;

	@FindBy(xpath = "//input[@placeholder='Customer Name']")
	private WebElement Enterthecustomername;
//		
//		@FindBy(xpath = "//button[text()='OK']")
//		private WebElement clickonokbtn;
//		
//		
//		@FindBy(xpath = "//button[text()='OK']")
//		private WebElement clickonokbtn;
//		
//		
//		@FindBy(xpath = "//button[text()='OK']")
//		private WebElement clickonokbtn;
//		
//		
//		@FindBy(xpath = "//button[text()='OK']")
//		private WebElement clickonokbtn;
//		
//		
//		@FindBy(xpath = "//button[text()='OK']")
//		private WebElement clickonokbtn;
//		
//		
//		@FindBy(xpath = "//button[text()='OK']")
//		private WebElement clickonokbtn;
//		

	//// Business logics

	public void ClickOnmasters(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, clickonmasterbtnVims);
	}

	private String generateRandomName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void ClickOncustomermaster(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, clickoncustomermasterbtnVims);
	}

	public void ClickOnaddbutton(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, clickonaddbtnVims);
	}

	public void Enterdatacustomercategorydropdown(WebDriver driver, String customercategory) {
		customercategorydropdownVims.click();
		moveToElementAndEnterTheData(driver, searchboxindropdown, customercategory);
	}

	public void customerNameTextfield(WebDriver driver) {
		Random random = new Random();
		String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
		String fullName = (firstName + " " + lastName);
		enterthecustomernamefeildVims.sendKeys(fullName);
	}

	public void emailTextField(WebDriver driver) {
		Random random = new Random();
		String randomName = generateRandomName();
		System.out.println("The random name is: " + randomName);
		String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
		String email = firstName + "." + lastName + "@" + "gmail.com";
		emailtextField.sendKeys(email);
	}

	public void enterthelandlinenumber(WebDriver driver, String number) {
		Enterthelandlinumber.sendKeys(number);

	}

	public void enterthemobilenumber(WebDriver driver, String number1) {
		Enterthemobilenumber.sendKeys(number1);
	}

	public void enterthefaxnumber(WebDriver driver, String number2) {
		Enterthefaxnumber.sendKeys(number2);
	}

	public void pincodeTextField(WebDriver driver, String pincode) {
		Enterthepincode.sendKeys(pincode);
	}

	public void postOfficeDropdown(WebDriver driver, String postOffice) throws InterruptedException {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			try {
				postOfficeDropdown.click();
				break;
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
	}

	public void enterthewebsiteield(WebDriver driver, String website) {
		enterthewebsitefield.sendKeys(website);
	}

	public void entertheaddress(WebDriver driver, String Address) {
		Entertheaddress.sendKeys(Address);
	}

	public void Clickontheipdratelinkdropdown(WebDriver driver, String ipdratelinkdropdown) {
		invisibiltyOf_Element_ThreeDots(driver);
		moveToTheParticularElementAndClick(driver, clickonipdratelink);
		moveToElementAndEnterTheData(driver, searchboxindropdown, ipdratelinkdropdown);
	}

	public void Clickontheopdratelinkdropdown(WebDriver driver, String opdratelinkdropdown) {
		invisibiltyOf_Element_ThreeDots(driver);
		moveToTheParticularElementAndClick(driver, clickonopdratelink);
		moveToElementAndEnterTheData(driver, searchboxindropdown, opdratelinkdropdown);
	}

	public void ClickOnsubmitbutton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, clickonsubmitbtn);
	}

	public void Clickonokbutton(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, clickonokbtn);
	}

}
