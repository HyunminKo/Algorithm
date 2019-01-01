T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    weightsOfContainer = list(map(int,input().split()))
    weightsOfTruck = list(map(int, input().split()))
    weightsOfContainer.sort(reverse=True)
    weightsOfTruck.sort(reverse=True)
    result = 0
    i = j = 0
    for x in range(len(weightsOfTruck)):
        if j >= len(weightsOfContainer):
            break
        if weightsOfTruck[i] >= weightsOfContainer[j]:
            result += weightsOfContainer[j]
            i += 1
            j += 1
        else:
            j += 1
            continue
    print('#{}'.format(test_case),result)