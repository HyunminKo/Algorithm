v=[10,40,30,50]
w=[5,4,6,3]

k=[[-1] * 11 for i in range(5)]
bag=[0,0,0,0]
maxValue = 0
n = 4

def knapsack_dp(i, W):
    global v
    global k
    global w
    if k[i][W] != -1:
        return k[i][W]
    for i in range(W+1):
        k[0][i] = 0
    for i in range(len(w)+1):
        k[i][0] = 0

    for n in range(1,i+1):
        for j in range(1,W+1):
            if w[n-1] > j:
                k[n][j] = k[n-1][j]
            else:
                k[n][j] = max(k[n-1][j-w[n-1]]+v[n-1],k[n-1][j])

    return k[n][j]

def knapsack_allsearch(W, i, curValue, bag):
    global maxValue,n,w,v
    if W >= 0:
        if i > n:
            if maxValue < curValue:
                maxValue = curValue
                print(bag)
        else:
            bag[i - 1] = 1
            knapsack_allsearch(W - w[i-1],i+1, curValue + v[i-1], bag)
            bag[i - 1] = 0
            knapsack_allsearch(W,i+1,curValue, bag)

print(knapsack_dp(4,10))
knapsack_allsearch(10,1,0,bag)
print(maxValue)