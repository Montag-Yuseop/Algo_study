import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 공통인 부분 빼고 다른 부분은 없애버리면 된다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int ans = compare(s1, s2);

        System.out.println(ans);
    }

    static int compare(String s1, String s2) {
        int result = 0;

        int[] arr1 = transform(s1);
        int[] arr2 = transform(s2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                result += Math.abs(arr1[i] - arr2[i]);
            }
        }

        return result;

    }

    static int[] transform(String s) {
        int[] result = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ++result[s.charAt(i)-97];
        }

        return result;
    }
}