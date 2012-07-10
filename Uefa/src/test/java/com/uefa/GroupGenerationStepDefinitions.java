package com.uefa;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cucumber.runtime.PendingException;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class GroupGenerationStepDefinitions {
	boolean f=false;
	FileMgmt fm;
	public FileMgmt getFm() {
		return fm;
	}

	@Given("^sixteen team read from a file$")
	public void sixteen_team_read_from_a_file() {
		 fm = new FileMgmt("D:\\Workspace eclipse\\Ericsson\\Uefa\\squadre.txt");
		ArrayList<String> array = fm.loadTeamList();
		
		assertTrue("Load Ok",array!=null);
		
	}

	@When("^the button \"([^\"]*)\" is clicked$")
	public void the_button_is_clicked(String arg1) {
		fm.sort();
		assertTrue("pulsante cliccato",true);
	}

	@Then("^the system show four section of four team$")
	public void the_system_show_four_section_of_four_team() {
		
		if(fm.getGroups().keySet().size() != 4)
		  assertTrue("Squadra dello stesso rank nello stesso girone ",false);
		else
	      assertTrue("Squadra dello stesso rank nello stesso girone ",true);
	}
	
	
}
