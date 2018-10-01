#include <iostream>
#include <string>
#include <vector>
#include <math.h>
using namespace std;

int solution(vector<int> food_times, long long k) {
    int answer = 0;
    long long sumOfElems = 0;
    for (auto& n: food_times){
        sumOfElems += n;
    }
    if(sumOfElems <= k){
        return -1;
    }
    long long numOfFood = food_times.size();
    long long willEat = floor(k / numOfFood);
    long long remainderOfSec = k - willEat * numOfFood;
    for(auto& n:food_times){
        if(n==0)
            continue;
        n -= willEat;
    }
    
    int pointer = 0;
    while(remainderOfSec != 0){
        pointer +=1;
        pointer %= numOfFood;
        while(food_times[pointer] - 1 < 0){
            pointer +=1;
            pointer %= numOfFood;
        }
        food_times[pointer] -= 1;
        remainderOfSec -=1;
    }
    answer = pointer+1;
    return answer;
}
int main(){
    vector<int> test = {3, 1, 2};
    int k = 5;
    
    cout << solution(test,k) << endl;
}
// import math
// def solution(food_times, k):
//     if sum(food_times) <= k:
//         return -1
//     numOfFood = len(food_times)
//     willEat = math.floor(k / numOfFood)
//     remainderOfSec = k - willEat * numOfFood
//     numOfFood = [x - willEat for x in food_times]
//     pointer = 0
//     while remainderOfSec == 0:
//         while food_times[pointer] - 1 < 0:
//             pointer +=1
//             pointer %= numOfFood
//         food_times[pointer] -= 1
//         remadinerOfSec -=1
//     answer = pointer + 1
//     return answer
