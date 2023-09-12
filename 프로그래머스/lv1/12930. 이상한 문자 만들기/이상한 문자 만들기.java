import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split("");
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(" ")) {
                idx = 0;
            } else {
                idx++;
            }
            
            if(idx % 2 != 0) { // 홀수면
                answer += arr[i].toUpperCase();
            } else {
                answer += arr[i].toLowerCase();
            }
            
            
        }
        
//         StringTokenizer st = new StringTokenizer(s);
//         int x = st.countTokens();
        
//         for(int tc = 0; tc < x; tc++) {
//             String temp = st.nextToken();
            
//             for(int i = 0; i < temp.length(); i++) {
//                 if(i%2 == 0) {
//                     answer += Character.toUpperCase(temp.charAt(i));
//                 } else {
//                     answer += Character.toLowerCase(temp.charAt(i));
//                 }
//             }
            
//             if(tc == x-1) {
//                 continue;
//             }
//             answer += " ";            
//         }
                
        
        
        return answer;
    }
}