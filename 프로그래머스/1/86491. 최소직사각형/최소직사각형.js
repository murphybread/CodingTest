function solution(sizes) {
    var answer = 0;
    const small = []
    const big = []
    
    for (let size of sizes){
        
        big.push(Math.max(...size))
        small.push( Math.min(...size))
    }
    console.log(small, big)
    return Math.max(...big) * Math.max(...small);
}