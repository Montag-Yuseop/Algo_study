import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // D : n을 2배로, 9999보다 크면 10000으로 나눈 나머지를 저장
    // S : n - 1, n이 0이면 9999로
    // L : 왼쪽으로 한 칸씩, 1234 -> 2341
    // R : 오른쪽으로 회전, 1234 -> 4123
    static class Node {
        int start;
        String move;

        public Node(int start, String move) {
            this.start = start;
            this.move = move;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int start = sc.nextInt();
            int target = sc.nextInt();
            moveDslr(start, target);
            Arrays.fill(visited, false);
        }

        System.out.println(sb);

    }

    private static void moveDslr(int start, int target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, ""));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll(); // 시작 숫자

            if(cur.start == target){
                sb.append(cur.move +"\n");
                break;
            }
            int x = cur.start;

            // D 무브
            int dx = (2 * x) > 9999 ? (2 * x) % 10000 : 2 * x;
            if(!visited[dx]){
                q.offer(new Node(dx, cur.move+"D"));
                visited[dx] = true;
            }

            // S 무브
            int sx = x > 0 ? x-1 : 9999;
            if(!visited[sx]){
                q.offer(new Node(sx, cur.move+"S"));
                visited[sx] = true;
            }

            // L 무브
            int lx = (x % 1000) * 10 + (x / 1000);
            if(!visited[lx]){
                q.offer(new Node(lx, cur.move+"L"));
                visited[lx] = true;
            }

            // R 무브
            int rx = (x%10) * 1000 + (x / 10);
            if(!visited[rx]){
                q.offer(new Node(rx, cur.move+"R"));
                visited[rx] = true;
            }

        }

    }

}