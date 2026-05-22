package com.leadwinner.api.tests;

import com.leadwinner.api.base.BaseTest;
import com.leadwinner.api.config.ConfigManager;
import com.leadwinner.api.constants.Endpoints;
import com.leadwinner.api.utils.JsonUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Test_UserLoginAPI extends BaseTest{
	
	static String token;
	
	
	@Test(priority =1)
	void signinWithValidDetails() {
//		String encodedUsername = Base64.getEncoder().encodeToString("superdmin".getBytes());
//	    String encodedPassword = Base64.getEncoder().encodeToString("superadmin".getBytes());
		
		HashMap<String, String> body = new HashMap<String, String>();
		body.put("username" , "7358190473");
		body.put("password", "123456");
		
		Response res =  given()
			.contentType(ContentType.JSON)
			.body(body)
		.when()
			.post(Endpoints.SignIN)
		.then()
		.extract().response();
		
		token = res.jsonPath().get("token");
		System.out.println(token);
	
	}
	
	
	@Test(priority =2)
	public void createProjectDetails() throws Exception {
		String filePath = "src/test/resources/data/ProjectCreation.json";

	    // read headers and body from same json file
	    Map<String, String> headers = JsonUtils.getHeaders(filePath);
	    String udAsnDTO             = JsonUtils.readProjectCreationDataBody(filePath);
		
	    given()
        .header("Authorization", "Bearer " + token)
        .headers(headers)   // ← pass all headers at once
        .multiPart("udAsnFile", "")
        .multiPart("udAsnDTO", udAsnDTO, "application/json")
    .when()
        .post("/web/udasn")
    .then()
        .log().all()
        .extract().response().prettyPrint();
	}
	
	@Ignore
	@Test
	public void data() throws Exception {
		String filePath = "src/test/resources/data/ProjectCreation.json";

		String udAsnDTO = JsonUtils.readProjectCreationDataBody(filePath);
		System.out.println("Body: " + udAsnDTO);
	}

}
