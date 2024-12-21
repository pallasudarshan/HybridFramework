package Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.DoctorVerificationEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LabTechnicianEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SendToLabPage;

public class labDataGeneration_Test extends BaseClass {

	@Test(invocationCount = 150)
	public void labDataGeneration_OP() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		String un = "automationh@demo.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// --------Do patient arrival----------
		String servicePackage = "AUTOMATION LAB SERVICES";
		Thread.sleep(3000);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		Thread.sleep(1000);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		Thread.sleep(3000);
		dp.clickOnInvestigationTab(driver);
		dp.selectServiePackage_Investigation(driver, servicePackage);
		dp.enterClinicalNotes_listOfWebElement(driver, "remarks");
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		Thread.sleep(3000);
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		String serviceClass1 = "BIOCHEMISTRY";
		String serviceClass2 = "BIOCHEMISTRY IMMUNOASSAY";
		String serviceClass3 = "COAGULATION";
		String serviceClass4 = "CLINICAL PATHOLOGY";
		String serviceClass5 = "CYTOLOGY";
		String serviceClass6 = "FNAC";
		String serviceClass7 = "CYTO GENETICS LAB";
		String serviceClass8 = "HAEMATOLOGY";
		String serviceClass9 = "IMMUNOHISTOCHEMISRY";
		String serviceClass10 = "MICROBIOLOGY";
		String serviceClass11 = "MOLECULAR GENETIC LAB";

		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab_3(driver, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass2, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass3, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass4, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass5, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass6, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass7, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass8, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass9, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass10, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass11, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_1(driver, serviceClass1, hospitalNumber);
		lt.labTechnician(driver, serviceClass2, hospitalNumber);
		lt.labTechnician(driver, serviceClass3, hospitalNumber);
		lt.labTechnician(driver, serviceClass4, hospitalNumber);
		lt.labTechnician(driver, serviceClass5, hospitalNumber);
		lt.labTechnician(driver, serviceClass6, hospitalNumber);
		lt.labTechnician(driver, serviceClass7, hospitalNumber);
		lt.labTechnician(driver, serviceClass8, hospitalNumber);
		lt.labTechnician(driver, serviceClass9, hospitalNumber);
		lt.labTechnician(driver, serviceClass10, hospitalNumber);
		lt.labTechnician(driver, serviceClass11, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_3(driver, hospitalNumber);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass2);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass3);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass4);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass5);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass6);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass7);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass8);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass9);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass10);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass11);
		System.out.println("final " + hospitalNumber);
	}

	@Test(invocationCount = 10)
	public void labDataGeneration_IP() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = "YES";
		String doctor = "rama";
		String department = "general medicine";
		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

		String un = "automationh@demo.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// --------Do patient arrival----------
		String servicePackage = "AUTOMATION LAB SERVICES";
		Thread.sleep(3000);
		ipd.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.clickOnClearButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		ipd.clickOnPatientArrivalBtn(driver, doctorname);
		ipd.ClickOnSavebtn(driver);
		Thread.sleep(3000);
		ipd.clickOnInvestigationTab(driver);
		ipd.selectServiePackage_Investigation(driver, servicePackage);
		Thread.sleep(5000);
