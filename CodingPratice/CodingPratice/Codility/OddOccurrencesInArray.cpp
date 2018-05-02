// you can use includes, for example:
#include <algorithm>
#include <queue>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int solution(vector<int> &A) {
    sort(A.begin(),A.end());
    queue<int> q;
    for(auto element: A){
        q.push(element);
    }
    while(!q.empty()){
        int t1,t2;
        t1 = q.front();
        q.pop();
        t2 = q.front();
        q.pop();
        if(t1 != t2)
            return t1;
    }
    return -1;
}
int main(){
    vector<int> A ={9, 3, 9, 3, 9, 7, 9};
    printf("%d\n",solution(A));
    return 0;
}
