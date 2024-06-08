import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // N과 M이 주어진다
    // N은 몇 주 동안
    // M은 몇 명의 랭킹 정보인지
    // 각 값은 선수 번호
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      Map<Integer, Integer> map = new HashMap<>();

      // 종료 조건 0, 0 설정
      if (N == 0 && M == 0) break;

      // N개의 행을 진행하면서 선수 번호들을 모두 map에 저장
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
          int now = Integer.parseInt(st.nextToken());

          // map에 없으면 0을 기본값으로, 있으면 해당 값을 가져와서 + 1
          map.put(now, map.getOrDefault(now, 0) + 1);
        }
      }
      // 모든 정보를 저장했으면 map을 value순으로 정렬해서 출력해야함
      // value를 기준으로 해야하며, 1등은 제외해야한다
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      for (int i = 0; i <= 500; i++) {
        list.add(new ArrayList<>());
      }

      // map의 내용을 list로 담아주기
      for (int i : map.keySet()) {
        int cnt = map.get(i);
        list.get(cnt).add(i);
      }

      // list에 다 담긴 내용을 거꾸로 돌면서 size가 0이 아닌경우만 찾아
      // 처음은 건너뛰고 두번째를 정렬해서 출력
      int cnt = 0;
      for (int i = 500; i >= 0; i--) {
        ArrayList<Integer> temp = list.get(i);
        if (temp.size() == 0) continue;
        cnt++;
        if (cnt == 1) continue;

        Collections.sort(temp);
        for (int num : temp) {
          sb.append(num).append(" ");
        }
        sb.append("\n");
        break;
      }
    }

    System.out.println(sb);
  }
}