#include <cstdio>
#include <iostream>

using namespace std;

int N;
int t[15];
int p[15];
int maxV = -1000000000;

void go(int d,int total){
    if(d == N){
        maxV = max(maxV,total);
        return;
    }
    go(d+1,total);
    if(d + t[d] <= N){
        go(d+t[d],total + p[d]);
    }
}
int main(){
    scanf("%d",&N);
    
    for(int i = 0 ; i< N; i++){
        scanf("%d",&t[i]);
        scanf("%d",&p[i]);
    }
    go(0,0);
    printf("%d\n",maxV);
    return 0;
}
