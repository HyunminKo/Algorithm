// you can use includes, for example:
#include <algorithm>
#include <vector>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int solution(vector<int> &A) {
    if((int)A.size() == 0)
        return 1;
    sort(A.begin(),A.end());
    if(A[0] == 2)
        return 1;
    for(int i = 0 ; i < (int)A.size()-1;i++){
        if(A[i] + 1 != A[i+1]){
            return A[i]+1;
        }
    }
    return (int)A.size()+1;
}
int main(){
    vector<int> A={};
    printf("%d\n",solution(A));
    return 0;
}
