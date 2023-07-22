import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i=0; i<N; i++) {
			String str1 = scan.next();
			String str2 = scan.next();
			int[] arr = new int[str1.length()];
			for(int j=0; j<str1.length(); j++) {
				if(str2.charAt(j) >= str1.charAt(j)) {
					arr[j] = str2.charAt(j) - str1.charAt(j);
				}
				else {
					arr[j] = str2.charAt(j) - str1.charAt(j) + 26;
				}
			}
			System.out.print("Distances: ");
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		scan.close();
	}

}