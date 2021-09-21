package com.practice.test.interview;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AptiTest {

	public static void main(String[] args) {
		//nullString(null);
		//checkType();// float or double
		//testMethods(5, 0);
		//typeTest();
		//testCollectionRef();
		//getCountOfWordsFromFile();
		//firstNonRecurring();
		int[] i = {14, 222};
		//testBinaryCount(i);
		testBinaryOnesCount(i);
	}
	
	public static void testBinaryCount(int[] testCase){
		int len = testCase.length;
		if(len >= 1 && len <= 100){
			int decimal, h;
			for(h = 0; h < len; h++){
				decimal = testCase[h];
				//if(decimal >= 1 && decimal < 103){
					int count = 0;
					while(decimal != 0){
						decimal = (decimal & (decimal << 1));
						count++;
					}
					System.out.println(count);
				//}
			}
		}
	}
	
	public static void testBinaryOnesCount(int[] testCase){
		int len = testCase.length;
		if(len >= 1 && len <= 100){
			int decimal, h;
			for(h = 0; h < len; h++){
				decimal = testCase[h];
				String binaryEq = Integer.toBinaryString(decimal);
				String[] strArr = binaryEq.split("0");
				int start = 0, end = strArr.length;
				int count = 0;
				while(start < end) {
					if(strArr[start].length() > count ) {
						count = strArr[start].length();
						start++;
					}
				}
				System.out.println(count);
			}
		}
	}
	
	private static void nullString(String str) {//(Object str)
		System.out.println(str);//null
		
		System.out.println(str + null);//nullnull
		
		if(str instanceof String) 
			System.out.println("Its a string");
		if(str instanceof Object)
			System.out.println("Its an object");
		else System.out.println("Its something else");//something else
		
		if( str == null )
			System.out.println("String is null");//will be printed
		if( str.length() == 0 )//nullpointer
			System.out.println("String Has no length");
		else System.out.println("String Has length");
		
	}
	
	private static void checkType() {
		int a = 5;
		float b = 4;
		double c = 6;
		long d = 8;
		System.out.println((a+d)*(b+c) );//double or float
	}
	
	private static void testMethods(int a, int y) {
		try {
			//a/y error if not assigned to x
			int x = a/y;
		}catch(Exception ex) {
			System.out.println("Exception "+ex.getClass());
		}
		//testMethods(10, 0);
	}
	
	private static void typeTest() {
		Integer integer = new Integer(15);
		float f = integer.floatValue();
		double d = integer.doubleValue();
		long l = integer.longValue();
		int i = integer.intValue();
		System.out.println("int: "+ i +", float: "+f+", double: "+d+", long: "+l);
	}
	private static void testCollectionRef() {
		Set<String> strSet = new HashSet<>();
		strSet.add("set 123");;
		
		List<String> list = new ArrayList<>();
		list.add("list 123");
		
		changeCollection(strSet, list);

		strSet.add("set 456");
		list.add("list 456");
	
		System.out.println(strSet);//[set 123, set changed, set 456] - keeps track from all the references
		System.out.println(list);//[list 123, list changing, list 456] - keeps track from all the references
	}
	
	private static void changeCollection(Set<String> set, List<String> l){//returning List<String>
		l.add("list changed");
		set.add("set changed");
		//return l;
	}
	
	private static void getCountOfWordsFromFile() {
		//System.out.println(getClass());
		String filepath = "C:\\Users\\Sandeep\\Desktop\\test file java count.txt";
		
		/*try(BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
			List<?> stringList = new ArrayList<>();
			String line = "";
			while(br.readLine() != null) {
				
			}
		} catch (IOException e) {
		}*/
		
		try {
			Map<String, Long> map = Files.lines(new File(filepath).toPath()).
			filter(line -> line.length() > 0).
			flatMap(line -> Stream.of(line.split(" "))).
			collect(Collectors.groupingBy(words -> words, Collectors.counting()));
			
			//Map<String, Long> sortedmap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
			Map<String, Long> sortedmap = map.entrySet().stream().sorted((dataOne, datatwo) -> dataOne.getValue().compareTo(datatwo.getValue())).
			collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));
			System.out.println(sortedmap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void firstNonRecurring() {
		String str = "test string";
		char[] ch = str.toCharArray();
		int len = ch.length;
		for(int i = 0; i < len; i++) {
			boolean flag = false;
			for(int j = 1; j < len; j++) {
				if(ch[j] == ch[i]) { flag = true; }
			}
			
			if(!flag) {
				System.out.println(ch[i]);
				break;
			}
		}
	}

}
