import sys
testcase = int(sys.stdin.readline())

for i in range(testcase):
    a, b = map(int, sys.stdin.readline().split())
    print(a+b)