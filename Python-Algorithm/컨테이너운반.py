T = int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    weightsOfContainer = list(map(int,input().split()))
    weightsOfTruck = list(map(int, input().split()))
    print(weightsOfContainer,weightsOfTruck)
    print('#{}'.format(test_case),0)