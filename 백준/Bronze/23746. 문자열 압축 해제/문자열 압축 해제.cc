#include <iostream>
#include <string>
#include <vector>
#include <utility>

using std::string;
using std::vector;
using std::cin;
using std::cout;
using std::pair;

int main() {
	int N;
	cin >> N; // N 입력

	vector<pair<string, char>> keyword;

	for (int i = 0; i < N; i++) {
		string s1;
		char s2;
		cin >> s1 >> s2;
		keyword.push_back(make_pair(s1, s2));
	}

	string after, before;
	cin >> after;

	int startIdx, endIdx;
	cin >> startIdx >> endIdx;

	// 모든 입력 종료, after 문자를 기반으로 replace 진행
	// 키워드를 기반으로 루프 진행
	for (int i = 0; i < after.size(); i++) {
		for (int j = 0; j < keyword.size(); j++) {
			if (after[i] == keyword[j].second) {
				before += keyword[j].first;
				break;
			}
		}
		
	}
	cout << before.substr(startIdx - 1, endIdx - startIdx + 1);

	return 0;
}