import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int x = Math.abs(o1);
            int y = Math.abs(o2);

            if(x == y) return o1 - o2;
            return x - y;

        });
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();

            if(x == 0){
                if(pq.size() == 0){
                    sb.append(0+"\n");
                } else{
                    sb.append(pq.poll()+"\n");
                }
            } else {
                pq.offer(x);
            }

        }
        System.out.println(sb);

    }
}