package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @autor sunweijie
 * @since 2018年1月4日 上午9:31:53
 */
//185.矩阵的之字形遍历
public class MatrixZigzagTraversal {
	
	//另一种写法
	public static int[] printZMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[] result = new int[row * col];
		result[0] = matrix[0][0];
		boolean orientation = false;
		int i = 1, j = 1, k = 1;
		while(true) {
			int x, y;
			if(j < col) {
				x = 0;
				y = j++;
			}else if(i < row) {
				x = i++;
				y = col - 1;
			}else {
				break;
			}
			List<Integer> list = new ArrayList<>();
			while(x < row && y >=0) {
				list.add(matrix[x++][y--]);
			}
			if(orientation) {
				Collections.reverse(list);
			}
			for(int v : list) {
				result[k++] = v;
			}
			orientation = !orientation;
		}
		return result;
	}
	
	public static int[] printZMatrix1(int[][] matrix) {
		boolean orientation = true;
		int row = matrix.length;
		int col = matrix[0].length;
		int i = 0, j = 0;
		int[] result = new int[row * col];
		for(int k = 0; k < result.length; k++) {
			result[k] = matrix[i][j];
			if(orientation) {
				i--;
				j++;
				if(j >= col) {
					i += 2;
					j--;
					orientation = false;
				}else if(i < 0) {
					i++;
					orientation = false;
				}
			}else {
				i++;
				j--;
				if(i >= row) {
					j += 2;
					i--;
					orientation = true;
				}else if(j < 0){
					j++;
					orientation = true;
				}
			}
		}
        return result;
    }

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2,  3,  4},
				{5, 6,  7,  8},
				{9,10, 11, 12}
		};
		Util.print(printZMatrix(matrix));
	}

}
