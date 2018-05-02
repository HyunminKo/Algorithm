#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;
vector<int> solution(vector<int> &A, int K) {
    int size = (int)A.size();
    int numberOfRotation = K % size;
    if(size != 0){
        for (int i = 0 ; i < numberOfRotation; i++){
            int temp = A[size-1];
            for(int j = size - 1 ; j >0; j--){
                A[j] = A[j-1];
            }
            A[0] = temp;
        }
    }
    return A;
}
int main(){
    vector<int> A={1,2,3,4};
    A = solution(A, 2);
    for(auto i : A){
        cout<< i << " ";
    }
    cout<<'\n';
}
