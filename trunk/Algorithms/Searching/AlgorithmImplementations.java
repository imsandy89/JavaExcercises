package com.practice.prep.excercise;

import java.util.Arrays;

public class AlgorithmImplementations {

	public static void main(String[] args) {
		implementBinarySearch();
	}

	private static void implementBinarySearch() {
		int[] arr = {5, 8, 12, 19, 21, 24, 28, 34, 37, 42, 48, 49, 52};
		int searchFor = 42;
		int foundAt  = implementBinarySearch(arr, searchFor);
		System.out.println("Found at "+foundAt);
		
		int start = 0;
		int end = arr.length - 1;
		foundAt  = implementBinarySearch(arr, searchFor, start, end);
		System.out.println("recursive Found at "+foundAt);
		
		//Arrays.binarySearch(arr, 21);
	}
	
	private static int implementBinarySearch(int[] dataArr, int searchFor) {
		int start = 0;
		int end = dataArr.length - 1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			if(searchFor < dataArr[mid]) {
				end = mid-1;
			}
			if(searchFor > dataArr[mid]) {
				start = mid+1;
			}
			if(searchFor == dataArr[mid]) {
				return mid;
			}
		} 
		return -1;
	}
	
	private static int implementBinarySearch(int[] dataArr, int searchFor, int start, int end) {
		int mid = (start + end)/2;
		if(end < start) return -1;
		if(searchFor < dataArr[mid]) {
			return implementBinarySearch(dataArr, searchFor, start, mid-1);
		}
		if(searchFor > dataArr[mid]) {
			return implementBinarySearch(dataArr, searchFor, mid+1, end);
		}
		if(searchFor == dataArr[mid]) {
			return mid;
		}
		return -1;
	}
}
