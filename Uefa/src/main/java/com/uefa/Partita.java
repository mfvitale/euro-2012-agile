package com.uefa;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Partita {

	private String casa,trasferta;
	private int golCasa,golTrasferta;
	private GregorianCalendar data;
	
	public Partita(String c,String t){
		casa=c;
		trasferta=t;
		golCasa=golTrasferta=0;
		data=new GregorianCalendar();
	}

	public int getGolCasa() {
		return golCasa;
	}

	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}

	public int getGolTrasferta() {
		return golTrasferta;
	}

	public void setGolTrasferta(int golTrasferta) {
		this.golTrasferta = golTrasferta;
	}
	
	public String getRisultato(){
		return casa +" - "+trasferta+" "+golCasa+"-"+golTrasferta;
	}
	
	public void setData(GregorianCalendar data){
		this.data=data;
	}
	
	public String toString(){
		int mese = data.get(Calendar.MONTH) + 1;
		return data.get(Calendar.DAY_OF_MONTH)+"/"+mese+"/"+data.get(Calendar.YEAR)+", "+casa +" - "+trasferta;
	}
	
}
