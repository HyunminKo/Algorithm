#include <cstdio>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int N,K,dirSize;
vector<pair<int, int>> DirV;
queue<pair<int, int>> changeDirV;
queue<int> previousDirV;
int map[102][102];
const int EMPTY = 0;
const int PASS = 1;
const int APPLE = 2;
enum direction{
    UP = 0,
    RIGHT,
    DOWN,
    LEFT
};
int total_time = 1;
int direction = RIGHT;
int dx[4]={-1,0,1,0};
int dy[4]={0,1,0,-1};

int findNextDirection(int cD,int nD){
    int direction = -1;
    if(cD == UP){
        (nD == LEFT) ? direction = LEFT: direction = RIGHT;
    }else if(cD == RIGHT){
        (nD == LEFT) ? direction = UP: direction = DOWN;
    }else if(cD == DOWN){
        (nD == LEFT) ? direction = RIGHT: direction = LEFT;
    }else if(cD == LEFT){
        (nD == LEFT) ? direction = DOWN: direction = UP;
    }
    return direction;
}
int start(){
    int nx=0,ny=1,ex=0,ey=0,nextTime=0,temp=0,timeSize=0,length=1;
    
    timeSize = (int)DirV.size();
    if(timeSize!=0)
        nextTime = DirV[0].first;
    while(1){
        if(nx<0 || ny<0 || nx>=N || ny>=N)
            break;
        if(map[nx][ny] == PASS)
            break;
        if(map[nx][ny] == APPLE){
            map[nx][ny] = PASS;
            length++;
            if(length == 2){
                ex = nx;
                ey = ny;
                map[ex][ey] = PASS;
            }else{
                
            }
        }
        else if(map[nx][ny] == EMPTY){
            map[nx][ny] = PASS;
            int changeSize = (int) changeDirV.size();
            int preSize = (int) previousDirV.size();
            int preDirection = direction;
            int cx=-1,cy=-1;
            if(changeSize!=0 && preSize!=0){
                pair<int, int> temp = changeDirV.front();
                cx = temp.first;
                cy = temp.second;
                preDirection = previousDirV.front();
                if(ex == cx && ey == cy){
                    changeDirV.pop();
                    previousDirV.pop();
                }
            }
            if(length == 1){
                ex = nx;
                ey = ny;
                map[ex][ey] = EMPTY;
            }else{
                map[ex][ey] = EMPTY;
                ex = ex + dx[preDirection];
                ey = ey + dy[preDirection];
            }
        }
        if(total_time == nextTime){
            changeDirV.push(make_pair(nx, ny));
            previousDirV.push(direction);
            int dirVsize = (int) DirV.size();
            if(dirVsize!=0){
                int nextDirection = DirV[temp++].second;
                direction = findNextDirection(direction,nextDirection);
                if(temp<=timeSize)
                    nextTime = DirV[temp].first;
            }
        }
        nx = nx + dx[direction];
        ny = ny + dy[direction];
        total_time++;
    }
    return total_time;
}
int main(){
    scanf("%d",&N);
    scanf("%d",&K);
    for(int i = 0 ; i < K; i++){
        int x,y;
        scanf("%d %d",&x,&y);
        map[x-1][y-1] = APPLE;
    }
    scanf("%d",&dirSize);
    for(int i = 0 ; i < dirSize; i++){
        char dir;
        int time;
        scanf("%d %c",&time,&dir);
        if(dir == 'L')
            DirV.push_back(make_pair(time, LEFT));
        else
            DirV.push_back(make_pair(time, RIGHT));
    }
    printf("%d\n",start());
}
