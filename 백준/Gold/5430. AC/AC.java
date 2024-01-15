import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

//            String key = br.readLine();
//            key = key.substring(1, key.length() - 1);

            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            Deque<Integer> dq = new ArrayDeque<>();

            // dq 생성
            while (st.hasMoreTokens()) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean isOk = true;

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);

                if(c == 'R') reverse = !reverse;
                if(c == 'D') {
                    if(dq.isEmpty()) {
                        isOk = false;
                        break;
                    }

                    if (reverse) dq.removeLast();
                    else dq.removeFirst();
                }
            }

            if(isOk) {
                sb.append("[");
                if(dq.isEmpty()){
                    sb.append("]\n");
                    continue;
                }

                if(reverse) {
                    sb.append(dq.pollLast());

                    while(!dq.isEmpty()){
                        sb.append(",").append(dq.pollLast());
                    }
                }

                else {
                    sb.append(dq.pollFirst());

                    while (!dq.isEmpty()) {
                        sb.append(",").append(dq.pollFirst());
                    }
                }
                sb.append("]\n");
            }
            else sb.append("error\n");

        }

        System.out.println(sb);
    }
}