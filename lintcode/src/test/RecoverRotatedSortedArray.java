package test;

import java.util.Arrays;
import java.util.List;

//»Ö¸´Ðý×ªÊý×é
public class RecoverRotatedSortedArray {
	
	public static void recoverRotatedSortedArray(List<Integer> nums) {
		int i = 1, n = nums.size();
		while(i < n && nums.get(i) >= nums.get(i - 1)) {
			i++;
		}
		if(i == 1) {
			return;
		}
		reverse(nums, 0, i - 1);
		if(i < n) {
			reverse(nums, i, n - 1);
		}
		reverse(nums, 0, n - 1);
    }
	
	static void reverse(List<Integer> nums, int i, int j) {
		int temp;
		for(;i < j; i++, j--) {
			temp = nums.get(i);
			nums.set(i, nums.get(j));
			nums.set(j, temp);
		}
	}

	public static void main(String[] args) {
		Integer[] a = {5, 6, 1, 2, 3, 4};
//		a = new Integer[]{4, 5, 1, 2, 3};
//		a = new Integer[]{3, 4, 5, 6, 1, 2};
		a = new Integer[]{1, 1, 1, -1, 1, 1, 1, 1};
		List<Integer> nums = Arrays.asList(a);
		recoverRotatedSortedArray(nums);
		System.out.println(nums);
	}

}
