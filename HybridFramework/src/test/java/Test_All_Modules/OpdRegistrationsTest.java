package Test_All_Modules;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;

public class OpdRegistrationsTest  extends BaseClass{
	
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
	
		HomePage hp = new HomePage(driver);

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println(hospitalNumber);
	}*/

}
