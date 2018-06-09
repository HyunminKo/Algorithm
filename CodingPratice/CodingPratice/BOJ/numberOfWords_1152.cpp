#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int result = 0;
bool isWhiteSpace = true;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    string inputStr;
    getline(cin,inputStr);
    if(inputStr.size() == 0){
        cout << 0 << '\n';
        return 0;
    }
    for(int i = 0 ; i < (int) inputStr.size(); i++){
        if(inputStr.at(i) == ' '){
            isWhiteSpace = true;
        }
        else{
            if(isWhiteSpace){
                result++;
                isWhiteSpace = false;
            }else{
                continue;
            }
        }
    }
    cout << result << '\n';
    return 0;
}
