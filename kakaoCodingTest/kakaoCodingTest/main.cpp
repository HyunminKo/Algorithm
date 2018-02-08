//
//  main.cpp
//  kakaoCodingTest
//
//  Created by 고현민 on 08/02/2018.
//  Copyright © 2018 Ko. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

int main(int argc, const char * argv[]) {
    int n;
    if ( argc >= 2){
        cout << argv[1] << endl;
        n = stoi(argv[1]);
        cout << n << endl;
    }
    string result[n];

    int arr1[] = {9,20,28,18,11};
    int arr2[] = {30, 1, 21, 17, 28};
    
    for(int i = 0 ; i < n; i++){
        int overLapNum = arr1[i] | arr2[i];
        int quotient = overLapNum;
        int remainder = 0;
        string tempResult = "";
        while(quotient > 1){
            remainder = quotient % 2;
            quotient = quotient / 2;
            if(remainder == 1){
                tempResult += "#"+tempResult;
            }else{
                tempResult += " "+tempResult;
            }
        }
        if(quotient == 1){
            tempResult += "#"+tempResult;
        }
        result[i].append(tempResult);
    }
    return 0;
}
