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

WebUI.openBrowser("")

String linkPartner="https://partners.shopify.com/"+GlobalVariable.partner_id+"/stores/new"
WebUI.navigateToUrl(linkPartner)
WebUI.setText(findTestObject('Object Repository/Shopify/input_email_shopify'), GlobalVariable.partner_email)
WebUI.click(findTestObject('Object Repository/Shopify/btn_continue_with_email'))
WebUI.setEncryptedText(findTestObject('Object Repository/Shopify/input_password_shopify'), GlobalVariable.partner_password)
WebUI.click(findTestObject('Object Repository/Shopify/btn_login'))

String linkPartner="https://partners.shopify.com/"+GlobalVariable.partner_id+"/stores/new?store_type=dev_preview_store&developer_preview_handle=checkout_extensibility"
WebUI.navigateToUrl(linkPartner)
WebUI.setText(findTestObject('Object Repository/Shopify/input_store_name'), store_name)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Shopify/btn_create_store'))
WebUI.delay(20)