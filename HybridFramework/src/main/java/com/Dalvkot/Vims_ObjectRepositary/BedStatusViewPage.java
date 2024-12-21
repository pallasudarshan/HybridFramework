package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;

public class BedStatusViewPage extends BaseClass {

	public BedStatusViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Bed Status View ']")
	private WebElement bedStatusView;

	@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span")
	private WebElement wardTypeDropdownBtn;

	@FindBy(xpath = "//span[@title='Select Room Type']/following-sibling::span[1]")
	private WebElement roomTypeDropdownBtn;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "(//label[text()='Count']/following-sibling::span)[2]")
	private WebElement admittedCount;

	@FindBy(xpath = "(//label[text()='Count']/following-sibling::span)[3]")
	private WebElement reservedCount;

	@FindBy(xpath = "(//label[text()='Count']/following-sibling::span)[4]")
	private WebElement underMaintance;

	@FindBy(xpath = "(//label[text()='Count']/following-sibling::span)[5]")
	private WebElement available_Count;

	@FindBy(xpath = "//label[text()='Total No.Of Bed ']/following::span")
	private WebElement totalNumberOfBeds;

	@FindBy(xpath = "//label[text()='Available']/following::span[1]")
	private WebElement availableCount;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindBys({ @FindBy(xpath = "(//div[@class='card-header']//strong)") })
	private List<WebElement> admittedBedStatusCount;

	@FindBy(xpath = "//table[@id='subtableid']/thead//td[1]")
	private WebElement hospitalNumber_List_SingleBed;

	@FindBy(xpath = "//button[text()=' ADD']")
	private WebElement addBtn;

	/*
	 * 
	 * 
	 * Business Logics
	 * 
	 * 
	 */

	public void clickOn_BedStatusView(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, bedStatusView);
	}

	public void select_WardType(WebDriver driver, String wardType) throws Throwable {
		Thread.sleep(2000);
		dropdown(driver, wardTypeDropdownBtn, dropdownText, wardType);
	}

	public void select_RoomType(WebDriver driver, String roomType) {
		dropdown(driver, roomTypeDropdownBtn, dropdownText, roomType);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void clickOn_SearchButton(WebDriver driver) {
		searchBtn.click();
	}

	public String admitted_Count(WebDriver driver) {
		String admitted = admittedCount.getText();
		return admitted;
	}

	public String reserved_Count(WebDriver driver) {
		String reserved = reservedCount.getText();
		return reserved;
	}

	public String underMaintance_Cout(WebDriver driver) {
		String co = underMaintance.getText();
		return co;
	}

	public String available_Count(WebDriver driver) {
		String count = availableCount.getText();
		return count;
	}

	public String total_NumberOfBeds(WebDriver driver) {
		String total = totalNumberOfBeds.getText();
		return total;
	}

	public void count_TotalNumberOfBeds(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
		String t = admitted_Count(driver);
		String t1 = reserved_Count(driver);
		String t2 = underMaintance_Cout(driver);
		String t3 = available_Count(driver);
		String t4 = total_NumberOfBeds(driver);

		int admitted = Integer.parseInt(t);
		int reserved = Integer.parseInt(t1);
		int unerMaintaince = Integer.parseInt(t2);
		int available = Integer.parseInt(t3);
		int totalNumberOfBeds = Integer.parseInt(t4);

		int total = admitted + reserved + unerMaintaince + available;
		Assert.assertEquals(totalNumberOfBeds, total);
		System.out.println(totalNumberOfBeds + total + "Verified a total amount successfully");
	}

	public String capture_HospitalNumber_List(WebDriver driver) {
		String hospitalNum = hospitalNumber_List_SingleBed.getText();
		String hospitalNumber = remove_All_ExceptNumbers(hospitalNum, 0);
		return hospitalNumber;
	}

	public void clickOn_AddButton(WebDriver driver) {
		addBtn.click();
	}

}
