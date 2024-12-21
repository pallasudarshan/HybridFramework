package Test;

import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.PAC_Anaesthesia_SchedulePage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.otConfirmationPage;

public class OnPatientAllDataTest extends BaseClass {

	@Test(invocationCount = 20)
	public void test() throws Throwable {
		String doctorname = "VIJAYA";
		String depName = "ENDOCRINOLOGY";

		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

//		String department = "GENERAL MEDICINE";
//		String doctor = "JAYA";
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//
//		String department = "MEDICAL ONCOLO";
//		String doctor = "SHASHI";
//		String un = "mjayashakar1234@vimsmail.com";// "mjayashakar1234@vimsmail.com";
//		String pw = "12345";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "4th FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
//
		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, depName, doctorname);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);
//
		String scheduleTime = "1230";
		String surgeryName = "Heart transplant";
		String asaClass = "I";
		String text = "121/212";
		String language = "urdu";
		String electiveEmergency = "ELECTIVE";
		String disease = "Allergies and allergic disorders are among the most com";
		String medication = "Allergies and allergic disorders are among the most com";
		String history = "test test ";
		String remarks = "Remarks entered successfully";
		// String preAnesthesiaOrders = "first pre anesthesia orders in the text area";

//		// pac schedule
//		pas.clickOnPacScheduling(driver);
//		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, scheduleTime, surgeryName);
//
//		// Ot schedule
//		ots.clickOnOtScenduleScreenLink(driver);
//		hp.homeBtnForvims(driver);
//		ots.clickOnTheAddBtn(driver);
//		ots.enterHospitalNumber(driver, hospitalNumber);
//		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
//		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
//				anastesiaType, specialNotes);
//		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCategory, consultantName, diagnosis);
//		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
//		Thread.sleep(2000);
//		ots.clickOnSearchBtn_Filters(driver);
//		ots.takeHospitalNumber_OtList(driver);
//		ots.clickOnHospitalNumber_OtList(driver);
//		ocp.clickOnSubmitBtn(driver);
//
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//
//		// add investigations
//		ipd.clickOnTheDoctorDeskIPDButton(driver);
//		hp.homeBtnForvims(driver);
//		ipd.clickOnAllPatientListInDDIPd(driver);
//		ipd.clickOnClearButton(driver);
//		ipd.searchHospitalNumber(driver, hospitalNumber);
//		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
//		ipd.ClickOnPatientarrivalbtn(driver);
//		ipd.ClickOnSavebtn(driver);
//		ipd.clickOnInvestigationTab(driver);
//		ipd.scrolldown(driver);
//		Thread.sleep(3000);
//		ipd.clickAddBtnInInvestigationtab(driver);
//		ipd.addTheInvestigation(driver, notes);
//		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
//		System.out.println(hospitalNumber);
//
//		// Pharmacy
//		ipd.clickOnPharmacyTab(driver);
//		ipd.plusButton_Pharmacy(driver);
//		ipd.addThe_Pharmacy(driver, pattern, qty, route, notes);
//		System.out.println(hospitalNumber + "Hospital Number");
//
//		// Ip consultation
////		ipd.scrollUp(driver);
////		ipd.clickOn_IpConsultant_Tab(driver);
////		ipd.plusButton_IpConsultant(driver);
////		ipd.Ip_Consultant_Process(driver, doctorName);
//
//		// Diet plan
//		ipd.scrolldown(driver);
//		ipd.DietPlan_Tab(driver);
//		ipd.clickOn_PlusBtn_DietPlan(driver);
//		ipd.dietPlan_Process(driver);
//
//		System.out.println("Hospital Diet Number :- " + hospitalNumber);
//
//		// Current Medication
//		String route1 = "ORAL";
//		String status = "Continue";
//
//		scrollToTop(driver);
//		ipd.clickOnHistoryTabs(driver);
//		ipd.clickOnCurrentMedicationTab(driver);
//		ipd.addTheCurrentMedication(driver, route1, pattern, date, qty, notes, status);
//		scrollDownTheStillEndOfThePage(driver);
//		ipd.clickOnNextBtn_currentMedication(driver);
//
//		String bp1 = "120120";
//		String height = "5.9";
//		String weight = "59";
//		String temp = "89";
//		String pulse = "123";
//
//		scrollToTop(driver);
//		ipd.clickOnVitalSignsTab(driver);
//		ipd.vitalSigns_History(driver, bp1, height, weight, temp, pulse);
//
//		String ChiefComplaint = "Patient complains of severe chest pain radiating to the left arm.\"\r\n"
//				+ "\"Patient presents with shortness of breath and wheezing.\"\r\n"
//				+ "\"Patient reports persistent abdominal pain, worse after meals.\"\r\n"
//				+ "\"Patient describes a sudden onset severe headache with nausea and vomiting.\"\r\n"
//				+ "\"Patient presents with fever, cough, and difficulty breathing.\"\r\n"
//				+ "\"Patient complains of joint pain and swelling in multiple joints.\"\r\n"
//				+ "\"Patient reports a skin rash with itching and redness.\"\r\n"
//				+ "\"Patient presents with sudden vision changes and eye pain.\"\r\n"
//				+ "\"Patient describes numbness and weakness in the left arm.\"\r\n"
//				+ "\"Patient reports sudden onset dizziness and loss of balance.\"";
//		String historyOfIllnes = "Chronic Medical Conditions:\r\n" + "Hypertension\r\n" + "Type 2 Diabetes Mellitus\r\n"
//				+ "Asthma\r\n" + "Rheumatoid Arthritis\r\n" + "Chronic Kidney Disease (Stage 3)\r\n"
//				+ "Previous Surgeries or Procedures:\r\n" + "Appendectomy - 2010\r\n" + "Knee Arthroscopy - 2015\r\n"
//				+ "Cholecystectomy - 2017\r\n" + "Coronary Artery Bypass Graft (CABG) - 2018\r\n"
//				+ "Total Hip Replacement - 2019\r\n" + "Hospitalizations:\r\n" + "Hospitalized for pneumonia - 2013\r\n"
//				+ "Hospitalized for myocardial infarction (heart attack) - 2016\r\n"
//				+ "Hospitalized for exacerbation of asthma - 2018\r\n" + "Significant Medical Events:\r\n"
//				+ "Myocardial Infarction (Heart Attack) - 2016\r\n" + "Stroke - 2019\r\n"
//				+ "Deep Vein Thrombosis (DVT) - 2017";
//		String Pmh = "Chronic Medical Conditions: Hypertension, Type 2 Diabetes Mellitus\r\n"
//				+ "Previous Surgeries or Procedures: Appendectomy (2008), Knee Arthroscopy (2015)\r\n"
//				+ "Hospitalizations: None\r\n" + "Significant Medical Events: None";
//		String scoialHx = "Occupation: Teacher\r\n" + "Smoking History: Non-smoker\r\n"
//				+ "Alcohol Use: Occasional social drinker\r\n" + "Recreational Drug Use: None reported\r\n"
//				+ "Exercise: Regular exercise routine, gym three times a week";
//		String pastInvestigation = "Blood Tests:\r\n" + "\r\n" + "Complete Blood Count (CBC)\r\n"
//				+ "Comprehensive Metabolic Panel (CMP)\r\n" + "Lipid Profile\r\n" + "Thyroid Function Tests\r\n"
//				+ "HbA1c (Glycated Hemoglobin) Test\r\n" + "Imaging Studies:\r\n" + "\r\n"
//				+ "X-rays (e.g., Chest X-ray, Abdominal X-ray)\r\n"
//				+ "Ultrasound Scans (e.g., Abdominal Ultrasound, Obstetric Ultrasound)\r\n"
//				+ "Computed Tomography (CT) Scans\r\n" + "Magnetic Resonance Imaging (MRI)\r\n"
//				+ "Bone Density Scan (DEXA Scan)\r\n"
//				+ "Electrocardiogram (ECG or EKG): Used to assess heart rhythm and detect abnormalities.\r\n" + "\r\n"
//				+ "Endoscopic Procedures:\r\n" + "\r\n"
//				+ "Upper Gastrointestinal Endoscopy (Esophagogastroduodenoscopy, EGD)\r\n" + "Colonoscopy\r\n"
//				+ "Bronchoscopy\r\n" + "Cystoscopy\r\n" + "Biopsy:\r\n" + "\r\n"
//				+ "Tissue samples taken for examination under a microscope to diagnose conditions such as cancer or inflammatory diseases.\r\n"
//				+ "Cardiac Tests:\r\n" + "\r\n" + "Echocardiogram (Echo)\r\n"
//				+ "Stress Test (Exercise ECG or Nuclear Stress Test)\r\n"
//				+ "Holter Monitor (24-hour ECG monitoring)\r\n"
//				+ "Pulmonary Function Tests (PFTs): Used to assess lung function and diagnose conditions such as asthma or chronic obstructive pulmonary disease (COPD).\r\n"
//				+ "\r\n" + "Neurological Tests:\r\n" + "\r\n" + "Electroencephalogram (EEG)\r\n"
//				+ "Nerve Conduction Studies (NCS)\r\n" + "Electromyography (EMG)\r\n"
//				+ "Allergy Testing: Skin prick tests or blood tests (e.g., IgE levels) to identify allergic sensitivities.\r\n"
//				+ "\r\n"
//				+ "Genetic Testing: Used to identify genetic mutations associated with inherited conditions or susceptibility to diseases.";
//		String provisionalDiagnosis = "Upper Respiratory Tract Infection (URTI):\r\n"
//				+ "Symptoms: Sore throat, nasal congestion, cough, low-grade fever\r\n" + "Acute Bronchitis:\r\n"
//				+ "Symptoms: Persistent cough, productive cough with clear or yellow sputum, mild fever\r\n"
//				+ "Urinary Tract Infection (UTI):\r\n"
//				+ "Symptoms: Dysuria (painful urination), urgency, frequency, hematuria (blood in urine)\r\n"
//				+ "Gastroenteritis:\r\n" + "Symptoms: Diarrhea, nausea, vomiting, abdominal cramps, low-grade fever\r\n"
//				+ "Acute Otitis Media:\r\n" + "Symptoms: Ear pain (otalgia), fever, hearing loss, ear discharge\r\n"
//				+ "Acute Sinusitis:\r\n"
//				+ "Symptoms: Facial pain or pressure, nasal congestion, purulent nasal discharge, headache\r\n"
//				+ "Gastritis:\r\n"
//				+ "Symptoms: Epigastric pain or burning sensation, nausea, vomiting, loss of appetite\r\n"
//				+ "Migraine Headache:\r\n" + "Symptoms: Severe headache, throbbing pain, photophobia, phonophobia\r\n"
//				+ "Acute Pharyngitis:\r\n"
//				+ "Symptoms: Sore throat, difficulty swallowing (dysphagia), fever, swollen tonsils\r\n"
//				+ "Lumbosacral Strain (Lower Back Strain):\r\n"
//				+ "Symptoms: Low back pain, muscle stiffness, limited range of motion, pain with movement";
//
//		// -----------History tabs iframes----------
//		scrollToTop(driver);
//		ipd.clickOnHistoryTabs(driver);
//		ipd.clickOnChiefComplaintTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver, ChiefComplaint);
//		ipd.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		ipd.clickOnHistoryOfIlnessTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver, historyOfIllnes);
//		ipd.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		ipd.clickOnPmhTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver, Pmh);
//		ipd.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		ipd.clickOnSocialHx(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver, scoialHx);
//		ipd.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		ipd.clickOnPastInvestigationTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver, pastInvestigation);
//		ipd.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		ipd.clickOnProvisionalDiagnosisTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver, provisionalDiagnosis);
//		ipd.clickOnNextBtn_historyTabs(driver);
//
////		scrollToTop(driver);
////		ipd.clickOnPlanTab(driver);
////		ipd.enterDataInIframe_HistoryTabs(driver, plan);
////		ipd.clickOnNextBtn_historyTabs(driver);
////		System.out.println("Hospital Number Last:- " + hospitalNumber);
//
//		// Final dignosis
//		ipd.clickOn_FinaleDiagnosis_Tab(driver);
//		ipd.enter_ICDCode_Description_FinalDiagnosis(driver, codeType);
//		ipd.clickOn_SubmitBtn_FinalDiagnosis(driver);
		System.out.println("Final Hospital Number :- " + hospitalNumber);
	}
