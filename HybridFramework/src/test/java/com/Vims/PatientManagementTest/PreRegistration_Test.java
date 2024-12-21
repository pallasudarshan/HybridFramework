package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class PreRegistration_Test extends BaseClass {

	@Test(invocationCount = 50)
	public void createPreRegistrationByEnteringDataInAllFields_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String middleName = JavaUtility.generateRandomMiddleName();
		String lastName = JavaUtility.generateRandomLastName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String motherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String std = "12344";
		String bloodGroup = "AB POSITIVE";
		String mail = firstName + middleName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();
		String nextOfKin = "father";
		String name = JavaUtility.generateRandomFirstName();
		String mobilenum = JavaUtility.generatePhoneNumber_Random();
		String email = name + "@demo.com";

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterMiddleName(driver, middleName);
		opdregistrationpage.LastNameText(lastName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMotherName(driver, motherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterStd_Isd(driver, std);
		opdregistrationpage.selectBloodGroup(driver, bloodGroup);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);
		opdregistrationpage.selectNextOfKin(driver, nextOfKin);
		opdregistrationpage.enterName_NextOfKin(driver, name);
		opdregistrationpage.enterMobileNumber_NextOfKin(driver, mobilenum);
		opdregistrationpage.enterEmail_NextOfKin(driver, email);
		opdregistrationpage.clickOnAddAction_NextOfKin(driver);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);

		String text = opdregistrationpage.captureOkBtnText(driver);
		opdregistrationpage.clickOnOkBtn(driver);
		Assert.assertTrue(text.contains("Form Filled Successfully."));
	}

	@Test(invocationCount = 50)
	public void createPreRegistrationByEnteringDataInMandatoryFields_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String mail = firstName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);

		String text = opdregistrationpage.captureOkBtnText(driver);
		opdregistrationpage.clickOnOkBtn(driver);
		Assert.assertTrue(text.contains("Form Filled Successfully."));
	}

	@Test
	public void createPreRegistrationByEnteringDataInAllFields_AddMultipleNextOfKin_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String middleName = JavaUtility.generateRandomMiddleName();
		String lastName = JavaUtility.generateRandomLastName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String motherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String std = "12344";
		String bloodGroup = "AB POSITIVE";
		String mail = firstName + middleName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();

		String nextOfKin1 = "father";
		String name1 = JavaUtility.generateRandomFirstName();
		String mobilenum1 = JavaUtility.generatePhoneNumber_Random();
		String email1 = name1 + "@demo.com";

		String nextOfKin2 = "BROTHER";
		String name2 = JavaUtility.generateRandomFirstName();
		String mobilenum2 = JavaUtility.generatePhoneNumber_Random();
		String email2 = name2 + "@demo.com";

		String nextOfKin3 = "FRIEND";
		String name3 = JavaUtility.generateRandomFirstName();
		String mobilenum3 = JavaUtility.generatePhoneNumber_Random();
		String email3 = name3 + "@demo.com";

		String nextOfKin4 = "GUARDIAN";
		String name4 = JavaUtility.generateRandomFirstName();
		String mobilenum4 = JavaUtility.generatePhoneNumber_Random();
		String email4 = name4 + "@demo.com";

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterMiddleName(driver, middleName);
		opdregistrationpage.LastNameText(lastName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMotherName(driver, motherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterStd_Isd(driver, std);
		opdregistrationpage.selectBloodGroup(driver, bloodGroup);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);

		opdregistrationpage.addNextOfKin(driver, nextOfKin1, name1, mobilenum1, email1);
		opdregistrationpage.addNextOfKin(driver, nextOfKin2, name2, mobilenum2, email2);
		opdregistrationpage.addNextOfKin(driver, nextOfKin3, name3, mobilenum3, email3);
		opdregistrationpage.addNextOfKin(driver, nextOfKin4, name4, mobilenum4, email4);

		opdregistrationpage.clickOnSubmit_windowHandles(driver);

		String text = opdregistrationpage.captureOkBtnText(driver);
		opdregistrationpage.clickOnOkBtn(driver);
		Assert.assertTrue(text.contains("Form Filled Successfully."));
	}

	@Test
	public void verifyThatCreatedPreRegistrationIsDisplayedAccuratlyInTheList_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String mail = firstName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);

		String tokenNumber = OPDRegistrationPage.captureTokenNumberFromPopUp(driver);
		String tokenKey = OPDRegistrationPage.captureTokenKeyFromPopUp(driver);
		opdregistrationpage.clickOnOkBtn(driver);
		Thread.sleep(1500);
		opdregistrationpage.clickOnBackBtn(driver);
		Thread.sleep(3000);

		String tokenNumber2 = opdregistrationpage.captureTokenNumber_Table(driver);
		String tokenKey2 = opdregistrationpage.captureTokenKey_Table(driver);
		String patientName2 = opdregistrationpage.capturePatientName_Table(driver);
		String mobileNumber2 = opdregistrationpage.captureMobileNumber_Table(driver);
		String registeredDate2 = opdregistrationpage.captureRegisteredDate_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(tokenNumber, tokenNumber2, "token number is miss macthed");
		sa.assertEquals(tokenKey, tokenKey2, "token key is miss matched");
		sa.assertTrue(patientName2.contains(firstName), "patient name is miss matched");
		sa.assertEquals(mobileNumber2, mobileNumber, "mobile number is miss matched");
		sa.assertEquals(registeredDate2, currentDate_Dd_Mm_Yyyy(), "registered date is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyThatUniqueTokenNumberIsGeneratedForEachCreation_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String mail = firstName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.clickOnBackBtn(driver);
		String tokenNumber = opdregistrationpage.captureTokenNumber_Table(driver);
		int tokenNumber_Int = Integer.parseInt(tokenNumber);
		int result = tokenNumber_Int + 1;
		String token_String = String.valueOf(result);

		opdregistrationpage.clickOnAddBtn(driver);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);

		String tokenNumber2 = OPDRegistrationPage.captureTokenNumberFromPopUp(driver);
		opdregistrationpage.clickOnOkBtn(driver);
		Assert.assertEquals(token_String, tokenNumber2, "token number is miss matched");
	}

	@Test
	public void verifyThatUniqueTokenKeyIsGeneratedForEachCreation_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String mail = firstName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.clickOnBackBtn(driver);
		String tokenKey = opdregistrationpage.captureTokenKey_Table(driver);
		int tokenKey_Int = Integer.parseInt(tokenKey);
		int result = tokenKey_Int + 1;
		String token_String = String.valueOf(result);

		opdregistrationpage.clickOnAddBtn(driver);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);

		String tokenKey2 = OPDRegistrationPage.captureTokenKeyFromPopUp(driver);
		opdregistrationpage.clickOnOkBtn(driver);
		Assert.assertEquals(token_String, tokenKey2, "token key is miss matched");
	}

	@Test
	public void VerifyPreRegistrationFlow_WithMandatoryFields_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String mail = firstName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();

		String regType2 = "New";
		String department = "DERMATOLOGY";
		String doctor = "HOD DOCTOR";

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);

		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);
		String tokenNumber = OPDRegistrationPage.captureTokenKeyFromPopUp(driver);
		opdregistrationpage.clickOnOkBtn(driver);

		opdregistrationpage.selectRegistrationType(driver, regType2);
		opdregistrationpage.clickOnPreRegistrationBtn(driver);
		opdregistrationpage.enterTokenNumberSearchField(driver, tokenNumber);
		opdregistrationpage.clickOnSearch(driver);
		opdregistrationpage.clickOnFetchBtn(driver);
		opdregistrationpage.selectDepartment(driver, department);
		opdregistrationpage.selectDoctor(driver, doctor);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);
		String text = opdregistrationpage.captureOkBtnText(driver);
		opdregistrationpage.clickOnNewRegistrationBtn(driver);
		Assert.assertTrue(text.contains("Successfully Op Registration is Done"));
	}

	@Test
	public void VerifyPreRegistrationFlow_DataInAllFields_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		String regType = "PRE-REGISTRATION";
		String firstName = JavaUtility.generateRandomFirstName();
		String middleName = JavaUtility.generateRandomMiddleName();
		String lastName = JavaUtility.generateRandomLastName();
		String age = JavaUtility.generateRandomAge();
		String fatherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String motherName = JavaUtility.generateRandomFirstName() + " " + JavaUtility.generateRandomMiddleName();
		String mobileNumber = JavaUtility.generatePhoneNumber_Random();
		String std = "12344";
		String bloodGroup = "AB POSITIVE";
		String mail = firstName + middleName + "@demo.com";
		String address = generateRandomAddress();
		String pincode = "560066";
		String aadharNumber = JavaUtility.generateAadharNumber_Random();

		String nextOfKin1 = "father";
		String name1 = JavaUtility.generateRandomFirstName();
		String mobilenum1 = JavaUtility.generatePhoneNumber_Random();
		String email1 = name1 + "@demo.com";

		String nextOfKin2 = "BROTHER";
		String name2 = JavaUtility.generateRandomFirstName();
		String mobilenum2 = JavaUtility.generatePhoneNumber_Random();
		String email2 = name2 + "@demo.com";

		String nextOfKin3 = "FRIEND";
		String name3 = JavaUtility.generateRandomFirstName();
		String mobilenum3 = JavaUtility.generatePhoneNumber_Random();
		String email3 = name3 + "@demo.com";

		String nextOfKin4 = "GUARDIAN";
		String name4 = JavaUtility.generateRandomFirstName();
		String mobilenum4 = JavaUtility.generatePhoneNumber_Random();
		String email4 = name4 + "@demo.com";

		String regType2 = "New";
		String department = "CARDIOLOGY";
		String doctor = "DR.VIJAYA SAI";

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.enterFirstName(driver, firstName);
		opdregistrationpage.enterMiddleName(driver, middleName);
		opdregistrationpage.LastNameText(lastName);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.enterFatherName(driver, fatherName);
		opdregistrationpage.enterMotherName(driver, motherName);
		opdregistrationpage.enterMobileNumber(driver, mobileNumber);
		opdregistrationpage.enterStd_Isd(driver, std);
		opdregistrationpage.selectBloodGroup(driver, bloodGroup);
		opdregistrationpage.enterEmail(driver, mail);
		opdregistrationpage.enterAddress(driver, address);
		opdregistrationpage.enterPincode(driver, pincode);
		opdregistrationpage.selectPostOffice(driver);
		opdregistrationpage.enterAadharCardNumber(driver, aadharNumber);

		opdregistrationpage.addNextOfKin(driver, nextOfKin1, name1, mobilenum1, email1);
		opdregistrationpage.addNextOfKin(driver, nextOfKin2, name2, mobilenum2, email2);
		opdregistrationpage.addNextOfKin(driver, nextOfKin3, name3, mobilenum3, email3);
		opdregistrationpage.addNextOfKin(driver, nextOfKin4, name4, mobilenum4, email4);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);
		String tokenNumber = OPDRegistrationPage.captureTokenKeyFromPopUp(driver);
		opdregistrationpage.clickOnOkBtn(driver);

		opdregistrationpage.selectRegistrationType(driver, regType2);
		opdregistrationpage.clickOnPreRegistrationBtn(driver);
		opdregistrationpage.enterTokenNumberSearchField(driver, tokenNumber);
		opdregistrationpage.clickOnSearch(driver);
		opdregistrationpage.clickOnFetchBtn(driver);
		opdregistrationpage.selectDepartment(driver, department);
		opdregistrationpage.selectDoctor(driver, doctor);
		opdregistrationpage.clickOnSubmit_windowHandles(driver);
		String text = opdregistrationpage.captureOkBtnText(driver);
		opdregistrationpage.clickOnNewRegistrationBtn(driver);
		Assert.assertTrue(text.contains("Successfully Op Registration is Done"));
	}

}
