#include <cstdio>
#include <algorithm>
using namespace std;
int dist;
int main(){
    int result = 0;
    scanf("%d",&dist);
    result = dist / 5;
    if(dist % 5 == 0)
        printf("%d\n",result);
    else
        printf("%d\n",result+1);
    return 0;
}
