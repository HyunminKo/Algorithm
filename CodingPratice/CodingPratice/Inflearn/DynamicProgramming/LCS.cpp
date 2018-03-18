#include <cstdio>
#include <iostream>
#include <string>
using namespace std;
int DP[1000][1000];
string str1;
string str2;
int LCS(int n, int m){
    for(int i = 0 ; i < n; i++){
        DP[i][0] = 0;
    }
    for(int j = 0 ; j < m; j++){
        DP[0][j] = 0;
    }
    for(int i = 1 ; i <= n; i++){
        for(int j = 1 ; j <= m; j++){
            if(str1[i] == str2[j])
                DP[i][j] = DP[i-1][j-1] + 1;
            else
                DP[i][j] = max(DP[i-1][j] , DP[i][j-1]);
        }
    }
    return DP[n][m];
}
int main(){
    getline(cin, str1);
    getline(cin, str2);
    
    printf("%d\n",LCS(((int)str1.size()), ((int)str2.size())));
    return 0;
}
