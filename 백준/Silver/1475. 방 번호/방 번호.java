import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // String 형태로 받아서, char -> int 형 배열로 변경하여 입력
        // 비교할 배열 우선 생성
        int[] num = new int[9]; // 0 ~ 8

        String s = br.readLine();

        // 9는 어차피 6과 같으므로, 6은 /2로 한다
        for (int i = 0; i < s.length(); i++) {
            int nowNum = s.charAt(i)-'0';
            if(nowNum == 9) nowNum = 6;

            ++num[nowNum];
        }

        num[6] = (int) Math.ceil((double) num[6] / 2);

        int ans = 0;

        for (int i = 0; i < 9; i++) {
            ans = Math.max(ans, num[i]);
        }

        System.out.println(ans);
    }
}