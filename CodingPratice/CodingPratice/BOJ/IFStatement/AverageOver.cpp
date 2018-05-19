#include <iostream>
#include <string>
#include <cstdio>
#include <vector>
#include <cmath>

using namespace std;

int main(){
    int N;
    int j;
    vector<int> V;
    scanf("%d",&N);
    
    for(int i = 0; i < N; i++){
        scanf("%d",&j);
        for(int k = 0 ; k < j; k++){
            int temp;
            scanf("%d",&temp);
            V.push_back(temp);
        }
        vector<int>::iterator iter;
        float avg=0;
        int overNum = 0;
        for(iter=V.begin(); iter!=V.end(); iter++){
            avg+=*iter;
        }
        avg = avg/(float)j;

        for(iter=V.begin(); iter!=V.end(); iter++){
            if((float)*iter > avg){
                overNum++;
            }
        }
        printf("%.3f%%\n",round((((float)overNum/(float)j)*100)*1000)/1000);
        
        V.clear();
    }
}


