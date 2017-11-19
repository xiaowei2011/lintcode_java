package test;

import java.util.Arrays;

public class SortIntegersII {
	
	//希尔排序
	public static void sortIntegers2(int[] A) {
        for(int i = A.length / 2; i >= 1; i /= 2) {
        	for(int j = i; j < A.length; j++) {
        		int temp = A[j];
        		int k = j;
        		while(k - i >= 0 && A[k - i] > temp) {
        			A[k] = A[k - i];
        			k -= i;
        		}
        		A[k] = temp;
        	}
        }
    }

	public static void main(String[] args) {
		int[] A = {3, 2, 1, 4, 5};
		sortIntegers2(A);
		Arrays.stream(A).forEach(n->System.out.print(n + " "));
	}
	
}
