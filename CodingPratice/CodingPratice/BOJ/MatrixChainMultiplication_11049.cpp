#include <iostream>
#include <algorithm>
using namespace std;
int N;
int matrix[1001];
long long memo[501][501];
long long MAX_LONG_LONG = 9223372036854775807;
long long calc(int n){
    for(int i = 0 ; i <= n; i++)
        memo[i][i] = 0;
    for(int i = n-1; i > 0; i--){
        for(int j = i+1; j <= n; j++){
            memo[i][j] = MAX_LONG_LONG;
            for(int k = i; k<j; k++){
                memo[i][j] = min(memo[i][k] + memo[k+1][j] + (matrix[i-1] * matrix[k] * matrix[j]) , memo[i][j]);
            }
        }
    }
    
    return memo[1][n];
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N;
    for(int i = 0 ; i < N; i++){
        cin >> matrix[i];
        cin >> matrix[i+1];
    }

    long long result = calc(N);
    cout << result <<'\n';
}
