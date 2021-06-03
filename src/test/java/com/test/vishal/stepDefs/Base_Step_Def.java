package com.test.vishal.stepDefs;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.test.vishal.automation.TestSessionInitiator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Base_Step_Def {

	public static TestSessionInitiator test;
	public static String timeStamp = new SimpleDateFormat("yyMMddHHmmss").format(new Date());

	@Before
	public void initialSetUp() {
	}



	@After
	public void screenShotAndConsoleLog(Scenario result) {
		
	}


}
