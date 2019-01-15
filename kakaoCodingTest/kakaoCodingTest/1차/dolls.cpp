#include <stdio.h>
#include <math.h>
#define MIN(a,b) (((a)<(b))?(a):(b))
long double getMean(long double sum[],int a,int b,int size);
int main() {
    int dolls[501];
    long double sum[501];
    long double squareSum[501];
    long double lfResult = 0;
    int n,k;
    scanf("%d %d",&n,&k);
    
    for(int i = 0 ; i < n ; i++){
        scanf("%d",&dolls[i]);
    }
    for(int i = 0 ; i < n; i++){
        if(i == 0){
            sum[i] = dolls[i];
            squareSum[i] = (double) pow(dolls[i],2);
        }else {
            sum[i] += dolls[i];
            sum[i] += sum[i-1];
            squareSum[i] = (double) pow(dolls[i],2);
            squareSum[i] += squareSum[i-1];
        }
    }
    
    
    for(int i = 0 ; i < n; i++){
        for(int j = 0 ; j < n; j++){
            if(i > j) continue;
            if(j - i + 1 < k) continue;
            long double variance = getMean(squareSum,i,j,j - i + 1) - pow(getMean(sum,i,j, j - i + 1),2);
            lfResult = MIN(lfResult, sqrt(variance));
        }
    }
    printf("%.11Lf\n",lfResult);
}
long double getMean(long double sum[],int a,int b,int size){
    if(a == 0){
        return (long double) sum[b] / (long double) size;
    }else {
        return (long double) (sum[b] - sum[a-1]) / (long double) size;
    }
}

