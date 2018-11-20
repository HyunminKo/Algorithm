#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int minValue = 1000000000;

enum directions {
    UP, RIGHT, DOWN, LEFT
};
enum mode {
    ACTIVE, DEACTIVE
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
    vector<int> directionsOfCCTV;
    int x,y;
    Camera(int type,int x, int y){
        this->typeOfCCTV = type;
        this->x = x;
        this->y = y;
        generateNumOfRotations(type, this->numOfRotation);
        generateDirections(type, directionsOfCCTV);
    }
};
void printMap(){
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            printf("%d ",map[i][j]);
        }
        printf("\n");
    }
}
void calcBlindSpot(){
    int result = 0 ;
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            if(map[i][j] == 0){
                result += 1;
            }
        }
    }
    minValue = min(minValue,result);
    printf("The number of Blind Spot: %d \n",minValue);
}
void drawArea(int x, int y, int direct, int typeOfArea, int isActive){
    int nx = x + dx[direct];
    int ny = y + dy[direct];
    if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny] == WALL){
        return ;
    }
    if(isActive == ACTIVE){
        if(map[nx][ny] == 0){
            map[nx][ny] = typeOfArea;
        }
    }else{
        if(map[nx][ny] == BLINDSPOT){
            map[nx][ny] = 0;
        }
    }
    
    drawArea(nx, ny, direct, typeOfArea, isActive);
}
void surveilence(Camera &camera){
    printf("Starting surveilence \n");
    for(auto &direct: camera.directionsOfCCTV){
        if(camera.typeOfCCTV == 5){
            drawArea(camera.x,camera.y,direct,FIXSPOT,ACTIVE);
        }else {
            drawArea(camera.x,camera.y,direct,BLINDSPOT,ACTIVE);
        }
    }
    printMap();
}
void recoverSurveilence(Camera &camera){
    for(auto &direct: camera.directionsOfCCTV){
        drawArea(camera.x, camera.y, direct, 0, DEACTIVE);
    }
}
void restoreMap(){
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            if(map[i][j] == BLINDSPOT){
                map[i][j]=0;
            }
        }
    }
    printf("restoring the map\n");
//    printMap();
}
void recursiveSurveilence(int count,size_t size, vector<Camera> &cameraVec){
    if(count == (int)size){
        calcBlindSpot();
        return;
    }
    while(!cameraVec.empty()){
        for(auto &camera: cameraVec){
            camera.numOfRotation--;
            for(int i = 0 ; i < camera.directionsOfCCTV.size(); i++){
                camera.directionsOfCCTV[i] = nextDirection[camera.directionsOfCCTV[i]];
            }
            
            surveilence(camera);
            recursiveSurveilence(count+1, size, cameraVec);
            recoverSurveilence(camera);
            
            camera.numOfRotation++;
            for(int i = 0 ; i < camera.directionsOfCCTV.size(); i++){
                camera.directionsOfCCTV[i] = nextReverseDirection[camera.directionsOfCCTV[i]];
            }
        }
    }
}
void startSurveiling(vector<Camera> &cameraVec){
    recursiveSurveilence(0, cameraVec.size(),cameraVec);
}

int main(){
    vector<Camera> cameraVec;
    vector<Camera> fixCameraVec;
    scanf("%d %d",&N,&M);
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            int temp;
            scanf("%d",&temp);
            map[i][j] = temp;
            if(temp>0 && temp <5){
                cameraVec.push_back(Camera(temp,i,j));
            }else if(temp == 5){
                fixCameraVec.push_back(Camera(temp,i,j));
            }
        }
    }
    
    for(auto &camera : cameraVec){
        printf("camera info, type: %d, numOfRotation: %d\ncamera has these : ",camera.typeOfCCTV,camera.numOfRotation);
        for(auto &direct: camera.directionsOfCCTV){
            printf("%d ",direct);
        }
        printf("\n");
    }
//    for(Camera &camera: fixCameraVec){
//        surveilence(camera);
//    }
//
//    startSurveiling(cameraVec);
    return 0;
}
