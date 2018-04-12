#include <cstdio>
#include <algorithm>
#include <iostream>
using namespace std;

int N,M;
int map[501][501];
int maxV = -1000000000;
int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,-1,1};
bool c[501][501];

void go(int x, int y, int count, int total){
    if(count > 4)
        return ;
    if(count == 4){
        maxV = max(total,maxV);
        return ;
    }
    for(int i = 0 ; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx<0 || ny<0 || nx>= N || ny>= M) continue;
        if(c[nx][ny]) continue;
        c[nx][ny] = true;
        go(nx,ny,count+1,total+map[nx][ny]);
        c[nx][ny] = false;
    }
}
void other(int i, int j){
    int temp =0;
    if(!(i - 1 < 0 || i + 1 >= N || j+1 >= M)){
        temp = map[i][j] + map[i-1][j] + map[i][j+1] + map[i+1][j];
        maxV = max(maxV,temp);
    }
    if(!(i - 1 < 0 || j - 1 < 0 || i+1 >= N)){
        temp = map[i][j] + map[i-1][j] + map[i][j-1] + map[i+1][j];
        maxV = max(maxV,temp);
    }
    if(!(j - 1 < 0 || i + 1 >= N || j+1 >= M)){
        temp = map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j-1];
        maxV = max(maxV,temp);
    }
    if(!(i - 1 < 0 || j - 1 < 0 || j+1 >= M)){
        temp = map[i][j] + map[i-1][j] + map[i][j+1] + map[i][j-1];
        maxV = max(maxV,temp);
    }
    return ;
}
int main(){
    scanf("%d %d",&N,&M);
    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M; j++){
            scanf("%d",&map[i][j]);
        }
    }
    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M; j++){
            c[i][j] = true;
            go(i,j,1,map[i][j]);
            other(i,j);
            c[i][j] = false;
        }
    }
    printf("%d\n",maxV);
}
