import java.util.*;
public class Main {
	static int num = 5;//物品数量
	static int w = 15;//背包承受重量
	static int[] value = {0,1,2,2,4,10};//各个物品价值
	static int[] weight = {0,1,1,2,12,4};//各个物品重量，与价值对应
	static int [][]dp = new int[num + 1][w + 1];
	public static void main(String[] args)throws Exception{
		f();
		System.out.println(dp[num][w]);
	}
	public static void f(){
		for (int i = 1; i <= num; i++) {
			for (int j = 0; j <= w ; j++) {
				if (j - weight[i] <= 0) {
					dp[i][j] = dp[i -1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]]+ value[i]);
				}
			}
		}
	}
}
