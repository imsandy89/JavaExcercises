package com.practice.prep.algorithms;

import java.util.Arrays;

public class SearchingAlgorithms {

	public static void main(String[] args) {
		int[] intArray = { 40, 51, 22, 45, 1, 4, 90, 23, 17, 55 };
		int dataToSearch = 55;
		System.out.println(linearSearch(intArray, dataToSearch));
		System.out.println( binarySearchUsingWhile(intArray, dataToSearch) );
		System.out.println( recursiveBinarySearch(intArray, 0, intArray.length - 1, dataToSearch ));
	}

	private static int linearSearch(int[] dataArray, int dataToSearch) {
		System.out.println("Linearly Searching " +dataToSearch+ " from array : "+dataArray);
		int index;
		for (index = 0; index < dataArray.length; index++) {
			if (dataArray[index] == dataToSearch) {
				return index;
			}
		}
		return -1;
	}

	private static int binarySearchUsingWhile(int[] dataArray, int dataToSearch) {
		System.out.println("Binary Searching by while loop of " +dataToSearch+ " from array : "+dataArray);
		Arrays.sort(dataArray);
		int startIndex = 0, endIndex = dataArray.length - 1;
		while (endIndex > startIndex) {
			int midIndex = (startIndex + endIndex) / 2;// (dataArray.length/2) + 1;
			if (dataToSearch == dataArray[midIndex]) {
				return midIndex;
			} else if (dataToSearch > dataArray[midIndex]) {
				startIndex = midIndex + 1;
			} else if (dataToSearch < dataArray[midIndex]) {
				endIndex = midIndex - 1;
			}
		}

		return -1;
	}

	private static int recursiveBinarySearch(int[] dataArray, int start, int end, int dataToSearch) {
		//Stream.of(intArr).forEach(System.out::print)
		System.out.println("Recursive approach of binary Searching of " +dataToSearch+ " from array : "+dataArray);
		Arrays.sort(dataArray);
		int mid = (start + end)/2;
		if(end < start) return -1;
		if(dataToSearch == dataArray[mid]) {
			return mid;
		} else if(dataToSearch < dataArray[mid]) {
			recursiveBinarySearch(dataArray, start, mid - 1, dataToSearch);
		} else if(dataToSearch > dataArray[mid]) {
			recursiveBinarySearch(dataArray, mid + 1, end, dataToSearch);
		}
		
		return -1;
	}

}
