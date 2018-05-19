#include <cstdio>
#include <algorithm>
using namespace std;
int N,countVal=0;
int cal(int n){
    int temp=0;
    while(n>0){
        n = n / 10;
        temp++;
    }
    return temp;
}
int main(){
    scanf("%d",&N);
    for(int i = 1; i<=N; i++){
        countVal+=cal(i);
    }
    printf("%d\n",countVal);
}
