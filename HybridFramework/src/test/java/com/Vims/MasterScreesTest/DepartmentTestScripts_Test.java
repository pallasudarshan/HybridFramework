package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DepartmentPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DepartmentTestScripts_Test extends BaseClass {

	@Test
	public void inputDetailsAndClickOnSubmit() throws Throwable {

		String departmentType = "CLINICAL DEPARTMENT";
		String Speciality = "NON-CLINICAL";
		String departmentShortName = "depa";
		String departmentName = "depa";
		String numberOfUnit = "3";
		String sequance = "68";
		String fromDate = "16032023";
		String toDate = "16042023";

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.selectDepartmentTypeDropdown(driver, departmentType);
		dp.selectSpecialityTypeDropdown(driver, Speciality);
		dp.enterDepartmentShortName(departmentShortName);
		dp.enterDepartmentName(departmentName);
		dp.enterNumberOfUnit(numberOfUnit);
		dp.enterSequence(sequance);
		dp.enterFromDate(fromDate);
		dp.entertoDate(toDate);
		dp.clickOnSubmit(driver);
	}

	@Test
	public void editTheCreatedDepartment() throws Throwable {

		String departmentName = "testing123";
		String sequance = "76";
		String departmentShortName = "tested";
		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnAction(driver);
		dp.clickOnEdit(driver);
		dp.enterDepartmentName(departmentName);
		dp.enterSequence(sequance);
		dp.enterDepartmentShortName(departmentShortName);
		dp.clickOnSubmit(driver);
	}

	@Test
	public void clickOnSubmitWithoutEnteringDepartmentType() throws Throwable {

		String Speciality = "NON-CLINICAL";
		String departmentShortName = "test";
		String departmentName = "testing";
		String numberOfUnit = "5";
		String sequance = "66";
		String fromDate = "16032023";
		String toDate = "16042023";
		String departmentTypeErrorMsg1 = "Please Select Department Type";

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.selectSpecialityTypeDropdown(driver, Speciality);
		dp.enterDepartmentShortName(departmentShortName);
		dp.enterDepartmentName(departmentName);
		dp.enterNumberOfUnit(numberOfUnit);
		dp.enterSequence(sequance);
		dp.enterFromDate(fromDate);
		dp.entertoDate(toDate);
		dp.clickOnSubmit(driver);
		String departmentTpeErrorMsg = dp.clickOnThePleaseEnterTheDepartment_Msg(driver);
		Assert.assertEquals(departmentTypeErrorMsg1, departmentTpeErrorMsg);
		System.out.println("User got the error msg as  :" + departmentTpeErrorMsg + "  :  Successfully");

	}

/*	@Test
	public void clickOnSubmitWithoutEnteringSpeciality() throws Throwable {

		String departmentType = "CLINICAL DEPARTMENT";
		String departmentShortName = "qwe";
		String departmentName = "ABCDE";
		String numberOfUnit = "5";
		String sequance = "66";
		String fromDate = "16032023";
		String toDate = "16042023";
		String specialityErrorMsg1 = "Please Select Speciality";

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.selectDepartmentTypeDropdown(driver, departmentType);
		dp.enterDepartmentShortName(departmentShortName);
		dp.enterDepartmentName(departmentName);
		dp.clickOn_OkButton(driver);
		dp.enterNumberOfUnit(numberOfUnit);
		dp.enterSequence(sequance);
		dp.enterFromDate(fromDate);
		dp.entertoDate(toDate);
		dp.clickOnSubmit(driver);
		String SpecialityErrorMsg = dp.clickOnThePleaseEnterTheDepartment_Msg(driver);
		Assert.assertEquals(specialityErrorMsg1, SpecialityErrorMsg);
		System.out.println("User got the error msg as  :" + SpecialityErrorMsg + "  :  Successfully");

	}*/

	@Test
	public void clickOnSubmitWithoutShortName() throws Throwable {

		String departmentType = "CLINICAL DEPARTMENT";
		String Speciality = "NON-CLINICAL";
		String shortNameErrorMsg1 = "Please enter Department Short Name";

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.selectDepartmentTypeDropdown(driver, departmentType);
		dp.selectSpecialityTypeDropdown(driver, Speciality);
		dp.clickOnSubmit(driver);
		String departmentShortNameErrorMsg = dp.clickOnThePleaseEnterDepartmentTypeShoryName_Msg(driver);
		Assert.assertEquals(shortNameErrorMsg1, departmentShortNameErrorMsg);
		System.out.println("User got the error msg as  --" + departmentShortNameErrorMsg + "--  Successfully");

	}

	@Test
	public void clickOnSubmitWithoutEnteringDepartmentName() throws Throwable {

		String departmentType = "CLINICAL DEPARTMENT";
		String Speciality = "NON-CLINICAL";
		String departmentShortName = "abcde";
		String DepartmentNameErrorMsg1 = "Please enter Department Name";

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.selectDepartmentTypeDropdown(driver, departmentType);
		dp.selectSpecialityTypeDropdown(driver, Speciality);
		dp.enterDepartmentShortName(departmentShortName);
		dp.clickOnSubmit(driver);

		String departmentNameErrorMsg = dp.clickOnThePleaseEnterDepartmentName_Msg(driver);
		Assert.assertEquals(DepartmentNameErrorMsg1, departmentNameErrorMsg);
		System.out.println("User got the error msg as  --" + departmentNameErrorMsg + "--  Successfully");

	}

	@Test
	public void clickOnSubmitWithoutEnteringNoOfUnit() throws Throwable {

		String departmentType = "CLINICAL DEPARTMENT";
		String Speciality = "NON-CLINICAL";
		String departmentShortName = "abcde";
		String noOfUnitErrorMsg1 = "Please enter No. Of Unit";
		String departmentName = "test";

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.selectDepartmentTypeDropdown(driver, departmentType);
		dp.selectSpecialityTypeDropdown(driver, Speciality);
		dp.enterDepartmentShortName(departmentShortName);
		dp.enterDepartmentName(departmentName);
		dp.clickOnSubmit(driver);

		String noOfUnitErrorMsg = dp.clickOnThePleaseEnterNoOfUnit_Msg(driver);
		Assert.assertEquals(noOfUnitErrorMsg1, noOfUnitErrorMsg);
		System.out.println("User got the error msg as  --" + noOfUnitErrorMsg + "--  Successfully");
	}

	@Test
	public void VerifyCancelBtn() throws Throwable {

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.clickOnCancelBtn(driver);
		System.out.println("User clicked on the cancel button successfully");

	}

	@Test
	public void VerifyBackBtn() throws Throwable {

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnTheAddButton(driver);
		dp.clickOnBackBtn(driver);
		System.out.println("User clicked on the Back button successfully");

	}

	@Test
	public void VerifySearchBtn() throws Throwable {

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnSearcBtn(driver);
		System.out.println("User clicked on the Search Button button successfully");

	}

	@Test
	public void VerifyClearBtn() throws Throwable {

		HomePage hp = new HomePage(driver);
		DepartmentPage dp = new DepartmentPage(driver);

		hp.homeBtnForvims(driver);
		dp.clickOnTheDepartmentScreenButton(driver);
		dp.clickOnClearBtn(driver);
		System.out.println("User clicked on the Clear Button button successfully");

	}
}