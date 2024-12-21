package com.Vims.RadiologyTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.RadiologyRegistrationListPage;
import com.Dalvkot.Vims_ObjectRepositary.modalityConfirmationPage;

public class ModaliltyConfirmationTest extends BaseClass {

	@Test
	public void checkHospitalNumberSearchFilter_PendingList_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		modalityConfirmationPage mc = new modalityConfirmationPage(driver);

		mc.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);
		mc.clickOnClearButton(driver);
		String hsp = mc.take_HospitalNumber_LastRow_Pending(driver);
		mc.enterHospitalNumber_Filter(driver, hsp);
		mc.clickOnSearch_Button_Filter(driver);
		String hsp1 = mc.take_HospitalNumber_Pending(driver);
		Assert.assertEquals(hsp, hsp1);
	}

	@Test
	public void checkServiceClassSearchFilter_PendingList_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		modalityConfirmationPage mc = new modalityConfirmationPage(driver);

		mc.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);
		mc.clickOnClearButton(driver);
		mc.clickOnRegistrationNumber_LastRow(driver);
		String serviceClass = mc.captureServiceClass_Popup(driver);
		mc.clickOnXbtn_popup(driver);
		mc.selectServiceClass(driver, serviceClass);
		mc.clickOnSearch_Button_Filter(driver);
		mc.clickOnRegistrationNumber(driver);
		String serviceClass1 = mc.captureServiceClass_Popup(driver);
		mc.clickOnXbtn_popup(driver);
		Assert.assertEquals(serviceClass, serviceClass1);
	}

	@Test
	public void checkThatUserShouldbeFilterTheIpPatientDetailsInThe_PendingList_WithHelpOf_BillType_Test()
			throws Throwable {
		String billType = "IP";

		HomePage homePage = new HomePage(driver);
		modalityConfirmationPage modalityconfirmationPage = new modalityConfirmationPage(driver);
		RadiologyRegistrationListPage radiologyRegistrationListPage = new RadiologyRegistrationListPage(driver);

		radiologyRegistrationListPage.clickOnRadiologyRegistrationScreenBtn(driver);
		homePage.homeBtnForvims(driver);
		radiologyRegistrationListPage.clickOnCompletedTab(driver);
		radiologyRegistrationListPage.clickOnClearBtn(driver);
		radiologyRegistrationListPage.selectBillType_Filter(driver, billType);
		radiologyRegistrationListPage.clickOnSearchBtn(driver);
		String hospitalNumber = radiologyRegistrationListPage.captureHospitalNumberInTable_CompletedList(driver);
		modalityconfirmationPage.clickOnModalityConfirmation(driver);
		homePage.homeBtnForvims(driver);
		modalityconfirmationPage.clickOnClearButton(driver);
		modalityconfirmationPage.selectBillType_Filter(driver, billType);
		modalityconfirmationPage.enterHospitalNumber_Filter(driver, hospitalNumber);
		modalityconfirmationPage.clickOnSearch_Button_Filter(driver);
		String hospitalNumber1 = modalityconfirmationPage.captureHospitalNumber_PendingList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserFilterThe_CompletedDetails_WithHelpOf_HospitalNumber_Test() throws Throwable {

		modalityConfirmationPage mp = new modalityConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		mp.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);

		mp.clickOnClearButton(driver);
		String hospitalNumber = mp.take_HospitalNumber_Pending(driver);
		mp.clickOnRegistrationNumber(driver);
		mp.clickOnSubmit(driver);
		mp.clickOnOkBtn(driver);

		mp.clickOn_CompleteTab(driver);
		mp.enterHospitalNumber_Filter(driver, hospitalNumber);
		mp.clickOnSearch_Button_Filter(driver);
		String hospitalNumber1 = mp.captureHospitalNumber_CompletedList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserFilterThe_CompletedDetails_WithHelpOf_ServiceClass_Test() throws Throwable {
		String serviceClass = "CT SCAN";

		modalityConfirmationPage mp = new modalityConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		mp.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);

		mp.clickOnClearButton(driver);
		mp.selectServiceClass(driver, serviceClass);
		mp.clickOnSearch_Button_Filter(driver);
		String hospitalNumber = mp.take_HospitalNumber_Pending(driver);
		mp.clickOnRegistrationNumber(driver);
		mp.clickOnSubmit(driver);
		mp.clickOnOkBtn(driver);

		mp.clickOn_CompleteTab(driver);
		mp.enterHospitalNumber_Filter(driver, hospitalNumber);
		mp.clickOnSearch_Button_Filter(driver);
		String hospitalNumber1 = mp.captureHospitalNumber_CompletedList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatSerachThePendingHospitalNumberInTHeCompletedList_Test() throws Throwable {

		String msg = "Details is not found";

		modalityConfirmationPage mp = new modalityConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		mp.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);

		mp.clickOnClearButton(driver);
		String hospitalNumber = mp.take_HospitalNumber_LastRow_Pending(driver);

		mp.clickOn_CompleteTab(driver);
		mp.enterHospitalNumber_Filter(driver, hospitalNumber);
		mp.clickOnSearch_Button_Filter(driver);
		String msg1 = mp.capture_OkpopupMessage(driver);
		mp.clickOnOkBtn(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test
	public void checkThatUserFilterThe_CompletedDetails_WithHelpOf_BillType_Test() throws Throwable {
		String billType = "IP";
		modalityConfirmationPage mp = new modalityConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		mp.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);
		mp.clickOnClearButton(driver);
		mp.selectBillType_Filter(driver, billType);
		mp.clickOnSearch_Button_Filter(driver);
		String hospitalNumber = mp.take_HospitalNumber_Pending(driver);
		mp.clickOnRegistrationNumber(driver);
		mp.clickOnSubmit(driver);
		mp.clickOnOkBtn(driver);

		mp.clickOn_CompleteTab(driver);
		mp.selectBillType_Filter(driver, billType);
		mp.enterHospitalNumber_Filter(driver, hospitalNumber);
		mp.clickOnSearch_Button_Filter(driver);
		String hospitalNumber1 = mp.captureHospitalNumber_CompletedList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

}
