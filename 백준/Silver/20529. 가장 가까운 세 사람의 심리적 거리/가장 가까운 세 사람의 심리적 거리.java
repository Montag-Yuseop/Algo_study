import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){
            int N = sc.nextInt();
            int ans = Integer.MAX_VALUE;
            String[] map = new String[N];

            for(int i = 0; i < N; i++){
                map[i] = sc.next();
            }

            // 최악의 경우, 모두 MBTI가 다를 때 33명부터는 거리가 항상 0임 - 비둘기집
            if(N > 32) {
                ans = 0;
            } else {
                for(int i = 0; i < N-2; i++){
                    for(int j = i+1; j < N-1; j++){

                        for(int k = j+1; k < N; k++){
                            int sum = 0;
                            for(int d = 0; d < 4; d++){
                                if(map[i].charAt(d) != map[j].charAt(d)) {
                                    sum++;
                                }
                                if(map[i].charAt(d) != map[k].charAt(d)) {
                                    sum++;
                                }
                                if(map[j].charAt(d) != map[k].charAt(d)) {
                                    sum++;
                                }
                            }
                            ans = Math.min(ans, sum);

                        }

                    }
                }
            }

            System.out.println(ans);

        }


    }
}