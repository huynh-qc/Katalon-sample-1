import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.context.TestCaseContext
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

import bsh.Variable
import groovy.ui.view.WindowsDefaults
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import shopify.store as Store
import com.kms.katalon.core.util.KeywordUtil

KeywordUtil log = new KeywordUtil()
WebUI.openBrowser('')
WebUI.maximizeWindow()


//Store st = new Store()


  //st.loginShopifyPartner(GlobalVariable.partner_email,
 // GlobalVariable.partner_password, GlobalVariable.partner_id)
  	
 	 CustomKeywords.'shopify.store.loginShopifyPartner'(GlobalVariable.partner_email,
		  	GlobalVariable.partner_password, GlobalVariable.partner_id)
	//  st.navigateToStoreDevelop(GlobalVariable.partner_id)
	  CustomKeywords.'shopify.store.navigateToStoreDevelop'(GlobalVariable.partner_id)
	  //st.inputStoreName(store_name)
	  CustomKeywords.'shopify.store.inputStoreName'(store_name)
	  CustomKeywords.'shopify.store.clickCreateStore'()
	 
	  
	  CustomKeywords.'shopify.store.importProduct'(product_file_local)
	  
	  CustomKeywords.'shopify.store.clickOnMenuOnlineStore'()
	  
	  CustomKeywords.'shopify.store.clickOnImportTheme'()
	  
	  CustomKeywords.'shopify.store.innstallThemeShopifyViaUrl'(theme_url,store_name)
	 
	  
	  //CustomKeywords.'shopify.store.uploadThemeFile'(theme_file_local)
	  
	  CustomKeywords.'shopify.store.clickPublishTheme'()
	  
	  CustomKeywords.'shopify.store.confirmPublishTheme'()
	  CustomKeywords.'shopify.store_setting.changeStoreCurrency'(currency, store_name)
	  CustomKeywords.'shopify.store_setting.saveStoreSetting'()
	  
	  CustomKeywords.'shopify.store_setting.changeStorePassword'(store_name, "1")
	  
@com.kms.katalon.core.annotation.TearDownIfFailed
def teardownIfFailed() {

	CustomKeywords.'data.excel.updateValueToSheet'(file_data, "store", 4, store_name, 7, "Failed")
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def teardownIfPassed() {
	
	CustomKeywords.'data.excel.updateValueToSheet'(file_data, "store", 4, store_name, 7, "Passed")
	
}
@com.kms.katalon.core.annotation.TearDownIfError
def teardownIfError() {
	WebUI.takeScreenshot("text loi roi")
}
