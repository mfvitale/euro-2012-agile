package com.uefa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Calendario {

	private HashMap<String, ArrayList<String>> groups;
	
	public Calendario (HashMap<String, ArrayList<String>> groups){
		this.groups=groups;
	}
	
	public ArrayList<Partita> getPartite(String girone,GregorianCalendar dataDiPartenza){
		ArrayList<String> listaGirone=groups.get(girone);
		ArrayList<String> squadreGirone=new ArrayList<String>();
		for(String s:listaGirone)
			squadreGirone.add(s.substring(2));
		ArrayList<Partita> partite=new ArrayList<Partita>();
		
		Partita p1=new Partita(squadreGirone.get(0),squadreGirone.get(1));
		p1.setData(dataDiPartenza);
		partite.add(p1);
	
		
		Partita p2=new Partita(squadreGirone.get(2),squadreGirone.get(3));
		dataDiPartenza = (GregorianCalendar) dataDiPartenza.clone();
		dataDiPartenza.add(Calendar.DAY_OF_MONTH, 1);
		p2.setData(dataDiPartenza);
		partite.add(p2);
		
		Partita p3=new Partita(squadreGirone.get(0),squadreGirone.get(2));
		dataDiPartenza = (GregorianCalendar) dataDiPartenza.clone();
		dataDiPartenza.add(Calendar.DAY_OF_MONTH, 7);
		p3.setData(dataDiPartenza);
		partite.add(p3);
		
		Partita p4=new Partita(squadreGirone.get(1),squadreGirone.get(3));
		dataDiPartenza = (GregorianCalendar) dataDiPartenza.clone();
		dataDiPartenza.add(Calendar.DAY_OF_MONTH, 1);
		p4.setData(dataDiPartenza);
		partite.add(p4);
		
		Partita p5=new Partita(squadreGirone.get(0),squadreGirone.get(3));
		dataDiPartenza = (GregorianCalendar) dataDiPartenza.clone();
		dataDiPartenza.add(Calendar.DAY_OF_MONTH, 7);
		p5.setData(dataDiPartenza);
		partite.add(p5);
		
		Partita p6=new Partita(squadreGirone.get(1),squadreGirone.get(2));
		p6.setData(dataDiPartenza);
		partite.add(p6);
		
		return partite;
	}
	
	
}
