def makeMax(num):
    strNum = list(str(num))
    index = 1
    big = strNum[0]
    while big == '9' and index < len(strNum):
        big = strNum[index]
        index += 1
    for i in range(len(strNum)):
        if strNum[i] == big:
            strNum[i] = '9'
    return ''.join(strNum)
def makeMin(num):
    strNum = list(str(num))
    big = strNum[0]
    big2 = strNum[1]
    for i in range(len(strNum)):
        if strNum[i] == big:
            strNum[i] = '1'
        elif strNum[i] == big2:
            strNum[i] = '0'
    return ''.join(strNum)

def findRange(num):
    maxValue = int(makeMax(num))
    minValue = int(makeMin(num))
    return maxValue - minValue
findRange(9)