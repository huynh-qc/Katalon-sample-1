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
WebUI.maximizeWindow()

CustomKeywords.'shopify.store.loginToStoreAdmin'(GlobalVariable.partner_email,
GlobalVariable.partner_password, store_name)
  
CustomKeywords.'alireview.install.inputRawDomain'(store_name, GlobalVariable.host)
CustomKeywords.'alireview.install.installStep1'()
CustomKeywords.'shopify.store.clickOnShopifyUserCard'()

CustomKeywords.'alireview.install.onboardingSelectColor'(color)

CustomKeywords.'alireview.install.onboardingSelectStyle'(layout_type)

CustomKeywords.'alireview.install.onboardingNext'()

CustomKeywords.'alireview.install.clickGetStartOnboarding'()
@com.kms.katalon.core.annotation.TearDownIfFailed
def teardownIfFailed() {
	String excelFilePath = 'Data Files\\storefree3_install app stag.xlsx'
	CustomKeywords.'data.excel.updateValueToSheet'(excelFilePath, "store", 4, store_name, 9, "Not install")
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def teardownIfPassed() {
	String excelFilePath = 'Data Files\\storefree3_install app stag.xlsx'
	CustomKeywords.'data.excel.updateValueToSheet'(excelFilePath, "store", 4, store_name, 9, "Installed")
	
}
@com.kms.katalon.core.annotation.TearDownIfError
def teardownIfError() {
	WebUI.takeScreenshot("text loi roi")
}
