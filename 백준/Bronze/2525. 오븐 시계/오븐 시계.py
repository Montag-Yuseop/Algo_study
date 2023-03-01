hour, minute = map(int, input().split())
time = int(input())

if minute+time >= 60:
    plus = (minute + time) // 60
    if hour + plus >= 24:
        a = hour + plus - 24
        print(f'{a} {(minute + time) - (60*plus)}')
    
    else:
        print(f'{hour + plus} {(minute + time) - (60*plus)}')


else:
    if hour >= 24:
        print(f'{hour-24} {minute + time}')
    
    else:
        print(f'{hour} {minute + time}')