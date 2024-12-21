package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class EquipmentMasterPage extends WebDriverUtility {

	public EquipmentMasterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[@id='Bio-Medical']//span)[1]")
	private WebElement equipmentMasterScreenButton;

	@FindBy(xpath = "//a[@href='#pending']")
	private WebElement pendingListTab;

	@FindBy(xpath = "//a[@href='#completed']")
	private WebElement completedListTab;

	@FindBy(xpath = "//a[@href='#PmDue']")
	private WebElement PM_HistoryLitTab;

	@FindBy(xpath = "//a[@href='#calDue']")
	private WebElement CAL_HistoryListTab;

	@FindBy(xpath = "//a[@href='#amcHist']")
	private WebElement AMC_HistoryListTab;

	@FindBy(xpath = "//a[@href='#cmcHist']")
	private WebElement CMC_HistoryListTab;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[2]")
	private WebElement itemNamePending;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[4]")
	private WebElement itemQuantityPendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td//button[text()=' Actions ']")
	private WebElement actionButtonPendingList;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td//button[text()=' Generate Asset Tag']")
	private WebElement generateAssetTagPendingList;

	@FindBy(xpath = "//input[@formcontrolname='assetName']")
	private WebElement assestNumberText;

	@FindBy(xpath = "//input[@placeholder='Asset Description']")
	private WebElement assestDescriptionText;

	@FindBy(xpath = "//label[contains(.,'Asset Class *')]/..//span[@role='presentation']")
	private WebElement AssetClassDropdownBtn;

	@FindBy(xpath = "//label[contains(.,'Make *')]/..//span[@role='presentation']")
	private WebElement makeDropdownButton;

	@FindBy(xpath = "//input[@formcontrolname='model']")
	private WebElement modelText;

	@FindBy(xpath = "//input[@placeholder='Asset Serial Number']")
	private WebElement assestSerialNo;

	@FindBy(xpath = "//label[contains(.,'Asset Condition *')]/..//span[@role='presentation']")
	private WebElement assestConditionDropdownBtn;

	@FindBy(xpath = "//input[@placeholder='accessories Description']")
	private WebElement accessoriesDescriptionText;

	@FindBy(xpath = "//input[@placeholder='accessories Model']")
	private WebElement accessoriesModelText;

	@FindBy(xpath = "//input[@placeholder='accessories Serial No']")
	private WebElement accessoriesSerialNoText;

	@FindBy(xpath = "(//label[contains(.,'Supplier ')]/..//span[@role='presentation'])[1]")
	private WebElement supplierDropdownButton;

	@FindBy(xpath = "(//label[contains(.,'Supplier ')]/..//span[@role='presentation'])[2]")
	private WebElement supplierDropdownButton1;

	@FindBy(xpath = "//input[@placeholder='Eneter Service Agent']")
	private WebElement serviceAgentText;

	@FindBy(xpath = "//label[contains(.,'Manufacturer *')]/..//span[@role='presentation']")
	private WebElement manufacturer;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[2]")
	private WebElement grnDetailsToggleBtn;

	@FindBy(xpath = "//label[normalize-space(text())='GRN Number']/..//span[@role='presentation']")
	private WebElement GRN_NumberDropdownBtn;

	@FindBy(xpath = "//input[@placeholder='Warranty']")
	private WebElement warrantyPeriodText;

	@FindBy(xpath = "//input[@id='cashTransaction']")
	private WebElement amcRadioButton;

	@FindBy(xpath = "//input[@id='creditTransaction']")
	private WebElement cmcRadioButton;

	@FindBy(xpath = "//a[normalize-space(text())='Preventive Maintenance History']")
	private WebElement PreventiveMaintenanceHistoryTab;;

	@FindBy(xpath = "//label[normalize-space(text())='Criticality(Asset Type)']/..//span[@role='presentation']")
	private WebElement CriticalityDropdownBtn;

	@FindBy(xpath = "//label[normalize-space(text())='PM Frequency']/..//span[@role='presentation']")
	private WebElement PM_FrequencyDropdownBtn;

	@FindBy(xpath = "//input[@placeholder='Risk Factor']")
	private WebElement riskFactorText;

	@FindBy(xpath = "//input[@placeholder='Service Life']")
	private WebElement serviceLifeText;

	@FindBy(xpath = "(//input[@id='abnormalResult'])[1]")
	private WebElement PM_ProcessCheckBox;

	@FindBy(xpath = "//table/tbody/tr[1]/td/input[@placeholder='PM Done By']")
	private WebElement PmDoneByText;

	@FindBy(xpath = "(//table/tbody/tr[1]/td/input[@placeholder='Remarks'])[1]")
	private WebElement remarksPmProcess;

	@FindBy(xpath = "//div[@id='preventive-main']//table/tbody/tr[1]/td[last()]//button//i")
	private WebElement actionBtnPmProcess;

	@FindBy(xpath = "//button[normalize-space(text())='Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//a[normalize-space(text())='Calibration Information']")
	private WebElement calibrationInformationTab;

	@FindBy(xpath = "//div[@id='Calibration']//input[@id='abnormalResult']")
	private WebElement calibrationProcessCheckbox;

	@FindBy(xpath = "//div[@id='Calibration']//table/tbody/tr/td/input[@placeholder='Calibration Done By']")
	private WebElement calibrationDoneByText;

	@FindBy(xpath = "//div[@id='Calibration']//table/tbody/tr/td/input[@placeholder='Certificate Number']")
	private WebElement certificateNumberTextCalibrationProcess;

	@FindBy(xpath = "//div[@id='Calibration']//table/tbody/tr/td/input[@placeholder='Remarks']")
	private WebElement remarksCalibrationProcess;

	@FindBy(xpath = "//div[@id='Calibration']//table/tbody/tr/td[last()]//button")
	private WebElement actionBtnCalibrationProcess;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[2]")
	private WebElement itemNamePmHistoryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[4]")
	private WebElement assetNumberPmHistoryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[5]")
	private WebElement pmDatePmHistoryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[6]")
	private WebElement expiryDatePmHistoryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[7]")
	private WebElement pmDoneByPmHistoryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[last()]//button[text()=' Actions ']")
	private WebElement actionBtnPmHistoryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[last()]//button[text()=' Generate Sticker ']")
	private WebElement generateStickerPmHistoryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[last()]//button[text()=' View ']")
	private WebElement viewBtnPmHistpryList;

	@FindBy(xpath = "//div[@id='PmDue']//table/tbody/tr[1]/td[last()]//button[text()='Edit']")
	private WebElement editPmHistoryList;

	@FindBy(xpath = "//div[@id='calDue']//table/tbody/tr[1]/td[2]")
	private WebElement equipmentNameCalHistoryList;

	@FindBy(xpath = "//div[@id='calDue']//table/tbody/tr[1]/td[4]")
	private WebElement assetNumberCalHistoryList;

	@FindBy(xpath = "//div[@id='calDue']//table/tbody/tr[1]/td[5]")
	private WebElement calDateCalHistoryList;

	@FindBy(xpath = "//div[@id='calDue']//table/tbody/tr[1]/td[6]")
	private WebElement expiryDateCalHistoryList;

	@FindBy(xpath = "//div[@id='calDue']//table/tbody/tr[1]/td[7]")
	private WebElement calibrationDoneByCalHistoryList;

	@FindBy(xpath = "//div[@id='calDue']//table/tbody/tr[1]/td[8]")
	private WebElement departmentCalHistoryList;

	@FindBy(xpath = "//div[@id='calDue']//table/tbody/tr[1]/td//button[text()=' Actions ']")
	private WebElement actionButton;

//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;

}
