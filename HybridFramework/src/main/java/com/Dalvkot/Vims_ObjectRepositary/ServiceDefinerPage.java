package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ServiceDefinerPage extends WebDriverUtility {

	public ServiceDefinerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Service definer ']")
	private WebElement serviceDefinerLink;

	@FindBy(xpath = "//span[@title='Select Service Type']/following-sibling::span")
	private WebElement serviceTypeDropdown_Filter;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindBy(xpath = "//span[@title='Select Service Group']/following-sibling::span")
	private WebElement serviceGroupDropdown_Filter;

	@FindBy(xpath = "//span[@title='Select Service Class']/following-sibling::span")
	private WebElement serviceClassDropdown_Filter;

	@FindBy(xpath = "//button[text()=' Search']//i")
	private WebElement searchBtn_Filter;

	@FindBy(xpath = "//button[text()=' Clear']//i")
	private WebElement clearBtn_Filter;

	@FindBy(xpath = "//a[contains(.,'Add')]//i[@class='zmdi zmdi-plus-circle']")
	private WebElement add_Btn;

	@FindBy(xpath = "(//span[@data-on='Yes']/following-sibling::span)[1]")
	private WebElement generate_Service_SwitchBtn;

	@FindBy(xpath = "(//input[@placeholder='Service Code'])[1]")
	private WebElement serviceCode_Text;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[2]")
	private WebElement concessionFor_Ip;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[3]")
	private WebElement concessionFor_Op;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[4]")
	private WebElement discountFor_Ip;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[5]")
	private WebElement discountFor_Op;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[6]")
	private WebElement clearanceRequired;

	@FindBy(xpath = "//table[@id='subtableid']//tr[1]//td[last()]//button//i[1]")
	private WebElement action_Btn;

	@FindBy(xpath = "//button[text()=' Save']//i")
	private WebElement save_Btn;

	@FindBy(xpath = "//button[text()=' Cancel']//i")
	private WebElement cancel_Btn;

	@FindBy(xpath = "//table[@id='subtableid']//tr[2]/td[last()]/button[1]")
	private WebElement delete_Btn;

	@FindBy(xpath = "//button[text()=' Back']//i")
	private WebElement back_Btn;

	@FindBy(xpath = "(//table)[1]//tr[1]/td[2]")
	private WebElement serviceType_Table;

	@FindBy(xpath = "(//table)[1]//tr[1]/td[3]")
	private WebElement serviceGroup_Table;

	@FindBy(xpath = "(//table)[1]//tr[1]/td[4]")
	private WebElement serviceClass_Table;

	@FindBy(xpath = "(//table)[1]//tr[1]/td[5]//span[@data-off='No']/following-sibling::span")
	private WebElement status_Table;

	@FindBy(xpath = "(//table)[1]//tr[1]//td[last()]//button[text()=' Actions ']")
	private WebElement action_Btn_Table;

	@FindBy(xpath = "(//table)[1]//tr[1]/td[last()]//button//i")
	private WebElement edit_Action_Table;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement ok_Btn;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement ok_popUp_Msg;

	/*
	 * 
	 * 
	 * Buiness Logics
	 * 
	 * 
	 */

	public void clickOnServiceDefiner_Link(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, serviceDefinerLink);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectServiceType_Filter(WebDriver driver, String serviceType) {
		invisibiltyOf_Element_ThreeDots(driver);
		serviceTypeDropdown_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceType);

	}

	public void selectServiceGroup(WebDriver driver, String serviceGroup) {
		invisibiltyOf_Element_ThreeDots(driver);
		serviceGroupDropdown_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceGroup);
	}

	public void selectServiceClass(WebDriver driver, String serviceClass) {
		invisibiltyOf_Element_ThreeDots(driver);
		serviceClassDropdown_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceClass);

	}

	public void clickOnSearch_Filter(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn_Filter.click();
	}

	public void clickOnClear_Button_Filter(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clearBtn_Filter.click();
	}

	public void clickOn_Add_Button(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, add_Btn);
	}

	public void clickOn_GenerateService_SwitchButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		generate_Service_SwitchBtn.click();
	}

	public void enter_ServiceCode(WebDriver driver, String serviceCode) {
		serviceCode_Text.sendKeys(serviceCode);
	}

	public void clickOn_Concession_For_Ip(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		concessionFor_Ip.click();
		;
	}

	public void clickOn_Conession_For_Op(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		concessionFor_Op.click();
	}

	public void clickOn_Discount_For_Ip(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		discountFor_Ip.click();
	}

	public void clickOn_Discount_Op(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		discountFor_Op.click();
	}

	public String take_ServiceType_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String serviceType = serviceType_Table.getText();
		return serviceType;
	}

	public String take_Service_Group_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String serviceGroup = serviceGroup_Table.getText();
		return serviceGroup;
	}

	public String take_Service_Class_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String serviceClass = serviceClass_Table.getText();
		return serviceClass;
	}

	public void clickOn_Status_SwitchButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		status_Table.click();
	}

	public void clickOn_Action_Button(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		doubleClickOnTheElement(driver, action_Btn);
	}

	public void clickOn_Edit_Action_Button(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		edit_Action_Table.click();
	}

}
