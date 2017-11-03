package test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//数据流中位数
public class DataStreamMedian {
	
	public static int[] medianII(int[] nums) {
		int[] medias = new int[nums.length];
		medias[0] = nums[0];
		int[] leftHeap = new int[nums.length];
		leftHeap[0] = nums[0];
		int leftSize = 1;
		int[] rightHeap = new int[nums.length];
		int rightSize = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] <= leftHeap[0]) {
				leftHeap[leftSize++] = nums[i];
				heapFixUp(leftHeap, false, leftSize - 1);
			}else {
				rightHeap[rightSize++] = nums[i];
				heapFixUp(rightHeap, true, rightSize - 1);
			}
			if(leftSize < rightSize) {
				int e = rightHeap[0];
				rightHeap[0] = rightHeap[--rightSize];
				heapFixDown(rightHeap, true, 0, rightSize);
				leftHeap[leftSize++] = e;
				heapFixUp(leftHeap, false, leftSize - 1);
			}else if(leftSize > rightSize + 1) {
				int e = leftHeap[0];
				leftHeap[0] = leftHeap[--leftSize];
				heapFixDown(leftHeap, false, 0, leftSize);
				rightHeap[rightSize++] = e;
				heapFixUp(rightHeap, true, rightSize - 1);
			}
			medias[i] = leftHeap[0];
		}
		return medias;
	}
	
	static void heapFixDown(int[] nums, boolean little, int i, int n) {
		int num = nums[i];
		int j = 2 * i + 1;
		while(j < n) {
			if(j + 1 < n && ((little && nums[j + 1] < nums[j])) || (!little && nums[j + 1] > nums[j])) {
				j++;
			}
			if((little && num <= nums[j]) || (!little && num >= nums[j])) {
				break;
			}
			nums[i] = nums[j];
			i = j;
			j = 2 * i + 1;
		}
		nums[i] = num;
	}
	
	static void heapFixUp(int[] nums, boolean little, int i) {
		int num = nums[i];
		int j = (i - 1) / 2;
		while(i > 0 && ((little && nums[j] > num) || (!little && nums[j] < num))) {
			nums[i] = nums[j];
			i = j;
			j = (i - 1) / 2;
		}
		nums[i] = num;
	}
	
	//时间复杂度为n^2,但竟然通过了
	public static int[] medianII1(int[] nums) {
		int[] medias = new int[nums.length];
		medias[0] = nums[0];
		Set<Pair> set = new TreeSet<>();
		set.add(new Pair(0, nums[0]));
		Iterator<Pair> it;
		for(int i = 1; i < nums.length; i++) {
			set.add(new Pair(i, nums[i]));
			it = set.iterator();
			int c = i / 2;
			while(c-- > 0) {
				it.next();
			}
			medias[i] = it.next().value;
		}
        return medias;
    }

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
//		nums = new int[] { 4, 5, 1, 3, 2, 6, 0 };
		int[] medias = medianII(nums);
		Arrays.stream(medias).forEach(n -> System.out.print(n + " "));
	}

}
class Pair implements Comparable<Pair>{
	int index;
	int value;
	public Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}
	@Override
	public int compareTo(Pair pair) {
		if(value != pair.value) {
			return value - pair.value;
		}
		return index - pair.index;
	}
	
}
