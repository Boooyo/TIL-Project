// 그래프 방의 개수

class Pair {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    // Java의 hashCode를 대신할 간단한 해시 함수
    hashCode() {
        return `${this.x},${this.y}`;
    }

    equals(other) {
        return this.x === other.x && this.y === other.y;
    }
}

function solution(arrows) {
    let cnt = 0;
    let current = new Pair(0, 0);

    const dx = [0, 1, 1, 1, 0, -1, -1, -1];
    const dy = [1, 1, 0, -1, -1, -1, 0, 1];

    const visited = new Map();
    visited.set(current.hashCode(), []);

    for (let arrow of arrows) {
        for (let i = 0; i <= 1; i++) {
            const next = new Pair(current.x + dx[arrow], current.y + dy[arrow]);
            const nextHash = next.hashCode();
            const currentHash = current.hashCode();

            if (!visited.has(nextHash)) {
                visited.set(nextHash, []);
            } else if (!visited.get(nextHash).some(pair => pair.equals(current))) {
                cnt++;
            }

            visited.get(currentHash).push(next);
            visited.get(nextHash).push(current);
            current = next;
        }
    }

    return cnt;
}
