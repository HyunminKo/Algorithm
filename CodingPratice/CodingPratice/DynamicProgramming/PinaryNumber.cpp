#include <cstdio>
#include <iostream>
using namespace std;

int N;
const int MAX_N = 91;

int main(){
    scanf("%d",&N);
    
    long long int d[MAX_N];
    d[0] = 0;
    d[1] = 1;
    for(int i = 2; i <= N;i++){
        d[i] = d[i-2] + d[i-1];
    }
    printf("%lld\n",d[N]);
}
