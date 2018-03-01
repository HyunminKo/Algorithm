#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;
int minV = 1000000000, maxV = -1000000000;
int n,num[11],p,s,m,d;
void dfs(int index, int plus, int sub, int mul, int div,int sum){
    if(index == n){
        minV = min(minV,sum);
        maxV = max(maxV,sum);
        return ;
    }
    if(plus < p)
        dfs(index + 1,plus +1,sub,mul,div, sum + num[index]);
    if(sub < s)
        dfs(index + 1,plus,sub+1,mul,div,sum - num[index]);
    if(mul < m)
        dfs(index + 1,plus,sub,mul+1,div,sum * num[index]);
    if(div < d)
        dfs(index + 1,plus,sub,mul,div+1,sum / num[index]);
}
int main(){
    scanf("%d",&n);
    for(int i = 0 ; i < n; i++){
        scanf("%d",&num[i]);
    }
    scanf("%d %d %d %d",&p,&s,&m,&d);
    
    dfs(1,0,0,0,0,num[0]);
    
    printf("%d\n%d\n",maxV,minV);
    
    return 0;
}



