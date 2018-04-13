#include <cstdio>
#include <iostream>

using namespace std;

int T,N;
const int MAX = 100001;
int value[2][MAX];
int dp[MAX][3];
int sticker(int c, int status){
    if (c == N) return 0;
    if (dp[c][status]!=-1) return dp[c][status];
    int result = sticker(c+1,0);
    if(status != 1){
        result = max(result,sticker(c+1,1)+value[0][c]);
    }
    if(status != 2){
        result = max(result,sticker(c+1,2)+value[1][c]);
    }
    dp[c][status] = result;
    return result;
}
int main(){
    scanf("%d",&T);
    for(int i = 0 ; i < T; i++){
        scanf("%d",&N);
        for(int j = 0 ; j < 2; j++){
            for(int k = 0 ; k < N; k++){
                scanf("%d",&value[j][k]);
            }
        }
        for(int j = 0 ; j < N; j++){
            for(int k = 0 ; k < 3; k++){
                dp[j][k]=-1;
            }
        }
        printf("%d\n",sticker(0,0));
    }
    
}
