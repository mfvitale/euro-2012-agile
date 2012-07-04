package com.uefa;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;


public class FileMgmt 
{
	String filename;
	HashMap<String, ArrayList<String>> allTeams;
	public final static HashMap<Integer,String> groupLetter = new HashMap<Integer,String>();
	private HashMap<String, ArrayList<String>> groups;
	static
	{
			groupLetter.put(1, "A");
			groupLetter.put(2, "B");
			groupLetter.put(3, "C");
			groupLetter.put(4, "D");
	}
	 
	public FileMgmt(String filename) {
		super();
		this.filename = filename;
		
		try {
			loadTeams();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void loadTeams() throws IOException
	{
		allTeams = new HashMap<String, ArrayList<String>>();
		
		String line;
		String team;
		String rank;
		
		StringTokenizer token = null;
		BufferedReader reader =
				new BufferedReader(
					new FileReader(filename) );
	
			while( (line = reader.readLine()) != null ){
				token= new StringTokenizer(line," ");
				rank = token.nextToken();
				team = token.nextToken();
				
				if(allTeams.containsKey(rank))
					allTeams.get(rank).add(team);
				else
				{
					ArrayList<String> teams = new ArrayList<String>();
					
					teams.add(team);
					allTeams.put(rank, teams);
				}
				
			}
			reader.close();
			
	}
	
	public ArrayList<String> loadTeamList()
	{
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for (String rank : allTeams.keySet())
		{
			toReturn.addAll(allTeams.get(rank));
		}
		
		return toReturn;
	}
	/*public static void main(String[] args) {
		FileMgmt fm=new FileMgmt("squadre.txt");
		try {
			fm.loadTeams();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


	public void sort() 
	{
		Random randomGenerator = new Random();
		groups = new HashMap<String, ArrayList<String>>();
		
		HashMap<String, ArrayList<String>> copy = cloneMap();
		
		
		
		for(int i=4; i>0; i--)
		{
			ArrayList<String> teams = new ArrayList<String>();
			
			for (String rank : copy.keySet())
			{
				int rand = randomGenerator.nextInt(i);
				teams.add(rank+" "+(copy.get(rank).get(rand)));
				copy.get(rank).remove(rand);
			}
			
			groups.put(groupLetter.get(i), teams);
		}
		
		
	}


	private HashMap<String, ArrayList<String>> cloneMap() {
		
		HashMap<String, ArrayList<String>> copy = new HashMap<String, ArrayList<String>>();
		
		for (String rank : allTeams.keySet()) {
			
			copy.put(rank,new ArrayList<String>(allTeams.get(rank)));
		}
		return copy;
	}


	public HashMap<String, ArrayList<String>> getGroups() {
		return groups;
	}

}
