#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int minValue = 1000000000;

enum directions {
    UP, RIGHT, DOWN, LEFT
};
int N,M;
int map[9][9];
int nextDirection[4]= {directions::RIGHT,directions::DOWN,directions::LEFT,directions::UP};
int nextReverseDirection[4]= {directions::LEFT,directions::UP,directions::RIGHT,directions::DOWN};
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
const int WALL = 6;
const int BLINDSPOT = 7;
const int FIXSPOT = 8;
void generateDirections(int type, vector<int> &cctvVec){
    switch (type) {
        case 1:
            cctvVec.push_back(RIGHT);
            break;
        case 2:
            cctvVec.push_back(LEFT);
            cctvVec.push_back(RIGHT);
            break;
        case 3:
            cctvVec.push_back(UP);
            cctvVec.push_back(RIGHT);
            break;
        case 4:
            cctvVec.push_back(LEFT);
            cctvVec.push_back(UP);
            cctvVec.push_back(RIGHT);
            break;
        case 5:
            cctvVec.push_back(LEFT);
            cctvVec.push_back(UP);
            cctvVec.push_back(RIGHT);
            cctvVec.push_back(DOWN);
            break;
    }
}
void generateNumOfRotations(int type, int &numOfRotation){
    switch (type) {
        case 1:
        case 3:
        case 4:
            numOfRotation = 4;
            break;
        case 2:
            numOfRotation = 2;
            break;
        case 5:
            numOfRotation = 0;
            break;
    };
}
class Camera{
public:
    int typeOfCCTV;
    int numOfRotation;
    int directionOfCurrent;
    vector<int> directionsOfCCTV;
    vector<Camera> childrenOfCCTV;
    int x,y;
    Camera(int type,int dC, int x, int y){
        this->typeOfCCTV = type;
        this->x = x;
        this->y = y;
        this->directionOfCurrent = dC;
        generateNumOfRotations(type, this->numOfRotation);
        generateDirections(type, directionsOfCCTV);
    }
};
class TreeCamera {
public:
    Camera *Root;
    TreeCamera(int type, int x, int y){
        Root = new Camera(type,-1,x,y);
    }
};
void printMap(int m[][9]){
    printf("\n");
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            printf("%d ",m[i][j]);
        }
        printf("\n");
    }
    
}
void calcBlindSpot(int m[][9]){
    int result = 0 ;
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            if(m[i][j] == 0){
                result += 1;
            }
        }
    }
    minValue = min(minValue,result);
}
void drawArea(int x, int y, int direct, int typeOfArea, int m[][9]){
    int nx = x + dx[direct];
    int ny = y + dy[direct];
    if(nx<0 || ny<0 || nx>=N || ny>=M || m[nx][ny] == WALL){
        return ;
    }
    if(m[nx][ny] == 0){
        m[nx][ny] = typeOfArea;
    }
    
    drawArea(nx, ny, direct, typeOfArea,m);
}
void copyMap(int dstMap[][9],int srcMap[][9]){
    for(int i = 0 ; i < N; i++){
        for(int j =0 ; j < M; j++){
            dstMap[i][j] = srcMap[i][j];
        }
    }
    
}
void surveilence(Camera *camera,int m[][9]){
    for(int i = 0 ; i < camera->directionsOfCCTV.size(); i++){
        for(int j = 0 ; j < camera->directionOfCurrent; j++){
            camera->directionsOfCCTV[i] = nextDirection[camera->directionsOfCCTV[i]];
        }
    }
    for(auto &direct: camera->directionsOfCCTV){
        if(camera->typeOfCCTV == 5){
            drawArea(camera->x,camera->y,direct,FIXSPOT,m);
        }else {
            drawArea(camera->x,camera->y,direct,BLINDSPOT,m);
        }
    }
}
void DFSSurveilence(Camera *node,int m[][9]){
    int lenOfChildren = (int)node->childrenOfCCTV.size();
    
    if(node->typeOfCCTV == 0){
        for(int i = 0 ; i < lenOfChildren; i++){
            DFSSurveilence(&node->childrenOfCCTV[i], m);
        }
    } else {
        int copiedMap[9][9];
        copyMap(copiedMap,m);
        surveilence(node,copiedMap);
        for(int i = 0 ; i < lenOfChildren; i++){
            DFSSurveilence(&node->childrenOfCCTV[i], copiedMap);
        }
        if(lenOfChildren == 0){
            calcBlindSpot(copiedMap);
            return;
        }
    }
}
void startDFSSurveiling(TreeCamera *root, int m[][9]){
    DFSSurveilence(root->Root,m);
}
void makeTreeNode(Camera *node,int type,int x,int y){
    for(int i = 0 ; i < (int)node->childrenOfCCTV.size(); i ++){
        makeTreeNode(&node->childrenOfCCTV[i], type, x, y);
    }
    if((int)node->childrenOfCCTV.size() == 0) {
        int numOfRotation = 0, i = 0;
        generateNumOfRotations(type,numOfRotation);
        while(i != numOfRotation){
            node->childrenOfCCTV.push_back(Camera(type,i,x,y));
            i++;
        }
    }
}
void makeTreeCamera(TreeCamera *root, int type, int x, int y){
    makeTreeNode(root->Root,type,x,y);
}

int main(){
    vector<Camera> fixCameraVec;
    TreeCamera *root = new TreeCamera(0,-1,-1);
    
    scanf("%d %d",&N,&M);
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            int temp;
            scanf("%d",&temp);
            map[i][j] = temp;
            if(temp>0 && temp <5){
                makeTreeCamera(root,temp,i,j);
            }else if(temp == 5){
                fixCameraVec.push_back(Camera(temp,0,i,j));
            }
        }
    }
    for(int i = 0 ; i < (int)fixCameraVec.size(); i++){
        surveilence(&fixCameraVec[i],map);
    }
    calcBlindSpot(map);
    
    startDFSSurveiling(root,map);
    
    printf("%d\n",minValue);
    
    return 0;
}

