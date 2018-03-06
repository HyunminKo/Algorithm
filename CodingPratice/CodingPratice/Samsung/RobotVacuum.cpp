#include <cstdio>
#include <utility>
#include <stdlib.h>

using namespace std;
int N,M,r,c,d,count=1;
int map[50][50];
bool cleaned[50][50];
int directionOfRotation[4]={3,0,1,2};
bool isCleanedOrWall(int i , int j){
    if(cleaned[i][j] || map[i][j] == 1 || i<0 || j<0 || i>= N || j>= M)
        return true;
    else
        return false;
}
pair<int, int> isBack(int i , int j , int d){
    int ni=0,nj=0;
    switch (d) {
        case 0:
            ni = i+1;
            nj = j;
            break;
        case 1:
            ni = i;
            nj = j-1;
            break;
        case 2:
            ni = i-1;
            nj = j;
            break;
        case 3:
            ni = i;
            nj = j+1;
            break;
    }
    if( ni < 0 || nj < 0 || ni>=N || nj>=M){
        return make_pair(-1, -1);
    }else{
        if(map[ni][nj]==1)
            return make_pair(-1, -1);
        else
            return make_pair(ni, nj);
    }
}
pair<int,int> nextIndex(int i, int j, int d){
    pair<int, int> temp;
    switch (d) {
        case 0:
            temp = make_pair(i, j-1);
            break;
        case 1:
            temp = make_pair(i-1, j);
            break;
        case 2:
            temp = make_pair(i, j+1);
            break;
        case 3:
            temp = make_pair(i+1, j);
            break;
        default:
            temp = make_pair(-1, -1);
            break;
    }
    return temp;
}
void clean(int i ,int j ,int d){
    if(!cleaned[i][j])
        count++;
    cleaned[i][j] = true;
    pair<int, int> temp = nextIndex(i, j, d);
    if(!isCleanedOrWall(temp.first, temp.second)){
        clean(temp.first, temp.second, directionOfRotation[d]);
    }else{
        int temp2 = d;
        for(int k = 0; k < 4; k++){
            pair<int, int> temp = nextIndex(i, j, temp2);
            if(!isCleanedOrWall(temp.first, temp.second)){
                clean(temp.first, temp.second, directionOfRotation[temp2]);
                return ;
            }
            temp2 = directionOfRotation[temp2];
        }
        temp2 = d;
        int isFinal = 0;
        for(int k = 0 ; k < 4 ; k++){
            
            pair<int, int> temp = isBack(i, j, temp2);
            if(temp.first == -1){
                isFinal++;
                for(int k = 0; k < 4; k++){
                    pair<int, int> temp = nextIndex(i, j, temp2);
                    if(isCleanedOrWall(temp.first, temp.second)){
                        isFinal++;
                    }
                    temp2 = directionOfRotation[temp2];
                }
                if(isFinal>=4){
                    printf("%d\n",count);
                    exit(0);
                }
            }else{
                clean(temp.first, temp.second, d);
            }
            temp2 = directionOfRotation[temp2];

        }
    }
}
int main(){
    
    scanf("%d %d",&N,&M);
    scanf("%d %d %d",&r,&c,&d);
    for( int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M;j++){
            scanf("%d",&map[i][j]);
        }
    }
    cleaned[r][c]=true;
    clean(r,c,d);
    return 0;
}
