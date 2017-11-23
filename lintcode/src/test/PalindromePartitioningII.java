package test;

//分割回文串 II
public class PalindromePartitioningII {
	
	public static int minCut(String s) {
		char[] cs = s.toCharArray();
		int[] dp = new int[cs.length + 1];
		for(int i = 1; i <= cs.length; i++) {
			dp[i] = i;
			for(int j = 1; j <= i; j++) {
				if(isPalindrome(cs, j - 1, i) && dp[j - 1] + 1 < dp[i]) {
					dp[i] = dp[j - 1] + 1;
				}
			}
		}
        return dp[cs.length] - 1;
    }
	
	static boolean isPalindrome(char[] cs, int start, int end) {
		for(; start < end; start++, end--) {
			if(cs[start] != cs[end - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		char[] cs = "aab".toCharArray();
		System.out.println(minCut("aab"));
//		System.out.println(isPalindrome(cs, 2, 3));
	}

}
