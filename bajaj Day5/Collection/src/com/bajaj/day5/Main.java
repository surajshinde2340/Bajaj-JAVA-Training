package com.bajaj.day5;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String>  sp =  new ArrayList<>();
		sp.add("suraj");
		sp.add("AK");
		sp.add("aa");
		
		 
		Iterator<String> itr = sp.iterator(); 
		
		while( itr.hasNext() ) { 
		  System.out.println( itr.next() );
		}
		

	}

}
