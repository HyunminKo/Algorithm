# prices = [4,9,2,3]
# def calculateAmount(prices):
#     minValue = prices[0]
#     cost = prices[0]
#     for i in range(1,len(prices)):
#         if prices[i] > minValue:
#             cost += prices[i] - minValue
#         if prices[i] < minValue:
#             minValue = prices[i]
#     return cost
# print(calculateAmount(prices))
#
# print('abc' == 'abc')
#
#
# a = ['a','jk','abb','mn','abc','abbffgbbz']
# b = ['bb','kj','bbc','op','def','cbbgggbby']
#
#
#
# def getMinimumDifference(a, b):
#     answer = []
#     for i,j in zip(a,b):
#         if len(i) != len(j):
#             answer.append(-1)
#         else:
#             x = ''.join(sorted(i))
#             y = ''.join(sorted(j))
#             if x == y:
#                 answer.append(0)
#             else:
#                 count = 0
#                 countArr = [0] * 26
#                 print(countArr)
#                 answer.append(count)
#     return answer
#
# c = getMinimumDifference(a,b)
# print(c)
#
# print(ord('a'))

# def firstOccurrence(s, x):
#     index = 0
#     while index < len(s):
#         pointer = 0
#         startIndex = 0
#         flag = True
#         while pointer < len(x):
#             if x[pointer] == '*':
#                 if startIndex == 0:
#                         startIndex = index
#                 index += 1
#                 pointer += 1
#             else:
#                 if s[index] == x[pointer]:
#                     if startIndex == 0:
#                         startIndex = index
#                     index += 1
#                     pointer += 1
#                 else:
#                     flag = False
#                     break
#         if flag:
#             return startIndex
#         index += 1
# print(firstOccurrence('aaaaabaaaaabaaaaaa','aaaaaa'))

def isPossible(ith, value):
    if value % ith == 0:
        return True
    if ith % value == 0:
        return True
    return False
def dfs(index, n, bitSet, size):
    if index == n:
        print("{0:b}".format(bitSet))
        return 1
    temp = 0
    for i in range(1,n+1):
        if ((bitSet >> i) & 1) == 0:
            #if isPossible(size+1,i):
            bitSet = ((1 << i) | bitSet)
            temp += dfs(index+1,n,bitSet, size+1)
            bitSet = (~(1 << i) & bitSet)
    return temp
def arrangements(n):
    return dfs(0, n, 0, 0)
print(arrangements(3))