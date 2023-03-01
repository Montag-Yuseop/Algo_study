T = int(input())

score = list(map(float, input().split()))
max_score = max(score)
sum = 0

for i in range(len(score)):
    score[i] = (score[i]/max_score)*100
    sum += score[i]


print(sum/T)