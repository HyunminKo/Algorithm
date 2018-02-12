#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main(){
    string str;
    getline(cin,str);

    for(int i = 1; i <= str.size() ; i++){
        printf("%c",str[i-1]);
        if(i == 0)
            continue;
        if(i % 10 ==0)
            printf("\n");
    }
    printf("\n");
}
