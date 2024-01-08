import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a1 = st.nextToken();
            String a2 = st.nextToken();

            System.out.println(check(a1, a2));

        }

    }

    static String check(String s1, String s2) {
        int[] arr1 = trans(s1);
        int[] arr2 = trans(s2);

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) return "Impossible";
        }

        return "Possible";
    }

    static int[] trans(String base) {
        int[] result = new int[26];

        for (int i = 0; i < base.length(); i++) {
            Character c = base.charAt(i);

            ++result[c-97];
        }

        return result;
    }

}