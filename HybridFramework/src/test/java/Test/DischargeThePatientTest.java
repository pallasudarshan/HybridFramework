package Test;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;

public class DischargeThePatientTest extends BaseClass {

	@Test
	public void dischargeThePatientTest() throws Throwable {

		String assignDoctorName = "rama mishra";
		String notesEntry = "";
		String un = "automationhod@demo.com";
		String pw = "12345";

		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		ipd.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, assignDoctorName);
		ipd.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notesEntry);
//		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

	}
}
