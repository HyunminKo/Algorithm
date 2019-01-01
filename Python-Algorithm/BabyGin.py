T = int(input())

def runOrTriplet(cards):
    for i in range(len(cards)):
        if cards[i] != 0:
            if cards[i] == 3:
                return True
            else:
                if i + 2 < len(cards):
                    if cards[i] >= 1 and cards[i+1] >= 1 and cards[i+2] >= 1:
                        return True
    return False

def whoWin(cardsOfA, cardsOfB):
    isFinished = runOrTriplet(cardsOfA)
    if isFinished:
        return 1, isFinished
    isFinished = runOrTriplet(cardsOfB)
    if isFinished:
        return 2, isFinished
    return -1, isFinished


for test_case in range(1, T+1):
    result = -1
    game = list(map(int,input().split()))
    i = 0
    playerOne = []
    playerTwo = []
    while i < len(game):
        playerOne.append(game[i])
        playerTwo.append(game[i+1])
        i += 2
    cardsOfA = [0] * 10
    cardsOfB = [0] * 10
    for i, (a,b) in enumerate(zip(playerOne,playerTwo)):
        cardsOfA[a] += 1
        cardsOfB[b] += 1
        result,isFinished = whoWin(cardsOfA,cardsOfB)
        if isFinished:
            break
    if result == -1:
        print('#{}'.format(test_case), 0)
    else:
        print('#{}'.format(test_case),result)

