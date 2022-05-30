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
String body = 'New Comment added by Katalon'
int postId = 10

Posts post = new Posts(postId)

// POST call - Add a new Comment by adding details getting from variables above
resultSet = post.AddCommentByPostId(postId,body)
Map postResponse = jsonSlurper.parseText(resultSet.responseBodyContent)


//Verify Response Code is 201
WS.verifyResponseStatusCode(resultSet, 201)

/*
 * Successfully created a new record above
 * Now we need to see newly added comment on postId set above 
 * and verify our newly added data is available or not
*/
resultSet = post.getCommentsByPostId(postId)
ArrayList pResponse = jsonSlurper.parseText(resultSet.responseBodyContent)


//Verify the details added above are properly added in database or not. 
// We have to verify all comments first and see if our postId is available
int count = 0 
for(int i=0; i<pResponse.size();i++) {

	if(Integer.parseInt(pResponse[i].postId) == postId) {
		count = 1 ; 
		assert pResponse.body[i].toString() == body
	}
}

assert count == 1
	
