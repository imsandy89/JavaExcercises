package com.practice.prep.algorithms;


/**
 * Bubble Sort: O(n^2), 
 * 
 * */
public class SortingAlgorithms {

	public static void main(String[] args) {

	}

	private static void selectionSortAlgorithm() {
		
	}
	
	/** https://www.programiz.com/dsa/bubble-sort
	 * bubbleSort(array)
	 * 	for i <- 1 to indexOfLastUnsortedElement-1
	 * 		if leftElement > rightElement
	 * 			swap leftElement and rightElement
	 * 	end bubbleSort
	 * 
	 * */
	private static void recursiveBubbleSortAlgorithm(int[] arrayData) {
		int len = arrayData.length;
		if(len > 0) {
			for (int i = 0; i < len; i++) {
				if(arrayData[i] > arrayData[i + 1]) {
					int temp = arrayData[i + 1];
					arrayData[i + 1] = arrayData[i];
					arrayData[i] = temp;
				}
			}
		}
	}
	
	private static void bubbleSortAlgorithm() {
		//https://cs-fundamentals.com/data-structures/bubble-sort-in-java
	}
	private static void insertionSortAlgorithm() {}
}
