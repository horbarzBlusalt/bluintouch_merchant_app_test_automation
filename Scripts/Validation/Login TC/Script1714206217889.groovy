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

if (GlobalVariable.stagingEnv) {
    WebUI.openBrowser('https://staging.bluintouch.com/')
} else {
    WebUI.openBrowser('https://dev.bluintouch.com/')
}

currentWindow = WebUI.getWindowIndex()

WebUI.maximizeWindow()

if (GlobalVariable.testLoginOnly) {
    WebUI.setText(findTestObject('Object Repository/Page_BluInTouch/input_Company Email_email'), 'johnsolo12@yopmail.com')

    WebUI.click(findTestObject('Object Repository/Page_BluInTouch/button_Login'))

    WebUI.setEncryptedText(findTestObject('Object Repository/Page_BluInTouch/input_Password_password'), 'MHSUC33hkPmoriEBrWV97Q==')

    WebUI.click(findTestObject('Object Repository/Page_BluInTouch/button_Login'))

    try {
        WebUI.verifyElementText(findTestObject('Object Repository/Page_BluInTouch/div_Incorrect password or email'), 'Incorrect password or email')
    }
    catch (Exception e) {
        WebUI.verifyElementText(findTestObject('Object Repository/Page_BluInTouch/div_Incorrect password or email'), 'Invalid Credentials')
    } 
    
    WebUI.setText(findTestObject('Object Repository/Page_BluInTouch/input_Company Email_email'), 'johnsolo@yopmail.com')

    WebUI.click(findTestObject('Object Repository/Page_BluInTouch/button_Login'))

    try {
        WebUI.verifyElementText(findTestObject('Object Repository/Page_BluInTouch/div_Incorrect password or email'), 'Incorrect password or email')
    }
    catch (Exception e) {
        WebUI.verifyElementText(findTestObject('Object Repository/Page_BluInTouch/div_Incorrect password or email'), 'Invalid Credentials')
    } 
    
    WebUI.click(findTestObject('Object Repository/Page_BluInTouch/div_Incorrect password or email'))

    WebUI.setText(findTestObject('Object Repository/Page_BluInTouch/input_Password_password_1'), 'P@ssword1')

    WebUI.click(findTestObject('Object Repository/Page_BluInTouch/button_Login'))

    try {
        WebUI.verifyElementText(findTestObject('Object Repository/Page_BluInTouch/div_Incorrect password or email'), 'Incorrect password or email')
    }
    catch (Exception e) {
        WebUI.verifyElementText(findTestObject('Object Repository/Page_BluInTouch/div_Incorrect password or email'), 'Invalid Credentials')
    } 
}

if(GlobalVariable.stagingEnv) {
	WebUI.setText(findTestObject('Object Repository/Page_BluInTouch/input_Company Email_email'), GlobalVariable.stagingEmail)
}else {
	WebUI.setText(findTestObject('Object Repository/Page_BluInTouch/input_Company Email_email'), GlobalVariable.email)
}

WebUI.setText(findTestObject('Object Repository/Page_BluInTouch/input_Password_password_1'), 'P@ssword1')

WebUI.click(findTestObject('Object Repository/Page_BluInTouch/button_Login'))

if (GlobalVariable.two_factor) {
    WebUI.callTestCase(findTestCase('Validation/enter_otp'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_BluInTouch/button_Verify'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BluInTouch/div_Invalid token passed'), 0)

    WebUI.executeJavaScript('window.open();', [])

    WebUI.switchToWindowIndex(currentWindow + 1)

    WebUI.callTestCase(findTestCase('Common Utilities/retrieve_otp'), [:], FailureHandling.STOP_ON_FAILURE)

    String otp = WebUI.getText(findTestObject('Object Repository/Page_BluInTouch/otp_value'))

    println(otp)

    WebUI.switchToWindowIndex(currentWindow)

    WebUI.setText(findTestObject('Page_BluInTouch/two_fa_input_one'), otp[0])

    WebUI.setText(findTestObject('Page_BluInTouch/two_fa_input_two'), otp[1])

    WebUI.setText(findTestObject('Page_BluInTouch/two_fa_input_three'), otp[2])

    WebUI.setText(findTestObject('Page_BluInTouch/two_fa_input_four'), otp[3])

    WebUI.setText(findTestObject('Page_BluInTouch/two_fa_input_five'), otp[4])

    WebUI.setText(findTestObject('Page_BluInTouch/two_fa_input_six'), otp[5])

    WebUI.click(findTestObject('Object Repository/Page_BluInTouch/button_Verify'))
}

WebUI.verifyElementText(findTestObject('Object Repository/Page_BluInTouch/h4_Dashboard'), 'Dashboard')

