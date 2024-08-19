// 가장 많이 받은 선물 2024 KAKAO WINTER INTERNSHIP

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] mat = new int[n][n];
        int[] count = new int[n];
        Map<String, Integer> fr = new HashMap<>();

        for (int i = 0; i < n; i++) {
            fr.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] s = gift.split(" ");
            int giver = fr.get(s[0]);
            int receiver = fr.get(s[1]);
            mat[giver][receiver]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int giveItoJ = mat[i][j];
                int giveJtoI = mat[j][i];

                if (giveItoJ == giveJtoI) {
                    int give1 = Arrays.stream(mat[i]).sum();
                    int take1 = 0;
                    for (int k = 0; k < n; k++) {
                        take1 += mat[k][i];
                    }

                    int give2 = Arrays.stream(mat[j]).sum();
                    int take2 = 0;
                    for (int k = 0; k < n; k++) {
                        take2 += mat[k][j];
                    }

                    int diff1 = give1 - take1;
                    int diff2 = give2 - take2;

                    if (diff1 < diff2) {
                        count[j]++;
                    } else if (diff1 > diff2) {
                        count[i]++;
                    }
                } else if (giveItoJ > giveJtoI) { 
                    count[i]++;
                } else { 
                    count[j]++;
                }
            }
        }

        return Arrays.stream(count).max().orElse(0);
    }
}
