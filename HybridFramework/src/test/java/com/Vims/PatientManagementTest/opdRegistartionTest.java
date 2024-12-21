package com.Vims.PatientManagementTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.IpBillingPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.PAC_Anaesthesia_SchedulePage;
import com.Dalvkot.Vims_ObjectRepositary.PacAnaesthesiaConfirmationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

import net.bytebuddy.implementation.bind.annotation.Super;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class opdRegistartionTest extends BaseClass {

	@Test
	public void checkThatUserShouldUploadThePhoto_Test() throws Throwable {
		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);

		op.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		op.takeThe_Picture_UsingWebCam(driver);
	}

	@Test
	public void toVerifyThatUserIsAbleToViewTheEmergencyPatientInOpBilling_Test() throws Throwable {
		String registrationType = "EMERGENCY";
		String name = "Test";
		String year = "23";
		String ServiceNames = futil.getProperyKeyValue("Services");

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		op.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		op.registrationTypeDropDown(driver, registrationType);
		op.firstName(name);
		op.AgeText(year);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, ServiceNames);
		hs.clickOnSubmit(driver);
	}

}
