package com.Dalvkot.Vims_ObjectRepositary;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ClearanceScreenPage extends WebDriverUtility {

	public ClearanceScreenPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Clearance Screen ']")
	private WebElement clearanceBtn;

	@FindBy(xpath = "//label[text()='Clearance From']/..//span[@role='presentation']")
	private WebElement clearenceFromDropdownBtn;

	@FindBys({ @FindBy(xpath = "//li[@role='option']") })
	private List<WebElement> list_Of_Optins;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText;

	@FindBy(id = "emergency")
	private WebElement dischargeIntimationListCheckBoxBtn;

	@FindBy(xpath = "//button[text()=' Search']//i")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//table//tr[1]/td[2]//a")
	private WebElement hospitalNumber_PatientListTable;

	@FindBy(xpath = "//table//tr[last()]/td[2]//a")
	private WebElement hospitalNumber_Last_PatientListTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[10]/descendant::a[@class='badge badge-success']")
	private WebElement dischargeIntimationStatus_PatientListTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[11]/descendant::a[@class='badge badge-success']")
	private WebElement clearanceStatus_PatientListTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[12]/descendant::a[@class='badge badge-success']")
	private WebElement dischargeConfirmationStatus_PatientListTable;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[text()=' Save']//i")
	private WebElement saveBtn_Popup;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okPopup_Btn;

	@FindBy(xpath = "//button[text()=' Save']/following-sibling::button")
	private WebElement cancelBtn;

	@FindBy(xpath = "(//div[contains(@class,'form-group col-lg-6')]//label)[2]")
	private WebElement hospitalNumber_Popup;

	@FindBy(xpath = "((//div[contains(@class,'form-group col-lg-6')]//label)[1]/ancestor::div[@class='modal-body']//div)[9]")
	private WebElement patientName_Popup;

	@FindBy(xpath = "(//div[contains(@class,'form-group col-lg-6')]//label)[4]")
	private WebElement ipNumber_Poup;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[3]")
	private WebElement patientName_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[4]")
	private WebElement ipNumber_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[5]")
	private WebElement wardName_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[6]")
	private WebElement bedNumber_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[7]")
	private WebElement doctorName_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[8]")
	private WebElement department_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[9]")
	private WebElement clearenceType_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[10]")
	private WebElement dischargeIntimationStatus_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[11]")
	private WebElement clearanceStatus_List;

	@FindBy(xpath = "//div[@class='card row']//tr[1]/td[12]")
	private WebElement discharge_ConfirmationStatus_List;

	@FindBy(xpath = "//div[@id='swal2-content']")
	private WebElement okPopups_Messages;

	/*
	 * 
	 * 
	 * Buiness Logics
	 * 
	 * 
	 */

	public void clickOn_ClearencePage(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, clearanceBtn);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void clickOn_SearchButton(WebDriver driver) {
		searchBtn.click();
	}

	public void select_ClearenceFrom(WebDriver driver, String clearence) {
		clearenceFromDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, clearence);
	}

	public void clickOn_HospitalNumber_Table(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		hospitalNumber_PatientListTable.click();
	}

	public void clickOn_SaveButtonOnThe_Popup(WebDriver driver) {
		saveBtn_Popup.click();
	}

	public void clickOn_OkPopup_Button(WebDriver driver) {
		okPopup_Btn.click();
	}

	public void clearence_Process(WebDriver driver, String hospitalNumber) throws Throwable {
	
		enterHospitalNumber(driver, hospitalNumber);
		clearenceFromDropdownBtn.click();
		Set<String> uniqueNames = extractUniqueNames(list_Of_Optins);
		clearenceFromDropdownBtn.click();
		for (String name : uniqueNames) {
			System.out.println(name);
			// invisibiltyOf_Element_ThreeDots(driver);
			select_ClearenceFrom(driver, name);
			clickOn_SearchButton(driver);
			clickOn_HospitalNumber_Table(driver);
			clickOn_SaveButtonOnThe_Popup(driver);
			clickOn_OkPopup_Button(driver);
		}
	}

	private Set<String> extractUniqueNames(List<WebElement> elements) {
		Set<String> uniqueNames = new HashSet<>();
		for (WebElement element : elements) {
			String name = element.getText();
			uniqueNames.add(name);
		}
		return uniqueNames;
	}

	public String take_LastRowHospitalNumber(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_Last_PatientListTable.getText();
		return hospitalNumber;
	}

	public String capture_FirstRow_hospitalNumber(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_PatientListTable.getText();
		return hospitalNumber;
	}

	public String capture_HospitalNumber_Popup(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_Popup.getText();
		return hospitalNumber;
	}

	public String capture_PatientName_Popup(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientName = patientName_Popup.getText();
		return patientName;
	}

	public String capture_IpNumber_Popup(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String ipNumber = ipNumber_Poup.getText();
		return ipNumber;
	}

	public String capture_PatientName_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientName = patientName_List.getText();
		return patientName;
	}

	public String capture_IpNumber_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String ipNumber = ipNumber_List.getText();
		return ipNumber;
	}

	public String capture_WardName_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String ward = wardName_List.getText();
		return ward;
	}

	public String capture_BedNumber_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String bed = bedNumber_List.getText();
		return bed;
	}

	public String capture_DoctorName_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String doctor = doctorName_List.getText();
		return doctor;
	}

	public String capture_Department_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String dep = department_List.getText();
		return dep;
	}

	public String cpature_ClearanceType_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String clearenace = clearenceType_List.getText();
		return clearenace;
	}

	public String cpature_DischargeIntimationStatus_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String dis_Intimation = dischargeIntimationStatus_List.getText();
		return dis_Intimation;
	}

	public String capture_ClearanceStatus_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String clearance = clearanceStatus_List.getText();
		return clearance;
	}

	public String capture_DischargeIntimationStatus_List(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String discharge_Confirmation = dischargeIntimationStatus_List.getText();
		return discharge_Confirmation;
	}

	public String capture_OkPopups_Messages(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String msg = okPopups_Messages.getText();
		return msg;

	}

	public void select_DischargeIntimationListCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		dischargeIntimationListCheckBoxBtn.click();
	}
}
