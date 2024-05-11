import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double weightOnE = 0;
        while(true) {
            weightOnE = sc.nextDouble();
            if(weightOnE < 0) break;
            double weightOnM = weightOnE * 0.167;
            System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n",
                             weightOnE, weightOnM);
        }
        sc.close();
    }
}