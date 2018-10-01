#include <cstdio>
#include <algorithm>
#include <vector>
#include <map>
#include <string>
#include <set>
using namespace std;

int countOfTest=0;
int N,M,K;
char debugMap[100][100];
int debugMap2[100][100];
enum directions {
    UP = 1,
    DOWN = 2,
    LEFT = 3,
    RIGHT = 4
};
bool isInDrug(int x, int y){
    if(x == 0 || x == N-1){
        if(y>=0 && y<=N-1){
            return true;
        }
    }else if(y == 0 || y == N-1){
        if(x>=0 && x<=N-1){
            return true;
        }
    }
    return false;
}

pair<int, int> nextPosition(int cx, int cy, int direction){
    pair<int, int> info;
    if(direction == directions::UP){
        info.first = cx - 1;
        info.second = cy;
    }else if(direction == directions::DOWN){
        info.first = cx + 1;
        info.second = cy;
    }else if(direction == directions::LEFT){
        info.first = cx;
        info.second = cy - 1;
    }else { //RIGHT
        info.first = cx;
        info.second = cy + 1;
    }
    return info;
}
directions nextDirection(int direction){
    if(direction == directions::UP){
        return directions::DOWN;
    }else if(direction == directions::DOWN){
        return directions::UP;
    }else if(direction == directions::LEFT){
        return directions::RIGHT;
    }else { //RIGHT
        return directions::LEFT;
    }
}
class MicroBugs{
public:
    int x,y;
    int numOfBugs;
    int direct;
    MicroBugs(int x, int y, int num, int direct){
        this->x = x;
        this->y = y;
        this->numOfBugs = num;
        this->direct = direct;
    }
    
};
void start(int time,vector<MicroBugs> &bugs){
    for(int i = 0 ; i < time; i++){
        map<pair<int,int>,pair<int,int>> checkMap;
        set<pair<int, int>> duplicatedIndex;
        for(auto bug = bugs.begin(); bug != bugs.end(); bug++){
            pair<int,int> nextStep = nextPosition(bug->x, bug->y, bug->direct);
            int nx = nextStep.first;
            int ny = nextStep.second;
            
            if(isInDrug(nx, ny)){
                bug->numOfBugs /= 2;
                bug->direct = nextDirection(bug->direct);
            }
            bug->x = nx;
            bug->y = ny;
            pair<int, int> key = make_pair(nx,ny);
            if (checkMap.find(key) == checkMap.end()) {
                checkMap[key] = make_pair(bug->numOfBugs, bug->direct);
            } else {
                pair<int,int> tempPair = checkMap[key];
                duplicatedIndex.insert(make_pair(nx, ny));
                tempPair.first += bug->numOfBugs;
                checkMap[key] = tempPair;
            }
        }
        auto bug = bugs.begin();
        while(bug != bugs.end()){
            if(bug->numOfBugs == 0){
                bug = bugs.erase(bug);
            }else{
                ++bug;
            }
        }
        for(auto const &item: duplicatedIndex){
            pair<int, int> key = make_pair(item.first,item.second);
            auto bug = bugs.begin();
            int tempNumOfbugs = 0;
            while(bug != bugs.end()){
                if(bug->x == item.first && bug->y == item.second){
                    if(tempNumOfbugs < bug->numOfBugs){
                        checkMap[key].second = bug->direct;
                        tempNumOfbugs = bug->numOfBugs;
                    }
                    bug = bugs.erase(bug);
                }else{
                    ++bug;
                }
            }
            bugs.push_back(MicroBugs(item.first,item.second,checkMap[key].first,checkMap[key].second));
        }
    }
}
int main(){
    scanf("%d",&countOfTest);
    for(int i = 0 ; i < countOfTest; i++){
        vector<MicroBugs> mb;
        scanf("%d %d %d",&N,&M,&K);
        for(int j = 0; j < K; j++){
            int x,y,num,direct;
            scanf("%d %d %d %d",&x,&y,&num,&direct);
            MicroBugs bugs(x,y,num,direct);
            mb.push_back(bugs);
        }
        start(M,mb);
        int result = 0;
        for(MicroBugs &bug:mb){
            result += bug.numOfBugs;
        }
        printf("#%d %d\n",i+1,result);
        
    }
    return 0;
}

