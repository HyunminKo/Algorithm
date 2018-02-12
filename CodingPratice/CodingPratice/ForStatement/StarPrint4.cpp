#include <iostream>
#include <cstdio>

using namespace std;

int main(){
    int N;
    int i,j=1;
    scanf("%d",&N);
    
    for(i = 0; i < N;i++){
        for(int k = 1; k < j;k++){
            printf(" ");
        }
        for(int a = N-i; a > 0; a--){
            printf("*");
        }
        
        j++;
        printf("\n");
    }
}

