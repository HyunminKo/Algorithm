#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

const int MAX = 10001;
int numAry[MAX]={0,};

void self(int n){
    int sum=0, temp = n;
    sum += n;
    while(temp>0){
        sum += temp % 10;
        temp = temp/10;
    }
    numAry[sum]=1;
}

int main(){
    for(int i = 1; i < MAX; i++){
       self(i);
    }

    for(int i = 1 ; i < MAX; i++){
        if(numAry[i]==0)
            printf("%d\n",i);
    }
    return 0;
}

