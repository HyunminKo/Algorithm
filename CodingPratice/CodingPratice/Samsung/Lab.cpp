#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;
int N,M;
int map[8][8];
int copyMap[8][8];
int tempMap[8][8];
int dx[4] ={-1,0,1,0};
int dy[4] ={0,1,0,-1};
const int EMPTY = 0;
const int WALL = 1;
const int VIRUS = 2;
const int ALREADY_INFECTED = 3;
int safeZoneCount = 0;
int maxV = -1000000000;
vector<pair<int, int>> infectV;

void infect(int x , int y){
    if(x < 0 || y < 0 || x>=N || y>=M)
        return;
    if(tempMap[x][y] == WALL || tempMap[x][y] == ALREADY_INFECTED)
        return;
    else{
        if(tempMap[x][y] == VIRUS)
            tempMap[x][y] = ALREADY_INFECTED;
        else
            tempMap[x][y] = VIRUS;
        
        for(int i = 0 ; i<4;i++)
            infect(x+dx[i], y+dy[i]);
    }
}
void recover() {
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            map[i][j] = copyMap[i][j];
        }
    }
}

void safeZone() {
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            if(tempMap[i][j] == EMPTY)
                safeZoneCount++;
        }
    }
    maxV = max(maxV,safeZoneCount);
    safeZoneCount = 0;
}

void guard(int k){
    if (k == 3) {
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                tempMap[i][j] = map[i][j];
            }
        }
        for(auto item : infectV){
            infect(item.first, item.second);
        }
        safeZone();
        return;
    }
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            if(map[i][j] == VIRUS || map[i][j] == WALL) continue;
            map[i][j] = 1;
            guard(k+1);
            map[i][j] = 0;
        }
    }
}
int main(){
    scanf("%d %d",&N,&M);
    
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            scanf("%d",&map[i][j]);
            copyMap[i][j] = map[i][j];
            if(map[i][j] == VIRUS){
                infectV.push_back(make_pair(i, j));
            }
        }
    }
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            if(map[i][j] == VIRUS || map[i][j] == WALL) continue;
            recover();
            map[i][j] = 1;
            guard(1);
            map[i][j] = 0;
        }
    }
    printf("%d\n",maxV);
    return 0;
}
