#include <cstdio>
#include <algorithm>
using namespace std;
int N,countN=0;
bool isOk(int level,int cols[]){
    for( int i = 0 ; i < level ; i++){
        if(cols[i] == cols[level])
            return false;
        else if((level - i)==abs(cols[level] - cols[i]))
            return false;
    }
    return true;
}
void queens(int level,int cols[]){
    if(!isOk(level,cols))
        return;
    else if(level == N-1){
        countN++;
        return;
    }else{
        for(int i = 0 ; i< N; i++){
            cols[level+1]=i;
            queens(level+1,cols);
        }
    }
}
int main(){
    scanf("%d",&N);
    
    for(int c = 0 ; c < N; c++){
        int check[14];
        for (int i = 0 ; i < N; i++) {
            check[i]=-1000;
        }
        check[0] = c;
        queens(0,check);
    }
    printf("%d\n",countN);
}
