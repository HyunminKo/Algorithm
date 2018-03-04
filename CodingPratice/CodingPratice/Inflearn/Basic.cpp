#include <cstdio>
#include <algorithm>

using namespace std;
int search(int ary[] , int n, int target){
    for(int i = 0 ; i < n; i++)
        if(ary[i]==target)
            return i;
    return -1;
}
int recursiveSearch(int ary[],int begin, int end, int target){
    if(begin>end)
        return -1;
    else if (target == ary[begin])
        return begin;
    else
        return recursiveSearch(ary,begin+1,end,target);
}
int findMax(int ary[],int begin, int end){
    if(begin == end)
        return ary[begin];
    else
        return max(ary[begin],findMax(ary, begin+1, end));
}
int main(){
    int a[10] = {9,0,5,3,2,1,6,7,4};
    printf("Search %d, index: %d\n",5,search(a,10,5));
    printf("RecursiveSearch %d, index: %d\n",5,recursiveSearch(a, 0, 9, 5));
    printf("findMax(1~4):%d\n",findMax(a, 1, 4));
    return 0;
}
