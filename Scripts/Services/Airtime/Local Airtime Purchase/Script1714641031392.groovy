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

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Services'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Airtime'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Pay'))

WebUI.verifyElementPresent(findTestObject('Page_BlueInTouch/div_please fill all fields'), 0)

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Buy Airtime_phone_number'), '+2348175885645')

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input__amount'), '10')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Pay'))

WebUI.click(findTestObject('Page_BlueInTouch/div_Pay With Wallet'))

WebUI.switchToWindowTitle('YOPmail - Disposable Email Address - Anonymous and temporary inbox')

WebUI.setText(findTestObject('Page_YOPmail - Disposable Email Address - A_32619f/input_Type the Email name of your choice_login'), 
    'richbayo')

WebUI.sendKeys(findTestObject('Page_YOPmail - Disposable Email Address - A_32619f/input_Type the Email name of your choice_login'), 
    Keys.chord(Keys.ENTER))

WebUI.switchToWindowTitle('BlueInTouch')

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_10.00_sc-dLMFU bKPCnw otpInput'), '0')

WebUI.click(findTestObject('Page_BlueInTouch/button_Proceed'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_customers0.amount must be greater than _a3a71f'), 
    0)

WebUI.refresh()

WebUI.switchToWindowTitle('BlueInTouch')

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Buy Airtime_phone_number'), '+2348175885645')

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input__amount'), '100')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Pay'))

WebUI.click(findTestObject('Page_BlueInTouch/div_Pay With Wallet'))

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_10.00_sc-dLMFU bKPCnw otpInput'), '1')

WebUI.click(findTestObject('Page_BlueInTouch/button_Proceed'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_The Payment of100.00was deducted succes_5c45f2'), 
    0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_View Receipt'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/p_100.00'), '100.00')

WebUI.click(findTestObject('Page_BlueInTouch/img_Fund Wallet_logo'))

WebUI.click(findTestObject('Page_BlueInTouch/span_Reports'))

WebUI.click(findTestObject('Page_BlueInTouch/span_Transaction History'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/td_Wallet Debit'), 'Wallet Debit')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Service Report'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_View'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/span_Successful'), 'Successful')

WebUI.closeBrowser()

