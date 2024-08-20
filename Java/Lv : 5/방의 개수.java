// 그래프 방의 개수

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
    }

    public static int solution(int[] arrows) {
        int cnt = 0;
        Pair current = new Pair(0, 0);

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        HashMap<Pair, ArrayList<Pair>> visited = new HashMap<>();
        visited.put(current, new ArrayList<>());

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) {
                Pair next = new Pair(current.x + dx[arrow], current.y + dy[arrow]);

                if (!visited.containsKey(next)) {
                    visited.put(next, new ArrayList<>());
                } else if (!visited.get(next).contains(current)) {
                    cnt++;
                }

                visited.get(current).add(next);
                visited.get(next).add(current);
                current = next;
            }
        }

        return cnt;
    }
}
