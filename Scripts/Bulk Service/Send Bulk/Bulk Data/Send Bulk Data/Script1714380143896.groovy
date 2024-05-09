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

bulkDataWindow = WebUI.getWindowIndex()

WebUI.click(findTestObject('Page_BlueInTouch/span_Bulk Service'))

WebUI.click(findTestObject('Page_BlueInTouch/span_Send Bulk'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Data'))

WebUI.click(findTestObject('Page_BlueInTouch/button_Send Bulk Data'))

WebUI.setText(findTestObject('Page_BlueInTouch/input_Bulk Name_dataCampaignName'), 'Automated Bulk Data')

WebUI.callTestCase(findTestCase('Bulk Service/Send Bulk/Bulk Data/select_contact_populate_data'), null)

WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : '123456'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_BlueInTouch/proceed_btn'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Invalid token passed'), 'Invalid token passed')

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(bulkDataWindow + 1)

WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

String otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

WebUI.switchToWindowIndex(bulkDataWindow)

WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_BlueInTouch/proceed_btn'))

try {
    WebUI.verifyElementText(findTestObject('Page_Inbox/div_Invalid token passed'), 'This campaign already exists')

    WebUI.refresh()

	WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Data'))

    WebUI.setText(findTestObject('Page_BlueInTouch/input_Bulk Name_dataCampaignName'), 'Automated Bulk Data' + 
        rand_number)

	WebUI.callTestCase(findTestCase('Bulk Service/Send Bulk/Bulk Data/select_contact_populate_data'), null)
	
    WebUI.switchToWindowIndex(bulkDataWindow + 1)

    WebUI.refresh()

    WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

    otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

    WebUI.switchToWindowIndex(bulkDataWindow)

    WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_BlueInTouch/proceed_btn'))

    WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Bulk Data launched successfully'), 'Bulk Data launched successfully')
}
catch (Exception e) {
    e.toString()

    WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Bulk Data launched successfully'), 'Bulk Data launched successfully')
} 

WebUI.click(findTestObject('Page_BlueInTouch/img_Fund Wallet_logo'))

WebUI.verifyElementText(findTestObject('Page_BlueInTouch/div_completed'), 'Completed')

WebUI.verifyElementPresent(findTestObject('Page_BlueInTouch/td_0'), 0)

WebUI.click(findTestObject('Page_BlueInTouch/span_Reports'))

WebUI.click(findTestObject('Page_BlueInTouch/span_Transaction History'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_Data'), 'Data')

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_Successful'), 'Successful')

WebUI.verifyElementPresent(findTestObject('Page_BlueInTouch/td_Wallet Credit'), 0)

WebUI.closeBrowser()

