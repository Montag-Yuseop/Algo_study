import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int start = 0;
        int end = people.length-1;
        
        Arrays.sort(people);
        // System.out.println(Arrays.toString(people));
        
        while(start <= end) {
            int l = people[start];
            int r = people[end];
            
            int sum = l + r;
            
            if(sum > limit) {
                --end;
                ++answer;
            } else {
                ++start;
                --end;
                ++answer;
            }
            
        }
        
        return answer;
    }
}