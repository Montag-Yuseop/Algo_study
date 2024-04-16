import sys
input = sys.stdin.readline

pro = [12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6]
pan = [1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773]

N = int(input())
print(pro[N-1], pan[N-1])