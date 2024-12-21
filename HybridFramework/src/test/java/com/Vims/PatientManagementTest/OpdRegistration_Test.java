package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

public class OpdRegistration_Test extends BaseClass {

	@Test(priority = 1)
	public void checkThatWithoutFillingThe_FirstName_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {

		String msg = "Please Enter First Name";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 2)
	public void checkThatWithoutFillingThe_DateOfBirth_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {

		String name = "name";
		String msg = "Please Select Date Of Birth";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 3)
	public void checkThatWithoutFillingThe_FatherName_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {

		String name = "name";
		String age = "23";
		String msg = "Please Enter Father Name";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 4)
	public void checkThatWithoutFillingThe_MobileNumber_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {
		String name = "TestEngineer";
		String age = "23";
		String fatherName = "TestEng Father";
		String msg = "Please Enter Mobile Number";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.fatherName(fatherName);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 5)
	public void checkThatWithoutFillingThe_Email_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {
		String name = "TestEngineer";
		String age = "23";
		String fatherName = "TestEng Father";
		String msg = "Please Enter Email Id";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.fatherName(fatherName);
		opdRegistrationPage.clickOn_UnavailableButton_MobileNum(driver);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 6)
	public void checkThatWithoutFillingThe_Address_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {

		String name = "TestEngineer";
		String age = "23";
		String fatherName = "TestEng Father";
		String msg = "Please Enter address";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.fatherName(fatherName);
		opdRegistrationPage.clickOn_UnavailableButton_MobileNum(driver);
		opdRegistrationPage.clickOn_UnavailableButton_Email(driver);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 7)
	public void checkThatWithoutFillingThe_AadharNumber_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {
		String name = "TestEngineer";
		String age = "23";
		String fatherName = "TestEng Father";
		String msg = "Please Enter Aadhar Number";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.fatherName(fatherName);
		opdRegistrationPage.clickOn_UnavailableButton_MobileNum(driver);
		opdRegistrationPage.clickOn_UnavailableButton_Email(driver);
		opdRegistrationPage.adressTextFiled(name);

		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 8)
	public void checkThatWithoutFillingThe_Pincode_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {
		String name = "TestEngineer";
		String age = "23";
		String fatherName = "TestEng Father";
		String msg = "Please Enter Pincode";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.fatherName(fatherName);
		opdRegistrationPage.clickOn_UnavailableButton_MobileNum(driver);
		opdRegistrationPage.clickOn_UnavailableButton_Email(driver);
		opdRegistrationPage.adressTextFiled(name);
		opdRegistrationPage.aadharCards_Random(driver);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 9)
	public void checkThatWithoutFillingThe_PostOffice_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {
		String name = "TestEngineer";
		String age = "23";
		String fatherName = "TestEng Father";
		String pincode = "516360";
		String msg = "Please Select Post Office";

		HomePage homePage = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		homePage.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.fatherName(fatherName);
		opdRegistrationPage.clickOn_UnavailableButton_MobileNum(driver);
		opdRegistrationPage.clickOn_UnavailableButton_Email(driver);
		opdRegistrationPage.adressTextFiled(name);
		opdRegistrationPage.pincodeTextField(driver, pincode);
		opdRegistrationPage.aadharCards_Random(driver);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 10)
	public void checkThatWithoutFillingThe_Department_MandataroyFiledClickOnSubmitButton_Test() throws Throwable {
		String name = "TestEngineer";
		String age = "23";
		String fatherName = "TestEng Father";
		String pincode = "516360";
		String postOffice = "COLLEGE ROAD";
		String msg = "Please Select Department";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		opdRegistrationPage.fatherName(fatherName);
		opdRegistrationPage.clickOn_UnavailableButton_MobileNum(driver);
		opdRegistrationPage.clickOn_UnavailableButton_Email(driver);
		opdRegistrationPage.adressTextFiled(name);
		opdRegistrationPage.pincodeTextField(driver, pincode);
		opdRegistrationPage.aadharCards_Random(driver);
		opdRegistrationPage.postOfficeDropdown(driver, postOffice);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 11)
	public void checkThatUserShouldCreateTheEmergencyRegistration_Test() throws Throwable {

		String registrationType = "EMERGENCY";
		String name = "Vikram";
		String age = "12";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);

		opdRegistrationPage.registrationTypeDropDown(driver, registrationType);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.AgeText(age);
		String hospitalNumber = opdRegistrationPage.submitAnd_ViewBtnForEmergencyMedicine2(driver);

	}

	@Test(priority = 12, description = "It's should not allow to create the emergency registration ")
	public void checkThatInEmergencyRegistrationWithoutFillingTheMandatoryFieldAgeSubmit_Test() throws Throwable {
		String registrationType = "EMERGENCY";
		String name = "Vikram";
		String msg = "Please Select Date Of Birth";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdRegistrationPage = new OPDRegistrationPage(driver);

		opdRegistrationPage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdRegistrationPage.registrationTypeDropDown(driver, registrationType);
		opdRegistrationPage.firstName(name);
		opdRegistrationPage.SubmitBtnOnly(driver);
		String msg1 = opdRegistrationPage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(priority = 13)
	public void checkThatUserShouldCreateTheRevisitRegistration_Test() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String registrationType = "REVISIT";
		String revisitDepartment = "CARDIOLOGY";
		String revisitDoctor = "VIJAYA SAI";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.registrationTypeDropDown(driver, registrationType);
		opdregistrationpage.enterRevisitHospitalNumber_Text(driver, hospitalNumber);
		opdregistrationpage.selectDepartment(driver, revisitDepartment);
		opdregistrationpage.selectDoctor(driver, revisitDoctor);
		opdregistrationpage.submitAnd_ViewBtn(driver);

	}

	@Test(priority = 14)
	public void cx() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = "SANJAY";
		String depName = "Urology";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.clickOn_QuickRegistrationBtn(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
	}

	@Test(priority = 14)
	public void checkThatUserAddTheMultiple_NextofKinDetailsInTheList_Test() throws Throwable {
		String nextOfKIn = "BROTHER";
		String name = "Bhairava";
		String number = "9876543210";
		String email = "test@gmail.com";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);

		opdregistrationpage.nextOfKinDetails(driver, nextOfKIn, name, number, email);

	}

	@Test(priority = 15)
	public void checkThatMobileNumberTextFieldShouldNotAcceptTheWrongBelowTenDigits_Test() throws Throwable {
		String phoneNumber = "3232";
		String mail = "tesdfusfs8wr6wwert@gmail.com";
		String msg = "";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.mobileNumber(driver, phoneNumber);
		opdregistrationpage.emailEnter(mail);
		String msg1 = opdregistrationpage.mandatoryFields_error_Message(driver);
		Assert.assertEquals(msg1, msg);
	}

}