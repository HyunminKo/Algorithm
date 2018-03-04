#include <iostream>
#include <cstdio>

using namespace std;
int N,countN=0;

int isOk(int r,int c,int check[]){
    for(int i = 0 ; i < N; i++){
        if(check[i]<0) break;
        if(check[i]==c) return 0;
    }
    int tempI =r-1;
    int tempJ =c-1;
    while(tempI>-1){
        if(tempJ<0)
            break;
        if(check[tempI] == tempJ)
            return 0;
        tempI -= 1;
        tempJ -= 1;
    }
    tempI = r-1;
    tempJ = c+1;
    while(tempI>-1){
        if(tempJ>=N)
            break;
        if(check[tempI] == tempJ)
            return 0;
        tempI -= 1;
        tempJ += 1;
    }
    check[r] = c;
    return 1;
}
void dfs(int r,int check[]){
    if ( r == N - 1){
        countN++;
        
    }
    else{
        for(int c = 0 ; c < N; c++){
            if(isOk(r+1,c,check)){
                dfs(r+1,check);
            }
        }
    }
}
int main(){
    scanf("%d",&N);
    
    for(int c = 0 ; c < N; c++){
        int check[14];
        for (int i = 0 ; i < N; i++) {
            check[i]=-1000;
        }
        check[0] = c;
        dfs(0,check);
    }
    printf("%d\n",countN);
    return 0;
}
