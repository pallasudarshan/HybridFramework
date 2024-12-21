package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class IcuDaskPage extends WebDriverUtility {

	public IcuDaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// -----------------------X Paths-----------------------

	@FindBy(xpath = "//span[text()=' ICU Desk ']")
	private WebElement icuDeskBtn;

	@FindBy(xpath = "//input[@formcontrolname='hospitalnum1']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//input[@placeholder='IP Number']")
	private WebElement ipNumberText;

	@FindBy(xpath = "//input[@placeholder='Patient Name']")
	private WebElement patientNameText;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement phoneNumberText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]//a")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//a[contains(.,'Next page')]")
	private WebElement nextBtn;

	@FindBy(xpath = "//a[contains(.,'Previous page')]")
	private WebElement prevoisBtn;

	@FindBy(xpath = "//a[contains(.,'Back')]")
	private WebElement backBtn;

	@FindBy(xpath = "(//button[@data-dismiss='modal'])[3]")
	private WebElement plusBtn_ventilator;

	@FindBy(xpath = "(//button[@data-dismiss='modal'])[4]")
	private WebElement plusBtn_GrbsMonitoring;

	@FindBy(xpath = "(//button[@data-dismiss='modal'])[5]")
	private WebElement plusBtn_AbgMonitoring;

	@FindBy(xpath = "(//button[@data-dismiss='modal'])[6]")
	private WebElement plusBtn_NeuroMonitoring;

	@FindBy(xpath = "(//button[@data-dismiss='modal'])[7]")
	private WebElement plusBtn_LinesAndTubes;

	@FindBy(xpath = "(//button[@data-dismiss='modal'])[8]")
	private WebElement plusBtn_IntakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='effectiveT']")
	private WebElement chooseDateTime_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='SPO2']")
	private WebElement spo2Field_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='TV']")
	private WebElement tvField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@formcontrolname='RateValue']")
	private WebElement rateField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='FIO2']")
	private WebElement fio2Field_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='PR Support']")
	private WebElement prSupportField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='PEEP']")
	private WebElement peepField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='PC']")
	private WebElement pcField_ventilatorSetUpTab;

	@FindBy(xpath = "//input[@placeholder='Oxygen']")
	private WebElement oxygenField_ventilatorSetUpTab;

	@FindBy(xpath = "//input[@placeholder='T-Piece']")
	private WebElement tPieceField_ventilatorSetUpTab;

	@FindBy(xpath = "(//input[@id='linkToLabId']/following-sibling::span)[1]")
	private WebElement roomAirBtn_ventilatorSetup;

	@FindBy(xpath = "(//label[contains(@class,'switch switch-flat')]//span)[3]")
	private WebElement vomittingBtn_ventilatorSetup;

	@FindBy(xpath = "(//input[@id='linkToLabId']/following-sibling::span)[3]")
	private WebElement positioningBackCareBtn_ventilatorSetup;

	@FindBy(xpath = "(//span[@class='switch-label ng-tns-c243-2'])[4]")
	private WebElement bedBathBtn_ventilatorSetup;

	@FindBy(xpath = "(//span[@class='switch-label ng-tns-c243-2'])[5]")
	private WebElement oralCareBtn_ventilatorSetup;

	@FindBy(xpath = "(//span[@class='switch-label ng-tns-c243-2'])[6]")
	private WebElement chestPhysioBtn_ventilatorBtn;

	@FindBy(xpath = "(//span[@class='switch-label ng-tns-c243-2'])[7]")
	private WebElement stoolBtn_ventilatorBtn;

	@FindBy(xpath = "(//span[@class='switch-label ng-tns-c243-2'])[8]")
	private WebElement woundDressingBtn_ventilatorSetup;

	@FindBy(xpath = "//button[@id='closeVentilator']/following-sibling::button[1]")
	private WebElement cancelBtn_ventilatorSetup;

	@FindBy(xpath = "//button[@id='closeVentilator']")
	private WebElement submitBtn_ventilatorSetup;

	@FindBy(xpath = "(//input[@type='datetime-local'])[2]")
	private WebElement dateInTable_grbs;

	@FindBy(xpath = "(//div[@id='grbs']//table/tbody/tr[1]/td[3]//span[@class='select2-selection__arrow'])[1]")
	private WebElement typeDropDownBtn_grbs;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "(//div[@id='grbs']//table/tbody/tr[1]/td[4]//span[@class='select2-selection__arrow'])[1]")
	private WebElement collectedAtDropDownBtn_grbs;

	@FindBy(xpath = "//input[@placeholder='value']")
	private WebElement valueField_grbs;

	@FindBy(xpath = "//input[@placeholder='Enter Remarks']")
	private WebElement remarksField_grbs;

	@FindBy(xpath = "//div[@id='grbs']/descendant::table[@id='subtableid']/tbody/tr[1]/td[7]/descendant::button")
	private WebElement addBtnInTable_grbs;

	@FindBy(xpath = "//div[@id='grbs']//button[@type='submit']")
	private WebElement submitBtn_grbs;

	@FindBy(xpath = "//div[@id='grbs']//button[@type='reset']")
	private WebElement cancelBtn_grbs;

	@FindBy(xpath = "//div[@id='grbs']/descendant::table[@id='subtableid']/tbody/tr[2]/td[7]/descendant::button")
	private WebElement deleteBtnInTable_Grbs;

	@FindBy(xpath = "//input[@formcontrolname='abgsTime']")
	private WebElement chooseTime_abg;

	@FindBy(xpath = "//input[@formcontrolname='PH']")
	private WebElement phText_abg;

	@FindBy(xpath = "//input[@formcontrolname='PCO2']")
	private WebElement pco2Text_abg;

	@FindBy(xpath = "//label[text()='PO2']/following-sibling::input")
	private WebElement po2Text_abg;

	@FindBy(xpath = "//label[text()='SO2']/following-sibling::input")
	private WebElement so2Text_abg;

	@FindBy(xpath = "//label[text()='LAC']/following-sibling::input")
	private WebElement lacText_abg;

	@FindBy(xpath = "//label[text()='HCO2']/following-sibling::input")
	private WebElement hco2Text_abg;

	@FindBy(xpath = "(//button[text()='Submit'])[2]")
	private WebElement submitBtn_abg;

	@FindBy(xpath = "(//button[text()='Cancel'])[2]")
	private WebElement cancelBtn_abg;

	@FindBy(xpath = "//div[@title='Choose Time Fot Neuro Monitoring']//input[1]")
	private WebElement chooseTime_neuroMonitoring;

	@FindBy(xpath = "//label[text()='Size on right']/following-sibling::input")
	private WebElement sizeOnRightText;

	@FindBy(xpath = "//label[text()='Size on Left']/following-sibling::input")
	private WebElement sizeOnLeftText;

	@FindBy(xpath = "(//span[@class='switch-handle ng-tns-c243-0'])[9]")
	private WebElement reactionRightBtn;

	@FindBy(xpath = "(//span[@class='switch-handle ng-tns-c243-0'])[10]")
	private WebElement reactionLeftBtn;

	@FindBy(xpath = "(//input[@id='treatmentToOp'])[1]")
	private WebElement rightArmCheckBox;

	@FindBy(xpath = "(//input[@value='applicableToIP'])[2]")
	private WebElement leftArmCheckBox;

	@FindBy(xpath = "(//label[text()='Left arm ']/following::input)[1]")
	private WebElement rightLegCheckBox;

	@FindBy(xpath = "(//label[text()='Right leg ']/following::input)[1]")
	private WebElement leftLegCheckBox;

	@FindBy(xpath = "//button[@id='closeNeuro']")
	private WebElement submitBtn_neuroMonitoring;

	@FindBy(xpath = "//button[@id='closeNeuro']/following-sibling::button[1]")
	private WebElement cancelBtn_neuroMonitoring;

	@FindBys({ @FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr/th[2]//input") })
	private List<WebElement> listOfCheckBox_LinesAndtubes;

	@FindBys({ @FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr/th[3]//input") })
	private List<WebElement> listOfTextField_LinesAndtubes;

	@FindBy(xpath = "//button[@id='closeLines']")
	private WebElement submitBtn_linesAndTubesTab;

	@FindBy(xpath = "//button[@id='closeLines']/following-sibling::button[1]")
	private WebElement cancelBtn_linesAndTubesTab;

	@FindBy(xpath = "//input[@formcontrolname='IntakeTime']")
	private WebElement chooseTimeField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='fluid']")
	private WebElement fluidTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='RTF']")
	private WebElement rtfTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='oral']")
	private WebElement oralTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='fj']")
	private WebElement fjTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='ivfsolution']")
	private WebElement ivfSolutionTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='amountIntake']")
	private WebElement amountInTakeTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='urineOutput']")
	private WebElement urinOutputTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//span[@id='select2-i2a6-container']/following-sibling::span[1]")
	private WebElement drainDropDownBtn_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='icd']")
	private WebElement icdTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='amountoutput']")
	private WebElement amountOutputTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//button[@id='closeIntake']")
	private WebElement submitBtn_intakeAndOutputCharting;

	@FindBy(xpath = "//button[@id='closeIntake']/following-sibling::button[1]")
	private WebElement cancelBtn_intakeAndOutputCharting;

	@FindBy(xpath = "(//label[text()='Input Type']/following::input)[1]")
	private WebElement inputTypeText_intakeAndOutputCharting;

	@FindBy(xpath = "(//label[text()='Input']/following::input)[1]")
	private WebElement inputText_intakeAndOutputCharting;

	@FindBy(xpath = "(//label[text()='Output Type']/following::input)[1]")
	private WebElement outputTypeText_intakeAndOutputCharting;

	@FindBy(xpath = "(//label[text()='Output']/following::input)[1]")
	private WebElement outputText_intakeAndOutputCharting;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorPopUpMsg;

	@FindBy(xpath = "//input[@formcontrolname='drainValue']")
	private WebElement drainValueBtn_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='rtfOutput']")
	private WebElement rtaText;

	// --------------------------Logics---------------------------

	public void clickOnIcuDesk(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, icuDeskBtn);
		Thread.sleep(1000);
	}

	public void clickOnHospitalNumberInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		hospitalNumber_Table.click();
	}

	public void clickOnVentilatorPlusBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		plusBtn_ventilator.click();
	}

	public void clickOnGrbsMonitoringPlusBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		plusBtn_GrbsMonitoring.click();
	}

	public void clickOnAbgMonitoringPlusBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		plusBtn_AbgMonitoring.click();
	}

	public void clickOnNeuroMonitoringPlusBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		plusBtn_NeuroMonitoring.click();
	}

	public void clickOnLinesAndTubesPlusBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownTheStillEndOfThePage(driver);
		plusBtn_LinesAndTubes.click();
	}

	public void clickOnIntakeAndOutputChartingPlusBtn(WebDriver driver) {
		scrollToBottom(driver);
		plusBtn_IntakeAndOutputCharting.click();
	}

	public void enterChooseDateAndTime_ventilatorSetUpPlanTab(WebDriver driver, String date) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		chooseDateTime_ventilatorSetupTab.sendKeys(date);
		Thread.sleep(400);
		chooseDateTime_ventilatorSetupTab.sendKeys(Keys.ENTER);
	}

	public void enterSpo2_ventilatorSetUpPlanTab(WebDriver driver, String spo2) {
		explictWaitForElementToBeVisible(driver, spo2Field_ventilatorSetupTab);
		spo2Field_ventilatorSetupTab.sendKeys(spo2);
	}

	public void enterTv_ventilatorSetUpPlanTab(WebDriver driver, String tv) {
		explictWaitForElementToBeVisible(driver, tvField_ventilatorSetupTab);
		tvField_ventilatorSetupTab.sendKeys(tv);
	}

	public void enterRate_ventilatorSetUpPlanTab(WebDriver driver, String rate) {
		explictWaitForElementToBeVisible(driver, rateField_ventilatorSetupTab);
		rateField_ventilatorSetupTab.sendKeys(rate);
	}

	public void enterFio2_ventilatorSetUpPlanTab(WebDriver driver, String fio2) {
		explictWaitForElementToBeVisible(driver, fio2Field_ventilatorSetupTab);
		fio2Field_ventilatorSetupTab.sendKeys(fio2);
	}

	public void enterPrSupport_ventilatorSetUpPlanTab(WebDriver driver, String prSupport) {
		explictWaitForElementToBeVisible(driver, prSupportField_ventilatorSetupTab);
		prSupportField_ventilatorSetupTab.sendKeys(prSupport);
	}

	public void enterPeep_ventilatorSetUpPlanTab(WebDriver driver, String peep) {
		explictWaitForElementToBeVisible(driver, peepField_ventilatorSetupTab);
		peepField_ventilatorSetupTab.sendKeys(peep);
	}

	public void enterPc_ventilatorSetUpPlanTab(WebDriver driver, String pc) {
		explictWaitForElementToBeVisible(driver, pcField_ventilatorSetUpTab);
		pcField_ventilatorSetUpTab.sendKeys(pc);
	}

	public void enterOxygen_ventilatorSetUpPlanTab(WebDriver driver, String oxygen) {
		explictWaitForElementToBeVisible(driver, oxygenField_ventilatorSetUpTab);
		oxygenField_ventilatorSetUpTab.sendKeys(oxygen);
	}

	public void enterTpiece_ventilatorSetUpPlanTab(WebDriver driver, String tpiece) {
		explictWaitForElementToBeVisible(driver, tPieceField_ventilatorSetUpTab);
		tPieceField_ventilatorSetUpTab.sendKeys(tpiece);
	}

	public void clickOnRoomAirBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		roomAirBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnVomittingBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		vomittingBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnPositioningBackCareBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		positioningBackCareBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnBathBedBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		bedBathBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnOralCareBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		oralCareBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnChestPhysioBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		chestPhysioBtn_ventilatorBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnStoolBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		stoolBtn_ventilatorBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnWoundDressingBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		woundDressingBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnSubmitBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollToBottom(driver);
		submitBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnCancelBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollToBottom(driver);
		cancelBtn_ventilatorSetup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void createVentilatorSetup_1(WebDriver driver, String date, String spo2, String tv, String rate, String fio2,
			String prsupport, String peep, String pc) throws Throwable {
		Thread.sleep(1000);
		enterChooseDateAndTime_ventilatorSetUpPlanTab(driver, date);
		enterSpo2_ventilatorSetUpPlanTab(driver, spo2);
		enterTv_ventilatorSetUpPlanTab(driver, tv);
		enterRate_ventilatorSetUpPlanTab(driver, rate);
		enterFio2_ventilatorSetUpPlanTab(driver, fio2);
		enterPrSupport_ventilatorSetUpPlanTab(driver, prsupport);
		enterPeep_ventilatorSetUpPlanTab(driver, peep);
		enterPc_ventilatorSetUpPlanTab(driver, pc);
	}

	public void createVentilatorSetup_2(WebDriver driver, String oxygen, String tpiece) {
		for (int i = 0; i <= 2; i++) {
			scrollDownByUsingActionClass(driver);
		}
		enterOxygen_ventilatorSetUpPlanTab(driver, oxygen);
		enterTpiece_ventilatorSetUpPlanTab(driver, tpiece);
		clickOnRoomAirBtn_ventilatorSetUpPlanTab(driver);
		clickOnVomittingBtn_ventilatorSetUpPlanTab(driver);
		clickOnPositioningBackCareBtn_ventilatorSetUpPlanTab(driver);
		clickOnSubmitBtn_ventilatorSetUpPlanTab(driver);
	}

	public String captureErrorPopUpmsg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(500);
		String errorMsg = errorPopUpMsg.getText();
		return errorMsg;
	}

	public void enterDateInTable_grbs(WebDriver driver, String date) throws InterruptedException {
		invisibiltyOf_Element_ThreeDots(driver);
		dateInTable_grbs.sendKeys(date);
		Thread.sleep(400);
		dateInTable_grbs.sendKeys(Keys.ENTER);
	}

	public void selectTypeInTable_grbs(WebDriver driver, String selectType) {
		invisibiltyOf_Element_ThreeDots(driver);
		typeDropDownBtn_grbs.click();
		moveToElementAndEnterTheData(driver, dropDownText, selectType);
	}

	public void selectCollectedAtInTable_grbs(WebDriver driver, String collectedAt) {
		invisibiltyOf_Element_ThreeDots(driver);
		collectedAtDropDownBtn_grbs.click();
		moveToElementAndEnterTheData(driver, dropDownText, collectedAt);
	}

	public void enterValueInTable_grbs(WebDriver driver, String value) {
		explictWaitForElementToBeVisible(driver, valueField_grbs);
		valueField_grbs.sendKeys(value);
	}

	public void enterRemarksInTable_grbs(WebDriver driver, String remarks) {
		explictWaitForElementToBeVisible(driver, remarksField_grbs);
		remarksField_grbs.sendKeys(remarks);
	}

	public void clickOnAddBtnInTable_grbs(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		addBtnInTable_grbs.click();
	}

	public void clickOnSubmitBtn_grbs(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_grbs);
		submitBtn_grbs.click();
	}

	public void createGrbs(WebDriver driver, String date, String type, String collectedAt, String value, String remarks)
			throws Throwable {
		for (int i = 0; i <= 4; i++) {
			scrollDownByUsingJavascriptExecuter(driver);
			enterDateInTable_grbs(driver, date);
			selectTypeInTable_grbs(driver, type);
			selectCollectedAtInTable_grbs(driver, collectedAt);
			enterValueInTable_grbs(driver, value);
			enterRemarksInTable_grbs(driver, remarks);
			clickOnAddBtnInTable_grbs(driver);
		}
		clickOnSubmitBtn_grbs(driver);
	}

	public void enterChooseTime_abg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		chooseTime_abg.sendKeys(Keys.SPACE);
		Thread.sleep(400);
		chooseTime_abg.sendKeys(Keys.ENTER);
	}

	public void enterPh(WebDriver driver, String ph) {
		explictWaitForElementToBeVisible(driver, phText_abg);
		phText_abg.sendKeys(ph);
	}

	public void enterPco2(WebDriver driver, String pco2) {
		explictWaitForElementToBeVisible(driver, pco2Text_abg);
		pco2Text_abg.sendKeys(pco2);
	}

	public void enterPo2(WebDriver driver, String po2) {
		explictWaitForElementToBeVisible(driver, po2Text_abg);
		po2Text_abg.sendKeys(po2);
	}

	public void enterSo2(WebDriver driver, String so2) {
		explictWaitForElementToBeVisible(driver, so2Text_abg);
		so2Text_abg.sendKeys(so2);
	}

	public void enterLac(WebDriver driver, String lac) {
		explictWaitForElementToBeVisible(driver, lacText_abg);
		lacText_abg.sendKeys(lac);
	}

	public void enterHco2(WebDriver driver, String hco2) {
		explictWaitForElementToBeVisible(driver, hco2Text_abg);
		hco2Text_abg.sendKeys(hco2);
	}

	public void clickOnSubmit_ags(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		submitBtn_abg.click();
	}

	public void enterChooseTime_neuroMonitoring(WebDriver driver) throws Throwable {
		chooseTime_neuroMonitoring.sendKeys(Keys.SPACE);
		Thread.sleep(400);
		chooseTime_neuroMonitoring.sendKeys(Keys.ENTER);
	}

	public void enterSizeOnRight(WebDriver driver, String sizeOnRight) {
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		sizeOnRightText.sendKeys(sizeOnRight);
	}

	public void enterSizeOnleft(WebDriver driver, String sizeOnleft) {
		explictWaitForElementToBeVisible(driver, sizeOnLeftText);
		sizeOnLeftText.sendKeys(sizeOnleft);
	}

	public void clickOnReactionRight(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		reactionRightBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnReactionLeft(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		reactionLeftBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnRightArmCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		rightArmCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnLeftArmCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		leftArmCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnRightLegCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		rightLegCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnLeftLegCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		leftLegCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnSubmit_NeuroMonitoring(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		submitBtn_neuroMonitoring.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnListOfCheckBox_LinesAndTubes(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		for (WebElement element : listOfCheckBox_LinesAndtubes) {
			element.click();
		}
	}

	public void enterListOfText_LinesAndTubes(WebDriver driver, String text) throws Throwable {

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		for (WebElement element : listOfTextField_LinesAndtubes) {
			element.sendKeys(text);
		}
	}

	public void clickOnSubmitBtn_linesAndTubes(WebDriver driver) {
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_linesAndTubesTab);
		submitBtn_linesAndTubesTab.click();
	}

	public void enterChooseTime_IntakeAndOutputCharting(WebDriver driver, String date) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		chooseTimeField_intakeAndOutputCharting.sendKeys(date);
		Thread.sleep(400);
		chooseTimeField_intakeAndOutputCharting.sendKeys(Keys.ENTER);
	}

	public void enterFluid_IntakeAndOutputCharting(WebDriver driver, String fluid) throws Throwable {
		explictWaitForElementToBeVisible(driver, sizeOnLeftText);
		fluidTextField_intakeAndOutputCharting.sendKeys(fluid);
	}

	public void enterRtf_IntakeAndOutputCharting(WebDriver driver, String Rtf) throws Throwable {
		rtfTextField_intakeAndOutputCharting.sendKeys(Rtf);
	}

	public void enterOral_IntakeAndOutputCharting(WebDriver driver, String oral) throws Throwable {
		oralTextField_intakeAndOutputCharting.sendKeys(oral);
	}

	public void enterFj_IntakeAndOutputCharting(WebDriver driver, String fj) throws Throwable {
		fjTextField_intakeAndOutputCharting.sendKeys(fj);
	}

	public void enterIvfSolution_IntakeAndOutputCharting(WebDriver driver, String ivf) throws Throwable {
		ivfSolutionTextField_intakeAndOutputCharting.sendKeys(ivf);
	}

	public void enterUrinOutput_IntakeAndOutputCharting(WebDriver driver, String urinOutput) throws Throwable {
		urinOutputTextField_intakeAndOutputCharting.sendKeys(urinOutput);
	}

	public void enterDrainValue_IntakeAndOutputCharting(WebDriver driver, String drainValue) throws Throwable {
		drainValueBtn_intakeAndOutputCharting.sendKeys(drainValue);
	}

	public void selectDrain_IntakeAndOutputCharting(WebDriver driver, String drain) throws Throwable {
		dropdown(driver, drainDropDownBtn_intakeAndOutputCharting, dropDownText, drain);
	}

	public void enterIcd_IntakeAndOutputCharting(WebDriver driver, String icd) throws Throwable {
		icdTextField_intakeAndOutputCharting.sendKeys(icd);
	}

	public void clickOnSubmit_IntakeAndOutputCharting(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, submitBtn_intakeAndOutputCharting);
		submitBtn_intakeAndOutputCharting.click();
	}

	public void enterRta_IntakeAndOutputCharting(WebDriver driver, String rta) throws Throwable {
		rtaText.sendKeys(rta);
	}

	public void enterInputType_IntakeAndOutputCharting(WebDriver driver, String inputType) throws Throwable {
		inputTypeText_intakeAndOutputCharting.sendKeys(inputType);
	}

	public void enterInput_IntakeAndOutputCharting(WebDriver driver, String input) throws Throwable {
		inputText_intakeAndOutputCharting.sendKeys(input);
	}

	public void enterOutputType_IntakeAndOutputCharting(WebDriver driver, String outputType) throws Throwable {
		outputTypeText_intakeAndOutputCharting.sendKeys(outputType);
	}

	public void enterOutput_IntakeAndOutputCharting(WebDriver driver, String output) throws Throwable {
		outputText_intakeAndOutputCharting.sendKeys(output);
	}
}
