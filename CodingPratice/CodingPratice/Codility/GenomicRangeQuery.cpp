// you can use includes, for example:
#include <algorithm>
#include <vector>
#include <string>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;
using namespace std;
vector<int> solution(string &S, vector<int> &P, vector<int> &Q) {
    vector<int> ans;
    for(int i = 0 ; i < (int)P.size(); i++){
        int start = P[i], end=Q[i];
        string subStr = S.substr(start,end-start+1);
        
        if(subStr.find('A') != string::npos)
            ans.push_back(1);
        else{
            if(subStr.find('C') != string::npos)
                ans.push_back(2);
            else{
                if(subStr.find('G') != string::npos)
                    ans.push_back(3);
                else
                    ans.push_back(4);
            }
        }
            
    }
    return ans;
}
int main(){
    string S = "A";
    vector<int> P={1};
    vector<int> Q={1};
    
    solution(S, P, Q);
    
}
