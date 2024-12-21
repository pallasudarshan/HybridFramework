package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AppointmentBookingPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class AppointmentBookingTest extends BaseClass {
	@Test
	public void checkThatUserClickOnBooknowButtonWithoutSelectingAppointmentType_Test() throws Throwable {

		String bookingTime = "1230";
		String name = "TEST";
		String gender = "male";
		String mobileNumber = "9999988888";
		String emailId = "depart@dalvkot.com";
		String department = "CARDIOLOGY";
		String doctorName = "VIJAYA SAI";

		String msg = "Please Select Appointment Type";

		HomePage hp = new HomePage(driver);
		AppointmentBookingPage ap = new AppointmentBookingPage(driver);

		hp.homeBtnForvims(driver);
		ap.clickOnAppointmentBooking(driver);
		ap.selectBookingDate(driver);
		ap.SelectBookingTime(driver, bookingTime);
		ap.enterTheName(driver, name);
		ap.selectGneder(driver, gender);
		ap.selectDateOfBirth(driver);
		ap.erterMobileNumber(driver, mobileNumber);
		ap.enterEmailId(driver, emailId);
		ap.selectDepartment(driver, department);
		ap.selectDoctorName(driver, doctorName);
		ap.clickOnBooknowButton(driver);
		String msg1 = ap.errorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the  :" + msg1 + "  Succssfully");
	}

	@Test
	public void checkThaaUserClickOnTheBooknowButtonWithoutSelectingBookingDate_Test() throws Throwable {
		String appointmentType = "TELEPHONIC";
		String bookingTime = "1230";
		String name = "TEST";
		String gender = "male";
		String mobileNumber = "9999988888";
		String emailId = "depart@dalvkot.com";
		String department = "CARDIOLOGY";
		String doctorName = "VIJAYA SAI";

		String msg = "Please Select Booking date";

		HomePage hp = new HomePage(driver);
		AppointmentBookingPage ap = new AppointmentBookingPage(driver);

		hp.homeBtnForvims(driver);
		ap.clickOnAppointmentBooking(driver);
		ap.selectAppointmentType(driver, appointmentType);

		ap.SelectBookingTime(driver, bookingTime);
		ap.enterTheName(driver, name);
		ap.selectGneder(driver, gender);
		ap.selectDateOfBirth(driver);
		ap.erterMobileNumber(driver, mobileNumber);
		ap.enterEmailId(driver, emailId);
		ap.selectDepartment(driver, department);
		ap.selectDoctorName(driver, doctorName);
		ap.clickOnBooknowButton(driver);
		String msg1 = ap.errorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the  :" + msg1 + "  Succssfully");
	}

	@Test
	public void checkThaaUserClickOnTheBooknowButtonWithoutSelectingBookingTime_Test() throws Throwable {
		String appointmentType = "TELEPHONIC";
		String name = "TEST";
		String gender = "male";
		String mobileNumber = "9999988888";
		String emailId = "depart@dalvkot.com";
		String department = "CARDIOLOGY";
		String doctorName = "VIJAYA SAI";

		String msg = "Please Select Booking time";

		HomePage hp = new HomePage(driver);
		AppointmentBookingPage ap = new AppointmentBookingPage(driver);

		hp.homeBtnForvims(driver);
		ap.clickOnAppointmentBooking(driver);
		ap.selectAppointmentType(driver, appointmentType);
		ap.selectBookingDate(driver);
		ap.enterTheName(driver, name);
		ap.selectGneder(driver, gender);
		ap.selectDateOfBirth(driver);
		ap.erterMobileNumber(driver, mobileNumber);
		ap.enterEmailId(driver, emailId);
		ap.selectDepartment(driver, department);
		ap.selectDoctorName(driver, doctorName);
		ap.clickOnBooknowButton(driver);
		String msg1 = ap.errorMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the  :" + msg1 + "  Succssfully");
	}

	@Test
	public void checkThatUserClickOnBooknowButtonWithoutEnteringName_Test() throws Throwable {

//		String appointmentType = "TELEPHONIC";
//		String bookingTime = "1230";
//		String gender = "male";
//		String mobileNumber = "9999988888";
//		String emailId = "depart@dalvkot.com";
//		String department = "CARDIOLOGY";
//		String doctorName = "VIJAYA SAI";
//
//		String msg = "Please Enter Name";
//
//		HomePage hp = new HomePage(driver);
//		AppointmentBookingPage ap = new AppointmentBookingPage(driver);
//
//		hp.homeBtnForvims(driver);
//		ap.clickOnAppointmentBooking(driver);
//		ap.selectAppointmentType(driver, appointmentType);
//		ap.selectBookingDate(driver);
//		ap.SelectBookingTime(driver, bookingTime);
//		ap.selectGneder(driver, gender);
//		ap.selectDateOfBirth(driver);
//		ap.erterMobileNumber(driver, mobileNumber);
//		ap.enterEmailId(driver, emailId);
//		ap.selectDepartment(driver, department);
//		ap.selectDoctorName(driver, doctorName);
//		ap.clickOnBooknowButton(driver);
//		String msg1 = ap.errorMessage(driver);
//		Assert.assertEquals(msg1, msg);
//		System.out.println("User got the  :" + msg1 + "  Succssfully");
	}

	@Test(invocationCount = 10)
	public void checkThatUserShouldCreateTheAppointmentBooking_Test() throws Throwable {

		String appointmentType = "TELEPHONIC";
		String bookingTime = "1230";
		String name = "TEST";
		String gender = "male";
		String mobileNumber = "9999988888";
		String emailId = "depart@dalvkot.com";
		String department = "CARDIOLOGY";
		String doctorName = "VIJAYA SAI";

		

		HomePage hp = new HomePage(driver);
		AppointmentBookingPage ap = new AppointmentBookingPage(driver);

		hp.homeBtnForvims(driver);
		ap.clickOnAppointmentBooking(driver);
		ap.selectAppointmentType(driver, appointmentType);
		ap.selectBookingDate(driver);
		ap.SelectBookingTime(driver, bookingTime);
		ap.enterTheName(driver, name);
		ap.selectGneder(driver, gender);
		ap.selectDateOfBirth(driver);
		ap.erterMobileNumber(driver, mobileNumber);
		ap.enterEmailId(driver, emailId);
		ap.selectDepartment(driver, department);
		ap.selectDoctorName(driver, doctorName);
		ap.clickOnBooknowButton(driver);

	}

}
