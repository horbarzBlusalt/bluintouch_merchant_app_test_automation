import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.io.File as File
import java.util.*

Random rand = new Random()

int rand_number = rand.nextInt(1000)

def filePath = 'Bulk Uploads/sms.csv'

File file = new File(filePath)

WebUI.callTestCase(findTestCase('Validation/Login TC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Contacts'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/h4_Manage Contacts'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Add, Edit or Delete Contacts'), 'Add, Edit or Delete Contacts')

WebUI.setText(findTestObject('Page_BlueInTouch/input_contact_search'), 'Test')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Apply'))

WebUI.verifyTextPresent('Test SMS', false)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Clear'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Service'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Airtime'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Apply'))

WebUI.verifyElementText(findTestObject('Page_BlueInTouch/td_Airtime'), 'Airtime')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Airtime'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_SMS'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Apply'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_SMS'), 'SMS')

WebUI.click(findTestObject('Page_BlueInTouch/div_SMS_dropdown'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Data'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Apply'))

WebUI.verifyElementPresent(findTestObject('Page_BlueInTouch/td_Data'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Clear'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_25'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_50'))

WebUI.scrollToElement(findTestObject('Object Repository/Page_BlueInTouch/span_50'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/span_50'), '50')

WebUI.click(findTestObject('Page_BlueInTouch/div_50_dropdown'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_100'))

WebUI.scrollToElement(findTestObject('Page_BlueInTouch/span_100'), 0)

WebUI.verifyElementText(findTestObject('Page_BlueInTouch/span_100'), '100')

WebUI.scrollToPosition(0, 100)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Date'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Last 30 Days'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Apply'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Clear'))

WebUI.click(findTestObject('Page_BlueInTouch/menu_btn_contact'))

WebUI.click(findTestObject('Page_BlueInTouch/contactedit_button'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Back'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Ungrouped'))

WebUI.click(findTestObject('Page_BlueInTouch/ungroup_date_filter'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_This Week'))

WebUI.click(findTestObject('Page_BlueInTouch/ungrouped_apply_btn'))

WebUI.click(findTestObject('Page_BlueInTouch/ungroup_date_filter'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_This Month'))

WebUI.click(findTestObject('Page_BlueInTouch/ungrouped_apply_btn'))

WebUI.click(findTestObject('Page_BlueInTouch/clear_btn_ungrouped'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Date Added_sc-jlZhew cqJiSU danger danger'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Delete'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Ungrouped'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/th_Country Code'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Grouped Contacts'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Add Grouped Contacts'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Create New Group'))

String newContact = 'TEST Contact' + rand_number

WebUI.setText(findTestObject('Page_BlueInTouch/input_Group Name_name'), newContact)

WebUI.click(findTestObject('Page_BlueInTouch/select_contact_catgeory'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Data'))

WebUI.uploadFile(findTestObject('Page_BlueInTouch/upload_contact_data'), file.getAbsolutePath())

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Create Group'))

WebUI.verifyTextPresent(newContact, false)

WebUI.click(findTestObject('Page_BlueInTouch/menu_btn_contact'))

WebUI.click(findTestObject('Page_BlueInTouch/contactedit_button'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/img_Phone Number_logo'))

WebUI.setText(findTestObject('Page_BlueInTouch/phonenumber_input'), '8023206755')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Update'))

WebUI.click(findTestObject('Page_BlueInTouch/menu_btn_contact'))

WebUI.click(findTestObject('Page_BlueInTouch/contactedit_button'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/img_Phone Number_logo_1'))

WebUI.delay(2)

not_run: WebUI.click(findTestObject('Page_BlueInTouch/delete_icon'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Delete'))

WebUI.closeBrowser()

