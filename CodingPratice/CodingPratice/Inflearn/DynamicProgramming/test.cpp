#include <iostream>
#include <cstdio>

using namespace std;

int arr[5]={2,3,4,5,1};
bool check[5];
void go(int i, int k){
    if( k == 5){
        for(int i = 0 ; i < 5; i++){
            if(check[i]) printf("%d ",arr[i]);
        }
        printf("\n");
        return ;
    }
    check[i] = true;
    go(i+1,k+1);
    check[i] = false;
    go(i+1,k+1);
}
int main(){
    for(int i = 0 ; i < 5; i ++)
        go(i,0);
}
