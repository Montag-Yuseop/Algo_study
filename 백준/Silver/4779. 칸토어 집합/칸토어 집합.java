import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();

            // 재귀를 돌리면서 가운데 빈칸으로 넣고 입력한다면?
            cantor(sb, N);
            System.out.println(sb);
        }


    }

    // 0번 -> -
    // 1번 -> - -(3번 중 2번)
    // 2번 -> - -   - - // 9번 중 4번
    // 3번 -> - -   - -         - -   - - // 27번 중 8번

    // 봐봐 N = 3이면
    // N = 2 * 3개(줄 빈 줄)
    // N = 2는 N = 1 3개(줄 빈 줄)
    // N = 1은 N = 0 3개(줄)
    // N = 0 >> "-"
    // N = 1 >> "- -"

    static void cantor(StringBuilder sb, int depth) {
        if(depth == 0) {
            sb.append("-");
            return;
        }

        cantor(sb, depth-1);
        for(int i = 0; i < Math.pow(3, depth-1); i++) {
            sb.append(" ");
        }
        cantor(sb, depth-1);


    }
}