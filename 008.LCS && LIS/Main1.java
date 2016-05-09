import java.util.*;
public class Main1 {
	static String X = "ABCBDAB";
	static String Y = "BDCABA";
	static String str = "";
//	int m = X.length();
//	int n = Y.length();
	static int[][] table;
	TreeSet<String> set = new TreeSet<String>();
	public static void main(String[] args) {
		PrintLcs();
	}
	public static int f(int m, int n){
		table = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				}
				else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1] + 1;
				}
				else {
					table[i][j] = Math.max(table[i -1][j], table[i][j - 1]);
				}
			}
		}
		return table[m][n];
	}
	public static void TraceBack(int i, int j){
		while (i > 0 && j > 0) {
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				str += X.charAt(i - 1);
				i--;
				j--;
			}else {
				if (table[i - 1][j] > table[i][j - 1]) {
					i--;
				}
				else {
					j--;
				}
			}
		}
		StringBuffer sb = new StringBuffer(str).reverse();
		System.out.println(sb.toString());
	}
	public static void PrintLcs(){
		int len = f(X.length(), Y.length());
		System.out.println("最长子序列长度是：" + len);
		TraceBack(X.length(), Y.length());

		
	}
}
