#include <cstdio>
using namespace std;
const int MAX_N = 1000001;
const int divideV = 15746;
int N;
int dp[MAX_N];
int main(){
    scanf("%d",&N);
    dp[1] = 1;
    dp[2] = 2;
    for(int i = 3; i <= N; i++){
        dp[i] = (dp[i-2] + dp[i-1])%divideV;
    }
    printf("%d\n",dp[N]);
}
