#include <iostream>
#include <cstdio>

using namespace std;
int f[100];
int fib(int n){
    f[1] = f[2] = 1;
    for( int i = 3; i<=n;i++)
        f[i] = f[i-1] + f[i-2];
    return f[n];
}
int main(){
    printf("%d\n",fib(10));
    return 0;
}

