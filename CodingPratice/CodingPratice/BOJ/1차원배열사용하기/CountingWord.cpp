#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(){
    string str;
    int count=0;
    int successiveFlag = 0 ;
    vector<string> vec;
    getline(cin, str);
    string temp;
    
    
    for(int i = 0 ; i < str.size(); i++){
        if(str[i]-'\0' == ' '){
            vec.push_back(temp);
            temp = "";
        }
        if(str[i]-'\0' != ' ')
            temp += str[i];
    }
    printf("%d\n",(int)vec.size());
    return 0;
}
