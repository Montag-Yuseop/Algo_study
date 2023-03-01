num1, num2, num3 = map(int, input().split())
income = 0

if num1 == num2 & num2 == num3:
    income = 10000 + ((num1) * 1000)


elif (num1 != num2) & (num1 != num3) & (num2 != num3) :
    if (num1 > num2 > num3) | (num1 > num3 > num2):
        income = num1 * 100
    
    elif (num1 <= num2 < num3) | (num2 <= num1 < num3):
        income = num3 * 100

    else:
        income = num2 * 100

else:
    if num1 == num2 or num1 == num3:
        income = 1000 + (num1 * 100)
    
    elif num2 == num3:
        income = 1000 + (num2 * 100)

print(income)