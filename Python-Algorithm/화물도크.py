T = int(input())

class Task:
    def __init__(self,start,end):
        self.startTime = start
        self.endTime = end

    def __str__(self):
        return '[start: {}, end: {}]'.format(self.startTime,self.endTime)

    def __lt__(self, other):
        return self.endTime < other.endTime

for test_case in range(1, T+1):
    result = 0
    numOfTasks = int(input())
    tasks = []
    for i in range(numOfTasks):
        s,e = map(int, input().split())
        tasks.append(Task(s,e))
    tasks.sort()
    endTime = 0
    for index in range(len(tasks)):
        if endTime <= tasks[index].startTime:
            result += 1
            endTime = tasks[index].endTime
    print('#{}'.format(test_case),result)