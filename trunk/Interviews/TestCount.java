package com.practice.test.interview;

public class TestCount {

	public static void main(String[] args) {
		String[] strArr = {"5", "ab", "aab", "abb", "abab", "abaaaba"};
		int[] arr = minimalOperations(strArr);
		System.out.println(arr.toString());
	}
    // Complete the minimalOperations function below.
    static int[] minimalOperations(String[] words) {
    	int lenWords = words.length - 1;
    	//int lenWords = Integer.parseInt(words[0]);
        int[] indexArr = new int[lenWords];
        for(int i = 0; i < lenWords; i++){
            String word = words[i+1];
            char[] charArr = word.toCharArray();
            int lenWord = charArr.length;
            for(int j = 0; j < lenWord; j++){
                if(j+1 < lenWord && charArr[j] == charArr[j+1]){
                    indexArr[i] = 1;
                    System.out.println(word+ " : " + indexArr[i]);
                    break;
                }
                if(j+1 == lenWord) {
                	System.out.println(word+ " : " + indexArr[i]);
                    indexArr[i] = 0;
                }
            }
        }
    return indexArr;
    }


/*0
1
1
0
1*/

}
