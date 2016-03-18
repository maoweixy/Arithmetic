import java.util.*;
public class test7 {
	String X = "ABCBDAB";
	String Y = "BDCABA";
//	int m = X.length();
//	int n = Y.length();
	int[][] table;
	TreeSet<String> set = new TreeSet<String>();
	public static void main(String[] args) {
		new test7().PrintLcs();
	}
	public int f(int m, int n){
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
	public void TraceBack(int i, int j, String Lcs){
		while (i > 0 && j > 0) {
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				Lcs += X.charAt(i - 1);
				i--;
				j--;
			}else {
				if (table[i - 1][j] > table[i][j - 1]) {
					i--;
				}
				else if (table[i - 1][j] < table[i][j - 1]) {
					j--;
				}else {
					TraceBack(i - 1, j, Lcs);
					TraceBack(i, j - 1, Lcs);
					return;
				}
			}
		}
		StringBuffer str = new StringBuffer(Lcs).reverse(); 
		set.add(str.toString());
	}
	public void PrintLcs(){
		int len = f(X.length(), Y.length());
		System.out.println("������г��ȣ�" + len);
		TraceBack(X.length(), Y.length(), "");
		for (String str : set) {
			System.out.println(str);
		}
		
	}
}
