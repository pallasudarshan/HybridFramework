package com.Dalvkot.Vims_ObjectRepositary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class IcdEntryPage extends WebDriverUtility {

	public IcdEntryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' ICD Entry ']")
	private WebElement icdEntry;

	@FindBy(xpath = "//span[@title='OP']/following-sibling::span[1]")
	private WebElement patientTypeDropDownBtn;

	@FindBy(xpath = "//span[@title='Department']/following-sibling::span[1]")
	private WebElement departmentDropDownBtn;

	@FindBy(xpath = "//span[@title='Unit']/following-sibling::span[1]")
	private WebElement unitDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='Hospital No']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//span[@title='Select Category Type']/following-sibling::span[1]")
	private WebElement categoryTypeDropDownBytn;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[contains(text(),'Pending List')]")
	private WebElement pendingListTab;

	@FindBy(xpath = "//a[contains(text(),'Completed List')]")
	private WebElement completedListTab;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[2]")
	private WebElement hospitalNumber_Table_PendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[3]")
	private WebElement opNumber_Table_PendingLink;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[4]")
	private WebElement pentientName_Table_PendingLink;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[5]")
	private WebElement DepartmentAndUnit_Table_PendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[6]")
	private WebElement visitNumber_Table_PendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[7]")
	private WebElement DoctorName_Table_PendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[8]")
	private WebElement registrationDate_Table_PendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[9]//button")
	private WebElement addDiagnosisBtn_Table_PendingList;

	@FindBy(xpath = "(//a[@aria-label='Next page'])[1]")
	private WebElement nextPageBtn;

	@FindBy(xpath = "(//a[@aria-label='Previous page'])[1]")
	private WebElement previousPageBtn;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[2]")
	private WebElement hospitalNumber_Table_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[3]")
	private WebElement opNumber_Table_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[4]")
	private WebElement patientNamr_Table_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[5]")
	private WebElement departmentAndUnit_Table_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[6]")
	private WebElement doctorName_Table_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[7]")
	private WebElement registrationDate_Table_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[8]//button")
	private WebElement viewButton_Table_CompetedList;

	@FindBy(xpath = "//div[@id='DiagnosisModal']//table//tr[1]/td[2]//span[@role='presentation']")
	private WebElement icdCodeDropDownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "//div[@id='DiagnosisModal']//table//tr[1]/td//input[@name='dropdownTable']")
	private WebElement codeDescriptionText;

	@FindBy(xpath = "//div[@id='DiagnosisModal']//table/tbody/tr[1]/td[last()]//button[@type='button']//i")
	private WebElement plusBtn_Table_AddDiagnosisPopup;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitBtn;

	@FindBy(xpath = "(//button[@type='cancel'])[1]")
	private WebElement cancelBtn_AddDiagnosisPopup;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement popUpText_OkBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-danger')])[2]")
	private WebElement deleteBtn_Table_ViewPopUp;

	@FindBy(xpath = "(//button[@type='cancel'])[2]")
	private WebElement cancelBtn_ViewPopUp;

	@FindBy(xpath = "//table[@class='table row-border dropdown_table ng-star-inserted']/tbody/tr[1]")
	private WebElement suggestion_firstRow;

	@FindBys({ @FindBy(xpath = "//div[@id='pending']//table/tbody/tr/td[1]") })
	private List<WebElement> listOfSlNo_PendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[1]")
	private WebElement slNo_PendingList_FirstRow;

	@FindBys({ @FindBy(xpath = "//div[@id='completed']//table/tbody/tr/td[1]") })
	private List<WebElement> listOfSlNo_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[1]/td[1]")
	private WebElement slNo_CompletedList_FirstRow;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[last()]/td[5]")
	private WebElement DepartmentAndUnit_LastRow_Table_PendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[last()]/td[2]")
	private WebElement hospitalNumber_LastRow_Table_PendingList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[last()]/td[5]")
	private WebElement departmentAndUnit_LastRow_Table_CompletedList;

	@FindBy(xpath = "//div[@id='completed']//table/tbody/tr[last()]/td[2]")
	private WebElement hospitalNumber_LastRow_Table_CompletedList;

	@FindBys({ @FindBy(xpath = "//table[contains(@class,'table table-bordered')]/tbody[1]/tr/td[3]/div[1]") })
	private List<WebElement> listOfCodeDescription_View_CompletedList;

	@FindBy(xpath = "(//button[@type='cancel'])[2]")
	private WebElement cancelBtn_view_CompletedList;

	// ------------------------Logics------------------------

	public void clickOnIcdEntryScreenBtn(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, icdEntry);
	}

	public void selectPatientType(WebDriver driver, String patientType) {
		dropdown(driver, patientTypeDropDownBtn, dropDownText, patientType);
	}

	public void selectDepartment(WebDriver driver, String department) {
		dropdown(driver, departmentDropDownBtn, dropDownText, department);
	}

	public void selectUnit(WebDriver driver, String unit) {
		dropdown(driver, unitDropDownBtn, dropDownText, unit);
	}

	public void selectCategoryType(WebDriver driver, String categoryType) {
		dropdown(driver, categoryTypeDropDownBytn, dropDownText, categoryType);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void clickOnSearch(WebDriver driver) {
		searchBtn.click();
	}

	public void clickOnClear(WebDriver driver) {
		clearBtn.click();
	}

	public void clickOnAddDiagnosis_Table(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, addDiagnosisBtn_Table_PendingList);
		addDiagnosisBtn_Table_PendingList.click();
	}

	public void selectIcdCode(WebDriver driver, String icdCode) {
		dropdown(driver, icdCodeDropDownBtn, dropDownText, icdCode);
	}

	public void enterCodeDescription(WebDriver driver, String description) {
		codeDescriptionText.sendKeys(description);
		suggestion_firstRow.click();
	}

	public void clickOnPlusBtn_AddDiagnosis_Table(WebDriver driver) {
		plusBtn_Table_AddDiagnosisPopup.click();
	}

	public void clickOnSubmit(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
	}

	public String captureTextAndClickOnOkbtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = popUpText_OkBtn.getText();
		okBtn.click();
		return text;
	}

	public void clickOnPendingListTab(WebDriver driver) {
		pendingListTab.click();
	}

	public void clickOnCompletedListTab(WebDriver driver) {
		completedListTab.click();
	}

	public void verifyNextBtnIsWorkingAsExpected_PendingList(WebDriver driver) throws Throwable {
		for (int i = 1; i <= 2; i++) {
			WebElement lastSlNo = listOfSlNo_PendingList.get(listOfSlNo_PendingList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls) + 1;
			scrollDownTheStillEndOfThePage(driver);
			nextPageBtn.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			String ls1 = slNo_PendingList_FirstRow.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(l, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpected_PendingList(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 1; i++) {
			nextPageBtn.click();
		}
		for (int i = 1; i <= 1; i++) {
			String ls1 = slNo_PendingList_FirstRow.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			previousPageBtn.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			WebElement lastSlNo = listOfSlNo_PendingList.get(listOfSlNo_PendingList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public void addDiagnosis(WebDriver driver, String icdCode, String codeDescription) {
		selectIcdCode(driver, icdCode);
		enterCodeDescription(driver, codeDescription);
		clickOnPlusBtn_AddDiagnosis_Table(driver);
	}

	public String captureHospitalNumber_Table_PendingList(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, hospitalNumber_Table_PendingList);
		String hospitalNumber = hospitalNumber_Table_PendingList.getText();
		return hospitalNumber;
	}

	public String captureHospitalNumber_Table_CompletedList(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, hospitalNumber_Table_CompletedList);
		String hospitalNumber = hospitalNumber_Table_CompletedList.getText();
		return hospitalNumber;
	}

	public void verifyNextBtnIsWorkingAsExpected_CompletedList(WebDriver driver) throws Throwable {
		for (int i = 1; i <= 3; i++) {
			WebElement lastSlNo = listOfSlNo_CompletedList.get(listOfSlNo_CompletedList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls) + 1;
			scrollDownTheStillEndOfThePage(driver);
			nextPageBtn.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			String ls1 = slNo_CompletedList_FirstRow.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(l, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpected_CompletedList(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 3; i++) {
			nextPageBtn.click();
		}
		for (int i = 1; i <= 3; i++) {
			String ls1 = slNo_CompletedList_FirstRow.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			previousPageBtn.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			WebElement lastSlNo = listOfSlNo_CompletedList.get(listOfSlNo_CompletedList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public String captureLastRowDepartment_Table_PendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String dep = DepartmentAndUnit_LastRow_Table_PendingList.getText();
		String dep1 = dep.substring(0, dep.length() - 4);
		return dep1;
	}

	public String captureLastRowDepartment_Table_CompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String dep = departmentAndUnit_LastRow_Table_CompletedList.getText();
		String dep1 = dep.substring(0, dep.length() - 4);
		return dep1;
	}

	public String captureLastRowHospitalNumber_Table_PendingList(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, hospitalNumber_LastRow_Table_PendingList);
		String hp = hospitalNumber_LastRow_Table_PendingList.getText();
		return hp;
	}

	public String captureLastRowHospitalNumber_Table_CompletedList(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, hospitalNumber_LastRow_Table_CompletedList);
		String hp = hospitalNumber_LastRow_Table_CompletedList.getText();
		return hp;
	}

	public void clickOnView_CompletedList(WebDriver driver) {
		viewButton_Table_CompetedList.click();
	}

	public List<String> captureCodeDescription_View_CompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		List<String> cd = new ArrayList<>();
		for (WebElement element : listOfCodeDescription_View_CompletedList) {
			String text = element.getText();
			cd.add(text);
		}
		System.out.println(cd);
		return cd;
	}

	public void clickOnCancel_View_completedList(WebDriver driver) {
		cancelBtn_view_CompletedList.click();
	}
}
