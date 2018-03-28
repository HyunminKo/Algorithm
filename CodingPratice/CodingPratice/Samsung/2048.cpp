#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int map[30][30];
int N;
const int UP = 0;
const int LEFT = 1;
const int DOWN = 2;
const int RIGHT = 3;
int maxN = -1000000000;

void findMax(int temp[][30]){
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < N; j++){
            maxN = max(maxN,temp[i][j]);
        }
    }
    return;
}
void updateMap(int direction,int index,int temp[][30],int ary[30]){
    if(direction == UP || direction == DOWN){
        for(int i = 0; i< N; i++){
            temp[i][index]= ary[i];
        }
    }else{
        for(int i = 0; i< N; i++){
            temp[index][i] = ary[i];
        }
    }
}
void rotateAry(int direction,int index,int temp[][30],int ary[30]){
    if(direction == UP || direction == DOWN){
        for(int i = 0; i< N; i++){
            ary[i] = temp[i][index];
        }
    }else{
        for(int i = 0; i< N; i++){
            ary[i] = temp[index][i];
        }
    }
}
void move(int direction, int temp[][30],int ary[30],int index){
    bool check[30];
    for(int i = 0 ; i < N; i++){
        check[i] = false;
    }
    if(direction == UP || direction == LEFT){
        for(int i = 0 ; i < N; i++){
            if(ary[i] == 0)
                continue;
            if(i == N-1){
                for(int j = 0 ; j < N; j++){
                    if(i <= j)
                        break;
                    if(ary[j]==0){
                        ary[j] = ary[i];
                        ary[i] = 0;
                        check[i] = true;
                        break;
                    }
                }
            }
            if(ary[i] == ary[i+1]){
                for(int j = 0 ; j < N; j++){
                    if(i < j)
                        break;
                    if(i == j){
                        ary[i] = 2*ary[i];
                        ary[i+1] = 0;
                        check[i] = true;
                        break;
                    }
                    if(ary[j]==0){
                        ary[j] = 2*ary[i];
                        ary[i] = ary[i+1] = 0;
                        check[i] = true;
                        break;
                    }
                }
            }
            if(check[i] == false){
                for(int j = i+1 ; j < N; j++){
                    if(ary[j] == 0)
                        continue;
                    if(ary[i] > ary[j] || ary[i] < ary[j])
                        break;
                    if(ary[i] == ary[j]){
                        for(int k = 0 ; k < N; k++){
                            if(ary[k]==0){
                                ary[k] = 2*ary[i];
                                ary[i] = ary[j] = 0;
                                check[i] = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(check[i] == false){
                for(int j = 0 ; j < N; j++){
                    if(i < j)
                        break;
                    if(ary[j]==0){
                        ary[j] = ary[i];
                        ary[i] = 0;
                        break;
                    }
                }
            }
        }
    }else{
        for(int i = N-1 ; i >= 0; i--){
            if(ary[i] == 0)
                continue;
            if(i == 0){
                for(int j = N-1 ; j >= 0; j--){
                    if(i > j)
                        break;
                    if(ary[j]==0){
                        ary[j] = ary[i];
                        ary[i] = 0;
                        check[i] = true;
                        break;
                    }
                }
            }
            if(ary[i] == ary[i-1]){
                for(int j = N-1 ; j >= 0; j--){
                    if(i > j)
                        break;
                    if(i == j){
                        ary[i] = 2*ary[i];
                        ary[i-1] = 0;
                        check[i] = true;
                        break;
                    }
                    if(ary[j]==0){
                        ary[j] = 2*ary[i];
                        ary[i] = ary[i-1] = 0;
                        check[i] = true;
                        break;
                    }
                }
            }
            if(check[i] == false){
                for(int j = i-1 ; j >= 0; j--){
                    if(ary[j] == 0)
                        continue;
                    if(ary[i] < ary[j] || ary[i] > ary[j])
                        break;
                    if(ary[i] == ary[j]){
                        for(int k = N-1 ; k >= 0; k--){
                            if(ary[k]==0){
                                ary[k] = 2*ary[i];
                                ary[i] = ary[j] = 0;
                                check[i] = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(check[i] ==false){
                for(int j = N-1 ; j >= 0; j--){
                    if(i > j)
                        break;
                    if(ary[j]==0){
                        ary[j] = ary[i];
                        ary[i] = 0;
                        break;
                    }
                }
            }
        }
    }
    updateMap(direction,index,temp,ary);
}
void init(int temp[][30]){
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < N; j++){
            temp[i][j]= map[i][j];
        }
    }
}
void go(int direction, int count,int temp[][30]){
    if(count==5){
        findMax(temp);
        return;
    }
    int temp2[30][30];
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < N; j++){
            temp2[i][j]= temp[i][j];
        }
    }
    for(int i = 0 ; i < N; i++){
        int ary[30];
        rotateAry(UP,i,temp2,ary);
        move(UP,temp2,ary,i);
    }
    
    go(UP,count+1,temp2);
    
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < N; j++){
            temp2[i][j]= temp[i][j];
        }
    }
    for(int i = 0 ; i < N; i++){
        int ary[30];
        rotateAry(LEFT,i,temp2,ary);
        move(LEFT,temp2,ary,i);
    }
    go(LEFT,count+1,temp2);
    
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < N; j++){
            temp2[i][j]= temp[i][j];
        }
    }
    for(int i = 0 ; i < N; i++){
        int ary[30];
        rotateAry(DOWN,i,temp2,ary);
        move(DOWN,temp2,ary,i);
    }
    go(DOWN,count+1,temp2);
    
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < N; j++){
            temp2[i][j]= temp[i][j];
        }
    }
    for(int i = 0 ; i < N; i++){
        int ary[30];
        rotateAry(RIGHT,i,temp2,ary);
        move(RIGHT,temp2,ary,i);
    }
    go(RIGHT,count+1,temp2);
}
int main(){
    scanf("%d",&N);
    for(int i = 0 ; i < N ; i ++){
        for(int j = 0 ; j < N; j++){
            scanf("%d",&map[i][j]);
        }
    }
    for(int i = 0 ; i < 4; i++){
        int temp2[30][30];
        for(int i = 0 ; i < N; i++){
            for(int j =0 ; j < N; j++){
                temp2[i][j]= map[i][j];
            }
        }
        for(int j = 0; j < N; j++){
            int ary[30];
            rotateAry(i,j,temp2,ary);
            move(i,temp2,ary,j);
        }
        go(i,1,temp2);
    }
    printf("%d\n",maxN);
}

