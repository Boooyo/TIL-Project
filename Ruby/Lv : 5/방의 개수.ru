# 그래프 방의 개수

def solution(arrows)
    dx = [-1, -1, 0, 1, 1, 1, 0, -1]
    dy = [0, 1, 1, 1, 0, -1, -1, -1]
  
    node_visit = {}
    edge_visit = {}
  
    answer = 0
    x, y = 0, 0
    node_visit[[x, y]] = true
  
    arrows.each do |dir|
      2.times do
        nx = x + dx[dir]
        ny = y + dy[dir]
  
        if node_visit[[nx, ny]] && !edge_visit[[[x, y], [nx, ny]]]
          edge_visit[[[x, y], [nx, ny]]] = true
          edge_visit[[[nx, ny], [x, y]]] = true
          answer += 1
        else
          node_visit[[nx, ny]] = true
          edge_visit[[[x, y], [nx, ny]]] = true
          edge_visit[[[nx, ny], [x, y]]] = true
        end
  
        x, y = nx, ny
      end
    end
  
    answer
  end
  