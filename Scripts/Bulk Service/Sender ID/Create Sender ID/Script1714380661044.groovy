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

WebUI.click(findTestObject('Page_BlueInTouch/span_Bulk Service'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/span_Sender ID'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/h4_Sender ID'), 'Sender ID')

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/h5_Manage Your Identifications'), 'Manage Your Identifications')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Create New'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Submit'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_name is required'), 'name is required.')

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Sender ID_sender_id'), GlobalVariable.existingSenderId)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Submit'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_countryId is required'), 'countryId is required.')

WebUI.click(findTestObject('Page_BlueInTouch/div_country'))

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/li_Nigeria'))

WebUI.setText(findTestObject('Page_BlueInTouch/textarea_Hello welcome to our test automation'), 'Hello welcome to our test automation')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Submit'))

WebUI.verifyElementText(findTestObject('Page_BlueInTouch/div_You cant request for more than two senderId'), 'You can\'t request for more than two senderId')

WebUI.setText(findTestObject('Object Repository/Page_BlueInTouch/input_Sender ID_sender_id'), GlobalVariable.newSenderId + 
    rand_number)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_Your ID is being verified by our Admin,_392d60'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_Click the button below if you would wan_6e6856'), 
    0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/button_Continue'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_BlueInTouch/div_pending'), 'pending')

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Pending'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_pending'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Approved'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BlueInTouch/div_approved'), 0)

WebUI.click(findTestObject('Object Repository/Page_BlueInTouch/a_Rejected'))

WebUI.closeBrowser()

