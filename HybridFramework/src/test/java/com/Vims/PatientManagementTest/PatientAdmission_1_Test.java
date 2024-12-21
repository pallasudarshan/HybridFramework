package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

public class PatientAdmission_1_Test extends BaseClass {

	@Test
	public void toVerifyThatUserShouldAbleToAdmitThePatient_Test() throws Throwable {
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

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

	}

	@Test
	public void checkThatUserClickOnTheSavButtonWithoutFillHospitalNumber_Test() throws Throwable {

		String msg = eutil.getDataFromTheExcel("PatientAdm", 1, 1);

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pap = new PatientAdmissionPage(driver);

		hp.homeBtnForvims(driver);
		pap.clickOnThePatientAdmissinButton(driver);
		pap.saveButton(driver);
		String msg1 = pap.popupErrorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the error message as  :" + msg1 + " : successfully");

	}

	@Test(dependsOnMethods = "checkThatUserClickOnTheSavButtonWithoutFillHospitalNumber_Test")
	public void checkThatUserClickOnTheSavButtonWithoutFillEffetiveTime_Test() throws Throwable {

		String msg = eutil.getDataFromTheExcel("PatientAdm", 2, 1);
		String department = eutil.getDataFromTheExcel("PatientAdm", 2, 2);

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pap = new PatientAdmissionPage(driver);

		SearchPatientPage sp = new SearchPatientPage(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		hp.homeBtnForvims(driver);
		pap.clickOnThePatientAdmissinButton(driver);
		pap.hospitalNumberText(hospitalNumber);
		pap.departmentDropdown(driver, department);
		pap.saveButton(driver);
		String msg1 = pap.popupErrorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the error message as  :" + msg1 + " : successfully");
	}

	@Test(dependsOnMethods = "checkThatUserClickOnTheSavButtonWithoutFillEffetiveTime_Test")
	public void checkThatUserClickOnTheSavButtonWithoutSelectingDepartment_Test() throws Throwable {
		String msg = eutil.getDataFromTheExcel("PatientAdm", 3, 1);
		String effectiveTime = eutil.getDataFromTheExcel("PatientAdm", 3, 2);

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pap = new PatientAdmissionPage(driver);

		SearchPatientPage sp = new SearchPatientPage(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		hp.homeBtnForvims(driver);
		pap.clickOnThePatientAdmissinButton(driver);
		pap.hospitalNumberText(hospitalNumber);
		pap.effectiveTimeText(effectiveTime);
		pap.saveButton(driver);
		String msg1 = pap.popupErrorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the error message as  :" + msg1 + " : successfully");

	}

	@Test(dependsOnMethods = "checkThatUserClickOnTheSavButtonWithoutSelectingDepartment_Test")
	public void checkThatUserClickOnTheSavButtonWithoutSelectingDoctor_Test() throws Throwable {
		String msg = eutil.getDataFromTheExcel("PatientAdm", 4, 1);
		String effectiveTime = eutil.getDataFromTheExcel("PatientAdm", 4, 2);
		String department = futil.getProperyKeyValue("cardiologyDepartment");

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pap = new PatientAdmissionPage(driver);

		SearchPatientPage sp = new SearchPatientPage(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		hp.homeBtnForvims(driver);
		pap.clickOnThePatientAdmissinButton(driver);
		pap.hospitalNumberText(hospitalNumber);
		pap.effectiveTimeText(effectiveTime);
		pap.departmentDropdown(driver, department);
		pap.saveButton(driver);
		String msg1 = pap.popupErrorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the error message as  :" + msg1 + " : successfully");

	}

	@Test
	public void checkThatUserClickOnTheSavButtonWithoutSelectingWardType_Test() throws Throwable {
		String msg = eutil.getDataFromTheExcel("PatientAdm", 5, 1);
		String effectiveTime = eutil.getDataFromTheExcel("PatientAdm", 5, 2);
		String admittedByDr = eutil.getDataFromTheExcel("PatientAdm", 5, 3);

		String admittedUnderDr = futil.getProperyKeyValue("cardiologyDoctor");
		String department = futil.getProperyKeyValue("cardiologyDepartment");

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pap = new PatientAdmissionPage(driver);

		SearchPatientPage sp = new SearchPatientPage(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		hp.homeBtnForvims(driver);
		pap.clickOnThePatientAdmissinButton(driver);
		pap.hospitalNumberText(hospitalNumber);
		pap.effectiveTimeText(effectiveTime);
		pap.departmentDropdown(driver, department);
		pap.admittedUnderDrDropdown(driver, admittedUnderDr);
		pap.admittedByDrDropDown(driver, admittedByDr);
		pap.saveButton(driver);
		String msg1 = pap.popupErrorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the error message as  :" + msg1 + " : successfully");
	}

	@Test
	public void checkThatUserClickOnTheSavButtonWithoutSelectingRoomTYpe_Test() throws Throwable {

		String msg = eutil.getDataFromTheExcel("PatientAdm", 6, 1);
		String effectiveTime = eutil.getDataFromTheExcel("PatientAdm", 6, 2);
		String admittedByDr = eutil.getDataFromTheExcel("PatientAdm", 6, 3);
		String wardType = eutil.getDataFromTheExcel("PatientAdm", 6, 4);

		String admittedUnderDr = futil.getProperyKeyValue("cardiologyDoctor");
		String department = futil.getProperyKeyValue("cardiologyDepartment");

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pap = new PatientAdmissionPage(driver);

		SearchPatientPage sp = new SearchPatientPage(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		hp.homeBtnForvims(driver);
		pap.clickOnThePatientAdmissinButton(driver);
		pap.hospitalNumberText(hospitalNumber);
		pap.effectiveTimeText(effectiveTime);
		pap.departmentDropdown(driver, department);
		pap.admittedUnderDrDropdown(driver, admittedUnderDr);
		pap.admittedByDrDropDown(driver, admittedByDr);
		pap.wardTypeDropdown(driver, wardType);
		pap.saveButton(driver);
		String msg1 = pap.popupErrorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the error message as  :" + msg1 + " : successfully");
	}

	@Test
	public void checkThatUserClickOnTheSavButtonWithoutSelectingBedNumber_Test() throws Throwable {
		String msg = eutil.getDataFromTheExcel("PatientAdm", 7, 1);
		String effectiveTime = eutil.getDataFromTheExcel("PatientAdm", 7, 2);
		String admittedByDr = eutil.getDataFromTheExcel("PatientAdm", 7, 3);
		String wardType = eutil.getDataFromTheExcel("PatientAdm", 7, 4);
		String roomType = eutil.getDataFromTheExcel("PatientAdm", 7, 5);
		String admittedUnderDr = futil.getProperyKeyValue("cardiologyDoctor");
		String department = futil.getProperyKeyValue("cardiologyDepartment");

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage pap = new PatientAdmissionPage(driver);
		SearchPatientPage sp = new SearchPatientPage(driver);

		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		hp.homeBtnForvims(driver);
		pap.clickOnThePatientAdmissinButton(driver);
		pap.hospitalNumberText(hospitalNumber);
		pap.effectiveTimeText(effectiveTime);
		pap.departmentDropdown(driver, department);
		pap.admittedUnderDrDropdown(driver, admittedUnderDr);
		pap.admittedByDrDropDown(driver, admittedByDr);
		pap.wardTypeDropdown(driver, wardType);
		pap.roomTypeDropdown(driver, roomType);
		pap.saveButton(driver);
		String msg1 = pap.popupErrorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the error message as  :" + msg1 + " : successfully");
	}

	@Test
	public void checkThatUserShouldbePay_MultiplePaymentModeForAdmissionCharges_Test() {

	}
}
