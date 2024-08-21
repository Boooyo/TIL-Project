// 월간 코드 챌린지 시즌1 문자열의 아름다움
// 41.2 / 100.0 개선 필요 08.21

import java.util.*;

public class Solution {

    public static int solution(String s) {
        Map<Character, Map<Integer, Integer>> countByLenByCh = new HashMap<>();

        int n = s.length();

        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) != s.charAt(i - 1)) {
                char ch = s.charAt(i - 1);
                countByLenByCh.putIfAbsent(ch, new HashMap<>());
                Map<Integer, Integer> lengthMap = countByLenByCh.get(ch);
                lengthMap.put(count, lengthMap.getOrDefault(count, 0) + 1);
                count = 1;
            } else {
                count++;
            }
        }

        int answer = (n - 1) * n * (n + 1) / 6;

        for (Map<Integer, Integer> countByLen : countByLenByCh.values()) {
            int t = countByLen.values().stream().mapToInt(Integer::intValue).sum();
            int sum = countByLen.entrySet().stream()
                .mapToInt(e -> e.getKey() * e.getValue()).sum();

            for (int l = 1; l <= Collections.max(countByLen.keySet()); l++) {
                answer -= sum * (sum - 1) / 2;
                sum -= t;
                t -= countByLen.getOrDefault(l, 0);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ababbab")); 
    }
}
