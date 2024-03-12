import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int S=sc.nextInt();

        if(T<=11){
            //아침
            System.out.println(280);
        }
        else if(T<=16){
            if(S==0){
                System.out.println(320);
            }
            else{
                System.out.println(280);
            }
        }
        else{
            System.out.println(280);
        }
    }
}