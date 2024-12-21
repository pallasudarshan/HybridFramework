package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class PacAnaesthesiaConfirmationPage extends WebDriverUtility {

	public PacAnaesthesiaConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' PAC Anaesthesia Confirmation ']")
	private WebElement pacAnaesthesiaConfirmationBtn;

	@FindBy(xpath = "//input[@formcontrolname='HospitalNumber']")
	private WebElement hospitalNumberText;

	@FindBy(css = "input[placeholder='IP Number']")
	private WebElement ipNumberText;

	@FindBy(xpath = "//label[text()='Department Name']/..//span[@role='presentation']")
	private WebElement departmentNameDropdownBtn;

	@FindBy(css = "input[formcontrolname='regnDate']")
	private WebElement surgeryDateCalender;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement hospitalNumber_ReqTable;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement ipNumber_ReqTable;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientName_ReqTable;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement department_ReqTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
	private WebElement doctorNameTable;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement surgeryDate_ReqTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()-2]")
	private WebElement status_ReqTable;

	@FindBy(xpath = "//a[contains(text(),'Review List')]")
	private WebElement reviewTab;

	// eview List
	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement hospitalNumber_ReviewTable;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement ipNumber_ReviewTable;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement department_ReviewTable;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement surgeryDate_ReviewTable;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[last()]")
	private WebElement reviewCount_ReviewTable;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actiontn_ReqTable;

	@FindBy(xpath = "//table//tr[1]//td[last()]//button[text()='Confirm']")
	private WebElement confirm_ReqTable;

	@FindBy(xpath = "//div[@id='OTLISt']//tr[1]/td[last()]//button[text()='cancel']")
	private WebElement cancel_ReqTable;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[last()]/descendant::button[text()='View']")
	private WebElement viewAction_ReqTable;

	@FindBy(xpath = "//div[@id='OTLISt']//tr[1]/td[last()]//button[text()=' Re-Schedule']")
	private WebElement reschedule_ReqTable;

	@FindBy(xpath = "(//textarea[@name='remarks'])[2]")
	private WebElement reasonForCancellation;

	@FindBy(xpath = "//div[@id='exampleModalCenter5']/descendant::button[@id='closeModal']")
	private WebElement sumbitBtn_ReasonCancellation;

	@FindBy(xpath = "//div[@id='exampleModalCenter5']/descendant::button//i[@class='zmdi zmdi-card-sd']")
	private WebElement cancelBtn_ReasonCancellation;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okSuccesssfullMessage;

	@FindBy(css = "textarea#remarks")
	private WebElement reasonForRescheduleText;

	@FindBy(xpath = "//div[@id='exampleModalCenter3']/descendant::button[text()=' Submit ']")
	private WebElement submit_Reschedule;

	@FindBy(xpath = "//div[@id='exampleModalCenter3']/descendant::button[text()=' Cancel']")
	private WebElement cancel_Reschedule;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//div[@id='OTLISt']//tbody/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actionsBtnForVims;

	@FindBy(xpath = "//div[@id='OTLISt']//tbody/tr[1]/td[last()]/descendant::button[text()=' Re-Schedule']")
	private WebElement rescheduleSuggetionActions;

	@FindBy(xpath = "//div[@id='OTLISt']//table//tr[1]//td[last()]//button[text()='Confirm']")
	private WebElement confirmationSuggetionActions;

	@FindBy(xpath = "//div[@id='OTLISt']//table//tr[1]//td[last()]//button[text()='cancel']")
	private WebElement cancelSuggestionActions;

	@FindBy(xpath = "//div[@id='OTLISt']//table//tr[1]//td[last()]//button[text()=' Re-Schedule']")
	private WebElement rescheduleSuggestionActions;

	@FindBy(xpath = "/html/body/app-root/app-home/app-pac-anaesthesia-confirmation-list/div[1]/div/div/div/form/div/div/div[2]/div/div/div/textarea")
	private WebElement reasonForRescheduleText_Popup;

	@FindBy(xpath = "/html/body/app-root/app-home/app-pac-anaesthesia-confirmation-list/div[1]/div/div/div/form/div/div/div[3]/button[1]/i")
	private WebElement submitButton_ReschedulePopup;

	@FindBy(xpath = "//form[@class='ng-pristine ng-valid ng-touched']/descendant::i[@class='zmdi zmdi-close-circle']")
	private WebElement cancelButton_ReschedulePopup;

	@FindBy(xpath = "(//span[@title='Select'])[1]/following-sibling::span")
	private WebElement asaClassDropdownBtn;

	@FindBy(css = "input[autocapitalize='none']")
	private WebElement dropdownText;

	@FindBy(xpath = "//input[@formcontrolname='weight']")
	private WebElement weightText;

	@FindBy(xpath = "//input[@formcontrolname='height']")
	private WebElement heightText;

	@FindBy(xpath = "//input[@formcontrolname='bp']")
	private WebElement bloodPressureText;

	@FindBy(xpath = "//input[@placeholder='HR']")
	private WebElement hrMinText;

	@FindBy(xpath = "//input[@formcontrolname='spo2']")
	private WebElement spo2Text;

	@FindBy(xpath = "//input[@placeholder='RR']")
	private WebElement rrMinText;

	@FindBy(xpath = "//input[@placeholder='Language']")
	private WebElement languageText;

	@FindBy(xpath = "//label[text()='Elective/Emergency']/..//span[@role='presentation']")
	private WebElement electiveEmergencyDropdownBtn;

	@FindBy(xpath = "//input[@placeholder='Disease']")
	private WebElement DiseaseText;

	@FindBy(xpath = "//input[@placeholder='Medications']")
	private WebElement MedicationsText;

	@FindBy(xpath = "//input[@placeholder='Medications']/ancestor::table//button")
	private WebElement actionBtnPastMedicalHistory;

	@FindBy(xpath = "//input[@placeholder='Operation Name']")
	private WebElement operationNameText;

	@FindBy(xpath = "//input[@formcontrolname='lmp']")
	private WebElement lmpText;

	@FindBy(xpath = "//input[@formcontrolname='lmp']")
	private WebElement ocpText;

	@FindBy(xpath = "//input[@formcontrolname='prostheses']")
	private WebElement prosthesesText;

	@FindBy(xpath = "//input[@formcontrolname='anticoagulants']")
	private WebElement anticoagulantsText;

	@FindBy(xpath = "//input[@formcontrolname='vysya']/..//span[@class='switch-handle']")
	private WebElement vysyaBtn;

	@FindBy(xpath = "//input[@formcontrolname='dentures']/..//span[@class='switch-handle']")
	private WebElement denturesText;

	@FindBy(css = "textarea[formcontrolname='historyOfpresentLines']")
	private WebElement historyOfPresentIllnessTextarea;

	@FindBy(xpath = "//button[text()=' Next']")
	private WebElement nextButton;

	@FindBy(xpath = "//input[@placeholder='Pallor ']")
	private WebElement pallorText;

	@FindBy(xpath = "//input[@formcontrolname='icterusCyanosis']")
	private WebElement icterusText;

	@FindBy(xpath = "//input[@formcontrolname='cyanosis']")
	private WebElement cyanosisText;

	@FindBy(xpath = "//input[@formcontrolname='koilonychia']")
	private WebElement koilonychiaText;

	@FindBy(xpath = "//input[@formcontrolname='lymphadenopathy']")
	private WebElement lymphadenopathyText;

	@FindBy(xpath = "//input[@placeholder='Oedema ']")
	private WebElement oedemaText;

	@FindBy(xpath = "//input[@formcontrolname='neckExtension']")
	private WebElement neckExtensionText;

	@FindBy(xpath = "//input[@formcontrolname='neckFlexion']")
	private WebElement neckFlexionText;

	@FindBy(xpath = "//input[@formcontrolname='looseTooth']")
	private WebElement looseToothText;

	@FindBy(xpath = "//input[@placeholder='MP']")
	private WebElement mpText;

	@FindBy(xpath = "//input[@placeholder='TMD ']")
	private WebElement tmdText;

	@FindBy(xpath = "//input[@placeholder='TMJ ']")
	private WebElement tmjText;

	@FindBy(xpath = "//input[@placeholder='MO ']")
	private WebElement moText;

	@FindBy(xpath = "//input[@placeholder='I.V.Access']")
	private WebElement ivAccessText;

	@FindBy(xpath = "//input[@placeholder='Spine']")
	private WebElement spineText;

	@FindBy(css = "div[aria-label='Rich Text Editor, main']")
	private WebElement preAnasthesiaOrdersTextarea;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement successfullPopUpOKBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement captureIPNumber;

	@FindAll({ @FindBy(css = "body[aria-label='Rich Text Editor, editor1']"),
			@FindBy(css = "body[aria-label='Rich Text Editor, editor1']") })
	private WebElement historyOfillnessTextArea;

	@FindBy(xpath = "//div[@id='History1']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement iframe_historyOfIllnessTab;

	@FindBy(css = "iframe[title='Editor, editor2']")
	private WebElement iframe_cvs;

	@FindBy(css = "body[aria-label='Editor, editor2']")
	private WebElement cvsText;

	@FindBy(css = "iframe[title='Editor, editor3']")
	private WebElement iframe_Rs;

	@FindBy(css = "body[aria-label='Editor, editor3']")
	private WebElement rsText;

	@FindBy(xpath = "body[aria-label='Editor, editor4']")
	private WebElement perAbdomenText;

	@FindBy(css = "iframe[title='Editor, editor4']")
	private WebElement iframe_PerAbdomen;

	@FindBy(xpath = "body[aria-label='Editor, editor5']")
	private WebElement cnsText;

	@FindBy(xpath = "iframe[title='Editor, editor5']")
	private WebElement iframe_Cns;

	@FindBy(xpath = "//button[text()=' Next']")
	private WebElement nextBtn;

	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private WebElement remarksText;

	@FindBy(xpath = "//button[text()=' Lab Report View ']")
	private WebElement labReportViewBtn;

	@FindBy(css = "iframe[title='Editor, editor6']")
	private WebElement iframe_preAnasthesiaOrders;

	@FindBy(css = "body[aria-label='Editor, editor6']")
	private WebElement preAnesthesiaOredersText;

	@FindBy(xpath = "//button[text()=' Preview ']")
	private WebElement previewBtn;

	@FindBy(xpath = "//button[text()=' Fitness Review ']")
	private WebElement fitnessReviewBtn;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitBtn_preAnesthesiaCheckup;

	@FindBy(xpath = "//button[text()=' Fitness Review ']/..//button[text()=' Cancel']")
	private WebElement cancelBtn_preAnesthesiaCheckup;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement popupErrorMessage_mandatoryFields;

	@FindBy(xpath = "(//button[text()=' Submit '])[2]")
	private WebElement submitButton_Cancellation;

	@FindBys({ @FindBy(css = "body.cke_editable.cke_editable_themed") })
	private List<WebElement> otherNotesTextArea;

	/**
	 * 
	 * Business Logics
	 * 
	 * @throws Throwable
	 * 
	 */

	public void clickOnPacAnasthesiaConfirmation(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, pacAnaesthesiaConfirmationBtn);
	}

	public void hospitalNumber(String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void clickOnSearch(WebDriver driver) {
		searchBtn.click();
	}

	public void actionBtn_ReqTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		actiontn_ReqTable.click();
	}

	public void rescheduleActionBtn_ReqTable(WebDriver driver) {
		reschedule_ReqTable.click();
	}

	public void confirmationActionBtn_ReqTable(WebDriver driver) {
		scrollDownByUsingJavascriptExecuter(driver);
		confirm_ReqTable.click();
	}

	public void cancelActionBtn_ReqTable(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, cancel_ReqTable);
		cancel_ReqTable.click();
	}

	public void viewActionsBtn_ReqTable(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, cancel_ReqTable);
		viewAction_ReqTable.click();
	}

	public void reasonForRescheduleText(String reasonForReschedule) {
		reasonForRescheduleText.sendKeys(reasonForReschedule);
	}

	public String takeHospitalNumber_ReqTable(WebDriver driver) {
		String hospitalNumber = hospitalNumber_ReqTable.getText();
		return hospitalNumber;
	}

	public String takeIpNumber_RequTable(WebDriver driver) {
		String ipNumber = ipNumber_ReqTable.getText();
		return ipNumber;
	}

	public String takeDepartmentName_ReqTable(WebDriver driver) {
		String dep = department_ReqTable.getText();
		String departmentName = remove_SpecialCharacters_And_Numbers_Speces(dep, 0);
		return departmentName;
	}

	public String takeStatus_ReqTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String status = status_ReqTable.getText();
		return status;
	}

	public String takeHospitalNumber_ReviewTable(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String hospitalNumber = hospitalNumber_ReviewTable.getText();
		return hospitalNumber;
	}

	public String takeIpNumber_ReviewTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = ipNumber_ReviewTable.getText();
		return ipNumber;
	}

	public String departmentName_ReviewTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = department_ReviewTable.getText();
		return department;
	}

	public void reviewCount_RevewTable(WebDriver driver) {

	}

	public void submitBtnReschedule(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, submit_Reschedule);
		submit_Reschedule.click();
	}

	public void clickOnOkSuccessMessage(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, okSuccesssfullMessage);
		okSuccesssfullMessage.click();
	}

	public void reasonForReschedule(String reasonForResch) {
		reasonForRescheduleText.sendKeys(reasonForResch);
	}

	public String errorMessage_MandatoryField(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String errorMsg = popupErrorMessage_mandatoryFields.getText();
		clickOnTheElementUsedToJavascriptExecuter(driver, popupErrorMessage_mandatoryFields);
		return errorMsg;
	}

	public void vitalSign(WebDriver driver, String asaClass, String text, String language, String electiveEmergency)
			throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, asaClassDropdownBtn);
		dropdown_Handling(driver, 6, asaClassDropdownBtn, dropdownText, asaClass);
		weightText.sendKeys(text);
		heightText.sendKeys(text);
		bloodPressureText.sendKeys(text);
		hrMinText.sendKeys(text);
		spo2Text.sendKeys(text);
		rrMinText.sendKeys(text);
		languageText.sendKeys(language);
		electiveEmergencyDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, electiveEmergency);

	}

	public void pastMedicalHisstory(WebDriver driver, String disease, String medication) {

		for (int i = 0; i <= 5; i++) {
			DiseaseText.sendKeys(disease);
			MedicationsText.sendKeys(medication);
			scrollDownThePageUntilElementIsVisible(driver, actionBtnPastMedicalHistory);
			actionBtnPastMedicalHistory.click();
		}
	}

	public void admissionDetailsProcess(String admissionDetails) {
		lmpText.sendKeys(admissionDetails);
		ocpText.sendKeys(admissionDetails);
		prosthesesText.sendKeys(admissionDetails);
		anticoagulantsText.sendKeys(admissionDetails);
		vysyaBtn.click();
	}

	public void enterTextInHistoryOfPresentIllness(WebDriver driver, String history) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		Thread.sleep(2000);
		WebElement iframe = iframe_historyOfIllnessTab;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		List<WebElement> list = otherNotesTextArea;
		for (WebElement webElement : list) {
			webElement.sendKeys();
		}
		driver.switchTo().defaultContent();
	}

	public void clickOnNextButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		nextBtn.click();
	}

	public void enterCVS(WebDriver driver, String cvs) {
		WebElement iframe = iframe_cvs;
		driver.switchTo().frame(iframe);
		cvsText.sendKeys(cvs);
		driver.switchTo().defaultContent();
	}

	public void enterRS(WebDriver driver, String rs) {
		WebElement iframe = iframe_Rs;
		driver.switchTo().frame(iframe);
		rsText.sendKeys(rs);
		driver.switchTo().defaultContent();
	}

	public void enterThePerAbdomen(WebDriver driver, String perAbdomen) {
		WebElement iframe = iframe_PerAbdomen;
		driver.switchTo().frame(iframe);
		perAbdomenText.sendKeys(perAbdomen);
		driver.switchTo().defaultContent();
	}

	public void enterTheCNS(WebDriver driver, String enterTheCNS) {
		WebElement iframe = iframe_Cns;
		driver.switchTo().frame(iframe);
		cnsText.sendKeys(enterTheCNS);
		driver.switchTo().defaultContent();
	}

	public void preAnesthesiaOrders(WebDriver driver, String preAnesthesiaOreders) {
		scrollDownTheStillEndOfThePage(driver);
		WebElement iframe = iframe_preAnasthesiaOrders;
		driver.switchTo().frame(iframe);
		preAnesthesiaOredersText.sendKeys(preAnesthesiaOreders);
		driver.switchTo().defaultContent();
	}

	public void examination(String text) {
		pallorText.sendKeys(text);
		icterusText.sendKeys(text);
		cyanosisText.sendKeys(text);
		koilonychiaText.sendKeys(text);
		lymphadenopathyText.sendKeys(text);
		oedemaText.sendKeys(text);
	}

	public void airwayExamination(String text) {
		neckExtensionText.sendKeys(text);
		neckFlexionText.sendKeys(text);
		looseToothText.sendKeys(text);
		mpText.sendKeys(text);
		tmdText.sendKeys(text);
		tmjText.sendKeys(text);
		moText.sendKeys(text);
		ivAccessText.sendKeys(text);
		spineText.sendKeys(text);
	}

	public void enterRemarks(String remarks) {
		remarksText.sendKeys(remarks);
	}

	public void clickOnPreviewButton(WebDriver driver) {
		previewBtn.click();
	}

	public void clickOnFitnessReviewButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		fitnessReviewBtn.click();
	}

	public void clickOnSubmit(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, cancel_ReqTable);
		submitBtn.click();
	}

	public void clickOnCancel(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, cancel_ReqTable);
		cancelBtn_preAnesthesiaCheckup.click();
	}

	public void clickOnClear(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, cancel_ReqTable);
		clearBtn.click();
	}

	public void rescheduleProcess(WebDriver driver, String hospitalNumber, String reasonForReschedule)
			throws Throwable {
		hospitalNumber(hospitalNumber);
		clickOnSearch(driver);

		actionBtn_ReqTable(driver);

		rescheduleActionBtn_ReqTable(driver);

		Thread.sleep(1000);
		reasonForRescheduleText(reasonForReschedule);

		Thread.sleep(1000);
		submitBtnReschedule(driver);

		clickOnOkSuccessMessage(driver);

		Thread.sleep(1000);
	}

	public void enterReasonForCancellation(WebDriver driver, String reason) {
		reasonForCancellation.sendKeys(reason);
	}

	public void clickOnSubmit_Cancellation(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, submitButton_Cancellation);
		submitButton_Cancellation.click();
	}

	public void scheduleCancelProcess(WebDriver driver, String hospitalNumber, String reason) throws Throwable {
		hospitalNumber(hospitalNumber);
		clickOnSearch(driver);
		actionBtn_ReqTable(driver);
		cancelActionBtn_ReqTable(driver);
		enterReasonForCancellation(driver, reason);
		Thread.sleep(1000);
		clickOnSubmit_Cancellation(driver);
		clickOnOkSuccessMessage(driver);
		Thread.sleep(1000);
	}

	public void clickOnReviewListTab(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, cancel_ReqTable);
		reviewTab.click();
	}

	public void enter_IpNumber_Filter(WebDriver driver, String ipNumber) {
		ipNumberText.sendKeys(ipNumber);
	}

	public void select_DepartmentName_Filter(WebDriver driver, String department) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, departmentNameDropdownBtn, dropdownText, department);
	}

	public String capture_DepartmentName_FitnessReviewList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String dep = department_ReviewTable.getText();
		String departmentName = removeSpecialCharactersAndNumbers_RemoveLastCharacters(dep, 0);
		return departmentName;
	}
}
