package com.leadwinner.api.base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {

	
	//https://gpmsuate.com/lms_cbobe/api/auth/signin
	//
	//https://squareupuate.com/tamilnadube/api/auth/signin
	
	/*
	 * Base URI : */
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://squareupuate.com";
		RestAssured.basePath = "/tamilnadube/";//api/auth/signin"
		
	}
}
