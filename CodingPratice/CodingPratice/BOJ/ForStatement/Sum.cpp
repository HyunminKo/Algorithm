#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main(){
    int N,sum=0;
    scanf("%d",&N);
    
    for(int i = 1 ; i <= N ; i++){
        sum += i;
    }
    printf("%d\n",sum);
}