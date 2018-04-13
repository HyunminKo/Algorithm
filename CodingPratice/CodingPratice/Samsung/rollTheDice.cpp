#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
int N,M,X,Y,K;
int map[21][21];
vector<int> instructionV;
int dx[5]={0,0,0,-1,1};
int dy[5]={0,1,-1,0,0};
int dice[6] = {0,0,0,0,0,0};
enum direction{
    RIGHT=1,
    LEFT,
    UP,
    DOWN
};
void updateDiceByRoll(int direction){
    int x1,x2,x3,x4;
    if(direction == DOWN){
        x1 = dice[1]; x2 = dice[2]; x3=dice[3]; x4=dice[0];
        dice[0] = x1; dice[1] = x2; dice[2] = x3; dice[3] = x4;
    }else if(direction == UP){
        x1 = dice[3]; x2 = dice[0]; x3=dice[1]; x4=dice[2];
        dice[0] = x1; dice[1] = x2; dice[2] = x3; dice[3] = x4;
    }else if(direction == LEFT){
        x1 = dice[5]; x2 = dice[4]; x3=dice[0]; x4=dice[2];
        dice[0] = x1; dice[2] = x2; dice[4] = x3; dice[5] = x4;
    }else if(direction == RIGHT){
        x1 = dice[4]; x2 = dice[5]; x3=dice[2]; x4=dice[0];
        dice[0] = x1; dice[2] = x2; dice[4] = x3; dice[5] = x4;
    }
}
void updateDiceByCopy(int x, int y){
    //위: dice[0], 바닥: dice[2]
    if(map[x][y] == 0){
        map[x][y] = dice[2];
    }else{
        dice[2] = map[x][y];
        map[x][y]=0;
    }
    printf("%d\n",dice[0]);
}
void roll(int n,int x, int y){
    if(n == K)
        return ;
    int direction = instructionV[n];
    int nx = x + dx[direction];
    int ny = y + dy[direction];
    if(nx < 0 || ny < 0 || nx >= N || ny >= M)
        roll(n+1,x,y);
    else{
        updateDiceByRoll(direction);
        updateDiceByCopy(nx,ny);
        roll(n+1,nx,ny);
    }
}
int main(){
    scanf("%d %d %d %d %d",&N,&M,&X,&Y,&K);
    for(int i = 0 ;i < N; i++){
        for(int j = 0 ; j <M; j++){
            scanf("%d",&map[i][j]);
        }
    }
    for(int i = 0 ; i < K; i++){
        int temp;
        scanf("%d",&temp);
        instructionV.push_back(temp);
    }
    roll(0,X,Y);
}
