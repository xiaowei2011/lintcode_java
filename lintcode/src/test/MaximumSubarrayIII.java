package test;

public class MaximumSubarrayIII {
	
	/** 
	 *分析：与Best Time to Buy and Sell Stock IV类似，两个数组分别记录包含当前值的本地最优解和全局最优解。
	 *local[i][j]代表从0到nums中第i个数字处，分成j个数组后，和的最大值,且必须包括第i个数字，这样可以排除第i个数组包含在前一个数组中的情况。
	 *global[i][j]代表从0到nums第i个数字处，分成j个数组后和的最大值。二维数组动态规划的状态转移方程为：
	 *local[i][j] = Math.max(local[i - 1][j], global[i - 1][j - 1])  + nums[i - 1];
	 *global[i][j] = Math.max(global[i - 1][j], local[i][j]);
	 */
	public static int maxSubArray(int[] nums, int k) {
		int[][] local = new int[nums.length + 1][k + 1];
		int[][] global = new int[nums.length + 1][k + 1];
		for(int i = 1; i <= nums.length; i++) {
			local[i][0] = Integer.MIN_VALUE;
			for(int j = 1; j <= k; j++) {
				if(j > i) {
					global[i][j] = local[i][j] = Integer.MIN_VALUE;
					continue;
				}
				local[i][j] = Math.max(local[i - 1][j], global[i - 1][j - 1]) + nums[i - 1];
				if(i == j) {
					global[i][j] = local[i][j];
				}else {	
					global[i][j] = Math.max(global[i - 1][j], local[i][j]);
				}
			}
		}
		return global[nums.length][k];
	}

	//时间复杂度略高
	public static int maxSubArray1(int[] nums, int k) {
		int[][] dp = new int[nums.length + 1][k + 1];
		for(int i = 0; i <= nums.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= i && j <= k; j++) {
				int p = 0;
				int mx = Integer.MIN_VALUE;
				dp[i][j] = Integer.MIN_VALUE;
				for (int m = i; m >= j; m--) {
					p = p < 0 ? nums[m - 1] : p + nums[m - 1];
					mx = p > mx ? p : mx;
					dp[i][j] = dp[m - 1][j - 1] + mx > dp[i][j] ? dp[m - 1][j - 1] + mx : dp[i][j];
				}
			}
		}
		return dp[nums.length][k];
	}

	public static void main(String[] args) {
		int[] nums = { -1, 4, -2, 3, -2, 3 };
//		nums = new int[] {1, 2, 3};
		nums = new int[] {-1,-2,-3,-100,-1,-50};
		System.out.println(maxSubArray(nums, 2));
	}

}
