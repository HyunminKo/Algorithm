T = int(input())
for test_case in range(1, T + 1):
    a = input().split(" ")
    print(a[1])
    result =''

    for element in a[1]:
        if element == 'A':
            result += '1010'
        elif element == 'B':
            result += '1011'
        elif element == 'C':
            result += '1100'
        elif element == 'D':
            result += '1101'
        elif element == 'E':
            result += '1110'
        elif element == 'F':
            result += '1111'
        else:
            b = int(element)
            c = []
            while b > 0:
                c.append(b % 2)
                b = int(b / 2)
            for i in range(4-len(c)):
                c.append(0)
            c = c[::-1]
            result += ''.join(str(x) for x in c)
    print('#{}'.format(test_case),result)
