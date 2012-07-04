package com.uefa;

import java.util.ArrayList;
import java.util.HashMap;

public class Euro2012 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		FileMgmt filemgmt = new FileMgmt("D:\\Workspace eclipse\\Ericsson\\Uefa\\squadre.txt");
		
		System.out.println(filemgmt.loadTeamList().toString());
		
		filemgmt.sort();
		
		HashMap<String, ArrayList<String>> groups = filemgmt.getGroups();
		
		System.out.println(groups.toString());
		

	}

}
