dp = [[0] * 71 for i in range(71)]
T=int(input())

dp[0][0] = 1
dp[1][0] = 1
dp[1][1] = 1

def comb(N, C):
    global dp
    if dp[N][C] != 0:
        return dp[N][C]
    for i in range(2,N+1):
        if N == C or C == 0:
            dp[N][C] = 1
            return dp[N][C]
        for j in range(i+1):
            if j == 0 or i == j:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
    return dp[N][C]

for i in range(T):
    line = list(map(int,input().split()))
    print('#{} {}'.format(i+1,comb(line[0],line[1])))