package test;

/**
 * @autor sunweijie
 * @since 2017年12月26日 下午3:55:27
 */
//143. 排颜色 II
public class SortColorsII {
	
	public static void sortColors2(int[] colors, int k) {
        int id = 0;
        while(id < colors.length) {
        	if(colors[id] <= 0) {
        		id++;
        	}else {
        		int n = colors[id] - 1;
        		if(colors[n] <= 0) {
        			colors[n]--;
        			colors[id] = 0;
        			id++;
        		}else {
        			colors[id] = colors[n];
        			colors[n] = -1;
        		}
        	}
        }
        id = colors.length - 1;
        for(int i = k; i > 0; i--) {
        	int n = colors[i - 1];
        	while(n++ < 0) {
        		colors[id--] = i;
        	}
        }
    }

	public static void main(String[] args) {
		int[] colors = {3, 2, 2, 1, 4};
		sortColors2(colors,4);
		Util.print(colors);
	}

}
