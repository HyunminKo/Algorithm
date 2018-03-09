#include <iostream>
#include <cstdio>

using namespace std;


class Gear{
    int ary[8];
public:
    bool isRotate=false;
    int direction = 0;
    int getValue (int);
    void setValue(int,int);
    void rotate(int,int,int);
};
int Gear::getValue(int index){
    return Gear::ary[index];
}
void Gear::setValue(int index,int value){
    Gear::ary[index] = value;
}
Gear gearAry[4];
bool isRotate[4];

void rotateWideRight(int gearNum){
    int pole;
    if(gearAry[gearNum+1].isRotate){
        if(gearAry[gearNum+1].direction == 1){
            pole = gearAry[gearNum+1].getValue(7);
        }else{
            pole = gearAry[gearNum+1].getValue(5);
        }
        if(pole!=gearAry[gearNum].getValue(2)){
            gearAry[gearNum].isRotate = true;
            if(gearAry[gearNum+1].direction == 1)
                gearAry[gearNum].rotate(gearNum, gearNum, -1);
            else
                gearAry[gearNum].rotate(gearNum, gearNum, 1);
        }
    }
}
void rotateRight(int gearNum, int direction){
    int pole;
    if(gearAry[gearNum+1].isRotate){
        if(direction == 1){
            pole = gearAry[gearNum+1].getValue(7);
        }else{
            pole = gearAry[gearNum+1].getValue(5);
        }
        if(pole!=gearAry[gearNum].getValue(2)){
            gearAry[gearNum].isRotate = true;
            if(direction == 1)
                gearAry[gearNum].rotate(gearNum, gearNum, -1);
            else
                gearAry[gearNum].rotate(gearNum, gearNum, 1);
        }
    }else{
        int pole = gearAry[gearNum+1].getValue(6);
        if(pole!=gearAry[gearNum].getValue(2)){
            gearAry[gearNum].isRotate = true;
            if(direction == 1)
                gearAry[gearNum].rotate(gearNum, gearNum, -1);
            else
                gearAry[gearNum].rotate(gearNum, gearNum, 1);
        }
    }
}
void rotateWideLeft(int gearNum){
    int pole;
    if(gearAry[gearNum-1].isRotate){
        if(gearAry[gearNum-1].direction == 1)
            pole = gearAry[gearNum-1].getValue(3);
        else
            pole = gearAry[gearNum-1].getValue(1);
        if(pole!=gearAry[gearNum].getValue(6)){
            gearAry[gearNum].isRotate = true;
            if(gearAry[gearNum-1].direction == 1)
                gearAry[gearNum].rotate(gearNum, gearNum, -1);
            else
                gearAry[gearNum].rotate(gearNum, gearNum, 1);
        }
    }
}
void rotateLeft(int gearNum,int direction){
    int pole;
    if(gearAry[gearNum-1].isRotate){
        if(direction == 1)
            pole = gearAry[gearNum-1].getValue(3);
        else
            pole = gearAry[gearNum-1].getValue(1);
        if(pole!=gearAry[gearNum].getValue(6)){
            gearAry[gearNum].isRotate = true;
            if(direction == 1)
                gearAry[gearNum].rotate(gearNum, gearNum, -1);
            else
                gearAry[gearNum].rotate(gearNum, gearNum, 1);
        }
    }else{
        int pole = gearAry[gearNum-1].getValue(6);
        if(pole!=gearAry[gearNum].getValue(2)){
            gearAry[gearNum].isRotate = true;
            if(direction == 1)
                gearAry[gearNum].rotate(gearNum, gearNum, -1);
            else
                gearAry[gearNum].rotate(gearNum, gearNum, 1);
        }
    }
}
void Gear::rotate(int startGearNum,int gearNum, int direction){
    if(startGearNum == gearNum){
        if(direction == 1){
            int temp = this->ary[7];
            for(int i = 7 ; i >= 1; i--){
                this->ary[i] = this->ary[i-1];
            }
            this->ary[0] = temp;
        }else if(direction == -1){
            int temp = this->ary[0];
            for(int i = 0 ; i < 7; i++){
                this->ary[i] = this->ary[i+1];
            }
            this->ary[7] = temp;
        }
        this->direction = direction;
        this->isRotate = true;
    }else{
        if(gearNum == 0){
            if(abs(startGearNum - gearNum) >= 2)
                rotateWideRight(gearNum);
            else
                rotateRight(gearNum,direction);
        }else if(gearNum == 1||gearNum ==2){
            if(startGearNum > gearNum){
                if(abs(startGearNum - gearNum) >= 2)
                    rotateWideRight(gearNum);
                else
                    rotateRight(gearNum,direction);
            }else{
                if(abs(startGearNum - gearNum) >= 2)
                    rotateWideLeft(gearNum);
                else
                    rotateLeft(gearNum,direction);
            }
        }else{
            if(abs(startGearNum - gearNum) >= 2)
                rotateWideLeft(gearNum);
            else
            rotateLeft(gearNum,direction);
        }
    }
}

void rotateGear(int startGear, int index,int direction){
    if(isRotate[index])
        return;
    if(index < 0 || index >= 4)
        return;
    gearAry[index].rotate(startGear,index, direction);
    isRotate[index] = true;
    rotateGear(startGear,index-1, direction);
    rotateGear(startGear,index+1, direction);
}
int calResult(){
    int sum=0;
    for(int i = 0 ; i < 4; i++){
        if(gearAry[i].getValue(0) == 0)
            continue;
        if(i == 0){
            sum += 1;
        }else if( i== 1){
            sum += 2;
        }else if(i == 2){
            sum += 4;
        }else{
            sum += 8;
        }
    }
    return sum;
}
void isRotateClear(){
    for(int i =0; i< 4; i++){
        isRotate[i]=false;
        gearAry[i].direction = 0;
        gearAry[i].isRotate = false;
    }
}
int k;
int method[100][2];
int main(){
    for(int i = 0 ; i < 4; i++){
        for(int j = 0 ; j < 8; j++){
            int temp;
            scanf("%1d",&temp);
            gearAry[i].setValue(j, temp);
        }
    }
    scanf("%d",&k);
    for(int s = 0 ; s < k; s++){
        int gearNum;
        scanf("%d %d",&gearNum,&method[s][1]);
        method[s][0] = gearNum-1;
    }
    
    for(int s = 0 ; s < k; s++){
        rotateGear(method[s][0],method[s][0], method[s][1]);
        isRotateClear();
    }
    printf("%d\n",calResult());
    return 0;
}
