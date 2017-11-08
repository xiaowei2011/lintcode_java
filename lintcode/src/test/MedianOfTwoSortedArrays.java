package test;

//两个排序数组的中位数
public class MedianOfTwoSortedArrays {
	
	/**
	 * 首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。
	 * 这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。换句
	 * 话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。
	 * 当A[k/2-1]>B[k/2-1]时存在类似的结论。
	 * 当A[k/2-1]=B[k/2-1]时，我们已经找到了第k小的数，也即这个相等的元素，我们将其记为m。由于在A和B中分别有k/2-1个元素小于m，所以m即是第k小的数
	 */
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int mid = (A.length + B.length) / 2;
		if((A.length + B.length) % 2 == 1) {
			return findKpth(A, 0, B, 0, mid + 1);
		}else {
			int a = findKpth(A, 0, B, 0, mid);
			int b = findKpth(A, 0, B, 0, mid + 1);
			System.out.println(a);
			System.out.println(b);
			return (findKpth(A, 0, B, 0, mid) + findKpth(A, 0, B, 0, mid + 1)) / 2.0;
		}
	}
	
	static int findKpth(int[] A, int s1, int[] B, int s2, int k) {
		int m = A.length - s1;
		int n = B.length - s2;
		if(m > n) {
			return findKpth(B, s2, A, s1, k);
		}
		if(m == 0) {
			return B[s2 + k - 1];
		}
		if(k == 1) {
			return Math.min(A[s1], B[s2]);
		}
		int pa = Math.min(k / 2, m);
		int pb = k - pa;
		if(A[s1 + pa - 1] == B[s2 + pb - 1]) {
			return A[s1 + pa - 1];
		}else if(A[s1 + pa - 1] < B[s2 + pb - 1]){
			return findKpth(A, s1 + pa, B, s2, k - pa);
		}else {
			return findKpth(A, s1, B, s2 + pb, k - pb);
		}
	}
	
	//归并排序后取中间值
	public static double findMedianSortedArrays1(int[] A, int[] B) {
		int i = 0, j = 0, k = 0, mid;
		int[] C = new int[A.length + B.length];
		mid = (A.length + B.length) / 2;
		while(i < A.length && j < B.length) {
			if(A[i] <= B[j]) {
				C[k++] = A[i++];
			}else {
				C[k++] = B[j++];
			}
		}
		while(i < A.length) {
			C[k++] = A[i++];
		}
		while(j < B.length) {
			C[k++] = B[j++];
		}
        return C.length % 2 == 0 ? (C[mid] + C[mid - 1]) / 2.0 : C[mid];
    }

	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		int[] B = {2,3,4,5};
		A = new int[] {3};
		B = new int[] {4};
		System.out.println(findMedianSortedArrays(A, B));
	}

}
