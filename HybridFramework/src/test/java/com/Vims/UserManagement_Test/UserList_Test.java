package com.Vims.UserManagement_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.UserListPage;

public class UserList_Test extends BaseClass {

	@Test(groups = { "Smoke Testing" })
	public void createUserInUserListScreen_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";
		String lastName = "das";
		String employeeCode = "DVT001";
		String gender = "MALE";
		String mobileNumber = generateRandomMobileNumber1();
		String pincode1 = "560066";
		String department = "Accounts";
		String userType = "System users";
		String roleType = "ADMIN OFFICER";
		String role = "ADMIN";
		String address = "Dalvkot vydehi campus";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.enterEmployeeCode(driver, employeeCode);
		ul.enterEmail(driver);
		ul.selectGender(driver, gender);
		ul.enterMobileNumber(driver, mobileNumber);
		ul.enterPincode(driver, pincode1);
		ul.selectDepartment(driver, department);
		ul.selectUserType(driver, userType);
		ul.selectRoleType(driver, roleType);
		ul.selectRole(driver, role);
		ul.enterAddressText(driver, address);
		ul.clickOnSumbitButton(driver);
		ul.clickOnOkMessagePopup(driver);
	}

	@Test(groups = { "Unit Testing" })
	public void verifyFirstNameErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.clickOnSumbitButton(driver);
		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter First Name");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void verifyLastNameErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.clickOnSumbitButton(driver);
		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter Last Name");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void verifyEmailErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";
		String lastName = "Das";
		String gender = "MALE";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.selectGender(driver, gender);
		ul.clickOnSumbitButton(driver);
		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter Email Id");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void verifyMobileNumberErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";
		String lastName = "Das";
		String gender = "MALE";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.enterEmail(driver);
		ul.selectGender(driver, gender);
		ul.clickOnSumbitButton(driver);
		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter Mobile Number");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void verifyPincodeErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";
		String lastName = "Das";
		String mobileNumber = "6767876876";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.enterEmail(driver);
		ul.selectGender(driver, "MALE");
		ul.enterMobileNumber(driver, mobileNumber);
		ul.clickOnSumbitButton(driver);
		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter Pincode Name");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void verifyDepartmentErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";
		String lastName = "Das";
		String mobileNumber = "6767876876";
		String pincode = "560066";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.enterEmail(driver);
		ul.enterMobileNumber(driver, mobileNumber);
		ul.enterPincode(driver, pincode);
		Thread.sleep(1500);
		ul.clickOnSumbitButton(driver);
		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter Department");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void verifyRoleTypeErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";
		String lastName = "Das";
		String mobileNumber = "6767876876";
		String pincode = "560066";
		String department = "Accounts";
		String user = "SYSTEM USERS";
		String gender = "MALE";

		ul.clickOnUserList(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.enterEmail(driver);
		ul.selectGender(driver, gender);
		ul.enterMobileNumber(driver, mobileNumber);
		ul.enterPincode(driver, pincode);
		Thread.sleep(1500);
		ul.selectDepartment(driver, department);
		ul.selectUserType(driver, user);
		ul.clickOnSumbitButton(driver);
		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter roleType");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void verifyRoleErrorMsg_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "Harold";
		String lastName = "das";
		String employeeCode = "DVT001";
		String gender = "MALE";
		String mobileNumber = "9871234511";
		String pincode1 = "560066";
		String department = "Accounts";
		String userType = "System users";
		String roleType = "ADMIN OFFICER";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.enterEmployeeCode(driver, employeeCode);
		ul.enterEmail(driver);
		ul.selectGender(driver, gender);
		ul.enterMobileNumber(driver, mobileNumber);
		ul.enterPincode(driver, pincode1);
		ul.selectDepartment(driver, department);
		ul.selectUserType(driver, userType);
		ul.selectRoleType(driver, roleType);
		ul.clickOnSumbitButton(driver);

		String msg = ul.captureErrorMsg(driver);
		Assert.assertEquals(msg, "Please Enter Role");
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void checkNameSearchFilter_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		String name = "JAYASHANKAR";
		ul.enterName_Filter(name);
		ul.clickOnSearch_Filter(driver);
		String name1 = ul.captureNameInTable(driver);
		Assert.assertEquals("KIRAN " + name + " R", name1);
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void checkEmailSearchFilter_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);

		ul.clickOnUserList(driver);
		String email = ul.captureEmailInLastTable(driver);
		ul.enterEmail_Filter(email);
		ul.clickOnSearch_Filter(driver);
		String email1 = ul.captureEmailInTable(driver);
		Assert.assertEquals(email, email1);
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void checkUserTypeSearchFilter_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);

		String userType = "SYSTEM USERS";

		ul.clickOnUserList(driver);
		ul.selectUserType_Filter(driver, userType);
		ul.clickOnSearch_Filter(driver);
		String userType1 = ul.captureUserTypeInTable(driver);
		Assert.assertEquals(userType, userType1);
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void checkPhoneNumberSearchFilter_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		ul.clickOnUserList(driver);
		String phoneNumber = ul.capturePhoneNumberInLastTable(driver);
		ul.enterPhoneNumber_Filter(driver, phoneNumber);
		ul.clickOnSearch_Filter(driver);
		String phoneNumber1 = ul.capturePhoneNumberInTable(driver);
		Assert.assertEquals(phoneNumber, phoneNumber1);
		System.out.println("successfully verified");
	}

	@Test(groups = { "Unit Testing" })
	public void checkRoleSearchFilter_Test() throws Throwable {
		UserListPage ul = new UserListPage(driver);

		String userType = "SYSTEM USERS";
		String role = "admin";

		ul.clickOnUserList(driver);

		ul.selectUserType(driver, userType);
		ul.selectRole_Filter(driver, role);
		ul.clickOnSearch_Filter(driver);
		Thread.sleep(3000);
		String role1 = ul.captureRoleInTable(driver);
		Assert.assertEquals(role, role1);
		System.out.println("successfully verified");
	}

	@Test(description = "1.Create the user ," + "" + "2. edit their details " + ""
			+ "3.check that the edited details are reflecting correctly in the List.")
	public void createTheUser_EditTheDetailsAndCheckThatEditedDetailsAreReflectingSameInTheList_Test()
			throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "praveen";
		String lastName = "kumar";
		String employeeCode = "DVT001";
		String gender = "MALE";
		String mobileNumber = generateRandomMobileNumber1();
		String pincode1 = "560066";
		String department = "Accounts";
		String userType = "System users";
		String roleType = "ADMIN OFFICER";
		String role = "ADMIN";
		String address = "Dalvkot vydehi campus";

		String firstName1 = "ANTONY";
		String mobileNumber1 = generateRandomMobileNumber1();
		String department1 = "PAIN CLINIC";
		String userType1 = "DOCTOR";
		String roleType1 = "ASSISTANT PROFESSOR";
		String role1 = "CARDIOLOGIST";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
