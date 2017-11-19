package test;

public class FirstPositionOfTarget {
	
	//一简洁写法
	public static int binarySearch(int[] nums, int target) {
		int mid, start = 0, end = nums.length;
		while(start < end) {
			mid = start + (end - start) / 2;
			if(nums[mid] >= target) {
				end = mid;
			}else{
				start = mid + 1;
			}
		}
        return nums[start] == target ? start : -1;
	}
	
	public static int binarySearch1(int[] nums, int target) {
		int mid, start = 0, end = nums.length;
		while(start <= end) {
			mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				if(mid == 0 || nums[mid - 1] != target) {
					return mid;
				}else {
					end = mid;
				}
			}else if(nums[mid] < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
        return -1;
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 4, 5, 10};
		System.out.println(binarySearch(nums, 4));
		System.out.println(binarySearch(nums, 3));
		System.out.println(binarySearch(nums, 6));
	}

}
