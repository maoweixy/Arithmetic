##整体思路
使用回溯法
1.下图是题目的解空间树
![][1]
  


  [1]: https://d.pcs.baidu.com/thumbnail/1a728acf48b7b5fb9f7abac8ee8c194f?fid=1044190022-250528-12313234528463&time=1458270000&rt=sh&sign=FDTAER-DCb740ccc5511e5e8fedcff06b081203-mfnHLXngVR5sU3vfYKAwq7Pp1tk=&expires=8h&chkv=0&chkbd=0&chkpc=&dp-logid=1796707294995138898&dp-callid=0&size=c710_u500&quality=100
ABC代表三个杯子，分支代表父结点向子节点倒酒，其实应该有三个结点，只是我画的时候就用了剪枝，因为杯子不能往自己里面倒。每个节点代表一组解，然后与题目要求比较，看是否满足。

2.剪枝
这题目麻烦就是在于剪枝函数太复杂，要求考虑的条件太多。

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
注意要每次求得的解要与以前的比较，看是否有重复，这点很重要，否则会陷入无限循环。使用flag确定是否与以前相同，这个方法好好品味一下。</br>要求当前的解与以前的解比较，如果与某个解全部相同，则不行。直接比较全部相同太麻烦，对等的只有一个解不同就可以。
