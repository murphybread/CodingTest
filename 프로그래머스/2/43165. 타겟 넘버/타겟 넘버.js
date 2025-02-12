function solution(numbers, target) {
    var answer = 0;
    const maxDepth = numbers.length
    const operation = [+1 , -1]
    const arr = []
    
    function dfs (value, depth){
        if (depth === maxDepth ) {
            arr.push(value)
            return 
        }
        
        let originalValue = value  // 원본 value 저장
        
        // +연산
        value = originalValue + numbers[depth]*operation[0]
        dfs(value , depth+1)
        
        // - 연산
        value = originalValue + numbers[depth]*operation[1]
        dfs(value , depth+1)
    }

    // 첫 번째 숫자의 + 케이스
    dfs(numbers[0], 1)
    // 첫 번째 숫자의 - 케이스
    dfs(-numbers[0], 1)

    for (let e of arr){
        if (e === target){
            answer +=1
        }
    }
    
    return answer;
}