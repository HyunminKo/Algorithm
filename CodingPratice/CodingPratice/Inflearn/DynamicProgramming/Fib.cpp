#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

vector<int> call;

int f[100];

int fib(int n){
    f[1] = f[2] = 1;
    for( int i = 3; i<=n;i++)
        f[i] = f[i-1] + f[i-2];
    return f[n];
}
int fibonacci(int n){
    call[n]++;
    if(n < 2) return n;
    return fibonacci(n-2) + fibonacci(n-1);
}
int main(){
    int N = 10;
    call.resize(N+1);
    printf("F(%d): %d\n", N, fibonacci(N));
    puts("호출 횟수");
    for(int i=0; i<=N; i++)
        printf("F(%d): %d회 호출\n", i, call[i]);
    return 0;
}

