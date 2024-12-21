package Test;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SendToLabPage;

public class Lab extends BaseClass {
	@Test(invocationCount = 3)
	public void tet() throws Throwable {
		String registrationType = "EMERGENCY";
		String department = "NEUROLOGY";
		String doctor = "SURE";
		String bedCategory = "NON TEACHING";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION";
		String floor = "5TH FLOOR";
		String wings = "EAST WING";
		String admittedByDr = "abbas";
		String time = "";
		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String doctorName = "SURESHA KODAPALA";
		String route = "ORAL";
		String receivedAtLab = "YES";

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		hp.homeBtnForvims(driver);
		op.createOpdRegistrationForIpPatients(driver, registrationType, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// add investigations
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
//		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		Thread.sleep(3000);
		ipd.clickAddBtnInInvestigationtab(driver);
		// ipd.addTheInvestigation(driver, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		System.out.println(hospitalNumber);

		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(username, password, driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
		sam.sampleCollection1(driver, hospitalNumber);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow(driver, "sampleNumber");

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

	}
}
