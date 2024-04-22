import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for(int r=1; r<=n; r++) {
            for(int c=1; c<=n; c++) {
                if(r == c) map[r][c] = 0;
                else map[r][c] = 999999999;
            }
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map[x][y] = Math.min(map[x][y], value);
        }


        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }



        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(map[i][j] == 999999999) {
                    sb.append(0).append(" ");
                }
                else sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}