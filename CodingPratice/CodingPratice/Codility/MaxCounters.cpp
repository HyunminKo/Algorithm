// you can use includes, for example:
#include <algorithm>
#include <vector>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
vector<int> solution(int N, vector<int> &A) {
    vector<int> ans(N,0);
    int maxCounter = 0;
    int tempCounter = 0;
    for(auto element: A){
        if(element == N+1){
            tempCounter = maxCounter;
        }else{
            if(ans[element-1] < tempCounter)
                ans[element-1] = tempCounter;
            ans[element-1]++;
            if(maxCounter<ans[element-1])
                maxCounter = ans[element-1];
        }
    }
    for(int i = 0 ; i < N;i++){
        if(ans[i]<tempCounter){
            ans[i] = tempCounter;
        }
    }
    return ans;
}
