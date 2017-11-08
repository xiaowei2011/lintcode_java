package test;

public class StringToIntegerII {
	
	public static int atoi(String str) {
		str = str.trim();
		if(str.length() == 0) {
			return 0;
		}
		int index = str.indexOf('.');
		if(index > 0) {
			str = str.substring(0, index);
		}
		boolean negative = false;
		if(str.charAt(0) == '-' || str.charAt(0) == '+') {
			negative = str.charAt(0) == '-';
			str = str.substring(1);
		}
		//注意，如果是long num将会导致结果不正确
		double num = 0;
		char[] a = str.toCharArray();
		for(int i = 0; i < a.length; i++) {
			if(a[i] < '0' || a[i] > '9') {
				break;
			}
			num = num*10 + (a[i] - '0');
		}
		if (negative) {
			num = -num;
		}
		if(num < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}else if(num > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
        return (int)num;
    }

	public static void main(String[] args) {
		System.out.println(atoi("1234567890123456789012345678901234567890"));
	}

}
