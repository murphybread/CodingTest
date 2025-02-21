function solution(numbers, target) {
    var answer = 0;
    const n = numbers.length
    function backtracking (depth, sum){
        if (depth > n ) return
        if (sum === target && depth === n) {
            answer +=1

        }
        
        
        backtracking (depth +1, sum + numbers[depth])
        backtracking (depth +1, sum - numbers[depth])
    }
    backtracking(0,0)
    return answer;
}