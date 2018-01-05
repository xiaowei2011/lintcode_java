package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor sunweijie
 * @since 2018年1月5日 下午3:58:36
 */
//211. 字符串置换
public class StringPermutation {
	
	/*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public static boolean Permutation(String A, String B) {
    	char[] a = A.toCharArray();
    	char[] b = B.toCharArray();
    	if(a.length != b.length) {
    		return false;
    	}
    	Map<Character,Integer> count = new HashMap<>();
    	for(int i = 0; i < a.length; i++) {
    		Integer c = count.get(a[i]);
    		c = c == null ? 0 : c;
    		count.put(a[i], c + 1);
    	}
    	for(int i = 0; i < b.length; i++) {
    		Integer c = count.get(b[i]);
    		if(c == null) {
    			return false;
    		}
    		if(c == 1) {
    			count.remove(b[i]);
    		}else {
    			count.put(b[i], c - 1);
    		}
    	}
        return count.isEmpty();
    }
    
    public static boolean Permutation1(String A, String B) {
    	char[] a = A.toCharArray();
    	char[] b = B.toCharArray();
    	if(a.length != b.length) {
    		return false;
    	}
    	Arrays.sort(a);
    	Arrays.sort(b);
    	for(int i = 0; i < a.length; i++) {
    		if(a[i] != b[i]) {
    			return false;
    		}
    	}
    	return true;
    }

	public static void main(String[] args) {
		System.out.println(Permutation("abc", "cba"));
		System.out.println(Permutation("aabc", "abcc"));
	}

}
