# 4673 셀프넘버

def self_number(num):
    self_num = num

    while num != 0:
        self_num += num%10
        num //=10

    return self_num

list_self_number = []

for i in list(range(1, 10001)):
    list_self_number.append(self_number(i))
    if i not in list_self_number:
        print(i)