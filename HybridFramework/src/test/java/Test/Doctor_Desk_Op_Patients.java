package Test;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.PAC_Anaesthesia_SchedulePage;
import com.Dalvkot.Vims_ObjectRepositary.PacAnaesthesiaConfirmationPage;

public class Doctor_Desk_Op_Patients extends BaseClass {

	@Test(invocationCount = 50)
	public void createTheDoctorDeskOPAllTheData_Test() throws Throwable {
//
		String un = "gmh@demo.com";
		String pw = "12345";

		String doctorname = "VIJAYA";
		String depName = "ENDOCRINOLOGY";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String date = jutil.currentDate();

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

		// ----------Prescription-------------
		String repeatPattern = "1-1/2-0";
		String duration_prescription = "2";
		String route = "ORAL";
		String quantity = "2";

		// ------Investigations---------
		String notes = "testing";
		// --------final diagnosis--------
		String comments = "Lorem ipsum dolor sit amet";

		// ------------Next encounter---------
		String subjective = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur, quam id ";
		String objective = "tincidunt posuere, quam dolor bibendum mi, vel vehicula dui ex at orci. Fusce scelerisque, ";
		String assessment = "eros eu gravida dictum, nunc ex laoreet justo, a interdum leo odio a dolor. Sed euismod risus ";
		String plan = "eu tortor efficitur, eu finibus justo scelerisque. Vestibulum id augue et ipsum tristique";
		String inv = "pellentesque. Vivamus eleifend, lectus vel scelerisque congue, justo metus blandit urna, nec ";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pac = new PacAnaesthesiaConfirmationPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);
////
//		ots.clickOnOtScenduleScreenLink(driver);
//		hp.homeBtnForvims(driver);
//		ots.clickOnTheAddBtn(driver);
//		ots.enterHospitalNumber(driver, hospitalNumber);
//		ots.selectDepartmentInOtScheduling(driver, depName);
//		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
//		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
//				anastesiaType, specialNotes);
//		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCategory, consultantName, diagnosis);
//
//		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
//		Thread.sleep(2000);
//		ots.clickOnSearchBtn_Filters(driver);
//		String hospitalNumber1 = ots.takeHospitalNumber_OtList(driver);
//		ots.clickOnHospitalNumber_OtList(driver);
		// ocp.clickOnSubmitBtn(driver);

//		String doctorName = "rama mishra";
//
//		// -----login using doctor credentials----
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
////
//		// --------Do patient arrival----------
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnAllPatientListTab(driver);
//		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//
//		// ------Investigations---------
//		scrollToTop(driver);
//		dp.clickOnInvestigationTab(driver);
//		dp.clickOnNewBtnInInvestigationTab(driver);
//		dp.scrolldown(driver);
//		dp.addThreeInvestigations(driver, notes);
//		dp.clickOnSubmitBtnInInvestigationsTab(driver);
//
//		// --------final diagnosis--------
//		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
//		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
//		dp.addTheFinalDiagnosis_Random(driver, comments);
//		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
//
		// ----------Prescription-------------
//		scrollToTop(driver);
//		dp.clickOnPrescriptioinTab(driver);
//		dp.clickOnNewBtnInPrescriptonTab(driver);
//		dp.addThePrescriptons(driver, repeatPattern, duration_prescription, route, quantity, notes);
//		dp.clickOnSubmitBtnInPrescriptionTab(driver);
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
//
//		// ------------Next encounter---------
//		scrollToTop(driver);
//		dp.clickOnNextEncounterTab(driver);
//		dp.addTheNextEncounter(driver, subjective, objective, assessment, plan, inv);
//		dp.clickOnSubmitBtnInNextEncounterTb(driver);
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
//
//		// ---------------Documents-------------
////		scrollToTop(driver);
////		dp.clickOnDocumentsTab(driver);
////		dp.addDocumentsInDdOpd_Random(driver);
//
//		// ------------Other notes-----------
//		String templateType = "OT NOTES";
//		scrollToTop(driver);
//		dp.clickOnOtherNotesTab(driver);
//		dp.clickOnNewBtn_OtherNotesTab(driver);
//		dp.selectTemplateType_otherNotesTab(driver, templateType);
//		dp.enterDataOtherNotes_Iframe(driver);
//
//		// --------current medication-------
//		String route1 = "ORAL";
//		String pattern = "1-1/2-0";
//		String since = "< 3 MONTHS";
//		String qty = "5";
//		String status = "Continue";
//
//		scrollToTop(driver);
//		dp.clickOnHistoryTabs(driver);
//		dp.clickOnCurrentMedicationTab(driver);
//		dp.addTheCurrentMedication(driver, route1, pattern, since, qty, notes, status);
//		scrollDownTheStillEndOfThePage(driver);
//		dp.clickOnNextBtn_currentMedication(driver);
//
//		// -------vital signs-------
//		String bp = "223456";
//		String height = "174";
//		String weight = "66";
//		String c = "35";
//		String pulse = "156";
//		String rr = "987";
//		String spo2 = "111";
//
//		scrollToTop(driver);
//		dp.clickOnVitalSignsTab(driver);
//		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr, spo2);
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
//		String psh = "Appendectomy - \r\n" + "\r\n" + "Reason: Acute appendicitis\r\n" + "Complications: None\r\n"
//				+ "Tonsillectomy and Adenoidectomy - \r\n" + "\r\n"
//				+ "Reason: Recurrent tonsillitis and obstructive sleep apnea\r\n" + "Complications: None\r\n"
//				+ "Cholecystectomy - \r\n" + "\r\n" + "Reason: Symptomatic cholelithiasis (gallstones)\r\n"
//				+ "Complications: None\r\n" + "Repair of Umbilical Hernia -\r\n" + "\r\n"
//				+ "Reason: Incarcerated umbilical hernia\r\n" + "Complications: None\r\n" + "Social History:\r\n"
//				+ "\r\n" + "Smoking History: [Smoking Status - Never/Former/Current, Pack-years]\r\n"
//				+ "Alcohol Consumption: [Frequency and Quantity]\r\n" + "Recreational Drug Use: [Yes/No, Specify]\r\n"
//				+ "Medication History:\r\n" + "\r\n"
//				+ "List of Current Medications: [Medication Names, Dosages, Frequencies]\r\n"
//				+ "Medication Allergies: [Any Known Medication Allergies]\r\n" + "Family History:\r\n" + "\r\n"
//				+ "Family History of Medical Conditions: [List of Family Members and Conditions]\r\n"
//				+ "Review of Systems:\r\n" + "\r\n" + "General: [Any Current Symptoms or Complaints]\r\n"
//				+ "Cardiovascular: [Any Cardiovascular Symptoms]\r\n" + "Respiratory: [Any Respiratory Symptoms]\r\n"
//				+ "Gastrointestinal: [Any Gastrointestinal Symptoms]\r\n"
//				+ "Neurological: [Any Neurological Symptoms]\r\n"
//				+ "Musculoskeletal: [Any Musculoskeletal Symptoms]\r\n" + "Etc.\r\n" + "";
//		String drugAndFoodAllregies = "Symptoms: Can range from mild skin rashes and itching to severe anaphylaxis.\r\n"
//				+ "Common Allergens: Antibiotics like penicillin, non-steroidal anti-inflammatory drugs (NSAIDs) like aspirin, chemotherapy drugs, and certain vaccines.\r\n"
//				+ "Diagnosis: Often based on symptoms and confirmed through allergy testing.\r\n" + "Management:\r\n"
//				+ "Avoidance of the offending drug.\r\n" + "Use of medical alert bracelets.\r\n"
//				+ "Desensitization in some cases under strict medical supervision.\r\n" + "Treatment of Reactions:\r\n"
//				+ "Antihistamines for mild reactions.\r\n" + "Epinephrine for severe reactions.\r\n"
//				+ "Prompt medical attention for anaphylaxis.\r\n" + "Food Allergies:\r\n" + "\r\n"
//				+ "Definition: A food allergy is an abnormal immune response to certain foods.\r\n"
//				+ "Symptoms: Can include hives, itching, swelling, abdominal pain, diarrhea, and in severe cases, anaphylaxis.\r\n"
//				+ "Common Allergens: Peanuts, tree nuts, shellfish, fish, milk, eggs, wheat, and soy.\r\n"
//				+ "Diagnosis: Often based on symptoms, supported by allergy testing (skin prick tests, blood tests).\r\n"
//				+ "Management:\r\n" + "Strict avoidance of the allergen.\r\n" + "Reading food labels carefully.\r\n"
//				+ "Educating oneself and others about the allergy.\r\n"
//				+ "Carrying emergency medication (e.g., epinephrine auto-injector) if necessary.\r\n"
//				+ "Treatment of Reactions:\r\n" + "Epinephrine injection for anaphylaxis.\r\n"
//				+ "Antihistamines for mild symptoms.\r\n" + "Seeking immediate medical attention in severe cases.";
//
//		String ros = "Hypothetical RAST Test Results:\r\n" + "\r\n" + "Allergen	IgE Level (IU/mL)	Class\r\n"
//				+ "Peanut	45	5\r\n" + "Tree Pollen	12	3\r\n" + "Dust Mites	8	2\r\n"
//				+ "Cat Dander	22	4\r\n" + "Mold Spores	15	3";
//		String gpe = "\r\n" + "ParameteR Result	Normal Range\r\n" + "Blood Pressure	120/80 mmHg	< 120/80 mmHg\r\n"
//				+ "Heart Rate	72 bpm	60-100 bpm\r\n" + "Respiratory Rate	16 breaths/min	12-20 breaths/min\r\n"
//				+ "Temperature	98.6°F (37°C)	97.0-99.0°F\r\n" + "Height	170 cm	(Varies by age)\r\n"
//				+ "Weight	70 kg	(Varies by age)\r\n" + "BMI	24.2 kg/m²	18.5-24.9 kg/m²\r\n"
//				+ "Head Circumference	56 cm	(Varies by age)\r\n" + "Visual Acuity	20/20	(Varies)\r\n"
//				+ "Hearing Acuity	Normal	(Varies)\r\n" + "Skin Examination	Clear	(Varies)\r\n"
//				+ "Cardiovascular Exam	Normal	(Varies)\r\n" + "Respiratory Exam	Clear	(Varies)\r\n"
//				+ "Abdominal Exam	Soft, non-tender	(Varies)\r\n" + "Neurological Exam	Intact	(Varies)";
//		String pastInvetsigations = "Blood Tests ()\r\n" + "\r\n" + "Complete Blood Count (CBC)\r\n"
//				+ "Results: Within normal limits\r\n" + "Blood Glucose Level\r\n" + "Results: 90 mg/dL (Fasting)\r\n"
//				+ "Lipid Profile\r\n" + "Results:\r\n" + "Total Cholesterol: 180 mg/dL\r\n"
//				+ "LDL Cholesterol: 110 mg/dL\r\n" + "HDL Cholesterol: 50 mg/dL\r\n" + "Triglycerides: 120 mg/dL\r\n"
//				+ "Imaging Studies (Date: [Date])\r\n" + "\r\n" + "X-ray of Chest\r\n"
//				+ "Results: Clear lung fields, no consolidation or effusion\r\n" + "Ultrasound of Abdomen\r\n"
//				+ "Results: Normal liver, spleen, kidneys, and gallbladder. No evidence of masses or abnormalities.\r\n"
//				+ "Electrocardiogram (ECG) ()\r\n" + "\r\n"
//				+ "Results: Normal sinus rhythm, no ST-T wave changes or arrhythmias detected.\r\n"
//				+ "Other Investigations\r\n" + "\r\n" + "Spirometry ()\r\n"
//				+ "Results: Normal spirometry values, no evidence of obstructive or restrictive lung disease.\r\n" + "";
//
//		String ProvisionalDiagnosis = "Physical Examination (Date: [Date])\r\n" + "\r\n"
//				+ "Sinus Tenderness: Present on palpation over frontal and maxillary sinuses.\r\n"
//				+ "Nasal Congestion: Bilateral, with clear nasal discharge.\r\n"
//				+ "Facial Pressure: Reported by the patient over the frontal region.\r\n" + "Nasal Endoscopy ()\r\n"
//				+ "\r\n"
//				+ "Findings: Mucosal edema and erythema of the nasal turbinates. Purulent discharge noted in the middle meatus.\r\n"
//				+ "Sinus X-ray (Date: [Date])\r\n" + "\r\n"
//				+ "Results: Evidence of fluid levels in the maxillary sinuses bilaterally. Opacification of the left frontal sinus.\r\n"
//				+ "Laboratory Tests ()\r\n" + "\r\n" + "Complete Blood Count (CBC)\r\n"
//				+ "Results: Mild leukocytosis with neutrophilia.\r\n" + "C-reactive protein (CRP)\r\n"
//				+ "Results: Elevated at 20 mg/L (normal range < 5 mg/L).\r\n" + "Microbiological Tests ()\r\n" + "\r\n"
//				+ "Nasal Swab Culture\r\n" + "Organisms Identified: Staphylococcus aureus\r\n"
//				+ "Sensitivity: Susceptible to amoxicillin-clavulanate.\r\n" + "Other Investigations\r\n" + "\r\n"
//				+ "Allergy Testing ()\r\n" + "Results: Negative for common environmental allergens.";
//
//		String plan1 = "Provisional Diagnosis: Acute Sinusitis\r\n" + "\r\n" + "Treatment Plan:\r\n" + "\r\n"
//				+ "Medications:\r\n" + "\r\n" + "Antibiotic Therapy:\r\n"
//				+ "Amoxicillin-Clavulanate 875/125 mg orally twice daily for 10 days.\r\n" + "Symptomatic Relief:\r\n"
//				+ "Nasal decongestant spray (e.g., oxymetazoline) for 3-5 days as needed.\r\n"
//				+ "Saline nasal irrigation to be performed twice daily.\r\n" + "Adjunctive Therapies:\r\n" + "\r\n"
//				+ "Pain Relief:\r\n"
//				+ "Acetaminophen (paracetamol) 500 mg orally every 6 hours as needed for facial pain.\r\n"
//				+ "Nasal Steroid Spray:\r\n"
//				+ "Fluticasone propionate nasal spray 50 mcg in each nostril once daily for 2 weeks to reduce nasal inflammation.\r\n"
//				+ "Monitoring:\r\n" + "\r\n"
//				+ "Follow-up appointment in 1 week for reassessment of symptoms and treatment response.\r\n"
//				+ "Encourage the patient to report any worsening symptoms, new onset of fever, or development of severe headache.\r\n"
//				+ "Patient Education:\r\n" + "\r\n"
//				+ "Explain the diagnosis of acute sinusitis and the rationale behind the treatment plan.\r\n"
//				+ "Instruct the patient on proper administration of medications, including dosages and frequencies.\r\n"
//				+ "Emphasize the importance of completing the full course of antibiotics even if symptoms improve before completion.\r\n"
//				+ "Advise on measures to promote sinus drainage, such as steam inhalation and maintaining adequate hydration.\r\n"
//				+ "Referral:\r\n" + "\r\n"
//				+ "Consider referral to an ENT specialist if symptoms persist despite appropriate treatment or if complications arise.\r\n"
//				+ "Preventive Measures:\r\n" + "\r\n"
//				+ "Discuss strategies for preventing future episodes of sinusitis, such as avoiding environmental triggers and practicing good nasal hygiene.";
//
//		String familyHx = "Family History:\r\n" + "\r\n" + "Father: Hypertension, Type 2 Diabetes\r\n"
//				+ "Mother: Hypothyroidism\r\n" + "Siblings: None\r\n" + "Maternal Grandmother: Breast Cancer\r\n"
//				+ "Maternal Grandfather: Coronary Artery Disease\r\n" + "Test Data:\r\n" + "\r\n"
//				+ "Blood Tests (Date: [Date])\r\n" + "\r\n" + "Complete Blood Count (CBC)\r\n"
//				+ "Results: Within normal limits\r\n" + "Fasting Blood Glucose\r\n" + "Results: 120 mg/dL (Fasting)\r\n"
//				+ "Thyroid Function Tests\r\n"
//				+ "Results: TSH level of 4.5 mIU/L (elevated), T4 and T3 within normal range.\r\n"
//				+ "Imaging Studies (Date: [Date])\r\n" + "\r\n" + "Abdominal Ultrasound\r\n"
//				+ "Results: Normal liver, spleen, kidneys, and gallbladder. No evidence of masses or abnormalities.\r\n"
//				+ "Echocardiogram\r\n"
//				+ "Results: Normal left ventricular function, no evidence of structural abnormalities.\r\n"
//				+ "Electrocardiogram (ECG) (Date: [Date])\r\n" + "\r\n"
//				+ "Results: Normal sinus rhythm, no evidence of conduction abnormalities or ischemic changes.\r\n"
//				+ "Other Investigations\r\n" + "\r\n" + "Colonoscopy (Date: [Date])\r\n"
//				+ "Results: Normal colon anatomy, no evidence of polyps or malignancy.\r\n"
//				+ "Mammogram (Date: [Date])\r\n" + "Results: Negative for suspicious masses or calcifications.";
//
//		// -----------History tabs iframes----------
//		scrollToTop(driver);
//		dp.clickOnHistoryTabs(driver);
//		dp.clickOnChiefComplaintTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, ChiefComplaint);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnHistoryOfIlnessTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, historyOfIllnes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnPmhTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, Pmh);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnPshTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, psh);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnFamilyHx(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, familyHx);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnSocialHx(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, scoialHx);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnDrugAndFoodAllergy(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, drugAndFoodAllregies);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnRosTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, ros);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnGpeTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, gpe);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnPastInvestigationTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, pastInvetsigations);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnProvisionalDiagnosisTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, ProvisionalDiagnosis);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnPlanTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, plan1);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		// ----Progress record-----
//		// dp.clickOnSignBtn(driver);
		System.out.println("Hospital Number_OP last : " + hospitalNumber);
	}

	@Test(invocationCount = 20)
	public void createTheDoctorDeskOPAllTheData2_Test() throws Throwable {

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		String doctorname = "rama";
		String depName = "general medicine";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String date = jutil.currentDate();
		String doctorName = "";

		// ---------Operation theatre schedule---------
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "TEST";
		String doctorCategory = "Consultant physician";
		String consultantName = "Rama mishra";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String dep = "CARDIOLOGY";

		// ----------Prescription-------------
		String repeatPattern = "1-1/2-0";
		String duration_prescription = "2";
		String route = "ORAL";
		String quantity = "2";

		// ------Investigations---------
		String notes = "testing";
		// --------final diagnosis--------
		String comments = "Lorem ipsum dolor sit amet";

		// ------------Next encounter---------
		String subjective = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur, quam id ";
		String objective = "tincidunt posuere, quam dolor bibendum mi, vel vehicula dui ex at orci. Fusce scelerisque, ";
		String assessment = "eros eu gravida dictum, nunc ex laoreet justo, a interdum leo odio a dolor. Sed euismod risus ";
		String plan = "eu tortor efficitur, eu finibus justo scelerisque. Vestibulum id augue et ipsum tristique";
		String inv = "pellentesque. Vivamus eleifend, lectus vel scelerisque congue, justo metus blandit urna, nec ";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

//		ots.clickOnOtScenduleScreenLink(driver);
//		hp.homeBtnForvims(driver);
//		ots.clickOnTheAddBtn(driver);
//		ots.enterHospitalNumber(driver, hospitalNumber);
//		ots.selectDepartmentInOtScheduling(driver, depName);
//		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
//		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
//				anastesiaType, specialNotes);
//		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCategory, consultantName, diagnosis);

		// -----login using doctor credentials----
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// --------Do patient arrival----------
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		// ------Investigations---------
		scrollToTop(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addThreeInvestigations(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);

		// --------final diagnosis--------
		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
		dp.addTheFinalDiagnosis_Random(driver, comments);
		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		// ----------Prescription-------------
		scrollToTop(driver);
		dp.clickOnPrescriptioinTab(driver);
		dp.clickOnNewBtnInPrescriptonTab(driver);
		dp.addThePrescriptons(driver, repeatPattern, duration_prescription, route, quantity, notes);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		String remarks = "test";
		// ------------Next encounter---------
		scrollToTop(driver);
		dp.clickOnNextEncounterTab(driver);
		dp.addTheNextEncounter(driver, remarks);
		dp.clickOnSubmitBtnInNextEncounterTb(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		// ---------------Documents-------------
//		scrollToTop(driver);
//		dp.clickOnDocumentsTab(driver);
		dp.addDocumentsInDdOpd_Random(driver);

		// ------------Other notes-----------
		String templateType = "OT NOTES";
		scrollToTop(driver);
		dp.clickOnOtherNotesTab(driver);
		dp.clickOnNewBtn_OtherNotesTab(driver);
		dp.selectTemplateType_otherNotesTab(driver, templateType);
		dp.enterDataOtherNotes_Iframe(driver);

		// --------current medication-------
		String route1 = "ORAL";
		String pattern = "1-1/2-0";
		String since = "< 3 MONTHS";
		String qty = "5";
		String status = "Continue";

		scrollToTop(driver);
		dp.clickOnHistoryTabs(driver);
		dp.clickOnCurrentMedicationTab(driver);
		dp.addTheCurrentMedication(driver, route1, pattern, since, qty, notes, status);
		scrollDownTheStillEndOfThePage(driver);
		dp.clickOnNextBtn_currentMedication(driver);

		// -------vital signs-------
		String bp = "223456";
		String height = "174";
		String weight = "66";
		String c = "35";
		String pulse = "156";
		String rr = "987";
		String spo2 = "111";

		scrollToTop(driver);
		dp.clickOnVitalSignsTab(driver);
		// dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr, spo2);

		// -----------History tabs iframes----------
		scrollToTop(driver);
		dp.clickOnHistoryTabs(driver);
		dp.clickOnChiefComplaintTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"Patient presents with a 3-day history of progressively worsening shortness of breath (SOB) and non-productive cough. Symptoms are exacerbated with exertion and lying flat, partially relieved by sitting upright. Denies chest pain, palpitations, fever, or recent sick contacts. No significant relief with over-the-counter cough medications. Reports a past medical history of asthma but states that current symptoms differ from previous asthma exacerbations.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnHistoryOfIlnessTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"The patient, a 55-year-old male, presents with a history of chronic obstructive pulmonary disease (COPD) diagnosed 10 years ago. He reports a gradual decline in lung function over the past few years despite compliance with inhaler therapy (inhaled corticosteroids and long-acting beta-agonists). He has a smoking history of 30 pack-years and quit smoking five years ago.\r\n"
						+ "\r\n"
						+ "Additionally, the patient has a history of hypertension diagnosed five years ago, managed with a combination of lisinopril and hydrochlorothiazide. Blood pressure readings at home have been consistently elevated despite medication adherence.\r\n"
						+ "\r\n"
						+ "He also reports a remote history of myocardial infarction (MI) seven years ago, for which he underwent percutaneous coronary intervention (PCI) and stent placement in the left anterior descending artery (LAD). He is compliant with dual antiplatelet therapy and statin therapy");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnPmhTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"Hypertension: Diagnosed 10 years ago. Managed with a combination of amlodipine and lifestyle modifications. Blood pressure readings typically range from 130-140/80-90 mmHg on medication.\r\n"
						+ "\r\n"
						+ "Type 2 Diabetes Mellitus: Diagnosed 7 years ago. Managed with metformin and diet control. Last HbA1c level was 7.2% three months ago.\r\n"
						+ "\r\n"
						+ "Coronary Artery Disease (CAD): History of CAD with a non-ST segment elevation myocardial infarction (NSTEMI) 5 years ago. Underwent coronary angiography revealing significant stenosis in the left anterior descending (LAD) artery, managed with percutaneous coronary intervention (PCI) and stent placement.\r\n"
						+ "\r\n"
						+ "Hyperlipidemia: Elevated lipid levels detected concurrently with CAD diagnosis. Managed with atorvastatin 40 mg daily. Last lipid profile showed LDL cholesterol level of 80 mg/dL.\r\n"
						+ "\r\n"
						+ "Chronic Kidney Disease (CKD): Stage 3 CKD diagnosed 3 years ago, likely secondary to long-standing hypertension and diabetes. Stable renal function with serum creatinine around 1.5 mg/dL.\r\n"
						+ "\r\n"
						+ "Peripheral Arterial Disease (PAD): History of intermittent claudication and reduced pedal pulses bilaterally, diagnosed 4 years ago. Managed with antiplatelet therapy and cilostazol.\r\n"
						+ "\r\n"
						+ "Diabetic Retinopathy: Background retinopathy diagnosed 3 years ago during routine eye examination. Under the care of an ophthalmologist for regular follow-ups.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnPshTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"Coronary Artery Bypass Grafting (CABG): Underwent CABG surgery 5 years ago for severe coronary artery disease. Four-vessel bypass grafting was performed due to extensive atherosclerosis. Postoperative recovery was uneventful, and the patient has been stable since then.\r\n"
						+ "\r\n"
						+ "Cholecystectomy: Had laparoscopic cholecystectomy 10 years ago for symptomatic gallstones. The surgery was successful, and the patient recovered without any complications.\r\n"
						+ "\r\n"
						+ "Total Knee Replacement (TKR): Underwent TKR of the right knee 3 years ago due to severe osteoarthritis. The procedure provided significant relief from pain and improved mobility.\r\n"
						+ "\r\n"
						+ "Transurethral Resection of the Prostate (TURP): Had TURP surgery 2 years ago for benign prostatic hyperplasia (BPH). The procedure was performed to alleviate urinary symptoms caused by prostate enlargement.\r\n"
						+ "\r\n"
						+ "Appendectomy: Appendectomy performed in childhood (age 12) for acute appendicitis. No complications were reported post-surgery.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnFamilyHx(driver);
		dp.enterDataInIframe_HistoryTabs2(driver, "Maternal Side:\r\n" + "\r\n"
				+ "Mother: Deceased at age 68 due to complications of type 2 diabetes. She also had a history of hypertension and suffered a stroke at age 65.\r\n"
				+ "Maternal Grandmother: Died from complications of congestive heart failure at age 72.\r\n"
				+ "Maternal Grandfather: Had a myocardial infarction at age 60 and passed away from a subsequent stroke at age 65.\r\n"
				+ "Paternal Side:\r\n" + "\r\n"
				+ "Father: Alive, with a history of hypertension and hyperlipidemia, currently well-controlled with medication.\r\n"
				+ "Paternal Grandmother: Lived into her 90s with no significant medical issues.\r\n"
				+ "Paternal Grandfather: Passed away from lung cancer at age 78, was a heavy smoker.\r\n"
				+ "Siblings:\r\n" + "\r\n" + "One older sister, age 50, with no significant medical conditions.\r\n"
				+ "One younger brother, age 40, diagnosed with type 1 diabetes at age 20.\r\n" + "Children:\r\n"
				+ "\r\n" + "One adult daughter, age 25, currently healthy with no known medical issues.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnSocialHx(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"Occupation: The patient is employed as a teacher at a local high school, where he has been working for the past 15 years. He reports no significant occupational exposures or hazards.\r\n"
						+ "\r\n"
						+ "Marital Status: Married for 20 years. Lives with his spouse and two teenage children in a suburban neighborhood.\r\n"
						+ "\r\n"
						+ "Tobacco Use: Former smoker. Quit smoking 10 years ago after smoking a pack a day for 25 years. No current tobacco use.\r\n"
						+ "\r\n"
						+ "Alcohol Use: Occasionally consumes alcohol in social settings, typically a glass of wine or beer. Reports drinking alcohol socially once or twice a month.\r\n"
						+ "\r\n" + "Illicit Drug Use: Denies any history of illicit drug use.\r\n" + "\r\n"
						+ "Exercise: Engages in regular moderate exercise, including walking and cycling, for at least 30 minutes most days of the week.\r\n"
						+ "\r\n"
						+ "Diet: Generally follows a balanced diet rich in fruits, vegetables, lean proteins, and whole grains. Occasionally indulges in fast food or processed snacks.\r\n"
						+ "\r\n"
						+ "Safety: Reports wearing seatbelts while driving and using protective gear when engaging in recreational activities such as cycling and hiking.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnDrugAndFoodAllergy(driver);
		dp.enterDataInIframe_HistoryTabs2(driver, "Drug Allergy:\r\n"
				+ "The patient reports a known allergy to penicillin, resulting in hives and itching when exposed to this medication. This reaction was confirmed by a healthcare provider during a previous course of antibiotics.\r\n"
				+ "\r\n" + "Food Allergy:\r\n"
				+ "The patient has a known allergy to shellfish, specifically shrimp, which causes symptoms of facial swelling, itching, and difficulty breathing. This allergy was diagnosed in childhood after an anaphylactic reaction following ingestion of shrimp.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnRosTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"General: The patient reports feeling fatigued over the past few weeks, otherwise denies fever or chills.\r\n"
						+ "\r\n"
						+ "Skin: No rashes, lesions, or changes in skin color reported. Denies itching or dryness.\r\n"
						+ "\r\n"
						+ "Head: Denies headaches, dizziness, or head trauma. No vision changes or eye pain.\r\n"
						+ "\r\n"
						+ "Eyes: No visual disturbances, redness, or discharge. Denies double vision or photophobia.\r\n"
						+ "\r\n"
						+ "Ears, Nose, Throat: No ear pain, hearing loss, or tinnitus. Denies nasal congestion, sore throat, or difficulty swallowing.\r\n"
						+ "\r\n"
						+ "Respiratory: Reports mild cough with clear sputum production. Denies hemoptysis or wheezing. No history of asthma or chronic bronchitis.\r\n"
						+ "\r\n"
						+ "Cardiovascular: Denies chest pain, palpitations, or orthopnea. No history of heart murmurs or peripheral edema.\r\n"
						+ "\r\n"
						+ "Gastrointestinal: Reports occasional heartburn after spicy meals. Denies nausea, vomiting, diarrhea, or constipation. No abdominal pain or changes in bowel habits.\r\n"
						+ "\r\n"
						+ "Genitourinary: No dysuria, hematuria, or urinary frequency reported. Denies flank pain or urinary incontinence.\r\n"
						+ "\r\n"
						+ "Musculoskeletal: Reports occasional joint stiffness in the mornings. Denies swelling, redness, or limitation of movement.\r\n"
						+ "\r\n"
						+ "Neurological: No numbness, tingling, or weakness in extremities. Denies seizures or tremors.\r\n"
						+ "\r\n" + "Psychiatric: Denies symptoms of depression, anxiety, or changes in mood.\r\n"
						+ "\r\n"
						+ "Endocrine: No excessive thirst or urination reported. Denies heat or cold intolerance.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnGpeTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"Geographic Positioning Equipment: This typically refers to devices used for determining the precise geographic location of an object, person, or place. GPS (Global Positioning System) devices are common examples of GPE.\r\n"
						+ "\r\n"
						+ "General Physical Examination: In a medical context, GPE may stand for General Physical Examination. This is a comprehensive assessment of a patient's overall health status, including vital signs, physical appearance, and examination of various body systems.\r\n"
						+ "\r\n"
						+ "Graduate Program in Education: GPE could also refer to a Graduate Program in Education, which involves advanced study and training in the field of education beyond the undergraduate level.\r\n"
						+ "\r\n"
						+ "Global Political Economy: GPE can also stand for Global Political Economy, which is an interdisciplinary field that studies the interaction between political and economic processes at the global level.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnPastInvestigationTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver,
				"Complete Blood Count (CBC) - January 2023: Within normal limits. Hemoglobin: 14 g/dL, White Blood Cell Count: 8.5 x 10^3/µL, Platelet Count: 250 x 10^3/µL.\r\n"
						+ "\r\n"
						+ "Fasting Blood Glucose - August 2022: 110 mg/dL (normal range: 70-99 mg/dL), indicating prediabetes. Patient advised on lifestyle modifications.\r\n"
						+ "\r\n"
						+ "Chest X-ray - March 2021: No acute findings. Clear lung fields, normal cardiac silhouette.\r\n"
						+ "\r\n"
						+ "Electrocardiogram (ECG) - May 2020: Normal sinus rhythm, no evidence of arrhythmias or ischemic changes.\r\n"
						+ "\r\n"
						+ "Lipid Profile - November 2019: Total cholesterol: 190 mg/dL (normal range: <200 mg/dL), LDL cholesterol: 120 mg/dL (normal range: <100 mg/dL), HDL cholesterol: 50 mg/dL (normal range: >40 mg/dL), Triglycerides: 150 mg/dL (normal range: <150 mg/dL). Mildly elevated LDL cholesterol levels.\r\n"
						+ "\r\n"
						+ "Abdominal Ultrasound - July 2018: Normal liver, gallbladder, and spleen. No evidence of gallstones or biliary ductal dilation.\r\n"
						+ "\r\n" + "Colonoscopy - June 2017: No polyps detected. Colon mucosa appears normal.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnProvisionalDiagnosisTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver, "Provisional Diagnosis: Suspicion of Lung Cancer\r\n" + "\r\n"
				+ "Rationale: The patient's symptoms, including persistent cough with hemoptysis (coughing up blood), unintentional weight loss, and fatigue, raise concern for a possible malignancy, particularly lung cancer. Additional risk factors such as a long history of smoking further support this provisional diagnosis. However, further diagnostic evaluation, including imaging studies such as chest X-ray or CT scan, as well as possible biopsy, is necessary to confirm the diagnosis and determine the extent and stage of the disease.");
		dp.clickOnNextBtn_historyTabs(driver);

		scrollToTop(driver);
		dp.clickOnPlanTab(driver);
		dp.enterDataInIframe_HistoryTabs2(driver, "Treatment Plan:\r\n" + "\r\n" + "Patient: John Smith\r\n"
				+ "Provisional Diagnosis: Lung Cancer\r\n" + "\r\n" + "Further Diagnostic Evaluation:\r\n" + "\r\n"
				+ "Chest X-ray or CT scan to evaluate the extent and stage of the disease.\r\n"
				+ "Pulmonary function tests to assess lung function.\r\n"
				+ "Biopsy (e.g., bronchoscopy, CT-guided biopsy) to confirm the diagnosis and determine the type of lung cancer (e.g., non-small cell lung cancer, small cell lung cancer).\r\n"
				+ "Multidisciplinary Consultation:\r\n" + "\r\n"
				+ "Referral to a pulmonologist, oncologist, and/or thoracic surgeon for further evaluation and treatment planning.\r\n"
				+ "Consideration of genetic testing to identify specific mutations or biomarkers that may guide treatment decisions (e.g., EGFR mutations, ALK rearrangements).\r\n"
				+ "Treatment Options:\r\n" + "\r\n"
				+ "Surgical resection: For localized disease (stage I-II), surgical removal of the tumor may be considered, potentially followed by adjuvant chemotherapy or radiation therapy.\r\n"
				+ "Chemotherapy: For more advanced or metastatic disease (stage III-IV), systemic chemotherapy is typically recommended, either alone or in combination with targeted therapies or immunotherapy.\r\n"
				+ "Radiation therapy: May be used as primary treatment for localized disease or as palliative treatment to relieve symptoms and improve quality of life in advanced stages.\r\n"
				+ "Targeted therapy: If genetic testing identifies specific mutations or biomarkers (e.g., EGFR mutation, ALK rearrangement), targeted therapies such as tyrosine kinase inhibitors (TKIs) may be indicated.\r\n"
				+ "Immunotherapy: Checkpoint inhibitors (e.g., pembrolizumab, nivolumab) may be considered for patients with advanced non-small cell lung cancer who express PD-L1 and have no targetable mutations.\r\n"
				+ "Supportive Care:\r\n" + "\r\n"
				+ "Symptom management: Addressing symptoms such as pain, dyspnea, cough, and fatigue with appropriate medications and supportive care measures.\r\n"
				+ "Nutritional support: Dietitian consultation to optimize nutrition and manage weight loss.\r\n"
				+ "Psychosocial support: Referral to a social worker, psychologist, or support group to address emotional and psychosocial needs throughout treatment.\r\n"
				+ "Follow-up:\r\n" + "\r\n"
				+ "Regular follow-up appointments with the healthcare team to monitor treatment response, manage side effects, and adjust the treatment plan as needed.\r\n"
				+ "Surveillance imaging and laboratory tests to monitor disease progression and response to treatment.");
		dp.clickOnNextBtn_historyTabs(driver);

		// ----Progress record-----
		// dp.clickOnSignBtn(driver);
		System.out.println("Hospital Number_OP last : " + hospitalNumber);
	}

}
