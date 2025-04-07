function solution(diffs, times, limit) {
    const n = diffs.length;
    
    function getTime(i, level) {
        // 첫 번째 퍼즐은 특별히 처리
        if (i === 0) {
            if (diffs[i] <= level) {
                return times[i];
            } else {
                return (diffs[i] - level) * times[i] + times[i];
            }
        }
        
        // 일반적인 경우
        if (diffs[i] <= level) {
            return times[i];
        } else {
            return (diffs[i] - level) * (times[i-1] + times[i]) + times[i];
        }
    }
    
    function takenTime(level) {
        let partSum = 0;
        for (let i = 0; i < n; i++) {
            partSum += getTime(i, level);
            // 시간 초과 즉시 반환으로 최적화
            if (partSum > limit) {
                return partSum;
            }
        }
        return partSum;
    }
    
    let max = 1;
diffs.forEach(item => {
  if(max < item) max = item;
});
    let high = max
    let low = 1;
    
    while (low < high) {
        let mid = Math.floor((low + high) / 2);
        let part = takenTime(mid);
        
        if (part <= limit) {
            // 가능하면 더 작은 레벨 탐색
            high = mid;
        } else {
            // 불가능하면 더 큰 레벨 탐색
            low = mid + 1;
        }
    }
    
    return low;
}