#include <iostream>
#include <string>
#include <algorithm>
#include <map>

using namespace std;
void encoding(string str){
    int count = 0, sizeCount = 0;
    int strSize = (int) str.size();
    char prevCh = str.at(0);
    for(auto ch : str){
        if(ch!=prevCh){
            cout << count << prevCh;
            prevCh = ch;
            count = 1;
        }else{
            count++;
        }
        sizeCount++;
        if(strSize == sizeCount){
            cout << count << prevCh;
        }
    }
    cout<< '\n';
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    string str;
    cin >> N;
    for(int i = 0 ; i < N; i++){
        cin >> str;
        encoding(str);
    }
}
