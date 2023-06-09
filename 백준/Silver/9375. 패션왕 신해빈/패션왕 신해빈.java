import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){
            HashMap<String, Integer> hs = new HashMap<>();

            int N = sc.nextInt();
            for(int i = 0; i < N; i++){
                String name = sc.next();
                String type = sc.next();

                if(hs.containsKey(type)){
                    hs.replace(type, hs.get(type) + 1);
                } else {
                    hs.put(type, 2);
                }
            }

            int ans = 1;

            for(int s : hs.values()){
                ans *= s;
            }

            System.out.println(ans -1);

        }

    }

}