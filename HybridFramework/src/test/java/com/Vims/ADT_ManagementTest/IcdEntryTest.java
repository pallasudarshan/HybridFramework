package com.Vims.ADT_ManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.IcdEntryPage;

public class IcdEntryTest extends BaseClass {
	@Test
	public void checkThatUserIsAbleToAddDiagnosis_Urban_IcdEntry_Test() throws Throwable {
		String icdCode = "icd";
		String codeDescription = "Paratyphoid fever A";
		String categoryType = "Urban";

		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnClear(driver);
		icdEntryPage.selectCategoryType(driver, categoryType);
		icdEntryPage.clickOnSearch(driver);
		String hospitalNumber = icdEntryPage.captureHospitalNumber_Table_PendingList(driver);
		TestData.setHospitalNumber(hospitalNumber);
		icdEntryPage.clickOnAddDiagnosis_Table(driver);
		icdEntryPage.addDiagnosis(driver, icdCode, codeDescription);
		icdEntryPage.clickOnSubmit(driver);
		String text = icdEntryPage.captureTextAndClickOnOkbtn(driver);
		Assert.assertEquals(text, "Successfully created diagnosis");
	}

	@Test(dependsOnMethods = "checkThatUserIsAbleToAddDiagnosis_Urban_IcdEntry_Test")
	public void checkThatHospitalNumberIsReflectingInCompletedListAfterDiagnosisIsAdded_Test() throws Throwable {

		String hospitalNumber = TestData.getHospitalNumber();

		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnCompletedListTab(driver);
		icdEntryPage.enterHospitalNumber(driver, hospitalNumber);
		icdEntryPage.clickOnSearch(driver);
		String hospitalNumber1 = icdEntryPage.captureHospitalNumber_Table_CompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkNextBtnPagination_PendingList_IcdEntry_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnClear(driver);
		icdEntryPage.verifyNextBtnIsWorkingAsExpected_PendingList(driver);
	}

	@Test
	public void checkPreviousBtnPagination_PendingList_IcdEntry_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnClear(driver);
		icdEntryPage.verifyPreviousBtnIsWorkingAsExpected_PendingList(driver);
	}

	@Test
	public void checkThatUserIsAbleToAddDiagnosis_Rural_IcdEntry_Test() throws Throwable {
		String icdCode = "icd";
		String codeDescription = "Paratyphoid fever A";
		String categoryType = "Rural";

		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnClear(driver);
		icdEntryPage.selectCategoryType(driver, categoryType);
		icdEntryPage.clickOnSearch(driver);
		icdEntryPage.clickOnAddDiagnosis_Table(driver);
		icdEntryPage.addDiagnosis(driver, icdCode, codeDescription);
		icdEntryPage.clickOnSubmit(driver);
		String text = icdEntryPage.captureTextAndClickOnOkbtn(driver);
		Assert.assertEquals(text, "Successfully created diagnosis");
	}

	@Test
	public void checkDepartmentSearchFilter_PendingList_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnClear(driver);
		String dep = icdEntryPage.captureLastRowDepartment_Table_PendingList(driver);
		icdEntryPage.selectDepartment(driver, dep);
		icdEntryPage.clickOnSearch(driver);
		String dep1 = icdEntryPage.captureLastRowDepartment_Table_PendingList(driver);
		Assert.assertEquals(dep, dep1);
	}

	@Test
	public void checkHospitalNumberSearchFilter_PendingList_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		String hs = icdEntryPage.captureLastRowHospitalNumber_Table_PendingList(driver);
		icdEntryPage.enterHospitalNumber(driver, hs);
		icdEntryPage.clickOnSearch(driver);
		String hs1 = icdEntryPage.captureLastRowHospitalNumber_Table_PendingList(driver);
		Assert.assertEquals(hs, hs1);
	}

	@Test
	public void checkDepartmentSearchFilter_CompletedList_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnCompletedListTab(driver);
		String dep = icdEntryPage.captureLastRowDepartment_Table_CompletedList(driver);
		icdEntryPage.selectDepartment(driver, dep);
		icdEntryPage.clickOnSearch(driver);
		String dep1 = icdEntryPage.captureLastRowDepartment_Table_CompletedList(driver);
		Assert.assertEquals(dep, dep1);
	}

	@Test
	public void checkHospitalNumberSearchFilter_CompletedListList_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		IcdEntryPage icdEntryPage = new IcdEntryPage(driver);

		icdEntryPage.clickOnIcdEntryScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		icdEntryPage.clickOnCompletedListTab(driver);
		String hs = icdEntryPage.captureLastRowHospitalNumber_Table_CompletedList(driver);
		icdEntryPage.enterHospitalNumber(driver, hs);
		icdEntryPage.clickOnSearch(driver);
		String hs1 = icdEntryPage.captureLastRowHospitalNumber_Table_CompletedList(driver);
		Assert.assertEquals(hs, hs1);
	}

	/*
	 * @Test public void checkNextBtnPagination_CompletedList_IcdEntry_Test() throws
	 * Throwable { HomePage hp = new HomePage(driver); IcdEntryPage ic = new
	 * IcdEntryPage(driver);
	 * 
	 * ic.clickOnIcdEntryScreenBtn(driver); hp.homeBtnForvims(driver);
	 * ic.clickOnCompletedListTab(driver);
	 * ic.verifyNextBtnIsWorkingAsExpected_CompletedList(driver); }
	 * 
	 * @Test public void checkPreviousBtnPagination_CompletedList_IcdEntry_Test()
	 * throws Throwable { HomePage hp = new HomePage(driver); IcdEntryPage ic = new
	 * IcdEntryPage(driver);
	 * 
	 * ic.clickOnIcdEntryScreenBtn(driver); hp.homeBtnForvims(driver);
	 * ic.clickOnCompletedListTab(driver);
	 * ic.verifyPreviousBtnIsWorkingAsExpected_CompletedList(driver); }
	 */

}
