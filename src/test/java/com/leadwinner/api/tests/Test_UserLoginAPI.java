package com.leadwinner.api.tests;

import com.leadwinner.api.base.BaseTest;
import com.leadwinner.api.constants.Endpoints;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Test_UserLoginAPI extends BaseTest{
	
	@Test
	void signinWithValidDetails() {
//		String encodedUsername = Base64.getEncoder().encodeToString("superdmin".getBytes());
//	    String encodedPassword = Base64.getEncoder().encodeToString("superadmin".getBytes());
		
		HashMap<String, String> body = new HashMap<String, String>();
		body.put("username" , "superadmin");
		body.put("password", "123456");
		
		given()
			.contentType(ContentType.JSON)
			.body(body)
		.when()
			.post(Endpoints.SignIN)
		.then()
			.log().all();
		
	}

}
