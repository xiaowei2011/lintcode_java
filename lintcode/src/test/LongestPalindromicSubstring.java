package test;

//200. 最长回文子串
public class LongestPalindromicSubstring {

	// 中心扩展法,时间复杂度为n^2
	public static String longestPalindrome(String s) {
		char[] cs = s.toCharArray();
		int len = s.length();
		int start = 0, count = 1;
		//奇数长度子串
		for(int i = 0; i < len; i++) {
			int j = i - 1, k = i + 1;
			while(j >= 0 && k < len && cs[j] == cs[k]) {
				if(k - j + 1 > count) {
					count = k - j + 1;
					start = j;
				}
				j--;
				k++;
			}
		}
		// 偶数长度子串
		for (int i = 0; i < len; i++) {
			int j = i, k = i + 1;
			while (j >= 0 && k < len && cs[j] == cs[k]) {
				if (k - j + 1 > count) {
					count = k - j + 1;
					start = j;
				}
				j--;
				k++;
			}
		}
		return String.copyValueOf(cs, start, count);
	}

	// 动态规划法,时间复杂度为n^2,空间复杂度n^2,比暴力法好些，但还是不够理想
	public static String longestPalindrome1(String s) {
		char[] cs = s.toCharArray();
		int len = s.length();
		int start = 0, count = 1;
		boolean[][] palindrome = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j + i < len; j++) {
				if (i == 0) {
					palindrome[j][j + i] = true;
				} else {
					palindrome[j][j + i] = cs[j] == cs[j + i];
					if (i > 2) {
						palindrome[j][j + i] &= palindrome[j + 1][j + i - 1];
					}
				}
				if (i + 1 > count && palindrome[j][j + i]) {
					start = j;
					count = i + 1;
				}
			}
		}
		return String.copyValueOf(cs, start, count);
	}

	public static void main(String[] args) {
		String s = "abcdzdcab";
		System.out.println(longestPalindrome(s));
	}

}
