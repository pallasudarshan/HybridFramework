package com.Vims.Surya_MasterScreens_Test;

import java.time.LocalDate;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.RadiologyRegistrationListPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

import net.bytebuddy.asm.Advice.Local;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class opdRegistration_Test extends BaseClass {
	/*@DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][]{
        	
        	    {"GENERAL MEDICINE", "rama"},
                {"CARDIOLOGY", "VIJAY"},             
                {"DERMATOLO", "BHAN"},
                {"DENTAL", "MAYURNATH"},
                {"CARDIO THORACIC", "DURGA"},
                {"ENDOCRINOLOGY", "VIJAYA"},
                {"NEUROLOGY", "SURESH"},
                {"PHYSIOTHERAPY", "MANJULA"},
                {"EMERGENCY MEDICIN", "KALPANA"},
                {"FORENSIC", "JAGADISH"},
                {"INTENSIVE CARE MEDICINE", "MENAKA"},
                {"MEDICAL ONCOLOGY", "SHASHI"},
                {"MEDICAL GASTROENTEROLOGY", "PRAVEEN MATHEW"},
                {"NEPHROLOGY", "GIRISH"},
                {"GENERAL MEDICINE", "DR.LOKESH"},
                {"NEUROLOGY", "SURESHA"},
                {"DERMATOLO", "BHAN"},
                {"DENTAL", "MAYURNATH"},
                {"CARDIO THORACIC", "DURGA"},
                {"ENDOCRINOLOGY", "VIJAYA"},
                {"NEUROLOGY", "SURESH"},
                {"PHYSIOTHERAPY", "MANJULA"},
                {"EMERGENCY MEDICIN", "KALPANA"},
                {"FORENSIC", "JAGADISH"},
                {"INTENSIVE CARE MEDICINE", "MENAKA"},
                {"MEDICAL ONCOLOGY", "SHASHI"},
                {"MEDICAL GASTROENTEROLOGY", "PRAVEEN MATHEW"},
                {"NEPHROLOGY", "GIRISH"},
      

                     
        };
    }

	@Test (dataProvider  = "loginData")
	public void createPatientInOpdRegistartion_Test(String depName,String doctorname) throws Throwable {
	
		
		String name = "";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname, mobilenum, mail, address, pincode,postOffice, depName, doctorname);
		Thread.sleep(1000);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		
	}
	
	@Test (dataProvider  = "loginData")
	public void createPatientInOpdRegistartionForFemalePatients_Test(String depName,String doctorname) throws Throwable {
	
		
		String name = "";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVimsFemalePatient(driver, name, year, fname, mobilenum, mail, address, pincode,postOffice, depName, doctorname);
		Thread.sleep(1000);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		
	}
	
	
	@Test
	public void createPatientInOpdRegistartionForGeneralMedicine_Test() throws Throwable {
		String name = "";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "ANAND";
		String depName ="GENERAL MEDICINE";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		
		int numberOfIterations = 200; 
	    int counter = 0;
	       
	    while (counter < numberOfIterations) {
			
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,postOffice, depName, doctorname);
		Thread.sleep(1000);
		opdregistrationpage.submitAnd_ViewBtn2(driver);
		
		counter++;
		 }
		
		Thread.sleep(1000);
	
		}
	

	 @Test
	public void createPatientInOpdRegistartionNeurology_Test() throws Throwable {

		String name = "";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "SURESHA KODAPALA";
		String depName ="neurology";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		
		int numberOfIterations = 350; 
	    int counter = 0;
	       
	    while (counter < numberOfIterations) {
			
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,postOffice, depName, doctorname);
		Thread.sleep(1000);
		opdregistrationpage.submitAnd_ViewBtn2(driver);
		
		counter++;
		 }
		
		Thread.sleep(1000);
	
		}
	
	@Test
	public void createPatientInOpdRegistartionDermatalogy_Test() throws Throwable {

		String name = "";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "SHASHI";
		String depName ="MEDICAL ONCOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		HomePage hp = new HomePage(driver);
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		
		int numberOfIterations = 350; 
	    int counter = 0;
	       
	    while (counter < numberOfIterations) {
			
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,postOffice, depName, doctorname);
		Thread.sleep(1000);
		opdregistrationpage.submitAnd_ViewBtn2(driver);
			
		counter++;
	    }
		
		Thread.sleep(1000);
		}
	
		}*/


}
	