//		ipd.enterClinicalNotes_listOfWebElement(driver, "remarks");
//		Thread.sleep(2000);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		Thread.sleep(3000);
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		String billType = "IP";
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, billType, hospitalNumber);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		String serviceClass1 = "BIOCHEMISTRY";
		String serviceClass2 = "BIOCHEMISTRY IMMUNOASSAY";
		String serviceClass3 = "COAGULATION";
		String serviceClass4 = "CLINICAL PATHOLOGY";
		String serviceClass5 = "CYTOLOGY";
		String serviceClass6 = "FNAC";
		String serviceClass7 = "CYTO GENETICS LAB";
		String serviceClass8 = "HAEMATOLOGY";
		String serviceClass9 = "IMMUNOHISTOCHEMISRY";
		String serviceClass10 = "MICROBIOLOGY";
		String serviceClass11 = "MOLECULAR GENETIC LAB";

		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab_3(driver, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass2, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass3, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass4, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass5, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass6, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass7, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass8, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass9, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass10, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass11, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_1(driver, serviceClass1, hospitalNumber);
		lt.labTechnician(driver, serviceClass2, hospitalNumber);
		lt.labTechnician(driver, serviceClass3, hospitalNumber);
		lt.labTechnician(driver, serviceClass4, hospitalNumber);
		lt.labTechnician(driver, serviceClass5, hospitalNumber);
		lt.labTechnician(driver, serviceClass6, hospitalNumber);
		lt.labTechnician(driver, serviceClass7, hospitalNumber);
		lt.labTechnician(driver, serviceClass8, hospitalNumber);
		lt.labTechnician(driver, serviceClass9, hospitalNumber);
		lt.labTechnician(driver, serviceClass10, hospitalNumber);
		lt.labTechnician(driver, serviceClass11, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_3(driver, hospitalNumber);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass2);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass3);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass4);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass5);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass6);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass7);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass8);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass9);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass10);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass11);
		System.out.println("final " + hospitalNumber);

	}

	@Test // (invocationCount = 5)
	public void labDataGeneration_IP_particularHospitalNumber() throws Throwable {
		String hospitalNumber = "8667068";

		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		// -----sample collection---------
		String billType = "IP";
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, billType, hospitalNumber);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		String serviceClass1 = "BIOCHEMISTRY";
		String serviceClass2 = "BIOCHEMISTRY IMMUNOASSAY";
		String serviceClass3 = "COAGULATION";
		String serviceClass4 = "CLINICAL PATHOLOGY";
		String serviceClass5 = "CYTOLOGY";
		String serviceClass6 = "FNAC";
		String serviceClass7 = "CYTO GENETICS LAB";
		String serviceClass8 = "HAEMATOLOGY";
		String serviceClass9 = "IMMUNOHISTOCHEMISRY";
		String serviceClass10 = "MICROBIOLOGY";
		String serviceClass11 = "MOLECULAR GENETIC LAB";

		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab_3(driver, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass2, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass3, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass4, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass5, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass6, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass7, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass8, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass9, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass10, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass11, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_1(driver, serviceClass1, hospitalNumber);
		lt.labTechnician(driver, serviceClass2, hospitalNumber);
		lt.labTechnician(driver, serviceClass3, hospitalNumber);
		lt.labTechnician(driver, serviceClass4, hospitalNumber);
		lt.labTechnician(driver, serviceClass5, hospitalNumber);
		lt.labTechnician(driver, serviceClass6, hospitalNumber);
		lt.labTechnician(driver, serviceClass7, hospitalNumber);
		lt.labTechnician(driver, serviceClass8, hospitalNumber);
		lt.labTechnician(driver, serviceClass9, hospitalNumber);
		lt.labTechnician(driver, serviceClass10, hospitalNumber);
		lt.labTechnician(driver, serviceClass11, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_3(driver, hospitalNumber);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass2);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass3);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass4);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass5);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass6);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass7);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass8);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass9);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass10);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass11);
		System.out.println("final " + hospitalNumber);
	}

	@Test(invocationCount = 5)
	public void labDataGeneration_OP_ParticularHospitalNumber() throws Throwable {
		String hospitalNumber = "";

		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		String serviceClass1 = "BIOCHEMISTRY";
		String serviceClass2 = "BIOCHEMISTRY IMMUNOASSAY";
		String serviceClass3 = "COAGULATION";
		String serviceClass4 = "CLINICAL PATHOLOGY";
		String serviceClass5 = "CYTOLOGY";
		String serviceClass6 = "FNAC";
		String serviceClass7 = "CYTO GENETICS LAB";
		String serviceClass8 = "HAEMATOLOGY";
		String serviceClass9 = "IMMUNOHISTOCHEMISRY";
		String serviceClass10 = "MICROBIOLOGY";
		String serviceClass11 = "MOLECULAR GENETIC LAB";

		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab_3(driver, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass2, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass3, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass4, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass5, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass6, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass7, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass8, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass9, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass10, hospitalNumber, receivedAtLab);
		rsa.ReceiptAtSampleLab_2(driver, serviceClass11, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_1(driver, serviceClass1, hospitalNumber);
		lt.labTechnician(driver, serviceClass2, hospitalNumber);
		lt.labTechnician(driver, serviceClass3, hospitalNumber);
		lt.labTechnician(driver, serviceClass4, hospitalNumber);
		lt.labTechnician(driver, serviceClass5, hospitalNumber);
		lt.labTechnician(driver, serviceClass6, hospitalNumber);
		lt.labTechnician(driver, serviceClass7, hospitalNumber);
		lt.labTechnician(driver, serviceClass8, hospitalNumber);
		lt.labTechnician(driver, serviceClass9, hospitalNumber);
		lt.labTechnician(driver, serviceClass10, hospitalNumber);
		lt.labTechnician(driver, serviceClass11, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_3(driver, hospitalNumber);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass2);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass3);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass4);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass5);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass6);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass7);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass8);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass9);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass10);
		df.doctorVerificationEntry_2(driver, hospitalNumber, serviceClass11);
		System.out.println("final " + hospitalNumber);
	}

	@Test
	public void labDataGeneration_OP_Dynamic() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		String un = "automationh@demo.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// --------Do patient arrival----------
		String servicePackage = "AUTOMATION LAB SERVICES";
		Thread.sleep(3000);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		Thread.sleep(1000);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		Thread.sleep(3000);
		dp.clickOnInvestigationTab(driver);
		dp.selectServiePackage_Investigation(driver, servicePackage);
		dp.enterClinicalNotes_listOfWebElement(driver, "remarks");
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		Thread.sleep(3000);
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnBackButton(driver);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println(uniqueServiceClassList);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);
	}

	@Test
	public void labDataGeneration_OP_Dynamic_ParticularHospitalNumber() throws Throwable {
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		String hospitalNumber = "8823977";

//		 ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		Thread.sleep(4000);
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnBackButton(driver);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println("Services Class = " + uniqueServiceClassList);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, "YES");

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);
	}

	@Test // (invocationCount = 5)
	public void labDataGeneration_IP_Dynamic() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String doctor = "rama";
		String department = "general medicine";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);
		String un = "automationh@demo.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// --------Do patient arrival----------
		String servicePackage = "AUTOMATION LAB SERVICES";
		Thread.sleep(3000);
		ipd.clickOnTheDoctorDeskIPDScreenButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.clickOnClearButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
