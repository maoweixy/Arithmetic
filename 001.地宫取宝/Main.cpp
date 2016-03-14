#include<iostream>  
#include<cstdio>  
#include<cstring>  
#define MAXN 60  
#define MOD %1000000007   
using namespace std;  
long long r[MAXN][MAXN][15][15];//保存状态   
long long map[MAXN][MAXN];//初始地图   
long long m,n,num;  
long long dfs(long long i,long long j,long long k,long long v)  
{  
    long long s=0,t;  
    if(r[i][j][k][v+1]!=-1)  
        return r[i][j][k][v+1];  
    if(i==m&&j==n)//到达终点   
    {  
        if(k==num)  
        {  
            r[m][n][k][v+1]=1;  
            return r[m][n][k][v+1];  
        }  
        else if(k==num-1&&map[m][n]>v)  
        {  
            r[m][n][k][v+1]=1;  
            return r[m][n][k][v+1];  
        }  
        else  
        {  
            r[m][n][k][v+1]=0;  
            return r[m][n][k][v+1];  
        }  
    }  
    else  
    {  
        if(map[i][j]>v)  
        {  
            t=map[i][j];  
            if(i+1<=m)  
            s=(s+dfs(i+1,j,k+1,t)MOD+dfs(i+1,j,k,v)MOD)MOD;  
            if(j+1<=n)  
            s=(s+dfs(i,j+1,k+1,t)MOD+dfs(i,j+1,k,v)MOD)MOD;  
        }  
        else  
        {  
            if(i+1<=m)  
            s=(s+dfs(i+1,j,k,v)MOD)MOD;  
            if(j+1<=n)  
            s=(s+dfs(i,j+1,k,v)MOD)MOD;  
        }  
        r[i][j][k][v+1]=s MOD;  
        return r[i][j][k][v+1];  
    }  
}  
int main()  
{  
//    freopen("data.in","r",stdin);  
//    freopen("data.out","w",stdout);  
    memset(r,-1,sizeof(r));  
    long long i,j,p,q;  
    cin>>m>>n>>num;  
    for(i=1;i<=m;i++)  
        for(j=1;j<=n;j++)  
            cin>>map[i][j];  
    dfs(1,1,0,-1);  
    cout<<r[1][1][0][0]<<endl;      
    return 0;  
}  
