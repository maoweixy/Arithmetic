import java.util.*;
import java.math.*;
public class Main {
	static int count = 0;
	static int[] a = new int[9];
	static int[] b = new int[100];
	public static void main(String[] args)throws Exception{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		f(0,num);
		System.out.println(count);
	}
	public static void f(int start, int num){
		if (start == 9) {
			Judge(num);
		}else {
			for (int i = 1; i < 10; i++) {
				if (b[i] == 0) {
					a[start] = i;
					b[i] = 1;
					f(start+1,num);
					b[i] =0;
				}
				
			}
		}
	}
	public static void Judge(int num){
		int begin = 1, temp = num;
		while ((temp = temp/10) != 0) {
			begin++;
		}
		for (int i = 1; i <= begin; i++) {
			int num1 = sum(0,i);
			if (num1 < num) {
				for (int j = i + (9 - i)/2; j < 8; j++) {
					int num2 = sum(i,j);
					int num3 = sum(j,9);
					if (num2 >= num3 && num2 % num3 == 0&&num==num1+num2/num3) {
						System.out.println(num+" = "+num1+"+"+num2+"/"+num3); 
						count++;
					}
				}
			}
		}
	}
	public static int sum(int start, int end){
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum = sum * 10 + a[i];
		}
		return sum;
	}
}
