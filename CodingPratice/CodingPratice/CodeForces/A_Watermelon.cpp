#include <cstdio>
int W;
int main(){
    scanf("%d",&W);
    if(W % 2 == 0 && W >= 4)
        printf("YES\n");
    else
        printf("NO\n");
}
