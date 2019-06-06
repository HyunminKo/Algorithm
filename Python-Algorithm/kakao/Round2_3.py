def teamFormation(score, team, m):
    teamSquad = []
    while team > 0:
        if len(score) > m:
            A = score[:m]
            B = score[len(score) - m:]

            s1 = A[0]
            index1 = 0
            s2 = B[0]
            index2 = 0

            for i in range(len(A)):
                if s1 < A[i]:
                    s1 = A[i]
                    index1 = i

            for i in range(len(B)):
                if s2 < B[i]:
                    s2 = B[i]
                    index2 = len(score) - m + i
            if index2 == 0:
                index2 = len(score) - m
            if s1 > s2:
                teamSquad.append(s1)
                score.pop(index1)
            elif s2 > s1:
                teamSquad.append(s2)
                score.pop(index2)
            else:
                teamSquad.append(s1)
                score.pop(index1)
            team -= 1
        else:
            s = score[0]
            index = 0
            for i in range(len(score)):
                if s < score[i]:
                    s = score[i]
                    index = i
            teamSquad.append(s)
            score.pop(index)
            team -= 1
    return sum(teamSquad)
# score = [17,12,10,2,7,2,11,20,8]
# team = 3
# m = 4
score = [18,
5,
15,
18,
11,
15,
9,
7]
team = 5
m = 1
print(teamFormation(score,team,m))