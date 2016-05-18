import java.util.Scanner;
public class Main {
	static int[][] used;
	static String[][] ch;
	static int min = Integer.MAX_VALUE, n;
	static int startx, starty, endx, endy;
	static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1}; 
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.nextLine());
		used = new int[n][n];
		ch = new String[n][n];
		for (int i = 0; i < n; i++) {
			ch[i] = in.nextLine().split(" ");
		}
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				if (ch[i][j].equals("A")) {
					startx = i;
					starty = j;
				}
				if (ch[i][j].equals("B")) {
					endx = i;
					endy = j;
				}
			}
		}
		f(0,startx, starty);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	public static void f(int k, int tx, int ty){
		if (tx == endx && ty == endy) {
			if (k < min) {
				min = k;
			}
		}else {
			for (int i = 0; i < 4; i++) {
				int ax = tx + dx[i], ay = ty + dy[i];
				if (judge(ax, ay) && (ch[tx][ty].equals(ch[ax][ay])== false)) {
					used[ax][ay] = 1;
					f(k + 1, ax, ay);
					used[ax][ay] = 0;
					
				}
			}
		}
	}
	public static Boolean judge(int a, int b){
		if (0 <= a && a < n && 0 <= b && b < n && used[a][b] == 0) {
			return true;
		}
		return false;
	}
}
