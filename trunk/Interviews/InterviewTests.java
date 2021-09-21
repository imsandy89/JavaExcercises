package com.practice.test.interview;

public class InterviewTests {

	public static void main(String[] args) {
		printNumberShifted();
	}

	/*this method appends first character to last of the string*/
	private static void printNumberShifted() {
		String str = "qwertyuiopasdf";
		for(int i = 0; i < str.length(); i++) {
			str = shiftCharatersInString(str);
			System.out.println((i+1)+": "+str);
		}
	}
	private static String shiftCharatersInString(String str) {
		return (str.substring(1) + str.charAt(0));
	}
}
