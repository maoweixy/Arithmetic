
public class Main {
	public static int[] total = {0,12,5,7};
//	public int[] start = {0,12,0,0};
	public static int[] end = {0,11,1,0};
	public static int[][] S = new int[100][100]; //记录各个杯子在倒的过程中，所含酒的量
	public static int n = 3; //杯子个数
	public static int[][] bestS = new int[100][100]; //最好解所含酒的量
	public static int min = 30;
	public static stu[] X = new stu[100];
	public static stu[] bestX = new stu[100];
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			bestX[i] = new stu();
			X[i] = new stu();
		}
		S[0][1] = 12;
		F(1);
		outPut();
	}
	public static void outPut(){
		for (int i = 1; i <= min; i++) {
			System.out.print(bestX[i].from + " >" + bestX[i].to+"       ");
			for (int j = 1; j <= n; j++) {
				System.out.print(bestS[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("min = " + min);
	}
	public static void  F(int k){
		if(k <= min){
			if (isOk(k-1)) {
				if (k < min) {
					save(k-1);
				}
			}
			else {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (judge(k, i, j)) {
							X[k].from = i;
							X[k].to = j;
							F(k + 1);
						}
					}
				}
			}
		}
	}
	public static Boolean isOk(int k){
		for (int i = 1; i <= n; i++) {
			if (S[k][i] != end[i]) {
				return false;
			}
		}
		return true;
	}
	public static void save(int k){
		min = k;
//		System.out.println("min = " + min);
		for (int i = 0; i <= k; i++) {
			bestX[i].from = X[i].from;
			bestX[i].to = X[i].to;
			for (int j = 1; j <= n; j++) {
				bestS[i][j] = S[i][j];
			}
		}
	}
	public static Boolean judge(int k, int i, int j){
		Boolean flag = true;
			if (i == j) {
				return false;
			}
			if (S[k-1][i] == 0) {
				return false;
			}
			if (S[k - 1][j] == total[j]) {
				return false;
			}
			for (int j2 = 1; j2 <= n; j2++) {
				S[k][j2] = S[k - 1][j2];
			}
			if (S[k - 1][i] < total[j] - S[k - 1][j]) {
				S[k][i] = 0;
				S[k][j] = S[k - 1][i] + S[k - 1][j];
			}
			if (S[k - 1][i] > total[j] - S[k - 1][j]) {
				S[k][i] = S[k - 1][i] - (total[j] - S[k - 1][j]);
				S[k][j] = total[j];
			}
			for (int i2 = 0; i2 < k; i2++) {
				flag = false;
				for (int j2 = 1; j2 <= n; j2++) {
					if (S[k][j2] != S[i2][j2]) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					return false;
				}
			}
			return true;
		
	}
}

class stu{
	public int from = 0;
	public int to = 0;
}