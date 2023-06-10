import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[] map = new char[M+2];
        int ans = 0;
        String s = sc.next();

        for(int i = 0; i < M; i++){
           map[i] = s.charAt(i);
        }

        for(int i = 0; i < M-2; i++){
            if(map[i+1] == 'O' && map[i+2] == 'I') {
                int temp = 0;
                while(map[i] == 'I' && map[i+1] == 'O') {
                    i += 2;
                    temp++;

                    if(map[i] == 'I' && temp == N){
                        ans++;
                        temp--;
                    }

                }
            }
        }

        System.out.println(ans);


    }
}