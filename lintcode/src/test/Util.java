package test;

import java.util.List;

public class Util {
	
	public static void print(int[] a) {
		System.out.print("[");
		for(int i = 0; i < a.length; i++) {
			if(i != 0) {
				System.out.print(",");
			}
			System.out.print(a[i]);
		}
		System.out.println("]");
	}
	
	public static void print(int[][] matrix) {
		if(matrix.length == 0) {
			System.out.println("[]");
			return;
		}
		for(int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for(int j = 0; j < matrix[i].length; j++) {
				if(j > 0) {
					System.out.print(",");
				}
				System.out.print(matrix[i][j]);
			}
			System.out.println("]");
		}
	}

	public static <T> void print(T[][] matrix) {
		if(matrix.length == 0) {
			System.out.println("[]");
			return;
		}
		for(int i = 0; i < matrix.length; i++) {
			if(i > 0) {
				System.out.println();
			}
			System.out.print("[");
			for(int j = 0; j < matrix[i].length; j++) {
				if(j > 0) {
					System.out.print(",");
				}
				System.out.print(matrix[i][j]);
			}
			System.out.print("]");
		}
	}
	
	public static <T> void print(List<List<T>> matrix) {
		if(matrix.size() == 0) {
			System.out.println("[]");
			return;
		}
		for(int i = 0; i < matrix.size(); i++) {
			if(i > 0) {
				System.out.println();
			}
			System.out.print("[");
			for(int j = 0; j < matrix.get(i).size(); j++) {
				if(j > 0) {
					System.out.print(",");
				}
				System.out.print(matrix.get(i).get(j));
			}
			System.out.print("]");
		}
	}
}
