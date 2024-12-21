package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class MenuManagement_Page extends WebDriverUtility {

	public MenuManagement_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Menu Management ']")
	private WebElement menuManagementLink;

	@FindBy(xpath = "//a[contains(text(),'Add')]//i")
	private WebElement addBtn;

	@FindBy(xpath = "//input[@placeholder='Main Menu']")
	private WebElement mainMenu_Text;

	@FindBy(xpath = "//input[@placeholder='Sub Menu']")
	private WebElement subMenu_Text;

	@FindBy(xpath = "//input[@placeholder='Enter page Name']")
	private WebElement pagenName_Text;

	@FindBy(xpath = "//input[@placeholder='Enter url']")
	private WebElement url_Text;

	@FindBy(xpath = "//input[@placeholder='Enter title']")
	private WebElement title_Text;

	@FindBy(xpath = "//table//tr[1]/td[2]//span[@role='presentation']")
	private WebElement organizationId_Dropdown;

	@FindBy(xpath = "//table//tr[1]/td[3]//span[@role='presentation']")
	private WebElement groupId_Dropdown;

	@FindBy(xpath = "//table//tr[1]/td[4]//span[@role='presentation']")
	private WebElement buinessId_Dropdown;

	@FindBy(xpath = "//table//tr[1]/td[last()]//i[@class='zmdi zmdi-plus']")
	private WebElement plusBtn_Table;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement popupMsg;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorPopup_Msg;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[text()=' Submit']//i")
	private WebElement submit_Btn;

	@FindBy(xpath = "//button[text()=' Cancel']//i")
	private WebElement cancel_Btn;

	@FindBy(xpath = "//a[contains(text(),'Back')]//i")
	private WebElement back_Btn;

	@FindBy(xpath = "(//button[text()=' Actions '])[1]")
	private WebElement actionBtn;

	@FindBy(xpath = "(//button[text()=' Edit'])[1]")
	private WebElement edit_Btn;

	/*
	 * 
	 * 
	 * Buiness Logics
	 * 
	 * 
	 * 
	 */

	public void clickOn_MenuManagement(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, menuManagementLink);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOn_AddButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		addBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void enter_MainMenu(WebDriver driver, String mainMenu) {
		invisibiltyOf_Element_ThreeDots(driver);
		mainMenu_Text.sendKeys(mainMenu);
	}

	public void enter_PageName(WebDriver driver, String pageName) {
		pagenName_Text.sendKeys(pageName);
	}

	public void enter_Url(WebDriver driver, String url) {
		url_Text.sendKeys(url);
	}

	public void enterTitle(WebDriver driver, String title) {
		title_Text.sendKeys(title);
	}

	public void select_OrganisationId(WebDriver driver, String organisationId) {
		dropdown(driver, organizationId_Dropdown, dropdownText, organisationId);
	}

	public void select_GrouoId(WebDriver driver, String groupId) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, groupId_Dropdown, dropdownText, groupId);
	}

	public void select_BuinessId(WebDriver driver, String businesId) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, buinessId_Dropdown, dropdownText, businesId);
	}

	public void clickOn_PlusButton_Table(WebDriver driver) {

		plusBtn_Table.click();
	}

	public void clickOn_SubmitButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);

		submit_Btn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOn_CancelButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, cancel_Btn);

		cancel_Btn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public String take_Error_PopupMessage(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String msg = errorPopup_Msg.getText();
		errorPopup_Msg.click();
		return msg;
	}

	public void clickOn_OKButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		okBtn.click();
	}

	public void clickOn_BackButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		back_Btn.click();
	}

	public void clickOn_Actions_With_Edit(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		doubleClickOnTheElement(driver, actionBtn);

		edit_Btn.click();
	}
}
