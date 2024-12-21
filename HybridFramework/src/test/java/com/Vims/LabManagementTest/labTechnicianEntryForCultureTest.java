package com.Vims.LabManagementTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LabTechnicianEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class labTechnicianEntryForCultureTest extends BaseClass {

//	@Test
//
//	public void verifyNoResult() throws Throwable {
//		
//			LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
//			ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
//			
//			HomePage hp = new HomePage(driver);
//			SearchPatientPage sp = new SearchPatientPage(driver);
//		    Hospital_Service_Bill_page hs=new Hospital_Service_Bill_page(driver);
//			
//			String name = "S";
//			String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//			String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//			String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//			String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//			String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//			String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//			String doctorname = "rama";
//			String depName ="general medicine";
//			String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		
//			
//			String receivedAtLab = "YES";
//			SampleCollectionPage sam =new SampleCollectionPage(driver);

//	        //----OPD registration---------
//			hp.homeBtnForvims(driver);
//			OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//			opdregistrationpage.opdRegistrationButton(driver);
//			opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,postOffice, depName, doctorname);
//			Thread.sleep(1000);
//			opdregistrationpage.submitAnd_ViewBtn(driver);
//			hp.homeBtnForvims(driver);
//			sp.clickOnTheSearchPatientButton(driver);
//			String hospitalNumber=sp.captureHospitalNumberInTheTable();
//		
//			
//			//----op billing-----------
//			String serviceName="BLOOD- FUNGAL MANUAL CULTURE";
//			hp.homeBtnForvims(driver);
//			hs.clickOnHospitalServiceBillLink(driver);
//			hs.clickonNewBillButton(driver);
//			hs.enterHospitalNumber(hospitalNumber);
//			hs.addServicesInOpBilling(driver,serviceName);
//			hs.clickOnSubmit(driver);
//							
//			//-----sample collection---------
//			hp.homeBtnForvims(driver);
//			sam.clickOnSampleCollectionPage(driver);
//			sam.sampleCollection(driver, hospitalNumber);
//			
//			//-----reciept sampler at lab-------------
//			hp.homeBtnForvims(driver);
//			rsa.clickOnReceiptAtSampleLabBtn(driver);
//			String serviceClass="MICROBIOLOGY";
//			rsa.selectServiceClass(driver, serviceClass);
//			rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

//			//-------lab technician entryy----------------------------
//			hp.homeBtnForvims(driver);
//			lt.labtechnicianEntryPage(driver);
//			String serviceClass="MICROBIOLOGY";
//			String hospitalNumber="";
//			lt.selectServiceClassDropDown(driver, serviceClass,hospitalNumber);
//			lt.selectPositveAndFinalGrowthAndSubmit(driver);
//			
//
//}
//}
}
