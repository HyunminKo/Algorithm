#include <cstdio>
#include <vector>
using namespace std;
int N,one,zero;
vector<pair<int, int>> memo;
vector<int> numOfInputV;
pair<int,int> fib(int n){
    if(n==0){
        if((int)memo.size()<=n)
            memo.push_back(make_pair(1, 0));
        return memo[n];
    }else if(n==1){
        if((int)memo.size()<=n)
            memo.push_back(make_pair(0, 1));
        return memo[n];
    }else if((int)memo.size()>n){
        return memo[n];
    }else{
        pair<int,int> temp1 = fib(n-2);
        pair<int,int> temp2 = fib(n-1);
        memo.push_back(make_pair(temp1.first+temp2.first, temp1.second+temp2.second));
        return memo[n];
    }
}
int main(){
    scanf("%d",&N);
    
    for(int i = 0 ; i < N; i++){
        int temp;
        scanf("%d",&temp);
        numOfInputV.push_back(temp);
    }
    for(int element: numOfInputV){
        pair<int,int> temp = fib(element);
        printf("%d %d\n",temp.first,temp.second);
    }
}
