package com.uefa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
		
		Calendario cal = new Calendario(groups);
		
		GregorianCalendar day = new GregorianCalendar();
		
		ArrayList<Partita> partite = cal.getPartite("A", day);
		
		System.out.println("Partite girone A");
		for (Partita p : partite) 
			System.out.println(p);
		
		day = (GregorianCalendar) day.clone();
		day.add(Calendar.DAY_OF_MONTH, 2);
		partite = cal.getPartite("B", day);
		
		System.out.println("Partite girone B");
		for (Partita p : partite) 
			System.out.println(p);

		day = (GregorianCalendar) day.clone();
		day.add(Calendar.DAY_OF_MONTH, 2);
		partite = cal.getPartite("C", day);
		
		System.out.println("Partite girone C");
		for (Partita p : partite) 
			System.out.println(p);
		
		day = (GregorianCalendar) day.clone();
		day.add(Calendar.DAY_OF_MONTH, 2);
		partite = cal.getPartite("D", day);
		
		System.out.println("Partite girone D");
		for (Partita p : partite) 
			System.out.println(p);
	}

}
