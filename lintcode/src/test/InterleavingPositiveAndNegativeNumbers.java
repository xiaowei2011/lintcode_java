package test;

/**
 * @autor sunweijie
 * @since 2017年12月29日 下午5:15:44
 */
// 144.交错正负数
public class InterleavingPositiveAndNegativeNumbers {

	/*
	 * @param A: An integer array.
	 * 
	 * @return: nothing
	 */
	//一神奇算法，先将正数全部移到左边，负数移到右边，然后交换
	public static void rerange(int[] A) {
		int i = 0, j = A.length - 1;
		while(i < j) {
			if(A[i] < 0) {
				swap(A, i, j);
				j--;
			}else {
				i++;
			}
		}
		if(A.length % 2 == 0) {
			i = 1;
			j = A.length - 2;
		}else if(A[A.length / 2] > 0) {
			i = 1;
			j = A.length - 1;
		}else {
			i = 0;
			j = A.length - 2;
		}
		while(i < j) {
			swap(A, i, j);
			i += 2;
			j -= 2;
		}
	}
	
	//两根指针，一个指向正数，一个指向负数交替插入当前位置
	public static void rerange1(int[] A) {
		int c1 = 0, c2 = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				c1++;
			} else {
				c2++;
			}
		}
		int i = 0, j = 0;
		while (i < A.length && A[i] < 0) {
			i++;
		}
		while (j < A.length && A[j] > 0) {
			j++;
		}
		boolean cur = true;
		if (c2 > c1) {
			cur = false;
		}
		int id = 0;
		while (id < A.length) {
			if (cur && i < A.length) {
				swap(A, id, i);
				i++;
				while (i < A.length && A[i] < 0) {
					i++;
				}
				while (j < A.length && A[j] > 0) {
					j++;
				}

			} else if(j < A.length){
				swap(A, id, j);
				j++;
				while (j < A.length && A[j] > 0) {
					j++;
				}
				while (i < A.length && A[i] < 0) {
					i++;
				}
			}
			id++;
			cur = !cur;
		}
	}

	static void swap(int[] a, int i, int j) {
		if(i != j) {
			a[i] = a[i] ^ a[j];
			a[j] = a[i] ^ a[j];
			a[i] = a[i] ^ a[j];	
		}
	}

	public static void main(String[] args) {
		int[] a = { -1, -2, -3, 4, 5, 6 };
		a = new int[] { 26, -31, 10, -29, 17, 18, -24, -10};
		rerange(a);
		Util.print(a);
	}

}
