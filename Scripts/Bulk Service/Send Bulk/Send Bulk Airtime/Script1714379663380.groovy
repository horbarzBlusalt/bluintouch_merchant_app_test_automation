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
import java.io.File as File

def filePath = 'Bulk Uploads/airtime_nigeria.csv'

File file = new File(filePath)

Random rand = new Random()

int rand_number = rand.nextInt(1000)

WebUI.callTestCase(findTestCase('Validation/Login TC'), [:], FailureHandling.STOP_ON_FAILURE)

bulkAirtimeWindow = WebUI.getWindowIndex()

WebUI.click(findTestObject('Page_BlueInTouch/span_Bulk Service'))

WebUI.click(findTestObject('Page_BlueInTouch/span_Send Bulk'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Airtime'))

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Bulk Name_campaignName'), 'Automated Bulk Airtime')

WebUI.uploadFile(findTestObject('Page_BlueInTouch/upload_contact_airtime'), file.getAbsolutePath())

WebUI.verifyTextPresent('100%', false)

WebUI.click(findTestObject('Page_BlueInTouch/button_Send Bulk Airtime'))

WebUI.click(findTestObject('Page_BlueInTouch/div_Pay With Wallet'))

WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : '123456'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Proceed'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Invalid token passed'), 'Invalid token passed')

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(bulkAirtimeWindow + 1)

WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

String otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

WebUI.switchToWindowIndex(bulkAirtimeWindow)

WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Proceed'))

try {
    WebUI.verifyElementText(findTestObject('Page_Inbox/div_Invalid token passed'), 'This campaign already exists')

    WebUI.refresh()

    WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Airtime'))

    WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Bulk Name_campaignName'), 'Automated Test Airtime' + 
        rand_number)

    WebUI.uploadFile(findTestObject('Page_BlueInTouch/upload_contact_airtime'), file.getAbsolutePath())

    WebUI.verifyTextPresent('100%', false)

    WebUI.click(findTestObject('Page_BlueInTouch/button_Send Bulk Airtime'))

    WebUI.click(findTestObject('Page_BlueInTouch/div_Pay With Wallet'))

    WebUI.switchToWindowIndex(bulkAirtimeWindow + 1)

    WebUI.refresh()

    WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

    otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

    WebUI.switchToWindowIndex(bulkAirtimeWindow)

    WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_BlueInTouch/proceed_btn'))

    WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Bulk airtime launched successfully'), 
        'Your bulk airtime is being processed')
}
catch (Exception e) {
    e.toString()

    WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Bulk airtime launched successfully'), 
        'Your bulk airtime is being processed')
} 

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/img_Fund Wallet_logo'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_completed'), 0)

try {
	WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_0'), '0')
}catch(Exception e) {
	WebUI.delay(1)
	WebUI.refresh()
	WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_0'), '0')
}

WebUI.scrollToElement(findTestObject('Object Repository/Page_BlueInTouch/span_Reports'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Reports'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Transaction History'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_Wallet Credit'), 'Wallet Credit')

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_Airtime'), 'Airtime')

WebUI.closeBrowser()

