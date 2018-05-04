// you can use includes, for example:
#include <algorithm>
#include <cmath>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(int A, int B, int K) {
    return ceil((B-A+1-(K-(A%K))%K)/(double)K);
}