//		ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		Thread.sleep(3000);
		ipd.clickOnInvestigationTab(driver);
		ipd.selectServiePackage_Investigation(driver, servicePackage);
		Thread.sleep(5000);
//		ipd.enterClinicalNotes_listOfWebElement(driver, "remarks");
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		Thread.sleep(3000);
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		String billType = "IP";

		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, billType, hospitalNumber);
		sam.clickOnBackButton(driver);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println("Services Class = " + uniqueServiceClassList);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----receipt sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, "YES");

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);

	}

	@Test // (invocationCount = 5)
	public void labDataGeneration_IP_Dynamic_ParticularHospitalNumber() throws Throwable {
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		String hospitalNumber = "8823977";

		// -----sample collection---------
		String billType = "IP";

		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, billType, hospitalNumber);
		sam.clickOnBackButton(driver);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.selectBillTypeFilter(driver, billType);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println("Services Class = " + uniqueServiceClassList);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----receipt sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, "YES");

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);
	}

	@Test(invocationCount = 50)
	public void labDataGeneration_OP_Updated() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		// String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		// ----OPD registration---------
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, "ramya.j@dalvkot.com",
				address, pincode, postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		String un = "automationhod@demo.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		String doctorName = futil.getProperyKeyValue("generalmedicineHod");

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "test";

		// ------Investigations---------
		scrollToTop(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addThreeInvestigations(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);

		Thread.sleep(3000);
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnBackButton(driver);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println(uniqueServiceClassList);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);
		System.out.println("LAB OP Hospital NUmber : " + hospitalNumber);
	}

	@Test(invocationCount = 10)
	public void labDataGeneration_IP_Updated() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String doctor = "rama";
		String department = "general medicine";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "twi";
		String bedRoomType = "twi";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, "", address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

//		String hospitalNumber = "8824163";

		String un = "automationp@demo.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		String assignDoctorName = "rama mishra";
		ipd.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, assignDoctorName);
		ipd.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "test";

		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		ipd.clickAddBtnInInvestigationtab(driver);

		List<String> investigations = eutil.fetchDataFromExcel("Investigation", 0);

		ipd.addTheInvestigation(driver, notes, investigations);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		Thread.sleep(3000);
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		String billType = "IP";

		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		Thread.sleep(10000);
		sam.sampleCollection(driver, billType, hospitalNumber);
		sam.clickOnBackButton(driver);
		Thread.sleep(10000);
		sam.selectBillTypeFilter(driver, billType);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println("Services Class = " + uniqueServiceClassList);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----receipt sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, "YES");

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);
		System.out.println("LAB IP Hospital NUmber : " + hospitalNumber);
	}

	@Test(invocationCount = 10)
	public void labDataGeneration_OP_Updated_SingleService() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		String un = "automationh@demo.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		String doctorName = futil.getProperyKeyValue("generalmedicineHod");

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String serviceName = "NT PROBNP";

		// ------Investigations---------
		scrollToTop(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addInvestigations(driver, serviceName);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);

		Thread.sleep(3000);
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
		sam.clickOnBackButton(driver);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println(uniqueServiceClassList);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		Thread.sleep(5000);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);
		System.out.println("LAB OP Hospital NUmber : " + hospitalNumber);
	}

	@Test
	public void labDataGeneration_OP_Updated_Manual() throws Throwable {
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		String hospitalNumber = "8825129";

//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickonNewBillButton(driver);
//		hs.enterHospitalNumber(hospitalNumber);
//		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
//		sam.sampleCollection(driver, hospitalNumber);
//		sam.clickOnBackButton(driver);
		sam.enter_HopsitalNumber_List(driver, hospitalNumber);
		sam.clickOnSearchButton_ListTable(driver);
		List<String> serviceClass = sam.captureListOfServiceClasses_ListTable(driver);
		Set<String> uniqueServiceClass = new LinkedHashSet<>(serviceClass);
		List<String> uniqueServiceClassList = new ArrayList<>(uniqueServiceClass);
		System.out.println(uniqueServiceClassList);

//		// -------Send to lab -----------
//		sendToLab.clickOnSendToLabScreenBtn(driver);
//		Thread.sleep(5000);
//		hp.homeBtnForvims(driver);
//		sendToLab.sendToLabFlow_2(driver, hospitalNumber);
////
		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.runReceiptAtSampleLab(driver, uniqueServiceClassList, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.labTechnician_Dynamic(driver, uniqueServiceClassList, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry_dynamic(driver, uniqueServiceClassList, hospitalNumber);
		System.out.println("LAB OP Hospital NUmber : " + hospitalNumber);
	}
}
