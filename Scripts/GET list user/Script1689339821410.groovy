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

response = WS.sendRequestAndVerify(findTestObject('GET/GET list user'))

WS.verifyResponseStatusCode(response, 200)

String jsonSchema = '\n{\n  "$id": "https://example.com/person.schema.json",\n  "$schema": "https://json-schema.org/draft/2020-12/schema",\n  "title": "Person",\n  "type": "object",\n  "properties": {\n    "firstName": {\n      "type": "string",\n      "description": "The person\'s first name."\n    },\n    "lastName": {\n      "type": "string",\n      "description": "The person\'s last name."\n    },\n    "age": {\n      "description": "Age in years which must be equal to or greater than zero.",\n      "type": "integer",\n      "minimum": 0\n    }\n  }\n}\n'

boolean successful = WS.validateJsonAgainstSchema(response, jsonSchema)

