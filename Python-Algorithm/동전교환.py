import time

coin = [6,4,1]
900원 500 100 50

700
500 300 50

def coinChange(change):
    if memo[change] != -1:
        return memo[change]

    if change == 0:
        return 0
    else:
        minValue = 987654321
        for i in range(len(coin)):
            if change - coin[i] >= 0:
                result = coinChange(change - coin[i])
                if minValue > result:
                    minValue = result
        memo[change] = minValue + 1
        return memo[change]

def coinChangeDP(change):
    for N in range(1,change+1):
        minValue = 987654321
        for i in range(len(coin)):
            if N >= coin[i]:
                result = memo[N-coin[i]]
                if minValue > result:
                    minValue = result
        memo[N] = minValue + 1
    return memo[change]

memo = [-1] * 10001
start_time = time.time()
print(coinChange(5000))
print("--- %s seconds ---" % (time.time() - start_time))
memo = [0] * 100001
start_time = time.time()
print(coinChangeDP(10000))
print("--- %s seconds ---" % (time.time() - start_time))