function solution(numbers, target) {
    var answer = 0;
    const maxDepth = numbers.length
    
    function dfs (depth, sum){
        // console.log(` depth ${depth} sum ${sum}`)
       if (depth === maxDepth) {
            // 합계가 타겟과 같으면 answer 증가
            if (sum === target) {
                answer++;
            }
            return;
        }
        
        
        // +연산
        dfs(depth + 1, sum + numbers[depth]);
        // -연산
        dfs(depth + 1, sum - numbers[depth]);
    }
    dfs ( 0,0)

    
    
    return answer;
}