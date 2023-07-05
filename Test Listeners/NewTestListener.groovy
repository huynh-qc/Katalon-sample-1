import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	
	def validData(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		println 'testCaseContext'
		println testCaseContext.getTestCaseVariables()
		
		Map<String, Object> map = testCaseContext.getTestCaseVariables()
		String fileName = map.get("testcae_status")
		println fileName
		testCaseContext.skipThisTestCase()
	}
	
	@BeforeTestCase
	def skipStatus(TestCaseContext testCaseContext) {
		Map<String, Object> map = testCaseContext.getTestCaseVariables()
		String testcae_status = map.get("testcase_status")
		println testcae_status
		if(testcae_status=='Passed' || testcae_status=='Failed' ) {
			testCaseContext.skipThisTestCase()
		}
	}
	
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		println 'testCaseContext'
		testCaseContext.getTestCaseVariables()
		String accexcel="C:\\xxxx\\xx.xlsx"
		String ContractNumber = GlobalVariable.ContractNumber
		String PassFail
		String ErrorMsg = GlobalVariable.ErrorMsg
		switch (testCaseContext.getTestCaseStatus()) {
			case 'FAILED':
				PassFail = "Fail";
				break
			case 'ERROR':
				PassFail = "Fail";
				break
			case 'PASSED':
				PassFail = "Pass";
				break
	}
				
	XSSFWorkbook workbook1 = ExcelKeywords.getWorkbook(accexcel)
	XSSFSheet sheet1 = ExcelKeywords.getExcelSheet(workbook1, "ISA Bulk Certification")
	
	String studentEmail = testCaseContext.getTestCaseVariables().get("StudentEmail")
	int rowIndex = ExcelKeywords.getRowIndexByCellContent(sheet1, studentEmail, 5)
	
	if (ContractNumber == null) { ContractNumber = "Student is not created" }
	ExcelKeywords.setValueToCellByIndex(sheet1, rowIndex, 0, ContractNumber)
	ExcelKeywords.setValueToCellByIndex(sheet1, rowIndex, 1, PassFail + " - " + ErrorMsg)
	ExcelKeywords.saveWorkbook(accexcel, workbook1)
	}
}