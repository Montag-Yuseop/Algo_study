import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // 이동 1칸에 배터리 1칸
        // 순간이동은 이동 거리의 2배 이동인데, 배터리 소모 0
        // 5칸 이동(1칸 - 순간(2) - 순간(4) - 1칸)
        
        // 2로 최대한 나눈 다음 더 안나눠질 때 한칸 가면될듯?
        // 2진수 사용 가능
        
        ans = Integer.bitCount(n);
        
        return ans;
    }
}