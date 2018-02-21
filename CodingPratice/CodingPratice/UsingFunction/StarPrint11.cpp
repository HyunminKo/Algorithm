#include <iostream>
#include <cstdio>
using namespace std;

void makeStar(int x, int y, int n);
char arr[3072][6144];

int main(){
    int i , j , n;
    
    scanf("%d",&n);
    for(i = 0 ; i < n ; i++){
        for(j =0 ; j < 2 * n;j++){
            if(j == 2 * n - 1){
                arr[i][j]='\0';
            }else{
                arr[i][j]=' ';
            }
        }
    }
    makeStar(n-1,0,n);
    for(i = 0 ; i < n ; i++){
        for(j =0 ; j < 2 * n;j++){
                printf("%c",arr[i][j]);
        }
        printf("\n");
    }
    return 0;
}
void makeStar(int x, int y, int n){
    if (n == 3){
        arr[y][x]='*';
        arr[y+1][x-1] = '*';
        arr[y+1][x+1] = '*';
        arr[y+2][x-2] = '*';
        arr[y+2][x-1] = '*';
        arr[y+2][x] = '*';
        arr[y+2][x+1] = '*';
        arr[y+2][x+2] = '*';
        return ;
    }
    makeStar(x,y,n/2);
    makeStar(x - (n/2),y + (n/2), n/2);
    makeStar(x + (n/2),y + (n/2), n/2);
}
