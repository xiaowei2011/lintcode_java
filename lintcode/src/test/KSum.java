package test;

//k数之和
public class KSum {
	
	//稍加改动，降低空间复杂度
	public static int kSum(int[] A, int k, int target) {
		int[][] dp = new int[k + 1][target + 1];
		dp[0][0] = 1;
		for(int i = 1; i <= A.length; i++) {
			for(int j = k; j > 0; j--) {
				for(int m = target; m >= A[i - 1]; m--) {			
					dp[j][m] += dp[j - 1][m - A[i - 1]];
				}
			}
		}
        return dp[k][target];
    }
	
	//动态规划
	public static int kSum2(int[] A, int k, int target) {
		int[][][] dp = new int[A.length + 1][k + 1][target + 1];
		for(int i = 1; i <= A.length; i++) {
			if(A[i - 1] <= target) {
				for(int j = i; j <= A.length; j++) {
					dp[j][1][A[i - 1]] = 1;
				}
			}
		}
		for(int i = 1; i < dp.length; i++) {
			for(int j = 2; j <= i && j < dp[i].length; j++) {
				for(int m = 1; m < dp[i][j].length; m++) {
					dp[i][j][m] = dp[i - 1][j][m];
					if(m > A[i - 1]) {			
						dp[i][j][m] += dp[i - 1][j - 1][m - A[i - 1]];
					}
				}
			}
		}
        return dp[A.length][k][target];
    }
	
	//回溯法，超时
	public static int kSum1(int[] A, int k, int target) {
		int[] count = new int[1];
		kSum(A, k, target, 0, count);
        return count[0];
    }
	
	static void kSum(int[] A, int k, int target, int i, int[] count) {
		if(k == 0) {
			count[0] += target == 0 ? 1 : 0;
			return;
		}
		for(int m = i; m < A.length; m++) {
			kSum(A, k - 1, target - A[m], m + 1, count);
		}
	}

	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		System.out.println(kSum(A, 2, 5));
		A = new int[] {1,4,7,10,12,15,16,18,21,23,24,25,26,29};
		System.out.println(kSum(A, 5, 113));
	}

}
