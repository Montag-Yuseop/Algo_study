import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("-");

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(arr[i], "+");
            int temp = 0;
            while(st.hasMoreTokens()){
                 temp += Integer.parseInt(st.nextToken());
            }

            if(i == 0){
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}