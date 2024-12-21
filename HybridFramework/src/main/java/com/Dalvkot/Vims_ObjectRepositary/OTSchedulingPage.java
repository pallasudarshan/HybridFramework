package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class OTSchedulingPage extends WebDriverUtility {
	public OTSchedulingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()=' Add']")
	private WebElement addBtnInOtScheduling;

	@FindBy(xpath = "//label[text()='Schedule Type']/..//span[@role='presentation']")
	private WebElement scheduleTypeDropDOwnBtn;

	@FindBy(xpath = "//label[text()='Booked As']/..//span[@role='presentation']")
	private WebElement bookesAsDropDownBtn;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalNumberTextFeildInOtScheduling;

	@FindBy(xpath = "//label[text()='Store Name']/..//span[@role='presentation']")
	private WebElement storeNameDropDownBtn;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtnInOtSceduling;

	@FindBy(xpath = "//label[text()='Operation Theater']/..//span[@role='presentation']")
	private WebElement operationTheatreDropDownBtn;

	@FindBy(xpath = "//label[text()='Surgery Type']/..//span[@role='presentation']")
	private WebElement surgeryTypeDropDownBtn;

	@FindBy(xpath = "//label[text()='Surgery Nature']/..//span[@role='presentation']")
	private WebElement surgeryNatureDropDownBtn;

	@FindBy(xpath = "//input[@formcontrolname='surgerTime']")
	private WebElement surgeryTimeField;

	@FindBy(xpath = "//input[@formcontrolname='duration']")
	private WebElement durationTextField;

	@FindBy(xpath = "//label[text()='Anaesthesia Type']/..//span[@role='presentation']")
	private WebElement anaestesiaTypeDropDownBtn;

	@FindBy(xpath = "//textarea[@formcontrolname='specialNotes']")
	private WebElement specialNotesTextField;

	@FindBy(xpath = "//textarea[@formcontrolname='diagnosis']")
	private WebElement diagnosisTextField;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]//span[@role='presentation']")
	private WebElement departmentDropDownBtnUnderSurgeryDetails;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[3])[1]//span[@role='presentation']")
	private WebElement surgeryDescriptionDropDownBtnUnderSurgeryDetails;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[last()])[1]//button//i")
	private WebElement addBtnUnderSurgeryDetails;

	@FindBy(xpath = "//div[@class='table-responsive table-editable']//table//tr[2]//td[last()]//button//i[@class='zmdi zmdi-edit']")
	private WebElement pencilButton_SurgeryDetailsTable;

	@FindBy(xpath = "//div[@id='surgeryDetails']//table//tr[1]/td[2]//span[@role='presentation']")
	private WebElement doctorCatagoryDropDownBtnInthePopUP_surgeryDetailsTab;

	@FindBy(xpath = "//div[@id='surgeryDetails']//table//tr[1]/td[3]//span[@role='presentation']")
	private WebElement consultantNameDropDownBtnInThePopUp_surgeryDetailsTab;

	@FindAll({ @FindBy(xpath = "//div[@id='surgeryDetails']//table//tr[1]/td[last()]//button") })
	private WebElement addBtnInThePopUp_surgeryDetailsTab;

	@FindBy(xpath = "//div[@id='SurgeryDetailstab']//button[@id='closeModal']")
	private WebElement submitBtnInThe_SurgeonDetailsPopUP;

	@FindBy(xpath = "//div[@id='SurgeryDetailstab']//button[text()=' Submit']")
	private WebElement submitBtnInThePopUP;

	@FindBy(xpath = "//div[@id='SurgeryDetailstab']//button[text()=' Cancel']")
	private WebElement cancelBtnInThe_SurgeonDetailsPopUp;

	@FindBy(xpath = "//div[@id='specialInstrument']/descendant::input[@placeholder='Short Code']")
	private WebElement instrumentNameTextFieldInthePopUp_specialInstrumentTab;

	@FindBy(xpath = "//span[@title='Description']/following-sibling::span[1]")
	private WebElement descriptionDropDownBtnInthePopUp_specialInstrumentTab;

	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement quantityTextFieldIntherPopUP_specialInstrumentTab;

	@FindBy(xpath = "//div[@id='specialInstrument']//descendant::table/tbody/tr[1]/td/input[@placeholder='Rate']")
	private WebElement rateTextFieldInThePop_up_specialInstrumentTab;

	@FindBy(xpath = "//div[@id='specialInstrument']//tr[1]/td[last()]//button[@type='button']")
	private WebElement addBtn_specialInstrumentTab;

	@FindBy(xpath = "//textarea[@formcontrolname='diagnosis']")
	private WebElement diagnosisTextArea;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnInTheSuccesffullyCreatedPopUP;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement searchBtnInTheHospitalNUmber;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement searchBoxIntheDropDown;

	@FindBy(xpath = "(//a[@class='nav-link'])[3]")
	private WebElement specialInstrumentTab;

	@FindBy(xpath = "//span[text()=' OT Scheduling ']")
	private WebElement otSchedulingScreenBtn;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorMsg;

	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueBTn;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberTextField;

	@FindBy(xpath = "//label[text()='Department']/..//span[@role='presentation']")
	private WebElement departmentDropDownBtn;

	@FindBy(xpath = "//div[text()='Duration is more than 10 hours']")
	private WebElement durationMoreThan10Hr_msg;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement msgForSelectingDifferentDepartment;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalText_Filter;

	@FindBy(xpath = "//div[@id='OTLISt']//table//tr[1]/td[3]//a")
	private WebElement hospitalNumberBtn_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumberData_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientName_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement department_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement roomType_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement wardType_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement scheduleNumber_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement surgeryName_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement surgeryDate_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement status_OtList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::td[2]")
	private WebElement hospitalNumber_FirstRow_PacList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::td[3]")
	private WebElement opNumber_FirstRow_PacList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::td[4]")
	private WebElement patientName_FirstRow_PacList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::td[5]")
	private WebElement date_FirstRow_PacList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::td[6]")
	private WebElement time_FirstRow_PacList;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement mandatoryFieldErrorMsg;

	@FindBy(xpath = "//div[@id='OTLISt']//table/tbody/tr[1]/td[3]//a")
	private WebElement hospitalNumber_OtList;

	@FindBy(xpath = "//h2[text()='Please enter surgeon details.']")
	private WebElement pleaseEnterSurgeonDetailsMsg;

	@FindBy(xpath = "//div[@id='surgeryDetails']//table//tr[2]/td[last()]//button")
	private WebElement deleteBtn_SurgeryDetailsPopUp;

	@FindBy(xpath = "//button[contains(@class,'btn btn-warning')]")
	private WebElement deleteBtn_specialInstrument;

	@FindAll({ @FindBy(xpath = "//button[text()=' Clear']"),
			@FindBy(xpath = "//button[text()=' Search']/following-sibling::button"),
			@FindBy(xpath = "//button[@type='button']//img[1]") })
	private WebElement clearBtn_Filter;

	@FindAll({ @FindBy(xpath = "//span[@title='Status']/following-sibling::span") })
	private WebElement statueDropdown_Filter;

	@FindBy(xpath = "//div[@id='swal2-content']")
	private WebElement alreadyConfirmed_Popup;

	@FindBy(css = "button.swal2-confirm.swal2-styled")
	private WebElement okBtnAlreadyConfirmed_Popup;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindAll({ @FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[3]/descendant::a"),
			@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[3]") })
	private WebElement hospitalNumberInTable_LastRow;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[4]")
	private WebElement patientNameInTable_LastRow_OtList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientNameInTable_FirstRow_OtList;

	@FindBy(xpath = "//input[@placeholder='Patient Name']")
	private WebElement patientName_Filter;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[9]")
	private WebElement surgeryNameInTable_LastRow;

	@FindBy(xpath = "//input[@placeholder='Surgery Name']")
	private WebElement surgeryName_Filter;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
	private WebElement departmentDropDownBtn_Filter;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement departmentInTable_LastRow;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[11]")
	private WebElement statusInTable_LastRow;

	@FindBy(xpath = "(//span[@class='select2-selection__rendered']/following-sibling::span)[2]")
	private WebElement statusDropDownBtn_Filter;

	@FindBy(xpath = "//a[contains(text(),'PAC List')]")
	private WebElement pacListTab;

	@FindBy(xpath = "//div[@id='PACLISt']//table/tbody/tr[last()]/td[2]")
	private WebElement hospitalNumberInTablePacList_LastRow;

	@FindBy(xpath = "//div[@id='PACLISt']//table/tbody/tr[last()]/td[4]")
	private WebElement patientNameInTablePacList_LastRow;

	@FindBy(xpath = "//div[@id='PACLISt']//table/tbody/tr[last()]/td[10]")
	private WebElement surgeryNameInTablePacList_LastRow;

	@FindBy(xpath = "//div[@id='PACLISt']//table/tbody/tr[last()]/td[7]")
	private WebElement departmentInTablePacList_LastRow;

	@FindBy(xpath = "//div[@id='PACLISt']//table/tbody/tr[last()]/td[11]")
	private WebElement statusInTablePacList_LastRow;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'OT List')]"), @FindBy(linkText = "OT List"),
			@FindBy(xpath = "//a[contains(text(),'OT List')]") })
	private WebElement otListTab;

	@FindBys({ @FindBy(xpath = "//div[@id='OTLISt']//table/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialnoInOtList;

	@FindBy(xpath = "(//li/..//a[@aria-label='Next page'])[1]")
	private WebElement nextBtnInOtList;

	@FindBy(xpath = "(//li/..//a[@aria-label='Next page'])[2]")
	private WebElement nextBtnInPacList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[1]")
	private WebElement slNo_OtList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[1]")
	private WebElement slNo_PacList;

	@FindBy(xpath = "//li/..//a[@aria-label='Previous page']")
	private WebElement previousBtn_OtList;

	@FindBys({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialnoInPacList;

	@FindBy(xpath = "//div[@id='swal2-content']//td[1]")
	private WebElement surgeryNameTextInPopUp;

	@FindBy(xpath = "(//div[@class='swal2-html-container']//td)[2]")
	private WebElement surgeryDateTextInPopUp;

	@FindBy(xpath = "//div[text()='Patient is not admitted!']")
	private WebElement patientNotAdmittedText;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement otNumber_OtList;

	@FindBy(xpath = "//div[@id='surgeryDetails']//tbody//tr[1]/td[last()-1]//input[@placeholder='Surgery rate']")
	private WebElement surgeonAmount_SurgeonDetailsPopup;

	@FindBys({ @FindBy(xpath = "//div[@id='surgeryDetails']//tbody//tr[position()>1]/td[last()-1]//input") })
	private List<WebElement> surgeonAmounts_SurgeonDetailsPopup;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']/tbody/tr[2]/td[last()]")
	private WebElement additionalCharges_SurgeonDetailsPopup;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']/tbody/tr[3]/td[last()]")
	private WebElement TheaterChargesCharges_SurgeonDetailsPopup;

	@FindBy(xpath = "//input[@placeholder='Surgery Date']")
	private WebElement surgeryDate;

	// logics

	public void clickOnTheAddBtn(WebDriver driver) throws Throwable {
		scrollToTop(driver);
		scrollDownThePageUntilElementIsVisible(driver, addBtnInOtScheduling);
		addBtnInOtScheduling.click();
	}

	public void clickOnOtScenduleScreenLink(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, otSchedulingScreenBtn);

	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) throws Throwable {
		Thread.sleep(2500);
		scrollToTop(driver);
		hospitalNumberTextFeildInOtScheduling.sendKeys(hospitalNumber, Keys.TAB);
	}

	public void scrollDown(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public void scrollDownUsingRobotClass(WebDriver driver) throws Throwable {
		Robot robot = new Robot();
		Point startPoint = MouseInfo.getPointerInfo().getLocation();
		robot.mouseMove(startPoint.x, startPoint.y + 100);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void enterDataInOtScheduling(WebDriver driver, String operationTheatre, String surgeryType,
			String surgeryNature, String surgeryTime, String duration, String anaestesiaType, String specialNotes,
			String department, String surgeryDescription, String doctorcategory, String consultantName,
			String instrumentName, String description, String quantity, String rate, String diagnosis)
			throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, operationTheatreDropDownBtn);
		operationTheatreDropDownBtn.click();
		searchBoxIntheDropDown.sendKeys(operationTheatre);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		scrollDownThePageUntilElementIsVisible(driver, surgeryTypeDropDownBtn);
		surgeryTypeDropDownBtn.click();
		searchBoxIntheDropDown.sendKeys(surgeryType);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		scrollDownThePageUntilElementIsVisible(driver, surgeryNatureDropDownBtn);
		surgeryNatureDropDownBtn.click();
		searchBoxIntheDropDown.sendKeys(surgeryNature);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);
		surgeryTimeField.sendKeys(surgeryTime);
		durationTextField.sendKeys(duration);

		scrollDownThePageUntilElementIsVisible(driver, anaestesiaTypeDropDownBtn);
		anaestesiaTypeDropDownBtn.click();
		searchBoxIntheDropDown.sendKeys(anaestesiaType);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		specialNotesTextField.sendKeys(specialNotes);

		scrollDown(driver);

		scrollDown(driver);

		scrollDownThePageUntilElementIsVisible(driver, departmentDropDownBtnUnderSurgeryDetails);
		departmentDropDownBtnUnderSurgeryDetails.click();
		searchBoxIntheDropDown.sendKeys(department);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		scrollDownThePageUntilElementIsVisible(driver, surgeryDescriptionDropDownBtnUnderSurgeryDetails);
		surgeryDescriptionDropDownBtnUnderSurgeryDetails.click();

		searchBoxIntheDropDown.sendKeys(surgeryDescription);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		addBtnUnderSurgeryDetails.click();

		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.mouseMove(500, 500);
		robot.mouseWheel(2);

		scrollDownThePageUntilElementIsVisible(driver, doctorCatagoryDropDownBtnInthePopUP_surgeryDetailsTab);
		doctorCatagoryDropDownBtnInthePopUP_surgeryDetailsTab.click();
		searchBoxIntheDropDown.sendKeys(doctorcategory);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		scrollDownThePageUntilElementIsVisible(driver, consultantNameDropDownBtnInThePopUp_surgeryDetailsTab);
		consultantNameDropDownBtnInThePopUp_surgeryDetailsTab.click();
		searchBoxIntheDropDown.sendKeys(consultantName);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		moveToTheParticularElementAndClick(driver, addBtnInThePopUp_surgeryDetailsTab);

		specialInstrumentTab.click();

		instrumentNameTextFieldInthePopUp_specialInstrumentTab.sendKeys(instrumentName);

		scrollDownThePageUntilElementIsVisible(driver, descriptionDropDownBtnInthePopUp_specialInstrumentTab);
		descriptionDropDownBtnInthePopUp_specialInstrumentTab.click();
		searchBoxIntheDropDown.sendKeys(description);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);

		quantityTextFieldIntherPopUP_specialInstrumentTab.sendKeys(quantity);

		rateTextFieldInThePop_up_specialInstrumentTab.sendKeys(rate);

		moveToTheParticularElementAndClick(driver, addBtn_specialInstrumentTab);

		moveToTheParticularElementAndClick(driver, submitBtnInThe_SurgeonDetailsPopUP);

		diagnosisTextArea.sendKeys(diagnosis);

		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtn);

		clickOnTheElementUsedToJavascriptExecuter(driver, okBtnInTheSuccesffullyCreatedPopUP);

	}

	public void clickOnSubmit(WebDriver driver) throws Throwable {
		scrollToBottom(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollTillVisibleElement(driver, submitBtn);
		submitBtn.click();
	}

	public String verifyErrorMsg(WebDriver driver) throws Throwable {
		Thread.sleep(750);
		String errorMsg1 = errorMsg.getText();
		return errorMsg1;
	}

	public void clickOnContinueIfpopUpDisplays(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement popup = null;
		try {
			popup = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("popup_element_id")));
		} catch (Exception e) {
			System.out.println("Popup not found. Continue with the next steps.");
		}
		if (popup != null) {
			popup.findElement(By.xpath("//button[text()='Continue']")).click();
		}
	}

	public void enterHospitalNumberInOtScheduling(WebDriver driver, String hospitalNumber) throws Throwable {
		Thread.sleep(1500);
		hospitalNumberTextFeildInOtScheduling.sendKeys(hospitalNumber, Keys.TAB);
	}

	public void selectDepartmentInOtScheduling(WebDriver driver, String department) throws Throwable {
		Thread.sleep(1500);
		dropdown_Handling(driver, 5, departmentDropDownBtn, searchBoxIntheDropDown, department);
	}

	public void selectOperationTheaterInOtScheduling(WebDriver driver, String operationTheater) throws Throwable {
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, operationTheatreDropDownBtn);
		dropdown_Handling(driver, 3, operationTheatreDropDownBtn, searchBoxIntheDropDown, operationTheater);
	}

	public void selectSurgeryTypeInOtScheduling(WebDriver driver, String surgeryNature) throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, surgeryTypeDropDownBtn);
		dropdown_Handling(driver, 3, surgeryTypeDropDownBtn, searchBoxIntheDropDown, surgeryNature);
	}

	public void selectSurgeryNatureInOtScheduling(WebDriver driver, String surgeryNature) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, surgeryNatureDropDownBtn);
		dropdown_Handling(driver, 3, surgeryNatureDropDownBtn, searchBoxIntheDropDown, surgeryNature);
	}

	public void enterSurgeryTime(WebDriver driver, String surgeryTime) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, surgeryTimeField);
		surgeryTimeField.sendKeys(surgeryTime);
	}

	public void enterduration(WebDriver driver, String duration) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, durationTextField);
		durationTextField.sendKeys(duration, Keys.TAB);
	}

	public void selectAnastesiaTypeInOtScheduling(WebDriver driver, String anastesiaType) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, anaestesiaTypeDropDownBtn);
		dropdown_Handling(driver, 3, anaestesiaTypeDropDownBtn, searchBoxIntheDropDown, anastesiaType);
	}

	public void enterDisgosis(WebDriver driver, String diagnosis) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, diagnosisTextArea);
		diagnosisTextArea.sendKeys(diagnosis);
	}

	public void enterSpecialNotes(WebDriver driver, String specialNotes) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, specialNotesTextField);
		specialNotesTextField.sendKeys(specialNotes);
	}

	public String verifyMoreThan10HrInDurationField(WebDriver driver) throws Throwable {
		Thread.sleep(800);
		String msg = durationMoreThan10Hr_msg.getText();
		okBtnInTheSuccesffullyCreatedPopUP.click();
		return msg;
	}

	public String verifyMsgbyselectingDifferentDepartment(WebDriver driver) throws Throwable {
		Thread.sleep(800);
		String msg = msgForSelectingDifferentDepartment.getText();
		okBtnInTheSuccesffullyCreatedPopUP.click();
		return msg;
	}

	public void selectDepartment_surgeryDetails(WebDriver driver, String dep_SugeryDetails) throws Throwable {
		scrollTillVisibleElement(driver, departmentDropDownBtnUnderSurgeryDetails);
		scrollUntilElementVisible(driver, departmentDropDownBtnUnderSurgeryDetails);
		scrollDownThePageUntilElementIsVisible(driver, departmentDropDownBtnUnderSurgeryDetails);
		dropdown_Handling(driver, 3, departmentDropDownBtnUnderSurgeryDetails, searchBoxIntheDropDown,
				dep_SugeryDetails);
	}

	public void selectSurgeryDescription_surgeryDetails(WebDriver driver, String description_SugeryDetails)
			throws Throwable {
		Thread.sleep(1500);
		scrollDownThePageUntilElementIsVisible(driver, surgeryDescriptionDropDownBtnUnderSurgeryDetails);
		dropdown_Handling(driver, 3, surgeryDescriptionDropDownBtnUnderSurgeryDetails, searchBoxIntheDropDown,
				description_SugeryDetails);
	}

	public void clickOnAddLineItem_surgeryDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, addBtnUnderSurgeryDetails);
		addBtnUnderSurgeryDetails.click();
	}

	public void clickOnAddLineItem_SurgeryDetailspopUP(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, addBtnInThePopUp_surgeryDetailsTab);
		addBtnInThePopUp_surgeryDetailsTab.click();
	}

	public void clickOnAddLineItem_SpecialInstrumentpopUP(WebDriver driver) throws Throwable {
		Thread.sleep(800);
		scrollDownThePageUntilElementIsVisible(driver, addBtn_specialInstrumentTab);
		addBtn_specialInstrumentTab.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String verifyMandatoryFieldErrorMsg(WebDriver driver) throws Throwable {
		Thread.sleep(500);
		String errorMsg = mandatoryFieldErrorMsg.getText();
		okBtnInTheSuccesffullyCreatedPopUP.click();
		return errorMsg;
	}

	public void clickOnSpecialInstrumentTab(WebDriver driver) throws Throwable {
		clickElementWithRetries(driver, 7, specialInstrumentTab);
	}

	public void otScheduling_Process(WebDriver driver, String operationTheatre, String surgeryType,
			String surgeryNature, String surgeryTime, String duration, String anaestesiaType, String specialNotes) {

		scrollDownThePageUntilElementIsVisible(driver, operationTheatreDropDownBtn);
		dropdown_Handling(driver, 6, operationTheatreDropDownBtn, searchBoxIntheDropDown, operationTheatre);

		scrollDownThePageUntilElementIsVisible(driver, surgeryTypeDropDownBtn);
		dropdown(driver, surgeryTypeDropDownBtn, searchBoxIntheDropDown, surgeryType);

		scrollDownThePageUntilElementIsVisible(driver, surgeryNatureDropDownBtn);
		surgeryNatureDropDownBtn.click();
		searchBoxIntheDropDown.sendKeys(surgeryNature);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);
		surgeryTimeField.sendKeys(surgeryTime);

		durationTextField.sendKeys(duration);
		scrollDownThePageUntilElementIsVisible(driver, anaestesiaTypeDropDownBtn);
		anaestesiaTypeDropDownBtn.click();
		searchBoxIntheDropDown.sendKeys(anaestesiaType);
		searchBoxIntheDropDown.sendKeys(Keys.ENTER);
		specialNotesTextField.sendKeys(specialNotes);
	}

	public void otScheduling_ProcessTwo(WebDriver driver, String department, String surgeryDescription,
			String doctorcategory, String consultantName, String instrumentName, String description, String quantity,
			String rate, String diagnosis) throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, departmentDropDownBtnUnderSurgeryDetails);
		dropdown_Handling(driver, 3, departmentDropDownBtnUnderSurgeryDetails, searchBoxIntheDropDown, department);

		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, surgeryDescriptionDropDownBtnUnderSurgeryDetails);
		surgeryDescriptionDropDownBtnUnderSurgeryDetails.click();
		moveToElementAndEnterTheData(driver, searchBoxIntheDropDown, surgeryDescription);

		addBtnUnderSurgeryDetails.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.mouseMove(500, 500);
		robot.mouseWheel(2);

		dropdown_Handling(driver, 3, doctorCatagoryDropDownBtnInthePopUP_surgeryDetailsTab, searchBoxIntheDropDown,
				doctorcategory);

		dropdown_Handling(driver, 3, consultantNameDropDownBtnInThePopUp_surgeryDetailsTab, searchBoxIntheDropDown,
				consultantName);

		moveToTheParticularElementAndClick(driver, addBtnInThePopUp_surgeryDetailsTab);

		specialInstrumentTab.click();

		instrumentNameTextFieldInthePopUp_specialInstrumentTab.sendKeys(instrumentName);

		dropdown_Handling(driver, 2, descriptionDropDownBtnInthePopUp_specialInstrumentTab, searchBoxIntheDropDown,
				description);

		quantityTextFieldIntherPopUP_specialInstrumentTab.sendKeys(quantity);

		rateTextFieldInThePop_up_specialInstrumentTab.sendKeys(rate);

		moveToTheParticularElementAndClick(driver, addBtn_specialInstrumentTab);

		moveToTheParticularElementAndClick(driver, submitBtnInThe_SurgeonDetailsPopUP);
		diagnosisTextArea.sendKeys(diagnosis);
		scrollDownTheStillEndOfThePage(driver);

	}

	public void enterHospitalNumber_Filter(WebDriver driver, String hospitalNumber) throws Throwable {
		Thread.sleep(2000);
		hospitalText_Filter.sendKeys(hospitalNumber);
	}

	public void clickOnSearchBtn_Filters(WebDriver driver) throws Throwable {
		searchBtnInOtSceduling.click();
	}

	public String takeHospitalNumber_OtList(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String hospitalNumber = hospitalNumberData_OtList.getText();
		return hospitalNumber;
	}

	public void clickOnHospitalNumber_OtList(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, hospitalNumber_OtList);
	}

	public void clickOnSubmit_SurgeryDetailsPopPU(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, submitBtnInThePopUP);
		submitBtnInThePopUP.click();
	}

	public String capturePleaseEnterSurgonDetails_msg(WebDriver driver) throws Throwable {
		Thread.sleep(500);
		String errorMsg = pleaseEnterSurgeonDetailsMsg.getText();
		okBtnInTheSuccesffullyCreatedPopUP.click();
		return errorMsg;
	}

	public void selectDoctorCatagory_surgeryDetailsPopUP(WebDriver driver, String doctorCatagory) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, doctorCatagoryDropDownBtnInthePopUP_surgeryDetailsTab);
		scrollTillVisibleElement(driver, doctorCatagoryDropDownBtnInthePopUP_surgeryDetailsTab);
		dropdown(driver, doctorCatagoryDropDownBtnInthePopUP_surgeryDetailsTab, searchBoxIntheDropDown, doctorCatagory);
	}

	public void selectConsultantName_surgeryDetailsPopUP(WebDriver driver, String consultantName) throws Throwable {
		dropdown_Handling(driver, 4, consultantNameDropDownBtnInThePopUp_surgeryDetailsTab, searchBoxIntheDropDown,
				consultantName);
	}

	public void addLineItems_surgeryDetailsPopup(WebDriver driver, String doctorCatagory, String consultantName)
			throws Throwable {
		for (int i = 0; i <= 4; i++) {
			selectDoctorCatagory_surgeryDetailsPopUP(driver, doctorCatagory);
			selectConsultantName_surgeryDetailsPopUP(driver, consultantName);
			clickOnAddLineItem_SurgeryDetailspopUP(driver);
		}
	}

	public void deletelineItem_surgeryDetailsPopUP(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, deleteBtn_SurgeryDetailsPopUp);
		deleteBtn_SurgeryDetailsPopUp.click();
	}

	public void deleteLineItems_surgeryDetailsPopup(WebDriver driver) throws Throwable {
		for (int i = 0; i <= 4; i++) {
			deletelineItem_surgeryDetailsPopUP(driver);
		}
	}

	public void verifyDeleteBtnIsVisibleOrnot_SurgeryDetailsPopUP(WebDriver driver) throws Throwable {
		try {
			assert !deleteBtn_SurgeryDetailsPopUp.isDisplayed()
					: "Delete button is still present after the item is deleted!";
			System.out.println("Delete button is not present after the item is deleted. Test passed!");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Delete button is not present after the item is deleted. Test passed!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterInstrumentName_surgeryDetailsPopUP(WebDriver driver, String instrumentName) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, instrumentNameTextFieldInthePopUp_specialInstrumentTab);
		instrumentNameTextFieldInthePopUp_specialInstrumentTab.sendKeys(instrumentName);
	}

	public void selectDescription_surgeryDetailsPopUP(WebDriver driver, String description) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, descriptionDropDownBtnInthePopUp_specialInstrumentTab);
		dropdown_Handling(driver, 3, descriptionDropDownBtnInthePopUp_specialInstrumentTab, searchBoxIntheDropDown,
				description);
	}

	public void enterQuantity_surgeryDetailsPopUP(WebDriver driver, String quantity) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, instrumentNameTextFieldInthePopUp_specialInstrumentTab);
		quantityTextFieldIntherPopUP_specialInstrumentTab.sendKeys(quantity);
	}

	public void enterRate_surgeryDetailsPopUP(WebDriver driver, String rate) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, rateTextFieldInThePop_up_specialInstrumentTab);
		rateTextFieldInThePop_up_specialInstrumentTab.sendKeys(rate);
	}

	public void addBtn_SpecialInstrument(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, addBtn_specialInstrumentTab);
		addBtn_specialInstrumentTab.click();
	}

	public void addLineItems_specialInstrument(WebDriver driver, String instrumentName, String description,
			String quantity, String rate) throws Throwable {
		for (int i = 0; i <= 4; i++) {
			enterInstrumentName_surgeryDetailsPopUP(driver, instrumentName);
			selectDescription_surgeryDetailsPopUP(driver, description);
			enterQuantity_surgeryDetailsPopUP(driver, quantity);
			enterRate_surgeryDetailsPopUP(driver, rate);
			addBtn_SpecialInstrument(driver);
		}
	}

	public void deleteLineItems_specialInstrument(WebDriver driver) throws Throwable {
		for (int i = 0; i <= 4; i++) {
			deletelineItem_specialInstrument(driver);
		}
	}

	public void deletelineItem_specialInstrument(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, deleteBtn_specialInstrument);
		deleteBtn_specialInstrument.click();
	}

	public void verifyDeleteBtnIsVisibleOrnot_SpecailInstrumentPopUP(WebDriver driver) throws Throwable {
		try {
			assert !deleteBtn_specialInstrument.isDisplayed()
					: "Delete button is still present after the item is deleted!";
			System.out.println("Delete button is not present after the item is deleted. Test passed!");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Delete button is not present after the item is deleted. Test passed!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String captureSpecialInstrumentTextInThePopUP(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String text = specialInstrumentTab.getText();
		return text;
	}

	public void clickOnClearButton(WebDriver driver) {
		clearBtn_Filter.click();
	}

	public void selectStatusDropdownButton_Filter(WebDriver driver, String status) throws Throwable {
		dropdown_Handling(driver, 4, statueDropdown_Filter, searchBoxIntheDropDown, status);
	}

	public String takeAlready_Confirmed_PopupStatus_OkBtn(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String popupMsg = alreadyConfirmed_Popup.getText();
		return popupMsg;
	}

	public void clickOnClearBtn(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		clearBtn.click();
	}

	public String captureLastRowHospitalNumber(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollTillVisibleElement(driver, hospitalNumberInTable_LastRow);
		String hospitalNumber = hospitalNumberInTable_LastRow.getText();
		return hospitalNumber;
	}

	public String captureLastRowPatientName_OtList(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, patientNameInTable_LastRow_OtList);
		String patientName = patientNameInTable_LastRow_OtList.getText();
		String patientName1 = patientName.substring(0, patientName.indexOf("(")).trim();
		return patientName1;
	}

	public String captureFirstRowPatientName_OtList(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, patientNameInTable_FirstRow_OtList);
		String patientName = patientNameInTable_FirstRow_OtList.getText();
		String patientName1 = patientName.substring(0, patientName.indexOf("(")).trim();
		return patientName1;
	}

	public void enterPatientName_Filter(WebDriver driver, String patientName) {
		patientName_Filter.sendKeys(patientName);
	}

	public String captureLastRowSurgeryName(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, surgeryNameInTable_LastRow);
		String surgeryName = surgeryNameInTable_LastRow.getText();
		return surgeryName;
	}

	public void enterSurgeryName_Filter(WebDriver driver, String surgeryName) {
		surgeryName_Filter.sendKeys(surgeryName);
	}

	public void selectDepartment_Filter(WebDriver driver, String department) {
		dropdown_Handling(driver, 3, departmentDropDownBtn_Filter, searchBoxIntheDropDown, department);
	}

	public String captureLastRowDepartment(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, departmentInTable_LastRow);
		String department = departmentInTable_LastRow.getText();
		return department;
	}

	public String captureLastRowStatus(WebDriver driver) throws Throwable {
		Thread.sleep(5000);
		scrollTillVisibleElement(driver, statusInTable_LastRow);
		String status = statusInTable_LastRow.getText();
		return status;
	}

	public void selectStatus_Filter(WebDriver driver, String status) throws Throwable {
		dropdown_Handling(driver, 3, statusDropDownBtn_Filter, searchBoxIntheDropDown, status);
		Thread.sleep(1000);
	}

	public void clickOnPacListTab(WebDriver driver) throws Throwable {
		pacListTab.click();
	}

	public void clickOnOkBtnIfDisplays(WebDriver driver) throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement okBtn = null;
		try {
			okBtn = driver.findElement(By.xpath("//button[text()='OK']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Ok button not found. Skipping clicking the OK button.");
		}
		if (okBtn != null) {
			okBtn.click();
		}
	}

	public String captureLastRowHospitalNumber_pacList(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollTillVisibleElement(driver, hospitalNumberInTablePacList_LastRow);
		String hospitalNumber = hospitalNumberInTablePacList_LastRow.getText();
		return hospitalNumber;
	}

	public String captureLastRowPatientNameInPacList(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, patientNameInTablePacList_LastRow);
		String patientName = patientNameInTablePacList_LastRow.getText();
		String patientName1 = patientName.substring(0, patientName.indexOf("(")).trim();
		return patientName1;
	}

	public String captureLastRowSurgeryNameInPacList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, surgeryNameInTablePacList_LastRow);
		String surgeryName = surgeryNameInTablePacList_LastRow.getText();
		return surgeryName;
	}

	public String captureLastRowDepartmentInPacList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, departmentInTablePacList_LastRow);
		String department = departmentInTablePacList_LastRow.getText();
		String dept = removeSpecialCharactersAndNumbers_RemoveLastCharacters(department, 8);
		return dept;
	}

	public String captureLastRowStatusInPacList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, statusInTablePacList_LastRow);
		String status = statusInTablePacList_LastRow.getText();
		return status;
	}

	public void clickOnOkBtn(WebDriver driver) throws Throwable {
		okBtnInTheSuccesffullyCreatedPopUP.click();
	}

	public void enterSurgeryDate(WebDriver driver, String date) {
		surgeryDate.sendKeys(date);
	}

	public void otScheduleProcess_one(WebDriver driver, String operationTheater, String SurgeryType,
			String SurgeryNature, String date, String surgeryTime, String duration, String anastesiaType,
			String specialNotes) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		selectOperationTheaterInOtScheduling(driver, operationTheater);
		selectSurgeryTypeInOtScheduling(driver, SurgeryType);
		selectSurgeryNatureInOtScheduling(driver, SurgeryNature);
		enterSurgeryDate(driver, date);
		enterSurgeryTime(driver, surgeryTime);
		enterduration(driver, duration);
		selectAnastesiaTypeInOtScheduling(driver, anastesiaType);
		enterSpecialNotes(driver, specialNotes);

	}

	public void otScheduleProcess_two(WebDriver driver, String dep, String surgeryDescription, String doctorCatagory,
			String consultantName, String diagnosis) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);

		selectDepartment_surgeryDetails(driver, dep);

		selectSurgeryDescription_surgeryDetails(driver, surgeryDescription);

		clickOnAddLineItem_surgeryDetails(driver);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		selectDoctorCatagory_surgeryDetailsPopUP(driver, doctorCatagory);
		Thread.sleep(1000);
		selectConsultantName_surgeryDetailsPopUP(driver, consultantName);
		clickOnAddLineItem_SurgeryDetailspopUP(driver);
		clickOnSubmit_SurgeryDetailsPopPU(driver);
		enterDisgosis(driver, diagnosis);
		clickOnSubmit(driver);
		clickOnOkBtn(driver);
	}

	public void clickOnOtListTab(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, otListTab);
		otListTab.click();

	}

	public void verifyNextBtnIsWorkingAsExpectedInOtList(WebDriver driver) throws Throwable {
		Thread.sleep(7000);
		for (int i = 1; i <= 3; i++) {
			WebElement lastSlNo = listOfSerialnoInOtList.get(listOfSerialnoInOtList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);

			nextBtnInOtList.click();
			Thread.sleep(6500);
			String ls1 = slNo_OtList.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpectedInOtList(WebDriver driver) throws Throwable {

		Thread.sleep(7000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 2; i++) {
			Thread.sleep(6000);
			scrollToBottom(driver);
			nextBtnInOtList.click();
		}
		for (int i = 1; i <= 2; i++) {
			Thread.sleep(6000);
			String ls1 = slNo_OtList.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			scrollToBottom(driver);
			previousBtn_OtList.click();
			Thread.sleep(6000);
			WebElement lastSlNo = listOfSerialnoInOtList.get(listOfSerialnoInOtList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public void verifyNextBtnIsWorkingAsExpectedInPacList(WebDriver driver) throws Throwable {

		Thread.sleep(7000);
		for (int i = 1; i <= 3; i++) {

			WebElement lastSlNo = listOfSerialnoInPacList.get(listOfSerialnoInPacList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);

			nextBtnInPacList.click();
			Thread.sleep(6500);
			scrollDownThePageUntilElementIsVisible(driver, slNo_PacList);
			String ls1 = slNo_PacList.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpectedInPacList(WebDriver driver) throws Throwable {

		Thread.sleep(7000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 2; i++) {
			Thread.sleep(6000);
			scrollToBottom(driver);
			nextBtnInPacList.click();
		}
		for (int i = 1; i <= 2; i++) {
			Thread.sleep(6000);
			String ls1 = slNo_PacList.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			scrollToBottom(driver);
			previousBtn_OtList.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			Thread.sleep(6000);
			WebElement lastSlNo = listOfSerialnoInPacList.get(listOfSerialnoInPacList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public String captureSurgeryNameInThePopup(WebDriver driver) throws Throwable {

		Thread.sleep(600);
		String surgeryName = surgeryNameTextInPopUp.getText();
		return surgeryName;
	}

	public String captureSurgeryDateInThePopup(WebDriver driver) throws Throwable {

		Thread.sleep(600);
		String surgeryDate = surgeryDateTextInPopUp.getText();
		String date = surgeryDate.trim().substring(0, 10);
		String date1 = date.replace("-", "");
		return date1;
	}

	public String captureRoomTypeInTable_OtList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = roomType_OtList.getText();
		return roomType;
	}

	public String captureWardTypeInTable_OtList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String wardType = wardType_OtList.getText();
		return wardType;
	}

	public String capturePatientNotAdmittedPopUp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = patientNotAdmittedText.getText();
		return text;
	}

	public String captureScheduleNumber_OtList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, scheduleNumber_OtList);
		String scheduleNumber = scheduleNumber_OtList.getText();
		return scheduleNumber;
	}

	public String captureOtNumber_OtList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, otNumber_OtList);
		String otNumber = otNumber_OtList.getText();
		return otNumber;
	}

	public String captureSurgeryDate_OtList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, surgeryDate_OtList);
		String surgeryDate = surgeryDate_OtList.getText();
		return surgeryDate;
	}

	public void clickOn_PencilButtonIn_SurgeryDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pencilButton_SurgeryDetailsTable);

		pencilButton_SurgeryDetailsTable.click();
	}

	public void surgeonDetails_InThePopup(WebDriver driver, String doctorCateory, String consultantName,
			String surgeonAmount) throws Throwable {
		selectDoctorCatagory_surgeryDetailsPopUP(driver, doctorCateory);
		selectConsultantName_surgeryDetailsPopUP(driver, consultantName);
		surgeonAmount_SurgeonDetailsPopup.sendKeys(surgeonAmount);
		clickOnAddLineItem_SurgeryDetailspopUP(driver);
	}

	public String capture_SurgerRates_SurgeryDetails_Tab_InThePopup(WebDriver driver) {
		double number1 = 0.0;
		for (WebElement webElement : surgeonAmounts_SurgeonDetailsPopup) {
			String rate = webElement.getAttribute("value");
			System.out.println(rate);
			double number = Double.parseDouble(rate);
			number1 = number1 + number;
		}
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		String totalSurgeonAmounts = decimalFormat.format(number1);
		return totalSurgeonAmounts;
	}

	public String capture_ServiceName_Amounts_SurgeonDetailsPopup(WebDriver driver, String hours) {
		scrollTillVisibleElement(driver, additionalCharges_SurgeonDetailsPopup);
		String amount = additionalCharges_SurgeonDetailsPopup.getText();
		String cleanedValue = amount.replace("₹", "").replace(",", "");
		double convertedValue = Double.parseDouble(cleanedValue);
		double hour = Double.parseDouble(hours);
		hour--;
		System.out.println("Hours values" + hour);
		double amounts = convertedValue * hour;
		String additionalCharges = String.format("%.2f", amounts);
		return additionalCharges;
	}

	public String capture_TheaterCharges_SurgeryDetailsPopup(WebDriver driver) {
		scrollTillVisibleElement(driver, TheaterChargesCharges_SurgeonDetailsPopup);
		String amount = TheaterChargesCharges_SurgeonDetailsPopup.getText();
		String cleanedValue = amount.replace("₹", "").replace(",", "");
		double convertedValue = Double.parseDouble(cleanedValue);
		String TheaterlCharges = String.format("%.2f", convertedValue);
		return TheaterlCharges;
	}
}
