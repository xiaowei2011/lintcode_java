package test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//骰子求和
public class DicesSum {
	
	public List<Map.Entry<Integer, Double>> dicesSum(int n) {
		double[][] dp = new double[n+1][6*n+1];
		for(int i = 1; i <= 6; i++) {
			dp[1][i] = 1/6d;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = i; j <= 6 * i; j++) {
				for(int k = 1; k <=6; k++) {
					if(j > k) {
						dp[i][j] += dp[i-1][j-k];
					}
				}
				dp[i][j] /= 6d;
			}
		}
		List<Map.Entry<Integer, Double>> list = new ArrayList<>();
		for(int i = n; i <= 6 * n; i++) {
			list.add(new AbstractMap.SimpleEntry<>(i, dp[n][i]));
		}
        return list;
    }
	
	//运行出错
	public List<Map.Entry<Integer, Double>> dicesSum1(int n) {
		Map<Integer, Double> map = new HashMap<>();
		for(int i = 0; i < 6; i++) {
			map.put(i + 1, 1d);
		}
		for(int i = 1; i < n; i++) {
			Map<Integer, Double> temp = new HashMap<>();
			for(Map.Entry<Integer, Double> entry : map.entrySet()) {
				for(int j = 1; j <= 6; j++) {
					int k = entry.getKey();
					Double c = temp.get(k + j);
					c = c == null ? 1 : c + 1;
					temp.put(k + j, c);
				}
			}
			map = temp;
		}
		List<Map.Entry<Integer, Double>> list = new ArrayList<>();
		double sum = Math.pow(6, n);
		for(Map.Entry<Integer, Double> entry : map.entrySet()) {
			list.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue() / sum));
		}
        return list;
    }
	
	void show(List<Map.Entry<Integer, Double>> list) {
		System.out.print("[");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(i == 0 ? "" : ",");
			System.out.print("[" + list.get(i).getKey() + "," + list.get(i).getValue() + "]");
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		DicesSum obj = new DicesSum();
		obj.show(obj.dicesSum(3));
	}
}
