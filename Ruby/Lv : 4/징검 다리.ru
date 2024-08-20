# 이분 탐색 방의 개수

def can_achieve?(min_dist, rocks, n)
    delete = 0
    prev_rock = 0
    
    rocks.each do |rock|
      dist = rock - prev_rock
      if dist < min_dist
        delete += 1
        if delete > n
          return false
        end
      else
        prev_rock = rock
      end
    end
    
    true
  end
  
  def solution(distance, rocks, n)
    left = 1
    right = distance
    
    rocks.sort!
    rocks.push(distance)
    
    while left <= right
      mid = (left + right) / 2
      if can_achieve?(mid, rocks, n)
        answer = mid
        left = mid + 1
      else
        right = mid - 1
      end
    end
    
    answer
  end
  