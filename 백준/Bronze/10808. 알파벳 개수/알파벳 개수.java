import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 각 알파벳이 단어 S에 몇 개 포함되어 있는지 확인하는 문제

        // 1. 알파벳 배열을 생성한다(char 형태이므로, -를 해서 0부터 시작하도록 한다)
        // a는 97부터 시작한다
        int[] alphabet = new int[26];

        // 2. 단어 S를 입력받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            ++alphabet[c-97];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alphabet.length; i++) {
            if (i == 25) {
                sb.append(alphabet[i]);
            } else {
                sb.append(alphabet[i]).append(" ");
            }
        }

        System.out.println(sb);

    }

}