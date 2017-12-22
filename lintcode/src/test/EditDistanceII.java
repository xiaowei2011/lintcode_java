package test;

/**
 * @autor sunweijie
 * @since 2017年12月22日 上午9:30:24
 */
//640.编辑距离II
public class EditDistanceII {
	
	/*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public static boolean isOneEditDistance(String s, String t) {
    	char[] c1 = s.toCharArray();
    	char[] c2 = t.toCharArray();
    	int d = c1.length - c2.length;
    	if(d < -1 || d > 1) {
    		return false;
    	}
    	boolean flag = true;
    	int i = 0, j = 0;
    	for(; i < s.length() && j < t.length(); i++, j++) {
    		if(c1[i] != c2[j]) {
    			if(flag) {
    				if(d == -1) {
    					i--;
    				}else if(d == 1) {
    					j--;
    				}
    				flag = false;
    			}else {
    				return false;
    			}
    		}
    	}
    	if(i == s.length() && j == t.length()) {
    		return !flag;
    	}else {
    		return flag;
    	}
    }

	public static void main(String[] args) {
		String s = "aDb";
		String t = "adb";
		System.out.println(isOneEditDistance(s, t));
	}

}
