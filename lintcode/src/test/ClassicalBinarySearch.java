package test;

public class ClassicalBinarySearch {
	
	//非递归算法
	public static int findPosition(int[] nums, int target) {
		int start = 0, end = nums.length;
		while(start < end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	//递归算法
	public static int findPosition1(int[] nums, int target) {
        return findPosition(nums, 0, nums.length, target);
    }
	
	static int findPosition(int[] nums, int start, int end, int target) {
		if(end <= start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if(nums[mid] == target) {
			return mid;
		}else if(nums[mid] < target) {
			return findPosition(nums, mid + 1, end, target);
		}else {
			return findPosition(nums, start, mid - 1, target);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 4, 5, 5};
		System.out.println(findPosition(nums, 2));
		System.out.println(findPosition(nums, 5));
		System.out.println(findPosition(nums, 6));
	}

}
