package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class NursingDesk_WardServicesPage extends WebDriverUtility {

	public NursingDesk_WardServicesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Nursing Desk ']")
	private WebElement nursingDeshBtn;

	@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span")
	private WebElement wardTypeDropdownBtn_Filter;

	@FindBy(xpath = "//span[@title='Select Room Type']/following-sibling::span")
	private WebElement roomTypeDropdownBtn_Filter;

	@FindBy(xpath = "//span[@title='Department']/following-sibling::span")
	private WebElement departmentDropdownBtn_Filter;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText_Filter;

	@FindBy(xpath = "//span[@title='Status']/following-sibling::span[1]")
	private WebElement statusDropdownBtns_Filter;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn_Filter;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement cancelBtn_Filter;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[3]/td[2]/descendant::a")
	private WebElement hospitalNumber3rdRow_Table;

	@FindBy(xpath = "//table//tr[last()]/td[2]/descendant::a")
	private WebElement lastRow_HospitalNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[3]/td[4]")
	private WebElement ipNumber_Table;

	@FindBy(xpath = "//table//tr[1]/td[5]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table//tr[1]/td[6]")
	private WebElement gender_Table;

	@FindBy(xpath = "//table//tr[1]/td[7]")
	private WebElement wardType_Table;

	@FindBys({ @FindBy(xpath = "//table//tbody//tr/td[7]") })
	private List<WebElement> wardType_List_Table;

	@FindBy(xpath = "//table//tr[1]/td[8]")
	private WebElement roomType_Table;

	@FindBys({ @FindBy(xpath = "//table//tr/td[8]") })
	private List<WebElement> roomType_List_Table;

	@FindBys({ @FindBy(xpath = "//table//tr/td[9]") })
	private List<WebElement> department_List_Table;

	@FindBys({ @FindBy(xpath = "//table//tr/td[12]") })
	private List<WebElement> Status_List_Table;

	@FindBy(xpath = "//table//tr[1]/td[9]")
	private WebElement department_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[10]")
	private WebElement dateOfAdmission_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[11]")
	private WebElement visitNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[12]")
	private WebElement status_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[13]")
	private WebElement newStatus_Table;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownsText;

	@FindBy(xpath = "//li//a[@aria-label='Next page']")
	private WebElement nextButton;

	@FindBys({ @FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr/th[2]//input") })
	private List<WebElement> listOfCheckBox_LinesAndtubes;

	@FindBys({ @FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr/th[3]//input") })
	private List<WebElement> listOfTextField_LinesAndtubes;

	// Buiness Logics
	public void clickOnTheNursingDeskButton(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, nursingDeshBtn);
	}

	public void selectWardTypeDropdown(WebDriver driver, String wardName) throws Throwable {
		Thread.sleep(2000);
		wardTypeDropdownBtn_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wardName);
	}

	public void selectRoomTypeDropdown(WebDriver driver, String roomName) throws Throwable {
		roomTypeDropdownBtn_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownsText, roomName);
	}

	public void selcetDepartmentDropdown(WebDriver driver, String department) {
		departmentDropdownBtn_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownsText, department);
	}

	public void enterHospitalNumberInTheText(String hospitalNumber) {
		hospitalNumberText_Filter.sendKeys(hospitalNumber);
	}

	public String HospitalNumberGetText() throws Throwable {
		Thread.sleep(1000);
		String hospitalNumber = hospitalNumberText_Filter.getText();
		return hospitalNumber;
	}

	public void selectStatusDropdown(WebDriver driver, String status) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		statusDropdownBtns_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownsText, status);
	}

	public void clickOnTheSearchButton(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn_Filter.click();
		Thread.sleep(1000);
	}

	public void clickOnTheCancelButton(WebDriver driver) {
		cancelBtn_Filter.click();
	}

	public String take_HosptalNumberInThe_Table(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String hospitalNumber = hospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String take_LastRowHospitalNumber_Table(WebDriver driver) {
		String hospitalNumber = lastRow_HospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String ipNumberInThe_Table(WebDriver driver) {
		String ipNumber = ipNumber_Table.getText();
		return ipNumber;
	}

	public String patientNameInThe_Table(WebDriver driver) {
		String patientName = patientName_Table.getText();
		return patientName;
	}

	public String genderInThe_Table(WebDriver driver) {
		String gender = gender_Table.getText();
		return gender;
	}

	public String wardTypeInThe_Table(WebDriver driver) throws Throwable {
		String ward = wardType_Table.getText();
		return ward;
	}

	public String roomTypeInThe_Table(WebDriver driver) {
		String room = roomType_Table.getText();
		return room;
	}

	public String departmentInThe_Table(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String department = department_Table.getText();
		return department;
	}

	public String dateOfAdmissionInThe_Table(WebDriver driver) {
		String dateOfAdmission = dateOfAdmission_Table.getText();
		return dateOfAdmission;
	}

	public String visitNumberInThe_Table(WebDriver driver) {
		String visitNumber = visitNumber_Table.getText();
		return visitNumber;
	}

	public String statusInThe_Table(WebDriver driver) {
		String status = status_Table.getTagName();
		return status;
	}

	public void wardType_List_InTheTable(WebDriver driver, String ward) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		for (WebElement Element : wardType_List_Table) {
			Thread.sleep(2000);
			String ward1 = Element.getText();
			Assert.assertEquals(ward1, ward);
		}
	}

	public void roomType_List_InThe_Table(WebDriver driver, String room) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		for (WebElement webElement : roomType_List_Table) {
			String room1 = webElement.getText();
			Assert.assertEquals(room1, room);
		}

	}

	public void take_Department_InTheTable(WebDriver driver, String department) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		for (WebElement webElement : department_List_Table) {
			String depar = webElement.getText();
			String department1 = removeSpecialCharactersAndNumbers_RemoveLastCharacters(depar, 3);
			Assert.assertEquals(department1, department);
		}
	}

	public void take_Status_InTheTable(WebDriver driver, String status) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		for (WebElement webElement : Status_List_Table) {
			String depar = webElement.getText();
			String status1 = removeSpecialCharactersAndNumbers_RemoveLastCharacters(depar, 1);
			Assert.assertEquals(status1, status);
		}
	}

	public void clickOnListOfCheckBox_LinesAndTubes(WebDriver driver) {

	}

	public void clickOnHospitalNumberInTheTable(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		hospitalNumber_Table.click();
	}
}