//		ul.clickOnAddBtn(driver);
//		ul.enterFirstName(driver, firstName);
//		ul.enterLastName(driver, lastName);
//		ul.enterEmployeeCode(driver, employeeCode);
//		ul.enterEmail(driver);
//		ul.selectGender(driver, gender);
//		ul.enterMobileNumber(driver, mobileNumber);
//		ul.enterPincode(driver, pincode1);
//		ul.selectDepartment(driver, department);
//		ul.selectUserType(driver, userType);
//		ul.selectRoleType(driver, roleType);
//		ul.selectRole(driver, role);
//		ul.enterAddressText(driver, address);
//		ul.clickOnSumbitButton(driver);
//		ul.clickOnOkMessagePopup(driver);

		ul.clickOnActions_Table(driver);
		ul.clickOnEditUnderAction_table(driver);
		ul.enterFirstName(driver, firstName1);
		ul.enterMobileNumber(driver, mobileNumber1);
		ul.selectDepartment(driver, department1);
		ul.selectUserType(driver, userType1);
		ul.selectRoleType(driver, roleType1);
		ul.selectRole(driver, role1);
		ul.clickOnSumbitButton(driver);
		ul.clickOnOkMessagePopup(driver);

		String name2 = ul.captureNameInTable(driver);
		String usertype2 = ul.captureUserTypeInTable(driver);
		String phoneNumber2 = ul.capturePhoneNumberInTable(driver);
		String department2 = ul.captureDepartmentInTable(driver);
		String role2 = ul.captureRoleInTable(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(firstName1, name2);
		sa.assertEquals(userType1, usertype2);
		sa.assertEquals(mobileNumber1, phoneNumber2);
		sa.assertEquals(department1, department2);
		sa.assertEquals(role1, role2);
		sa.assertAll();
	}

	@Test(description = "Create, user, and deactivate the user in the user list.", groups = { "Unit Testing" })
	public void createTheUseAndDeactivateTheUserInUserList() throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		String firstName = "test";
		String lastName = "das";
		String employeeCode = "DVT001";
		String gender = "MALE";
		String mobileNumber = generateRandomMobileNumber1();
		String pincode1 = "560066";
		String department = "Accounts";
		String userType = "System users";
		String roleType = "ADMIN OFFICER";
		String role = "ADMIN";
		String address = "Dalvkot vydehi campus";

		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.clickOnAddBtn(driver);
		ul.enterFirstName(driver, firstName);
		ul.enterLastName(driver, lastName);
		ul.enterEmployeeCode(driver, employeeCode);
		ul.enterEmail(driver);
		ul.selectGender(driver, gender);
		ul.enterMobileNumber(driver, mobileNumber);
		ul.enterPincode(driver, pincode1);
		ul.selectDepartment(driver, department);
		ul.selectUserType(driver, userType);
		ul.selectRoleType(driver, roleType);
		ul.selectRole(driver, role);
		ul.enterAddressText(driver, address);
		ul.clickOnSumbitButton(driver);
		ul.clickOnOkMessagePopup(driver);

		ul.enterName_Filter(firstName);
		ul.clickOnSearch(driver);
		ul.clickOnStatusToggleBtn(driver);
		ul.clickOnConfirmDeactivateBtn(driver);

	}

	@Test(dependsOnMethods = "createTheUseAndDeactivateTheUserInUserList", groups = { "Smoke Testing" })
	public void checkThatIfUserClickOnTheStatusToggleBtnAndClickOnTheCancelButtonInTheConfirmPopupVerifyTheStatusInTheList_Text()
			throws Throwable {
		UserListPage ul = new UserListPage(driver);
		HomePage hp = new HomePage(driver);
		String firstName = "test";
		ul.clickOnUserList(driver);
		hp.homeBtnForvims(driver);
		ul.enterName_Filter(firstName);
		ul.clickOnSearch(driver);
		ul.clickOnStatusToggleBtn(driver);
		ul.clickOnCancelBtn(driver);
	}
}
