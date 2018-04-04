#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N,M;
char map[20][20];
int rx,ry,bx,by;
bool redSuccess = false;
bool blueSuccess = false;
int minN = 1000000000;
enum Direction{
    UP = 0,
    LEFT,
    RIGHT,
    DOWN
};
enum ColorBall{
    RED = 0,
    BLUE
};
int findOrder(int direction){ //RED가 먼저면 0 리턴, BLUE가 먼저면 1리턴
    int nRx = rx;
    int nRy = ry;
    int nBx = bx;
    int nBy = by;
    if(direction == LEFT){
        if(nRx != nBx) return RED;
        return nRy < nBy ? RED: BLUE;
    }else if(direction == RIGHT){
        if(nRx != nBx) return RED;
        return nBy < nRy ? RED: BLUE;
    }else if(direction == UP){
        if(nRy != nBy) return RED;
        return nRx < nBx ? RED : RIGHT;
    }else{
        if(nRy != nBy) return RED;
        return nRx > nBx ? RED : RIGHT;
    }
    return -1;
}
void backUp(char temp2[][20],char temp[][20]){
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < M; j++){
            temp2[i][j]= temp[i][j];
            if(temp[i][j] == 'R'){
                rx = i;
                ry = j;
            }
            else if(temp[i][j] == 'B'){
                bx = i;
                by = j;
            }
        }
    }
}
void rotateAry(int direction, char ary[20],char temp[][20], int color){
    int x,y;
    if(color == RED){
        x = rx;
        y = ry;
    }else{
        x = bx;
        y = by;
    }
    if(direction == LEFT){
        for(int i = 0 ; i < M; i++){
            ary[i] = temp[x][i];
        }
    }else if(direction == RIGHT){
        int i = 0;
        for(int j = M-1 ; j >= 0; j--){
            ary[i++] = temp[x][j];
        }
    }else if(direction == UP){
        for(int i = 0 ; i < N; i++){
            ary[i] = temp[i][y];
        }
    }else if(direction == DOWN){
        int i = 0;
        for(int j = N-1 ; j >= 0; j--){
            ary[i++] = temp[j][y];
        }
    }
}
void updateMap(int direction, char ary[20], char temp[][20],int x, int y){
    if(direction == LEFT){
        for(int i = 0 ; i < M; i++){
            temp[x][i] = ary[i];
        }
    }else if(direction == RIGHT){
        int i = 0;
        for(int j = M-1 ; j >= 0; j--){
            temp[x][i++] = ary[j];
        }
    }else if(direction == UP){
        for(int i = 0 ; i < N; i++){
            temp[i][y] = ary[i];
        }
    }else if(direction == DOWN){
        int i = 0;
        for(int j = N-1 ; j >= 0; j--){
            temp[i++][y]=ary[j];
        }
    }
}
void move(int direction, char ary[20], char temp[][20], int color){
    int x,y;
    if(color == RED){
        x = rx;
        y = ry;
    }else{
        x = bx;
        y = by;
    }
    int index;
    for(index = 0 ; index < 20; index++){
        if(color ==RED){
            if(ary[index] == 'R') break;
        }else{
            if(ary[index] == 'B') break;
        }
    }
    for(int j = index-1; j >=0 ; j--){
        if(ary[j] == '#'){
            break;
        }else if(ary[j] == '.'){
            if(color ==RED){
                ary[j] = 'R';
                index = j;
            }
            else{
                ary[j] = 'B';
                index = j;
            }
            ary[j+1] = '.';
        }else if(ary[j] == 'O'){
            if(color == RED){
                redSuccess = true;
                index = j;
            }
            else if(color == BLUE){
                blueSuccess = true;
                index = j;
            }
            ary[j+1] = '.';
            break;
        }else if(ary[j] == 'R'){
            if(color == BLUE)
                break;
        }else if(ary[j] == 'B'){
            if(color == RED)
                break;
        }
    }
    if(color == RED){
        if(direction == UP){
            rx = index;
            ry = y;
        }else if(direction == LEFT){
            rx = x;
            ry = index;
        }else if(direction == RIGHT){
            rx = x;
            ry = (M-1)-index;
        }else{
            rx = (N-1)-index;
            ry = y;
        }
    }
    else{
        if(direction == UP){
            bx = index;
            by = y;
        }else if(direction == LEFT){
            bx = x;
            by = index;
        }else if(direction == RIGHT){
            bx = x;
            by = (M-1)-index;
        }else{
            bx = (N-1)-index;
            by = y;
        }
    }
    updateMap(direction, ary, temp, x, y);
}
void rotateAndMove(int direction,char ary[20],char temp2[][20],int order){
    if(order == RED){
        rotateAry(direction, ary, temp2,RED);
        move(direction,ary,temp2,RED);
        rotateAry(direction, ary, temp2,BLUE);
        move(direction,ary,temp2,BLUE);
    }else{
        rotateAry(direction, ary, temp2,BLUE);
        move(direction,ary,temp2,BLUE);
        rotateAry(direction, ary, temp2,RED);
        move(direction,ary,temp2,RED);
    }
}
void go(int direction,int count, char temp[][20]){
    if(count >= 11){
        blueSuccess = false;
        redSuccess = false;
        return;
    }
    else if(redSuccess == true && blueSuccess == false){
        minN = min(count,minN);
        redSuccess = false;
        return;
    }else if(blueSuccess == true){
        blueSuccess = false;
        redSuccess = false;
        return;
    }
    char temp2[20][20];
    backUp(temp2, temp);
    char ary[20];
    int order = findOrder(UP);
    rotateAndMove(UP,ary,temp2,order);
    go(UP,count+1,temp2); //UP
    backUp(temp2, temp);
    order = findOrder(LEFT);
    rotateAndMove(LEFT, ary, temp2, order);
    go(LEFT,count+1,temp2); //LEFT
    backUp(temp2, temp);
    order = findOrder(RIGHT);
    rotateAndMove(RIGHT, ary, temp2, order);
    go(RIGHT,count+1,temp2); //RIGHT
    backUp(temp2, temp);
    order = findOrder(DOWN);
    rotateAndMove(DOWN, ary, temp2, order);
    go(DOWN,count+1,temp2); //DOWN
}
int main(){
    scanf("%d %d",&N,&M);
    for(int i = 0; i <N; i++){
        scanf("%s",map[i]);
    }
    for(int i = 0 ; i < 4; i++){
        char temp2[20][20];
        for(int i = 0 ; i < N; i++){
            for(int j =0 ; j < M; j++){
                temp2[i][j]= map[i][j];
                if(map[i][j] == 'R'){
                    rx=i;
                    ry=j;
                }
                else if(map[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }
        char ary[20];
        int order = findOrder(i);
        rotateAndMove(i, ary, temp2, order);
        go(i,1,temp2);
    }
    if(minN == 1000000000)
        minN = -1;
    printf("%d\n",minN);
    return 0;
}