//
//	@Test(invocationCount = 25)
//	public void test3() throws Throwable {
////		String department = "CARDIOLOGY";
////		String doctor = "VIJAYA SAI";
////		String un = "cardio_vijaysai@vimsmail.com";
////		String pw = "12345";
//
//		String department = "GENERAL MEDICINE";
//		String doctor = "RAMA";
//		String un = "medicine_rama1234@vimsmail.com";
//		String pw = "12345";
//
////		String department = "general medicine";
////		String doctor = "JAYA";
////		String un = "imopooja@d.com";// "mjayashakar1234@vimsmail.com";
////		String pw = "12345";
//
//		String admittedByDr = "ABBAS";
//		String bedCategory = "NON TEACHING";
//		String bedWardType = "SINGLE WARD";
//		String bedRoomType = "SINGLE ROOM WARD";
//		String floor = "5TH FLOOR";
//		String wings = "EAST WING";
//		String time = "";
//		String notes = "testing";
//		String pattern = "0-0-2";
//		String qty = "23";
//		String route = "ORAL";
//		String address = "Test";
//		String fname = "t";
//		String pincode = "560066";
//		String postOffice = "WHITEFIELD";
//		String doctorName = "";
//		String codeType = "ICD";
//
//		OPDRegistrationPage op = new OPDRegistrationPage(driver);
//		HomePage hp = new HomePage(driver);
//		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
//		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
//		LoginPage lp = new LoginPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//
//		hp.homeBtnForvims(driver);
//		op.opdRegistrationButton(driver);
//		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, department, doctor);
//		String hospitalNumber = op.submitAnd_ViewBtn(driver);
//
//		BedMasterPage bp = new BedMasterPage(driver);
//		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
//				floor, wings);
//
//		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
//		System.out.println(bednumberh);
//		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
//				bedWardType, bedRoomType, bednumberh);
//
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		// add investigations
//		ipd.clickOnTheDoctorDeskIPDButton(driver);
//		hp.homeBtnForvims(driver);
//		ipd.clickOnAllPatientListInDDIPd(driver);
//		ipd.clickOnClearButton(driver);
//		ipd.searchHospitalNumber(driver, hospitalNumber);
//		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
//		ipd.ClickOnPatientarrivalbtn(driver);
//		ipd.ClickOnSavebtn(driver);
//		ipd.clickOnInvestigationTab(driver);
//		ipd.scrolldown(driver);
//		Thread.sleep(3000);
//		ipd.clickAddBtnInInvestigationtab(driver);
//		ipd.addTheInvestigation(driver, notes);
//		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
//		System.out.println(hospitalNumber);
//
////		// Pharmacy
//		ipd.clickOnPharmacyTab(driver);
//		ipd.plusButton_Pharmacy(driver);
//		ipd.addThe_Pharmacy(driver, pattern, qty, route, notes);
//		System.out.println(hospitalNumber + "Hospital Number");
////
////		    // Ip consultation
//////////		ipd.scrollUp(driver);
//////////		ipd.clickOn_IpConsultant_Tab(driver);
//////////		ipd.plusButton_IpConsultant(driver);
//////////		ipd.Ip_Consultant_Process(driver, doctorName);
////
//		// Diet plan
//		ipd.scrolldown(driver);
//		ipd.DietPlan_Tab(driver);
//		ipd.clickOn_PlusBtn_DietPlan(driver);
//		ipd.dietPlan_Process(driver);
//
//		// ---------current medication-------
//		String route1 = "ORAL";
//		String date = "12122023";
//		String status = "Continue";
//
//		scrollToTop(driver);
//		ipd.clickOnHistoryTabs(driver);
//		ipd.clickOnCurrentMedicationTab(driver);
//		ipd.addTheCurrentMedication(driver, route1, pattern, date, qty, notes, status);
//		scrollDownTheStillEndOfThePage(driver);
//		ipd.clickOnNextBtn_currentMedication(driver);
//
//		String bp1 = "120120";
//		String height = "5.9";
//		String weight = "59";
//		String temp = "89";
//		String pulse = "123";
//
//		scrollToTop(driver);
//		ipd.clickOnVitalSignsTab(driver);
//		ipd.vitalSigns_History(driver, bp1, height, weight, temp, pulse);
//
//		// -----------History tabs iframes----------
//		scrollToTop(driver);
//		ipd.clickOnHistoryTabs(driver);
//		ipd.clickOnChiefComplaintTab(driver);
//		ipd.enterDataInIframe_HistoryTabs_STRING(driver,
//				"presents with a chief complaint of persistent lower back pain that has been bothering him for the past two weeks. He describes the pain as a dull ache, primarily located on the right side of his lower back. The intensity of the pain varies throughout the day, and he notes that it tends to worsen after prolonged periods of sitting. Mr. Anderson reports no recent injuries or trauma but mentions that he has a desk job that requires long hours of sitting. He rates the pain as a 6 on a scale of 0 to 10, with 0 being no pain and 10 being the worst pain imaginable. Additionally, he expresses concern about the impact of the pain on his daily activities, especially on his ability to focus at work.\r\n"
//						+ "Associated Symptoms and Relevant History:\r\n"
//						+ "In addition to the lower back pain, Mr. Anderson reports occasional numbness and tingling sensations in his right leg, specifically in the outer part of his thigh. He denies any bowel or bladder abnormalities but mentions that he has been experiencing mild difficulty in maintaining a consistent sleep pattern due to discomfort. His medical history includes occasional episodes of lower back pain in the past, for which he sought over-the-counter pain relief. There is no known history of chronic conditions, and he is not currently taking any medications. Mr. Anderson is eager to understand the cause of his pain and explore treatment options to alleviate his symptoms and improve his overall quality of life.");
//
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//
//		ipd.clickOnHistoryOfIlnessTab(driver);
//		ipd.enterDataInIframe_HistoryTabs_STRING(driver,
//				"History of illness -severe abdominal pain that began two days ago. He describes the pain as a constant, sharp sensation localized in the lower right quadrant of his abdomen. He rates the pain as 8 out of 10 on a pain scale. The pain is exacerbated by movement and is not relieved by over-the-counter pain medications. He denies any associated symptoms such as nausea, vomiting, diarrhea, or fever. He reports no recent dietary changes or trauma to the abdomen. Mr. Doe reports a gradual onset of symptoms, initially mild and intermittent, which have progressively worsened over the past week. He denies any recent trauma or changes in bowel habits. No relief with over-the-counter medications.");
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//
//		ipd.clickOnPmhTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.enterDataInIframe_HistoryTabs_STRING(driver,
//				"Hypertension: Diagnosed in 2015, managed with Lisinopril 10 mg daily. Blood pressure readings typically range from 130-140/80-90 mmHg on medication.\r\n"
//						+ "\r\n"
//						+ "Cholecystectomy: Underwent laparoscopic cholecystectomy in 2018 for symptomatic cholelithiasis. No postoperative complications reported.\r\n"
//						+ "\r\n"
//						+ "Hyperlipidemia: Elevated lipid levels detected in routine screening in 2016. Managed with lifestyle modifications and occasional use of statin therapy. Last lipid profile showed mildly elevated LDL cholesterol levels.\r\n"
//						+ "\r\n"
//						+ "Allergic Rhinitis: History of seasonal allergies, managed with over-the-counter antihistamines as needed.\r\n"
//						+ "\r\n"
//						+ "Appendectomy: Appendectomy performed in childhood (age 10) for acute appendicitis. No issues reported since then.\r\n"
//						+ "\r\n"
//						+ "Osteoarthritis: Chronic knee pain, diagnosed in 2017. Managed with nonsteroidal anti-inflammatory drugs (NSAIDs) and physical therapy.");
//		scrollToTop(driver);
//		ipd.clickOnSocialHx(driver);
//		ipd.enterDataInIframe_HistoryTabs_STRING(driver,
//				"Living Situation: Ask about where the patient lives (e.g., alone, with family, in assisted living), as well as the safety and cleanliness of their living environment.\r\n"
//						+ "Occupation: Inquire about the patient's current or past employment, including any exposure to occupational hazards or stresses related to their work.\r\n"
//						+ "Marital Status and Family: Learn about the patient's marital status, number of children, and their relationships with family members. This helps assess the patient's support system.\r\n"
//						+ "Social Support Network: Determine the patient's support system, including friends, family, or community resources they rely on for assistance or emotional support.\r\n"
//						+ "Hobbies and Recreational Activities: Ask about the patient's hobbies, interests, and recreational activities, as these can provide insights into their overall lifestyle and potential sources of stress or enjoyment.\r\n"
//						+ "Substance Use: Inquire about the patient's use of tobacco, alcohol, recreational drugs, or prescription medications, including frequency and quantity.\r\n"
//						+ "Diet and Nutrition: Assess the patient's dietary habits, including any specific dietary restrictions, preferences, or challenges they may face in accessing nutritious food.\r\n"
//						+ "Physical Activity: Determine the patient's level of physical activity, including exercise routines, mobility limitations, and any barriers to staying active.\r\n"
//						+ "Sexual History: Discuss the patient's sexual activity, partners, and practices, as well as any concerns related to sexual health or contraception.\r\n"
//						+ "Financial and Insurance Status: Evaluate the patient's financial resources, insurance coverage, and access to healthcare services, which can impact their ability to seek and afford medical care.");
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//
//		ipd.clickOnPastInvestigationTab(driver);
//		ipd.enterDataInIframe_HistoryTabs_STRING(driver, "Past Investigations:\r\n" + "\r\n"
//				+ "Abdominal Ultrasound (2018): Revealed multiple gallstones, largest measuring 1.5 cm. No evidence of biliary ductal dilation or gallbladder wall thickening. No sonographic Murphy's sign. Compatible with symptomatic cholelithiasis.\r\n"
//				+ "\r\n"
//				+ "Lipid Profile (last checked in 2023): Total cholesterol: 220 mg/dL (normal range: <200 mg/dL), LDL cholesterol: 150 mg/dL (normal range: <100 mg/dL), HDL cholesterol: 45 mg/dL (normal range: >40 mg/dL), Triglycerides: 180 mg/dL (normal range: <150 mg/dL). Mildly elevated LDL cholesterol levels.\r\n"
//				+ "\r\n"
//				+ "Blood Pressure Monitoring (ongoing): Average blood pressure readings over the past year: systolic 140-150 mmHg, diastolic 85-90 mmHg. Despite medication adherence, blood pressure remains elevated. Further optimization of antihypertensive regimen may be warranted.\r\n"
//				+ "\r\n"
//				+ "Liver Function Tests (last checked in 2022): Alanine transaminase (ALT): 25 U/L (normal range: 7-56 U/L), Aspartate transaminase (AST): 30 U/L (normal range: 10-40 U/L), Alkaline phosphatase (ALP): 80 U/L (normal range: 40-150 U/L), Total bilirubin: 0.7 mg/dL (normal range: 0.2-1.2 mg/dL). Within normal limits, suggesting no active liver pathology.");
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//
//		ipd.clickOnProvisionalDiagnosisTab(driver);
//		ipd.enterDataInIframe_HistoryTabs_STRING(driver, "Provisional Diagnosis: Acute Bronchitis\r\n"
//				+ "Clinical Presentation:\r\n"
//				+ "John presents with a 3-day history of cough, productive of greenish-yellow sputum.\r\n"
//				+ "He reports mild chest discomfort and a low-grade fever of 100.8°F.\r\n"
//				+ "John denies shortness of breath, wheezing, or hemoptysis.\r\n"
//				+ "On physical examination, there are mild bilateral coarse crackles on auscultation of the lung bases.\r\n"
//				+ "Reasoning for Provisional Diagnosis:\r\n"
//				+ "The patient's symptoms, including cough, sputum production, chest discomfort, and low-grade fever, are consistent with acute bronchitis.\r\n"
//				+ "The presence of mild bilateral coarse crackles on lung auscultation suggests inflammation and irritation of the bronchial passages.\r\n"
//				+ "John's history does not suggest an alternative diagnosis such as pneumonia or exacerbation of chronic obstructive pulmonary disease (COPD).");
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//
//		ipd.clickOnPlanTab(driver);
//		ipd.enterDataInIframe_HistoryTabs_STRING(driver, "Medication:\r\n"
//				+ "Prescribe a 7-day course of amoxicillin-clavulanate 875 mg/125 mg orally twice daily for 7 days to treat the bacterial infection.\r\n"
//				+ "Recommend over-the-counter nasal decongestants (pseudoephedrine) and saline nasal irrigation to alleviate congestion and facilitate drainage.\r\n"
//				+ "Provide a prescription for acetaminophen or ibuprofen as needed for pain and fever management.\r\n"
//				+ "Symptomatic Relief:\r\n"
//				+ "Advise Sarah to use a humidifier at home to maintain moisture in the air and help ease nasal congestion.\r\n"
//				+ "Encourage adequate hydration by drinking plenty of fluids to help thin mucus and promote drainage.\r\n"
//				+ "Instruct Sarah to avoid irritants such as cigarette smoke and strong odors, which can exacerbate symptoms.\r\n"
//				+ "Follow-up:\r\n"
//				+ "Schedule a follow-up appointment in 10 days to assess treatment response and adjust management if necessary.\r\n"
//				+ "Instruct Sarah to contact the office sooner if symptoms worsen or new symptoms develop, such as high fever, severe headache, or visual disturbances.\r\n"
//				+ "Educational Counseling:\r\n"
//				+ "Educate Sarah about the nature of sinusitis, including its causes, symptoms, and treatment options.\r\n"
//				+ "Provide instructions on proper antibiotic use, including completing the full course of medication even if symptoms improve before completion.\r\n"
//				+ "Review strategies for preventing future episodes of sinusitis, such as practicing good hand hygiene, avoiding allergens, and using nasal saline irrigation regularly.\r\n"
//				+ "Referral:\r\n"
//				+ "Consider referral to an otolaryngologist (ENT specialist) if symptoms persist despite appropriate medical therapy or if there are recurrent episodes of sinusitis requiring further evaluation and management.\r\n"
//				+ "Patient Education Material Provided:\r\n"
//				+ "Handout on sinusitis: Symptoms, causes, and treatment options.\r\n"
//				+ "Instructions for nasal saline irrigation.\r\n"
//				+ "Information on proper antibiotic use and potential side effects.");
//		ipd.clickOnNextBtn_historyTabs(driver);
//		System.out.println("Hospital Number Last:- " + hospitalNumber);
//
//		// Final dignosis
//		ipd.clickOn_FinaleDiagnosis_Tab(driver);
//		ipd.enter_ICDCode_Description_FinalDiagnosis(driver, codeType);
//		ipd.clickOn_SubmitBtn_FinalDiagnosis(driver);
//		System.out.println("Hospital Number :- " + hospitalNumber);
//
//	}

	@Test(invocationCount = 20)
	public void test_2() throws Throwable {
		String department = "general medicine";
		String doctor = "DR.MEE";
		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

//		String department = "GENERAL MEDICINE";
//		String doctor = "JAYA";
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//
//		String department = "MEDICAL ONCOLO";
//		String doctor = "SHASHI";
//		String un = "mjayashakar1234@vimsmail.com";// "mjayashakar1234@vimsmail.com";
//		String pw = "12345";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
//
		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

//		BedMasterPage bp = new BedMasterPage(driver);
//		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
//				floor, wings);
//
//		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
//		System.out.println(bednumberh);
//		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
//				bedWardType, bedRoomType, bednumberh);
	}

	@Test(invocationCount = 20)
	public void test__3() throws Throwable {
		String department = "general medicine";
		String doctor = "DR TANUJA S NAMBAKAM";
		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

//		String department = "GENERAL MEDICINE";
//		String doctor = "JAYA";
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//
//		String department = "MEDICAL ONCOLO";
//		String doctor = "SHASHI";
//		String un = "mjayashakar1234@vimsmail.com";// "mjayashakar1234@vimsmail.com";
//		String pw = "12345";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
//
		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

//		BedMasterPage bp = new BedMasterPage(driver);
//		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
//				floor, wings);
//
//		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
//		System.out.println(bednumberh);
//		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
//				bedWardType, bedRoomType, bednumberh);
	}

	@Test(invocationCount = 20)
	public void test__4() throws Throwable {
		String department = "general medicine";
		String doctor = "DR.AKSHATHA SAVITH";
		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

//		String department = "GENERAL MEDICINE";
//		String doctor = "JAYA";
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//
//		String department = "MEDICAL ONCOLO";
//		String doctor = "SHASHI";
//		String un = "mjayashakar1234@vimsmail.com";// "mjayashakar1234@vimsmail.com";
//		String pw = "12345";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
//
		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

//		BedMasterPage bp = new BedMasterPage(driver);
//		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
//				floor, wings);
//
//		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
//		System.out.println(bednumberh);
//		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
//				bedWardType, bedRoomType, bednumberh);
	}

	@Test(invocationCount = 20)
	public void test__5() throws Throwable {
		String department = "general medicine";
		String doctor = "DR P DEEPAK KUMAR";
		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

//		String department = "GENERAL MEDICINE";
//		String doctor = "JAYA";
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//
//		String department = "MEDICAL ONCOLO";
//		String doctor = "SHASHI";
//		String un = "mjayashakar1234@vimsmail.com";// "mjayashakar1234@vimsmail.com";
//		String pw = "12345";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
//
		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

//		BedMasterPage bp = new BedMasterPage(driver);
//		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
//				floor, wings);
//
//		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
//		System.out.println(bednumberh);
//		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
//				bedWardType, bedRoomType, bednumberh);
	}

	@Test(invocationCount = 20)
	public void test__6() throws Throwable {
		String department = "general medicine";
		String doctor = "DR AMEENA MEAH";
		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

//		String department = "GENERAL MEDICINE";
//		String doctor = "JAYA";
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//
//		String department = "MEDICAL ONCOLO";
//		String doctor = "SHASHI";
//		String un = "mjayashakar1234@vimsmail.com";// "mjayashakar1234@vimsmail.com";
//		String pw = "12345";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
//
		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);
	}

	@Test(invocationCount = 20)
	public void test__7() throws Throwable {
		String department = "general medicine";
		String doctor = "DR JITHENDRA HC";
		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

//		String department = "GENERAL MEDICINE";
//		String doctor = "JAYA";
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//
//		String department = "MEDICAL ONCOLO";
//		String doctor = "SHASHI";
//		String un = "mjayashakar1234@vimsmail.com";// "mjayashakar1234@vimsmail.com";
//		String pw = "12345";

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
//
		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);
	}

	@Test(invocationCount = 10)
	public void ipPatinets_OBG() throws Throwable {
		String doctorname = "APARANA NAIR";
		String depName = "OBSTETRICS & GYNAECOLOGY";
		String un = " medicine_rama1234@vimsmail.com";
		String pw = "12345";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ISOLATION WARD";
		String bedRoomType = "ISOLATION ROOM";
		String floor = "4th FLOOR";
		String wings = "EAST WING";
		String time = "";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";
		String codeType = "ICD";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "HEART SURGERY VALUE";
		String doctorCategory = "SENIOR DOCTOR";
		String consultantName = "POOJA";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "OBSTETRICS & GYNAECOLOGY";
		String date = jutil.currentDate();

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);

		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims_5(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName,
				doctorname);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

		System.out.println("Hospital Number - IP : " + hospitalNumber);
	}

}
