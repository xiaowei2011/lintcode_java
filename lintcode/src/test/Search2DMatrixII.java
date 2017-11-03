package test;

//ËÑË÷¶þÎ¬¾ØÕó
public class Search2DMatrixII {
	
	public static int searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0, count = 0;
        while(i >= 0 && j < matrix[i].length) {
        	if(matrix[i][j] == target) {
        		count++;
        		i--;
        		j++;
        	}else if(matrix[i][j] < target) {
        		j++;
        	}else {
        		i--;
        	}
        }
        return count;
    }
	
	public static int searchMatrix1(int[][] matrix, int target) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[i].length; j++) {
        		if(matrix[i][j] == target) {
        			count++;
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7},{2, 4, 7, 8},{3, 5, 9, 10}};
		System.out.println(searchMatrix(matrix, 3));
	}

}
