##整体思路
暴力枚举会超时，所以选择dfs+剪枝。边全排列边试验。num=num1+num2/num3;

分析一下可以知道**num1<num;  num2>num3;   num2%num3==0**; 这正是剪枝的条件。

把num转换为字符串，算出有多少位。比如num=256,长度begin=3。把全排列的字符串也转化为字符串,长度为9,比如str= 348576192。

由上面的条件知道，num1最多也就从str截取最多是begin长度。

而num2则最少截取到剩下字符串的一半，因为num2的长度肯定大于等于num3的长度，且num3长度至少为1.当num1取3时，num2直接就从4857开始了。
##实现
使用如下实现全排列

    public static void f(int start, int num){
		if (start == 9) {//数字一共有九个，数组下标最大为8，所以start必须达到9
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

接着在Judge方法内先算出num1不得超出多少位

    int begin = 1, temp = num;
		while ((temp = temp/10) != 0) {
			begin++;
		}

接着依次遍历begin位内的num1数值，sum方法值得学习一下

    public static int sum(int start, int end){
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum = sum * 10 + a[i];
		}
		return sum;
	}
##总结
dfs和剪枝都是常用的方法，这个不难，只是其中剪枝条件过多，需要细心考虑，begin是将一个数变成有多少位，sum是将多少位变成一个数