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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://partners.shopify.com/1662018/stores/new')

WebUI.setText(findTestObject('Object Repository/Page_Log in  Partners/input_Email_accountemail'), 'huynh@firegroup.io')

WebUI.click(findTestObject('Object Repository/Page_Log in  Partners/button_Continue with Email'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Shopify/input_Password_accountpassword'), 'aFIq2JAxbLdIICk85ZHRFA==')

WebUI.click(findTestObject('Object Repository/Page_Shopify/button_Log in'))

WebUI.click(findTestObject('Object Repository/Page_Shopify Partners/span_Development store'))

WebUI.setText(findTestObject('Object Repository/Page_Shopify Partners/input_Store name_signupshop_name'), 'huynh-a-5')

WebUI.delay(20)

WebUI.click(findTestObject('Object Repository/Page_Shopify Partners/span_Save'))

WebUI.click(findTestObject('Object Repository/Page_huynh-a-1  Home  Shopify/span_Products'))

WebUI.click(findTestObject('Object Repository/Page_huynh-a-1  Products  Shopify/span_Import'))

WebUI.uploadFile(findTestObject('Object Repository/Page_huynh-a-1  Products  Shopify/file_product'), 'D:\\Users\\Admin\\Downloads\\products_export_1 (5).csv')


WebUI.click(findTestObject('Object Repository/Page_huynh-a-1  Products  Shopify/span_Upload and continue'))

WebUI.click(findTestObject('Object Repository/Page_huynh-a-1  Products  Shopify/span_Import products'))

WebUI.click(findTestObject('Object Repository/Page_huynh-a-1  Products  Shopify/span_Close'))



