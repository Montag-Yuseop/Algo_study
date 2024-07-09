#include <iostream>
#include <string>

using std::string;
using std::cin;
using std::cout;

int main() {

	int N, M;

	cin >> N >> M;
	int answer = 0;

	for (int i = 0; i < N; i++) {
		int count = 0;
		string question;

		cin >> question;

		for (int j = 0; j < question.size(); j++) {
			if (question[j] == 'O') count++;
		}

		if (count >= (M / 2) + 1) answer++;
	}

	cout << answer;

	return 0;
}