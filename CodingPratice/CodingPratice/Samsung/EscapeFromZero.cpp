#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N,M;
char map[12][12];
vector<pair<int,int>> locOfRed;
vector<pair<int,int>> locOfBlue;
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
    int Rx = locOfRed[0].first;
    int Ry = locOfRed[0].second;
    int Bx = locOfBlue[0].first;
    int By = locOfBlue[0].second;
    if(direction == LEFT){
        return Ry < By ? RED: BLUE;
    }else if(direction == RIGHT){
        return By < Ry ? RED: BLUE;
    }else if(direction == UP){
        return Rx < Bx ? RED : RIGHT;
    }else{
        return Rx > Bx ? RED : RIGHT;
    }
    return -1;
}
void backUp(char temp2[][12],char temp[][12]){
    locOfRed.clear();
    locOfBlue.clear();
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < M; j++){
            temp2[i][j]= temp[i][j];
            if(temp[i][j] == 'R')
                locOfRed.push_back(make_pair(i, j));
            else if(temp[i][j] == 'B')
                locOfBlue.push_back(make_pair(i, j));
        }
    }
}
void rotateAry(int direction, char ary[12],char temp[][12], int color){
    int x,y;
    if(color == RED){
        x = locOfRed[0].first;
        y = locOfRed[0].second;
    }else{
        x = locOfBlue[0].first;
        y = locOfBlue[0].second;
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
void updateMap(int direction, char ary[12], char temp[][12],int x, int y){
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
void move(int direction, char ary[12], char temp[][12], int color){
    int x,y;
    if(color == RED){
        x = locOfRed[0].first;
        y = locOfRed[0].second;
    }else{
        x = locOfBlue[0].first;
        y = locOfBlue[0].second;
    }
    int index;
    for(index = 0 ; index < 12; index++){
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
        locOfRed.clear();
        if(direction == UP){
            locOfRed.push_back(make_pair(index, y));
        }else if(direction == LEFT){
            locOfRed.push_back(make_pair(x, index));
        }else if(direction == RIGHT){
            locOfRed.push_back(make_pair(x, (M-1)-index));
        }else{
            locOfRed.push_back(make_pair((N-1)-index, y));
        }
    }
    else{
        locOfBlue.clear();
        if(direction == UP){
            locOfBlue.push_back(make_pair(index, y));
        }else if(direction == LEFT){
            locOfBlue.push_back(make_pair(x, index));
        }else if(direction == RIGHT){
            locOfBlue.push_back(make_pair(x, (M-1)-index));
        }else{
            locOfBlue.push_back(make_pair((N-1)-index, y));
        }
    }
    updateMap(direction, ary, temp, x, y);
}
void rotateAndMove(int direction,char ary[12],char temp2[][12],int order){
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
void go(int direction,int count, char temp[][12]){
    if(redSuccess == true && blueSuccess == false){
        minN = min(count,minN);
        redSuccess = false;
        return;
    }else if(blueSuccess == true){
        blueSuccess = false;
        redSuccess = false;
        return;
    }else if(count >= 11){
        blueSuccess = false;
        redSuccess = false;
        return;
    }
    char temp2[12][12];
    backUp(temp2, temp);
    char ary[12];
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
        for(int j = 0; j <M; j++){
            scanf(" %c",&map[i][j]);
            if(map[i][j] == 'R')
                locOfRed.push_back(make_pair(i, j));
            else if(map[i][j] == 'B')
                locOfBlue.push_back(make_pair(i, j));
        }
    }
    for(int i = 0 ; i < 4; i++){
        locOfRed.clear();
        locOfBlue.clear();
        char temp2[12][12];
        for(int i = 0 ; i < N; i++){
            for(int j =0 ; j < N; j++){
                temp2[i][j]= map[i][j];
                if(map[i][j] == 'R')
                    locOfRed.push_back(make_pair(i, j));
                else if(map[i][j] == 'B')
                    locOfBlue.push_back(make_pair(i, j));
            }
        }
        char ary[12];
        int order = findOrder(i);
        rotateAndMove(i, ary, temp2, order);
        go(i,1,temp2);
    }
    if(minN == 1000000000)
        minN = -1;
    printf("%d\n",minN);
    return 0;
}
