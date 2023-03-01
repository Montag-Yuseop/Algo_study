
T = int(input())

for tc in range(T):
    list_ox = list(map(str, input()))
    list_score = [0 for sc in range(len(list_ox))]
    
    for i in range(len(list_ox)):
        if i == 0:
            if list_ox[0] == "O":
                list_score[i] = 1

        elif i > 0:
            if list_ox[i] == 'O':
                list_score[i] = list_score[i-1] + 1
            
            else:
                list_score[i] = 0
    
    list_sum = sum(list_score)
    print(list_sum)