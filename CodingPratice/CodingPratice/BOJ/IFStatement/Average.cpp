#include <iostream>
#include <string>
#include <cstdio>
#include <vector>

using namespace std;

int main(){
    int N;
    float sum=0;
    float maxValue=0;
    vector<float> V;
    
    scanf("%d",&N);
    for(int i = 0 ; i < N; i++){
        float temp;
        scanf("%f",&temp);
        V.push_back(temp);
    }
    vector<float>::iterator iter;
    for(iter = V.begin(); iter!=V.end();iter++){
        if(*iter > maxValue){
            maxValue = *iter;
        }
    }
    for(iter = V.begin(); iter!=V.end();iter++){
        *iter = (*iter/maxValue)*100;
    }
    for(iter = V.begin(); iter!=V.end();iter++){
        sum += *iter;
    }
    printf("%.2f\n", sum/N);
}

