h, m = map(int, input().split())

if (m-45>=0):
    print(f'{h} {m-45}')
elif (m-45<0)&(h-1<0):
    print(f'{24-1} {15+m}')
else:

    print(f'{h-1} {15+m}')