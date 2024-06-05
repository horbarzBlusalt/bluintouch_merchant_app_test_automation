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

dataWindow = WebUI.getWindowIndex()

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Services'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Data'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Send Now'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_Please select data plan for all phone number'), 
    'Please select data plan for all phone number')

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Enter Recipients_phone_numbers'), '+2348175885645,+2348137210473')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/9MobileDropDown'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_50MB validity 24 hours'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/mtnTab'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/mtnDropdown'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_50MB 2Go Weekly Plan'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Send Now'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Pay With Wallet'))

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(dataWindow + 1)

WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

String otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

WebUI.switchToWindowIndex(dataWindow)

WebUI.callTestCase(findTestCase('Common Utilities/enter_payment_otp'), [('otpValue') : otp], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Proceed'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_Transaction Processing'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_View Receipt'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_Amount100.00'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_Failed Trans.2348175885645, 2348137210473'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/p_Transaction Date'), 'Transaction Date')

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/p_Transaction Reference'), 'Transaction Reference')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/img_Fund Wallet_logo'))

WebUI.click(findTestObject('Page_BlueInTouch/span_Reports'))

WebUI.click(findTestObject('Page_BlueInTouch/span_Transaction History'))

//WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_Wallet Debit'), 'Wallet Debit')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Service Report'))
//
WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_View'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/span_Successful'), 'Successful')

WebUI.closeBrowser()


