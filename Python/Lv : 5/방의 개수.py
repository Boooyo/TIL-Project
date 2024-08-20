# 그래프 방의 개수

from collections import defaultdict

def solution(arrows):
    answer = 0
    visited = defaultdict(list)
    x, y = 0, 0
    dx = [0, 1, 1, 1, 0, -1, -1, -1]
    dy = [1, 1, 0, -1, -1, -1, 0, 1]

    for arrow in arrows:
        for _ in range(2): 
            nx, ny = x + dx[arrow], y + dy[arrow]
            if (nx, ny) in visited and (x, y) not in visited[(nx, ny)]:
                answer += 1
            visited[(x, y)].append((nx, ny))
            visited[(nx, ny)].append((x, y))
            x, y = nx, ny
    return answer
