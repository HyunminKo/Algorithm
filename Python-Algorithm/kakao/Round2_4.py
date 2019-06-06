N=0
M=0
matrixA = []
matrixB = []
dx = [-1,0,1,0]
dy = [0,1,0,-1]
visited = [[0 for i in range(101)] for j in range(101)]

def bfs(row,col):
    global N, M, visited
    visited[row][col] = 1
    q = [(row,col)]
    count = 0
    if matrixA[row][col] != matrixB[row][col]:
        count = - 1
    flag = True
    while q:
        location = q.pop(0)
        for i in range(len(dx)):
            nx = location[0] + dx[i]
            ny = location[1] + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M or visited[nx][ny] == 1 or matrixB[nx][ny] == 0:
                continue
            if matrixA[nx][ny] != matrixB[nx][ny]:
                count = - 1
            visited[nx][ny] = 1
            q.append((nx,ny))
            flag = False
    if count == 0 and flag:
        if matrixA[row][col] == matrixB[row][col]:
            return 1
    if count == 0:
        return 1
    else:
        return 0
def countMatches(grid1, grid2):
    global N, M,visited
    N = len(grid1)
    M = len(grid1[0])
    result = 0
    for line in grid1:
        matrixA.append([int(x) for x in line])
    for line in grid2:
        matrixB.append([int(x) for x in line])
    for row in range(N):
        for col in range(M):
            if matrixB[row][col] != 0:
                if visited[row][col] == 0:
                     result += bfs(row,col)
    return result
grid1= [
    '0100',
    '1001',
    '0011',
'0011']

grid2= [
    '0101',
    '1001',
    '0011',
'0011']
print(countMatches(grid1,grid2))