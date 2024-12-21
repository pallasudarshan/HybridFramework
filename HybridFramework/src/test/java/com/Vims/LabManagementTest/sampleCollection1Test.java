
package com.Vims.LabManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;
import com.Dalvkot.Vims_ObjectRepositary.SendToLabPage;

public class sampleCollection1Test extends BaseClass {

	@Test(invocationCount = 1)
	public void checkThatUserShouldCreateSampleCollection_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("SampleCollection", 1, 1);
		String notes = eutil.getDataFromTheExcel("SampleCollection", 1, 2);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String un = futil.getProperyKeyValue("doctorUn");
		String pw = futil.getProperyKeyValue("doctorPw");
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		// ----OPD registration---------
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
	
		// ------add investigstion --------
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addTheInvestigationsFoLab(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		l.logoutTheApplication(driver);
		// ----op billing-----------
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		Thread.sleep(2000);
		hs.clickOnSubmit(driver);
		String billNumber = hs.captureBillNoUnderCompletedTab(driver);
		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollectionForOneSample(driver, hospitalNumber);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow(driver, "");
	}

	@Test
	public void verifySampleNumberInRecieptSampleAtLab_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollection_ProcessForSingleSample(driver, hospitalNumber);

		// Sample collectionS
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		String sample = sam.captureSampleNumberInTable(driver);

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// Receipt sample at lab
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);
		rsa.verifySampleNumber(driver, sample);
	}

	@Test
	public void VerifyServiceClassAndServiceTypeInViewaPopup_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 3, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.verifyServiceClassAndServiceTypeInViewPopup(driver);

	}

	@Test
	public void verifySampleCollectedText_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.verifySampleCollectedTextInTable(driver);
	}

	@Test
	public void checkThatSystemShouldDisableTheViewButtonAfterSelectingNoInSampleCollected_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// Sample collection
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.verifyBySelectingNoInSalmpleCollectedDropDown(driver);
	}

	@Test
	public void verifyThatCreatedSampleIsDisplayingInSampleCollectionList_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("SampleCollection", 1, 1);
		String notes = eutil.getDataFromTheExcel("SampleCollection", 1, 2);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String un = futil.getProperyKeyValue("doctorUn");
		String pw = futil.getProperyKeyValue("doctorPw");
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// ----OPD registration---------
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// ------add investigstion --------
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addTheInvestigationsForLab(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		l.logoutTheApplication(driver);
		// ----op billing-----------
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnBackAndVerifyCreatedSampleInTheList(driver, hospitalNumber);
	}

	/*
	 * @Test public void
	 * verifyThatUserShouldBeAbleToSubmitOnly2servicesOutOf4_Test() throws Throwable
	 * { HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
	 * DoctorDeskOpdPage(driver); Hospital_Service_Bill_page hs = new
	 * Hospital_Service_Bill_page(driver); LogOutPage l = new LogOutPage(driver);
	 * LoginPage lp = new LoginPage(driver);
	 * 
	 * String name = "S"; String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
	 * String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6); String mobilenum =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 7); String mail =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 8); String address =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 9); String pincode =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 10); String doctorname =
	 * "RAJESH SAHOO"; String depName = "OCCUPATIONAL THERAPY"; String postOffice =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 14);
	 * 
	 * 
	 * String un = futil.getProperyKeyValue("doctorUn"); String pw =
	 * futil.getProperyKeyValue("doctorPw"); String un1 =
	 * futil.getProperyKeyValue("username"); String pw1 =
	 * futil.getProperyKeyValue("password"); String notes = "testing";
	 * SampleCollectionPage sam = new SampleCollectionPage(driver);
	 * 
	 * // ----OPD registration--------- hp.homeBtnForvims(driver);
	 * OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
	 * opdregistrationpage.opdRegistrationButton(driver);
	 * 
	 * opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname,
	 * mobilenum, mail, address, pincode, postOffice, depName, doctorname); String
	 * hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
	 * 
	 * l.logoutTheApplication(driver); lp.loginToApplicationUsingDoctorLogin(un, pw,
	 * driver);
	 * 
	 * // ------add investigstion -------- hp.homeBtnForvims(driver);
	 * dp.clickOnTheDoctorDeskOpdScreenButton(driver);
	 * dp.clickOnMyPatientListTab(driver);
	 * dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
	 * dp.clickOnPatientArrivalBtnAndSave(driver);
	 * dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
	 * dp.clickOnInvestigationTab(driver);
	 * dp.clickOnNewBtnInInvestigationTab(driver); dp.scrolldown(driver);
	 * dp.addTheInvestigationsForLab1(driver, notes);
	 * dp.clickOnSubmitBtnInInvestigationsTab(driver);
	 * l.logoutTheApplication(driver);
	 * 
	 * // ----op billing----------- lp.loginToApplicationUsingDoctorLogin(un1, pw1,
	 * driver); hp.homeBtnForvims(driver);
	 * hs.clickOnHospitalServiceBillLink(driver); hs.clickonNewBillButton(driver);
	 * hs.enterHospitalNumber(hospitalNumber); hs.clickOnSubmit(driver);
	 * 
	 * hp.homeBtnForvims(driver); sam.clickOnSampleCollectionPage(driver);
	 * sam.sampleCollection1(driver, hospitalNumber);
	 * 
	 * }
	 */

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfDepartmentInTheNewSample_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("SampleCollection", 1, 1);
		String notes = eutil.getDataFromTheExcel("SampleCollection", 1, 2);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String un = futil.getProperyKeyValue("doctorUn");
		String pw = futil.getProperyKeyValue("doctorPw");
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		SearchPatientPage sp = new SearchPatientPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// ----OPD registration---------
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		hp.homeBtnForvims(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// ------add investigstion --------
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addTheInvestigationsForLab(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		l.logoutTheApplication(driver);

		// ----op billing-----------
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		Thread.sleep(2000);
		hs.clickOnSubmit(driver);
		// -----sample collection--------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.selectDepartment(driver, depName);
		sam.clickOn_Search_Button_NewSamples(driver);
		String departmentName = sam.takeDepartmentIn_SelectinCreteriaTable(driver);
		Assert.assertEquals(departmentName, depName);
		System.out.println("User verified department successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfBillTypeInTheNewSample_Test() throws Throwable {

		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		String billType = hs.takeBillType_CompletedTable(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.selectBillTypeFilter(driver, billType);
		sam.clickOn_Search_Button_NewSamples(driver);
		String hospitalNumber1 = sam.takeHospitalNumber_SelectionCreteria(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber1);

	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfBillDateInTheNewSample_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);
		JavaUtility j = new JavaUtility();
		String billDate = j.currentDate();

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		hp.homeBtnForvims(driver);
		sam.enterBillDate(driver, billDate);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billDate1 = sam.takeBillDate_SelectioncreteriaTable(driver);
		Assert.assertEquals(billDate1, billDate);
		System.out.println("Bill date verified successfully");

	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfBillNumberInTheNewSample_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		String billNumber = hs.takeBillNumber_CompletedTable_ScrollUp(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		hp.homeBtnForvims(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber1 = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		Assert.assertEquals(billNumber1, billNumber);
		System.out.println("Bill number verified successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfHospitalNumberInTheNewSample_Test()
			throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		hp.homeBtnForvims(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String hospitaNumber1 = sam.takeHospitalNumber_SelectionCreteria(driver);
		Assert.assertEquals(hospitaNumber1, hospitalNumber);
		System.out.println("User verified hospital number successfully");

	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfBillTypeInTheListTable_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 4, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		String billType = hs.takeBillType_CompletedTable(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.selectBillTypeFilter(driver, billType);
		sam.clickOnSearchButton_ListTable(driver);
		String hospitalNumber1 = sam.takeHospitalName_ListTable(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("User verified hospital number successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfServiceClassInTheListTable_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 4, 1);
		String serviceClass = eutil.getDataFromTheExcel("SampleCollection", 5, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.selectServiceClassFilter(driver, serviceClass);
		sam.clickOnSearchButton_ListTable(driver);
		String serviceClass1 = sam.takeServiceClass_ListTable(driver);
		Assert.assertEquals(serviceClass1, serviceClass);
		System.out.println("User verified service class  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfSampleDatesInTheListTable_Test() throws Throwable {

		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);
		JavaUtility j = new JavaUtility();
		String sampleDate = j.currentDate();

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		// ----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.enterSampleDateFilter(driver, sampleDate);
		sam.clickOnSearchButton_ListTable(driver);
		String sampleDate1 = sam.takeSampleDate_ListTable(driver);
		Assert.assertEquals(sampleDate1, sampleDate1);
		System.out.println("User verified sample date   successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfHospitalNumberInTheListTable_Test()
			throws Throwable {

		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		String hospitalNumber1 = sam.takeHospitalName_ListTable(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber1);
		System.out.println("User verified hospitalNumber  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfBillNumberInTheListTable_Test() throws Throwable {
		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		sam.clickonAllViewbuttons_submit(driver);
		// Sample collection Listtable
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOnSearchButton_ListTable(driver);
		String billNumber1 = sam.takeBillNumber_ListTable(driver);
		Assert.assertEquals(billNumber1, billNumber);
		System.out.println("User verified bill Number  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfPatientNameInTheListTable_Test() throws Throwable {

		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		String patientName = hs.takePatientName_CompletedList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		sam.clickonAllViewbuttons_submit(driver);
		// Sample collection Listtable
		sam.clickOnBackButton(driver);
		sam.enterPatientNameFilter(driver, patientName);
		sam.clickOnSearchButton_ListTable(driver);
		String patientName1 = sam.takePatientName_ListTable();
		Assert.assertEquals(patientName1, patientName);
		System.out.println("User verified patient name successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfSampleNumberInTheListTable_Test() throws Throwable {

		String serviceName = eutil.getDataFromTheExcel("SampleCollection", 2, 1);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollectionFor_Updated_BillNumber(driver, hospitalNumber);

		// Sample collection Listtable
		sam.clickOnBackButton(driver);
		sam.enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		String sampleNumber = sam.takeSampleNumber_ListTable(driver);
		sam.clickOnSearchButton_ListTable(driver);
		String sampleNumber1 = sam.takeSampleNumber_ListTable(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
		System.out.println("User verified sample Number  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfHospitalNumberInTheCancelledList_Test()
			throws Throwable {

		String name = eutil.getDataFromTheExcel("SampleCollection", 1, 1);
		String notes = eutil.getDataFromTheExcel("SampleCollection", 1, 2);
		String receivedAtLab = eutil.getDataFromTheExcel("SampleCollection", 6, 1);
		String rejectReason = eutil.getDataFromTheExcel("SampleCollection", 6, 2);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String un = futil.getProperyKeyValue("doctorUn");
		String pw = futil.getProperyKeyValue("doctorPw");
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// ------add investigstion --------
		dp.addTheInvestigationForOPProcess(driver, hospitalNumber, notes);
		l.logoutTheApplication(driver);
		// ----op billing-----------
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollectionFor_Updated_BillNumber(driver, hospitalNumber);
		// receipt sample at lab
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.selectAllSamplesInTheTable(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.selectRejectReason_AllDropdownsButtons(driver, rejectReason);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		// sample cllection
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnCancelledListTab(driver);
		sam.enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		String hospitalNumber1 = sam.takeHospitalNumber_CancelledListTable(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("User verified hospital Number  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfBillTypeInTheCancelledList_Test() throws Throwable {

		String sn1 = eutil.getDataFromTheExcel("SampleCollection", 4, 1);
		String sn2 = eutil.getDataFromTheExcel("SampleCollection", 7, 1);
		String sn3 = eutil.getDataFromTheExcel("SampleCollection", 7, 2);
		String receivedAtLab = eutil.getDataFromTheExcel("SampleCollection", 6, 1);
		String rejectReason = eutil.getDataFromTheExcel("SampleCollection", 6, 2);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		String billType = hs.takeBillType_CompletedTable(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickOnViewButtons_And_ClickOnSubmit(driver);
		// receipt sample at lab
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);
		rsa.receivedSampleAtLab_Reject_Process(driver, serviceClass, hospitalNumber, receivedAtLab, rejectReason);
		// sample cllection
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnCancelledListTab(driver);
		sam.selectBillTypeFilter(driver, billType);
		sam.enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		String hospitalNumber1 = sam.takeHospitalNumber_CancelledListTable(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("User verified bill type  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfServiceClassInTheCancelledList_Test()
			throws Throwable {

		String sn1 = eutil.getDataFromTheExcel("SampleCollection", 4, 1);
		String sn2 = eutil.getDataFromTheExcel("SampleCollection", 7, 1);
		String sn3 = eutil.getDataFromTheExcel("SampleCollection", 7, 2);
		String receivedAtLab = eutil.getDataFromTheExcel("SampleCollection", 6, 1);
		String rejectReason = eutil.getDataFromTheExcel("SampleCollection", 6, 2);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickOnViewButtons_And_ClickOnSubmit(driver);

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// receipt sample at lab
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);
		rsa.receivedSampleAtLab_Reject_Process(driver, serviceClass, hospitalNumber, receivedAtLab, rejectReason);

		// sample cllection
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnCancelledListTab(driver);
		sam.selectServiceClassFilter(driver, serviceClass);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		String serviceClass1 = sam.takeServiceClass_CancelledListTable(driver);
		Assert.assertEquals(serviceClass1, serviceClass);
		System.out.println("User verified service class  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfSampleDatesInTheCancelledList_Test()
			throws Throwable {

		String sn1 = eutil.getDataFromTheExcel("SampleCollection", 4, 1);
		String sn2 = eutil.getDataFromTheExcel("SampleCollection", 7, 1);
		String sn3 = eutil.getDataFromTheExcel("SampleCollection", 7, 2);
		String receivedAtLab = eutil.getDataFromTheExcel("SampleCollection", 6, 1);
		String rejectReason = eutil.getDataFromTheExcel("SampleCollection", 6, 2);
		JavaUtility j = new JavaUtility();
		String sampleDate = j.currentDate();
		String sDate = j.currentDate_yyyymmdd();

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickOnAllViewButtons_And_Submit(driver);

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// receipt sample at lab
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);
		rsa.receivedSampleAtLab_Reject_Process(driver, serviceClass, hospitalNumber, receivedAtLab, rejectReason);

		// sample cllection
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnCancelledListTab(driver);
		sam.enterSampleDateFilter(driver, sampleDate);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		sam.takeSampleDates_CancelledListTable(driver, sDate);
		System.out.println("User filtered sample details with help of sample dates  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfSampleNumberInTheCancelledList_Test()
			throws Throwable {
		String sn1 = eutil.getDataFromTheExcel("SampleCollection", 4, 1);
		String sn2 = eutil.getDataFromTheExcel("SampleCollection", 7, 1);
		String sn3 = eutil.getDataFromTheExcel("SampleCollection", 7, 2);
		String receivedAtLab = eutil.getDataFromTheExcel("SampleCollection", 6, 1);
		String rejectReason = eutil.getDataFromTheExcel("SampleCollection", 6, 2);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		// OP billing

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------

		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickOnAllViewButtons_And_Submit(driver);

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// receipt sample at lab
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.selectServiceClassDropdown(driver, serviceClass);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		String sampleNumber = rsa.takeSampleNumber_SampleListTable(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.selectRejectReason_AllDropdownsButtons(driver, rejectReason);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// sample cllection
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnCancelledListTab(driver);
		sam.selectServiceClassFilter(driver, serviceClass);
		sam.enterSampleNumberFilter(driver, sampleNumber);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		String sampleNumber1 = sam.takeSampleNumberInCancelledList(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
		System.out.println("User filtered sample details with help of sample number  successfully");
	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfBillNumberInTheCancelledList_Test()
			throws Throwable {
		String sn1 = eutil.getDataFromTheExcel("SampleCollection", 4, 1);
		String sn2 = eutil.getDataFromTheExcel("SampleCollection", 7, 1);
		String sn3 = eutil.getDataFromTheExcel("SampleCollection", 7, 2);
		String receivedAtLab = eutil.getDataFromTheExcel("SampleCollection", 6, 1);
		String rejectReason = eutil.getDataFromTheExcel("SampleCollection", 6, 2);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		// OP billing
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickonAllViewbuttons_submit(driver);

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// receipt sample at lab
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.selectServiceClassDropdown(driver, serviceClass);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.selectRejectReason_AllDropdownsButtons(driver, rejectReason);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// sample cllection
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnCancelledListTab(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.selectServiceClassFilter(driver, serviceClass);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		String billNumber1 = sam.takeBillNumber_CancelledListTable(driver);
		Assert.assertEquals(billNumber1, billNumber);
		System.out.println("User filtered sample details with help of bill  number  successfully");

	}

	@Test
	public void checkThatUserShouldSearchTheSampleDetailsWithHelpOfPatientNameInTheCancelledList_Test()
			throws Throwable {
		String sn1 = eutil.getDataFromTheExcel("SampleCollection", 4, 1);
		String sn2 = eutil.getDataFromTheExcel("SampleCollection", 7, 1);
		String sn3 = eutil.getDataFromTheExcel("SampleCollection", 7, 2);
		String receivedAtLab = eutil.getDataFromTheExcel("SampleCollection", 6, 1);
		String rejectReason = eutil.getDataFromTheExcel("SampleCollection", 6, 2);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		// OP billing
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String billNumber = sam.takeLastRowBillNumberThe_SelectionCreteriaTable(driver);
		sam.enterBillNumberFilter(driver, billNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		String patientName = sam.takeLastRowPatientName_SelectionCreteria(driver);
		sam.clickonAllViewbuttons_submit(driver);

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);
		// receipt sample at lab
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.selectServiceClassDropdown(driver, serviceClass);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.selectRejectReason_AllDropdownsButtons(driver, rejectReason);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// sample cllection
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnCancelledListTab(driver);
		sam.enterPatientNameFilter(driver, patientName);
		sam.selectServiceClassFilter(driver, serviceClass);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		String patientName1 = sam.takePatientName_CancelledListTable(driver);
		Assert.assertEquals(patientName1, patientName);
		System.out.println("User filtered sample details with help of patient name  successfully");
	}

}
