package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.DoctorMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.UserListPage;

public class DoctorMasterTest extends BaseClass {

	@Test(priority = 0)
	public void checkThatUserFillAllDetailsExceptDoctorTitleMandatoryField_Test() throws Throwable {
		String gender = "FEMALE";
		String doctorType = "SENIOR RESIDENT";
		String doctorCategory = "CONSULTANT PHYSICIAN";
		String organizationId = "SRINIVASA TRUST";
		String groupId = "VYDEHI GROUP";
		String buinessId = "VIMS";
		String msg1 = "Doctor Title required.";

		HomePage hp = new HomePage(driver);
		DoctorMasterPage dm = new DoctorMasterPage(driver);

		hp.homeBtnForvims(driver);
		dm.clickOnDoctorMaster(driver);
		dm.clickOnAddButton(driver);
		dm.selectGender(driver, gender);
		dm.selectDoctorType(driver, doctorType);
		dm.selectDoctorCategory(driver, doctorCategory);
		dm.selectOrganizationId(driver, organizationId);
		dm.selectGroupId(driver, groupId);
		dm.selectBuinessId(driver, buinessId);
		String msg = dm.errorMessage_MandatoryField(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "successfully");
	}

	@Test(priority = 1)
	public void checkThatUserAbleToCreateTheDoctorUserId_Test() throws Throwable {
		JavaUtility j = new JavaUtility();
		String doctorTitle = "MS";
		String displayName = "Test";
		String gender = "FEMALE";
		String email = generateRandomEmail();
		String phoneNumber = "123" + j.getRandomNumbers();
		String doctorType = "SENIOR RESIDENT";
		String doctorCategory = "CONSULTANT PHYSICIAN";
		String address = "PDTR";
		String organizationId = "SRINIVASA TRUST";
		String groupId = "VYDEHI GROUP";
		String buinessId = "VIMS";
		String doctorName = "Test";
		String department = "CARDIOLOGY";
		String unit = "1";
		String effectiveFrom = j.currentDate();

		HomePage hp = new HomePage(driver);
		DoctorMasterPage doctorMasterPage = new DoctorMasterPage(driver);

		hp.homeBtnForvims(driver);
		doctorMasterPage.clickOnDoctorMaster(driver);
		doctorMasterPage.clickOnAddButton(driver);
		doctorMasterPage.selectDoctorTitle(driver, doctorTitle);
		doctorMasterPage.enterDoctorName(doctorName);
		doctorMasterPage.enterDisplayName(driver, displayName);
		doctorMasterPage.selectGender(driver, gender);
		doctorMasterPage.enterEmailAddress(driver, email);
		doctorMasterPage.enterPhoneNumber(phoneNumber);
		doctorMasterPage.selectDoctorType(driver, doctorType);
		doctorMasterPage.selectDoctorCategory(driver, doctorCategory);
		doctorMasterPage.enterAddressInTheText(driver, address);
		doctorMasterPage.selectOrganizationId(driver, organizationId);
		doctorMasterPage.selectGroupId(driver, groupId);
		doctorMasterPage.selectBuinessId(driver, buinessId);
		doctorMasterPage.selectDepartment_DoctorDetails(driver, department);
		doctorMasterPage.selectUnit_DoctorDetails(driver, unit);
		doctorMasterPage.enterEffectiveFrom_DoctorDetails(driver, effectiveFrom);
		doctorMasterPage.actionButton_DoctorDetails(driver);
		doctorMasterPage.clickOnTheSubmitButton(driver);
		doctorMasterPage.clickOnTheOkButtonOfPopupMessage(driver);
		System.out.println("User created a doctor id successfully");

		doctorMasterPage.enterPhoneNumber(phoneNumber);
		doctorMasterPage.clickOnSearch(driver);
		String phoneNumber1 = doctorMasterPage.phoneNumberInThe_Table(driver);
		Assert.assertEquals(phoneNumber1, phoneNumber);
		System.out.println("User got the details after filtered with help of the phone number");
		doctorMasterPage.clickOnClear(driver);
		doctorMasterPage.enterEmailId(email);
		doctorMasterPage.clickOnSearch(driver);
		String email1 = doctorMasterPage.emailIdInThe_Table(driver);
		Assert.assertEquals(email, email1);
		System.out.println("User got the details after fltered with help of the email id");

	}

