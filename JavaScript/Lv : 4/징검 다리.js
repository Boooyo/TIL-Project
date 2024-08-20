// 이분 탐색 징검다리

function canAchieve(minDist, rocks, n) {
    let deleteCount = 0;
    let prevRock = 0;
    
    for (const rock of rocks) {
      const dist = rock - prevRock;
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
  
  function solution(distance, rocks, n) {
    let left = 1;
    let right = distance;
    
    rocks.sort((a, b) => a - b);
    rocks.push(distance);
    
    let answer = 0;
    
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (canAchieve(mid, rocks, n)) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    return answer;
  }
  