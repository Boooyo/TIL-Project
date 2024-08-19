// 2023 KAKAO BLIND RECRUITMENT 택배 배달과 수거하기

import java.util.Arrays;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dstart = n - 1;
        int pstart = n - 1;
        int dtotal = Arrays.stream(deliveries).sum();
        int ptotal = Arrays.stream(pickups).sum();

        while (dtotal > 0 || ptotal > 0) {
            int currentCap = cap;
            int index = -1;
            for (int i = dstart; i >= 0; i--) {
                if (deliveries[i] > 0) {
                    index = Math.max(index, i);
                    if (deliveries[i] <= currentCap) {
                        currentCap -= deliveries[i];
                        dtotal -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= currentCap;
                        dstart = i;
                        dtotal -= currentCap;
                        break;
                    }
                }
            }
            currentCap = cap;
            for (int i = pstart; i >= 0; i--) {
                if (pickups[i] > 0) {
                    index = Math.max(index, i);
                    if (pickups[i] <= currentCap) {
                        currentCap -= pickups[i];
                        ptotal -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= currentCap;
                        pstart = i;
                        ptotal -= currentCap;
                        break;
                    }
                }
            }
            if (index >= 0) {
                answer += (index + 1) * 2;
            }
        }
        return answer;
    }
}
