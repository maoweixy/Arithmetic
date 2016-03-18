import java.util.*;
public class Main2 {
	static int num = 5;//物品数量
	static int w = 15;//背包承受重量
	static int[] value = {0,1,2,2,4,10};//各个物品价值
	static int[] weight = {0,1,1,2,12,4};//各个物品重量，与价值对应
	//static int [][]dp = new int[num + 1][w + 1];
	static int sum = 0;
	static int[] best = new int[num + 1];
	static int[] path = new int[num + 2];
	public static void main(String[] args)throws Exception{
		f(1,0);
		for (int i = 1; i < best.length; i++) {
			if (best[i] == 1) {
				System.out.println(value[i] + "  " + weight[i]);
			}
		}
		System.out.println(sum);
	}
	public static void f(int t, int w1){
		if (t > num) {
			int count = 0;
			for (int i = 1; i < t; i++) {
				if (path[i] == 1) {
					count += value[i];
				}
			}
			if (count > sum) {
				sum = count;
				for (int i = 1; i < best.length; i++) {
					best[i] = path[i];
				}
			}
			return;
		}
		for (int i = 0; i <= 1; i++) {
			if (i == 0) {
				path[t] = i;
			}else {
				if (i == 1 && (w1 + weight[t]) < w) {
					path[t] = i;
					w1  = w1 + weight[t];
				}
			}
			f(t + 1,w1);
		}
	}
}
