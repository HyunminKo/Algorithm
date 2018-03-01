#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;
int maxV = -1000000000;
int N,M,count,temp=0;
int ary[501][501];
vector<pair<int,int>> locationV;

void go(int count, int i, int j,int total){
    if(temp >= 4){
        temp = 0;
        if((int)locationV.size()!=0)
            locationV.pop_back();
    }
    if(i<0 || j<0 ||i >= N || j >= M){
        return;
    }
    for(int k = 0 ; k < (int)locationV.size();k++){
        if( i == locationV[k].first && j == locationV[k].second){
            return;
        }
    }
    if(count == 4){
        maxV = max(maxV,total);
        return;
    }
    locationV.push_back(make_pair(i, j));
    go(count + 1, i, j+1,total + ary[i][j+1]); // right
    temp++;
    go(count + 1, i+1, j,total + ary[i+1][j]); // down
    temp++;
    go(count + 1, i, j-1,total + ary[i][j-1]); // left
    temp++;
    go(count + 1, i-1, j,total + ary[i-1][j]); // up
    temp++;
}
void others(int i, int j){
    int temp =0;
    if(!(i - 1 < 0 || i + 1 >= N || j+1 >= M)){
        temp = ary[i][j] + ary[i-1][j] + ary[i][j+1] + ary[i+1][j];
        maxV = max(maxV,temp);
    }
    if(!(i - 1 < 0 || j - 1 < 0 || i+1 >= N)){
        temp = ary[i][j] + ary[i-1][j] + ary[i][j-1] + ary[i+1][j];
        maxV = max(maxV,temp);
    }
    if(!(j - 1 < 0 || i + 1 >= N || j+1 >= M)){
        temp = ary[i][j] + ary[i+1][j] + ary[i][j+1] + ary[i][j-1];
        maxV = max(maxV,temp);
    }
    if(!(i - 1 < 0 || j - 1 < 0 || j+1 >= M)){
        temp = ary[i][j] + ary[i-1][j] + ary[i][j+1] + ary[i][j-1];
        maxV = max(maxV,temp);
    }
    
}
int main(){
    scanf("%d %d",&N,&M);
    
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            scanf("%d",&ary[i][j]);
        }
    }
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            go(1,i,j,ary[i][j]);
            others(i, j);
        }
    }
    printf("%d\n",maxV);
    return 0;
}
