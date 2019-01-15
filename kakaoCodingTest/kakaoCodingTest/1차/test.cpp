#include <iostream>
#include <queue>
#include <cstdio>
#include <vector>
#include <cstring>
#include <string>
#include <math.h>
#include <algorithm>

using namespace std;

long double getMean(long double sum[],int a,int b,int size);

int main(void)
{
    long long dolls[501];
    long double sum[501] = {0,};
    long double squareSum[501] = {0,};
    long double longResult = 1000000000000.0;
    
    int n = 0, k = 0;
    
    scanf("%d %d", &n, &k);
    
    for(int i = 0 ; i < n ; i++){
        scanf("%lld",&dolls[i]);
    }
    for(int i = 0 ; i < n; i++){
        if(i == 0){
            sum[i] = (long double) dolls[i];
            squareSum[i] = (long double) dolls[i] * dolls[i];
        }else {
            sum[i] += (long double) dolls[i];
            sum[i] += sum[i-1];
            squareSum[i] = (long double) dolls[i] * dolls[i];
            squareSum[i] += squareSum[i-1];
        }
    }
    for(int i = 0 ; i < n; i++){
        for(int j = 0 ; j < n; j++){
            if(i > j) continue;
            if(j - i + 1 < k) continue;
            long double variance = getMean(squareSum,i,j,j - i + 1) - pow(getMean(sum,i,j, j - i + 1),2);
            longResult = min(longResult, sqrt(variance));
        }
    }
    
    printf("%Lf\n", longResult);
    
    return 0;
}
long double getMean(long double sum[],int a,int b,int size){
    if(a == 0){
        return (long double) sum[b] / (long double) size;
    }else {
        return (long double) (sum[b] - sum[a-1]) / (long double) size;
    }
}
