package com.uefa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class CalendarGenerationStepDefinitions {
	
	private GroupGenerationStepDefinitions gp;
	private ArrayList<Partita> matchList;
	
	@Given("^Scenario: Groups$")
	public void Scenario_Groups() {
	   
		gp = new GroupGenerationStepDefinitions();
		
		gp.sixteen_team_read_from_a_file();
		gp.the_button_is_clicked("Genera");
		gp.the_system_show_four_section_of_four_team();
		
		
		
	}

	@When("^the Genera Calendario is clicked$")
	public void the_Genera_Calendario_is_clicked() {
	    // Express the Regexp above with the code you wish you had
		matchList = gp.getFm().getCalendario();
		assertTrue("Generating calendar ok",true);
	}
	
	@Then("^the system show four section of six match$")
	public void the_system_show_four_section_of_six_match() {
	    // Express the Regexp above with the code you wish you had
		if(matchList != null && matchList.size() == 24)
			assertTrue("Calendar ok",true);
		else
			assertTrue("Calendar fail",false);
	}

}
