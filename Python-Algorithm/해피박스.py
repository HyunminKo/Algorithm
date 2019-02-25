T = int(input())
dp = [[0] * 101 for i in range(21)]
for i in range(1,T+1):
    inputs = list(map(int,input().split()))
    N = inputs[0]
    M = inputs[1]

    sizeOfBox = []
    valueOfBox = []

    for j in range(M):
        sv = list(map(int,input().split()))
        sizeOfBox.append(sv[0])
        valueOfBox.append(sv[1])

    for j in range(1,M+1):
        for k in range(1,N+1):
            if sizeOfBox[j-1] > k:
                dp[j][k] = dp[j-1][k]
            else:
                dp[j][k] = max(dp[j-1][k-sizeOfBox[j-1]]+valueOfBox[j-1],dp[j-1][k])

    print('#{} {}'.format(i,dp[M][N]))