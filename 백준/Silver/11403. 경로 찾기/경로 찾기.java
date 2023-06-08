import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int r = 0; r < N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++){
                int x = Integer.parseInt(st.nextToken());
                map[r][c] = x;
            }
        }

        // 플로이드 워셜
        // 정점의 수 만큼 돌면서, r-k가 1이고, k-c가 1이면(연결되어 있으면), r,c를 1로 변경
        for(int k = 0; k < N; k++){
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    if(map[r][k] == 1 && map[k][c] == 1){
                        map[r][c] = 1;
//                        System.out.println("k: "+ k +" r: "+ r+" c: "+c);
//                        for(int j = 0; j < N; j++){
//                            System.out.println(Arrays.toString(map[j]));
//                        }
//                        System.out.println();
                    }
                }
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                sb.append(map[r][c] +" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}