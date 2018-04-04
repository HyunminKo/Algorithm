#include <cstdio>
#include <vector>
#include <iostream>
using namespace std;
class alba{
public:
    int start_date,duration,income;
    alba(int s,int d,int i) { start_date=s;duration=d;income=i; }
};
/*
 * Time complexity: TODO
 * Space complexity: TODO
 */
bool checkSchedule[200];
bool checkDate[200];
vector<alba* > albaV;
int N;
int maxN = -1000000000;
void checkFalse(int k){
    
}
void checkTrue(int k){
    
}
void startAlba(int k){
    if(k == N){
        
    }
    checkFalse(k);
    startAlba(k+1);
    checkTrue(k);
    startAlba(k+1);
}
int main(int argc, const char *argv[]) {

    scanf("%d\n", &N);
    
    for (int i = 0; i < N; ++i) {
        int start_date, duration, income;
        scanf("%d %d %d\n", &start_date, &duration, &income);
        albaV.push_back(new alba(start_date,duration,income));
    }
    
    startAlba(0);
    
    return 0;
}

