#include <cstdio>
#include <algorithm>
using namespace std;
int N,M;
bool visited[9];
int res[9];
bool check(){
    for(int i = 0 ; i < M-1; i++){
        if(res[i]>=res[i+1]) return false;
    }
    return true;
}
void dfs(int n){
    if(n==M){
        if(check()){
            for(int i = 0 ; i < M; i++){
                printf("%d ",res[i]);
            }
            printf("\n");
        }
        return;
    }
    for(int i = 0 ; i < N; i++){
        if(!visited[i]){
            visited[i] = true;
            res[n] = i + 1;
            dfs(n+1);
            visited[i] = false;
        }
    }
    
}
int main(){
    scanf("%d %d",&N,&M);
    dfs(0);
}

