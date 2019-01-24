#include <string>
#include <vector>
using namespace std;

class Solution{
public:
    static int N,M,result;
    static int map[48][48];
    const int BLACK = 0, WHITE = 1;
    int coverType[4][4][2] = {
        {{0,0},{0,1},{1,0}},
        {{0,0},{0,1},{1,1}},
        {{0,0},{1,0},{1,1}},
        {{0,0},{1,0},{1,-1}}
    };
    int cornerIndexByType[4][2] = {
        {0,0},
        {0,1},
        {1,0},
        {1,0}
    };
    bool set(int map[][48], int x, int y, int type, int delta) {
        bool flag = true;
        int cx = x + cornerIndexByType[type][0];
        int cy = y + cornerIndexByType[type][1];
        if(cx < 0 || cy < 0 || cx >= N || cy >= M) {
            return false;
        }
        if( (cx + cy) % 2 != 0){
            return false;
        }
        for(int i = 0 ; i < 3; i++){
            int nx = x + coverType[type][i][0];
            int ny = y + coverType[type][i][1];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1) {
                flag = false;
                break;
            }
            if(map[nx][ny] >= 1){
                flag = false;
                break;
            }
        }
        if(flag){
            fillTheType(map, x, y, type, delta);
        }
        
        return flag;
    }
    
    void fillTheType(int map[][48], int x, int y, int type, int delta) {
        for(int i = 0 ; i < 3; i++){
            int nx = x + coverType[type][i][0];
            int ny = y + coverType[type][i][1];
            map[nx][ny] += delta;
        }
    }
    void cover(int x, int y, int map[][48], int count, int color) {
        int startIndex= -1, endIndex = -1;
        if(count > result){
            result = count;
        }
        if(map[x][y] != 0)
            return;
        if(color == BLACK){
            startIndex = 0;
            endIndex = 1;
        } else if(color == WHITE){
            startIndex = 1;
            endIndex = 4;
        }
        for(int type = startIndex ; type < endIndex; type++){
            if(set(map,x,y,type,1)){
                for(int i = x; i < N-1; i++){
                    for(int j = 0 ; j < M; j++){
                        if(i == x){
                            if(j <= y) continue;
                        }
                        if((i + j) % 2 == 0){
                            cover(i, j, map, count + 1, BLACK);
                        }else {
                            cover(i, j, map, count + 1, WHITE);
                        }
                    }
                }
                fillTheType(map, x, y, type, -1);
            }
        }
        return ;
    }
    int solution(vector<string> board){
        N = int(board.size());
        M = int(board[0].size());
        
        for(int i = 0 ; i < N; i++){
            string line = board[i];
            for(int j = 0 ; j < M; j++){
                if(line.at(j) == 'X'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = 0;
                }
            }
        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if((i + j) % 2 == 0){
                    cover(i,j,map,0,BLACK);
                }else {
                    cover(i,j,map,0,WHITE);
                }
            }
        }
        return result;
    }
};


