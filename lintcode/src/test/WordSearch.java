package test;

/**
 * @autor sunweijie
 * @since 2017年12月24日 上午11:34:40
 */
//123.单词搜索
public class WordSearch {
	
	/*
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public static boolean exist(char[][] board, String word) {
    	boolean[][] visited = new boolean[board.length][board[0].length];
    	char[] a = word.toCharArray();
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[i].length; j++) {
    			if(board[i][j] == a[0]) {
    				if(backup(board, visited, a, i, j, 0)) {
    					return true;	
    				}
    			}
    		}
    	}
    	return false;
    }
    
    static boolean backup(char[][] board, boolean[][] visited, char[] word, int i, int j, int k) {
    	if(k == word.length) {
    		return true;
    	}
    	if(i >= 0 && i < board.length && j >= 0 && j < board[i].length && !visited[i][j] && board[i][j] == word[k]) {	
    		int[][] a = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    		visited[i][j] = true;
    		for(int m = 0; m < 4; m++) {
    			if(backup(board, visited, word, i + a[m][0], j + a[m][1], k + 1)) {
    				return true;
    			}
    		}
    		visited[i][j] = false;
    	}
    	return false;
    }

	public static void main(String[] args) {
		char[][] board = new char[][] {
			"ABCE".toCharArray(),
			"SFCS".toCharArray(),
			"ADEE".toCharArray()
		};
		String s = "ABCCED";
		System.out.println(exist(board, s));
		s = "SEE";
		System.out.println(exist(board, s));
		s = "ABCB";
		System.out.println(exist(board, s));
	}

}
