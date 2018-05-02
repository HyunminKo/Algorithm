// you can use includes, for example:
#include <algorithm>
#include <vector>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int minValue = 1000000000;
int solution(vector<int> &A) {
    int size = (int)A.size();
    int sum = A[0]-A[size-1];
    if(size == 2)
        return abs(sum);
    
    int leftSum = 0, rightSum = 0;
    for(int P = 1; P < size; P++){
        if(P == 1){
            leftSum = A[0];
            for(int i = 1 ; i < size; i++){
                rightSum += A[i];
            }
            minValue = min(minValue,abs(leftSum-rightSum));
        }else{
            leftSum += A[P-1];
            rightSum -= A[P-1];
            minValue = min(minValue,abs(leftSum-rightSum));
        }
    }
    return minValue;
}
