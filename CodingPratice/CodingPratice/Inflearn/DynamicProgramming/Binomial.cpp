#include <cstdio>
#include <iostream>

using namespace std;
int binom[100][100];

int binomial(int n, int k){
    binom[0][0] = binom[1][0] = binom[1][1] = 1;
    for(int i = 2 ; i <= n; i++){
        for(int j = 0 ; j <= k && j<= i ;j++){
            if( j==0 || i == j)
                binom[i][j] = 1;
            else
                binom[i][j] = binom[i-1][j-1] + binom[i-1][j];
        }
    }
    return binom[n][k];
}
int main(){
    for (int i = 0 ; i < 100; i++) {
        for(int j = 0 ; j < 100; j++)
            binom[i][j] = -1;
    }
    printf("%d\n",binomial(6, 2));
    return 0;
}
