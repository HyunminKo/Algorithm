// you can use includes, for example:
#include <algorithm>
#include <vector>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
int solution(int N) {
    vector<int> ans;
    int q = N; // quoient
    int r = 0; // remainder
    bool oneFlag = false;
    bool zeroFlag = false;
    int temp = 0;
    while(q > 0){
        r = q % 2;
        if( r == 1 ){ // case: remainder == 1
            oneFlag = true;
            if(zeroFlag){
                zeroFlag = false;
                ans.push_back(temp);
                temp = 0;
            }
        }else{  // case: remainder == 0
            zeroFlag = true;
            if(oneFlag)
                temp++;
        }
        q = q / 2;
    }
    sort(ans.begin(),ans.end(),[](const int a, const int b){return a>b;});
    if((int)ans.size() == 0){
        return 0;
    }else{
        return ans[0];
    }
}
int main(){
    printf("%d\n",solution(1041));
}
