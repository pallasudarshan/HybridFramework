package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.BaseClass;

public class IpPackagePage extends BaseClass{
	
	// intilization f the WebElements
		public IpPackagePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//span[text()=' Ip package ']")
		private WebElement   ipaPackageBtn;
		
		@FindBy(xpath = "//span[@title='Select Rate Type']/following-sibling::span")
		private WebElement    rateTypeDropdown;

		@FindBy(xpath = "//span[@title='Select Speciality']/following-sibling::span")
		private WebElement     departmentTypeDropdown;
		
		@FindBy(xpath = "//button[text()=' Search']")
		private WebElement     searchBtn;
		
		@FindBy(xpath = "//i[@class='zmdi zmdi-plus-circle']")
		private WebElement     addBtn;
		
		@FindBy(xpath = "//input[@formcontrolname='packageName']")
		private WebElement    packageNameText;
		
		@FindBy(xpath = "//input[@formcontrolname='packageAmount']")
		private WebElement    packageAmountText;
		
		@FindBy(xpath = "//input[@formcontrolname='noOfDays']")
		private WebElement     numberOfDaysText;
		
		@FindBy(xpath = "//input[@formcontrolname='effectiveFromDate']")
		private WebElement    effectiveFromDate;
		
		@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span")
		private WebElement     wardTypeDropdown;
		
		@FindBy(xpath = "//table/tbody/tr[1]/td[2]/descendant::input[@placeholder='Service']")
		private WebElement    serviceNameText_ServiceDetailsTable;
		
		@FindBy(xpath = "//table/tbody/tr[1]/td[6]/descendant::input[@placeholder='Quantity']")
		private WebElement     quantityText_ServiceDetailsTable;
		
		@FindBy(xpath = "//table/tbody/tr[1]/td[9]/descendant::span[@data-on='Yes']/following-sibling::span")
		private WebElement    statusBtn_ServiceDetailsTable;
		
		@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[@type='button']")
		private WebElement    actionBtn_ServiceDetailsTable;
		
		@FindBy(xpath="//button[text()=' Submit']")
		private WebElement  submitBtn;
		
		
		@FindBy(xpath="//button[text()=' Cancel']")
		private WebElement   cancelBtn;
		
		@FindBy(xpath="//input[@formcontrolname='detailAmount']")
		private WebElement   detailsAmount;
		
		@FindBy(xpath="//table/tbody/tr[1]/td[last()-2]/descendant::input[@placeholder='Package Value']")
		private WebElement    serviceVlue_ServiceDetailsTable;
		
		
		@FindBy(xpath="(//table[contains(@class,'table table-striped')]/tbody/tr[1]/td[2])[1]")
		private WebElement          packageCode_Table;
		
		@FindBy(xpath="(//table[contains(@class,'table table-striped')]/tbody/tr[1]/td[3])[1]")
		private WebElement packageName_Table;
		
		
		@FindBy(xpath="(//table[contains(@class,'table table-striped')]/tbody/tr[1]/td[4])[1]")
		private WebElement    wardType_Table;
		
		@FindBy(xpath="(//table[contains(@class,'table table-striped')]/tbody/tr[1]/td[5])[1]")
		private WebElement   effectiveFrom_Table ;
		
		@FindBy(xpath="(//table[contains(@class,'table table-striped')]/tbody/tr[1]/td[7])[1]")
		private WebElement   packageAmount_Table ;
		
		@FindBy(xpath="(//table[contains(@class,'table table-striped')]/tbody/tr[1]/td[8])[1]/descendant::span[@data-off='No']/following-sibling::span")
		private WebElement    statusBtn_Table;
		
		
		@FindBy(xpath="(//table[contains(@class,'table table-striped')]/tbody/tr[1]/td[last()])[1]/descendant::button[text()=' Edit']")
		private WebElement    editBtn_Table;
		


}
