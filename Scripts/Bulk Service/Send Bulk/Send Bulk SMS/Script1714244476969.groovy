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
import java.util.*

Random rand = new Random()

int rand_number = rand.nextInt(1000)

WebUI.callTestCase(findTestCase('Validation/Login TC'), [:], FailureHandling.STOP_ON_FAILURE)

bulkSMSWindow = WebUI.getWindowIndex()

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Bulk Service'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Send Bulk'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Send Now'))

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Bulk Name_campaign_name'), 'Automated Test Bulk SMS')

WebUI.click(findTestObject('Page_BlueInTouch/sender_id_dropdown'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/li_FLCC'))

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/textarea_Good morning people, this is an au_c206c9'), 'Good morning people, this is an automated sms feature')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Send Now'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_please fill all fields'), 0)

WebUI.uploadFile(findTestObject('Page_BlueInTouch/upload_contact'), '/Users/obaloluwaabioye/Katalon Studio/MerchantPortal/Bulk Uploads/sms.csv')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/span_100'), 0)

WebUI.click(findTestObject('Page_BlueInTouch/input_wrapper'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Send Now'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Pay With Wallet'))

WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : '123456'], FailureHandling.STOP_ON_FAILURE)

String price = WebUI.getText(findTestObject('Object Repository/Page_BlueInTouch/final_computed_price'))

println(price)

WebUI.click(findTestObject('Page_BlueInTouch/proceed_btn'))

WebUI.verifyElementVisible(findTestObject('Page_Inbox/div_Invalid token passed'))

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(bulkSMSWindow + 1)

WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

String otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

println(otp)

WebUI.switchToWindowIndex(bulkSMSWindow)

WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_BlueInTouch/proceed_btn'))

try {
    WebUI.verifyElementText(findTestObject('Page_Inbox/div_Invalid token passed'), 'This campaign already exists')

    WebUI.refresh()

    WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Bulk Name_campaign_name'), 'Automated Test Bulk SMS ' + 
        rand_number)

    WebUI.click(findTestObject('Page_BlueInTouch/sender_id_dropdown'))

    WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/li_FLCC'))

    WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/textarea_Good morning people, this is an au_c206c9'), 
        'Good morning people, this is an automated sms feature')

    WebUI.uploadFile(findTestObject('Page_BlueInTouch/upload_contact'), '/Users/obaloluwaabioye/Katalon Studio/MerchantPortal/Bulk Uploads/sms.csv')

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/span_100'), 0)

    WebUI.delay(5)

    WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Send Now'))

    WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Pay With Wallet'))

    WebUI.switchToWindowIndex(bulkSMSWindow + 1)

    WebUI.refresh()

    WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

    otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

    WebUI.switchToWindowIndex(bulkSMSWindow)

    WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_BlueInTouch/proceed_btn'))

    WebUI.verifyElementText(findTestObject('Page_BlueInTouch/bulk_success_message'), 'Bulk SMS launched successfully')
}
catch (Exception e) {
    e.toString()

    WebUI.verifyElementText(findTestObject('Page_BlueInTouch/bulk_success_message'), 'Bulk SMS launched successfully')
} 

