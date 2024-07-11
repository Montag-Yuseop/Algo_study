#include <iostream>
#include <string>
#include <vector>
#include <utility>

using std::vector;
using std::string;
using std::cin;
using std::cout;
using std::pair;

const auto npos = std::string::npos;// 별칭 정의?

int main() {
	int N;
	cin >> N; // N 입력

	vector<pair<string, string>> keyword;

	for (int i = 0; i < N; i++) {
		string s1, s2;
		cin >> s1 >> s2;
		keyword.push_back(make_pair(s1, s2));
	}

	string after;
	cin >> after;

	int startIdx, endIdx;
	cin >> startIdx >> endIdx;

	// 모든 입력 종료, after 문자를 기반으로 replace 진행
	// 키워드를 기반으로 루프 진행
	for (int i = 0; i < keyword.size(); i++) {
		string from = keyword[i].first; // from
		string to = keyword[i].second; // to

		// to를 다시 from으로 변경
		while (after.find(to) != -1) {
			after.replace(after.find(to), to.length(), from);
		}
	}
	cout << after.substr(startIdx-1, endIdx - startIdx + 1);

	return 0;
}