import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine(); // 초기 문자
        LinkedList<Character> base = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            base.add(s.charAt(i));
        }

        int N = Integer.parseInt(br.readLine()); // 명령어의 수
//        int index = s.length(); // index 탐색은 시간초과

        ListIterator<Character> iter = base.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }

        // 명령어 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "L" :
//                    if(index != 0) --index;
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case "D" :
//                    if(index != base.size()) ++index;
                    if(iter.hasNext()) iter.next();
                    break;
                case "B" :
//                    if(index > 0) {
//                        base.remove(index -1);
//                        --index;
//                    }
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P" :
//                    base.add(index, st.nextToken().charAt(0));
//                    ++index;
                    iter.add(st.nextToken().charAt(0));
                    break;
            }
        }

        for(char c : base) {
            sb.append(c);
        }

        System.out.println(sb);

    }
}