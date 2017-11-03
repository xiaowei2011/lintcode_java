package test;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	
	public static String minWindow(String source , String target) {
		if(source == null || source.length() == 0) {
			return "";
		}
		char[] cs = source.toCharArray();
		char[] ct = target.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < ct.length; i++) {
			if(map.containsKey(ct[i])) {
				map.put(ct[i], map.get(ct[i]) + 1);
			}else {
				map.put(ct[i], 1);
			}
		}
		int left = 0, right = 0, count = 0, start = 0, len = cs.length + 1;
		while(right < cs.length) {
			if(map.containsKey(cs[right])) {
				map.put(cs[right], map.get(cs[right]) - 1);
				if(map.get(cs[right]) >= 0) {
					count++;
				}
				while(count == ct.length) {
					if(right - left + 1 < len) {
						start = left;
						len = right - left + 1;
					}
					if(map.containsKey(cs[left])) {
						map.put(cs[left], map.get(cs[left]) + 1);
						if(map.get(cs[left]) > 0) {
							count--;
						}
					}
					left++;
				}
			}
			right++;
		}
		if(len > cs.length) {
			return "";
		}
		return String.valueOf(cs, start, len);  
    }

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

}
