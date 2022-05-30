import apiCalls.*;

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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import java.sql.Connection
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.math.RoundingMode;
import java.text.DecimalFormat;



def jsonSlurper = new JsonSlurper()
int postId = 3

Posts post = new Posts(postId)

// Get call - Get posts by post ID
resultSet = post.getCommentsByPostId(postId)
ArrayList postResponse = jsonSlurper.parseText(resultSet.responseBodyContent)

//Verify Response Code is 200
WS.verifyResponseStatusCode(resultSet, 200)
//Verify Response Body is not empty
assert !postResponse.equals([:])
  
