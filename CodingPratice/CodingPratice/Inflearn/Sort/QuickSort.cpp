#include <cstdio>
int partition(int a[], int begin, int end)
{
    int pivot, temp, L, R ;
    L = begin ;
    R = end ;
    int i = L+1;
    pivot = L;
    int j = pivot;
    
    for(; i <= R; i++){
        if(a[i] < a[pivot]){
            j++;
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }
    
    temp = a[pivot] ;
    a[pivot] = a[j] ;
    a[j] = temp ;
    
    return j;
}

void quickSort(int a[], int begin, int end)
{
    if(begin<end)
    {
        int p ;
        p = partition(a, begin, end) ;
        quickSort(a, begin, p-1) ;
        quickSort(a, p+1, end) ;
    }
}
int a[10] ={3,0,1,8,7,2,5,4,9,6};
int main(){
    quickSort(a, 0, 9);
    for(int i = 0 ; i < 10 ; i ++){
        printf("%d ",a[i]);
    }
    printf("\n");
}
