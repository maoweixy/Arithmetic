import java.util.*;
public class Main {
	static String str1 = "BDCABA", str2 = "ABCBDAB"; 
	static char[] ch1,ch2;
	static int count = 0;
	public static void main(String[] args)throws Exception{
		ch1 = str1.toCharArray();
		ch2 = str2.toCharArray();
		System.out.println(f(ch1.length - 1, ch2.length - 1));
	}
	public static int f(int i, int j){ 
		if (i == -1 || j == -1) {
			return 0;
		}
		if (ch1[i] != ch2[j]) {
			return Math.max(f(i - 1, j), f(i, j - 1));
		}else {
			return f(i - 1, j - 1) + 1;
		}
	}
}
