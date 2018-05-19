#include <cstdio>
#include <algorithm>
using namespace std;
int N,result;
void cal(int n){
    if(n<0)
        return;
    if(n==0){
        result++;
        return;
    }
    cal(n-1);
    cal(n-2);
    cal(n-3);
}
int go(int n){
    result = 0;
    cal(n);
    return result;
}
int main(){
    scanf("%d",&N);
    for(int i = 0; i < N; i++){
        int temp =0;
        scanf("%d",&temp);
        printf("%d\n",go(temp));
    }
}
