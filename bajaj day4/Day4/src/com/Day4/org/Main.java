package com.Day4.org;
import static java.lang.Math.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//import static java.util.*;
import java.util.Map;

interface MyInterface{ 
	void sayHello();
}



public class Main {
	
	public static void main( String args[] ) {
		
		//static import 
		System.out.println(min( 4 , 11 ));
		System.out.println("ji ");
		
		
		
		// lambada expression 
		MyInterface obj = ()->System.out.println("hello from lambada ");
		obj.sayHello();
		
		
		
		List<Integer> list = Arrays.asList( 5 , 2 , 8 ,1);
		Collections.sort( list , ( a , b )-> a  - b );
		System.out.println(list);
		
		System.out.println(" ************************stream ******************************");
		
		List<Integer> l2 = Arrays.asList( 5 , 2 , 8 ,1);
		l2.stream().filter( n -> n %2 == 0 ).forEach( n -> System.out.println( n ));
		
		
		
		Map< Integer , String  > map = new HashMap<>();
		map.put( 1  , " java " );
		map.put( 2 , " c++ " );
		map.put( 3  , " python " );
		map.forEach( ( key , value ) -> System.out.println( key + " value is " +value )   );
		
		
		System.out.println("*******************************************************");
		List<String> l3 = Arrays.asList( "Suraj" , "yash" , "Aiket" , "Pranay" , "Suyash");
		l3.stream().filter( name -> name.startsWith("S")).forEach( System.out::println );
		
		List<Integer> l4 = Arrays.asList( 5 , 2 , 8 ,1);
		int sum = list.stream().reduce(0 , ( a , b )->a + b );
		System.out.println(sum);
		
		
		
	 
		
		
		
		
		
	}

}

