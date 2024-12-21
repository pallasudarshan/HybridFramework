package com.Vims.DoctordeskEnhancements;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

public class DocumentUploadFunctionality_DDOPD extends BaseClass {

	
	@Test(description = "To verify that users can successfully upload documents in the saved dietician note edit option in the Visit Detail tab")
	public void verifySuccessfulDocumentUploadInTheEditOptionForSavedDieticianNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = eutil.getDataFromTheExcel_DoctorDesk("diet", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Successfully document Is Uploaded");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "To verify that users can successfully upload documents in the dietician note under notes entry tab")
	public void verifySuccessfulDocumentUploadForSavedDieticianNoteUnderNotesEntry_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "DIETICIAN NOTES";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Successfully document Is Uploaded");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that document description , uploaded date and doctor name is displaying correctly after saving the document in the edit option for saved dietician note under visit details tab")
	public void verifyDetailsAreReflectedCorrectlyAfterDocumentUploadInTheEditForSavedDieticianNot_VisitDetailsTab_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = eutil.getDataFromTheExcel_DoctorDesk("diet", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Document upload failed");
		dp.clickOnOkBtn(driver);

		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to delete the saved document in the edit option for the saved dietitian note under the 'Visit Details' tab")
	public void verifyDeletionOfSavedDocumentInDietitianNotesInTheEdit_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = eutil.getDataFromTheExcel_DoctorDesk("diet", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Document upload failed");
		dp.clickOnOkBtn(driver);

		String reason = "Testing document delete functionality";

		dp.clickOnDeleteIcon_DocumentUpload(driver);
		dp.enterReasonDeletePopUp(driver, reason);
		dp.clickOnSubmit_DeletePopUP(driver);
		String successPopUp = dp.captureErrorText(driver);
		Assert.assertEquals(successPopUp, "Successfully Status is Deleted", "success message is miss matched");
	}

	@Test(description = "To verify that users can successfully upload multiple documents in the saved dietician note edit option in the Visit Detail tab")
	public void verifySuccessfulUploadMultipleDocumentUploadInTheEditOptionForSavedDieticianNote_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = eutil.getDataFromTheExcel_DoctorDesk("diet", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		int count = 5;
		dp.uploadMultipleDocuments_Loop(driver, absoluteFilePath, count);
	}

	@Test(description = "Verify that the user is able to delete multiple documents at a time in the edit option for the saved dietitian note under the 'Visit Details' tab")
	public void verifyDeletionOfMultipleDocumentsInDietitianNotesInTheEdit_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = eutil.getDataFromTheExcel_DoctorDesk("diet", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();
		int addCount = 5;

		dp.uploadMultipleDocuments_Loop(driver, absoluteFilePath, addCount);

		String reason = "Testing document delete functionality";

		int deleteCount = 3;
		dp.deleteMultipleDocuments_Loop(driver, reason, deleteCount);

		int size = dp.getRowSize_DocumentUpload(driver);
		Assert.assertEquals(size, addCount - deleteCount, "Size is miss matched");
	}

	@Test(description = "Verify that document description , uploaded date and doctor name is displaying correctly after saving the document in the view option for dietician note under visit details tab")
	public void verifyDetailsAreReflectedCorrectlyAfterDocumentUploadInTheViewForSavedDieticianNote_VisitDetailsTab_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = eutil.getDataFromTheExcel_DoctorDesk("diet", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Document upload failed");
		dp.clickOnOkBtn(driver);
		dp.clickOnTheCloseButtonInTheEditPopUp(driver);
		dp.clickOnView_Action_VisitDetails(driver);

		Thread.sleep(2000);
		String documentDescription = dp.captureDocumentDescription_View(driver);
		String uploadedDate = dp.captureUploadDate_view(driver);
		String doctorName = dp.captureDoctorName_view(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "To verify that users can successfully upload documents in the signed death note edit option in the Visit Detail tab")
	public void verifySuccessfulDocumentUploadInTheEditOptionForSignedDeathnNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Successfully document Is Uploaded");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "To verify that users can successfully upload documents in the drafted death note edit option in the Visit Detail tab")
	public void verifySuccessfulDocumentUploadInTheEditOptionForDraftedDeathnNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnDraftBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Successfully document Is Uploaded");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that document description , uploaded date and doctor name is displaying correctly after saving the document in the edit option for signed death under visit details tab")
	public void verifyDetailsAreReflectedCorrectlyAfterDocumentUploadInTheEditForSignedDeathNote_VisitDetailsTab_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Document upload failed");
		dp.clickOnOkBtn(driver);

		Thread.sleep(1000);
		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to delete the saved document in the edit option for the signed death note under the 'Visit Details' tab")
	public void verifyDeletionOfSavedDocumentInDeathNoteInTheEdit_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Document upload failed");
		dp.clickOnOkBtn(driver);

		String reason = "Testing document delete functionality";

		dp.clickOnDeleteIcon_DocumentUpload(driver);
		dp.enterReasonDeletePopUp(driver, reason);
		dp.clickOnSubmit_DeletePopUP(driver);
		String successPopUp = dp.captureErrorText(driver);
		Assert.assertEquals(successPopUp, "Successfully Status is Deleted", "success message is miss matched");
	}

