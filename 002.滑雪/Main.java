import java.util.*;
public class Main {
	static int[][] map = new int[101][101];
	static int[][] dp = new int[101][101];
	static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
	static int R, C;
	public static void main(String[] args)throws Exception{
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = in.nextInt();
			}
		}
		int max = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				max = Math.max(max, f(i,j));
			}
		}
		System.out.println(max + 1);
	}
	public static int f(int x, int y){
		int xx, yy;
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		
		for (int i = 0; i < 4; i++) {
			xx = x + dx[i];
			yy = y + dy[i];
			if (0<=xx && xx<R && 0<=yy && yy <C && map[x][y] > map[xx][yy]) {
				dp[x][y] = Math.max(dp[x][y], f(xx,yy) + 1);
			}
		}
		return dp[x][y];
	}
	
}
