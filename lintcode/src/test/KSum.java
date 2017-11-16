package test;

//k数之和
public class KSum {
	
	public static int kSum(int[] A, int k, int target) {
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
