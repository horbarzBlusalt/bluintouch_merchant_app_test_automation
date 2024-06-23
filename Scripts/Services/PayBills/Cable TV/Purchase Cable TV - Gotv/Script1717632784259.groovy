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

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Services'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_PayBills'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/span_Cable TV'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/h5_Select Bill Category'), 'Select Bill Category')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/select_biller'))

WebUI.click(findTestObject('Page_BlueInTouch/div_Gotv'))

WebUI.setText(findTestObject('Page_BlueInTouch/enter_iuc_number'), '1219001929')

WebUI.click(findTestObject('Page_BlueInTouch/select_bouquet'))

WebUI.click(findTestObject('Page_BlueInTouch/li_goTV_jollie'))

WebUI.click(findTestObject('Page_BlueInTouch/select_plan'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_N2150  1 Months(s)'))

not_run: WebUI.click(findTestObject('Page_BlueInTouch/enter_phone_number'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_BlueInTouch/phonenumber_input'), '8172881928')

WebUI.scrollToElement(findTestObject('Object Repository/Page_BlueInTouch/button_Pay'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Pay'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Pay With Wallet'))

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(payBillsWindow + 1)

WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

String otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

WebUI.switchToWindowIndex(payBillsWindow)

WebUI.callTestCase(findTestCase('Common Utilities/enter_bills_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Proceed'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/span_2,150.00'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_Transaction Processing'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_View Receipt'))

WebUI.verifyTextPresent('Amount', false)

WebUI.verifyTextPresent('2800.00', false)

WebUI.verifyTextPresent('CABLE_TV', false)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/img_Fund Wallet_logo'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Reports'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Transaction History'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Service Report'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_View'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/span_Successful'), 'Successful')

WebUI.closeBrowser()

