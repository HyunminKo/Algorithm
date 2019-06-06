#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'closestStraightCity' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts following parameters:
#  1. STRING_ARRAY c
#  2. INTEGER_ARRAY x
#  3. INTEGER_ARRAY y
#  4. STRING_ARRAY q
#
class City(object):
    def __init__(self, x,y,name):
        self.x = x
        self.y = y
        self.name = name
        self.distance = 0
    def __str__(self):
        return ' '.join([self.name,str(self.x),str(self.y),str(self.distance)])
    def __lt__(self,other):
        return self.distance < other.distance

def closestStraightCity(c, x, y, q):
    Cities = {}
    result = []
    for name,x,y in zip(c,x,y):
        Cities[name]=City(x,y,name)
    for query in q:
        selectedCity = Cities[query]
        newCities = []
        for key, value in Cities.items():
            if selectedCity.name == value.name:
                continue
            if selectedCity.x != value.x and selectedCity.y != value.y:
                continue
            value.distance = math.sqrt(math.pow(selectedCity.x-value.x,2) + math.pow(selectedCity.y-value.y,2))
            newCities.append(value)
        if len(newCities) == 0:
            result.append("NONE")
        else:
            newCities.sort(key = lambda city: city.distance)
            result.append(newCities[0].name)
    return result


if __name__ == '__main__':
    n = int(input())
    c = []
    x = []
    y = []
    q = []
    for i in range(n):
        c.append(input())
    n = int(input())
    for i in range(n):
        x.append(int(input()))
    n = int(input())
    for i in range(n):
        y.append(int(input()))
    n = int(input())
    for i in range(n):
        q.append((input()))
    result = closestStraightCity(c, x, y, q)
    print(result)