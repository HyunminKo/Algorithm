#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main(){
    int months[12]={0,3,3,6,1,4,6,2,5,0,3,5};
    string str[7]={"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};
    int mon,day;
    int result;
    
    scanf("%d %d",&mon,&day);
    
    result = ((day-1)%7 + months[mon-1])%7;
    cout << str[result] <<"\n";
}
