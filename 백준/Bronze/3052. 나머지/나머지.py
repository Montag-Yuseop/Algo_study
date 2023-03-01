a = []
b = []

for i in range(10):
    a.append(int(input())%42)

for j in range(10):
    if a[j] not in b:
        b.append(a[j])

    else:
        continue

print(len(b))
