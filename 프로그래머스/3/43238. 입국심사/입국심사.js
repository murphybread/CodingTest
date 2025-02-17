function solution(n, times) {
    
    
    let low = 1
    let high = n * Math.max(...times)
    var answer = high
    
    while (low <= high){
        
        let person = 0
        let mid = Math.floor( (low + high)/2)
        
        
        for (let t of times){
            person += Math.floor(mid/t)
        }
        
        if (person >= n){
            high = mid -1
            answer = Math.min(answer, mid);
        }        
        else {
            low = mid + 1
        }
        
        
    }
    
    return answer;
}