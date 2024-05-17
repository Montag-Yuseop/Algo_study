import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        
        while(true) {
            int m = sc.nextInt();
            int w = sc.nextInt();
            if(m + w == 0) break;
            System.out.println(m+w);
        }

    }	
	
}