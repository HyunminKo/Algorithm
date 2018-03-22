#include <iostream>
#include <cstdio>

using namespace std;

int map[20][20];
int N;
const int UP = 0;
const int LEFT = 1;
const int DOWN = 2;
const int RIGHT = 3;

void go(int direction, int count){
    if(count==6)
        return;
    
    
    go(UP,count+1);
    go(LEFT,count+1);
    go(DOWN,count+1);
    go(RIGHT,count+1);
}
int main(){
    scanf("%d",&N);
    for(int i = 0 ; i < N ; i ++){
        for(int j = 0 ; j < N; j++){
            scanf("%d",&map[i][j]);
        }
    }
    for(int i = 0 ; i < 4; i++){
        go(i,1);
    }
}
