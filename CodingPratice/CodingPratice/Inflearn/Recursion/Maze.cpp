#include <cstdio>
#include <algorithm>
using namespace std;
int N,M;
int maze[100][100];
bool visited[100][100];
int dx[4]={-1,0,1,0};
int dy[4]={0,1,0,-1};
int minV = 1000000000;
void findMazePath(int x, int y, int cost){
    if(x==N-1 && y==M-1){
        minV = min(cost,minV);
        return ;
    }else{
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx <0 || ny < 0 || nx>=N || ny>= M) continue;
            if (maze[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            findMazePath(x+dx[i], y+dy[i], cost+1);
        }
    }
}
int main(){
    scanf("%d %d",&N,&M);
    
    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M; j++){
            scanf("%1d",&maze[i][j]);
        }
    }
    visited[0][0]=true;
    findMazePath(0, 0, 1);
    
    printf("%d\n",minV);
    return 0;
}
