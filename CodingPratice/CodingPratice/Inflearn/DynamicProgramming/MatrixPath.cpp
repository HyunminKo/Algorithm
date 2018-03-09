#include <iostream>
#include <cstdio>

using namespace std;

int DP[100][100];
int map[100][100];
int N,M;
int dp(int x, int y){
    for(int i = 0 ; i <= x; i++){
        for(int j = 0 ; j <= y; j++){
            if(i == 0 && j == 0)
                DP[i][j] = map[i][j];
            else if(i == 0)
                DP[i][j] = DP[i][j-1] + map[i][j];
            else if(j == 0)
                DP[i][j] = DP[i-1][j] + map[i][j];
            else
                DP[i][j] = min(DP[i-1][j],DP[i][j-1])+map[i][j];
        }
    }
    return DP[x][y];
}
int main(){
    scanf("%d %d",&N,&M);
    
    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M; j++){
            scanf("%d",&map[i][j]);
            DP[i][j] = -1;
        }
    }
    
    printf("%d\n",dp(3,3));
    
    return 0;
}
