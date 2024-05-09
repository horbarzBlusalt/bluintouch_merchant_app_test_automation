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

String getNetworkProvider = "$networkProvider"

if(getNetworkProvider.equals("MTN Nigeria")) {
	WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_50MB 2Go Weekly Plan'))
}else if(getNetworkProvider.equals("Airtel Nigeria")) {
	WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_This Data plan gives 40MB for N50 valid_8433bb'))
}else if(getNetworkProvider.contains("9Mobile")) {
	WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/9mobile_data'))
}else if(getNetworkProvider.contains("Glo")) {
	WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/glo_data'))
}