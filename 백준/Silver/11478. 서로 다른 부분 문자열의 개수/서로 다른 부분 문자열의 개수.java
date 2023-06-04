import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        String s = sc.next();

        for(int i = 0; i <= s.length(); i++){

            for(int j = i+1; j <= s.length(); j++){
                String temp = s.substring(i, j);
                hs.add(temp);
            }
        }

        System.out.println(hs.size());
    }
}