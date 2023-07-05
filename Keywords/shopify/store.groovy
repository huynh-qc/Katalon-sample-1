package shopify

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

public class store {
	@Keyword
	public void loginShopifyPartner(String partnerEmail, String partnerPassword, String partnerID) {

		String linkPartner="https://partners.shopify.com/"+partnerID+"/stores/new"
		WebUI.navigateToUrl(linkPartner)
		WebUI.setText(findTestObject('Object Repository/Shopify/input_email_shopify'), partnerEmail)
		WebUI.click(findTestObject('Object Repository/Shopify/btn_continue_with_email'))
		WebUI.setEncryptedText(findTestObject('Object Repository/Shopify/input_password_shopify'), partnerPassword)
		WebUI.click(findTestObject('Object Repository/Shopify/btn_login'))
	}
	@Keyword
	public void navigateToStoreDevelop(String partnerID) {
		String linkPartner="https://partners.shopify.com/"+partnerID+"/stores/new?store_type=dev_preview_store&developer_preview_handle=checkout_extensibility"
		WebUI.navigateToUrl(linkPartner)
	}
	@Keyword
	public void inputStoreName(String store_name) {
		WebUI.setText(findTestObject('Object Repository/Shopify/input_store_name'), store_name)
		WebUI.delay(5)
	}
	@Keyword
	public void clickCreateStore() {
		WebUI.click(findTestObject('Object Repository/Shopify/btn_create_store'))
		WebUI.waitForPageLoad(40, FailureHandling.OPTIONAL)
	}
	@Keyword
	public void importProduct(String product_file) {
		WebUI.click(findTestObject('Object Repository/Shopify/span_product'))
		WebUI.click(findTestObject('Object Repository/Shopify/span_import_product'))
		WebUI.uploadFile(findTestObject('Object Repository/Shopify/file_product'), System.getProperty("user.dir") +product_file)
		WebUI.click(findTestObject('Object Repository/Shopify/span_upload_product_continue'))
		WebUI.click(findTestObject('Object Repository/Shopify/btn_product_confirm_import'))
		WebUI.delay(30)
		WebUI.refresh()
		WebUI.delay(15)
	}
	@Keyword
	public void clickOnMenuOnlineStore() {
		WebUI.click(findTestObject('Object Repository/Shopify Store/a_onlie_store'))
		WebUI.delay(10)
	}
	@Keyword
	public void clickOnImportTheme() {
		WebUI.delay(10)
		WebUI.switchToDefaultContent()
		WebUI.delay(10)
		WebUI.switchToFrame(findTestObject('Object Repository/Shopify Store/iframe_online_store'), 1)
		WebUI.click(findTestObject('Object Repository/Shopify Store/btn_add_theme'))
	}

	@Keyword
	public void uploadThemeFile(String file_path) {
		WebUI.click(findTestObject('Object Repository/Shopify Store/btn_upload_zip_file'))
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Shopify Store/iframe_import_theme'), 1)
		WebUI.uploadFile(findTestObject('Object Repository/Shopify Store/file_theme'), System.getProperty("user.dir") +file_path)
		WebUI.click(findTestObject('Object Repository/Shopify Store/btn_upload_theme'))
		WebUI.delay(10)
	}

	@Keyword
	public void connectFromGithub() {
		WebUI.click(findTestObject('Object Repository/Shopify Store/san_connect_from_github'))
		WebUI.delay(10)
	}
	@Keyword
	public void clickPublishTheme() {
		WebUI.delay(30)
		WebUI.refresh()
		WebUI.delay(30)
		WebUI.switchToFrame(findTestObject('Object Repository/Shopify Store/iframe_online_store'), 1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Shopify Store/btn_publish_theme'), 30)
		WebUI.click(findTestObject('Object Repository/Shopify Store/btn_publish_theme'))
	}
	@Keyword
	public void confirmPublishTheme() {
		WebUI.delay(10)
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Shopify Store/iframe_publish_theme'), 1)
		WebUI.click(findTestObject('Object Repository/Shopify Store/btn_confirm_publish_theme'))
	}

	@Keyword
	public void loginStore(String partnerEmail, String partnerPassword, String raw_domain) {
		WebUI.navigateToUrl(raw_domain)
		WebUI.setText(findTestObject('Object Repository/Shopify/input_email_shopify'), partnerEmail)
		WebUI.click(findTestObject('Object Repository/Shopify/btn_continue_with_email'))
		WebUI.setEncryptedText(findTestObject('Object Repository/Shopify/input_password_shopify'), partnerPassword)
		WebUI.click(findTestObject('Object Repository/Shopify/btn_login'))
	}
	@Keyword
	public void innstallThemeShopifyViaUrl(String themeurl, String storename) {
		String full_url= themeurl+"?shop="+storename+".myshopify.com"
		println full_url
		WebUI.navigateToUrl(full_url)
		WebUI.click(findTestObject('Object Repository/Shopify/div_user_card_name'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/Shopify Theme/a_trytheme'))
		WebUI.click(findTestObject('Object Repository/Shopify/div_user_card_name'),FailureHandling.OPTIONAL)
		WebUI.navigateToUrl(full_url)
		WebUI.click(findTestObject('Object Repository/Shopify Theme/a_trytheme'))
	}
	@Keyword
	public void clickOnShopifyUserCard() {
		WebUI.click(findTestObject('Object Repository/Shopify/div_user_card_name'),FailureHandling.OPTIONAL)
	}
	@Keyword
	public void loginToStoreAdmin(String partnerEmail, String partnerPassword, String store_name) {
		String raw_domain_admin=store_name+".myshopify.com/admin"
		println raw_domain_admin
		WebUI.navigateToUrl(raw_domain_admin)
		WebUI.setText(findTestObject('Object Repository/Shopify/input_email_shopify'), partnerEmail)
		WebUI.click(findTestObject('Object Repository/Shopify/btn_continue_with_email'))
		WebUI.setEncryptedText(findTestObject('Object Repository/Shopify/input_password_shopify'), partnerPassword)
		WebUI.click(findTestObject('Object Repository/Shopify/btn_login'))
	}
}
