import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    // 1. String 배열에 입력받은 명령어 저장
    // 2. Set에 키워드 저장하기(대문자 소문자 구별 없으므로 둘 다 저장)
    // 3. Set에 없으면 키워드 입력 및 괄호 삽입
    // 4. Set에 있는 경우에는 다음 문자 넣고, 앞에꺼 넣어보다가 다 안되면 다음 단계로
    // 5. Set에 앞 키워드들이 다 있으면 전체 돌면서 없는 키워드 삽입
    // 6. 키워드 설정했으면 괄호 넣어주기
    // 7. 다 돌았는데도 삽입이 안되면 그대로 출력

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            boolean regist = false;

            // 1단계
            String[] temp = br.readLine().split(" ");

            // 2단계
            for(int j = 0; j < temp.length; j++) {
                if(!set.contains(temp[j].charAt(0))){ // set에 없으면
                    set.add(Character.toLowerCase(temp[j].charAt(0)));
                    set.add(Character.toUpperCase(temp[j].charAt(0)));
                    // 3단계
                    temp[j] = "[" + temp[j].substring(0,1) + "]" +temp[j].substring(1);
                    regist = true;
                    break;
                }
            }
            // 4단계 시작 조건 regist
            if(!regist) {
                // 5단계 - 괄호 삽입 못 한 경우
                for(int j = 0; j < temp.length; j++) {
                    for(int k = 1; k < temp[j].length(); k++) {
                        if(!set.contains(temp[j].charAt(k))) {
                            set.add(Character.toLowerCase(temp[j].charAt(k)));
                            set.add(Character.toUpperCase(temp[j].charAt(k)));
                            temp[j] = temp[j].substring(0, k) + "[" + temp[j].substring(k, k+1) + "]" +
                                    temp[j].substring(k+1);
                            regist = true;
                            break;
                        }
                    }
                    if(regist) break;
                }
            }
            // 출력
            for(int j = 0; j < temp.length; j++) {
                System.out.print(temp[j]+" ");
            }
            System.out.println();

        }

    }
}