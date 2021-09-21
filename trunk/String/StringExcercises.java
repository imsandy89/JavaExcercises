package com.practice.prep.excercise;

public class StringExcercises {

	public static void main(String[] args) {
		//testStringPool();
		testStringReverse();
	}
	private static void testStringPool() {
		String str = "Sandeep";
		String strObj = new String("Sandeep");
		System.out.println(str.equals(strObj));//true - Content or value is same
		System.out.println(str == strObj);//false -- pool object not found for new String
		
		String strObj_1 = new String("Sandeep");
		//System.out.println(strObj_1.equals(strObj));//true
		System.out.println(strObj_1 == strObj);//false - both are not in pool
		
		String str_1 = "Sandeep";
		System.out.println(str.equals(str_1));//true
		System.out.println(str == str_1);//true - both in pool
		
		String str_2 = str_1;
		System.out.println(str_2 == str_1);//true - both in pool
		
		String objStr_1 = strObj;
		System.out.println(str == objStr_1);//false - still objStr_1 not created in pool, just refering heap
		System.out.println(strObj == objStr_1);//true
		
		objStr_1 = objStr_1.intern();
		System.out.println("interned strObj_1 == strObj "+( str == objStr_1));//true - now this created in pool also
		
		String st = "San";
		String st_1 = st + "deep";
		System.out.println(str == st_1);//false - At runtime, compiler dont know the value of st, so it creates a new entry in pool
		System.out.println(str.equals(st_1));//true
		System.out.println("###########");
		
		String con_1 = "San";
		String con_2 = "deep";
		String conated = con_1+con_2;
		System.out.println(str == conated);//false - at compile time don't know values of con_1 and con_2 so in Pool new object different from
		System.out.println(str.equals(conated));//true
		
		String concStr = "San" + "deep";//at compile time, both string is known so in Pool same object as in variable hello
		System.out.println(str == concStr);//true
		System.out.println(str.equals(concStr));//true
	}
	
	private static void testStringReverse() {
		String testString = "Java is a very beautiful programming language";
		
		System.out.println(" ######## Reverse String Using recursion ########");
		String reversed = stringReverseByRecursion(testString);
		System.out.println("Output: "+reversed);
		
		System.out.println(" ######## Reverse String Using SBuffer ########");
		System.out.println("Output: "+stringReverseBySBuffer(testString));
		
		System.out.println(" ######## Reverse String word wise, words only revered ########");
		System.out.println("Output: "+stringReverseByWords(testString));
		
		System.out.println(" ######## Reverse String Character wise ########");
		System.out.println("Output: "+stringReverseByCharsArr(testString));
		
		System.out.println(" ######## Reverse String Using loop ########");
		System.out.println("Output: "+stringReverseByLoop(testString));
	}
	
	//" ######## Reverse String Using recursion ########"
	private static String stringReverseByRecursion(String testStr) {
		if( null == testStr || testStr.length() <= 1)
			return testStr;
		return stringReverseByRecursion(testStr.substring(1)) + testStr.charAt(0);
	}
	
	//" ######## Reverse String Using SBuffer ########"
	private static String stringReverseBySBuffer(String testStr) {
		StringBuffer sb = new StringBuffer(testStr);
		return sb.reverse().toString();
	}
	
	//" ######## Reverse String word wise, words only revered ########"
	private static String stringReverseByWords(String testStr) {
		String[] strArray = testStr.split(" ");
		String revStr = "";
		for(String word : strArray) {
			revStr = word + " " + revStr;
		}
		
		return revStr;//egaugnal gnimmargorp lufituaeb yrev a si avaJ
	}
	
	//" ######## Reverse String CharacterArray wise ########"
	private static String stringReverseByCharsArr(String testStr) {
		char[] chArr = testStr.toCharArray();
		int startindex = 0, endIndex = chArr.length-1;
		//for(Character chr : chArr) {
		while(endIndex > startindex) {
			char chStart = chArr[startindex];
			chArr[startindex] = chArr[endIndex];
			chArr[endIndex] = chStart;
			startindex++;
			endIndex--;
		}
		return new String(chArr);//egaugnal gnimmargorp lufituaeb yrev a si avaJ
	}
	
	//" ######## Reverse String Using loop ########"
	private static String stringReverseByLoop(String testStr) {
		StringBuilder builder = new StringBuilder();
		String[] strArr = testStr.split(" ");
		for(int si = 0; si < strArr.length; ++si) {//avaJ si a yrev lufituaeb gnimmargorp egaugnal
		//for(int si = strArr.length-1; si >= 0; si--) {//egaugnal gnimmargorp lufituaeb yrev a si avaJ
			char[] charArr = strArr[si].toCharArray();
			for(int ci = charArr.length-1; ci >= 0; ci--) {
				builder.append(charArr[ci]);
			}
			if(si != strArr.length - 1) builder.append(" ");
			//if(si != 0) builder.append(" ");
		}
		
		return builder.toString();
	}

}
