#include <stdio.h>
#pragma warning(disable:4996)

int main() {

	int A = 0, B = 0, C = 0, D = 0;

	scanf("%d %d %d %d", &A, &B, &C, &D);

	int answer = (A + D) - (B + C);

	if (answer < 0) answer *= -1;
	
	printf("%d", answer);

	return 0;
}