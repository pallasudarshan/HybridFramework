package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;

import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientTypeAndCategoryLinkPage;

class PatientTypeAndCategoryLinkTest extends BaseClass {

	@Test
	public void editpatientTypeAndCategoryLink_Test() throws Throwable {
		PatientTypeAndCategoryLinkPage pt = new PatientTypeAndCategoryLinkPage(driver);
		HomePage hp = new HomePage(driver);

		String patientType1 = "BPL";
		String patientType = "APL";
		String patientCategory = "FREE PT";
		String rateType = "HOSPITAL RATE";

		pt.clickOnPatientAndCatagoryLinkScreenBtn(driver);
		hp.homeBtnForvims(driver);
		pt.selectPatientType(driver, patientType);
		pt.selectPatientCatagory(driver, patientCategory);
		pt.selectRateType(driver, rateType);
		pt.clickOnEditBtn(driver);
		pt.selectPatientType(driver, patientType1);
		pt.clickOnSubmit(driver);
		pt.clickOnOkBtn(driver);
	}

	@Test(dependsOnMethods = "editpatientTypeAndCategoryLink_Test")
	public void createPatientTypeAndCategoryLink_Test() throws Throwable {
		PatientTypeAndCategoryLinkPage pt = new PatientTypeAndCategoryLinkPage(driver);
		HomePage hp = new HomePage(driver);

		String patientType = "APL";
		String patientCategory = "FREE PT";
		String rateType = "HOSPITAL RATE";
		String registrationCharge = "55";
		String revisitRegistrationCharge = "150";
		String admissioncharge = "97";

		pt.clickOnPatientAndCatagoryLinkScreenBtn(driver);
		hp.homeBtnForvims(driver);
		pt.clickOnAddBtn(driver);
		pt.selectPatientType(driver, patientType);
		pt.selectPatientCatagory(driver, patientCategory);
		pt.selectRateType(driver, rateType);
		pt.enterRegistrationCharge(driver, registrationCharge);
		pt.enterRevisitRegistrationCharge(driver, revisitRegistrationCharge);
		pt.enterAdmissionCharge(driver, admissioncharge);
		pt.selectCashCheckBox(driver);
		pt.selectCreditCheckBox(driver);
		pt.selectIpCheckBox(driver);
		pt.selectOpCheckBox(driver);
		pt.selectMhcCheckBox(driver);
		pt.clickOnSubmit(driver);
		pt.clickOnOkBtn(driver);
	}

