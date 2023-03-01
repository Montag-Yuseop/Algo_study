import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int max = Integer.MIN_VALUE;
		int N = sc.nextInt(); // 처음 입력받는 수
		int[] arr = null;
		//
		for (int i = N/2; i <= N; i++) {

			int nowNum = N;
			int nextNum = i;
			int sum = 2;

			while (nowNum > 0) {
				int temp = 0;
				nowNum -= nextNum;
				temp = nextNum;
				nextNum = nowNum;
				nowNum = temp;
				if (nextNum < 0)
					break;
				else {
					sum++;
					max = Math.max(max, sum);
//					
					if (max == sum) {
						arr = new int[max];
						arr[0] = N;
						arr[1] = i;
						for (int k = 2; k < max; k++) {
							arr[k] = arr[k - 2] - arr[k - 1];
						}

					}

				}

			}

		}

		System.out.println(max);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}