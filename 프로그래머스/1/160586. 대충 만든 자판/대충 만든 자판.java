class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // 목표 target 만큼 반복하며 체크하자
        for(int i = 0; i < targets.length; i++) {
            String target = targets[i]; // 현재 내 target
            
            int result = pushKey(target, keymap);
            
            answer[i] = result;
        }
        
        return answer;
    }
    
    public int pushKey(String target, String[] keymap) {
        int count = 0;
        // key와 target의 차이
        for(int i = 0; i < target.length(); i++) {
            char c1 = target.charAt(i); // target 문자의 글자
            int temp = Integer.MAX_VALUE;
            boolean isOk = false;
            for(int j = 0; j < keymap.length; j++) {
                inner: for(int k = 0; k < keymap[j].length(); k++) {
                    char c2 = keymap[j].charAt(k); // 비교할 글자
                    if(c1 == c2) {
                        temp = Math.min(temp, k + 1);
                        isOk = true;
                        break inner;
                    }
                }
            }
            if(!isOk) return -1;
            if(temp != Integer.MAX_VALUE) count += temp;
            
        }
        
        if(count == 0) return -1;
        else return count;
    }
}