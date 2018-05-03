// you can use includes, for example:
#include <algorithm>
#include <vector>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int solution(vector<int> &A) {
    int size = (int)A.size();
    if(size == 0)
        return 0;
    else if(size == 1){
        if(A[0] != 1)
            return 0;
        else
            return 1;
    }
    sort(A.begin(),A.end());
    int prevValue = 0;
    for(auto i : A){
        if(i - prevValue != 1)
            return 0;
        prevValue = i;
    }
    return 1;
}
