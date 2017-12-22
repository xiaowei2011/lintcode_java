package test;

/**
 * @autor sunweijie
 * @since 2017年12月18日 下午7:21:07
 */
// 119.编辑距离
public class EditDistance {
	
	
	/*
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public static int minDistance(String word1, String word2) {
    	if(word1.length() == 0 || word2.length() == 0) {
    		return Math.max(word1.length(), word2.length());
    	}
    	char[] c1 = word1.toCharArray();
    	char[] c2 = word2.toCharArray();
    	int[][] dp = new int[c1.length + 1][c2.length + 1];
    	for(int i = 1; i <= c1.length; i++) {
    		dp[i][0] = i;
    	}
    	for(int i = 1; i <= c2.length; i++) {
    		dp[0][i] = i;
    	}
    	for(int i = 1; i < dp.length; i++) {
    		for(int j = 1; j < dp[i].length; j++) {
    			if(c1[i - 1] == c2[j - 1]) {
    				dp[i][j] = dp[i - 1][j - 1];
    			}else {
    				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
    				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
    			}
    		}
    	}
        return dp[c1.length][c2.length];
    }

	public static void main(String[] args) {
		String word1 = "mart";
		word1 = "sea";
		String word2 = "karma";
		word2 = "ate";
		System.out.println(minDistance(word1, word2));
	}

}
