package test;

import java.util.Arrays;

public class SortColors {
	
	public static void sortColors(int[] nums) {
        int i = 0, left = 0, right = nums.length - 1;
        while(i <= right) {
        	if(nums[i] == 0) {
        		swap(nums, left, i);
        		i++;
        		left++;
        	}else if(nums[i] == 1) {
        		i++;
        	}else {
        		swap(nums, right, i);
        		right--;
        	}
        }
    }
	
	//一种神奇的做法
	public static void sortColors1(int[] nums) {
        int i ,j ,k;
        i = j = k = 0;
        for(int p = 0; p < nums.length; p++) {
        	if(nums[p] == 0) {
        		nums[k++] = 2;
        		nums[j++] = 1;
        		nums[i++] = 0;
        	}else if(nums[p] == 1) {
        		nums[j++] = 1;
        		nums[i++] = 0;
        	}else {
        		nums[i++] = 0;
        	}
        }
    }
	
	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = {1,0,1,2};
		sortColors1(a);
		Arrays.stream(a).forEach(n->System.out.print(n+" "));
	}

}
