package test;

//回文数
public class PalindromeNumber {
	
	public static boolean isPalindrome(int num) {
		int[] a = new int[10];
		int i = 0;
		while(num > 0) {
			a[i++] = num % 10;
			num /= 10;
		}
		i--;
		for(int j = 0; j < i; j++, i--) {
			if(a[j] != a[i]) {
				return false;
			}
		}
		return true;
    }
	
	//另一种解法
	public static boolean isPalindrome1(int num) {
		long sum = 0;
		long n = num;
		while(n > 0) {
			sum = sum * 10 + n % 10;
			n /= 10;
		}
		return sum == num;
    }

	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
	}

}
