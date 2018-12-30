dx = [1, 0]
dy = [0, 1]

minValue = 987654321
matrix = []

def go(x, y, cost, n):
    global minValue
    if cost > minValue:
        return
    if x == n-1 and y == n-1:
        minValue = min(minValue, cost)
        return
    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < n and ny < n and nx >= 0 and ny >= 0:
            go(nx, ny, cost+int(matrix[nx][ny]), n)

T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    for i in range(N):
        matrix.append(input().split(" "))
    go(0,0,int(matrix[0][0]),N)
    print('#{}'.format(test_case),minValue)
    minValue = 987654321
    matrix = []