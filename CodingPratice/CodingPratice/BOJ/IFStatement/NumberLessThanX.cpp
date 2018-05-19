#include <iostream>
#include <string>
#include <cstdio>
#include <vector>

using namespace std;

int main(){
    int i,N,X;
    string str;
    vector<int> V;
    string resultStr;
    getline(cin,str);
    
    for(i = 0; i < str.size(); i++){
        if(str[i] == ' ')
            break;
    }
    N = stoi(str.substr(0,i));
    X = stoi(str.substr(i+1,str.size()));
    for(i = 0 ; i < N; i++){
        int temp;
        scanf("%d",&temp);
        V.push_back(temp);
    }
    
    vector<int>::iterator iter;
    i = 0;
    for(iter = V.begin();iter!=V.end();iter++){
        if(*iter < X){
            resultStr += to_string(*iter) + " ";
        }
    }
    cout << resultStr.substr(0,resultStr.size()-1) << "\n";
}