	@Test(priority = 2)
	public void checkThatUserShouldAbleToFilterTheDoctorUserIdDetails_Test() throws Throwable {

		String displayName = "TEST";
		String department = "CARDIOLOGY";

		HomePage hp = new HomePage(driver);
		DoctorMasterPage d = new DoctorMasterPage(driver);

		hp.homeBtnForvims(driver);
		d.clickOnDoctorMaster(driver);

		d.enterDoctorName(displayName);
		d.clickOnSearch(driver);
		String doctorName = d.doctorNameInThe_Table(driver);
		Assert.assertEquals(doctorName, displayName);
		System.out.println("User got the details after fltered with help of the  doctor name");
		d.clickOnClear(driver);
		d.selectDepartment(driver, department);
		d.clickOnSearch(driver);
		String department1 = d.departmentNameInThe_Table(driver);
		Assert.assertEquals(department1, department);
		System.out.println("User got the details after fltered with help of the department");
	}

	@Test(priority = 3)
	public void checkThatUserShouldEditAndUpdateTheDoctorDetails_Test() throws Throwable {
		JavaUtility j = new JavaUtility();
		String email = generateRandomEmail();
		String phoneNumber = "123" + j.getRandomNumbers();
		String displayName = "YELLOW";

		HomePage hp = new HomePage(driver);
		DoctorMasterPage doctorMasterPage = new DoctorMasterPage(driver);

		hp.homeBtnForvims(driver);
		doctorMasterPage.clickOnDoctorMaster(driver);
		doctorMasterPage.clickOnTheActions_Table(driver);
		doctorMasterPage.clickOnTheActions_Edit(driver);
		doctorMasterPage.clearTheDoctorName_DisplayName_EmailId_PhonNumber();
		doctorMasterPage.enterDoctorName(displayName);
		doctorMasterPage.enterDisplayName(driver, displayName);
		doctorMasterPage.enterEmailAddress(driver, email);
		doctorMasterPage.enterPhoneNumber(phoneNumber);
		doctorMasterPage.clickOnTheSubmitButton(driver);
		doctorMasterPage.clickOnTheOkButtonOfPopupMessage(driver);
		System.out.println("User edited/Updated a doctor details successfully");
		doctorMasterPage.enterPhoneNumber(phoneNumber);
		doctorMasterPage.clickOnSearch(driver);
		String phoneNumber1 = doctorMasterPage.phoneNumberInThe_Table(driver);
		Assert.assertEquals(phoneNumber1, phoneNumber);
		System.out.println("User got the details after filtered with help of the phone number");
		doctorMasterPage.clickOnClear(driver);
		doctorMasterPage.enterEmailId(email);
		doctorMasterPage.clickOnSearch(driver);
		String email1 = doctorMasterPage.emailIdInThe_Table(driver);
		Assert.assertEquals(email, email1);
		System.out.println("User got the details after fltered with help of the email id");
		doctorMasterPage.clickOnClear(driver);
		doctorMasterPage.enterDoctorName(displayName);
		doctorMasterPage.clickOnSearch(driver);
		String doctorName = doctorMasterPage.doctorNameInThe_Table(driver);
		Assert.assertEquals(doctorName, displayName);
		System.out.println("User got the details after fltered with help of the  doctor name");
	}
	
	
	@Test(description ="Check that the user is able to filter using the doctor's name in doctor master screen.")
	public void checkThatUserisAbleToFilterUsingDoctorName_Test() throws Throwable{
		DoctorMasterPage dm = new DoctorMasterPage(driver);
		HomePage hp = new HomePage(driver);
		
		dm.clickOnDoctorMaster(driver);
		hp.homeBtnForvims(driver);
		String doctorName = dm.captureDoctorName_table_LastRow(driver);
		dm.enterDoctorName(doctorName);
		dm.clickOnSearch(driver);
		String doctorName1 = dm.captureDoctorName_table(driver);
		Assert.assertEquals(doctorName, doctorName1);
	}
	
	@Test(description = "Check that the user is able to filter using the department in doctor master screen")
	public void checkThatUserisAbleToFilterUsingDepartment_Test() throws Throwable{
		DoctorMasterPage dm = new DoctorMasterPage(driver);
		HomePage hp = new HomePage(driver);
		
		dm.clickOnDoctorMaster(driver);
		hp.homeBtnForvims(driver);
		String dep = dm.captureDepartment_table_LastRow(driver);
		dm.selectDepartment(driver,dep);
		dm.clickOnSearch(driver);
		String dep1 = dm.departmentNameInThe_Table(driver);
		Assert.assertEquals(dep, dep1);
	}
	
