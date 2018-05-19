#include <iostream>
#include <cstdio>
#include <string>
using namespace std;
bool isHan(int n){
    if(n<100)
        return true;
    if(n>=1000)
        return false;
    string str = to_string(n);
    if((str[0]-'0')-(str[1]-'0') == (str[1]-'0') - (str[2]-'0'))
        return true;
    else
        return false;
}
int main(){
    int N;
    int count=0;
    scanf("%d",&N);
    
    for(int i = 1 ; i <= N; i++){
        if(isHan(i))
            count++;
    }
    printf("%d\n",count);
}
