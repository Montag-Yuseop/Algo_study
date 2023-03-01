homework = []

for i in range(28):
    homework.append(int(input()))

for j in range(30):
    if j+1 not in homework:
        print(j+1)
    else:
        continue