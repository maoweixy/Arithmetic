##Mian.java
使用动态规划自底向上求解：
定义 dp( n,  w )代表从n个元素中选择组合方式使得重量为w的背包价值最大，value( n )表示第n个元素的价值，weight( n )表示第n个元素的重量。则可以得到状态转移方程：

    dp(n,w) = max( dp(n-1,w), dp(n-1,w-weight(n))+value(n))  
    //dp(n-1,w)表示物品不放入背包，从剩下n-1个元素中，书包重量为w中获取最大价值  
    //dp(n-1,w-weight(n))+value(n)表示第n个元素放入书包中(w > w - weight(n)  
依次穷举每个物品，当个数为1，背包承受重量为0到个数为num，承受重量为w，自底向上依次求解：

    for (int i = 1; i <= num; i++) {
			for (int j = 0; j <= w ; j++) {
				if (j - weight[i] <= 0) {
					dp[i][j] = dp[i -1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]]+ value[i]);
				}
			}
		}
		
##Main1.java
动态规划+从上到下+备忘录法
##Main2.java
上面两种方法只能求最大值是多少，如果要求出具体是那几个物品装进背包里面，这就必须要使用回溯法。

    使用0，1循环遍历所有物品（0代表物品不在背包里面，1代表在），
    最后打印value最大的path数组。