	@Test(description = "To verify that users can successfully upload multiple documents in the signed death note edit option in the Visit Detail tab")
	public void verifySuccessfulUploadMultipleDocumentUploadInTheEditOptionForSignedDeathNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		int count = 5;
		dp.uploadMultipleDocuments_Loop(driver, absoluteFilePath, count);
	}

	@Test(description = "Verify that document description , uploaded date and doctor name is displaying correctly after saving the document in the view option for death note under visit details tab")
	public void verifyDetailsAreReflectedCorrectlyAfterDocumentUploadInTheViewForSignedDeathNote_VisitDetailsTab_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Document upload failed");
		dp.clickOnOkBtn(driver);
		dp.clickOnTheCloseButtonInTheEditPopUp(driver);
		dp.clickOnView_Action_VisitDetails(driver);

		Thread.sleep(2000);
		String documentDescription = dp.captureDocumentDescription_View(driver);
		String uploadedDate = dp.captureUploadDate_view(driver);
		String doctorName = dp.captureDoctorName_view(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "To verify that users can successfully upload documents in the death note under notes entry tab")
	public void verifySuccessfulDocumentUploadForSavedDeathNoteUnderNotesEntry_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "DEATH NOTE";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Successfully document Is Uploaded");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that users can successfully upload documents in the Past Investigation tab under History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentUploadInPastInvestigationTabInHistoryAndPhysicalNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnPastInvestigationTab(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Successfully document Is Uploaded");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that users can successfully upload documents in the lab tab under History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentUploadInLabTabInHistoryAndPhysicalNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnLabTab(driver);
		dp.clickOnDocumentUploadIcon(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Successfully document Is Uploaded");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that document description, upload date, and doctor name are displayed correctly after saving the document in the Past Investigation tab under History and Physical Notes.")
	public void verifyDetailsAreReflectedCorrectlyAfterDocumentUploadInThePastInvestigationTab_HistoryAndPhysicalNote_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnPastInvestigationTab(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		dp.clickOnOkBtn(driver);

		Thread.sleep(1000);
		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that document description, upload date, and doctor name are displayed correctly after saving the document in the lab tab under History and Physical Notes.")
	public void verifyDetailsAreReflectedCorrectlyAfterDocumentUploadInTheLabTab_HistoryAndPhysicalNote_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnLabTab(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		dp.clickOnOkBtn(driver);

		Thread.sleep(1000);
		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that users can successfully upload multiple documents in the Past Investigation tab under History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulUploadMultipleDocumentsInPastInvestigationTabInHistoryAndPhysicalNote_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnPastInvestigationTab(driver);
		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		int count = 5;
		dp.uploadMultipleDocuments_Loop(driver, absoluteFilePath, count);
	}

	@Test(description = "Verify that users can successfully upload multiple documents in the lab tab under History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulUploadMultipleDocumentsInLabTabInHistoryAndPhysicalNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.clickOnLabTab(driver);
		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		int count = 5;
		dp.uploadMultipleDocuments_Loop(driver, absoluteFilePath, count);
	}

	@Test(description = "Verify that the user is able to delete multiple documents at a time in the past investigation under the H&P note")
	public void verifyDeletionOfMultipleDocumentsInPastInvestigationTabInHistoryAndPhysicalNote_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.clickOnPastInvestigationTab(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();
		int addCount = 5;

		dp.uploadMultipleDocuments_Loop(driver, absoluteFilePath, addCount);

		String reason = "Testing document delete functionality";

		int deleteCount = 3;
		dp.deleteMultipleDocuments_Loop(driver, reason, deleteCount);

		int size = dp.getRowSize_DocumentUpload(driver);
		Assert.assertEquals(size, addCount - deleteCount, "Size is miss matched");
	}

	@Test(description = "Verify that the user is able to delete multiple documents at a time in the lab tab under the H&P note")
	public void verifyDeletionOfMultipleDocumentsInLabTabInHistoryAndPhysicalNote_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.clickOnLabTab(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();
		int addCount = 5;

		dp.uploadMultipleDocuments_Loop(driver, absoluteFilePath, addCount);

		String reason = "Testing document delete functionality";

		int deleteCount = 3;
		dp.deleteMultipleDocuments_Loop(driver, reason, deleteCount);

		int size = dp.getRowSize_DocumentUpload(driver);
		Assert.assertEquals(size, addCount - deleteCount, "Size is miss matched");
	}

	@Test(description = "Verify that users can successfully upload documents in the edit option for past investigation under drafted History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentUploadInTheEditForPastInvestigationTabInDraftedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = "Entered for testing";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencilIcon_PastInvestigationInEditPopUP(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Success message is miss matched");
		dp.clickOnOkBtn(driver);

		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that users can successfully upload documents in the edit option for Lab under drafted History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentUploadInTheEditForDraftedLabTabInHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = "Entered for testing";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencilIcon_LabInEditPopUP(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Success message is miss matched");
		dp.clickOnOkBtn(driver);

		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that users can successfully upload documents in the edit option for past investigation under signed History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentUploadInTheEditForPastInvestigationTabInSignedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * 
		 * history and physical notes
		 * 
		 */

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = eutil.getDataFromTheExcel_DoctorDesk("HP", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		scrollToTop(driver);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		String gn = "dolo";
		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		dp.addTheCurrentMedication_1(driver, gn, route, pattern, startDate1, qty, notes, status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencilIcon_PastInvestigationInEditPopUP(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		dp.clickOnOkBtn(driver);

		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that users can successfully upload documents in the edit option for lab tab under signed History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentUploadInTheEditForLabTabInSignedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * 
		 * history and physical notes
		 * 
		 */

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = eutil.getDataFromTheExcel_DoctorDesk("HP", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		scrollToTop(driver);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		String gn = "dolo";
		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		dp.addTheCurrentMedication_1(driver, gn, route, pattern, startDate1, qty, notes, status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencilIcon_LabInEditPopUP(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		dp.clickOnOkBtn(driver);

		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that users can successfully delete the uploaded documents in the edit option for past investigation under signed History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentDeleteInTheEditForPastInvestigationTabInSignedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * 
		 * history and physical notes
		 * 
		 */

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = eutil.getDataFromTheExcel_DoctorDesk("HP", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		scrollToTop(driver);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		String gn = "dolo";
		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		dp.addTheCurrentMedication_1(driver, gn, route, pattern, startDate1, qty, notes, status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();
		int addCount = 5;

		dp.uploadMultipleDocumentsForPastInvestigation_Edit_Loop(driver, absoluteFilePath, addCount);

		String reason = "Testing document delete functionality";

		int deleteCount = 3;
		dp.deleteMultipleDocuments_Loop(driver, reason, deleteCount);

		int size = dp.getRowSize_DocumentUpload(driver);
		Assert.assertEquals(size, addCount - deleteCount, "Size is miss matched");
	}

	@Test(description = "Verify that users can successfully delete the uploaded documents in the edit option for lab under signed History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentDeleteInTheEditForLabTabInSignedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * 
		 * history and physical notes
		 * 
		 */

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = eutil.getDataFromTheExcel_DoctorDesk("HP", 0, 0);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		scrollToTop(driver);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		String gn = "dolo";
		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		dp.addTheCurrentMedication_1(driver, gn, route, pattern, startDate1, qty, notes, status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();
		int addCount = 5;

		dp.uploadMultipleDocumentsForLab_Edit_Loop(driver, absoluteFilePath, addCount);

		String reason = "Testing document delete functionality";

		int deleteCount = 3;
		dp.deleteMultipleDocuments_Loop(driver, reason, deleteCount);

		int size = dp.getRowSize_DocumentUpload(driver);
		Assert.assertEquals(size, addCount - deleteCount, "Size is miss matched");
	}

	@Test(description = "Verify that users can successfully delete the uploaded documents in the edit option for past investigation under drafted History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentDeleteInTheEditForPastInvestigationTabInDraftedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = "Entered for testing";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();
		int addCount = 5;

		dp.uploadMultipleDocumentsForPastInvestigation_Edit_Loop(driver, absoluteFilePath, addCount);

		String reason = "Testing document delete functionality";

		int deleteCount = 3;
		dp.deleteMultipleDocuments_Loop(driver, reason, deleteCount);

		int size = dp.getRowSize_DocumentUpload(driver);
		Assert.assertEquals(size, addCount - deleteCount, "Size is miss matched");
	}

	@Test(description = "Verify that users can successfully delete the uploaded documents in the edit option for lab under drafted History and Physical Notes in the Visit Detail tab.")
	public void verifySuccessfulDocumentDeleteInTheEditForLabTabInDraftedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = "Entered for testing";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();
		int addCount = 5;

		dp.uploadMultipleDocumentsForLab_Edit_Loop(driver, absoluteFilePath, addCount);

		String reason = "Testing document delete functionality";

		int deleteCount = 3;
		dp.deleteMultipleDocuments_Loop(driver, reason, deleteCount);

		int size = dp.getRowSize_DocumentUpload(driver);
		Assert.assertEquals(size, addCount - deleteCount, "Size is miss matched");
	}

	@Test(description = "Verify that system displays uploaded documents in the view option for Lab under drafted History and Physical Notes in the Visit Detail tab.")
	public void verifyThatUploadedDocumentDetailsAreDisplayedInTheViewForLabTabInDraftedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = "Entered for testing";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencilIcon_LabInEditPopUP(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Success message is miss matched");
		dp.clickOnOkBtn(driver);

		dp.clickOnTheCloseButtonInTheEditPopUp(driver);
		dp.clickOnView_Action_VisitDetails(driver);

		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that system displays uploaded documents in the view option for past investigation under drafted History and Physical Notes in the Visit Detail tab.")
	public void verifyThatUploadedDocumentDetailsAreDisplayedInTheViewForPastInvestigationTabInDraftedHistoryAndPhysicalNote_VisitDetails_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "HISTORY & PHYSICAL";
		String historyPhysical = "Entered for testing";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.enterDataInIframe_HistoryTabs(driver, historyPhysical);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencilIcon_PastInvestigationInEditPopUP(driver);

		String doc = "./src/main/resources/Documents/d4.png";
		String absoluteFilePath = new File(doc).getAbsolutePath();

		dp.clickOnDocumentUploadIcon(driver);
		dp.chooseFile_UploadDocument(driver, absoluteFilePath);
		dp.clickOnSubmit_UploadDocument(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertTrue(text.toLowerCase().contains("success"), "Success message is miss matched");
		dp.clickOnOkBtn(driver);

		dp.clickOnTheCloseButtonInTheEditPopUp(driver);
		dp.clickOnView_Action_VisitDetails(driver);

		String documentDescription = dp.captureDocumentDescription_DocumentUpload(driver);
		String uploadedDate = dp.captureUploadDate_DocumentUpload(driver);
		String doctorName = dp.captureDoctorName_DocumentUpload(driver);

		String filename = new File(doc).getName();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(documentDescription, filename, "document description is miss matched");
		sa.assertEquals(uploadedDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "uploaded date is miss matched");
		sa.assertEquals(doctorName, doctorName_visitDeatils, "Doctor name is miss matched");
		sa.assertAll();
	}

}
