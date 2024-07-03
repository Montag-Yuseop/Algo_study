import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String first = br.readLine();
    String second = br.readLine();
    String third = br.readLine();

    String[] keyword = {first, second, third};
    int[] answer = new int[4];

    outer:
    for (int i = 0; i < 3; i++) {
      boolean check = keyword[i].charAt(0) != 'F' && keyword[i].charAt(0) != 'B';

      if (check) {
        answer[i] = Integer.parseInt(keyword[i]);

        if (i == 0) {
          answer[3] = answer[i] + 3;
          break outer;
        } else if (i == 1) {
          answer[3] = answer[i] + 2;
          break outer;
        } else {
          answer[3] = answer[i] + 1;
        }
      }
    }

    if (answer[3] % 3 == 0 && answer[3] % 5 == 0) System.out.println("FizzBuzz");
    else if (answer[3] % 3 == 0) System.out.println("Fizz");
    else if (answer[3] % 5 == 0) System.out.println("Buzz");
    else System.out.println(answer[3]);
  }
}