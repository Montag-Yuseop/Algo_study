C = int(input())

for tc in range(1,C+1):
    a = list(map(int, input().split(' ')))
    sum = 0
    cnt = 0
    for i in range(len(a)):
        if i == 0:
            continue
        
        else:
            sum += a[i]

    for i in range(len(a)):
        if i == 0:
            continue
        
        else:
            if a[i] > (sum/a[0]):
                cnt += 1
    
    print(f'{(cnt/a[0])*100:.3f}%')