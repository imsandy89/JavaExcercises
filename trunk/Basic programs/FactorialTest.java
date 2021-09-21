package com.practice.prep.math;

import java.util.Scanner;


/**
 * @author Sandeep
 *Factorial : 1 + 2 = 3, 3 + 2 = 5, 5 + 3 = 8(1, 2, 3, 5, 8, 13)
 */

public class FactorialTest {
	public static void main(String[] args) {
		System.out.println("Number for factorial to calculate ???");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println("Factorial of number " + num + " is : " + getFactorial(num));
		System.out.println("Factorial of number " + num + " is : " + numFact);
	}

	private static int numFact = 1;

	private static int getFactorial(int num) {
		for (int factor = 1; factor <= num; factor++) {
			numFact = numFact * factor;
		}
		return numFact;
	}
}
