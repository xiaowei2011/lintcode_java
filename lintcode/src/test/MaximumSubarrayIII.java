package test;

public class MaximumSubarrayIII {
	
	public static int maxSubArray(int[] nums, int k) {
		int[][] dp = new int[nums.length][k];
		int[][] f = new int[nums.length][nums.length];
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				int p = nums[i];
				f[i][j] = nums[i];
				for(int m = i + 1; m <= j; m++) {
					p = p < 0 ? nums[m] : p + nums[m];
					if(p > f[i][j]) {
						f[i][j] = p;
					}
				}
			}
		}
		Util.print(f);
		dp[0][0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < k; j++) {
				dp[i][j] = 0;
			}
		}
        return dp[nums.length - 1][k - 1];
    }

	public static void main(String[] args) {
		int[] nums = {-1,4,-2,3,-2,3};
		System.out.println(maxSubArray(nums, 2));
	}

}
