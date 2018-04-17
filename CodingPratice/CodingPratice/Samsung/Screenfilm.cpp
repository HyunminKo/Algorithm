#include <cstdio>
#include <algorithm>
using namespace std;
int D,W,K;
int film[21][14];
bool checkPass[14];
bool visited[3][3];
int res[3][3];
void dfs(int n){
    if(n==3){
        int temp = 0;
        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j <3; j++){
                if(visited[i][j])
                    printf("%d: (%d,%d) ",temp++,i,j);
            }
        }
        printf("\n");
        return;
    }
    for(int i = 0 ; i < 3; i++){
        for(int j = 0 ; j < 3; j++){
            if(!visited[i][j]){
                visited[i][j] = true;
                res[n][j] = i;
                dfs(n+1);
                visited[i][j] = false;
            }
        }
    }
}
int main(){
    scanf("%d %d %d",&D,&W,&K);
    for(int i = 0 ; i < D; i++){
        for(int j = 0 ; j < W; j++){
            scanf("%d",&film[j][i]);
        }
    }
    printf("\n");
    for(int i = 0 ; i < D; i++){
        for(int j = 0 ; j < W; j++){
            printf("%d ",film[i][j]);
        }
        printf("\n");
    }
    printf("\n");
    
    dfs(0);
}
