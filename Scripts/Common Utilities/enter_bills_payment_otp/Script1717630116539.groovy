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

String getOTP = "$otpValue"

println(getOTP)

WebUI.setText(findTestObject('Page_BlueInTouch/service_otp_one'), getOTP[0])

WebUI.setText(findTestObject('Page_BlueInTouch/service_otp_two'), getOTP[1])

WebUI.setText(findTestObject('Page_BlueInTouch/service_otp_three'), getOTP[2])

WebUI.setText(findTestObject('Page_BluInTouch/bills_otp_four'), getOTP[3])

WebUI.setText(findTestObject('Page_BluInTouch/bills_otp_five'), getOTP[4])

WebUI.setText(findTestObject('Page_BluInTouch/bills_otp_six'), getOTP[5])


