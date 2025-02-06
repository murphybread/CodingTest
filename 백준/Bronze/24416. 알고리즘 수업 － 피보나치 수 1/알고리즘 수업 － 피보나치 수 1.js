const input = Number(require('fs').readFileSync('/dev/stdin').toString().trim());

let fibCount = 0
let dpCount = 0

function fib(n) {
    
    if (n === 1 || n === 2)
        {    fibCount++;
            return 1;}
    return (fib(n - 1) + fib(n - 2));
}

const fibo = Array(input+1).fill(0)
fibo[1] = 1
fibo[2] = 1

function fibonacci(n) {
    
    for (let i = 3 ; i <= n; i++){
        dpCount++
        fibo[i] = fibo[i-1] + fibo[i-2]
        
    }
        
   
    return fibo[n];
}

fib(input)
fibonacci(input)
console.log(fibCount, dpCount)

