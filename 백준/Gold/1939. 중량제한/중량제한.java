import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N개의 섬으로 이루어진 나라
    // 두 개의 섬에 공장을 세워서 운송
    // 다리마다 중량 제한이 있으며, 중량이 넘으면 안된다

    // 최대 중량을 출력

    // BFS로 최대 중량을 탐색하면서 이동

    public static class Node {
        int x, w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    static boolean[] visited; // 시작노드부터 연결되어있는지 확인만 하면 되기 때문에, 굳이 2차원 배열 노필요
    static ArrayList<Node>[] adj;
    static int N, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 인접 리스트의 배열 생성 (0번 노드는 안씀)
        adj = new ArrayList[N+1];

        // 인접 리스트에 노드 수 만큼 리스트 추가
        for(int i = 0 ; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        // 인접 리스트에 정보 저장
        // 이분 탐색의 최소 중량과 최대 중량 변수 생성
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[x].add(new Node(y, w));
            adj[y].add(new Node(x, w));

            left = Math.min(left, w);
            right = Math.max(right, w);
        }

        // 시작 노드와 종료 노드 저장
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int ans = 0;
        // 중량 값을 변경하면서 이분 탐색 시작
        // left와 right의 값이 같을 경우에도 진행을 함 해줘야 하기 떄문에 
        while(left <= right) {
            int mid = (left + right) / 2;
            // 방문 배열 생성 - > 반복마다 초기화
            visited = new boolean[N+1];
            // 방문배열이 참 일 경우 > 방문배열 안에는 현재 내가 이분탐색한 중량의 중간값 저장
            if(bfs(mid)) {
                // 미드 값을 넣고 탐색했을 때, 중량이 초과가 안나면? 우측으로 이동하고
                left = mid + 1;
                // ans값을 현재의 mid값으로 변경
                ans = mid;
            } else {
                // 초과나면 좌측으로 이동하고 값 그대로
                right = mid-1;
            }
        }
        System.out.println(ans);
        
    }
    
    public static boolean bfs(int mid) {
        // 큐 생성
        Queue<Node> q = new LinkedList<>();

        visited[start] = true; // 시작점 방문처리
        q.offer(new Node(start, 0)); // 시작점은 중량값 없음, bfs탐색 시작

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.x == end) {
                return true;
            }
            // 인접 리스트에 저장된 다음 노드를 하나씩 꺼내오면서
            // 다음 불러올 노드의 중량값이 mid값보다 작거나 같을때만 진행 + 방문한 적 없는 경우
            // 중량값을 더할 필요 없이, 연결된 노드들 중에서 가장 중량값이 작은 녀석이, 내가 옮길 중량보다만
            // 큰 경우를 찾는다
            for(int i = 0; i < adj[cur.x].size(); i++) {
                if(!visited[adj[cur.x].get(i).x] && adj[cur.x].get(i).w >= mid) {
                    visited[adj[cur.x].get(i).x] = true;
                    q.offer(adj[cur.x].get(i));
                }
            }
        }
        return false; // 위의 경우에서 통과를 못할 경우 false 반환하고 다른 mid값 탐색
    }

}