package com.Dalvkot.Vims_ObjectRepositary;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class BedMasterPage extends WebDriverUtility {
	public BedMasterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Appointment link
	@FindBy(xpath = "//span[text()=' Bed master ']")
	private WebElement bedMatserBtn;

	@FindBy(xpath = "//span[@title='Select Bed Category']/following-sibling::span")
	private WebElement bedCategoryDropdownBtn;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownsText;

	@FindBy(xpath = "//span[@title='Select Floor Type']/following-sibling::span")
	private WebElement floorDropdownBtn;

	@FindBy(xpath = "//span[@title='Select Wing Type']/following-sibling::span")
	private WebElement wingsDropdownBtn;

	@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span")
	private WebElement wardTypeDropdownBtn;

	@FindBy(xpath = "//span[@title='Select Room Type']/following-sibling::span")
	private WebElement roomTyperopdownBtn;

	@FindBy(xpath = "//input[@placeholder='Room Number']")
	private WebElement roomNumberText;
	@FindBy(xpath = "//input[@placeholder='Bed Number']")
	private WebElement bedNumberText;

	@FindAll({ @FindBy(css = "span.switchs-handle"),
			@FindBy(xpath = "//span[@data-off='No']/following-sibling::span[1]") })
	private WebElement activeStatusbtn;

	@FindBy(xpath = "//span[@title='Available']/following-sibling::span")
	private WebElement bedStatusDropdownBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]//span[@role='presentation']")
	private WebElement firstbedStatusDropdownBtn;

	@FindAll({ @FindBy(xpath = "//table/tbody/tr[1]/td[7]/descendant::button"),
			@FindBy(xpath = "(//button[@type='button'])[2]") })
	private WebElement actionBtnInTheTable;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[7]/descendant::button//i[@class='zmdi zmdi-delete']")
	private WebElement deleteLastOneInTheTable;

	@FindBy(xpath = "//button[normalize-space(text())='Submit']")
	private WebElement submitBtn;

	@FindBy(css = "div[aria-label='Please Enter Room Number']")
	private WebElement pleaseEnterRoomNumberPopUp;

	@FindBy(css = "div[aria-label='Please Enter Bed Number']")
	private WebElement pleaseEnterBedNumberPopup;

	@FindBy(css = "div[aria-label='Please Select Bed Status']")
	private WebElement pleaseSelectBedStatusPopup;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement combinationAlreadyExistsOkBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement successfullOkBtn;

	@FindBy(xpath = "//span[@title='Select Department Type']/following-sibling::span")
	private WebElement departmentDropdownBtnForVims;

	@FindBy(xpath = "//span[@title='Unit']/following-sibling::span[1]")
	private WebElement departmenUnittDropdownBtnForVims;

	/**
	 * 
	 * Business Logics
	 * 
	 * 
	 */

	public void clickOnTheBedMasterButton(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, bedMatserBtn);
	}

	public void enterTheRoomNumber(String roomNumber) {
		roomNumberText.sendKeys(roomNumber);
	}

	public void enterTheBedNumber(String bedNumber) {
		String bednumberh = generatingNumber();
		bedNumberText.sendKeys(bedNumber + bednumberh);
	}

	public void enterBedNumberOnly(String bedNumber) {
		bedNumberText.sendKeys(bedNumber);
	}

	public void clickOnTheActionButton() {
		actionBtnInTheTable.click();
	}

	public String clickOnThePlaeseEnterRoomNumber_Msg(WebDriver driver) throws Throwable {
		moveToTheParticularElementAndClick(driver, pleaseEnterRoomNumberPopUp);
		String roomNumberErrorMsg = pleaseEnterRoomNumberPopUp.getText();
		Thread.sleep(1000);
		return roomNumberErrorMsg;
	}

	public String clickOnThePleaseEnterTheBedNumber_Msg(WebDriver driver) {
		moveToTheParticularElementAndClick(driver, pleaseEnterBedNumberPopup);
		String bedNumberErrorMsg = pleaseEnterBedNumberPopup.getText();
		return bedNumberErrorMsg;

	}

	public String clickOnThePleaseSelectTheBedStatus_Msg(WebDriver driver) throws Throwable {
		moveToTheParticularElementAndClick(driver, pleaseSelectBedStatusPopup);
		String bedStatusErrorMsg = pleaseSelectBedStatusPopup.getText();
		pleaseSelectBedStatusPopup.click();
		Thread.sleep(1500);
		return bedStatusErrorMsg;
	}

	public void clickOnTheCombinationAlreadyExistOkBtn(WebDriver driver) {
		moveToTheParticularElementAndClick(driver, combinationAlreadyExistsOkBtn);

	}

	public void clickOnTheLastRowBed(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		moveToTheParticularElementAndClick(driver, deleteLastOneInTheTable);
		deleteLastOneInTheTable.click();
	}

	public void clickOnTheSuccessfullyOkButton() {
		successfullOkBtn.click();
	}

	public String bedMasterForVims(WebDriver driver, String bedCategory, String bedWardType, String bedRoomType,
			String floor, String wings, String bedDepartment, String bedUnitDepartment) throws Throwable {
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, bedMatserBtn);

		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, bedCategoryDropdownBtn, dropdownsText, bedCategory);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedWardType);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		roomTyperopdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedRoomType);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		floorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, floor);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		;
		wingsDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wings);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		departmentDropdownBtnForVims.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedDepartment);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		departmenUnittDropdownBtnForVims.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedUnitDepartment);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(4000);
		roomNumberText.sendKeys("12");

		String bednumberh = generate_RandomNumbers();
		bedNumberText.sendKeys(bednumberh);

		Thread.sleep(1000);
		actionBtnInTheTable.click();

		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownTheStillEndOfThePage(driver);
		submitBtn.click();

		Thread.sleep(1000);
		invisibiltyOf_Element_ThreeDots(driver);
		successfullOkBtn.click();

		return bednumberh;

	}

	public void bedMasterForDeluxe(WebDriver driver, String bedCategory, String bedWardType, String bedRoomType,
			String floor, String wings) throws Throwable {
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, bedMatserBtn);

		bedCategoryDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedCategory);

		explictWaitForElementToBeVisible(driver, wardTypeDropdownBtn);
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedWardType);

		Thread.sleep(2000);
		roomTyperopdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedRoomType);

		explictWaitForElementToBeVisible(driver, floorDropdownBtn);
		floorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, floor);

		explictWaitForElementToBeVisible(driver, wingsDropdownBtn);
		wingsDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wings);

		for (int i = 0; i <= 50; i++) {
			roomNumberText.sendKeys("12");

			Random random1 = new Random();
			int bednumber = random1.nextInt(20000);
			String bednumberh = String.valueOf(bednumber);
			bedNumberText.sendKeys(bednumberh);

			explictWaitForElementToBeVisible(driver, firstbedStatusDropdownBtn);
			firstbedStatusDropdownBtn.click();
			moveToElementAndEnterTheData(driver, dropdownsText, "AVAILABLE");

			explictWaitForElementToBeVisible(driver, actionBtnInTheTable);
			actionBtnInTheTable.click();

		}

		scrollDownTheStillEndOfThePage(driver);

		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, submitBtn);
		scrollTillVisibleElement(driver, submitBtn);
		scrollDownTheStillEndOfThePage(driver, submitBtn);
		scrollTillVisibleElement(driver, submitBtn);

		submitBtn.click();
		successfullOkBtn.click();
	}

	public String bedMasterFor_WithoutDepartment_And_Unit(WebDriver driver, String bedCategory, String bedWardType,
			String bedRoomType, String floor, String wings) throws Throwable {
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, bedMatserBtn);

		invisibiltyOf_Element_ThreeDots(driver);
		dropdown_Handling(driver, 5, bedCategoryDropdownBtn, dropdownsText, bedCategory);

		invisibiltyOf_Element_ThreeDots(driver);
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedWardType);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		roomTyperopdownBtn.click();

		Actions act = new Actions(driver);
		act.moveToElement(dropdownsText).sendKeys(bedRoomType, Keys.ENTER).build().perform();

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		floorDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, floor);

		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		wingsDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wings);

		roomNumberText.sendKeys("12");

		long numberOfRandomNumbers = 3; // Change this to the number of random numbers you want
		Set<Integer> uniqueRandomNumbers = new HashSet<>();
		Random random = new Random();
		String randomNumberStr = "";
		while (uniqueRandomNumbers.size() < numberOfRandomNumbers) {
			int randomNumber = random.nextInt(20000786);
			uniqueRandomNumbers.add(randomNumber);
		}
		for (int randomNumber : uniqueRandomNumbers) {
			randomNumberStr = String.valueOf(randomNumber);
		}

		bedNumberText.sendKeys(randomNumberStr);

		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, activeStatusbtn);
		scrollDownByUsingJavascriptExecuter(driver);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, actionBtnInTheTable);

		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		Thread.sleep(1000);
		scrollDownTheStillEndOfThePage(driver);
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, submitBtn);
		scrollTillVisibleElement(driver, submitBtn);
		scrollDownTheStillEndOfThePage(driver, submitBtn);
		scrollTillVisibleElement(driver, submitBtn);
		Thread.sleep(1000);
		submitBtn.click();
		successfullOkBtn.click();
		return randomNumberStr;

	}

	public void selectBedCategoryDropdown(WebDriver driver, String bedCategory) {
		dropdown(driver, bedCategoryDropdownBtn, dropdownsText, bedCategory);
	}

	public void selectWardTypeDropdown(WebDriver driver, String wardType) {
		dropdown(driver, wardTypeDropdownBtn, dropdownsText, wardType);
	}

	public void selectRoomTypeDropdown(WebDriver driver, String roomType) throws Throwable {
		Thread.sleep(1000);
		dropdown(driver, roomTyperopdownBtn, dropdownsText, roomType);

	}

	public void selectFloorDropdown(WebDriver driver, String floor) {
		dropdown(driver, floorDropdownBtn, dropdownsText, floor);
	}

	public void selectWingsDropdown(WebDriver driver, String wings) {

		dropdown(driver, wingsDropdownBtn, dropdownsText, wings);
	}

	public void selectDepartmentDropdown(WebDriver driver, String department) {
		dropdown(driver, departmentDropdownBtnForVims, dropdownsText, department);
	}

	public void selectDepartmentUnit(WebDriver driver, String unit) {

		dropdown(driver, departmenUnittDropdownBtnForVims, dropdownsText, unit);
	}

	public void selectBedStatusDropdown(WebDriver driver, String bedStatus) {

		dropdown(driver, bedStatusDropdownBtn, dropdownsText, bedStatus);
	}

	public void changeActiveStatus(WebDriver driver) {

		activeStatusbtn.click();
	}

	public void clickOnTheSubmitButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		submitBtn.click();
	}

}
