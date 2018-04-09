#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;
int N;
vector<int> dp;

int go(int n){
    if(n == 1) return 0;
    if(dp[n] != -1) return dp[n];
    
    int result = go(n-1) + 1;
    if(n % 3 == 0){
        result = min(result,go(n/3)+1);
    }
    if(n % 2 == 0){
        result = min(result,go(n/2)+1);
    }
    dp[n] = result;
    return result;
}
int main(){
    scanf("%d",&N);
    dp.resize(N+1,-1);
    
    printf("%d\n",go(N));
}
