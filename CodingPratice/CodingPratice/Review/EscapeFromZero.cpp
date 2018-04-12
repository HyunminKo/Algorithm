#include <cstdio>
#include <iostream>
using namespace std;

int N,M;
char cM[11][11];
char map[11][11];
int minV = 1000000000;
int rx,ry,bx,by;
enum direction{
    UP =0,
    LEFT,
    DOWN,
    RIGHT
};
bool redSuccess;
bool blueSuccess;
bool blockDuplication(int nextDir,int currDir){
    if(currDir == nextDir)
        if(nextDir == UP)
            return false;
    if(currDir == UP)
        if(nextDir == DOWN)
            return false;
    if(currDir == LEFT)
        if(nextDir == RIGHT)
            return false;
    if(currDir == RIGHT)
        if(nextDir == LEFT)
            return false;
    if(currDir == DOWN)
        if(nextDir == UP)
            return false;
    return true;
}
void backMap(char currMap[][11],char originMap[][11]){
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            currMap[i][j] = originMap[i][j];
        }
    }
}
void copyAry(char currMap[][11], char ary[11],int direction,int x, int y){
    if(direction == UP){
        for(int i = 0 ; i < N; i++)
            ary[i] = currMap[i][y];
    }else if(direction == LEFT){
        for(int i = 0 ; i < M; i++)
            ary[i] = currMap[x][i];
    }else if(direction == DOWN){
        int j = 0;
        for(int i = N - 1; i>=0 ; i--)
            ary[j++] = currMap[i][y];
    }else if(direction == RIGHT){
        int j = 0;
        for(int i = M - 1; i>=0 ; i--)
            ary[j++] = currMap[x][i];
    }
}
void updateMap(char currMap[][11],char ary[11],int direction,int x, int y){
    if(direction == UP){
        for(int i = 0 ; i < N; i++)
            currMap[i][y] = ary[i];
    }else if(direction == LEFT){
        for(int i = 0 ; i < M; i++)
            currMap[x][i] = ary[i];
    }else if(direction == DOWN){
        int j = 0 ;
        for(int i = N - 1; i>=0 ; i--)
            currMap[i][y] = ary[j++];
    }else if(direction == RIGHT){
        int j = 0;
        for(int i = M - 1; i>=0 ; i--)
            currMap[x][i] = ary[j++];
    }
}
void moveBall(int x, int y, char color,int direction,char currMap[][11]){
    char ary[11];
    int startIndex = -1;
    copyAry(currMap,ary,direction,x,y);
    if(direction == UP)
        startIndex = x;
    else if(direction == DOWN)
        startIndex = (N-1)-x;
    else if(direction == RIGHT)
        startIndex = (M-1)-y;
    else
        startIndex = y;
    
    int endIndex =-1;
    for(int i = startIndex-1 ; i>= 0; i--){
        if(ary[i] == '#')
            break;
        else if(ary[i] == '.'){
            if(color == 'R'){
                ary[i] = 'R';
                endIndex = i;
            }
            else{
                ary[i] = 'B';
                endIndex = i;
            }
            ary[i+1] = '.';
        }else if(ary[i] == 'O'){
            if(color == 'R'){
                redSuccess = true;
                
            }
            else{
                blueSuccess = true;
            }
            ary[i+1] = '.';
            break;
        }else{
            if(color == 'R'){
                if(ary[i]=='B')
                    break;
            }else{
                if(ary[i] =='R')
                    break;
            }
        }
    }
    if(endIndex != -1){
        if(color == 'R'){
            if(direction == UP){
                ry = endIndex;
            }else if(direction == DOWN){
                ry = (N-1)-endIndex;
            }else if(direction == LEFT){
                rx = endIndex;
            }else{
                rx = (M-1)-endIndex;
            }
        }else{
            if(direction == UP){
                by = endIndex;
            }else if(direction == DOWN){
                by = (N-1)-endIndex;
            }else if(direction == LEFT){
                bx = endIndex;
            }else{
                bx = (M-1)-endIndex;
            }
        }
    }
    updateMap(currMap,ary,direction,x,y);
}
void rotateMove(int direction,char currMap[][11]){
    int order = 0;
    if(direction == UP)
        rx < bx ? order = 0: order = 1;
    else if(direction == DOWN)
        rx > bx ? order = 0: order = 1;
    else if(direction == LEFT)
        ry < by ? order = 0: order = 1;
    else
        ry > by ? order = 0: order = 1;
    
    if(order == 0){
        moveBall(rx,ry,'R',direction,currMap);
        moveBall(bx,by,'B',direction,currMap);
    }else{
        moveBall(bx,by,'B',direction,currMap);
        moveBall(rx,ry,'R',direction,currMap);
    }
    
}
void go(int direction,int count,char currMap[][11]){
    if(count >= 11){
        redSuccess = false;
        blueSuccess = false;
        return ;
    }
    rotateMove(direction,currMap);//방향 움직이기
    if(redSuccess){//성공 여부 확인
        if(blueSuccess){
            redSuccess = false;
            blueSuccess = false;
            return ;
        }else{
            minV = min(minV,count);
            redSuccess = false;
            return ;
        }
    }else if(blueSuccess){
        blueSuccess = false;
        return ;
    }
    for(int i = 0 ; i < 4; i++){
        if(blockDuplication(i,direction)){
            char tempMap[11][11];
            backMap(tempMap, currMap);
            go(i,count+1,tempMap);//다음 방향 돌리기
        }
    }
    
}
int main(){
    scanf("%d %d",&N,&M);
    for(int i = 0 ; i < N; i++){
        scanf("%s",map[i]);
    }
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            cM[i][j] = map[i][j];
            if(map[i][j] == 'R'){
                rx = i;
                ry = j;
            }else if(map[i][j]=='B'){
                bx = i;
                by = j;
            }
        }
    }
    int rx_b = rx;
    int ry_b = ry;
    int bx_b = bx;
    int by_b = by;
    for(int i = 0 ; i < 4; i++){
        backMap(cM,map);
        rx = rx_b;
        ry = ry_b;
        bx = bx_b;
        by = by_b;
        redSuccess = false;
        blueSuccess = false;
        go(i,1,cM);
    }
    if(minV == 1000000000)
        printf("%d\n",-1);
    else
        printf("%d\n",minV);
}
