#include <iostream>
#include <string>
#include <cstdio>

using namespace std;

int main(){
    int N;
    int count=0;
    int temp=-1;
    string str;
    
    scanf("%d",&N);
    if(N<10){
        str = "0"+to_string(N);
    }else{
        str = to_string(N);
    }
    while(temp != N){
        int temp2 = stoi(str.substr(0,1))+stoi(str.substr(1,2));
        string str2;
        if(temp2>=10){
            str2 = to_string(temp2);
        }else{
            str2 = "0"+to_string(temp2);
        }
        str = str.substr(1,2) + str2.substr(1,2);
        count++;
        temp = stoi(str);
    }
    printf("%d\n",count);
}
