import java.lang.reflect.Array;
import java.util.*;
public class Main {
	static int m, n, count = 0;
	static ArrayList<Integer> list1 = new ArrayList<>();
	public static void main(String[] args)throws Exception{
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				list1.add(i);
			}
			
		}
		f(2,list1);
		System.out.println(count);
	}
	public static void f(int t, ArrayList<Integer> list){
		
		if (t >= list.size()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) > m) {
					//System.out.print(list.get(i) + " ");
					count++;
				}
			}
			if (list.get(list.size() - 1) == n) {
				count--;
			}
			return;
		}
		if (t < list.size()) {
			int lucky = list.get(t -1);
			//System.out.println(lucky);
			list1 = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if ((i + 1) % lucky != 0) {
					list1.add(list.get(i));
				}
			}
			f(t + 1, list1);
		}
	}
}
