#include <cstdio>
#include <iostream>

char data[] = {'a','b','c','d','e','f'};
int N = 6;
bool include[6];

void powerSet(int k){
    if (k == N){
        for( int i = 0 ; i < N; i++)
            if (include[i]) printf("%c ",data[i]);
        printf("\n");
        return;
    }
    include[k] = false;
    powerSet(k+1);
    include[k] = true;
    powerSet(k+1);
}
int main(){
    powerSet(0);
    return 0;
}
