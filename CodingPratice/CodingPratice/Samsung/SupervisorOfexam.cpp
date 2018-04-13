#include <cstdio>
#include <algorithm>
using namespace std;
int N,B,C;
long long result = 0 ;
int examClass[1000001];
int cal(int n){
    if(n<=0)
        return 0;
    if(n%C == 0)
        return (n/C);
    else
        return (n / C) + 1;
}
long long go(int examClass[1000001]){
    long long temp =0;
    for(int i = 0 ; i < N; i++){
        temp += cal(examClass[i]);
    }
    return temp;
}
int main(){
    scanf("%d",&N);
    for(int i = 0 ; i < N; i++){
        scanf("%d",&examClass[i]);
    }
    scanf("%d %d",&B,&C);
    result += N;
    for(int i = 0 ; i < N; i++){
        examClass[i] -= B;
    }
    result += go(examClass);
    printf("%lld\n",result);
}
