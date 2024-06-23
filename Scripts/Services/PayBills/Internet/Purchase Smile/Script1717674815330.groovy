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

WebUI.callTestCase(findTestCase('Validation/Login TC'), [:], FailureHandling.STOP_ON_FAILURE)

payBillsWindow = WebUI.getWindowIndex()

WebUI.click(findTestObject('Page_BlueInTouch/span_Services'))

WebUI.click(findTestObject('Page_BlueInTouch/span_PayBills'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Internet'))

WebUI.click(findTestObject('Page_BlueInTouch/select_electricity_biller'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/li_Smile'))

WebUI.delay(2)

WebUI.click(findTestObject('Page_BlueInTouch/select_meter_type'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_SML-1GB-300  1DAY'))

WebUI.setText(findTestObject('Page_BlueInTouch/enter_iuc_number'), '129019920110121')

WebUI.click(findTestObject('Page_BlueInTouch/button_Pay'))

WebUI.click(findTestObject('Page_BlueInTouch/div_Pay With Wallet'))

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(payBillsWindow + 1)

WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

String otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

WebUI.switchToWindowIndex(payBillsWindow)

WebUI.callTestCase(findTestCase('Common Utilities/enter_bills_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Proceed'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_Transaction Processing'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_View Receipt'))

WebUI.verifyTextPresent('Amount', false)

WebUI.verifyTextPresent('300.00', false)

WebUI.verifyTextPresent('INTERNET', false)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/img_Fund Wallet_logo'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Reports'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Transaction History'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Service Report'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_View'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/span_Successful'), 'Successful')

WebUI.closeBrowser()

