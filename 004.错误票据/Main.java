import java.util.*;
public class Main {
	
	public static void main(String[] args)throws Exception{
		Scanner in = new Scanner(System.in);
		String str = "";
		String all = "";
		int m = 0, n = 0;
		int k = in.nextInt();
		in.nextLine();
		for (int i = 0; i < k; i++) {
			str = in.nextLine().trim() + " ";
			all += str;
		}

		String[] a = all.split(" ");
		int[] intArray = new int[a.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(a[i]);
		}
		Arrays.sort(intArray);
		for (int i = 0; i < intArray.length - 1; i++) {
			if (intArray[i] == intArray[i + 1]) {
				n = intArray[i];
			}else if (intArray[i] != intArray[i+1] -1) {
				m = intArray[i] + 1;
			}
			if (n != 0 && m != 0) {
				break;
			}
		}
		System.out.println(m + " " + n);
	}
	
}
