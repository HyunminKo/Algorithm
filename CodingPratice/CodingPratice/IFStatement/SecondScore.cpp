#include <iostream>
#include <cstdio>
using namespace std;

int main(){
    int a,b,c;
    scanf("%d %d %d",&a,&b,&c);
    printf("%d\n",a > b ? (b > c ? b : (c > a ? a : c)):(c > b? b : (c > a? c : a)));
}
