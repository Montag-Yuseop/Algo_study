import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer = 1; // 답 출력

        int start = 1;
        int end = 1;
        int sum = 1;
        while (end != N) {
            if (sum == N) {
                answer++;
                end++;
                sum += end;
            } else if(sum > N){
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(answer);
    }
}