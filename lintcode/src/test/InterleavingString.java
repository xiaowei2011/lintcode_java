package test;

//½»²æ×Ö·û´®
public class InterleavingString {
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        if(c1.length + c2.length != c3.length){
            return false;
        }
        if("".equals(s1)){
            return s2.equals(s3);
        }
        if("".equals(s2)){
            return s1.equals(s3);
        }
        boolean[][] dp = new boolean[c1.length + 1][c2.length + 1];
        dp[0][0] = true;
        for(int i = 1; i <= c2.length; i++) {
        	dp[0][i] = dp[0][i-1] && c3[i - 1] == c2[i - 1];
        }
        for(int i = 1; i <= c1.length; i++) {
        	dp[i][0] = dp[i - 1][0] && c3[i - 1] == c1[i - 1];
        }
        for(int i = 1; i <= c1.length; i++) {
        	for(int j = 1; j <= c2.length; j++) {
        		if(c3[i + j - 1] == c1[i - 1]) {
        			dp[i][j] |= dp[i -1][j];
        		}
        		if(c3[i + j - 1] == c2[j - 1]) {
        			dp[i][j] |= dp[i][j - 1];
        		}
        	}
        }
        return dp[c1.length][c2.length];
    }

	public static void main(String[] args) {
		System.out.println(isInterleave("aba","a","aaba"));
	}
}
