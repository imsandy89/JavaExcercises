package com.practice.test.collections;


public class ArrayOperation {

	public static void main(String[] args) {
		int[] arr = {4, 6, 1, 7, 8, 3, 9, 2};
		sortArrayOddEven(arr);
	}
	
	public static void sortArrayOddEven(int[] arr){
		if(arr != null && arr.length > 0) {
			int startI = 0; int endI = arr.length - 1;
			int temp;
			while(startI < endI) {
				if(arr[startI] % 2 == 0 && arr[endI] %2 == 0 ) {
					--endI;
				}
				else if(arr[startI] % 2 != 0 && arr[endI] %2 == 0 ) {
					++startI; --endI;
				}
				else if(arr[startI] % 2 != 0 && arr[endI] %2 != 0 ) {
					++startI;
				} else if(arr[startI] % 2 == 0 && arr[endI] %2 != 0) {
					temp = arr[startI];
					arr[startI] =  arr[endI];
					arr[endI] = temp;
					temp = 0;
					++startI;
				}
			}
		}
		
		System.out.println( arr);
	}

}
