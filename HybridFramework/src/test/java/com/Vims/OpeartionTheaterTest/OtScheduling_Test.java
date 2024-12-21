package com.Vims.OpeartionTheaterTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.otConfirmationPage;

public class OtScheduling_Test extends BaseClass {

	@Test
	public void OtScedulingForOp_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ot = new OTSchedulingPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		hp.homeBtnForvims(driver);
		ot.clickOnOtScenduleScreenLink(driver);
		ot.clickOnTheAddBtn(driver);
		ot.enterHospitalNumber(driver, hospitalNumber);
	}

	@Test(priority = 1)
	public void verifyOperationThreaterErrorMsg_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Opertaion Theater Name");
		System.out.println("successfully operation theatre error msg is verifed");
		TestData.setHospitalNumber(hospitalNumber);
	}

	@Test(priority = 2)
	public void verifySurgeryTypeErrorMsg_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String department = "GENERAL MEDICINE";

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Select Surgery Type");
		System.out.println("successfully surgery Type error msg is verifed");
	}

	@Test(priority = 3)
	public void verifySurgeryNatureErrorMsg_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.selectSurgeryTypeInOtScheduling(driver, surgeryType);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Select Surgery Nature");
		System.out.println("successfully surgery nature error msg is verifed");
	}

	@Test(priority = 4)
	public void verifySurgeryTimeErrorMsg_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.selectSurgeryTypeInOtScheduling(driver, surgeryType);
		ots.selectSurgeryNatureInOtScheduling(driver, surgeryNature);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Select Surgery Time");
		System.out.println("successfully surgery time error msg is verifed");
	}

	@Test(priority = 5)
	public void verifyDurationErrorMsg_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String surgeryTime = "1212pm";
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.selectSurgeryTypeInOtScheduling(driver, surgeryType);
		ots.selectSurgeryNatureInOtScheduling(driver, surgeryNature);
		ots.enterSurgeryTime(driver, surgeryTime);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Enter Duration");
		System.out.println("successfully duration error msg is verifed");
	}

	@Test(priority = 6)
	public void verifyAnastesiaTypeErrorMsg_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String surgeryTime = "1212pm";
		String duration = "8";
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.selectSurgeryTypeInOtScheduling(driver, surgeryType);
		ots.selectSurgeryNatureInOtScheduling(driver, surgeryNature);
		ots.enterSurgeryTime(driver, surgeryTime);
		ots.enterduration(driver, duration);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Select Anasthesia Type");
		System.out.println("successfully anasthesia type error msg is verifed");
	}

	@Test(priority = 7)
	public void verifySpecialNotesErrorMsg_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String surgeryTime = "1212pm";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String diagnosis = "testing";
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.selectSurgeryTypeInOtScheduling(driver, surgeryType);
		ots.selectSurgeryNatureInOtScheduling(driver, surgeryNature);
		ots.enterSurgeryTime(driver, surgeryTime);
		ots.enterduration(driver, duration);
		ots.selectAnastesiaTypeInOtScheduling(driver, anastesiaType);
		ots.enterDisgosis(driver, diagnosis);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Enter special Notes");
		System.out.println("successfully special notes error msg is verifed");
	}

	@Test(priority = 8)
	public void verifyDiagnosisErrorMsg_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String surgeryTime = "1212pm";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.selectSurgeryTypeInOtScheduling(driver, surgeryType);
		ots.selectSurgeryNatureInOtScheduling(driver, surgeryNature);
		ots.enterSurgeryTime(driver, surgeryTime);
		ots.enterduration(driver, duration);
		ots.selectAnastesiaTypeInOtScheduling(driver, anastesiaType);
		ots.enterSpecialNotes(driver, specialNotes);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Enter diagnosis");
		System.out.println("successfully Disgnosis error msg is verifed");
	}

	@Test(priority = 9)
	public void verifySurgeryDeatailsErrorMsg_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String surgeryTime = "1212pm";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String diagnosis = "Testing";
		String department = "GENERAL MEDICINE";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.selectSurgeryTypeInOtScheduling(driver, surgeryType);
		ots.selectSurgeryNatureInOtScheduling(driver, surgeryNature);
		ots.enterSurgeryTime(driver, surgeryTime);
		ots.enterduration(driver, duration);
		ots.selectAnastesiaTypeInOtScheduling(driver, anastesiaType);
		ots.enterDisgosis(driver, diagnosis);
		ots.enterSpecialNotes(driver, specialNotes);
		ots.clickOnSubmit(driver);
		String errorMsg = ots.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Enter Surgery Details");
		System.out.println("successfully surgery details error msg is verifed");
	}

	@Test(priority = 10)
	public void verifyByEnteringMoreThan10HrInDurationField_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		String hospitalNumber = TestData.getHospitalNumber();
		String duration = "11";
		String department = "GENERAL MEDICINE";

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.enterduration(driver, duration);
		String msg = ots.verifyMoreThan10HrInDurationField(driver);
		Assert.assertEquals(msg, "Duration is more than 10 hours");
		System.out.println("successfully Duration is more than 10 hours msg is verifed");
	}

	@Test(priority = 11)
	public void verifyPopUPBySelectingDifferentDepartment_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String department = "cardiology";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		String msg = ots.verifyMsgbyselectingDifferentDepartment(driver);
		Assert.assertEquals(msg, "Doctor consultation for the department CARDIOLOGY not available within 24 hours");
		System.out.println("successfully erro msg is verifed by selecting different department");
	}

	@Test(priority = 12)
	public void clickOnAddWithoutSelectingMandatoryDataInSurgeryDetails_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String department = "GENERAL MEDICINE";
		String dep_surgeryDetails = "CARDIOLOGY";
		String description_SugeryDetails = "CARDIAC SURG";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectDepartment_surgeryDetails(driver, dep_surgeryDetails);
		ots.selectSurgeryDescription_surgeryDetails(driver, description_SugeryDetails);
		ots.clickOnAddLineItem_surgeryDetails(driver);
		ots.clickOnAddLineItem_SurgeryDetailspopUP(driver);
		String errorMsg = ots.verifyMandatoryFieldErrorMsg(driver);

		Assert.assertEquals(errorMsg, "Please Fill The Mandatory Field");
		System.out.println("successfully Please Fill The Mandatory Field msg is verified");
	}

	@Test(priority = 13)
	public void clickOnAddWithoutSelectingMandatoryDataInSpecialInstrument_Test() throws Throwable {
		String department = "GENERAL MEDICINE";
		String dep_surgeryDetails = "CARDIOLOGY";
		String description_SugeryDetails = "CARDIAC SURG";
		String hospitalNumber = TestData.getHospitalNumber();

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectDepartment_surgeryDetails(driver, dep_surgeryDetails);
		ots.selectSurgeryDescription_surgeryDetails(driver, description_SugeryDetails);
		ots.clickOnAddLineItem_surgeryDetails(driver);
		ots.clickOnSpecialInstrumentTab(driver);
		ots.clickOnAddLineItem_SpecialInstrumentpopUP(driver);
		String errorMsg = ots.verifyMandatoryFieldErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please fill the Mandatory Feild..!");
		System.out.println("successfully Please Fill The Mandatory Field msg is verified");
	}

	@Test(priority = 1)
	public void verifyPLeaseEnterSugeonDetailsPopUP_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String department = "GENERAL MEDICINE";
		String dep_surgeryDetails = "CARDIOLOGY";
		String description_SugeryDetails = "CARDIAC SURG";

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);
		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectDepartment_surgeryDetails(driver, dep_surgeryDetails);
		ots.selectSurgeryDescription_surgeryDetails(driver, description_SugeryDetails);
		ots.clickOnAddLineItem_surgeryDetails(driver);
		ots.clickOnSubmit_SurgeryDetailsPopPU(driver);
		String errorMsg = ots.capturePleaseEnterSurgonDetails_msg(driver);
		Assert.assertEquals(errorMsg, "Please enter surgeon details.");
		System.out.println("successfully Please enter surgeon details msg is verified");
	}

	@Test(priority = 2)
	public void verifyDeleteBtnIsWorkingAsExpected_SurgeryDetailsPopUp_Test() throws Throwable {
		String dep_surgeryDetails = "CARDIOLOGY";
		String description_SugeryDetails = "CARDIAC SURG";
		String doctorCatagory = "CARDIOLOGIST";
		String consultantName = "VIJAYA";
		String department = "General medicine";
		String hospitalNumber = TestData.getHospitalNumber();

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectDepartment_surgeryDetails(driver, dep_surgeryDetails);
		ots.selectSurgeryDescription_surgeryDetails(driver, description_SugeryDetails);
		ots.clickOnAddLineItem_surgeryDetails(driver);
		ots.scrollDown(driver);
		ots.scrollDown(driver);
		ots.addLineItems_surgeryDetailsPopup(driver, doctorCatagory, consultantName);
		ots.deleteLineItems_surgeryDetailsPopup(driver);
		ots.verifyDeleteBtnIsVisibleOrnot_SurgeryDetailsPopUP(driver);
	}

	@Test(priority = 3)
	public void verifyDeleteBtnIsWorkingAsExpected_SpecialInstrumentPopUp_Test() throws Throwable {
		String department = "GENERAL MEDICINE";
		String dep_surgeryDetails = "CARDIOLOGY";
		String description_SugeryDetails = "CARDIAC SURG";
		String instrumentName = "loreum ipsum";
		String description = "C-ARM";
		String quantity = "4";
		String rate = "5002";
		String hospitalNumber = TestData.getHospitalNumber();

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectDepartment_surgeryDetails(driver, dep_surgeryDetails);
		ots.selectSurgeryDescription_surgeryDetails(driver, description_SugeryDetails);
		ots.clickOnAddLineItem_surgeryDetails(driver);
		ots.clickOnSpecialInstrumentTab(driver);
		ots.scrollDown(driver);
		ots.scrollDown(driver);
		ots.addLineItems_specialInstrument(driver, instrumentName, description, quantity, rate);
		ots.deleteLineItems_specialInstrument(driver);
		ots.verifyDeleteBtnIsVisibleOrnot_SpecailInstrumentPopUP(driver);
	}

	@Test(priority = 4)
	public void verifyThatPopUPIsDisplayedAfterAddingLineItemsUnderSurgeryDetails_Test() throws Throwable {
		String department = "GENERAL MEDICINE";
		String dep_surgeryDetails = "CARDIOLOGY";
		String description_SugeryDetails = "CARDIAC SURG";
		String hospitalNumber = TestData.getHospitalNumber();

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectDepartment_surgeryDetails(driver, dep_surgeryDetails);
		ots.selectSurgeryDescription_surgeryDetails(driver, description_SugeryDetails);
		ots.clickOnAddLineItem_surgeryDetails(driver);
		String text = ots.captureSpecialInstrumentTextInThePopUP(driver);
		Assert.assertEquals(text, "Special Instrument");
		System.out.println("successfully pop up is displaying after adding line item under surgery details");
	}

	@Test
	public void checkThatUser_CancelThe_OtScheduling_And_VerifyTheStausinTheOtList_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String department = "GENERAL MEDICINE";
		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String surgeryTime = "1212pm";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "TEST";
		String doctorCategory = "CARDIOLOGIST";
		String consultantName = "VIJAYA SAI";
		String instrumentName = "Test";
		String description = "CAMRA CASE";
		String quantity = "12";
		String rate = "12";
		String diagnosis = "testtest";
		String depart = "CARDIOLOGY";
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.otScheduling_Process(driver, operationTheater, surgeryType, surgeryNature, surgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduling_ProcessTwo(driver, depart, surgeryDescription, doctorCategory, consultantName, instrumentName,
				description, quantity, rate, diagnosis);
		ots.clickOnOtScenduleScreenLink(driver);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);

	}

	@Test
	public void verifyOtScheduleProcessForIp_Test() throws Throwable {
		String bedCategory = "NON TEACHING";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION DISEASE ROOM";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String admittedByDr = "DR.ABBAS";
		String time = "1230pm";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("doctornameNeurology");
		String depName = futil.getProperyKeyValue("depNameNeurology");
		String operationTheater = "OPERATION THEATER 1";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200pm";
		String duration = "8";
		String anastesiaType = "LOCAL";
		String specialNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String dep = "CARDIOLOGY";
		String surgeryDescription = "CAR GEn SURG";
		String doctorCatagory = "CARDIOLOGIST";
		String consultantName = "DR.VIJAYA SAI";
		String diagnosis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String date = jutil.currentDate();

		HomePage hp = new HomePage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);
		// -------- patientAdmission-------
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumber(driver, hospitalNumber);
		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCatagory, consultantName, diagnosis);
		ots.clickOnOtListTab(driver);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);
		String hospitalNumber1 = ots.captureLastRowHospitalNumber(driver);
		String roomType1 = ots.captureRoomTypeInTable_OtList(driver);
		String wardType1 = ots.captureWardTypeInTable_OtList(driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("successfully hospital number verified");
		softAssert.assertEquals(bedRoomType, roomType1);
		System.out.println("successfully room type verified");
		softAssert.assertEquals(bedWardType, wardType1);
		System.out.println("successfully ward type verified");
		softAssert.assertAll();
	}

	@Test
	public void verifyThatUserShouldGetPatientNotAdmittedPopupIfTryToConfirmNotAdmittedPatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String department = "GENERAL MEDICINE";

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);

		String operationTheater = "OPERATION THEATER 1";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200pm";
		String duration = "8";
		String anastesiaType = "LOCAL";
		String specialNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String dep = "CARDIOLOGY";
		String surgeryDescription = "CAR GEn SURG";
		String doctorCatagory = "CARDIOLOGIST";
		String consultantName = "DR.VIJAYA SAI";
		String diagnosis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String date = jutil.currentDate();

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCatagory, consultantName, diagnosis);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);
		ots.clickOnHospitalNumber_OtList(driver);
		String text = ots.capturePatientNotAdmittedPopUp(driver);
		ots.clickOnOkBtn(driver);

		Assert.assertEquals(text, "Patient is not admitted!");
		System.out.println("successfully pop-up is verified");
	}

	@Test(dependsOnMethods = "verifyThatUserShouldGetPatientNotAdmittedPopupIfTryToConfirmNotAdmittedPatient_Test")
	public void CheckThatOtConfirmationIsDoneAfterPatientIsAdmitted_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		BedMasterPage bp = new BedMasterPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		String hospitalNumber = TestData.getHospitalNumber();

		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String bedCategory = "NON TEACHING";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION DISEASE ROOM";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String admittedByDr = "DR.ABBAS";
		String time = "1230pm";

		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);
		ots.clickOnHospitalNumber_OtList(driver);
		ots.clickOnSubmit(driver);
		ots.clickOnOkBtn(driver);
	}

	@Test(dependsOnMethods = "CheckThatOtConfirmationIsDoneAfterPatientIsAdmitted_Test")
	public void checkThatAfterOtConfirmationIsDone_ItIsReflectingInSurgeryConfirmationList_Test() throws Throwable {
		otConfirmationPage otc = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		otc.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);

		String hospitalNumber = TestData.getHospitalNumber();

		otc.clickOnSurgeryConfirmationListTab(driver);
		otc.enterHospitalNumber_Filter(driver, hospitalNumber);
		otc.clickOnSeacrhButton_Filter(driver);
		String hospitalNumber1 = otc.takeFirstRow_HospitalNumber_SurgeryConfirmation_List(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("successfully hospital number is verified");
	}

	@Test
	public void checkThatAfterOtSchedule_detailsAreReflectingInDoctordesk_Test() throws Throwable {
		HomePage hp = new HomePage(driver);

		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String bedCategory = "NON TEACHING";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION DISEASE ROOM";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String admittedByDr = "DR.ABBAS";
		String time = "1230pm";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		// -------- patientAdmission-------
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

		// --------OT schedule------------
		String operationTheater = "OPERATION THEATER 1";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200pm";
		String duration = "8";
		String anastesiaType = "LOCAL";
		String specialNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String dep = "CARDIOLOGY";
		String surgeryDescription = "CAR GEn SURG";
		String doctorCatagory = "CARDIOLOGIST";
		String consultantName = "DR.VIJAYA SAI";
		String diagnosis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String date = jutil.currentDate();

		OTSchedulingPage ots = new OTSchedulingPage(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumber(driver, hospitalNumber);
		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCatagory, consultantName, diagnosis);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);
		String scheduleNumber = ots.captureScheduleNumber_OtList(driver);
		String surgeryName = ots.captureLastRowSurgeryName(driver);
		String surgeryDate = ots.captureSurgeryDate_OtList(driver);

		// -------Doctor desk IPD ------------
		DoctorDesk_Ip_Page dd = new DoctorDesk_Ip_Page(driver);
		dd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListInDDIPd(driver);
		dd.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		dd.searchHospitalNumber(driver, hospitalNumber);
		dd.clickOnHospitalNumberInAllPatientListTab(driver);
		dd.clickOnOtInformationTab(driver);
		String scheduleKey = dd.captureScheduleKeyInOtInformation(driver);
		String surgeryDate1 = dd.captureSurgeryDateInOtInformation(driver);
		String surgeryTime1 = dd.captureSurgeryTimeInOtInformation(driver);
		String duration1 = dd.captureDurationInOtInformation(driver);
		String surgeryName1 = dd.captureSurgeryNameInOtInformation(driver);
		String operationType = dd.captureOperationTypeInOtInformation(driver);
		SoftAssert SoftAssert = new SoftAssert();
		SoftAssert.assertEquals(scheduleKey, scheduleNumber, "schedule number is miss matched");
		SoftAssert.assertEquals(surgeryDate1, surgeryDate, "schedule date is miss matched");
		SoftAssert.assertEquals(surgeryTime1, SurgeryTime, "schedule time is miss matched");
		SoftAssert.assertEquals(duration1, duration, "duration is miss matched");
		SoftAssert.assertEquals(surgeryName1, surgeryName, "surgery name is miss matched");
		SoftAssert.assertEquals(operationType, operationTheater, " OT number is miss matched");
		SoftAssert.assertAll();
	}

	@Test(groups = { "Regression" })
	public void createTheOtScheduleFor_OPD_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String department = "GENERAL MEDICINE";
		String operationTheater = "OPERATION THEATER 1";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200pm";
		String duration = "8";
		String anastesiaType = "LOCAL";
		String specialNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String dep = "CARDIOLOGY";
		String surgeryDescription = "POBA";
		String doctorCatagory = "CARDIOLOGIST";
		String consultantName = "DR.VIJAYA SAI";
		String diagnosis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String date = jutil.currentDate();

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumber(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCatagory, consultantName, diagnosis);
		ots.clickOnOtListTab(driver);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);
		String hospitalNumber1 = ots.captureLastRowHospitalNumber(driver);
		System.out.println(hospitalNumber1);
		Assert.assertEquals(hospitalNumber, hospitalNumber1, "hospital number is not verified in the list -");
		System.out.println("successfully hospital number is verified");
	}

	@Test
	public void checkOnceOtScheduleDone_verifyTheDetailsInDoctorDesk_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String department = "GENERAL MEDICINE";
		String operationTheater = "OPERATION THEATER 1";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200pm";
		String duration = "8";
		String anastesiaType = "LOCAL";
		String specialNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String dep = "CARDIOLOGY";
		String surgeryDescription = "CAR GEn SURG";
		String doctorCatagory = "CARDIOLOGIST";
		String consultantName = "DR.VIJAYA SAI";
		String diagnosis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String date = jutil.currentDate();

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumber(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCatagory, consultantName, diagnosis);
		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dd.clickOnOtInformationTab(driver);
		dd.clickOnOtScheduleTab(driver);
	}

	@Test
	public void verifyNextButtonIsWorkingAsExpectedInOtListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnOtListTab(driver);
		ots.clickOnClearBtn(driver);
		ots.verifyNextBtnIsWorkingAsExpectedInOtList(driver);
	}

	@Test
	public void verifyPreviousButtonIsWorkingAsExpectedInOtListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnOtListTab(driver);
		ots.clickOnClearBtn(driver);
		ots.verifyPreviousBtnIsWorkingAsExpectedInOtList(driver);
	}

	@Test
	public void verifyNextButtonIsWorkingAsExpectedInPacListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		ots.verifyNextBtnIsWorkingAsExpectedInPacList(driver);
	}

	@Test
	public void verifyPreviousButtonIsWorkingAsExpectedInPacListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		ots.verifyPreviousBtnIsWorkingAsExpectedInPacList(driver);
	}

	@Test
	public void verifyThePopuMessage_IfWeDoOtSchedulingForSameHospitalNumberSecondTime_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String department = "GENERAL MEDICINE";
		String operationTheater = "OPERATION THEATER 1";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200pm";
		String duration = "8";
		String anastesiaType = "LOCAL";
		String specialNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String dep = "CARDIOLOGY";
		String surgeryDescription = "CAR GEN SURG";
		String doctorCatagory = "CARDIOLOGIST";
		String consultantName = "DR.VIJAYA SAI";
		String diagnosis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		String date = jutil.currentDate();

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
	
		
		
		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumber(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCatagory, consultantName, diagnosis);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumber(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, department);
		String date1 = currentDate_yyyymmdd();
		String surgeryName = ots.captureSurgeryNameInThePopup(driver);
		System.out.println(surgeryName);
		String surgeryDate = ots.captureSurgeryDateInThePopup(driver);
		System.out.println(surgeryDate);
		Assert.assertEquals(surgeryDescription, surgeryName);
		System.out.println("successfully surgery name is verified");
		Assert.assertEquals(surgeryDate, date1);
		System.out.println("successfully surgery date is verified");
	}

	@Test
	public void verifyHospitalNumberSearchFilterInOtList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnClearBtn(driver);
		String hospitalNumber = ots.captureLastRowHospitalNumber(driver);
		System.out.println(hospitalNumber);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);
		String hospitalNumber1 = ots.captureLastRowHospitalNumber(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1, "hospital number filter is not working");
		System.out.println("Hospital number filter is working as expected");
	}

	@Test
	public void verifyPatientNameSearchFilterInOtList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnClearBtn(driver);
		String patientName = ots.captureLastRowPatientName_OtList(driver);
		System.out.println(patientName);
		ots.enterPatientName_Filter(driver, patientName);
		ots.clickOnSearchBtn_Filters(driver);
		String patientName1 = ots.captureFirstRowPatientName_OtList(driver);
		Assert.assertEquals(patientName, patientName1, "patient name filter is not working");
		System.out.println("patient name filter is working as expected");
	}

	@Test
	public void verifySurgeryNameSearchFilterInOtList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnClearBtn(driver);
		String surgeryName = ots.captureLastRowSurgeryName(driver);
		System.out.println(surgeryName);
		ots.enterSurgeryName_Filter(driver, surgeryName);
		ots.clickOnSearchBtn_Filters(driver);
		String surgeryName1 = ots.captureLastRowSurgeryName(driver);
		Assert.assertEquals(surgeryName, surgeryName1, "surgery name filter is not working");
		System.out.println("surgery name filter is working as expected");
	}

	@Test
	public void verifyDepartmentSearchFilterInOtList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnClearBtn(driver);
		String department = ots.captureLastRowDepartment(driver);
		System.out.println(department);
		ots.selectDepartment_Filter(driver, department);
		ots.clickOnSearchBtn_Filters(driver);
		String department1 = ots.captureLastRowDepartment(driver);
		Assert.assertEquals(department, department1, "department filter is not working");
		System.out.println("department filter is working as expected");
	}

	@Test
	public void verifyConfirmedSatusSearchFilterInOtList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnClearBtn(driver);
		String status = "CONFIRMED";
		ots.selectStatus_Filter(driver, status);
		ots.clickOnSearchBtn_Filters(driver);
		String status1 = ots.captureLastRowStatus(driver);
		System.out.println(status);

		Assert.assertEquals(status, status1, "Confirmed status filter is not working");
		System.out.println("Confirmed status filter is working as expected");
	}

	@Test
	public void verifyPendingSatusSearchFilterInOtList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnClearBtn(driver);
		String status = "PENDING";
		ots.selectStatus_Filter(driver, status);
		ots.clickOnSearchBtn_Filters(driver);
		String status1 = ots.captureLastRowStatus(driver);
		System.out.println(status);

		Assert.assertEquals(status, status1, "PENDING status filter is not working");
		System.out.println("PENDING status filter is working as expected");
	}

	@Test
	public void verifyHospitalNumberSearchFilterInPacList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		String hospitalNumber = ots.captureLastRowHospitalNumber_pacList(driver);
		System.out.println(hospitalNumber);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		ots.clickOnSearchBtn_Filters(driver);
		String hospitalNumber1 = ots.captureLastRowHospitalNumber_pacList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1, "hospital number filter is not working");
		System.out.println("Hospital number filter is working as expected");
	}

	@Test
	public void verifyPatientNameSearchFilterInPacList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		String patientName = ots.captureLastRowPatientNameInPacList(driver);
		System.out.println(patientName);
		ots.enterPatientName_Filter(driver, patientName);
		ots.clickOnSearchBtn_Filters(driver);
		String patientName1 = ots.captureLastRowPatientNameInPacList(driver);
		Assert.assertEquals(patientName, patientName1, "patient name filter is not working");
		System.out.println("patient name filter is working as expected");
	}

	@Test
	public void verifySurgeryNameSearchFilterInPacList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		String surgeryName = ots.captureLastRowSurgeryNameInPacList(driver);
		System.out.println(surgeryName);
		ots.enterSurgeryName_Filter(driver, surgeryName);
		ots.clickOnSearchBtn_Filters(driver);
		String surgeryName1 = ots.captureLastRowSurgeryNameInPacList(driver);
		Assert.assertEquals(surgeryName, surgeryName1, "surgery name filter is not working");
		System.out.println("surgery name filter is working as expected");
	}

	@Test
	public void verifyDepartmentSearchFilterInPacList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		String department = ots.captureLastRowDepartmentInPacList(driver);
		System.out.println(department);
		ots.scrollToTop(driver);
		ots.selectDepartment_Filter(driver, department);
		ots.clickOnSearchBtn_Filters(driver);
		String department1 = ots.captureLastRowDepartmentInPacList(driver);
		Assert.assertEquals(department, department1, "department filter is not working");
		System.out.println("department filter is working as expected");
	}

	@Test
	public void verifyConfirmedSatusSearchFilterInPacList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		String status = "CONFIRMED";
		ots.selectStatus_Filter(driver, status);
		ots.clickOnSearchBtn_Filters(driver);
		String status1 = ots.captureLastRowStatusInPacList(driver);
		System.out.println(status);

		Assert.assertEquals(status, status1, "Confirmed status filter is not working");
		System.out.println("Confirmed status filter is working as expected");
	}

	@Test
	public void verifyPendingSatusSearchFilterInPacList_OtScheduling_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);

		ots.clickOnPacListTab(driver);
		ots.clickOnOkBtnIfDisplays(driver);
		ots.clickOnClearBtn(driver);
		String status = "PENDING";

		ots.selectStatus_Filter(driver, status);
		ots.clickOnSearchBtn_Filters(driver);
		String status1 = ots.captureLastRowStatusInPacList(driver);
		System.out.println(status);

		Assert.assertEquals(status, status1, "PENDING status filter is not working");
		System.out.println("PENDING status filter is working as expected");
	}
}
