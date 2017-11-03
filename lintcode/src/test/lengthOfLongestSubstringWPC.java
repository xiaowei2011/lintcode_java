package test;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstringWPC {
	
	public static int lengthOfLongestSubstring(String s) {
		char[] a = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int left = 0, right;
		int max = 0;
		for(right = 0; right < a.length; right++) {
			if(set.contains(a[right])) {
				while(a[left] != a[right]) {
					set.remove(a[left]);
					left++;
				}
				left++;
			}else {
				set.add(a[right]);
			}
			if(right - left + 1 > max) {
				max = right -left + 1;
			}
		}
        return max;                                                                                                      
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz"));
	}

}
