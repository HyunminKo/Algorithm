// you can use includes, for example:
#include <algorithm>
#include <vector>
#include <set>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int solution(int X, vector<int> &A) {
    set<int> setX;
    for(int i = 0 ; i < (int)A.size();i++){
        setX.insert(A[i]);
        if((int)setX.size() == X)
            return i;
    }
    return -1;
}
int main(){
    vector<int> A ={1, 3, 1, 4, 2, 3, 5, 4};
    printf("%d\n",solution(5, A));
    
}
