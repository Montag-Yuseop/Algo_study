import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // 첫째 줄에 사람 수 N, 파티 수 M
    // 진실을 아는 사람 수와 그 사람의 번호
    // 파티 수와 사람의 번호

    static int[] parent; // 대표 노드
    static int[] knowPeople; // 진실을 아는 사람 배열
    static ArrayList<Integer>[] party; // 파티 정보 인접리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0; // 정답 담기

        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // 파티의 수

        parent = new int[N+1]; // 대표 노드 저장
        for(int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        int know = sc.nextInt(); // 2번 째 줄 진실을 아는 사람의 수
        knowPeople = new int[know];
        // 진실을 아는 사람을 배열에 저장해놓기
        for(int i = 0; i < know; i++) {
            knowPeople[i] = sc.nextInt();
        }

        party = new ArrayList[M];
        for(int i = 0; i < M; i++) {
            party[i] = new ArrayList<Integer>(); // 인접리스트 생성
            int partyPeople = sc.nextInt(); // 맨 앞에 나오는 파티 인원 수 저장
            for(int j = 0; j < partyPeople; j++) { // 파티 인원 수 만큼 돌면서 다음 정보를 인접리스트에 저장
                party[i].add(sc.nextInt());
            }
        }

        // 파티 사람들의 대표 노드를 수정한다
        for(int i = 0; i < M; i++) {
            int first = party[i].get(0); // 제일 앞에 있는 사람이 기준
            for(int j = 1; j < party[i].size(); j++) { // 해당 인접리스트만큼 순회하면서 union 연산
                union(first, party[i].get(j));
            }
        }

        for(int i = 0; i < M; i++) {
            boolean ok = true;
            int cur = party[i].get(0);
            for(int j = 0; j < knowPeople.length; j++) {
                if(find(cur) == find(knowPeople[j])) {
                    ok = false;
                    break;
                }
            }
            if(ok) ans++;
        }

        System.out.println(ans);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}