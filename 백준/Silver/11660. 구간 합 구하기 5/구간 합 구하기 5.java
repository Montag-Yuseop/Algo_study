import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr; // 구간을 돌 배열 선언
    static int[][] d;
    static StringBuilder sb = new StringBuilder();

    // 실행
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken()); // 표의 크기 N(배열 크기)
        int M = Integer.parseInt(st.nextToken()); // 합을 구할 횟수 M

        arr = new int[N][N]; // N x N 범위의 배열 선언
        d = new int[N+1][N+1]; // N+1 x N+1 범위의 합 배열 생성, 범위 오류가 생기지 않도록

        // N번의 배열 입력 수행
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 합배열 d 생성
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + arr[i-1][j-1];
            }
        }

        // 배열 입력 완료 후 M번의 수행
        for(int i = 0; i < M; i++){ // M의 크기만큼 반복
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            findAnswer(x1, y1, x2, y2);
        }

        System.out.println(sb);
    }

    private static void findAnswer(int x1, int y1, int x2, int y2) {
//        System.out.println(d[x2][y2] +" " + d[x1-1][y2] +" "+ d[x2][y1-1] +" "+ d[x1-1][y1-1]);
        sb.append(d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1]).append("\n");
    }


}