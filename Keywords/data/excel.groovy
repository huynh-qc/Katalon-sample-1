package data

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
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable

public class excel {
	@Keyword
	public void excelfile() {
		String excelFilePath = 'Data Files\\store1.xlsx'
		String sheetName = 'store'
		String textToWrite = 'Fruit'

		def	workbook01 = ExcelKeywords.getWorkbook(excelFilePath)
		def	sheet01 = ExcelKeywords.getExcelSheet(workbook01, sheetName)
		String studentEmail = "huynh-ar-stag-2034"
		int rowIndex = ExcelKeywords.getRowIndexByCellContent(sheet01, studentEmail, 4)
		println rowIndex
		ExcelKeywords.setValueToCellByIndex(sheet01, rowIndex, 7, textToWrite)

		ExcelKeywords.saveWorkbook(excelFilePath, workbook01)
	}
	@Keyword
	public void updateValueToSheet(String file,String sheetname,int colnumtosearch, String rowvaluetosearch, int coltoupdate,String status) {
		def	workbook = ExcelKeywords.getWorkbook(file)
		def	sheet = ExcelKeywords.getExcelSheet(workbook, sheetname)

		int rowIndex = ExcelKeywords.getRowIndexByCellContent(sheet, rowvaluetosearch, colnumtosearch)
		println rowIndex
		ExcelKeywords.setValueToCellByIndex(sheet, rowIndex, coltoupdate, status)
		println 'set roi'
		ExcelKeywords.saveWorkbook(file, workbook)
		println 'saved'
	}
}
