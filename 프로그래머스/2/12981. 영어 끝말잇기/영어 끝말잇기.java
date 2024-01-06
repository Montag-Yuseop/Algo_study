class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int cnt = 0;

        outer: for(int i = 1; i < words.length; i++) {
            // 1. 전 단어의 마지막 글자와 비교하기
            char last = words[i-1].charAt(words[i-1].length()-1);
            char first = words[i].charAt(0);
            // System.out.println("last = " + last + " first = " + first);
            
            if(last != first) {
                cnt = i+1;
                // System.out.println("글자 다름");
                break outer;
            }
            
            for(int j = 0; j < i; j++) {
                if(words[i].equals(words[j])) {
                    cnt = i+1;
                    // System.out.println("단어 중복");
                    break outer;
                }
            }
        
        }
        // 3. 하나라도 충족이 안되면 해당 단어가 몇 번째인지 가져오기
        // 4. n으로 나누면 몇 번째 유저의 몇 번째 순서인지 나올 것
        int a = cnt / n;
        int b = cnt % n;
        // System.out.println("a = " + a + " b = " + b + " cnt = " + cnt);
        if(cnt == 0) return answer;
        
        
        if(b > 0) {
            a += 1;
            
            answer[0] = b;
            answer[1] = a;
        } else {
            answer[0] = n;
            answer[1] = a;
        }
        
        // System.out.println("a = " + a + " b = " + b);
        

        return answer;
    }
}