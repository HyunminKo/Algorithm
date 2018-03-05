#include <cstdio>

void merge(int A[],int p, int q, int r){
    int i = p, j = q + 1, k = p;
    int temp[10];
    while( i <= q && j <= r){
        if(A[i] <= A[j])
            temp[k++] = A[i++];
        else
            temp[k++] = A[j++];
    }
    while ( i <= q)
        temp[k++] = A[i++];
    while ( j <= r)
        temp[k++] = A[j++];
    
    for(int i = p ; i <= r; i++){
        A[i] = temp[i];
    }
}
void mergeSort(int A[],int p,int r){
    if(p < r){
        int q = (p+r)/2;
        mergeSort(A, p, q);
        mergeSort(A, q+1, r);
        merge(A, p, q, r);
    }
}
int main(){
    int A[]={9,0,5,4,7,6,3,2,1,8};
    mergeSort(A, 0, 9);
    for(int i = 0 ; i < 10; i++){
        printf("%d ",A[i]);
    }
    printf("\n");
}
