#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
int N;
int a[21][21];
int main(){
    scanf("%d",&N);
    for(int i = 0 ; i < N; i++)
        for(int j = 0 ; j <N; j++)
            scanf("%d",&a[i][j]);
    vector<int> b(N);
    for(int i = 0; i <N/2; i++){
        b[i] = 1;
    }
    sort(b.begin(),b.end());
    int ans = 1000000000;
    do{
        vector<int> first,second;
        for(int i = 0 ; i < N; i++){
            if(b[i]==1)
                second.push_back(i);
            else
                first.push_back(i);
        }
        int one=0,two=0;
        for(int i = 0 ; i < N/2; i++){
            for(int j = 0 ; j < N/2; j++){
                one+=a[first[i]][first[j]];
                two+=a[second[i]][second[j]];
            }
        }
        int diff = abs(one - two);
        ans = min(ans,diff);
    }
    while(next_permutation(b.begin(), b.end()));
    printf("%d\n",ans);
}
