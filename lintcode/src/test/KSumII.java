package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//k数之和II
public class KSumII {
	
	public static List<List<Integer>> kSumII(int[] A, int k, int targer) {
		List<List<Integer>> result = new ArrayList<>();
		int[] nums = new int[k]; 
		kSum(A, k, targer, 0, nums, result);
        return result;
    }
	
	static void kSum(int[] A, int k, int targer, int i, int[] nums, List<List<Integer>> result) {
		if(k == 0) {
			if(targer == 0) {
				List<Integer> list = new ArrayList<>();
				Arrays.stream(nums).forEach(list::add);
				result.add(list);
			}
			return;
		}
		for(int m = i; m < A.length; m++) {
			nums[nums.length - k] = A[m];
			kSum(A, k - 1, targer - A[m], m + 1, nums, result);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		Util.print(kSumII(A, 2, 5));
	}

}
