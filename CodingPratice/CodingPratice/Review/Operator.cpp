#include <cstdio>
#include <algorithm>
using namespace std;
int N;
int p,s,m,d;
int operand[12];
int minV = 1000000000,maxV = -1000000000;
void go(int plus,int sub,int mul,int div,int n, int total){
    if(n == N){
        minV = min(total,minV);
        maxV = max(total,maxV);
        return ;
    }
    if(plus<p)
        go(plus+1,sub,mul,div,n+1,total+operand[n]);
    if(sub<s)
        go(plus,sub+1,mul,div,n+1,total-operand[n]);
    if(mul<m)
        go(plus,sub,mul+1,div,n+1,total*operand[n]);
    if(div<d)
        go(plus,sub,mul,div+1,n+1,total/operand[n]);
}
int main(){
    scanf("%d",&N);
    for(int i = 0 ; i < N; i++){
        scanf("%d",&operand[i]);
    }
    scanf("%d %d %d %d",&p,&s,&m,&d);
    go(0,0,0,0,1,operand[0]);
    printf("%d\n%d\n",maxV,minV);
}
