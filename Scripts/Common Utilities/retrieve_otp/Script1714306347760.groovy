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


WebUI.navigateToUrl('https://yopmail.com')

if(GlobalVariable.stagingEnv) {
	WebUI.setText(findTestObject('Object Repository/Page_YOPmail - Disposable Email Address - A_32619f/input_Type the Email name of your choice_login'),
		GlobalVariable.stagingEmail)
}else {
	WebUI.setText(findTestObject('Object Repository/Page_YOPmail - Disposable Email Address - A_32619f/input_Type the Email name of your choice_login'),
		GlobalVariable.email)
}


WebUI.click(findTestObject('Object Repository/Page_YOPmail - Disposable Email Address - A_32619f/i_'))

WebUI.switchToFrame(findTestObject('Page_BluInTouch/yopmail_iframe'), 60)