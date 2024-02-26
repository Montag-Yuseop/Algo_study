for _ in range(2):
    # 입력
    # 터치다운 / 필드 골 / 세이프티 / 터치다운 후 포인트 및 2포인트 전환의 수
    a, b, c, d, e = map(int, input().split())

    # 계산
    print(a*6+b*3+c*2+d+e*2, end=" ")