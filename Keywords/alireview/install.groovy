package alireview

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
import com.kms.katalon.keyword.excel.ExcelKeywords
import internal.GlobalVariable

public class install {
	@Keyword
	public void inputRawDomain(String raw_domain, String host) {
		WebUI.navigateToUrl(host)
		WebUI.setText(findTestObject('Object Repository/Alireview/input_shop'), raw_domain)
		WebUI.click(findTestObject('Object Repository/Alireview/btn_login'))
	}
	@Keyword
	public void installStep1() {
		WebUI.click(findTestObject('Object Repository/Shopify Install App/btn_install_step1'))
	}

	@Keyword
	public void onboardingSelectColor(String color) {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Alireview/iframe_app'), 1)
		WebUI.setText(findTestObject('Object Repository/Alireview/input_color'), color)
	}
	@Keyword
	public void onboardingSelectStyle(String type) {
		if(type=='list') {
			WebUI.click(findTestObject('Object Repository/Alireview/label_list_onboarding'))
		}
		if (type=='grid') {
			WebUI.click(findTestObject('Object Repository/Alireview/label_grid_onboarding'))
		}
		if(type=='carousel') {
			WebUI.click(findTestObject('Object Repository/Alireview/label_carousel_onboarding'))
		}
	}
	@Keyword
	public void onboardingNext() {
		WebUI.click(findTestObject('Object Repository/Alireview/btn_next_onboarding'))
	}

	@Keyword
	public void clickGetStartOnboarding() {
		WebUI.click(findTestObject('Object Repository/Alireview/btn_get_start_onboarding'))
	}
	@Keyword
	void addGlobalVariable(String name, def value) {
		GroovyShell shell1 = new GroovyShell()
		MetaClass mc = shell1.evaluate("internal.GlobalVariable").metaClass
		String getterName = "get" + name.capitalize()
		mc.'static'."$getterName" = { -> return value }
		mc.'static'."$name" = value
	}
}
