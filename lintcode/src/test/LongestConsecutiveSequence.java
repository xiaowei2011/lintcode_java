package test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @autor sunweijie
 * @since 2017年12月25日 下午2:57:38
 */
//124. 最长连续序列
public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<>(num.length);
		for(int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
		int maxLen = 0;
		for(int cur : num) {
			int len = consecutive(set, cur, 1) + consecutive(set, cur - 1, -1);
			maxLen = len > maxLen ? len : maxLen;
		}
		return maxLen;
	}
	
	static int consecutive(HashSet<Integer> set, int cur, int inc) {
		int len = 0;
		while(set.contains(cur)) {
			len++;
			set.remove(cur);
			cur += inc;
		}
		return len;
	}
	
	/*
     * @param num: A list of integers
     * @return: An integer
     */
	//运行通过，但时间复杂度达不到O(n)
	public static int longestConsecutive1(int[] num) {
		Arrays.sort(num);
		int maxLen = 1;
		int len = 1;
		for(int i = 1; i < num.length; i++) {
			if(num[i] == num[i - 1] + 1) {
				len++;
			}else if(num[i] != num[i - 1]){
				len = 1;
			}
			if(len > maxLen) {
				maxLen = len;
			}
		}
        return maxLen;
    }

	public static void main(String[] args) {
		int[] num = {100, 4, 200, 1, 3, 2};
//		num = new int[]{1, 2, 0, 1};
		System.out.println(longestConsecutive(num));
	}

}
