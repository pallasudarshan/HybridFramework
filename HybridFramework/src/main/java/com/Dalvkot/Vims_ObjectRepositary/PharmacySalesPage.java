package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class PharmacySalesPage extends WebDriverUtility {
	public PharmacySalesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//a[text()=' Pharmacy Sales ']")
	private WebElement pharmacySalesBtn ;
	
	@FindBy(xpath="//i[@class='zmdi zmdi-plus-circle']")
	private WebElement addBtn;
	
	@FindBy(xpath="//label[text()='Sales Location']/ancestor::div[@class='form-group col-3 col-md-3']/descendant::span[@class='select2-selection__arrow']")
	private WebElement salesLocationDropdownBtn;
	
	@FindBy(className = "select2-search__field")
	private WebElement dropdownsText;
	
	@FindBy(xpath="//label[text()='Sale Type']/ancestor::div[@class='form-group col-3']/descendant::span[@class='select2-selection__arrow']")
	private WebElement salesTypeDropdOwnBtn;
	
	@FindBy(xpath="//label[text()='Hospital Name']/ancestor::div[@class='form-group col-3']/descendant::span[@class='select2-selection__arrow']")
	private WebElement hospitalNameDropdownBtn;
	
	@FindBy(xpath="//input[@placeholder='Patient Name']")
	private WebElement patientNameText;
	
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	private WebElement phoneNumberText;
	
	@FindBy(xpath="//label[text()='Manual Receipt Date']/ancestor::div[@class='form-group col-3']/descendant::input[@placeholder='Number']")
	private WebElement manualReceiptDateText;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[3]/descendant::input")
	private WebElement drupNameTextInTheTable;
	
	@FindBy(xpath="//li[@class='item']")
	private WebElement drugNameSuggestion;
	
	@FindBy(xpath="//table/tbody/tr/td[4]/descendant::span[@class='select2-selection__arrow']")
	private WebElement btachNumberDropdownBtnInTheTable;
	
	@FindBy(xpath="//input[@placeholder='sales qty']")
	private WebElement salesQuantityTextInTheTable;
	
	@FindBy(xpath="//table[@class='table table-responsive-md text-center']/tbody/tr/td[14]/descendant::input[@placeholder='Disc (%)']")
	private WebElement discountTextInTheTable;
	
	@FindBy(xpath="//table[@class='table table-responsive-md text-center']/tbody/tr/td[20]/descendant::button[@class='btn btn-primary btn-circle btn-sm']")
	private WebElement addBtnInTheTable;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-round btn-simple']/ancestor::div[@class='text-right']/descendant::i[@class='zmdi zmdi-card-sd'][2]")
	private WebElement submitBtn;
	
	
	@FindBy(xpath="//button[@class='swal2-confirm swal2-styled']")
	private WebElement SuccessfullMsgOkBtn;
	
	////////Other sales
	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
//	
//	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
//	
//	@FindBy()
//	private WebElement
	
	
	

	
	/**
	 * Getters 
	 * 
	 * @return
	 */

	public WebElement getPharmacySalesBtn() {
		return pharmacySalesBtn;
	}


	public WebElement getAddBtn() {
		return addBtn;
	}


	public WebElement getSalesLocationDropdownBtn() {
		return salesLocationDropdownBtn;
	}


	public WebElement getDropdownsText() {
		return dropdownsText;
	}


	public WebElement getSalesTypeDropdOwnBtn() {
		return salesTypeDropdOwnBtn;
	}


	public WebElement getHospitalNameDropdownBtn() {
		return hospitalNameDropdownBtn;
	}


	public WebElement getPatientNameText() {
		return patientNameText;
	}


	public WebElement getPhoneNumberText() {
		return phoneNumberText;
	}


	public WebElement getManualReceiptDateText() {
		return manualReceiptDateText;
	}


	public WebElement getDrupNameTextInTheTable() {
		return drupNameTextInTheTable;
	}


	public WebElement getDrugNameSuggestion() {
		return drugNameSuggestion;
	}


	public WebElement getBtachNumberDropdownBtnInTheTable() {
		return btachNumberDropdownBtnInTheTable;
	}


	public WebElement getSalesQuantityTextInTheTable() {
		return salesQuantityTextInTheTable;
	}


	public WebElement getDiscountTextInTheTable() {
		return discountTextInTheTable;
	}


	public WebElement getAddBtnInTheTable() {
		return addBtnInTheTable;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public WebElement getSuccessfullMsgOkBtn() {
		return SuccessfullMsgOkBtn;
	}
	
	
	
	
	
	
	
	
	
	
	

}
