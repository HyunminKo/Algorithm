#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
int N,maxV=-1000000000;
int main(){
    scanf("%d",&N);
    vector<int> a(N);
    for(int i = 0 ; i < N; i++){
        int temp=0;
        scanf("%d",&temp);
        a[i]=temp;
    }
    sort(a.begin(),a.end());
    do{
        int result = 0;
        for(int i = 0; i < N-1; i++){
            result += abs(a[i]-a[i+1]);
        }
        maxV = max(result,maxV);
    }while(next_permutation(a.begin(), a.end()));
    printf("%d\n",maxV);
}
