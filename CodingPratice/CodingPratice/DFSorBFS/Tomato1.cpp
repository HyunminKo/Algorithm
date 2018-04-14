#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int N,M;
int box[1001][1001];
bool a[1001][1001];
int result = -1;
int aT =0;
vector<pair<int, int> > T;
int dx[4]={-1,0,1,0};
int dy[4]={0,1,0,-1};
void bfs(pair<int,int> loc){
    queue<pair<int,int>> q;
    a[loc.first][loc.second] = true;
    q.push(loc);
    
    while(!q.empty()){
        pair<int, int> temp = q.front(); q.pop();
        int x = temp.first;
        int y = temp.second;

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M || box[nx][ny] == -1 || a[nx][ny]) continue;
            if(box[nx][ny] > box[x][y] + 1 || box[nx][ny] == 0){
                aT--;
                box[nx][ny] = box[x][y]+1;
                q.push(make_pair(nx, ny));
            }
        }
    }
}
int main(){
    scanf("%d %d",&M,&N);
    for(int i = 0 ; i < N; i++){
        for(int j = 0 ; j < M; j++){
            scanf("%d",&box[i][j]);
            if(box[i][j] == 0)
                aT++;
            else if(box[i][j]==1){
                T.push_back(make_pair(i, j));
            }
        }
    }
    if(aT == 0){
        printf("%d\n",0);
    }else{
        int vSize = (int) T.size();
        for(int i = 0 ; i < vSize; i++){
            bfs(T[i]);
            for(int i = 0 ; i <N; i++){
                for(int j = 0 ; j < M;j++){
                    a[i][j] = false;
                }
            }
        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                result = max(result,box[i][j]);
                if(box[i][j]==0){
                    printf("%d\n",-1);
                    return 0;
                }
            }
        }
        printf("%d\n",result-1);
    }
}
