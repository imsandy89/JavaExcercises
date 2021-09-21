package com.practice.test.collections;

import java.util.HashMap;
import java.util.Map;

import com.practice.test.pojo.PersonModel;

public class MapTest {

	public static void main(String[] args) {
		/*Map<String, Integer> tempMap = new HashMap<>();
		Map<String, Integer> tempMap_1 = new HashMap<>();
		Map<String, Integer> tempMap_2 = putValuesToTempMap(tempMap);
		Map<String, Integer> tempMap_3 = checkValuesToTempMap(tempMap);
		System.out.println("tempMap_2 " + tempMap_2);
		System.out.println("tempMap_3 " + tempMap_3);
		Map<String, Integer> poolMap = checkCheckStringPoolBehaviour(tempMap_1);
		System.out.println("PoolMap " + poolMap);*/
		
		checkDefaultBehaviour();
	}
	
	private static Map<String, Integer> putValuesToTempMap(Map<String, Integer> myMap){
		System.out.println("My map contents : "+myMap);
		myMap.put("a", 4);
		myMap.put("h", 1);
		myMap.put("f", 7);
		myMap.put("x", 3);
		
		return new HashMap();
	}
	
	private static Map<String, Integer> checkValuesToTempMap(Map<String, Integer> myMap){
		System.out.println("My map contents after : "+myMap);
		myMap.put("Sandeep", 8);
		myMap.put("Har", 3);
		myMap.put("John", 4);
		myMap.put("DellPC", 6);
		
		return myMap;
	}
	
	private static Map<String, Integer> checkCheckStringPoolBehaviour(Map<String, Integer> myMap){
		System.out.println("My map contents after : "+myMap);
		myMap.put("Sandeep", 8);
		myMap.put(new String("Sandeep"), 3);
		myMap.put(new String("Sandeep"), 4);
		myMap.put("null", 6);
		myMap.put(null, 2);
		
		System.out.println(null == "null");//false
		return myMap;//{null=2, Sandeep=4, null=6}
	}

	private static void checkDefaultBehaviour(){
		Map<PersonModel, String> map = new HashMap<>();
		map.put(new PersonModel("Sandeep", "Mumbai", 22, true), "Sandeep");
		map.put(new PersonModel("Ashish", "Lucknow", 29, true), "Ashish");
		map.put(new PersonModel("Sandeep", "Mumbai", 22, true), "Sandeep");
		/*new PersonModel("Shaloo", "Muradabad", 21, true),
		new PersonModel("Sandeep", "Allahabad", 22, true),
		new PersonModel("Sudeep", "Tarahathi", 20, true),
		new PersonModel("kuldeep", "Mungra", 20, true),
		new PersonModel("Babloo", "jaunpur", 29, true)*/
		System.out.println(map.size());
	}
}
