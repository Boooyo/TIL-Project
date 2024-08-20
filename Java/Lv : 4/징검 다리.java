import java.util.*;

public class Solution {
    
    public static boolean canAchieve(int minDist, int[] rocks, int n) {
        int deleteCount = 0;
        int prevRock = 0;
        
        for (int rock : rocks) {
            int dist = rock - prevRock;
            if (dist < minDist) {
                deleteCount++;
                if (deleteCount > n) {
                    return false;
                }
            } else {
                prevRock = rock;
            }
        }
        
        return true;
    }
    
    public static int solution(int distance, int[] rocks, int n) {
        int left = 1;
        int right = distance;
        
        Arrays.sort(rocks);
        int[] extendedRocks = new int[rocks.length + 1];
        System.arraycopy(rocks, 0, extendedRocks, 0, rocks.length);
        extendedRocks[rocks.length] = distance;
        
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAchieve(mid, extendedRocks, n)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        int result = solution(distance, rocks, n);
        System.out.println(result);
    }
}
