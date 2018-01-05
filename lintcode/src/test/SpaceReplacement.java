package test;

/**
 * @autor sunweijie
 * @since 2018年1月5日 下午4:42:27
 */
//212.空格替换
public class SpaceReplacement {
	
	 /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public static int replaceBlank(char[] string, int length) {
    	int count = 0;
    	for(int i = 0; i < length; i++) {
    		if(string[i] == ' ') {
    			count++;
    		}
    	}
    	int realLen = length + 2 * count;
    	int j = realLen - 1;
    	for(int i = length - 1; i >= 0 && j > i; i--) {
    		if(string[i] == ' ') {
    			string[j--] = '0';
    			string[j--] = '2';
    			string[j--] = '%';
    		}else {
    			string[j--] = string[i];
    		}
    	}
    	return realLen;
    }

	public static void main(String[] args) {
		String s = "Mr John Smith";
		int len = s.length();
		char[] c = new char[len + 10];
		for(int i = 0; i < len; i++) {
			c[i] = s.charAt(i);
		}
		int realLen = replaceBlank(c, len);
		System.out.println(realLen);
		System.out.println("->" + String.copyValueOf(c) + "<-");
	}

}
