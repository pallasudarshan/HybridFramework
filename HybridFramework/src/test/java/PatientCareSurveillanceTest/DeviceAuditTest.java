package PatientCareSurveillanceTest;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DeviceAuditPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

public class DeviceAuditTest extends BaseClass {

	@Test
	public void checkThatUserAbleToCreateTheDeviceAuditTest() throws Throwable {

		String deviceName = "iv cannula";

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DeviceAuditPage da = new DeviceAuditPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearBtn(driver);
		String hospitalNumber = alp.take_LastrRow_HospitalNumber_ActiveList(driver);

		hp.homeBtnForvims(driver);
		da.clickOnThePatientCareSurveillance(driver);
		da.clickOnTheDeviceAuditButton(driver);
		da.clickOnNewButtonAndenterHospitalNumber(driver, hospitalNumber);
		da.selectTheDevice(driver, deviceName);
	}
}
