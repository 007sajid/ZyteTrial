package apiCalls
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
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder as JsonBuilder
import java.sql.ResultSet
import java.sql.ResultSetMetaData

import internal.GlobalVariable

public class Posts {

	private int id;

	private static JsonBuilder jbuilder = new JsonBuilder()

	private static jsonSlurper = new JsonSlurper()
	private int postId;
	private String author;
	private String title;
	private String body;

	Posts(int postId) {
		this.postId = postId
	}
	Posts(String title, String author){
		this.title = title
		this.author = author
	}

	public int getPostId() {
		return postId
	}
	public String getPostAuthor() {
		return author
	}
	public String getPostTitle() {
		return title
	}
	public String getCommentBody() {
		return body
	}


	public void setCommentBody(String title) {
		this.body = body
	}

	public void setPostTitle(String title) {
		this.title = title
	}
	public void setPostAuthor(String author) {
		this.author = author
	}



	public void setId(int postId) {
		this.postId = postId
	}



	public Object getPostById(int postId) {

		return WS.sendRequestAndVerify(findTestObject('Object Repository/Get Post by Post ID', [('postId') : postId] ))
	}

	public Object getCommentsByPostId(int postId) {

		return WS.sendRequestAndVerify(findTestObject('Object Repository/Comments by Post', [('postId') : postId] ))
	}
	public Object getProfile() {
		
				return WS.sendRequestAndVerify(findTestObject('Object Repository/Get Profile'))
			}

			public Object CreateProfile(String name) {
				
						return WS.sendRequestAndVerify(findTestObject('Object Repository/Create Profile', [('name') : name] ))
					}
			

	public Object AddPost(String title, String author) {

		return WS.sendRequestAndVerify(findTestObject('Object Repository/Add new Post', [('title') : title, ('author'): author] ))
	}
	public Object AddCommentByPostId(int postId, String body) {

		return WS.sendRequestAndVerify(findTestObject('Object Repository/Add Comment by Post ID', [('body') : body , ('postId'): postId]))
	}






	public static Map getQueryResultMap(ResultSet resultSet) {
		Map resultMap = new HashMap()
		ResultSetMetaData rsmd = resultSet.getMetaData()

		while(resultSet.next()) {
			for(int k = 1; k < rsmd.getColumnCount()+1; k++) {
				switch(rsmd.getColumnClassName(k)) {
					case "java.math.BigDecimal" :
						resultMap.put(rsmd.getColumnName(k), resultSet.getBigDecimal(k))
					//println(rsmd.getColumnName(k) + ": " + resultSet.getString(k) + ", " + rsmd.getColumnClassName(k))
						break
					case "java.lang.Integer" :
						resultMap.put(rsmd.getColumnName(k), resultSet.getInt(k))
					//println(rsmd.getColumnName(k) + ": " + resultSet.getString(k) + ", " + rsmd.getColumnClassName(k))
						break
					case "java.lang.Short" :
						resultMap.put(rsmd.getColumnName(k), resultSet.getShort(k))
					//println(rsmd.getColumnName(k) + ": " + resultSet.getString(k) + ", " + rsmd.getColumnClassName(k))
						break
					default :
						resultMap.put(rsmd.getColumnName(k), resultSet.getString(k))
					//println(rsmd.getColumnName(k) + ": " + resultSet.getString(k) + ", " + rsmd.getColumnClassName(k))
				}
			}
			//println()
		}
		return resultMap
	}
}




