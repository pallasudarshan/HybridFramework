package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;

public class doctor_DeskIpd_Filters_Test extends BaseClass {
	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_HospitalNumberInTheMyList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String hospitalNumber1 = ip.capture_HospitalNumberMyList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_PatientNameInTheMyList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String patientName = alp.takeThePatientNameInTheActivePatinet_Table(driver);
		System.out.println(patientName);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.enter_PatientName(driver, patientName);
		ip.clickOn_SearchButton_Filters(driver);
		String patientName1 = ip.capturePatientName_MyList(driver);
		System.out.println(patientName1);
		Assert.assertEquals(patientName, patientName1);

	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_IpNumberInTheMyList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String ipNumber = alp.takeIpNumberInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.enter_IpNumber(driver, ipNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String ipNumber1 = ip.captureIpNumber_MyList(driver);
		Assert.assertEquals(ipNumber1, ipNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_PhoneNumberInTheMyList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String phoneNumber = alp.capturePhoneNumber_ActiveTab(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.enter_PhoneNumber(driver, phoneNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String phoneNumber1 = ip.capturePhoneNumber_MyList(driver);
		Assert.assertEquals(phoneNumber1, phoneNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_AlternativePhoneNumberInTheMyList_Test() {

	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_DepartmentNameInTheMyList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String department = alp.takeDepartmentNameInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.select_Department_MyList(driver, department);
		ip.clickOn_SearchButton_Filters(driver);
		String department1 = ip.capture_DepartmentName_MyLits(driver);
		Assert.assertEquals(department1, department);

	}

	/*
	 * @Test public void
	 * checkThatUserShouldFilterPatientDetailsWithHelpOf_WardType_Test() throws
	 * Throwable { String patientStatus = "ACTIVE"; String un =
	 * futil.getProperyKeyValue("doctorUserName"); String pw =
	 * futil.getProperyKeyValue("doctorPassword");
	 * 
	 * AllPatientListPage alp = new AllPatientListPage(driver); HomePage hp = new
	 * HomePage(driver); DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
	 * LogOutPage l = new LogOutPage(driver); LoginPage lp = new LoginPage(driver);
	 * 
	 * l.logoutTheApplication(driver); lp.loginToApplicationUsingDoctorLogin(un, pw,
	 * driver);
	 * 
	 * alp.clickOnTheAllPatientListButton(driver); hp.homeBtnForvims(driver);
	 * alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
	 * String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
	 * 
	 * ip.clickOnTheDoctorDeskIPDScreenButton(driver); hp.homeBtnForvims(driver);
	 * ip.select_WardType_MyList(driver, wardType);
	 * ip.clickOn_SearchButton_Filters(driver); String wardType1 =
	 * ip.capture_WardType_MyLits(driver); Assert.assertEquals(wardType1, wardType);
	 * }
	 */

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_RoomTypeInTheMyList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.selectWardType(driver, wardType);
		ip.select_RoomType(driver, roomType);
		ip.clickOn_SearchButton_Filters(driver);
		String hospitalNumber1 = ip.capture_HospitalNumberMyList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);

	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_BedNumberInTheMyList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
		String bedNumber = alp.takeBedNumberInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.selectWardType(driver, wardType);
		ip.select_RoomType(driver, roomType);
		ip.enter_BedNumber(driver, bedNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String hospitalNumber1 = ip.capture_HospitalNumberMyList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_GenderAs_FeMaleInTheMyList_Test() throws Throwable {

		String gender = "FEMALE";

		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.select_Gender(driver, gender);
		ip.clickOn_SearchButton_Filters(driver);
		String gender1 = ip.capture_Gender(driver);
		Assert.assertEquals(gender1, gender);

	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_GenderAs_FemaleInTheMyList_Test() throws Throwable {
		String gender = "FEMALE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.select_Gender(driver, gender);
		ip.clickOn_SearchButton_Filters(driver);
		String gender1 = ip.capture_Gender(driver);
		Assert.assertEquals(gender1, gender);

	}

//	@Test
//	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_RegistrtaionFrom_To_DateInTheMyList_Test() {
//
//	}

//	@Test
//	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_PassportAvailableInTheMyList_Test() {
//
//	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_HospitalNumber_InTheAllPatientList_Test()
			throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String hospitalNumber1 = ip.capture_HospitalNumber_AllPatientList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);

	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_PatientName_InTheAllPatientList_Test()
			throws Throwable {

		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String patientName = alp.takeThePatientNameInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.enter_PatientName(driver, patientName);
		ip.clickOn_SearchButton_Filters(driver);
		String patientName1 = ip.capture_PatientName_AllPatientList(driver);
		Assert.assertEquals(patientName1, patientName);

	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_IpNumber_InTheAllPatientList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String ipNumber = alp.takeIpNumberInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.enter_IpNumber(driver, ipNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String ipNumber1 = ip.capture_IpNumber_AllPatientList(driver);
		Assert.assertEquals(ipNumber1, ipNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_PhoneNumber_InTheAllPatientList_Test()
			throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		String phoneNumber = ip.capture_PhoneNumber_LastRow_AllpatientList(driver);
		ip.enter_PhoneNumber(driver, phoneNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String phoneNumber1 = ip.capture_PhoneNumber_AllPatientList(driver);
		Assert.assertEquals(phoneNumber1, phoneNumber);
	}

//	@Test
//	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_AlternativePhoneNumber_InTheAllPatientList_Test()
//			throws Throwable {
//
//	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_Department_InTheAllPatientList_Test()
			throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String department = alp.takeDepartmentNameInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.select_Department_MyList(driver, department);
		ip.clickOn_SearchButton_Filters(driver);
		String department1 = ip.capture_department_AllPatientList(driver);
		Assert.assertEquals(department1, department);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_WardType_InTheAllPatientList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.select_WardType_MyList(driver, wardType);
		ip.clickOn_SearchButton_Filters(driver);
		String hospitalNumber1 = ip.capture_HospitalNumber_AllPatientList(driver);

		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_RoomType_InTheAllPatientList_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.select_WardType_MyList(driver, wardType);
		ip.select_RoomType(driver, roomType);
		ip.clickOn_SearchButton_Filters(driver);
		String hospitalNumber1 = ip.capture_HospitalNumber_AllPatientList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_BedNumber_InTheAllPatientList_Test()
			throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);
		String bedNumber = alp.takeBedNumberInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.select_WardType_MyList(driver, wardType);
		ip.select_RoomType(driver, roomType);
		ip.enter_BedNumber(driver, bedNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String hospitalNumber1 = ip.capture_HospitalNumber_AllPatientList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_GenderAsFemale_InTheAllPatientList_Test()
			throws Throwable {
		String gender = "FEMALE";

		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
		ip.select_Gender(driver, gender);
		ip.clickOn_SearchButton_Filters(driver);
		String gender1 = ip.capture_Gender_AllPatientList(driver);
		Assert.assertEquals(gender1, gender);
	}

//	@Test
//	public void checkThatUserShouldFilterPatientDetailsWithHelpOf_RegistrationFrom_To_Date_InTheAllPatientList_Test()
//			throws Throwable {
//
//	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_HospitalNumber_InTheCrossreferralList_Test()
			throws Throwable {

		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		String hospitalNumber = ip.captureLastRow_HospitalNumber_CrossReferralList(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOn_SearchButton_Filters(driver);
		ip.capture_AndVerify_hospitalNumbers_CrossreferralList(driver, hospitalNumber);

	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_PatientName_InTheCrossreferralList_Test()
			throws Throwable {
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		String patientName = ip.captureLastRow_patientName_CrossReferralList(driver);
		ip.enter_PatientName(driver, patientName);
		ip.clickOn_SearchButton_Filters(driver);
		String patientName1 = ip.capture_PatientName_CrossreferralList(driver);
		Assert.assertEquals(patientName, patientName1);

	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_IpNumber_InTheCrossreferralList_Test()
			throws Throwable {
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		String ipNumber = ip.captureLastRow_IpNumber_CrossReferralList(driver);
		ip.enter_IpNumber(driver, ipNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String ipNumber1 = ip.capture_IpNumber_CrossreferralList(driver);
		Assert.assertEquals(ipNumber1, ipNumber);
	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_PhoneNumber_InTheCrossreferralList_Test()
			throws Throwable {
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		String phoneNumber = ip.captureLastRow_PhoneNumber_CrossReferralList(driver);
		ip.enter_PhoneNumber(driver, phoneNumber);
		ip.clickOn_SearchButton_Filters(driver);
		String phoneNumber1 = ip.capture_PhoneNumber_CrossreferralList(driver);
		Assert.assertEquals(phoneNumber1, phoneNumber);
	}

//	@Test
//	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_AlternativePhoneNumber_InTheCrossreferralList_Test() {
//
//	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_WardType_InTheCrossreferralList_Test()
			throws Throwable {
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");
		String status = "ACTIVE";

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearButton(driver);
		alp.selectPatientStatusDropdown(driver, status);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.selectWardType(driver, wardType);
		ip.clickOn_SearchButton_Filters(driver);
		ip.capture_AndVerify_hospitalNumbers_CrossreferralList(driver, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_RoomType_InTheCrossreferralList_Test()
			throws Throwable {
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");
		String status = "ACTIVE";

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearButton(driver);
		alp.selectPatientStatusDropdown(driver, status);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.selectWardType(driver, wardType);
		ip.select_RoomType(driver, roomType);
		ip.clickOn_SearchButton_Filters(driver);
		ip.capture_AndVerify_hospitalNumbers_CrossreferralList(driver, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_BedNumber_InTheCrossreferralList_Test()
			throws Throwable {
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");
		String status = "ACTIVE";

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearButton(driver);
		alp.selectPatientStatusDropdown(driver, status);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);
		String bedNumber = alp.takeBedNumberInTheActivePatinet_Table(driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.selectWardType(driver, wardType);
		ip.select_RoomType(driver, roomType);
		ip.enter_BedNumber(driver, bedNumber);
		ip.clickOn_SearchButton_Filters(driver);
		ip.capture_AndVerify_hospitalNumbers_CrossreferralList(driver, hospitalNumber);

	}

	@Test
	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_GenderAsFemale_InTheCrossreferralList_Test()
			throws Throwable {
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");
		String gender = "FEMALE";

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOn_CrossReferralTab(driver);
		ip.clickOn_ClearButton_Filters(driver);
		ip.select_Gender(driver, gender);
		ip.clickOn_SearchButton_Filters(driver);
		ip.captureTotalList_Genders_CrossreferralList(driver, gender);
	}

//	@Test
//	public void checkThatUserShouldbeFilterThePatientDetailsWithHelpOf_RegistrationFromDate_RegistrtaionToDate_InTheCrossreferralList_Test() {
//
//	}

	@Test
	public void checkThatUserShouldbeFilter_DischargeDetails_WithHelpOf_HospitalNumber_AllpatientList()
			throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);

		ip.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.clickOn_Checkbox_ShowAllFilters_AllPatientList(driver);
//		ip.selectdis
	}

	@Test
	public void checkThatUserShouldbeFilter_DischargeDetails_WithHelpOf_PatientName_AllpatientList() {

	}

	@Test
	public void checkThatUserShouldbeFilter_DischargeDetails_WithHelpOf_IpNumber_AllpatientList() {

	}

	@Test
	public void checkThatUserShouldbeFilter_DischargeDetails_WithHelpOf_PhoneNumber_AllpatientList() {

	}

	@Test
	public void checkThatUserShouldbeFilter_DischargeDetails_WithHelpOf_Department_AllpatientList() {

	}

	@Test
	public void checkThatUserShouldbeFilter_DischargeDetails_WithHelpOf_WardType_AllpatientList() {

	}
}
