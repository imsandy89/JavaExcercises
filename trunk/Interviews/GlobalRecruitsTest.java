package com.practice.test.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class GlobalRecruitsTest {

	public static void main(String[] args) throws IOException {
		// String inputData = "2 6 \n8 13 \n4 8 \n40 49";
		// String s = "this is a \nmultiline\rstring\r\nusing different newline styles";

		// System.out.println(lineByLineReadUsingBufferedReader(inputData));
		// System.out.println(lineByLineReadUsingScanner(inputData));

		String inputData = "timbernersleeinventedtheworldwideweb\n2\ninvented\nthe";
		/*
		 * String thisLine = null; BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); while ((thisLine = br.readLine()) != null) {
		 * inputData += thisLine + "\n"; }
		 */
		// Output the solution to the console
		System.out.println(tumharaSolution(inputData));
	}

	/**
	 * This method takes number ranges in line by line manner and returns the all
	 * odds from the string/ranges provided. input eg: 1 10 \n5 19 \n2 2 \n40 49
	 * 
	 **/
	private static String lineByLineReadUsingBufferedReader(String inputData) {
		System.out.println("Using BufferedReader");
		StringBuilder buildRes = new StringBuilder();
		new BufferedReader(new StringReader(inputData)).lines().forEach((line) -> {
			String[] rangeStrArr = line.split(" ");
			// System.out.println("" + line);
			if (rangeStrArr.length == 2) {
				int rangeStart = Integer.parseInt(rangeStrArr[0]);
				int rangeEnd = Integer.parseInt(rangeStrArr[1]);
				// System.out.println("Range : " + rangeStart + " - " + rangeEnd);
				for (int oddMe = rangeStart; oddMe <= rangeEnd; oddMe++) {
					if (oddMe % 2 != 0) {
						buildRes.append(oddMe).append(" ");
					}
				}

				if (buildRes.toString().length() == 0)
					buildRes.append("none");
			}
			buildRes.append("\n");
		});

		return buildRes.toString();
	}

	/**
	 * This method takes number ranges in line by line manner and returns the all
	 * odds from the string/ranges provided. input eg: 1 10 \n5 19 \n2 2 \n40 49
	 * 
	 **/
	private static String lineByLineReadUsingScanner(String inputData) {
		System.out.println("Using Scanner");
		StringBuilder buildRes = new StringBuilder();
		try (Scanner scanner = new Scanner(inputData)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] rangeStrArr = line.split(" ");
				// System.out.println("" + line);
				if (rangeStrArr.length == 2) {
					int rangeStart = Integer.parseInt(rangeStrArr[0]);
					int rangeEnd = Integer.parseInt(rangeStrArr[1]);
					// System.out.println("Range : " + rangeStart + " - " + rangeEnd);
					for (int oddMe = rangeStart; oddMe <= rangeEnd; oddMe++) {
						if (oddMe % 2 != 0) {
							// System.out.println(oddMe + " ");
							buildRes.append(oddMe).append(" ");
						}
					}

					if (buildRes.toString().length() == 0)
						buildRes.append("none");
				}
				buildRes.append("\n");
			}
		}

		return buildRes.toString();
	}

	/**
	 * in: timbernersleeinventedtheworldwideweb\n2\ninvented\nthe Means there are
	 * four lines, first line is with actual content, 2nd line is to decide how many
	 * words need to be lower case remaining lines[ count as 2nd line] are the words
	 * to keep in small case. 
	 * out : TIMBERNERSLEE invented the WORLDWIDEWEB
	 */
	public static String tumharaSolution(String inputData) {
		StringBuilder buildRes = new StringBuilder();
		String[] strDic = inputData.trim().split("\n");
		String temp = strDic[0].toUpperCase();
		int tuples = 0;
		if (strDic[1].length() == 1)
			tuples = Integer.valueOf(strDic[1]);
		int skip = 2;
		for (int index = 2; index < tuples + skip; index++) {
			String[] x = temp.split(strDic[index].toUpperCase());
			if (index > tuples) {
				buildRes.append(strDic[index]).append(" ").append(x[x.length - 1]);
			} else {
				buildRes.append(x[0]).append(" ").append(strDic[index]).append(" ");
				temp = temp.substring(buildRes.length() - 2);
			}
		}

		return buildRes.toString();
	}
}
