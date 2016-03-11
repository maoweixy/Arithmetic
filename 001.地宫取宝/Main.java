import java.util.Scanner;
public class Main {
	static int M = 1000000007;
	static long[][][][] dp = new long[55][55][15][15];
	static int n, m, k;
	static int[][] val;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		val = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				val[i][j] = in.nextInt();
				val[i][j]++;
			}
		}
		dp[1][1][val[1][1]][1] = 1;
		f();
	}
	public static void f(){
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 && j == 1) {
					continue;
				}else {
					for (int num = 1; num <= k; num++) {
						for (int ma = 0; ma <= 13; ma++) {
							if (ma < val[i][j]) {
								dp[i][j][val[i][j]][num+1] = ((dp[i - 1][j][val[i][j]][num] + dp[i][j - 1][val[i][j]][num]) % M + (dp[i - 1][j][ma][num] + dp[i][j - 1][ma][num]) % M) % M;                     
							}else{
								dp[i][j][ma][num] = (dp[i- 1][j][ma][num] + dp[i][j - 1][ma][num]) % M;
							}
						}
						
					}
				}
			}
		}
		long ans = 0;  
	    for(int i = 0; i < 13; i++)  
	        ans = (ans + dp[n][m][i][k]) % M;  
	    System.out.println(ans);
	}
}
