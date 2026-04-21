package com.bajaj.day5;
import java.util.*;
public class MainProject {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ArrayList<Project> listOfProjects = new ArrayList<>();
		ArrayList<String> member = new ArrayList<>();
		member.add( "Anand");
		member.add( "Pratick");
		member.add( "Esha");
		member.add( "yash");
		
		listOfProjects.add( new Project( " AI Project " , "Ajit Patil " , member , new Date()  ) );
		
		Iterator itr=listOfProjects.iterator();  

		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
		
		

	}

}
