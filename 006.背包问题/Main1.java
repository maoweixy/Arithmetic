import java.util.*;
public class Main1 {
	static int num = 5;//��Ʒ����
	static int w = 15;//������������
	static int[] value = {0,1,2,2,4,10};//������Ʒ��ֵ
	static int[] weight = {0,1,1,2,12,4};//������Ʒ���������ֵ��Ӧ
	static int [][]dp = new int[num + 1][w + 1];
	public static void main(String[] args)throws Exception{
		System.out.println(f(num,w));
	}
	public static int f(int n, int w1){
		if (w1<0) {
			return -10000;
		}
		if (n == 0) {
			return 0;
		}
		if (dp[n][w1] != 0) {
			return dp[n][w1];
		}
		return dp[n][w1] = Math.max(f(n - 1,w1), f(n - 1,w1 - weight[n]) + value[n]);
	}
}
