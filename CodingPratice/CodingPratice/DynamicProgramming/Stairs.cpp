#include <cstdio>
#include <algorithm>

using namespace std;
int N;
int FAIL = -1000000000;
int score[301];
int dp[301][4];
int stairs(int f, int status, int count){
    if(f>N) return FAIL;
    if(f==N) return score[N];
    if(dp[f][status] != -1) return dp[f][status];
    int result = 0;
    if(count+1<=2)
        result = max(result,stairs(f+1,1,count+1) + score[f+1]);
    count = 0;
    result = max(result, stairs(f+2, 2, count+1)+score[f+2]);
    dp[f][status] = result;
    return result;
}
int main(){
    scanf("%d",&N);
    for(int i = 1 ; i <= N; i++){
        scanf("%d",&score[i]);
    }
    for(int i = 0 ; i <= N; i++){
        for(int j = 0 ; j <= 3; j++){
            dp[i][j] = -1;
        }
    }
    printf("%d\n",stairs(0, 0, 0));
    
}
