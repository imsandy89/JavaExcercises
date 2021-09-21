/**
 * 
 */
package com.practice.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sandeep
 *
 */
public class StringPool{//extends String

	public static void main(String[] args) {
		//testStringPool();
		//getPermutatedStrings("", "abcde");
		//reverseString("abcde");
		//testStr();
		//shiftString();
		//Long.parseLong("1502542");
		//otherTest();
		//findPermutation("", "sandeep");
	}
	
	
	
	private static void stringPermutation(String strInput) {
		findPermutation("", strInput);
	}
	
	private static void findPermutation(String perm, String input) {
		if(input.isEmpty()) {
			System.err.println(perm+input);
		}else {
			int i;
			for(i = 0; i < input.length(); i++) {
				findPermutation(perm + input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()));
			}
		}
	}
	
	private static void testStringPool() {
		String str = "Test String";
		String str_ = "Test String";
		System.out.println(str == str_);//false
		String str_1 = new String("Test String");
		String str_2 = new String("Test String");
		System.out.println(str == str_2);//false
		System.out.println(str.equals(str_2));//true
		System.out.println(str_1 == str_2);//false
		System.out.println(str_1.equals(str_2));//true
		str_1.intern();
		System.out.println(str == str_1);//false
		str_1 = str_1.intern();
		System.out.println(str == str_1);//true
		
		System.out.println(" Another ");
		String one = "On";
		String another = one.concat("ce");
		String two = "Once";
		String three = new String("Once");
		
		System.out.println(another == two);//false
		System.out.println(another.equals(two));//true
		
		System.out.println(another == three);//false
		System.out.println(another.equals(three));//true
	}
	
	static int count = 0;
	private static void getPermutatedStrings(String prefix, String input) {
		int len = input.length();
		if( len == 0 ) 
			System.out.println(++count+ ": " +prefix);
		else{
			// calling recursively
			for(int i = 0; i < len; i++)
				getPermutatedStrings(prefix + input.charAt( i ), input.substring(0, i) + input.substring(i+1, len));
		}
	}
	
	public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        System.out.println(str);
        return reverseString(str.substring(1)) + str.charAt(0);
    }
	
	public static void testStr() {
		String s = "abcde";
		char ch[] = s.toCharArray();
		for(int i = 0; i < s.length(); i++) {
			String newStr = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);//ch[i+1] + s.substring(i+2, s.length() )+ch[i];
			System.out.println(newStr);
		}
	}
	
	public static void shiftString() {
		String input = "Stackoverflow";
		for(int i = 0; i < input.length(); i++) {
			input = shiftToEnd(input);
			System.out.println(input);
		}
	}
	
	public static String shiftToEnd(String str) {
		return str.substring(1) + str.charAt(0);
	}
	
	/*public static void main (String[] args) throws java.lang.Exception {
	    String input = "Stackoverflow";
	    for(int i = 0; i < s.length(); i++){
	        input = shift(input);
	        System.out.println(input);
	    }
	}*/

	/*public static String shift(String s) {
	    return s.charAt(s.length()-1)+s.substring(0, s.length()-1);
	}
	*/
	
	
	 /*URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
	 try (InputStream is = url.openStream();
	       JsonParser parser = Json.createParser(is)) {
	      while (parser.hasNext()) {
	          Event e = parser.next();
	         if (e == Event.KEY_NAME) {
	              switch (parser.getString()) {
	                  case "name":
	                      parser.next();
	                    System.out.print(parser.getString());
	                    System.out.print(": ");
	                    break;
	                case "message":
	                    parser.next();
	                    System.out.println(parser.getString());
	                    System.out.println("---------");
	                    break;
	             }
	         }
	     }
	 }*/
}


/*public static void main (String[] args) throws java.lang.Exception {
    String input = "Stackoverflow";
    for(int i = 0; i < s.length(); i++){
        input = shift(input);
        System.out.println(input);
    }
}*/
