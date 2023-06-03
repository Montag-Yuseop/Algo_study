import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BigInteger sum = new BigInteger("1");
        int cnt = 0;


        for(int i = 2; i < n+1; i++){
            sum = sum.multiply(BigInteger.valueOf(i));
        }

        String s = sum.toString();
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                cnt++;
            } else{
                break;
            }
        }

        System.out.println(cnt);

    }
}