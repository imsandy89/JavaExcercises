package com.practice.test.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueList {

	public static void main(String[] args) {
		randomList();
	}
	
	private static void randomList() {
		List<String> list = new ArrayList<String>();
		list.add("ethen");
		list.add("methan");
		list.add("propane");
		list.add("butane");
		list.add("pentane");
		list.add("hexane");
		list.add("butane");
		list.add("methan");
		System.out.println("List with duplicates : "+list.size());//8
		System.out.println("Original list : "+list);
		
		System.out.println("unifying list");
		Set<String> uniqListSet = new HashSet<>(list);
		System.out.println("unique item size : "+uniqListSet.size());//6
		uniqListSet.add("Septane");
		System.out.println("Unique list : "+uniqListSet);
		
		HashSet<Object> set_1 = new HashSet<>();
		set_1.add(list);// creates set of lists, so size one
		System.out.println("Other List: " + set_1);
		System.out.println("Size :" +set_1.size());//1
		
		HashSet<Object> set_2 = new HashSet<>();
		set_2.addAll(list);//adds every item to set individually, so size is == list size
		System.out.println("Other List: " + set_2);
		System.out.println("Size : " +set_2.size());//6
		
		//reversing the list
		Collections.sort(list, Collections.reverseOrder());// will start from back == descending
		System.out.println("Sorted list : "+list);
	}
}
