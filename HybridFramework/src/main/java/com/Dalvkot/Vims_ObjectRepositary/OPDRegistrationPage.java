package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class OPDRegistrationPage extends WebDriverUtility {
	public OPDRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// -------------------------------Random names for OPD registration
	// (male/female)-----------------------------------------------------------------

	private static final String[] FIRST_NAMES = { "jhon", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel",
			"Olivia", "Matthew", "sirish", "siva", "sam", "salim", "gupta", "chandrakanta", "murali", "babu", "dilli",
			"Leo", "Beast", "vishesh", "dhanush", "simbu", "virat", "dhoni", "siraj", "hardik", "jadeja", "kl rahul",
			"ajith", "lion", "cena", "batista", "kane", "vasanth", "abbas", "boss", "raj", "kumar", "chethan", "venky",
			"raghav", "rishab", "jaggadeesh", "ajay", "vijay", "ramesh", "suresh", "gajesh", "ravi", "rishi", "shashi",
			"praveen", "krishna", "sivam", "raju", "doss", "bheem", "kaushik", "keshu", "dan", "karthik", "mani",
			"lakshman", "Aarav", "Abhinav", "Aditya", "Alok", "Amit", "Aniket", "Anirudh", "Arjun", "Ashok", "Ayush",
			"Deepak", "Devendra", "Dinesh", "Ganesh", "Gaurav", "Hari", "Harsh", "Himanshu", "Ishaan", "Jatin", "Karan",
			"Karthik", "Kunal", "Lalit", "Manish", "Mayank", "Mukesh", "Naveen", "Nikhil", "Nitin", "Parth", "Prakash",
			"Pranav", "Rahul", "Rajat", "Rajesh", "Rajiv", "Rakesh", "Rohit", "Sachin", "Sameer", "Sanjay", "Satish",
			"Shivam", "Siddharth", "Sourabh", "Subhash", "Sumeet", "Sunil", "Suraj", "Tarun", "Uday", "Umesh", "Vikas",
			"Vikram", "Vinay", "Vivek", "Yash", "Abhishek", "Aman", "Ankit", "Anuj", "Arvind", "Ashish", "Bhavesh",
			"Chandan", "Chetan", "Darshan", "Gopal", "Hitesh", "Jagdish", "Jayesh", "Kaushal", "Kishan", "Mahesh",
			"Mohan", "Narayan", "Navin", "Pankaj", "Pradeep", "Pramod", "Rajendra", "Ravi", "Rohit", "Sandeep",
			"Shankar", "Shashank", "Shubham", "Sudhir", "Vijay", "Vimal", "Vishal", "Yogesh" };

	private static final String[] FEMALE_NAMES = { "reshma", "chitra", "shrushti", "kajal", "seema", "seeta", "komathi",
			"samantha", "roja", "Sophia", "sishobava", "leela", "jasmin", "kanchana", "kamala", "lakshmi", "veena",
			"meena", "geetha", "shobana", "lily", "Aishwarya", "Ananya", "Anjali", "Anushka", "Archana", "Arpita",
			"Bhavana", "Chitra", "Deepika", "Divya", "Gayatri", "Gitanjali", "Indira", "Isha", "Juhi", "Kajal", "Kavya",
			"Khushi", "Lakshmi", "Madhavi", "Madhuri", "Mala", "Mallika", "Manisha", "Meenakshi", "Megha", "mughi",
			"Neha", "Nisha", "Pooja", "Prachi", "Pragya", "Pratima", "poonam", "Radha", "Rashmi", "Rekha", "Renuka",
			"Rhea", "Riya", "Roopa", "Roshni", "Sangeeta", "Sapna", "Shikha", "Shilpa", "Simran", "Smita", "Sneha",
			"Sonam", "Sonia", "Suman", "Sunita", "Swati", "Tara", "Trisha", "Uma", "Usha", "Vaishali", "Vandana",
			"Varsha", "Veena", "Vidya", "Yamini", "Aditi", "Amrita", "Anita", "Ankita", "Aparna", "Ashwini", "Chhaya",
			"Deepti", "Ekta", "Gauri", "Jaya", "Kiran", "Lata", "Leena", "Manju", "Mitali", "sara", "Neelam", "Nidhi",
			"Pallavi", "Poonam", "Rachana", "Rashika", "Rina", "Ritu", "Roshan", "Sarika", "Shalini", "Sheetal",
			"Shraddha", "Shubha", "Sujata", "Tanuja", "Trupti", "Urmila", "Vidhi" };

	private static final String[] DEPARTMENT_NAMES = {

			"Cardiology", "Orthopedics", "Neurology", "Gastroenterology", "Ophthalmology", "Dermatology", "Pediatrics",
			"Oncology", "Urology", "ENT", "Emergency Medicine", "Psychiatry", "Obs", "General Surgery",
			"General medicine",

	};

	private static final String[] genders = { "male", "female", };

	Random random1 = new Random();
	String gender = genders[random1.nextInt(genders.length)];

	// ---------------------------XPATHS-------------------------------------------------------------------------------------------------------------

	@FindAll({ @FindBy(xpath = "//span[text()=' OPD Registration ']") })
	private WebElement opdRegisatrionBtn;

	@FindBy(css = "div[aria-label='Please Enter First Name ']")
	private WebElement pleaseEnterFirstName;

	@FindBy(css = "div[aria-label='Please Select Date Of Birth']")
	private WebElement pleaseSelectDateOfBirth;

	@FindBy(css = "div[aria-label='Please Enter Father Name ']")
	private WebElement pleaseEnterFatherName;

	@FindBy(css = "div[aria-label='Please Enter Mobile Number']")
	private WebElement pleaseEnterMobileNumber;

	@FindBy(css = "div[aria-label='Please Enter Email Id']")
	private WebElement pleaseEnterEmailId;

	@FindBy(css = "div[aria-label='Please Enter Address']")
	private WebElement pleaseEnterAddress;

	@FindBy(css = "div[aria-label='Please Enter Aadhar Number']")
	private WebElement pleaseEnterAdharNumber;

	@FindBy(css = "div[aria-label='Please Enter Pincode']")
	private WebElement pleaseEnterPincode;

	@FindBy(css = "div[aria-label='Please Select Post Office ']")
	private WebElement pleaseSelectPostOffice;

	@FindBy(css = "div[aria-label='Please Select Department']")
	private WebElement pleaseSelectDepartment;

	@FindBy(css = "div[aria-label='Please Select Unit']")
	private WebElement pleaseSelectUnit;

	@FindBy(css = "div[aria-label='Please Enter Valid Mobile Number']")
	private WebElement pleaseEnterValidMobileNumber;

	@FindBy(css = "div[aria-label='Please Enter Valid Email Id']")
	private WebElement pleaseEnterTheValidEmailId;

	@FindBy(xpath = "//input[@formcontrolname='parentHospitalNumber']")
	private WebElement parentHospitalNumber;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement successfullyFetchDetailsOfOpPatient;

	@FindBy(xpath = "//label[text()='Registration Type ']/..//span[@role='presentation']")
	private WebElement registartionTypeDropdown;

	@FindBy(css = "input[id='hospitalNumberRevisit']")
	private WebElement hospitalNumberRevisit;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement regTypeTextField;

	@FindBy(xpath = "//label[text()='Gender ']/..//span[@role='presentation']")
	private WebElement genderDropdownBtn;

	@FindBy(xpath = "//label[text()='Patient Type ']/..//span[@role='presentation']")
	private WebElement patientTypeDrop;

	@FindBy(xpath = "//label[text()='Financial Responsibility']/..//span[@role='presentation']")
	private WebElement financialResponsibility;

	@FindBy(xpath = "//span[@title='MR']/following-sibling::span[1]")
	private WebElement patientTitle_DropDOwn;

	@FindBy(xpath = "//label[text()='Patient Category ']/..//span[@role='presentation']")
	private WebElement patientCategoryDrop;

	@FindBy(xpath = "//label[text()=' Patient Title ']/..//span[@role='presentation']")
	private WebElement patientTitleDropdownBtn;

	@FindBy(xpath = "(//label[text()='First Name ']/..//input[@id='firstNameValueNew'])[2]")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	private WebElement middleName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Display Name']")
	private WebElement displaynameText;

	@FindBy(xpath = "//input[@placeholder='Year']")
	private WebElement AgeText;

	@FindBy(xpath = "//input[@placeholder='Spouse Name']")
	private WebElement spouseNameText;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement maritalStatusText;

	@FindBy(xpath = "//input[@placeholder='Father Name']")
	private WebElement fatherNameText;

	@FindBy(xpath = "//input[@placeholder='Mother Name']")
	private WebElement motherNameText;

	@FindBy(xpath = "//input[@placeholder='Landline Number']")
	private WebElement landlineNumberText;

	@FindBy(xpath = "//input[@placeholder='STD/ISD']")
	private WebElement stdISDText;

	@FindBy(xpath = "//span[@title='Blood Group']/following-sibling::span[1]")
	private WebElement bloodDropdownText;

	@FindBy(id = "validatemail")
	private WebElement emailText;

	@FindBy(xpath = "//input[@formcontrolname='passportNumber']")
	private WebElement passportNumberText_Nationality;

	@FindBy(xpath = "//input[@formcontrolname='visaNumber']")
	private WebElement visaNumber_Nationality;

	@FindBy(xpath = "//label[text()='Post Office']/following::i/..//descendant::span[@role='presentation']")
	private WebElement postOfficeDropdown;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement postOfficeDropdownText;

	@FindBy(xpath = "(//input[@formcontrolname='idProofNo'])[2]")
	private WebElement adharIdProofText;

	@FindBy(xpath = "//input[@formcontrolname='dateOfBirth']")
	private WebElement dateOfBirthcalender;

	@FindBy(css = "input[formcontrolname='policeStation']")
	private WebElement policeStationText;

	@FindBy(xpath = "//span[@title='Next Of Kin']/following-sibling::span[1]")
	private WebElement nextOfKinDropdown;

	@FindBy(xpath = "//table//tr/td/descendant::input[@name='name']")
	private WebElement nextOfKinNameText;

	@FindBy(xpath = "//table//tr/td/descendant::input[@placeholder='Mobile Number']")
	private WebElement nextOfKinMobileText;

	@FindBy(xpath = "//table//tr/td/descendant::input[@placeholder='Email']")
	private WebElement nextOfKinEmailText;

	@FindBy(xpath = "//table//tr/td/descendant::button//i")
	private WebElement nextOfKinPlusButton;

	@FindBy(xpath = "//i[@class='zmdi zmdi-cloud-upload']")
	private WebElement uploadButton;

	@FindBy(xpath = "//input[@id='file']")
	private WebElement chooseFile;

	@FindBy(xpath = "//button[@id='closeUpload']")
	private WebElement submit_UploadBtn;

	@FindBy(xpath = "(//input[@placeholder='Mobile Number'])[1]")
	private WebElement mobileNumber;

	@FindBy(xpath = "//label[text()='Mobile Number ']/../..//span[@data-off='No']/following-sibling::span")
	private WebElement unavailableButon_MobileNum;

	@FindBy(id = "validatemail")
	private WebElement mailTextfield;

	@FindBy(xpath = "//label[text()='Email Address ']/../..//span[@data-off='No']/following-sibling::span")
	private WebElement unavailableBtn_Email;

	@FindBy(xpath = "//textarea[@placeholder='Address']")
	private WebElement adressTextField;

	@FindBy(xpath = "//input[@placeholder='Pincode'][1]")
	private WebElement pincodeTextField;

	@FindBy(xpath = "//label[text()=' Doctor ']/..//span[@role='presentation']")
	private WebElement doctorDropdownBtn;

	@FindBy(xpath = "//label[text()=' Department ']/..//span[@role='presentation']")
	private WebElement departmentDropdown;

	@FindBy(xpath = "//label[text()='ID Proof ']/..//span[@role='presentation']")
	private WebElement idProofDropdownBtn;

	@FindBy(css = "input.select2-search__field")
	private WebElement dropdownText;

	@FindBy(xpath = "//input[@placeholder='Referred by speciality']")
	private WebElement referredBySepeciality;

	@FindBy(xpath = "(//button[text()=' Submit '])[1]")
	private WebElement submitBtn;

	@FindBy(xpath = "/html/body/div/div/div[3]/button[3]")
	private WebElement newRegistrationPopupBtnForVims;

	@FindBy(xpath = "//input[@placeholder='Appointment Number']")
	private WebElement appointmentNumberText;

	@FindBy(xpath = "//button[@id='closeModalForEdit']/descendant::i[@class='zmdi zmdi-card-sd']")
	private WebElement appointmentDetails;

	@FindBy(xpath = "(//input[@placeholder='Hospital Number'])[1]")
	private WebElement hospitalNumberFeidl_CrossReferral;

	@FindBy(id = "hospitalNumberRevisit")
	private WebElement hospitalNumberText;

	@FindBy(css = "textarea[placeholder='Reason for Cancellation']")
	private WebElement reasonOfCancellationText;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement successfullyCancelledBtn;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownsText;

	@FindBy(css = "textarea[placeholder='Reason']")
	private WebElement reasonTextField;

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[2]")
	private WebElement hospitalNumberInTheTableForVims;

	@FindBy(xpath = "//table/tbody/tr[1]/td[14]/descendant::i")
	private WebElement revisitBtnInTheTable;

	@FindBy(xpath = "//button[text()=' Quick Registration ']")
	private WebElement quickRegistartionBtn;

	@FindBy(css = "input[formcontrolname='totalBillingAmount']")
	private WebElement totalAmount;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow']//b)[1]")
	private WebElement registrationTypeDropDownbtn;

	@FindBy(xpath = "//input[@placeholder='Consultation Amount']")
	private WebElement consultationAmountFieldInOpdReg;

	@FindBy(xpath = "//div[@class='swal2-header']//h2[1]")
	private WebElement hospitalNumberTextInSuccessfullPopup;

	@FindBy(xpath = "//input[@formcontrolname='registrationAmount']")
	private WebElement registrationAmount;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorPoupMessage;

	// Upload photo
	@FindBy(xpath = "//div[@class='row']/following-sibling::img")
	private WebElement imageBtn;

	@FindBy(xpath = "(//button[text()='Take Picture'])[1]")
	private WebElement takePictureBtn;

	@FindBy(xpath = "(//button[text()=' Ok '])[1]")
	private WebElement image_OkBtn;

	@FindBy(xpath = "(//span[text()='NONE']/following-sibling::span)[2]")
	private WebElement mlcDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='Police Station']")
	private WebElement policeStationTextField;

	@FindBy(xpath = "//span[@title='Brought By']/following-sibling::span[1]")
	private WebElement broughtByDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='Contact Name']")
	private WebElement contactNameTextField;

	@FindBy(xpath = "//input[@placeholder='Contact Number']")
	private WebElement contactNumberTextField;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement dropDownSuggestion;

	@FindBy(xpath = "//div[@class='swal2-header']//h2[1]")
	private static WebElement okBtnText;

	@FindBy(xpath = "//button[text()=' Back ']")
	private WebElement backBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement tokenNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement tokenKey_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
	private WebElement mobileNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement registeredDate_Table;

	@FindBy(xpath = "//button[text()=' Add']")
	private WebElement addBtn;

	@FindBy(xpath = "//button[text()=' Pre Registration ']")
	private WebElement preRegistrationBtn;

	@FindBy(xpath = "//input[@placeholder='Token Number']")
	private WebElement tokenNumberField;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "(//button[text()=' Fetch '])[1]")
	private WebElement fetchBtn;

	@FindBy(xpath = "//button[text()='New registration']")
	private WebElement newRegistrationBtn;

	@FindBy(xpath = "//label[text()='Referred from Hospital & Location']/following-sibling::input")
	private WebElement ReferredFromHospitalAndLocation;

	@FindBy(xpath = "//label[text()='Referred by doctor']/following-sibling::input")
	private WebElement ReferredByDoctor;

	@FindBy(xpath = "//label[text()='Referred by speciality']/following-sibling::input")
	private WebElement ReferredBbySpeciality;

	// ------------------------------------- Bussiness
	// Logic------------------------------------------------------------------

	public void PatientTypeDropdown(WebDriver driver, String patientType) {
		scrollDownTheStillEndOfThePage(driver, patientTypeDrop);
		scroll_Up_FullPage_UsingJavaScriprExecuter(driver);
		dropdown(driver, patientTypeDrop, dropdownsText, patientType);
	}

	public void selectFinancialResponsibility(WebDriver driver, String FinancialResponsibility) {
		dropdown(driver, financialResponsibility, dropdownsText, FinancialResponsibility);
	}

	public void selectPatientType(WebDriver driver, String patientType) {
		scroll_Up_FullPage_UsingJavaScriprExecuter(driver);
		dropdown(driver, patientTypeDrop, dropdownsText, patientType);
	}

	public void selectGender(WebDriver driver) throws Throwable {
		scroll_Up_FullPage_UsingJavaScriprExecuter(driver);
		dropdown(driver, genderDropdownBtn, dropdownsText, gender);
	}

	public void selectPatientCategoryDropdown(WebDriver driver, String patientCategory) {
		scroll_Up_FullPage_UsingJavaScriprExecuter(driver);
		dropdown(driver, patientCategoryDrop, dropdownsText, patientCategory);
	}

	public void registrationTypeDropDown(WebDriver driver, String registrationType) {
		scrollDownThePageUntilElementIsVisible(driver, registartionTypeDropdown);
		// explicitWaitElementToBeClickable(driver, registartionTypeDropdown);
		dropdown(driver, registartionTypeDropdown, dropdownsText, registrationType);
	}

	public void opdRegistrationButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, opdRegisatrionBtn);
	}

	public void displayNameText(String displayname) {
		displaynameText.sendKeys(displayname);
	}

	public void dateOfBirthCalenderText(WebDriver driver, String year) {
		dateOfBirthcalender.sendKeys(year);
	}

	public void clickOnThesuccesffullyFeatchDeatilsOfOpPatient() {
		successfullyFetchDetailsOfOpPatient.click();
	}

	public void firstNameText(String name) {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		firstName.sendKeys(c + name);
	}

	public void firstName(String name) {
		firstName.sendKeys(name);
	}

	public void middleNameText(String name) {
		middleName.sendKeys(name);
	}

	public void LastNameText(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void AgeText(WebDriver driver) {
		AgeText.clear();
	}

	public void AgeText(String year) {
		AgeText.sendKeys(year);
	}

	public void enterTheSpouseNameInTheText(String spouseName) {
		spouseNameText.sendKeys(spouseName);
	}

	public void fatherName(String fname) {
		fatherNameText.sendKeys(fname);
	}

	public void mobileNumberNormal(String mobilenum) {
		mobileNumber.sendKeys(mobilenum);
	}

	public void motherName(String mothername) {
		motherNameText.sendKeys(mothername);
	}

	public void mobileNumber(WebDriver driver, String mobilenum) {
		Random ron = new Random();
		int ran = ron.nextInt(10000);
		mobileNumber.sendKeys(ran + mobilenum);
	}

	public void ssdAndLandLine(String ssdnum, String landNum) {
		stdISDText.sendKeys(ssdnum);
		landlineNumberText.sendKeys(landNum);
	}

	public void mailText(String mail) {
		mailTextfield.sendKeys(mail);
	}

	public void enterThePassportNumber_Nationality(String passportNumber) {
		passportNumberText_Nationality.sendKeys(passportNumber, Keys.TAB);
	}

	public void enterVisaNumber_Nationality(String visaNumber) {
		visaNumber_Nationality.sendKeys(visaNumber);
	}

	public void adressTextFiled(String address) {
		adressTextField.sendKeys(address);
	}

	public void pincodeTextField(WebDriver driver, String pincode) {
		pincodeTextField.sendKeys(pincode);
	}

	public void postOfficeDropdown(WebDriver driver, String postOffice) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 250);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(postOfficeDropdown)));
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

	public void enterThePoliceStationText(String policeStationName) {
		policeStationText.sendKeys(policeStationName);
	}

	public void clickOnTheNextOfKinButton() {
		nextOfKinPlusButton.click();
	}

	public void clickOnTheUploadButton(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, uploadButton);
		uploadButton.click();
	}

	public void clickOnTheChooseFileButton(String filePath) {
		chooseFile.sendKeys(filePath);
	}

	public void clickOnTheSubmitButtonOf_Upload(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 250);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(submit_UploadBtn)));
		submit_UploadBtn.click();
	}

	public void addTheNameText(String secondName) throws Throwable {
		firstName.sendKeys(secondName);
	}

	public void clearTheFatherNameGiveTheNewName(String fatherName) {
		fatherNameText.clear();
		fatherNameText.sendKeys(fatherName);
	}

	public void SubmitBtnOnly(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// explicityWaitForElemenToBeClickable(driver, submitBtn);
		submitBtn.click();
	}

	public void emailEnter(String mail) {
		emailText.sendKeys(mail);
	}

	public void enterParentHospitalNumber(String hospitalNumber) {
		parentHospitalNumber.sendKeys(hospitalNumber);
	}

	// search Appointment button
	public void appointmentNumberTextField(String appointmentNumber) {
		appointmentNumberText.sendKeys(appointmentNumber);
	}

	public void appointmentDetailsButton() {
		appointmentDetails.click();
	}

	public void hospitalNumberText(String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber, Keys.TAB);
	}

	// OP New
	public void OpdRegistartionForVims(WebDriver driver, String name, String year, String fname, String mobilenum,
			String mail, String address, String pincode, String postOffice, String depName, String doctorname)
			throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		firstName.sendKeys(firstName1);
		AgeText.sendKeys(year);
		fatherNameText.sendKeys(fname);

		Random ron = new Random();
		int ran = ron.nextInt(10000);
		mobileNumber.sendKeys(ran + mobilenum);

		mailTextfield.sendKeys(mail);

		adressTextField.sendKeys(address);

		pincodeTextField.sendKeys(pincode);

		Thread.sleep(2000);
		explictWaitForElementToBeVisible(driver, postOfficeDropdown);
		// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
		postOfficeDropdown.click();
		scrollTillVisibleElement(driver, postOfficeDropdownText);
		moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);

		Random rand = new Random();
		int intrandom = rand.nextInt(1000000000);
		adharIdProofText.sendKeys(intrandom + "1234");

		scroolToSpecifiedHeight(driver, 750);

		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		Thread.sleep(1000);
		waitForElementWithCustomTimeOut(driver, doctorDropdownBtn, 30);
		explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
		// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
		doctorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorname);

	}

	public String submitAnd_ViewBtn(WebDriver driver) throws Throwable {
		scrollToBottom(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
		Thread.sleep(3000);

		String mainWindowHandle = driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("window.print();");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		((JavascriptExecutor) driver).executeScript("window.close();");
		driver.switchTo().window(mainWindowHandle);

		String hospitalNumber1 = hospitalNumberTextInSuccessfullPopup.getText().trim();
		Pattern pattern = Pattern.compile("\\b\\d+\\b");
		Matcher matcher = pattern.matcher(hospitalNumber1);
		String hospitalNumber = "";
		if (matcher.find()) {
			hospitalNumber = matcher.group();
		}

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("(//button[@type='button']/following-sibling::button)[3]"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			clickOnTheElementUsedToJavascriptExecuter(driver, loginAnywayBtn1);
		}
		return hospitalNumber;
	}

	public void submitAnd_ViewBtn_2(WebDriver driver) throws Throwable {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);

		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);

		scrollToBottom(driver);

		scrollDownThePageUntilElementIsVisible(driver, submitBtn);

		// explicityWaitForElemenToBeClickable(driver, submitBtn);

		Thread.sleep(3000);
		submitBtn.click();
		Thread.sleep(4000);

		String mainWindowHandle1 = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator2.hasNext()) {
			String ChildWindow2 = iterator2.next();
			if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow2)) {
				driver.switchTo().window(ChildWindow2);
			}
		}
		driver.switchTo().window(mainWindowHandle1);
		explictWaitForElementToBeVisible(driver, newRegistrationBtn);
		newRegistrationBtn.click();
	}

	// ---------------------------------------OPD logics
	// (surya)----------------
	// --------------------------------------------------------

	public String submitAnd_ViewBtn2(WebDriver driver) throws Throwable {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		submitBtn.click();
		Thread.sleep(2000);

		String mainWindowHandle2 = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator2.hasNext()) {
			String ChildWindow2 = iterator2.next();
			if (!mainWindowHandle2.equalsIgnoreCase(ChildWindow2)) {
				driver.switchTo().window(ChildWindow2);
			}
		}
		driver.switchTo().window(mainWindowHandle2);

		String hospitalNumber1 = hospitalNumberTextInSuccessfullPopup.getText().trim();
		Pattern pattern = Pattern.compile("\\b\\d+\\b");
		Matcher matcher = pattern.matcher(hospitalNumber1);
		String hospitalNumber = "";
		if (matcher.find()) {
			hospitalNumber = matcher.group();
		}
		try {
			WebElement te = driver.findElement(By.xpath("//button[text()='New registration']"));
			clickElementWithRetries(driver, 20, te);
		} catch (Exception e) {
		}
		return hospitalNumber;

	}

	public void OpdRegistartionForVims2(WebDriver driver, String name, String year, String fname, String mobilenum,
			String mail, String address, String pincode, String postOffice, String depName, String doctorname)
			throws Throwable {
		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, firstName);
		scrollTillVisibleElement(driver, firstName);
		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		firstName.sendKeys(firstName1);
		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");
		selectGender(driver);
		scrollDownThePageUntilElementIsVisible(driver, fatherNameText);
		fatherNameText.sendKeys(fname);
		// emailText.sendKeys(mail);
		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		mobileNumber.sendKeys(ph);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}
		explictWaitForElementToBeVisible(driver, mailTextfield);
		mailTextfield.sendKeys(mail);
		adressTextField.sendKeys(address);
		pincodeTextField.sendKeys(pincode);

		Thread.sleep(1000);
		scrollUntilElementVisible(driver, postOfficeDropdown);
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, postOfficeDropdown);
		Thread.sleep(1000);
		scrollUntilElementVisible(driver, postOfficeDropdown);
		postOfficeDropdown.click();
		moveToElementAndEnterTheData(driver, postOfficeDropdownText, "whitefield s.o");
		Thread.sleep(1000);

		scrollDownThePageUntilElementIsVisible(driver, idProofDropdownBtn);
		Thread.sleep(1000);
		scrollUntilElementVisible(driver, postOfficeDropdown);
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, postOfficeDropdown);
		explictWaitForElementToBeVisible(driver, idProofDropdownBtn);
		idProofDropdownBtn.click();
		scrollDownThePageUntilElementIsVisible(driver, dropdownText);
		moveToElementAndEnterTheData(driver, dropdownText, "AADHAR CARD");
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);
		scrollDownTheStillEndOfThePage(driver);
		scrollTillVisibleElement(driver, departmentDropdown);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		departmentDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, depName);
		Thread.sleep(1000);
		doctorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorname);
	}

	public void OpdRegistartionForVimsFemalePatient(WebDriver driver, String name, String year, String fname,
			String mobilenum, String mail, String address, String pincode, String postOffice, String depName,
			String doctorname) throws Throwable {

		patientTitleDropdownBtn.click();
		dropdownsText.sendKeys("miss", Keys.ENTER);

		Random random = new Random();
		String firstName1 = FEMALE_NAMES[random.nextInt(FEMALE_NAMES.length)];
		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(99);
		AgeText.sendKeys(randomNumber + "");

		fatherNameText.sendKeys(fname);

		Random ron = new Random();
		int ran = ron.nextInt(100000);
		mobileNumber.sendKeys(ran + mobilenum);

		mailTextfield.sendKeys(mail);

		adressTextField.sendKeys(address);

		pincodeTextField.sendKeys(pincode);

		scroolToSpecifiedHeight(driver, 170);
		Thread.sleep(2000);
		explictWaitForElementToBeVisible(driver, postOfficeDropdown);
		postOfficeDropdown.click();
		scrollTillVisibleElement(driver, postOfficeDropdownText);
		moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);

		Random rand = new Random();
		int intrandom = rand.nextInt(1000000000);
		adharIdProofText.sendKeys(intrandom + "1234");

		scroolToSpecifiedHeight(driver, 700);

		explictWaitForElementToBeVisible(driver, departmentDropdown);
		departmentDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		Thread.sleep(1000);
		explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
		doctorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorname);

	}

	public void emergencymedicine(WebDriver driver) {
		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100);
		AgeText.sendKeys(randomNumber + "");

		scrollDownThePageUntilElementIsVisible(driver, departmentDropdown);

		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Random random1 = new Random();
		String dep = DEPARTMENT_NAMES[random1.nextInt(DEPARTMENT_NAMES.length)];
		moveToElementAndEnterTheData(driver, dropdownText, dep);

	}

	public void emergencymedicine1(WebDriver driver) {
		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100);
		AgeText.sendKeys(randomNumber + "");

		scrollDownThePageUntilElementIsVisible(driver, departmentDropdown);

		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		dropdownText.sendKeys("neurology", Keys.DOWN, Keys.ENTER);

	}

	public void registrationTypeForEmergencymedicine(WebDriver driver) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		// explicityWaitForElemenToBeClickable(driver, registrationTypeDropDownbtn);
		registrationTypeDropDownbtn.click();
		dropdownText.sendKeys("Emergency", Keys.DOWN, Keys.ENTER);

	}

	public String submitAnd_ViewBtnForEmergencyMedicine2(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		submitBtn.click();

		String hospitalNumber1 = hospitalNumberTextInSuccessfullPopup.getText().trim();
		Pattern pattern = Pattern.compile("\\b\\d+\\b");
		Matcher matcher = pattern.matcher(hospitalNumber1);
		String hospitalNumber = "";
		if (matcher.find()) {
			hospitalNumber = matcher.group();
		}
		newRegistrationPopupBtnForVims.click();
		return hospitalNumber;

	}

	public String toVerifyTheConsultationAmount(WebDriver driver, String name, String year, String fname,
			String mobilenum, String mail, String address, String pincode, String postOffice, String depName,
			String doctorname) throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100);
		AgeText.sendKeys(randomNumber + "");
		fatherNameText.sendKeys(fname);

		Random ron = new Random();
		int ran = ron.nextInt(100000);
		mobileNumber.sendKeys(ran + mobilenum);

		mailTextfield.sendKeys(mail);

		adressTextField.sendKeys(address);

		pincodeTextField.sendKeys(pincode);

		scroolToSpecifiedHeight(driver, 170);
		Thread.sleep(2000);
		explictWaitForElementToBeVisible(driver, postOfficeDropdown);
		// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
		postOfficeDropdown.click();
		scrollTillVisibleElement(driver, postOfficeDropdownText);
		moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);

		Random rand = new Random();
		int intrandom = rand.nextInt(1000000000);
		adharIdProofText.sendKeys(intrandom + "1234");

		scroolToSpecifiedHeight(driver, 700);

		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		Thread.sleep(1000);
		explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
		// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
		doctorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorname);

		scrollDownTheStillEndOfThePage(driver);

		String t = consultationAmountFieldInOpdReg.getAttribute("value");

		System.out.println("Consultation Amount in Opd Registration : " + t);

		return t;

	}

	public void OpdRegistartionForName(WebDriver driver, String fn, String name, String year, String fname,
			String mobilenum, String mail, String address, String pincode, String postOffice, String depName,
			String doctorname) throws Throwable {

		firstName.sendKeys(fn);
		AgeText.sendKeys(year);
		fatherNameText.sendKeys(fname);

		Random ron = new Random();
		int ran = ron.nextInt(10000);
		mobileNumber.sendKeys(ran + mobilenum);

		mailTextfield.sendKeys(mail);

		adressTextField.sendKeys(address);

		pincodeTextField.sendKeys(pincode);

		Thread.sleep(2000);
		explictWaitForElementToBeVisible(driver, postOfficeDropdown);
		// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
		postOfficeDropdown.click();
		scrollTillVisibleElement(driver, postOfficeDropdownText);
		moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);

		Random rand = new Random();
		int intrandom = rand.nextInt(1000000000);
		adharIdProofText.sendKeys(intrandom + "1234");

		scroolToSpecifiedHeight(driver, 750);

		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		Thread.sleep(1000);
		waitForElementWithCustomTimeOut(driver, doctorDropdownBtn, 30);
		explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
		// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
		doctorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorname);

	}

	public String captureRegistrationAmount(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, registrationAmount);
		Thread.sleep(1000);
		String ra = registrationAmount.getAttribute("value");
		String ra1 = ra.replace(".00", "");
		return ra1;
	}

	public String mandatoryFields_error_Message(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String msg = errorPoupMessage.getText();
		return msg;

	}

	public void clickOn_UnavailableButton_MobileNum(WebDriver driver) {
		// explicityWaitForElemenToBeClickable(driver, unavailableButon_MobileNum);
		unavailableButon_MobileNum.click();
	}

	public void clickOn_UnavailableButton_Email(WebDriver driver) {
		// explicityWaitForElemenToBeClickable(driver, unavailableBtn_Email);
		unavailableBtn_Email.click();
	}

	public void aadharCards_Random(WebDriver driver) {
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);
	}

	public void selectDepartment(WebDriver driver, String department) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicitWaitElementToBeClickable(driver, departmentDropdown);
		scrollDownThePageUntilElementIsVisible(driver, departmentDropdown);
		dropdown(driver, departmentDropdown, dropdownsText, department);
	}

	public void selectDoctor(WebDriver driver, String doctor) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, departmentDropdown);
		dropdown(driver, doctorDropdownBtn, dropdownsText, doctor);
	}

	public void enterRevisitHospitalNumber_Text(WebDriver driver, String hospitalNumber) {
		hospitalNumberRevisit.sendKeys(hospitalNumber, Keys.TAB);
	}

	public void clickOn_QuickRegistrationBtn(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, quickRegistartionBtn);
		//// explicityWaitForElemenToBeClickable(driver, quickRegistartionBtn);
		quickRegistartionBtn.click();
	}

	public void nextOfKinDetails(WebDriver driver, String nextOfKIn, String name, String number, String email) {

		for (int i = 0; i < 10; i++) {
			scrollDownThePageUntilElementIsVisible(driver, nextOfKinDropdown);
			dropdown(driver, nextOfKinDropdown, dropdownsText, nextOfKIn);
			nextOfKinNameText.sendKeys(name);
			nextOfKinMobileText.sendKeys(number);
			nextOfKinEmailText.sendKeys(email);
			nextOfKinPlusButton.click();
		}

	}

	public void OpdRegistartionForVims_searchFilter(WebDriver driver, String name, String year, String fname,
			String mobilenum, String mail, String address, String pincode, String postOffice, String aadhaar,
			String depName, String doctorname) throws Throwable {

		firstName.sendKeys(name);
		AgeText.sendKeys(year);
		fatherNameText.sendKeys(fname);
		mobileNumber.sendKeys(mobilenum);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}
		mailTextfield.sendKeys(mail);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn879 = null;
		try {
			loginAnywayBtn879 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn879 != null) {
			loginAnywayBtn879.click();
		}
		adressTextField.sendKeys(address);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn11 = null;
		try {
			loginAnywayBtn11 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn11 != null) {
			loginAnywayBtn11.click();
		}
		pincodeTextField.sendKeys(pincode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn123 = null;
		try {
			loginAnywayBtn123 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (Exception e) {
		}
		if (loginAnywayBtn123 != null) {
			loginAnywayBtn123.click();
		}
		scroolToSpecifiedHeight(driver, 170);
		int retries = 10;
		int attempts = 0;
		while (attempts < retries) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement loginAnywayBtn100 = null;
				try {
					loginAnywayBtn100 = driver.findElement(By.xpath("//button[text()='New']"));
				} catch (Exception e) {
				}
				if (loginAnywayBtn100 != null) {
					loginAnywayBtn100.click();
				}
				explictWaitForElementToBeVisible(driver, postOfficeDropdown);
				// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
				postOfficeDropdown.click();
				scrollTillVisibleElement(driver, postOfficeDropdownText);
				moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
				break;
			} catch (Exception e) {
				attempts++;
			}
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn2 = null;
		try {
			loginAnywayBtn2 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn2 != null) {
			loginAnywayBtn2.click();
		}
		adharIdProofText.sendKeys(aadhaar);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn3 = null;
		try {
			loginAnywayBtn3 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn3 != null) {
			loginAnywayBtn3.click();
		}
		scroolToSpecifiedHeight(driver, 700);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, depName);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}
		int retries1 = 20;
		int attempts1 = 0;
		while (attempts1 < retries1) {
			try {
				explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
				// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
				doctorDropdownBtn.click();
				moveToElementAndEnterTheData(driver, dropdownText, doctorname);
				break;
			} catch (Exception e) {
				attempts1++;
			}
		}
	}

	public void takeThe_Picture_UsingWebCam(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, imageBtn);
		// explicityWaitForElemenToBeClickable(driver, imageBtn);
		imageBtn.click();
		// explicityWaitForElemenToBeClickable(driver, takePictureBtn);
		takePictureBtn.click();
		// explicityWaitForElemenToBeClickable(driver, image_OkBtn);
		image_OkBtn.click();
	}

	public void OpdRegistartionForVims2_Mlc(WebDriver driver, String name, String year, String fname, String mobilenum,
			String mail, String address, String pincode, String postOffice, String mlc, String policeStation,
			String broughtBy, String contactName, String contactNumber, String depName, String doctorname)
			throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		firstName.sendKeys(firstName1);
		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");
		fatherNameText.sendKeys(fname);
		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		mobileNumber.sendKeys(ph);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}
		mailTextfield.sendKeys(mail);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn879 = null;
		try {
			loginAnywayBtn879 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn879 != null) {
			loginAnywayBtn879.click();
		}
		adressTextField.sendKeys(address);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn11 = null;
		try {
			loginAnywayBtn11 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn11 != null) {
			loginAnywayBtn11.click();
		}
		pincodeTextField.sendKeys(pincode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn123 = null;
		try {
			loginAnywayBtn123 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (Exception e) {
		}
		if (loginAnywayBtn123 != null) {
			loginAnywayBtn123.click();
		}
		scroolToSpecifiedHeight(driver, 170);
		int retries = 10;
		int attempts = 0;
		while (attempts < retries) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement loginAnywayBtn100 = null;
				try {
					loginAnywayBtn100 = driver.findElement(By.xpath("//button[text()='New']"));
				} catch (Exception e) {
				}
				if (loginAnywayBtn100 != null) {
					loginAnywayBtn100.click();
				}
				explictWaitForElementToBeVisible(driver, postOfficeDropdown);
				// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
				postOfficeDropdown.click();
				scrollTillVisibleElement(driver, postOfficeDropdownText);
				moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
				break;
			} catch (Exception e) {
				attempts++;
			}
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn2 = null;
		try {
			loginAnywayBtn2 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn2 != null) {
			loginAnywayBtn2.click();
		}
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);

		scrollDownThePageUntilElementIsVisible(driver, mlcDropDownBtn);
		dropdown(driver, mlcDropDownBtn, dropdownsText, mlc);

		policeStationTextField.sendKeys(policeStation);
		dropdown(driver, broughtByDropDownBtn, dropdownsText, broughtBy);
		contactNameTextField.clear();
		contactNameTextField.sendKeys(contactName);
		contactNumberTextField.sendKeys(contactNumber);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn3 = null;
		try {
			loginAnywayBtn3 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn3 != null) {
			loginAnywayBtn3.click();
		}
		scroolToSpecifiedHeight(driver, 700);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}

		int retries1 = 20;
		int attempts1 = 0;
		while (attempts1 < retries1) {
			try {
				explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
				// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
				doctorDropdownBtn.click();
				moveToElementAndEnterTheData(driver, dropdownText, doctorname);
				break;
			} catch (Exception e) {
				attempts1++;
			}
		}

	}

	public void enterFirstName(WebDriver driver, String name) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, firstName);
		firstName.clear();
		firstName.sendKeys(name);
	}

	public void enterAge(WebDriver driver, String age) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, AgeText);
		AgeText.clear();
		AgeText.sendKeys(age);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnSubmit(WebDriver driver) {
		scrollToBottom(driver);
		submitBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		// explicitWaitElementToBeClickabl(driver, okBtn);
		okBtn.click();
	}

	public void selectRegistrationType(WebDriver driver, String registrationType) throws Throwable {
		Thread.sleep(3000);
		scroll_Up_FullPage_UsingJavaScriprExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, registartionTypeDropdown);
		dropdown(driver, registartionTypeDropdown, dropdownsText, registrationType);
	}

	public void createOpdRegistrationForIpPatients(WebDriver driver, String registrationType, String department,
			String doctor) throws Throwable {
		opdRegistrationButton(driver);
		selectRegistrationType(driver, registrationType);
		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		firstName.sendKeys(firstName1);
		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");
		selectDepartment(driver, department);
	}

	public void OpdRegistartionForVims3(WebDriver driver, String fname, String address, String pincode,
			String postOffice, String depName, String doctorname) throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");

		selectGender(driver);
		fatherNameText.sendKeys(fname);

		// emailText.sendKeys(mail);

		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		mobileNumber.sendKeys(ph);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}

		String mail = generateRandomEmail();
		mailTextfield.sendKeys(mail);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn879 = null;
		try {
			loginAnywayBtn879 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn879 != null) {
			loginAnywayBtn879.click();
		}
		adressTextField.sendKeys(address);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn11 = null;
		try {
			loginAnywayBtn11 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn11 != null) {
			loginAnywayBtn11.click();
		}
		pincodeTextField.sendKeys(pincode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn123 = null;
		try {
			loginAnywayBtn123 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (Exception e) {
		}
		if (loginAnywayBtn123 != null) {
			loginAnywayBtn123.click();
		}
		scroolToSpecifiedHeight(driver, 170);
		int retries = 10;
		int attempts = 0;
		while (attempts < retries) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement loginAnywayBtn100 = null;
				try {
					loginAnywayBtn100 = driver.findElement(By.xpath("//button[text()='New']"));
				} catch (Exception e) {
				}
				if (loginAnywayBtn100 != null) {
					loginAnywayBtn100.click();
				}
				Thread.sleep(2000);
				explictWaitForElementToBeVisible(driver, postOfficeDropdown);
				// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
				postOfficeDropdown.click();
				scrollTillVisibleElement(driver, postOfficeDropdownText);
				moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
				break;
			} catch (Exception e) {
				attempts++;
			}
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn2 = null;
		try {
			loginAnywayBtn2 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn2 != null) {
			loginAnywayBtn2.click();
		}

		idProofDropdownBtn.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, "AADHAR CARD");
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn3 = null;
		try {
			loginAnywayBtn3 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn3 != null) {
			loginAnywayBtn3.click();
		}

		scroolToSpecifiedHeight(driver, 700);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}

		int retries1 = 20;
		int attempts1 = 0;
		while (attempts1 < retries1) {
			try {
				explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
				// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
				doctorDropdownBtn.click();
				moveToElementAndEnterTheData(driver, dropdownText, doctorname);
				break;
			} catch (Exception e) {
				attempts1++;
			}
		}

	}

	public void enterMiddleName(WebDriver driver, String name) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, middleName);
		middleName.clear();
		middleName.sendKeys(name);
	}

	public void c(WebDriver driver, String name) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, lastName);
		lastName.clear();
		lastName.sendKeys(name);
	}

	public void enterFatherName(WebDriver driver, String name) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, fatherNameText);
		fatherNameText.clear();
		fatherNameText.sendKeys(name);
	}

	public void enterMotherName(WebDriver driver, String name) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, motherNameText);
		motherNameText.clear();
		motherNameText.sendKeys(name);
	}

	public void enterMobileNumber(WebDriver driver, String number) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, mobileNumber);
		mobileNumber.clear();
		mobileNumber.sendKeys(number);
	}

	public void enterStd_Isd(WebDriver driver, String std) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, stdISDText);
		stdISDText.clear();
		stdISDText.sendKeys(std);
	}

	public void selectBloodGroup(WebDriver driver, String text) {
		scrollDownThePageUntilElementIsVisible(driver, bloodDropdownText);
		dropdown(driver, bloodDropdownText, dropdownsText, text);
	}

	public void enterEmail(WebDriver driver, String email) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, emailText);
		emailText.clear();
		emailText.sendKeys(email);
	}

	public void enterAddress(WebDriver driver, String address) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, adressTextField);
		adressTextField.clear();
		adressTextField.sendKeys(address);
	}

	public void enterPincode(WebDriver driver, String pincode) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pincodeTextField);
		pincodeTextField.clear();
		pincodeTextField.sendKeys(pincode);
	}

	public void selectPostOffice(WebDriver driver) throws Throwable {
		Thread.sleep(4000);
		// explicitWaitElementToBeClickable(driver, postOfficeDropdown);
		scrollDownThePageUntilElementIsVisible(driver, postOfficeDropdown);
		postOfficeDropdown.click();
		explictWaitForElementToBeVisible(driver, dropDownSuggestion);
		dropDownSuggestion.click();
	}

	public void enterAadharCardNumber(WebDriver driver, String number) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, adharIdProofText);
		adharIdProofText.clear();
		adharIdProofText.sendKeys(number);
	}

	public void selectNextOfKin(WebDriver driver, String nextOfKin) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, nextOfKinDropdown);
		dropdown(driver, nextOfKinDropdown, dropdownsText, nextOfKin);
	}

	public void enterName_NextOfKin(WebDriver driver, String name) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextOfKinNameText);
		nextOfKinNameText.clear();
		nextOfKinNameText.sendKeys(name);
	}

	public void enterMobileNumber_NextOfKin(WebDriver driver, String mobileNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextOfKinMobileText);
		nextOfKinMobileText.clear();
		nextOfKinMobileText.sendKeys(mobileNumber);
	}

	public void enterEmail_NextOfKin(WebDriver driver, String email) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextOfKinEmailText);
		nextOfKinEmailText.clear();
		nextOfKinEmailText.sendKeys(email);
	}

	public void clickOnAddAction_NextOfKin(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextOfKinPlusButton);
		nextOfKinPlusButton.click();
	}

	public void clickOnSubmit_windowHandles(WebDriver driver) throws Throwable {
		scrollToBottom(driver);
		submitBtn.click();
		Thread.sleep(2000);
		getWindowHandles(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String captureOkBtnText(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		explictWaitForElementToBeVisible(driver, okBtnText);
		return okBtnText.getText();
	}

	public void clickOnOkBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		// explicitWaitElementToBeClickable(driver, okBtn);
		okBtn.click();
	}

	public void addNextOfKin(WebDriver driver, String nextOfKin, String name, String mobilenum, String email)
			throws Throwable {
		selectNextOfKin(driver, nextOfKin);
		enterName_NextOfKin(driver, name);
		enterMobileNumber_NextOfKin(driver, mobilenum);
		enterEmail_NextOfKin(driver, email);
		clickOnAddAction_NextOfKin(driver);
	}

	public static String captureTokenNumberFromPopUp(WebDriver driver) {
		String tokenNumber1 = okBtnText.getText().trim();
		Pattern pattern = Pattern.compile("Token Number is (\\d+)");
		Matcher matcher = pattern.matcher(tokenNumber1);
		String tokenNumber = "";

		if (matcher.find()) {
			tokenNumber = matcher.group(1);
		}

		return tokenNumber.replaceAll("[^\\d]", "");
	}

	public static String captureTokenKeyFromPopUp(WebDriver driver) {
		String tokenKey1 = okBtnText.getText().trim();
		Pattern pattern = Pattern.compile("Token Key is (\\d+)");
		Matcher matcher = pattern.matcher(tokenKey1);
		String tokenKey = "";

		if (matcher.find()) {
			tokenKey = matcher.group(1);
		}

		return tokenKey.replaceAll("[^\\d]", "");
	}

	public void clickOnBackBtn(WebDriver driver) throws Throwable {
		scrollToTop(driver);
		backBtn.click();
	}

	public String captureTokenNumber_Table(WebDriver driver) {
		return tokenNumber_Table.getText();
	}

	public String captureTokenKey_Table(WebDriver driver) {
		return tokenKey_Table.getText();
	}

	public String capturePatientName_Table(WebDriver driver) {
		return patientName_Table.getText();
	}

	public String captureMobileNumber_Table(WebDriver driver) {
		return mobileNumber_Table.getText();
	}

	public String captureRegisteredDate_Table(WebDriver driver) {
		return registeredDate_Table.getText();
	}

	public void clickOnAddBtn(WebDriver driver) throws Throwable {
		scrollToTop(driver);
		// explicitWaitElementToBeClickable(driver, addBtn);
		addBtn.click();
	}

	public void clickOnPreRegistrationBtn(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, preRegistrationBtn);
		preRegistrationBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnFetchBtn(WebDriver driver) {
		// explicitWaitElementToBeClickable(driver, fetchBtn);
		scrollDownThePageUntilElementIsVisible(driver, fetchBtn);
		fetchBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void enterTokenNumberSearchField(WebDriver driver, String tokenNumber) throws Throwable {

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		explictWaitForElementToBeVisible(driver, tokenNumberField);
		scrollDownThePageUntilElementIsVisible(driver, tokenNumberField);
		tokenNumberField.clear();
		tokenNumberField.sendKeys(tokenNumber);
	}

	public void clickOnSearch(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, searchBtn);
		searchBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnNewRegistrationBtn(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		// explicitWaitElementToBeClickable(driver, newRegistrationBtn);
		clickElementWithRetries(driver, 20, newRegistrationBtn);
	}

	public void selectGenderFemale(WebDriver driver) {
		dropdown(driver, genderDropdownBtn, dropdownsText, "Female");
	}

	public void selectPatientTitle(WebDriver driver, String patientType) {
		dropdown(driver, patientTitle_DropDOwn, dropdownsText, patientType);
	}

	public void OpdRegistartionForVims_5(WebDriver driver, String name, String year, String fname, String mobilenum,
			String mail, String address, String pincode, String postOffice, String depName, String doctorname)
			throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		selectPatientTitle(driver, "Miss");
		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");

		selectGenderFemale(driver);

		fatherNameText.sendKeys(fname);

		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		mobileNumber.sendKeys(ph);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}
		mailTextfield.sendKeys(mail);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn879 = null;
		try {
			loginAnywayBtn879 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn879 != null) {
			loginAnywayBtn879.click();
		}
		adressTextField.sendKeys(address);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn11 = null;
		try {
			loginAnywayBtn11 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn11 != null) {
			loginAnywayBtn11.click();
		}
		pincodeTextField.sendKeys(pincode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn123 = null;
		try {
			loginAnywayBtn123 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (Exception e) {
		}
		if (loginAnywayBtn123 != null) {
			loginAnywayBtn123.click();
		}
		scroolToSpecifiedHeight(driver, 170);
		int retries = 10;
		int attempts = 0;
		while (attempts < retries) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement loginAnywayBtn100 = null;
				try {
					loginAnywayBtn100 = driver.findElement(By.xpath("//button[text()='New']"));
				} catch (Exception e) {
				}
				if (loginAnywayBtn100 != null) {
					loginAnywayBtn100.click();
				}
				Thread.sleep(2000);
				explictWaitForElementToBeVisible(driver, postOfficeDropdown);
				// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
				postOfficeDropdown.click();
				scrollTillVisibleElement(driver, postOfficeDropdownText);
				moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
				break;
			} catch (Exception e) {
				attempts++;
			}
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn2 = null;
		try {
			loginAnywayBtn2 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn2 != null) {
			loginAnywayBtn2.click();
		}
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn3 = null;
		try {
			loginAnywayBtn3 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn3 != null) {
			loginAnywayBtn3.click();
		}
		scroolToSpecifiedHeight(driver, 700);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}

		int retries1 = 20;
		int attempts1 = 0;
		while (attempts1 < retries1) {
			try {
				explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
				// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
				doctorDropdownBtn.click();
				moveToElementAndEnterTheData(driver, dropdownText, doctorname);
				break;
			} catch (Exception e) {
				attempts1++;
			}
		}

	}

	public void OpdRegistartionForReferredFromHospitalLocation(WebDriver driver, String name, String year, String fname,
			String mobilenum, String mail, String address, String pincode, String postOffice, String depName,
			String doctorname) throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");

		selectGender(driver);

		fatherNameText.sendKeys(fname);

		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		mobileNumber.sendKeys(ph);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}
		mailTextfield.sendKeys(mail);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn879 = null;
		try {
			loginAnywayBtn879 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn879 != null) {
			loginAnywayBtn879.click();
		}
		adressTextField.sendKeys(address);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn11 = null;
		try {
			loginAnywayBtn11 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn11 != null) {
			loginAnywayBtn11.click();
		}
		pincodeTextField.sendKeys(pincode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn123 = null;
		try {
			loginAnywayBtn123 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (Exception e) {
		}
		if (loginAnywayBtn123 != null) {
			loginAnywayBtn123.click();
		}
		scroolToSpecifiedHeight(driver, 170);
		int retries = 10;
		int attempts = 0;
		while (attempts < retries) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement loginAnywayBtn100 = null;
				try {
					loginAnywayBtn100 = driver.findElement(By.xpath("//button[text()='New']"));
				} catch (Exception e) {
				}
				if (loginAnywayBtn100 != null) {
					loginAnywayBtn100.click();
				}
				Thread.sleep(2000);
				explictWaitForElementToBeVisible(driver, postOfficeDropdown);
				// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
				postOfficeDropdown.click();
				scrollTillVisibleElement(driver, postOfficeDropdownText);
				moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
				break;
			} catch (Exception e) {
				attempts++;
			}
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn2 = null;
		try {
			loginAnywayBtn2 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn2 != null) {
			loginAnywayBtn2.click();
		}
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn3 = null;
		try {
			loginAnywayBtn3 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn3 != null) {
			loginAnywayBtn3.click();
		}
		scroolToSpecifiedHeight(driver, 700);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}

		int retries1 = 20;
		int attempts1 = 0;
		while (attempts1 < retries1) {
			try {
				explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
				// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
				doctorDropdownBtn.click();
				moveToElementAndEnterTheData(driver, dropdownText, doctorname);
				break;
			} catch (Exception e) {
				attempts1++;
			}
		}

		// Random random11 = new Random();
		String firstName33 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String tttt = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String yyyy = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		ReferredFromHospitalAndLocation.sendKeys(firstName33);
		ReferredByDoctor.sendKeys(tttt);
		ReferredBbySpeciality.sendKeys(yyyy);

	}

	public void OpdRegistartionForReferredFromHospitalLocation_Emergency(WebDriver driver, String name, String year,
			String fname, String mobilenum, String mail, String address, String pincode, String postOffice,
			String depName, String doctorname) throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");

		selectGender(driver);

		fatherNameText.sendKeys(fname);

		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		mobileNumber.sendKeys(ph);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}
		mailTextfield.sendKeys(mail);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn879 = null;
		try {
			loginAnywayBtn879 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn879 != null) {
			loginAnywayBtn879.click();
		}
		adressTextField.sendKeys(address);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn11 = null;
		try {
			loginAnywayBtn11 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn11 != null) {
			loginAnywayBtn11.click();
		}
		pincodeTextField.sendKeys(pincode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn123 = null;
		try {
			loginAnywayBtn123 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (Exception e) {
		}
		if (loginAnywayBtn123 != null) {
			loginAnywayBtn123.click();
		}
		scroolToSpecifiedHeight(driver, 170);
		int retries = 10;
		int attempts = 0;
		while (attempts < retries) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement loginAnywayBtn100 = null;
				try {
					loginAnywayBtn100 = driver.findElement(By.xpath("//button[text()='New']"));
				} catch (Exception e) {
				}
				if (loginAnywayBtn100 != null) {
					loginAnywayBtn100.click();
				}
				Thread.sleep(2000);
				explictWaitForElementToBeVisible(driver, postOfficeDropdown);
				// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
				postOfficeDropdown.click();
				scrollTillVisibleElement(driver, postOfficeDropdownText);
				moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
				break;
			} catch (Exception e) {
				attempts++;
			}
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn2 = null;
		try {
			loginAnywayBtn2 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn2 != null) {
			loginAnywayBtn2.click();
		}
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn3 = null;
		try {
			loginAnywayBtn3 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn3 != null) {
			loginAnywayBtn3.click();
		}
		scroolToSpecifiedHeight(driver, 700);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}

		// Random random11 = new Random();
		String firstName33 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String tttt = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String yyyy = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		ReferredFromHospitalAndLocation.sendKeys(firstName33);
		ReferredByDoctor.sendKeys(tttt);
		ReferredBbySpeciality.sendKeys(yyyy);

	}

	public void OpdRegistartionForReferredFromHospitalLocation_Forensic(WebDriver driver, String name, String year,
			String fname, String mobilenum, String mail, String address, String pincode, String postOffice,
			String depName, String doctorname) throws Throwable {

		Random random = new Random();
		String firstName1 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		firstName.sendKeys(firstName1);

		int randomNumber = random.nextInt(100) + 1;
		AgeText.sendKeys(randomNumber + "");

		selectGender(driver);

		fatherNameText.sendKeys(fname);

		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		mobileNumber.sendKeys(ph);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn1 = null;
		try {
			loginAnywayBtn1 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn1 != null) {
			loginAnywayBtn1.click();
		}
		mailTextfield.sendKeys(mail);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn879 = null;
		try {
			loginAnywayBtn879 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn879 != null) {
			loginAnywayBtn879.click();
		}
		adressTextField.sendKeys(address);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn11 = null;
		try {
			loginAnywayBtn11 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn11 != null) {
			loginAnywayBtn11.click();
		}
		pincodeTextField.sendKeys(pincode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn123 = null;
		try {
			loginAnywayBtn123 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (Exception e) {
		}
		if (loginAnywayBtn123 != null) {
			loginAnywayBtn123.click();
		}
		scroolToSpecifiedHeight(driver, 170);
		int retries = 10;
		int attempts = 0;
		while (attempts < retries) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement loginAnywayBtn100 = null;
				try {
					loginAnywayBtn100 = driver.findElement(By.xpath("//button[text()='New']"));
				} catch (Exception e) {
				}
				if (loginAnywayBtn100 != null) {
					loginAnywayBtn100.click();
				}
				Thread.sleep(2000);
				explictWaitForElementToBeVisible(driver, postOfficeDropdown);
				// explicityWaitForElemenToBeClickable(driver, postOfficeDropdown);
				postOfficeDropdown.click();
				scrollTillVisibleElement(driver, postOfficeDropdownText);
				moveToElementAndEnterTheData(driver, postOfficeDropdownText, postOffice);
				break;
			} catch (Exception e) {
				attempts++;
			}
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn2 = null;
		try {
			loginAnywayBtn2 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn2 != null) {
			loginAnywayBtn2.click();
		}
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		adharIdProofText.sendKeys(aadhaar);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn3 = null;
		try {
			loginAnywayBtn3 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn3 != null) {
			loginAnywayBtn3.click();
		}
//		scroolToSpecifiedHeight(driver, 700);
//		explictWaitForElementToBeVisible(driver, departmentDropdown);
//		explicityWaitForElemenToBeClickable(driver, departmentDropdown);
//		departmentDropdown.click();
//		Thread.sleep(1000);
//		moveToElementAndEnterTheData(driver, dropdownText, depName);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}

		int retries1 = 20;
		int attempts1 = 0;
		while (attempts1 < retries1) {
			try {
				explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
				// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
				doctorDropdownBtn.click();
				moveToElementAndEnterTheData(driver, dropdownText, doctorname);
				break;
			} catch (Exception e) {
				attempts1++;
			}
		}

		// Random random11 = new Random();
		String firstName33 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String tttt = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String yyyy = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		ReferredFromHospitalAndLocation.sendKeys(firstName33);
		ReferredByDoctor.sendKeys(tttt);
		ReferredBbySpeciality.sendKeys(yyyy);

	}

	public void OpdRegistartionForReferredFromHospitalLocation_Revisit(WebDriver driver, String hospitalNUmber,
			String depName, String doctorname) throws Throwable {

		hospitalNumberText.sendKeys(hospitalNUmber, Keys.TAB);
		scroolToSpecifiedHeight(driver, 700);
		Thread.sleep(1000);
		explictWaitForElementToBeVisible(driver, departmentDropdown);
		// explicityWaitForElemenToBeClickable(driver, departmentDropdown);
		departmentDropdown.click();
		Thread.sleep(1000);
		moveToElementAndEnterTheData(driver, dropdownText, depName);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn38 = null;
		try {
			loginAnywayBtn38 = driver.findElement(By.xpath("//button[text()='New']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn38 != null) {
			loginAnywayBtn38.click();
		}

		int retries1 = 20;
		int attempts1 = 0;
		while (attempts1 < retries1) {
			try {
				explictWaitForElementToBeVisible(driver, doctorDropdownBtn);
				// explicityWaitForElemenToBeClickable(driver, doctorDropdownBtn);
				doctorDropdownBtn.click();
				moveToElementAndEnterTheData(driver, dropdownText, doctorname);
				break;
			} catch (Exception e) {
				attempts1++;
			}
		}

		// Random random11 = new Random();
		Random random = new Random();
		String firstName33 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String tttt = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String yyyy = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		ReferredFromHospitalAndLocation.sendKeys(firstName33);
		ReferredByDoctor.sendKeys(tttt);
		ReferredBbySpeciality.sendKeys(yyyy);

	}

	public void OpdRegistartionForReferredFromHospitalLocation_CrossReferral(WebDriver driver) throws Throwable {
		scrollToBottom(driver);

		// Random random11 = new Random();
		Random random = new Random();
		String firstName33 = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String tttt = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String yyyy = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

		ReferredFromHospitalAndLocation.sendKeys(firstName33);
		ReferredByDoctor.sendKeys(tttt);
		ReferredBbySpeciality.sendKeys(yyyy);

	}

}
