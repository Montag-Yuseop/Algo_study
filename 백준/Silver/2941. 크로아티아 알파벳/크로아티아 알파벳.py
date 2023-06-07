croatia = ['c=', 'c-', 'd-', 'lj', 'nj', 's=']
str = input()
cnt, croaNum, onlyZ, plusD = 0, 0, 0, 0


for i in croatia:
    cnt += str.count(i)
    # print(f'i: {i}, cnt: {cnt}')
    croaNum += str.count(i)*len(i)
    # if str.count(i) > 0:
    #     croaNum += len(i)
    #     print(f'str.count(i): {str.count(i)}')
    #     print(f'croaNum: {croaNum}')

if "dz=" in str:
    onlyZ = str.count("z=") - str.count("dz=")
    plusD = str.count("dz=")
    cnt += onlyZ + plusD
    croaNum += (onlyZ * 2) + (plusD * 3)
else:
    onlyZ = str.count("z=")
    cnt += onlyZ
    croaNum += onlyZ * 2

# print(f'cnt: {cnt}')
# print(f'len(str): {len(str)}')
# print(f'croaNum: {croaNum}')

print(cnt + (len(str) - croaNum))