	@Test
	public void checkThatRegistrationAmountIsReflectingSameInOpdAfterCreatingInPatientCategoryLink_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String patientType = "APL";
		String patientCategory = "FREE PT";

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		scrollToTop(driver);
		Thread.sleep(800);
		opdregistrationpage.PatientTypeDropdown(driver, patientType);
		Thread.sleep(1800);
//		opdregistrationpage.patientCategoryDropdown(driver, patientCategory);
		Thread.sleep(800);
		String ra1 = opdregistrationpage.captureRegistrationAmount(driver);
		Assert.assertEquals(ra1, "55");
		System.out.println("successfullt registration amount is verified");
	}

	@Test
	public void checkThatReRegistrationAmountIsReflectingSameInRevisitAfterCreatingInPatientTypeCategoryLink_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String hospitalNumber = "8328973";
		String patientType = "APL";
		String patientCategory = "FREE PT";
		String registrationType = "REVISIT";

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		scrollToTop(driver);
		opdregistrationpage.registrationTypeDropDown(driver, registrationType);
		opdregistrationpage.hospitalNumberText(hospitalNumber);
		Thread.sleep(3000);
		scrollToTop(driver);
		opdregistrationpage.PatientTypeDropdown(driver, patientType);
		Thread.sleep(2000);
		// opdregistrationpage.patientCategoryDropdown(driver, patientCategory);
		String ra1 = opdregistrationpage.captureRegistrationAmount(driver);
		Assert.assertEquals(ra1, "150");
		System.out.println("successfullt registration amount is verified");
	}

	@Test
	public void checkThatAdmissionAmountIsReflectingSameInPatientAdmissionAfterCreatingInPatientTypeCategoryLink_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pa = new PatientAdmissionPage(driver);

		String hospitalNumber = "8328973";
		String patientType = "APL";
		String patientCategory = "FREE P";

		pa.clickOnThePatientAdmissinButton(driver);
		hp.homeBtnForvims(driver);
		pa.hospitalNumberText(hospitalNumber);
		pa.selectPatientType(driver, patientType);
		Thread.sleep(800);
		pa.selectPatientCategory(driver, patientCategory);
		Thread.sleep(1800);
		String ca = pa.captureAdmissionCharge(driver);

		Assert.assertEquals(ca, "97");
		System.out.println("successfullt Admission charges is verified");
	}

	@Test
	public void checkPatientTypeSearchFilter_Test() throws Throwable {
		PatientTypeAndCategoryLinkPage pt = new PatientTypeAndCategoryLinkPage(driver);
		HomePage hp = new HomePage(driver);

		String patientType = "CAMP";

		pt.clickOnPatientAndCatagoryLinkScreenBtn(driver);
		hp.homeBtnForvims(driver);
		pt.selectPatientType(driver, patientType);
		pt.clickOnSearchBtn(driver);
		String patientType1 = pt.capturePatientTypeInTable(driver);
		Assert.assertEquals(patientType, patientType1, "patient type is miss matched");
		System.out.println("patient type filter is working as expected");
	}

	@Test
	public void checkPatientCategorySearchFilter_Test() throws Throwable {
		PatientTypeAndCategoryLinkPage pt = new PatientTypeAndCategoryLinkPage(driver);
		HomePage hp = new HomePage(driver);

		String patientCategory = "GENERAL";

		pt.clickOnPatientAndCatagoryLinkScreenBtn(driver);
		hp.homeBtnForvims(driver);
		pt.selectPatientCatagory(driver, patientCategory);
		pt.clickOnSearchBtn(driver);
		String patientCategory1 = pt.capturePatientCategoryInTable(driver);
		Assert.assertEquals(patientCategory, patientCategory1, "patient category is miss matched");
		System.out.println("patient category filter is working as expected");
	}

	@Test
	public void checkRateTypeSearchFilter_Test() throws Throwable {
		PatientTypeAndCategoryLinkPage pt = new PatientTypeAndCategoryLinkPage(driver);
		HomePage hp = new HomePage(driver);

		String rateType = "HOSPITAL RATE";

		pt.clickOnPatientAndCatagoryLinkScreenBtn(driver);
		hp.homeBtnForvims(driver);
		pt.selectRateType(driver, rateType);
		pt.clickOnSearchBtn(driver);
		String rateType1 = pt.capturerRateTypeInTable(driver);
		Assert.assertEquals(rateType, rateType1, "rate type is miss matched");
		System.out.println("rateType filter is working as expected");
	}

	@Test
	public void checkNextBtnIsWorkingAsExpected_pagination_Test() throws Throwable {
		PatientTypeAndCategoryLinkPage pt = new PatientTypeAndCategoryLinkPage(driver);
		HomePage hp = new HomePage(driver);

		pt.clickOnPatientAndCatagoryLinkScreenBtn(driver);
		hp.homeBtnForvims(driver);
		pt.clickOnClearBtn(driver);
		pt.verifyNextBtnIsWorkingAsExpected(driver);
	}

	@Test
	public void checkPreviousBtnIsWorkingAsExpected_pagination_Test() throws Throwable {
		PatientTypeAndCategoryLinkPage pt = new PatientTypeAndCategoryLinkPage(driver);
		HomePage hp = new HomePage(driver);

		pt.clickOnPatientAndCatagoryLinkScreenBtn(driver);
		hp.homeBtnForvims(driver);
		pt.clickOnClearBtn(driver);
		pt.verifyPreviousBtnIsWorkingAsExpected(driver);
	}

}