	@Test(description = "Check that the user is able to filter using the department unit in doctor master screen")
	public void checkThatUserisAbleToFilterUsingUnit_Test() throws Throwable{
		DoctorMasterPage dm = new DoctorMasterPage(driver);
		HomePage hp = new HomePage(driver);
		
		dm.clickOnDoctorMaster(driver);
		hp.homeBtnForvims(driver);
		String dep = dm.captureDepartment_table_LastRow(driver);
		String unit = dm.captureUnit_table_LastRow(driver);
		dm.selectDepartment(driver,dep);
		dm.selectUnit(driver, unit);
		dm.clickOnSearch(driver);
		String dep1 = dm.departmentNameInThe_Table(driver);
		String unit1 = dm.captureUnit_table(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(dep, dep1);
		sa.assertEquals(unit, unit1);
		sa.assertAll();
	}
	
	@Test(description = "Check that the user is able to filter using the Phone Number in doctor master screen")
	public void checkThatUserisAbleToFilterUsingPhoneNumber_Test() throws Throwable{
		DoctorMasterPage dm = new DoctorMasterPage(driver);
		HomePage hp = new HomePage(driver);
		
		dm.clickOnDoctorMaster(driver);
		hp.homeBtnForvims(driver);
		String ph = dm.capturePhoneNumber_table_LastRow(driver);
		dm.enterPhoneNumber(ph);
		dm.clickOnSearch(driver);
		String ph1 = dm.phoneNumberInThe_Table(driver);
	    Assert.assertEquals(ph,ph1);
	}
	
	@Test(description = "Check that the user is able to filter using the Email id in doctor master screen")
	public void checkThatUserisAbleToFilterUsingEmail_Test() throws Throwable{
		DoctorMasterPage dm = new DoctorMasterPage(driver);
		HomePage hp = new HomePage(driver);
		
		dm.clickOnDoctorMaster(driver);
		hp.homeBtnForvims(driver);
		String email = dm.captureEmail_table_LastRow(driver);
		dm.enterEmailId(email);
		dm.clickOnSearch(driver);
		String email1 = dm.emailIdInThe_Table(driver);
	    Assert.assertEquals(email,email1);
	}
	
	@Test(description = "Check that the user is able to filter using the Doctor Category in doctor master screen")
	public void checkThatUserisAbleToFilterDoctorCategory_Test() throws Throwable{
		DoctorMasterPage dm = new DoctorMasterPage(driver);
		HomePage hp = new HomePage(driver);
		
		dm.clickOnDoctorMaster(driver);
		hp.homeBtnForvims(driver);
		String dc = dm.captureDoctorCategory_table_LastRow(driver);
		dm.selectDoctorCategory(driver,dc);
		dm.clickOnSearch(driver);
		String dc1 = dm.captureDoctorCategory_table(driver);
	    Assert.assertEquals(dc,dc1);
	}
	
	@Test(description = "Check that the user is able to filter using the Doctor Type in doctor master screen")
	public void checkThatUserisAbleToFilterDoctorType_Test() throws Throwable{
		DoctorMasterPage dm = new DoctorMasterPage(driver);
		HomePage hp = new HomePage(driver);
		
		dm.clickOnDoctorMaster(driver);
		hp.homeBtnForvims(driver);
		String dt = dm.captureDoctorType_table_LastRow(driver);
		dm.selectDoctorType(driver,dt);
		dm.clickOnSearch(driver);
		String dt1 = dm.captureDoctorType_table(driver);
	    Assert.assertEquals(dt,dt1);
	}
}

		
	

	/*
	 * @Test(priority = 4) public void
	 * checkThatUserShouldAbleToResetThePassword_AndLoginWithTheChangedPasswordTest(
	 * ) throws Throwable { String password = "12345";
	 * 
	 * HomePage hp = new HomePage(driver); DoctorMasterPage dm = new
	 * DoctorMasterPage(driver); UserListPage ul = new UserListPage(driver);
	 * LoginPage loginPage = new LoginPage(driver); LogOutPage logOutPage = new
	 * LogOutPage(driver);
	 * 
	 * hp.homeBtnForvims(driver); dm.clickOnDoctorMaster(driver); String email =
	 * dm.emailIdInThe_Table(driver);
	 * 
	 * hp.homeBtnForvims(driver); ul.clickOnUserList(driver);
	 * ul.enter_Email_Filter(driver, email); ul.clickOnSearch(driver);
	 * ul.clickOnActions_Table(driver); ul.clickOnResetPassword(driver);
	 * ul.enterNew_ConfirmPassword_ClickOnChangeButton(driver, password);
	 * ul.clickOnOkMessagePopup(driver);
	 * System.out.println("User reset password done successfully");
	 * 
	 * logOutPage.logoutTheApplication(driver);
	 * loginPage.loginToApplicationUsingDoctorLogin(email, password, driver);
	 * System.out.println("User login successfully after the chnaged password"); }
	 */


