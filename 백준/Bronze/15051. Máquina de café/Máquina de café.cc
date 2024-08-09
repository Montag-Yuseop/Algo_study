#include <iostream>
#include <algorithm>

using namespace std;

int main ()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
    int a, b, c;
	cin >> a >> b >> c;

	int result = min(b * 2 + c * 4, min(a * 2 + c * 2, a * 4 + b * 2));

	cout << result << "\n";

	return 0;
}