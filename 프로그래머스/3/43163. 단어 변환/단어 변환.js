function solution(begin, target, words) {
    // target이 words에 없으면 변환 불가
    if (!words.includes(target)) return 0;
    
    // 방문 여부를 체크할 Set
    const visited = new Set();
    
    function canChange(word1, word2) {
        let diff = 0;
        for (let i = 0; i < word1.length; i++) {
            if (word1[i] !== word2[i]) diff++;
        }
        return diff === 1;
    }
    
    function bfs(begin) {
        let queue = [[begin, 0]]; // [단어, 변환횟수]
        visited.add(begin);
        
        while (queue.length) {
            const [current, count] = queue.shift();
            
            if (current === target) return count;
            
            for (let word of words) {
                if (!visited.has(word) && canChange(current, word)) {
                    queue.push([word, count + 1]);
                    visited.add(word);
                }
            }
        }
        
        return 0;
    }
    
    return bfs(begin);
}