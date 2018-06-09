#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
int memo[1001][1001];
int lcs(string x, string y, int m, int n){
    for(int i = 0 ; i <= m; i++)
        memo[i][0] = 0;
    for(int i = 0 ; i <= m; i++)
        memo[0][i] = 0;
    for(int i = 0 ; i < m; i++){
        for(int j = 0 ; j < n; j++){
            if(x.at(i) == y.at(j))
                memo[i+1][j+1] = memo[i][j]+1;
            else
                memo[i+1][j+1] = max(memo[i][j+1], memo[i+1][j]);
        }
    }
    return memo[m][n];
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    string str1;
    string str2;
    int sizeOfStr1, sizeOfStr2;
    
    getline(cin, str1);
    getline(cin, str2);
    
    sizeOfStr1 = (int) str1.size();
    sizeOfStr2 = (int) str2.size();
    
    int result = lcs(str1,str2,sizeOfStr1,sizeOfStr2);
    cout << result << '\n';
    return 0;
}
