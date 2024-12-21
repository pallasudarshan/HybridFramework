package com.Vims.MasterScreesTest;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class BedMasterScreenTest extends BaseClass {

	@Test(invocationCount = 100)
	public void checkThatUserShouldAbleToCreateTheReservedBed_Test() throws Throwable {
		String bedCategory = "NON TEACHING";
		String wardType = "TWIN SHARING";
		String roomType = "TWIN SHARING";
		String wings = "NORTH";
		String roomNumber = "12";
		String bedNumber = "12";
		String bedStatus = "aVAILABLE";
		String Floor = "3RD FLOOR";

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		BedMasterPage bmp = new BedMasterPage(driver);
		bmp.clickOnTheBedMasterButton(driver);
		bmp.selectBedCategoryDropdown(driver, bedCategory);
		bmp.selectWardTypeDropdown(driver, wardType);
		bmp.selectRoomTypeDropdown(driver, roomType);
		bmp.selectFloorDropdown(driver, Floor);
		bmp.selectWingsDropdown(driver, wings);
		bmp.enterTheRoomNumber(roomNumber);
		bmp.enterTheBedNumber(bedNumber);
		bmp.selectBedStatusDropdown(driver, bedStatus);
		bmp.changeActiveStatus(driver);
		bmp.clickOnTheActionButton();
		bmp.clickOnTheSubmitButton(driver);
		System.out.println("User created a reserved bed ");
	}

	@Test
	public void checkThatUserAbleToDeleteTheCreatedBed_Test() throws Throwable {
//		String bedCategory = "NON TEACHING";
//		String wardType = "GENERAL WARD";
//		String roomType = "FRW";
//		String wings = "NORTH WING";
//		String roomNumber = "1535";
//		String bedNumber = "1223";
//		String bedStatus = "AVAILABLE";
//		String Floor = "3RD FLOOR";
//
//		HomePage hp = new HomePage(driver);
//		hp.homeBtnForvims(driver);
//		BedMasterPage bmp = new BedMasterPage(driver);
//		bmp.clickOnTheBedMasterButton(driver);
//		bmp.selectBedCategoryDropdown(driver, bedCategory);
//		bmp.selectWardTypeDropdown(driver, wardType);
//		bmp.selectRoomTypeDropdown(driver, roomType);
//		bmp.selectFloorDropdown(driver, Floor);
//		bmp.selectWingsDropdown(driver, wings);
//		bmp.enterTheRoomNumber(roomNumber);
//		bmp.enterTheBedNumber(bedNumber);
//		bmp.selectBedStatusDropdown(driver, bedStatus);
//		bmp.clickOnTheActionButton();
//		
//		bmp.clickOnTheLastRowBed(driver);
//		System.out.println("Created Bed deleted successfully");
//		bmp.clickOnTheSubmitButton(driver);
//		bmp.clickOnTheSuccessfullyOkButton();
	}

	@Test
	public void ToVerifyThatClickOnTheAddButtonWithoutGivingTheRoomNumber_Test() throws Throwable {
		String bedCategory = "NON TEACHING";
		String wardType = "GENERAL WARD";
		String roomType = "FRW";
		String wings = "NORTH WING";
		String department = "DENTAL";
		String unit = "1";
		String roomNumberErrorMsg1 = "Please Enter Room Number";
		String Floor = "3RD FLOOR";

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		BedMasterPage bmp = new BedMasterPage(driver);
		bmp.clickOnTheBedMasterButton(driver);
		bmp.selectBedCategoryDropdown(driver, bedCategory);
		bmp.selectWardTypeDropdown(driver, wardType);
		bmp.selectRoomTypeDropdown(driver, roomType);
		bmp.selectFloorDropdown(driver, Floor);
		bmp.selectWingsDropdown(driver, wings);

		bmp.clickOnTheActionButton();
		String roomNumberErrorMsg = bmp.clickOnThePlaeseEnterRoomNumber_Msg(driver);
		System.out.println("User got the error msg as  " + roomNumberErrorMsg);
		Assert.assertEquals(roomNumberErrorMsg1, roomNumberErrorMsg);
		System.out.println("User got the expected error msg");
	}

	@Test
	public void ToVerifyThatUserClickOnTheAddbuttonWithoutGivingTheBedNumber_Test() throws Throwable {
		String bedCategory = "NON TEACHING";
		String wardType = "GENERAL WARD";
		String roomType = "FRW";
		String wings = "NORTH WING";
		String department = "DENTAL";
		String unit = "1";
		String roomNumber = "12";
		String bedNumberErrorMsg1 = "Please Enter Bed Number";
		String Floor = "3RD FLOOR";

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		BedMasterPage bmp = new BedMasterPage(driver);
		bmp.clickOnTheBedMasterButton(driver);
		bmp.selectBedCategoryDropdown(driver, bedCategory);
		bmp.selectWardTypeDropdown(driver, wardType);
		bmp.selectRoomTypeDropdown(driver, roomType);
		bmp.selectFloorDropdown(driver, Floor);
		bmp.selectWingsDropdown(driver, wings);
		bmp.enterTheRoomNumber(roomNumber);
		bmp.clickOnTheActionButton();
		String bedNumberErrorMsg = bmp.clickOnThePleaseEnterTheBedNumber_Msg(driver);
		Assert.assertEquals(bedNumberErrorMsg1, bedNumberErrorMsg);
		System.out.println("User got the error msg as  :" + bedNumberErrorMsg + "  :  Successfully");
	}

	@Test
	public void ToVerifyThatClickOnTheAddButtonWithoutSelectingTheBedStatus_Test() throws Throwable {

//		String bedCategory = "NON TEACHING";
//		String wardType = "SINGLE WARD";
//		String roomType = "SINGLE ROOM WARD";
//		String wings = "NORTH WING";
//		String roomNumber = "12";
//		String bedNumber = "122";
//		String bedStatusErrorMsg1 = "Please Select Bed Status";
//		String Floor = "3RD FLOOR";
//
//		HomePage hp = new HomePage(driver);
//		hp.homeBtnForvims(driver);
//		BedMasterPage bmp = new BedMasterPage(driver);
//		bmp.clickOnTheBedMasterButton(driver);
//		bmp.selectBedCategoryDropdown(driver, bedCategory);
//		bmp.selectWardTypeDropdown(driver, wardType);
//		bmp.selectRoomTypeDropdown(driver, roomType);
//		bmp.selectFloorDropdown(driver, Floor);
//		bmp.selectWingsDropdown(driver, wings);
//
//		bmp.enterTheRoomNumber(roomNumber);
//		bmp.enterTheBedNumber(bedNumber);
//		bmp.clickOnTheActionButton();;
//		String bedStatusErrorMsg = bmp.clickOnThePleaseSelectTheBedStatus_Msg(driver);
//		Assert.assertEquals(bedStatusErrorMsg1, bedStatusErrorMsg);
//		System.out.println("User got the error msg as  :" + bedStatusErrorMsg);
	}

	@Test
	public void ToVerifyThatUserShouldNotAcceptTheSameRoom_bedNumber_DuplicateRoom_BedNumber_Test() throws Throwable {

		String bedCategory = "NON TEACHING";
		String wardType = "GENERAL WARD";
		String roomType = "FRW";
		String wings = "NORTH WING";
		String department = "DENTAL";
		String unit = "1";
		String roomNumber = "12";
		String bedNumber = "12";
		String Floor = "3RD FLOOR";

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		BedMasterPage bmp = new BedMasterPage(driver);
		bmp.clickOnTheBedMasterButton(driver);
		bmp.selectBedCategoryDropdown(driver, bedCategory);
		bmp.selectWardTypeDropdown(driver, wardType);
		bmp.selectRoomTypeDropdown(driver, roomType);
		bmp.selectFloorDropdown(driver, Floor);
		bmp.selectWingsDropdown(driver, wings);

		bmp.enterTheRoomNumber(roomNumber);
		bmp.enterBedNumberOnly(bedNumber);
		bmp.clickOnTheActionButton();

	}

	@Test
	public void checkThatUserShouldAbleToSelectAdmittedBedstatus_Test() throws Throwable {
		String bedCategory = "NON TEACHING";
		String wardType = "GENERAL WARD";
		String roomType = "FRW";
		String wings = "NORTH WING";
		String department = "DENTAL";
		String unit = "1";
		String roomNumber = "12";
		String bedNumber = "12";
		String bedStatus = "ADMITTED";
		String Floor = "3RD FLOOR";

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		BedMasterPage bmp = new BedMasterPage(driver);
		bmp.clickOnTheBedMasterButton(driver);
		bmp.selectBedCategoryDropdown(driver, bedCategory);
		bmp.selectWardTypeDropdown(driver, wardType);
		bmp.selectRoomTypeDropdown(driver, roomType);
		bmp.selectFloorDropdown(driver, Floor);
		bmp.selectWingsDropdown(driver, wings);

		bmp.enterTheRoomNumber(roomNumber);
		bmp.enterTheBedNumber(bedNumber);
		bmp.selectBedStatusDropdown(driver, bedStatus);
		bmp.changeActiveStatus(driver);
		bmp.clickOnTheActionButton();
		System.out.println("User created a admitted bed successfully");
	}

	@Test
	public void checkThatUserShouldAbleToSelectUnderMaintenanceBedstatus_Test() throws Throwable {
		String bedCategory = "NON TEACHING";
		String wardType = "GENERAL WARD";
		String roomType = "FRW";
		String wings = "NORTH WING";
		String department = "DENTAL";
		String unit = "1";
		String roomNumber = "12";
		String bedNumber = "12";
		String bedStatus = "UNDER MAINTENANCE";
		String Floor = "3RD FLOOR";

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		BedMasterPage bmp = new BedMasterPage(driver);
		bmp.clickOnTheBedMasterButton(driver);
		bmp.selectBedCategoryDropdown(driver, bedCategory);
		bmp.selectWardTypeDropdown(driver, wardType);
		bmp.selectRoomTypeDropdown(driver, roomType);
		bmp.selectFloorDropdown(driver, Floor);
		bmp.selectWingsDropdown(driver, wings);
		bmp.enterTheRoomNumber(roomNumber);
		bmp.enterTheBedNumber(bedNumber);
		bmp.selectBedStatusDropdown(driver, bedStatus);
		bmp.changeActiveStatus(driver);
		bmp.clickOnTheActionButton();
		System.out.println("User created a user maintenance bed succesfully");
	}

	/*
	 * @Test(invocationCount = 1) public void createTheBed_Test() throws Throwable {
	 * String bedCategory = "NON TEACHING"; String bedWardType = "GENERAL WARD";
	 * String bedRoomType = "C19 MGW WITH O2 3 FLR"; String floor = "4TH FLOOR";
	 * String wings = "EAST WING"; String bedDepartment = "CARDIOLOGY"; String
	 * bedUnitDepartment = "1";
	 * 
	 * BedMasterPage bp = new BedMasterPage(driver); // String
	 * bednumberh=bp.bedMasterForDeluxe(driver, bedCategory, bedWardType, //
	 * bedRoomType, floor, wings,bedDepartment,bedUnitDepartment);
	 * 
	 * }
	 * 
	 * @Test public void createTheBed1_Test() throws Throwable { String bedCategory
	 * = "NON TEACHING"; String bedWardType = "DELUXE WARD"; String bedRoomType =
	 * "DELUXE WARD"; String floor = "4TH FLOOR"; String wings = "EAST WING";
	 * 
	 * BedMasterPage bp = new BedMasterPage(driver); bp.bedMasterForDeluxe(driver,
	 * bedCategory, bedWardType, bedRoomType, floor, wings);
	 * 
	 * }
	 */

	@Test(invocationCount = 20)
	public void createTheBeds() throws Throwable {

		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRAIGE WITH OX";
		String floor = "2ND FLOOR";
		String wings = "WEST WING";
		String bedUnitDepartment = "1";
		String depName = "GENERAL MEDICINE";

		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);
	}

	@Test(invocationCount = 2)
	public void createTheBeds_Twin() throws Throwable {
		String bedCategory = "NON TEACHING";
		String bedWardType = "day care";
		String bedRoomType = "day care";
		String floor = "4TH FLOOR";
		String wings = "west wing";

		BedMasterPage bp = new BedMasterPage(driver);
		bp.bedMasterForDeluxe(driver, bedCategory, bedWardType, bedRoomType, floor, wings);
	}

}
