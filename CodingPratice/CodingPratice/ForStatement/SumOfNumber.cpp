#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main(){
    string N;
    string nums;
    int sum = 0 ;
    getline(cin, N);
    getline(cin,nums);
    
    for(int i = 0; i < stoi(N); i++){
        sum += nums[i]-'0';
    }
    printf("%d\n",sum);
}

