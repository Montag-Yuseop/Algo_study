#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T; cin >> T;
	while (T--) {
		string s1, s2; cin >> s1 >> s2;
		if (s1 == s2) cout << "OK\n";
		else cout << "ERROR\n";
	}
}