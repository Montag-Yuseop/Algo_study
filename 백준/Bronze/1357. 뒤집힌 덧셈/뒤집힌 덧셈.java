import java.util.Scanner;

public class Main {

    // 숫자 뒤집는 메서드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(Rev(Rev(x)+Rev(y)));

    }

    static int Rev(int x) {
        String temp = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        sb.reverse();


        return Integer.parseInt(String.valueOf(sb));
    }

}