#include <iostream>
#include <cstdio>
using namespace std;
const int kg5 = 5;
const int kg3 = 3;

int main(){
    int N;
    int temp;
    int bagCount=0;

    scanf("%d",&N);
    temp = N;
    while( temp - kg5 >= 0){
        temp = temp - kg5;
        bagCount++;
    }
    if(temp != 0 ){
        while( temp - kg3 >= 0){
            temp = temp - kg3;
            bagCount++;
        }
        if(temp!=0){
            temp = N;
            bagCount=0;
            while(temp - kg3 >= 0){
                temp = temp - kg3;
                bagCount++;
                if(temp % kg5 == 0){
                    bagCount += temp / kg5;
                    temp = temp % kg5;
                }
            }
            if(temp != 0){
                printf("%d\n",-1);
            }else{
                printf("%d\n",bagCount);
            }
        }else{
            printf("%d\n",bagCount);
        }
    }else{
        printf("%d\n",bagCount);
    }
    
}
