package test;

import java.util.Arrays;
import java.util.List;

/**
 * @autor sunweijie
 * @since 2017年12月28日 下午9:00:11
 */
//91. 最小调整代价
public class MinimumAdjustmentCost {
	
	/*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public static int MinAdjustmentCost(List<Integer> A, int target) {
    	int len = A.size();
    	int[][] dp = new int[len][101];
    	for(int i = 0; i < 101; i++) {
    		dp[0][i] = Math.abs(A.get(0) - i);
    	}
    	for(int i = 1; i < len; i++) {
    		for(int j = 0; j < 101; j++) {
    			int min = Math.max(j - target, 0);
    			int max = Math.min(j + target, 100);
    			int diff = Math.abs(j - A.get(i));
    			dp[i][j] = Integer.MAX_VALUE;
    			for(int k = min; k <= max; k++) {
    				dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
    			}
    		}
    	}
    	int min = dp[len - 1][0];
    	for(int i = 0; i < 101; i++) {
    		min = Math.min(min, dp[len - 1][i]);
    	}
    	return min;
    }

	public static void main(String[] args) {
		Integer[] a = new Integer[] {1, 4, 2, 3};
		a = new Integer[] {12,3,7,4,5,13,2,8,4,7,6,5,7};
		System.out.println(MinAdjustmentCost(Arrays.asList(a), 2));
	}

}
