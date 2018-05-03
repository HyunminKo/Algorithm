// you can use includes, for example:
#include <algorithm>
#include <set>
#include <vector>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int solution(vector<int> &A) {
    set<int> setX;
    for(auto e: A){
        setX.insert(e);
    }
    
    for(int i = 1; i <= 1000000;i++){
        const bool is_in = setX.find(i) != setX.end();
        if(!is_in)
            return i;
    }
    return -1;
}
