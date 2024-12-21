package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class LabServicesListPage extends WebDriverUtility {

	public LabServicesListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Lab Service List ']")
	private WebElement labServiceListBtn;

	@FindBy(xpath = "//input[@placeholder='Service Name']")
	private WebElement serviceNameText;

	@FindBy(xpath = "/html/body/app-root/app-home/app-lab-service-list/section/div[2]/div/div/div[1]/div/div[2]/button[1]/i")
	private WebElement searchBtn;

	@FindBy(xpath = "/html/body/app-root/app-home/app-lab-service-list/section/div[2]/div/div/div[1]/div/div[2]/button[2]/i")
	private WebElement clearBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement serviceName_Table;

	/*
	 * Buisness Logics
	 * 
	 */

	public void clickOnTheServiceList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, labServiceListBtn);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void enterTheserviceNameText(String serviceName) {
		serviceNameText.sendKeys(serviceName);
	}

	public void clickOnThesearchBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		searchBtn.click();
	}

	public void clickOnTheClearButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		clearBtn.click();
	}

	public String fetchTheServiceName() {

		String serviceName1 = serviceName_Table.getText();
		return serviceName1;
	}

}
