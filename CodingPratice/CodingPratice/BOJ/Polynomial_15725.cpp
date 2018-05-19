#include <string>
#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    vector<int> indexOfX;
    
    string str;
    cin >> str;
    int result = 0;
    int size = (int)str.size();
    for(int i = 0 ; i < size; i++){
        if(str.at(i) == 'x')
            indexOfX.push_back(i);
    }
    int numOfX = (int) indexOfX.size();
    if(numOfX == 0){
        cout << 0 << '\n';
        return 0;
    }else{
        int prevIndex = -1;
        for(int index : indexOfX){
            int tempIndex = index - 1;
            while(tempIndex>=-1 && tempIndex!=prevIndex && isdigit(str.at(tempIndex))){
                tempIndex -= 1;
            }
            prevIndex = index;

            if(index-tempIndex-1 == 0 ){
                if(tempIndex == -1 || str.at(tempIndex) != '-')
                    result+=1;
                else
                    result-=1;
            }else{
                if(tempIndex != -1 && str.at(tempIndex) == '-')
                    result -= stoi(str.substr(tempIndex+1,index-tempIndex-1));
                else
                    result += stoi(str.substr(tempIndex+1,index-tempIndex-1));
            }            
        }
        cout << result << endl;
    }
    
}
