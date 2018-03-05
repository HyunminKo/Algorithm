#include <cstdio>

using namespace std;
int N,M;
int map[100][100];
const int BACKGROUND_COLOR = 0;
const int IMAGE_COLOR = 1;
const int ALREADY_COLOR = 2;
int countCells(int x, int y){
    if( x < 0 || y < 0 || x >= N || y >= M)
        return 0;
    else if(map[x][y]!=IMAGE_COLOR)
        return 0;
    else{
        map[x][y] = ALREADY_COLOR;
        return 1 + countCells(x-1, y) + countCells(x-1, y+1) + countCells(x, y+1) + countCells(x+1, y+1) + countCells(x+1, y) + countCells(x, y-1) + countCells(x, y-1) + countCells(x-1, y-1);
    }
}

int main(){
    
    return 0;
}
