package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class MenuPermissionPage extends WebDriverUtility {

	public MenuPermissionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Menu Permission ']")
	private WebElement menuPermissionBtn;

	@FindBy(xpath = "//span[@title='user Type']/following-sibling::span[1]")
	private WebElement userTypeDropdownBtn;

	@FindBy(xpath = "//span[@title='role_type']/following-sibling::span[1]")
	private WebElement roleTypeDropdownBtn;

	@FindBy(xpath = "//span[@title='Role']/following-sibling::span[1]")
	private WebElement roleDropdownBtn;

	@FindBy(xpath = "//span[@title='organisationName']/following-sibling::span[1]")
	private WebElement organizationDropdownBtn;

	@FindBy(xpath = "//span[@title='groupName']/following-sibling::span[1]")
	private WebElement groupNameDropdownBtn;

	@FindBy(xpath = "//span[@title='businessName']/following-sibling::span[1]")
	private WebElement buinessIdDropdwonBtn;

	@FindBy(xpath = "//span[@title='Menu']/following-sibling::span[1]")
	private WebElement menuListDropdownBtn;

	@FindBy(xpath = "(//button[text()=' Permission '])[1]")
	private WebElement permissionBtn;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement errorPopupMessage;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement errorPopupOkButton;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	/*
	 * 
	 * 
	 * 
	 * Business Logics
	 * 
	 * 
	 * 
	 */

	public void clickOnMenuPermissionButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, menuPermissionBtn);
	}

	public void selectUserType(WebDriver driver, String userType) {
		dropdown_Handling(driver, 5, userTypeDropdownBtn, dropdownText, userType);
	}

	public void selectRoleType(WebDriver driver, String roleType) {
		dropdown_Handling(driver, 4, roleTypeDropdownBtn, dropdownText, roleType);
	}

	public void selectRole(WebDriver driver, String role) {

		roleDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, role);

	}

	public void selectOrganization(WebDriver driver, String organization) {

		organizationDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, organization);

	}

	public void selectGroup(WebDriver driver, String groupName) throws Throwable {
		Thread.sleep(1000);

		groupNameDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, groupName);

	}

	public void selectBuinessId(WebDriver driver, String buinessId) throws Throwable {
		Thread.sleep(1000);

		buinessIdDropdwonBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, buinessId);
	}

	public void selectMenuList(WebDriver driver, String menuList) {

		menuListDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, menuList);

	}

	public void clickOnPermissionButton(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, permissionBtn);
		permissionBtn.click();

	}

	public String takeTheErrorMessage_And_ClickOnOkButton(WebDriver driver) {
		String msg = errorPopupMessage.getText();
		errorPopupOkButton.click();
		return msg;
	}

}
