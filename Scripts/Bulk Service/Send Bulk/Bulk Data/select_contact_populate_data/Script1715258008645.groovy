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


WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/div_Add from Contact'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/h5_demo-staging-group'))

String networkProvider = WebUI.getAttribute(findTestObject('Object Repository/Page_BlueInTouch/data_text_one'), 'innerText')
println(networkProvider)

WebUI.click(findTestObject('Page_BlueInTouch/data_select_one'))
WebUI.callTestCase(findTestCase('Bulk Service/Send Bulk/Bulk Data/select_data_plan'), [('networkProvider') : networkProvider], FailureHandling.STOP_ON_FAILURE)

networkProvider = WebUI.getAttribute(findTestObject('Object Repository/Page_BlueInTouch/data_text_two'), 'innerText')
WebUI.click(findTestObject('Page_BlueInTouch/data_select_two'))
WebUI.callTestCase(findTestCase('Bulk Service/Send Bulk/Bulk Data/select_data_plan'), [('networkProvider') : networkProvider], FailureHandling.STOP_ON_FAILURE)

networkProvider = WebUI.getAttribute(findTestObject('Object Repository/Page_BlueInTouch/data_text_three'), 'innerText')
WebUI.click(findTestObject('Page_BlueInTouch/data_select_three'))
WebUI.callTestCase(findTestCase('Bulk Service/Send Bulk/Bulk Data/select_data_plan'), [('networkProvider') : networkProvider], FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/span_149.99'), 0)

WebUI.click(findTestObject('Page_BlueInTouch/button_Send Bulk Data'))

try {
	WebUI.verifyElementPresent(findTestObject('Page_BlueInTouch/select_numbers_error'), 0)

	WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/next_button'))
	
	networkProvider = WebUI.getAttribute(findTestObject('Object Repository/Page_BlueInTouch/data_text_one'), 'innerText')
	WebUI.click(findTestObject('Page_BlueInTouch/data_select_one'))
	WebUI.callTestCase(findTestCase('Bulk Service/Send Bulk/Bulk Data/select_data_plan'), [('networkProvider') : networkProvider], FailureHandling.STOP_ON_FAILURE)

	WebUI.click(findTestObject('Page_BlueInTouch/button_Send Bulk Data'))
}
catch (Exception e) {
	e.toString()
}

WebUI.click(findTestObject('Page_BlueInTouch/div_Pay With Wallet'))


