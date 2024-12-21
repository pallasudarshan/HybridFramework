package com.Vims.ADT_ManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.GeneratHospitalNumber_page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class GenerateHospitalNumber_Test extends BaseClass {

	@Test
	public void checkThatUserIsAbleToGenerateRuralHospitalNumber_Test() throws Throwable {
		String clinicName = "VYDEHI CLINIC";
		String gender_female = "Female";
		String qty = "15";
		String msg = "Successfully completed opd registrations";
		String department = "DERMATOLOGY";
		String unit2 = "2";
		String hsp = "15";

		HomePage homePage = new HomePage(driver);
		GeneratHospitalNumber_page generatHospitalNumber_page = new GeneratHospitalNumber_page(driver);

		generatHospitalNumber_page.generateHospitalNumber(driver);
		homePage.homeBtnForvims(driver);
		generatHospitalNumber_page.clickNewBtn(driver);
		generatHospitalNumber_page.enterHospitalNumber(driver, hsp);
		generatHospitalNumber_page.clickGenerateHospitalNumberBtn(driver);
		generatHospitalNumber_page.clickonokBtn(driver);
		generatHospitalNumber_page.clickEdit(driver);
		generatHospitalNumber_page.selectFromDate(driver);
		generatHospitalNumber_page.addLineItems(driver, clinicName, department, unit2, gender_female, qty);
		generatHospitalNumber_page.clicksubmitBnt(driver);
		String text = generatHospitalNumber_page.captureTextAndClickOnOkbtn(driver);
		Assert.assertEquals(text, msg);
	}

	@Test
	public void checkThatSystemShouldNotAllowToAddLineItemWithoutEnteringMandatoryFields_Test() throws Throwable {
		String clinicName = "VYDEHI CLINIC";
		String department = "DERMATOLOGY";
		String unit2 = "2";
		String hsp = "15";

		HomePage homePage = new HomePage(driver);
		GeneratHospitalNumber_page generatHospitalNumber_page = new GeneratHospitalNumber_page(driver);

		generatHospitalNumber_page.generateHospitalNumber(driver);
		homePage.homeBtnForvims(driver);
		generatHospitalNumber_page.clickNewBtn(driver);
		generatHospitalNumber_page.enterHospitalNumber(driver, hsp);
		generatHospitalNumber_page.clickGenerateHospitalNumberBtn(driver);
		generatHospitalNumber_page.clickonokBtn(driver);
		generatHospitalNumber_page.clickEdit(driver);
		generatHospitalNumber_page.selectFromDate(driver);
		generatHospitalNumber_page.selectclinicName(driver, clinicName);
		generatHospitalNumber_page.selectDepartment(driver, department);
		generatHospitalNumber_page.selectunitNo(driver, unit2);
		generatHospitalNumber_page.clickaddBtn(driver);
		String text = generatHospitalNumber_page.captureOkBtnText(driver);
		generatHospitalNumber_page.clickonokBtn(driver);
		Assert.assertEquals(text, "Please Fill the Mandatory Feild..!");
	}

	@Test
	public void checkThatTotalNumberOfPatientIsDisplayingCorrectly_Test() throws Throwable {
		String clinicName = "VYDEHI CLINIC";
		String gender_female = "Female";
		String qty = "15";
		String department = "DERMATOLOGY";
		String unit2 = "2";
		String hsp = "50";
		String department1 = "GENERAL MEDICINE";
		String department2 = "DENTAL";
		String unit1 = "1";
		String unit4 = "4";

		HomePage homePage = new HomePage(driver);
		GeneratHospitalNumber_page generatHospitalNumber_page = new GeneratHospitalNumber_page(driver);

		generatHospitalNumber_page.generateHospitalNumber(driver);
		homePage.homeBtnForvims(driver);
		generatHospitalNumber_page.clickNewBtn(driver);
		generatHospitalNumber_page.enterHospitalNumber(driver, hsp);
		generatHospitalNumber_page.clickGenerateHospitalNumberBtn(driver);
		generatHospitalNumber_page.clickonokBtn(driver);
		generatHospitalNumber_page.clickEdit(driver);
		generatHospitalNumber_page.selectFromDate(driver);
		generatHospitalNumber_page.addLineItems(driver, clinicName, department, unit2, gender_female, qty);
		generatHospitalNumber_page.addLineItems(driver, clinicName, department1, unit4, gender_female, qty);
		generatHospitalNumber_page.addLineItems(driver, clinicName, department2, unit1, gender_female, qty);
		int total = generatHospitalNumber_page.captureAndCalculateNewQuantity(driver);
		System.out.println(total);
		int text = generatHospitalNumber_page.captureTotalNumberOfPatinet(driver);
		Assert.assertEquals(total, text);
	}

	@Test
	public void checkThatUserIsAbleToDeleteAddedLineItem_Test() throws Throwable {
		String clinicName = "VYDEHI CLINIC";
		String gender_female = "Female";
		String qty = "15";
		String department = "DERMATOLOGY";
		String unit2 = "2";
		String hsp = "50";
		String department2 = "DENTAL";
		String unit1 = "1";

		HomePage homePage = new HomePage(driver);
		GeneratHospitalNumber_page generatHospitalNumber_page = new GeneratHospitalNumber_page(driver);

		generatHospitalNumber_page.generateHospitalNumber(driver);
		homePage.homeBtnForvims(driver);
		generatHospitalNumber_page.clickNewBtn(driver);
		generatHospitalNumber_page.enterHospitalNumber(driver, hsp);
		generatHospitalNumber_page.clickGenerateHospitalNumberBtn(driver);
		generatHospitalNumber_page.clickonokBtn(driver);
		generatHospitalNumber_page.clickEdit(driver);
		generatHospitalNumber_page.selectFromDate(driver);
		generatHospitalNumber_page.addLineItems(driver, clinicName, department, unit2, gender_female, qty);
		generatHospitalNumber_page.clickOnDeleteBtn_LineItem(driver);
		generatHospitalNumber_page.checkThatLineItemIsDeletedOrNot(driver);
	}
}
