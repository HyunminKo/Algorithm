#include <iostream>
#include <cstdio>

using namespace std;

int N,M;
int map[500][500];
int DP[500][500];
int dx[4]={-1,0,1,0};
int dy[4]={0,1,0,-1};

int dp(int x, int y) {
    if( x == N - 1 && y == M -1)
        return 1;
    if( DP[x][y] > -1 )
        return DP[x][y];
    if( DP[x][y] == -1 )
        DP[x][y] = 0;
    for(int i = 0 ; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if( nx >= 0 && ny >= 0 && nx < N && ny < M && map[x][y] > map[nx][ny])
            DP[x][y] += dp(nx,ny);
    }
    return DP[x][y];
}
int main(){
    scanf("%d %d",&N,&M);
    
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            scanf("%d",&map[i][j]);
            DP[i][j] = -1;
        }
    }
    
    printf("%d\n",dp(0,0));
    
    return 0;
}
