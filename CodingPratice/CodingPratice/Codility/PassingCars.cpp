// you can use includes, for example:
#include <algorithm>
#include <vector>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int solution(vector<int> &A) {
    vector<pair<int,int>> zeroPosV;
    int zeroIndex =-1;
    int result = 0;
    for(int i = 0 ; i < (int)A.size();i++){
        if(A[i] == 0){
            zeroPosV.push_back(make_pair(i,0));
            zeroIndex++;
        }
        else{
            if(zeroIndex != -1)
                zeroPosV[zeroIndex].second++;
        }
        
    }
    if(zeroIndex != -1){
        int prevSum = 0;
        for(int i = ((int)zeroPosV.size())-1; i >= 0 ; i--){
            result = result + zeroPosV[i].second + prevSum;
            prevSum = zeroPosV[i].second+ prevSum;
            if(result > 1000000000)
                return -1;
        }
    }
    return result;
}
