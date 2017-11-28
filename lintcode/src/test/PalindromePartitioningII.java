package test;

//分割回文串 II
public class PalindromePartitioningII {
	
	//时间复杂度n^3,空间复杂度n^2
	public static int minCut(String s) {
		char[] cs = s.toCharArray();
		int len = s.length();
		//计算子串是否回文
		boolean[][] palindrome = new boolean[len][len];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j + i < len; j++) {
				if(i == 0) {
					palindrome[j][j + i] = true;
				}else {
					palindrome[j][j + i] = cs[j] == cs[j + i];
					if(i > 2) {
						palindrome[j][j + i] &= palindrome[j + 1][j + i - 1];
					}
				}
			}
		}
		int[] dp = new int[len];
		for(int i = 0; i < len; i++) {
			if(!palindrome[0][i]) {
				dp[i] = Integer.MAX_VALUE;
				for(int j = 0; j < i; j++) {
					if(palindrome[j + 1][i]) {
						dp[i] = Math.min(dp[i], dp[j] + 1);
					}
				}
			}
		}
		return dp[len - 1];
	}
	
	//时间复杂度略高(时间复杂度n^3,空间复杂度n)
	public static int minCut1(String s) {
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
//		System.out.println(cs[0] == cs[2]);
//		System.out.println(isPalindrome(cs, 2, 3));
	}

}
