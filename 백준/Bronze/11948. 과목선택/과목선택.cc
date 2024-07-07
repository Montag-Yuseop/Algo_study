#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using std::string;
using std::cin;
using std::cout;

int main() {
    
    // 물, 화, 생, 지 4개 중 3개 선택
    // 역, 지 2개 중 1개 선택

    // 점수를 최대로

    // 입력 6개 받음, 시간 복잡도 상수항
    // vector를 정렬한 뒤 앞에 3개를 더하고,
    // 다른 vector에서 앞에 1개만 더하면 최댓값이 나온다

    // 또는 4개를 다 더한 뒤 가장 작은 값을 뺀다
    // 이후 2개 중 큰 값을 더한다

    
    int min = 101;
    int sum = 0;

    for (int i = 0; i < 4; i++) {
        int now;

        cin >> now;

        sum += now;
        min = std::min(min, now);
    }

    sum -= min;
    min = 101;

    for (int i = 0; i < 2; i++) {
        int now;

        cin >> now;

        sum += now;
        min = std::min(min, now);
    }

    sum -= min;

    cout << sum;

    return 0;
}