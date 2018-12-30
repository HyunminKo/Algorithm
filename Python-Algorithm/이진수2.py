T = int(input())
for test_case in range(1, T + 1):
    a = input().split('.')
    pointOfSize = len(a[1])
    point = int(a[1])
    result = ''
    temp = point
    overflowFlag = False
    while temp != 0:
        if len(result) >= 13:
            overflowFlag = True
            break
        temp = temp * 2
        if temp >= int('1'+('0' * pointOfSize)):
            result += '1'
            temp = temp % int('1'+('0' * pointOfSize))
        else:
            result += '0'
    if not overflowFlag:
        print('#{}'.format(test_case), result)
    else:
        print('#{}'.format(test_case),"overflow")