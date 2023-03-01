count = 0
x = int(input())
n = int(input())


for i in range(n):
    a,b = map(int, input().split())
    count += a*b

if count == x:
    print('Yes')

else:
    print('No')
