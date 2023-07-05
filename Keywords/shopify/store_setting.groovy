package shopify
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class store_setting {
	@Keyword
	public void changeStoreCurrency(String currency,String store_name) {
		WebUI.delay(10)
		String raw_domain_admin=store_name+".myshopify.com/admin/settings/general"
		WebUI.navigateToUrl(raw_domain_admin)
		WebUI.selectOptionByValue(findTestObject('Object Repository/Shopify Store/select_currency'), currency, false)
	}
	@Keyword
	public void saveStoreSetting() {
		WebUI.click(findTestObject('Object Repository/Shopify Store/span_save_admin_setting'))
	}
	@Keyword
	public void changeStorePassword(String store_name, String password) {
		WebUI.delay(10)
		String raw_domain_admin=store_name+".myshopify.com/admin/online_store/preferences?tutorial=unlock"
		WebUI.navigateToUrl(raw_domain_admin)
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Shopify Store/div_loading_bar'), 50)
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Shopify Store/iframe_online_store'), 1)
		WebUI.sendKeys(findTestObject('Object Repository/Shopify Store/input_storefront_password'), password)
		WebUI.sendKeys(findTestObject('Object Repository/Shopify Store/input_storefront_password'), Keys.chord(Keys.ENTER))
	}
}
