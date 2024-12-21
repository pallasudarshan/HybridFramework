package com.Vims.BioMedicalTest;

import java.util.List;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.ExcelUtility;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.vims_MaterialManagement.ItemMasterPage;

public class EquipmentMasterTest extends BaseClass {

	@Test(invocationCount = 10)
	public void checkThatUserShouldCreateTheItem_Test() throws Throwable {

		ExcelUtility eutil = new ExcelUtility();
		String accountingStore = "biomedical";
		String itemGroup = "regular";
		String itemCategory = "biomedical spares";
		String manufacturer = "nihon khoden";
		String uomPurchase = "box";
		String uomStocks = "BOOK";
		String stockLinkType = "DIRECT";
		String issueType = "BULK";
		String packUnit = "ML";
		String effectiveDate = "12-12-2024";

		List<String> itemNames = eutil.fetchDataFromExcel("ItemMaster", 0);

		ItemMasterPage ip = new ItemMasterPage(driver);
		HomePage hp = new HomePage(driver);

		ip.clickOnItemMasterScreen(driver);
		hp.homeBtnForvims(driver);
		ip.select_Invetorystore(driver);

		ip.createTheItemForBioMedical(driver, accountingStore, itemGroup, itemCategory, manufacturer, uomPurchase,
				uomStocks, stockLinkType, issueType, packUnit, itemNames, effectiveDate);
	}

}
