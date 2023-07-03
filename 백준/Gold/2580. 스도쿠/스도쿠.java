import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 스도쿠 채우는 방법
    // 0, 0부터 탐색하면서, 만약 해당 값이 0이면 탐색(미리 지정)
    // 몇 개가 0으로 주어질 것인지 사이즈를 모르기 때문에, list를 활용
    // 행, 열, 3x3 탐색을 통해 들어갈 수 있는 값 만들기

    static int[][] map = new int[9][9];
    static ArrayList<int[]> empty = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스도쿠 배열 생성
        for(int r = 0; r < 9; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < 9; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 0) {
                    empty.add(new int[] {r, c}); // 빈 공간 저장
                }
            }
        }

        sudoku(0);
    }

    static void sudoku(int cnt) {
        // 종료 조건
        if(cnt == empty.size()) {
            StringBuilder sb = new StringBuilder();
            for(int r = 0; r < 9; r++) {
                for(int c = 0; c < 9; c++) {
                    sb.append(map[r][c] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0); // 프로그램 종료
        }

        // 1~9까지 넣으면서 탐색 진행
        int[] next = empty.get(cnt); // 다음 빈 칸 가져오기
        int x = next[0];
        int y = next[1];
        for(int i = 1; i < 10; i++) {
            if(isOk(x, y, i)) { // 만약 map[x][y] = i가 가능하다면(탐색)
                map[x][y] = i;
                sudoku(cnt+1);
                map[x][y] = 0; // 다시 0으로 초기화 해주기
            }
        }

    }

    static boolean isOk(int x, int y, int num) {

        // 가로 세로 탐색
        for(int i = 0; i < 9; i++) {
            if(map[x][i] == num) {
                return false; // 하나라도 걸리면 false; 반환
            }
            if( map[i][y] == num) {
                return false; // 하나라도 걸리면 false; 반환
            }
        }

        // 3x3 탐색
        int nx = x/3;
        int ny = y/3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(map[(nx*3)+i][(ny*3)+j] == num){
                    return false;
                }
            }
            // x가 0 1 2 면, 0부터 시작, 3 4 5면 3부터 시작, 6 7 8이면 6부터 시작해야 하므로
            // *3을 해준다
            // y도 마찬가지
        }


        return true; // 다 통과하면 true
    }

}