#include <cstdio>
#include <iostream>
#include <queue>
using namespace std;

int N,M,startV;
int v[1001];
int a[1001][10001];
bool bfs_visited[1001];
bool dfs_visited[1001];

void dfs(int v){
    printf("%d ",v);
    dfs_visited[v] = true;
    for(int i = 1 ; i <= N; i++){
        if(a[v][i])
            if(!dfs_visited[i])
                dfs(i);
    }
}
void bfs(int v){
    queue<int> q;
    bfs_visited[v] = true;
    q.push(v);
    while(!q.empty()){
        int u = q.front();
        q.pop();
        printf("%d ",u);
        for( int i = 1 ; i <= N; i++){
            if(a[u][i])
                if(!bfs_visited[i]){
                    bfs_visited[i]=true;
                    q.push(i);
                }
        }
    }
}
int main(){
    scanf("%d %d %d",&N,&M,&startV);
    for(int i = 0 ; i < M; i++){
        int u,v;
        scanf("%d %d",&u,&v);
        a[u][v] = true;
        a[v][u] = true;
    }
    dfs(startV);
    printf("\n");
    bfs(startV);
    printf("\n");
    return 0;
}
